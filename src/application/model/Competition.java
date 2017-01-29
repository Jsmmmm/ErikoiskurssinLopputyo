package application.model;

import java.util.ArrayList;

public class Competition {
	
	String name;
	public ArrayList<Competitor> competitors = new ArrayList<Competitor>();
	public ArrayList<Person> persons = new ArrayList<Person>();
	public ArrayList<Team> teams = new ArrayList<Team>();
	public ArrayList<Sport> sports = new ArrayList<Sport>(); 
	
	
	public Competition(){
		
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	
}
