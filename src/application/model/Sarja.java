package application.model;

import java.util.ArrayList;

public class Sarja {

	Sarja(String sarjanNimi){
		this.sarjanNimi=sarjanNimi;
	}
	
	String sarjanNimi;
	public ArrayList<Osallistuja> sarjanOsallistujat=new ArrayList<Osallistuja>();
	
	@Override
	public String toString(){
		return sarjanNimi;
	}
	
}
