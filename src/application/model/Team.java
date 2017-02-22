package application.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Team implements Serializable{
	
	String teamName;
	ArrayList<Person> teamMembers;
	
	public Team(String joukkueenNimi){
		this.teamName=joukkueenNimi;
		teamMembers = new ArrayList<Person>();		
	}
	
	@Override
	public String toString(){
		return this.teamName;
	}
		
}
