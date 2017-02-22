package application.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Competition implements Serializable{
	
	String name;
	public ArrayList<Competitor> competitors;
	public ArrayList<Person> persons;
	public ArrayList<Team> teams;
	public ArrayList<Sport> sports;
	
	
	public Competition(){
		competitors = new ArrayList<Competitor>(); 
		persons = new ArrayList<Person>(); 
		teams = new ArrayList<Team>();
		sports = new ArrayList<Sport>(); 
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	
}
