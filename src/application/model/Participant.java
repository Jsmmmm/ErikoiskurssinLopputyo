package application.model;

public class Participant {

	Competitor competitor;
	int resultPoints;
	//double resultPoints[];
	
	
	public Participant(Competitor competitor){
		this.competitor=competitor;
	}
	
	public void asetaPisteet(int points){
		this.resultPoints=points;
	}
	
	public int getPoints(){
		return this.resultPoints;
	}
	
	@Override
	public String toString(){
		return this.competitor.toString();
	}
}
