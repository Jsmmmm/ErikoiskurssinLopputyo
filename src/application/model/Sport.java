package application.model;

import java.util.ArrayList;


public class Sport {

	String lajinNimi;
	
	public ArrayList<Osallistuja> lajinOsallistujat = new ArrayList<Osallistuja>();
	
	public Serie yleisSarja; 
	public Serie miestenYleisSarja;
	public Serie miestenU18Sarja;
	public Serie naistenYleisSarja;
	public Serie naistenU18Sarja;
	public boolean booleanYleisSarja=false;
	public boolean booleanMiestenSarja=false;
	public boolean booleanNaistenSarja=false;
	public boolean booleanMiestenU18=false;
	public boolean booleanNaistenU18=false;
	 
	public Sport(String lajinNimi, boolean booleanYleisSarja, boolean booleanMiestenYleisSarja,  boolean booleanNaistenYleisSarja, boolean booleanMiestenU18Sarja, boolean booleanNaistenU18Sarja){
		this.lajinNimi=lajinNimi;
		this.booleanYleisSarja=booleanYleisSarja;
		this.booleanMiestenSarja=booleanMiestenYleisSarja;
		this.booleanNaistenSarja=booleanNaistenYleisSarja;
		this.booleanMiestenU18=booleanMiestenU18Sarja;
		this.booleanNaistenU18=booleanNaistenU18Sarja;
		
		if(booleanYleisSarja==true){
			yleisSarja=new Serie("Yleissarja");
		}
		if(booleanMiestenSarja==true){
			miestenYleisSarja=new Serie("Miesten sarja");
		}
		if(booleanMiestenU18==true){
			miestenU18Sarja=new Serie("Miesten sarja U18");
		}
		if(booleanNaistenSarja==true){
			naistenYleisSarja=new Serie("Naisten sarja");
		}
		if(booleanNaistenU18==true){
			naistenU18Sarja=new Serie("Naisten sarja U18");
		}						
	}
	
	
	private void lisaaOsallistujaSarjaan(Osallistuja osallistuja, Serie sarja){
		if(sarja.sarjanOsallistujat.contains(osallistuja)){
			System.out.println(osallistuja.kilpailija.toString()+" löytyi jo valmiiksi lajista");
		} else{
			sarja.sarjanOsallistujat.add(osallistuja); }
	}
	
	
	public void sijoitaOsallistujatSarjoihin(){
		
		for(Osallistuja osallistuja : lajinOsallistujat){
			
			if(booleanYleisSarja){
				lisaaOsallistujaSarjaan(osallistuja, yleisSarja);
				//yleisSarja.sarjanOsallistujat.add(osallistuja);
				
			}
			

			//miesten osallistuminen
			if(osallistuja.kilpailija.kerroSukupuoli().equals("Mies")){								
				
				if(booleanMiestenU18 && osallistuja.kilpailija.kerroIka()<18){
					lisaaOsallistujaSarjaan(osallistuja, miestenU18Sarja);
				//	miestenU18Sarja.sarjanOsallistujat.add(osallistuja);
					
				}else if(!booleanMiestenU18 && booleanMiestenSarja){
					lisaaOsallistujaSarjaan(osallistuja, miestenYleisSarja);
					//miestenYleisSarja.sarjanOsallistujat.add(osallistuja);
					
				}else if(booleanMiestenU18 && booleanMiestenSarja && osallistuja.kilpailija.kerroIka()>=18){
					lisaaOsallistujaSarjaan(osallistuja, miestenYleisSarja);
					//miestenYleisSarja.sarjanOsallistujat.add(osallistuja);
					
				}
				
			//naisten osallistuminen
			}else{
				if(booleanNaistenU18 && osallistuja.kilpailija.kerroIka()<18){
					lisaaOsallistujaSarjaan(osallistuja, naistenU18Sarja);
					//naistenU18Sarja.sarjanOsallistujat.add(osallistuja);
					
				}else if(booleanNaistenU18==false && booleanNaistenSarja){
					lisaaOsallistujaSarjaan(osallistuja, naistenYleisSarja);
					//naistenYleisSarja.sarjanOsallistujat.add(osallistuja);
					
				}else if(booleanNaistenU18 && booleanNaistenSarja && osallistuja.kilpailija.kerroIka()>=18){
					lisaaOsallistujaSarjaan(osallistuja, naistenYleisSarja);
					//naistenYleisSarja.sarjanOsallistujat.add(osallistuja);
					 }								
			}						
		}
		lajinOsallistujat.clear();
		
		
	}
	
	
	
	@Override
	public String toString(){
		return this.lajinNimi;
	}

}
