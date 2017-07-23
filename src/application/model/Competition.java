package application.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Competition implements Serializable{
	
	String name;
	public ArrayList<Competitor> competitors;
	public ArrayList<Person> persons;
	public ArrayList<Team> teams;
	public ArrayList<Sport> sports;
	
	public int numberOfCompetitors;
	public int men;
	public int women;
	public int menU18;
	public int womenU18;
	public int numberOfSports;
	public int numberOfSeries;
	public int numberOfTeams;
	
	private Competition(String name){
		this.name = name;
		competitors = new ArrayList<Competitor>(); 
		persons = new ArrayList<Person>(); 
		teams = new ArrayList<Team>();
		sports = new ArrayList<Sport>(); 
	}
	
	public static Competition newCompetition(String name){
		Competition competition = new Competition(name);		
		return competition;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	//taitaa olla muuttunu turhaks metodiks
	public int countCompetitors(){
		return competitors.size();
	}		
	
}
