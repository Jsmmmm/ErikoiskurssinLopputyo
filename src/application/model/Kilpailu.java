package application.model;

import java.util.ArrayList;

public class Kilpailu {
	
	String nimi;
	public ArrayList<Kilpailija> kilpailijat = new ArrayList<Kilpailija>();
	public ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();
	public ArrayList<Joukkue> joukkueet = new ArrayList<Joukkue>();
	public ArrayList<Laji> lajit = new ArrayList<Laji>(); 
	
	
	public Kilpailu(){
		
	}
	
	public void setNimi(String nimi){
		this.nimi=nimi;
	}
	
	public String getNimi(){
		return nimi;
	}
	
	
}
