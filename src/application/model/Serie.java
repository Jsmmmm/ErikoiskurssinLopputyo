package application.model;

import java.util.ArrayList;
import java.util.Collections;

import application.model.Sport.ResultFormation;//vie enumit omaan luokkaansa


public class Serie {

	Serie(String name){
		this.serieName=name;
	}
	
	String serieName;
	public ArrayList<Participant> serieParticipants=new ArrayList<Participant>();
	public ArrayList<Participant> sortedParticipants = new ArrayList<Participant>();	//participants sorted in result order
	
	@Override
	public String toString(){
		return serieName;
	}
	
	
	public void sortParticipantsByResult(ResultFormation resultFormation){
		
		sortedParticipants=(ArrayList<Participant>)serieParticipants.clone();
		
		if(resultFormation==ResultFormation.BEST){						
			sortedParticipants.sort((o1, o2) -> o2.getHighestOfResults().compareTo(o1.getHighestOfResults()));	
			
		}else if(resultFormation==ResultFormation.SUM){						
			sortedParticipants.sort((o1, o2) -> o2.getSumOfResults().compareTo(o1.getSumOfResults()));	
			
		}else if(resultFormation==ResultFormation.AVERAGE){						
			sortedParticipants.sort((o1, o2) -> o2.getAverageOfResults().compareTo(o1.getAverageOfResults()));			
		}
	}
	
}
