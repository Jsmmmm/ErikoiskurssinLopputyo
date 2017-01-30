package application.model;


public class Competitor extends Person{

	
	int competitorNumber;
	private static int nextNumber=1;
	
	public Competitor(String firstName, String lastName, int age, Boolean isMale){
		super(firstName, lastName, age,isMale);		
		competitorNumber=nextNumber;
		sumNextNumberByOne();
	}
		
	private void sumNextNumberByOne(){
		nextNumber++;
	}
	
	
	
}