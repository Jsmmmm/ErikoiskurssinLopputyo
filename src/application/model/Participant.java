package application.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



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
	
	public Double getHighestOfResults(){
		
		// Double max = Arrays.stream(results).max(Double::compareTo).get();
		// return max;
		  List<Double> list = new ArrayList<Double>();
		  for (int i = 0; i < results.length; i++) {
		    list.add(results[i]);
		  }
		 return Collections.max(list);
	}
	
	public Double getLowestOfResults(){
		
		 Double min = Arrays.stream(results).min(Double::compareTo).get();
		 return min;
	}
	
	public Double getAverageOfResults(){
		
		double sum=0; 
		
		for(int i=0; i<results.length; i++){
			sum=+results[i];
		}
		return sum/results.length;
	}
	
	public Double getSumOfResults(){
		
		double sum=0;
		for(int i=0; i<results.length; i++){
			sum=+results[i];
		}
		return sum;		
	}
}
