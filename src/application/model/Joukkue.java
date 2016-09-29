package application.model;

import java.util.ArrayList;

public class Joukkue{
	String joukkueenNimi;
	ArrayList<Henkilo> joukkueenPelaajat;
	
	public Joukkue(String joukkueenNimi){
		this.joukkueenNimi=joukkueenNimi;
		joukkueenPelaajat = new ArrayList<Henkilo>();		
	}
	
	@Override
	public String toString(){
		return this.joukkueenNimi;
	}
	
	
}
