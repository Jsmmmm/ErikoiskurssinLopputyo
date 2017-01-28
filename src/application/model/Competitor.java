package application.model;


public class Competitor extends Person{

	
	int kilpailijaNro;
	private static int seuraavaNro=1;
	
	public Competitor(String etuNimi, String sukuNimi, int ika, String sp){
		super(etuNimi, sukuNimi, ika, sp);		
		kilpailijaNro=seuraavaNro;
		kasvataSeuraavaNro();
	}
		
	private void kasvataSeuraavaNro(){
		seuraavaNro++;
	}
	
	
	
}