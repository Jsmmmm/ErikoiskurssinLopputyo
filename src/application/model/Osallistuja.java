package application.model;

public class Osallistuja {

	Kilpailija kilpailija;
	int tulosPisteet;
	
	public Osallistuja(Kilpailija kilpailija){
		this.kilpailija=kilpailija;
	}
	
	public void asetaPisteet(int pisteet){
		this.tulosPisteet=pisteet;
	}
	
	public int kerroPisteet(){
		return this.tulosPisteet;
	}
	
	@Override
	public String toString(){
		return this.kilpailija.toString();
	}
}
