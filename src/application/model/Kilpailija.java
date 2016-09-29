package application.model;


public class Kilpailija extends Henkilo{

	
	int kilpailijaNro;
	private static int seuraavaNro=1;
	
	public Kilpailija(String etuNimi, String sukuNimi, int ika, String sp){
		super(etuNimi, sukuNimi, ika, sp);		
		kilpailijaNro=seuraavaNro;
		kasvataSeuraavaNro();
	}
		
	private void kasvataSeuraavaNro(){
		seuraavaNro++;
	}
	
	
	
}