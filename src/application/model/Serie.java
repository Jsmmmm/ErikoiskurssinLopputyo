package application.model;

import java.util.ArrayList;

public class Serie {

	Serie(String name){
		this.serieName=name;
	}
	
	String serieName;
	public ArrayList<Participant> serieParticipants=new ArrayList<Participant>();
	
	@Override
	public String toString(){
		return serieName;
	}
	
}
