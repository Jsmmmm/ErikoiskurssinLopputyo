package application.model;

public class Participant {

	Competitor competitor;
	Result result;
	//double resultPoints[];
	
	
	public Participant(Competitor competitor){
		this.competitor=competitor;
	}
	
	
	
	@Override
	public String toString(){
		
		if(this.result==null){
			return this.competitor.toString();
		}else
			return this.competitor.toString()+" "+result.getResult();	//abstraktin luokan result ansiosta getResult voidaan muokata sopivan näköseks formaatist riippuen
	}
}
