package application.model;

import java.util.ArrayList;


public class Laji {

	String lajinNimi;
	
	public ArrayList<Osallistuja> lajinOsallistujat = new ArrayList<Osallistuja>();
	
	public Sarja yleisSarja; 
	public Sarja miestenYleisSarja;
	public Sarja miestenU18Sarja;
	public Sarja naistenYleisSarja;
	public Sarja naistenU18Sarja;
	public boolean booleanYleisSarja=false;
	public boolean booleanMiestenSarja=false;
	public boolean booleanNaistenSarja=false;
	public boolean booleanMiestenU18=false;
	public boolean booleanNaistenU18=false;
	 
	public Laji(String lajinNimi, boolean booleanYleisSarja, boolean booleanMiestenYleisSarja,  boolean booleanNaistenYleisSarja, boolean booleanMiestenU18Sarja, boolean booleanNaistenU18Sarja){
		this.lajinNimi=lajinNimi;
		this.booleanYleisSarja=booleanYleisSarja;
		this.booleanMiestenSarja=booleanMiestenYleisSarja;
		this.booleanNaistenSarja=booleanNaistenYleisSarja;
		this.booleanMiestenU18=booleanMiestenU18Sarja;
		this.booleanNaistenU18=booleanNaistenU18Sarja;
		
		if(booleanYleisSarja==true){
			yleisSarja=new Sarja("Yleissarja");
		}
		if(booleanMiestenSarja==true){
			miestenYleisSarja=new Sarja("Miesten sarja");
		}
		if(booleanMiestenU18==true){
			miestenU18Sarja=new Sarja("Miesten sarja U18");
		}
		if(booleanNaistenSarja==true){
			naistenYleisSarja=new Sarja("Naisten sarja");
		}
		if(booleanNaistenU18==true){
			naistenU18Sarja=new Sarja("Naisten sarja U18");
		}						
	}
	
	
	private void lisaaOsallistujaSarjaan(Osallistuja osallistuja, Sarja sarja){
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
