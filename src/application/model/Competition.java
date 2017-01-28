package application.model;

import java.util.ArrayList;

public class Competition {
	
	String nimi;
	public ArrayList<Competitor> kilpailijat = new ArrayList<Competitor>();
	public ArrayList<Person> henkilot = new ArrayList<Person>();
	public ArrayList<Team> joukkueet = new ArrayList<Team>();
	public ArrayList<Sport> lajit = new ArrayList<Sport>(); 
	
	
	public Competition(){
		
	}
	
	public void setNimi(String nimi){
		this.nimi=nimi;
	}
	
	public String getNimi(){
		return nimi;
	}
	
	
}
