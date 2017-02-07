package application.model;


public class Participant{

	Competitor competitor;
	private Double[] results;	//toistaiseksi Double - vaihda Result[]
	
	
	public Participant(Competitor competitor, int numberOfResults){
		this.competitor=competitor;
		results=new Double[numberOfResults];
	}
		
	
	
	
	@Override
	public String toString(){

		return this.competitor.toString();
	}
	
	public void setResult(Double result, int numberOfResult){
		results[numberOfResult-1]=result;
	}
	
	public Double getResult(int numberOfResult){
		return results[numberOfResult-1];
	}
	
	public boolean resultIsSet(int numberOfResult){
		
		if(results.length>=numberOfResult && results[numberOfResult-1]!=null){
			return true;
		}
		return false;
	}
	
}
