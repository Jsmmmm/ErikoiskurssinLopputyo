package application.model;

import java.util.ArrayList;

public class Team{
	String joukkueenNimi;
	ArrayList<Person> joukkueenPelaajat;
	
	public Team(String joukkueenNimi){
		this.joukkueenNimi=joukkueenNimi;
		joukkueenPelaajat = new ArrayList<Person>();		
	}
	
	@Override
	public String toString(){
		return this.joukkueenNimi;
	}
	
	
}
