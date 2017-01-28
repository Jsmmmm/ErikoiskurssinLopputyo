package application.model;

public class Osallistuja {

	Competitor kilpailija;
	int tulosPisteet;
	
	public Osallistuja(Competitor kilpailija){
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
