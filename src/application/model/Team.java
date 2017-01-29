package application.model;

import java.util.ArrayList;

public class Team{
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
