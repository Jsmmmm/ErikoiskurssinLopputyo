package application.controllers;

import application.model.Participant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SetResultsController {
	
	Participant participant;
	int amountOfResults;
	
    @FXML
    private TextField result1;

    @FXML
    private TextField result2;

    @FXML
    private TextField result3;

    @FXML
    private TextField result4;

    @FXML
    private TextField result5;

    @FXML
    private TextField result6;

    @FXML
    private TextField result7;

    @FXML
    private TextField result8;

    @FXML
    private TextField result9;

    @FXML
    private TextField result10;

    @FXML
    private Button save;

    @FXML
    private Button cancel;
    
    @FXML
    private Label result01;
    @FXML
    private Label result02;
    @FXML
    private Label result03;
    @FXML
    private Label result04;
    @FXML
    private Label result05;
    @FXML
    private Label result06;
    @FXML
    private Label result07;
    @FXML
    private Label result08;
    @FXML
    private Label result09;
    @FXML
    private Label result010;
    
    
    private void setExistingResultsToTextfields(){    	

    	if(participant.resultIsSet(1)){
    		result1.setText(participant.getResult(1).toString());
    	}
    	if(participant.resultIsSet(2)){
    		result2.setText(participant.getResult(2).toString());
    	}
    	if(participant.resultIsSet(3)){
    		result3.setText(participant.getResult(3).toString());
    	}
    	if(participant.resultIsSet(4)){
    		result4.setText(participant.getResult(4).toString());
    	}
    	if(participant.resultIsSet(5)){
    		result5.setText(participant.getResult(5).toString());
    	}
    	if(participant.resultIsSet(6)){
    		result6.setText(participant.getResult(6).toString());
    	}
    	if(participant.resultIsSet(7)){
    		result7.setText(participant.getResult(7).toString());
    	}
    	if(participant.resultIsSet(8)){
    		result8.setText(participant.getResult(8).toString());
    	}
    	if(participant.resultIsSet(9)){
    		result9.setText(participant.getResult(9).toString());
    	}
    	if(participant.resultIsSet(10)){
    		result10.setText(participant.getResult(10).toString());
    	}
    }
    
    public void save(ActionEvent e){
    	
    	if(result1.isVisible()){
    		Double firstResult=null;
    		try{
    			firstResult = Double.parseDouble( result1.getText());
    		}
    		catch(NumberFormatException x){
    			System.out.println(x.getMessage());
    		}
    		participant.setResult(firstResult,1);		//pitää siirtää nää kutsut loppuun, aiheuttaa nyt errorin jos invalid input
    		
    	}
    	
    	if(result2.isVisible()){
    		Double secondResult=null;
    		try{
    			secondResult = Double.parseDouble( result2.getText());
    		}
    		catch(NumberFormatException x){
    			System.out.println(x.getMessage());
    		}
    		participant.setResult(secondResult,2);
    	}
    	
    	if(result3.isVisible()){
    		Double thirdResult=null;
    		try{
    			thirdResult = Double.parseDouble( result3.getText());
    		}
    		catch(NumberFormatException x){
    			System.out.println(x.getMessage());
    		}
    		participant.setResult(thirdResult,3);
    	}
    	
    	if(result4.isVisible()){
    		Double fourthResult=null;
    		try{
    			fourthResult = Double.parseDouble( result4.getText());
    		}
    		catch(NumberFormatException x){
    			System.out.println(x.getMessage());
    		}
    		participant.setResult(fourthResult,4);
    	}
    	
    	if(result5.isVisible()){
    		Double fifthResult=null;
    		try{
    			fifthResult = Double.parseDouble( result5.getText());
    		}
    		catch(NumberFormatException x){
    			System.out.println(x.getMessage());
    		}
    		participant.setResult(fifthResult,5);
    	}
    	
    	if(result6.isVisible()){
    		Double sixthResult=null;
    		try{
    			sixthResult = Double.parseDouble( result6.getText());
    		}
    		catch(NumberFormatException x){
    			System.out.println(x.getMessage());
    		}
    		participant.setResult(sixthResult,6);
    	}
    	
    	if(result7.isVisible()){
    		Double seventhResult=null;
    		try{
    			seventhResult = Double.parseDouble( result7.getText());
    		}
    		catch(NumberFormatException x){
    			System.out.println(x.getMessage());
    		}
    		participant.setResult(seventhResult,7);
    	}
    	
    	if(result8.isVisible()){
    		Double eighthResult=null;
    		try{
    			eighthResult = Double.parseDouble( result8.getText());
    		}
    		catch(NumberFormatException x){
    			System.out.println(x.getMessage());
    		}
    		participant.setResult(eighthResult,8);
    	}
    	
    	if(result9.isVisible()){
    		Double ninthResult=null;
    		try{
    			ninthResult = Double.parseDouble( result9.getText());
    		}
    		catch(NumberFormatException x){
    			System.out.println(x.getMessage());
    		}
    		participant.setResult(ninthResult,9);
    	}
    	
    	if(result10.isVisible()){
    		Double tenthResult=null;
    		try{
    			tenthResult = Double.parseDouble( result10.getText());
    		}
    		catch(NumberFormatException x){
    			System.out.println(x.getMessage());
    		}
    		participant.setResult(tenthResult,10);
    	}
    	 Stage stage = (Stage) save.getScene().getWindow(); 
		 stage.close();
    }
    
    
    
    public void init(Participant participant, int amountOfResults){
    	this.participant=participant;
    	this.amountOfResults=amountOfResults;
    	hideOtherTextfields();
    	setExistingResultsToTextfields();
    }
    
    
    private void hideOtherTextfields(){
    	
    	if(amountOfResults>=1){
    		result01.setVisible(true);
    		result1.setVisible(true);
    		
    	}
    	if(amountOfResults>=2){
    		result02.setVisible(true);
    		result2.setVisible(true);
    		
    	}
    	if(amountOfResults>=3){
    		result03.setVisible(true);
    		result3.setVisible(true);
    		
    	}
    	if(amountOfResults>=4){
    		result04.setVisible(true);
    		result4.setVisible(true);
    		
    	}
    	if(amountOfResults>=5){
    		result05.setVisible(true);
    		result5.setVisible(true);
    		
    	}
    	if(amountOfResults>=6){
    		result06.setVisible(true);
    		result6.setVisible(true);
    		
    	}
    	if(amountOfResults>=7){
    		result07.setVisible(true);
    		result7.setVisible(true);
    		
    	}
    	if(amountOfResults>=8){
    		result08.setVisible(true);
    		result8.setVisible(true);
    		
    	}
    	if(amountOfResults>=9){
    		result09.setVisible(true);
    		result9.setVisible(true);
    	
    	}
    	if(amountOfResults>=10){
    		result010.setVisible(true);
    		result10.setVisible(true);
    		
    	}
    }
    
    @FXML
    private void initialize(){
    	
    	result1.setVisible(false);
    	result2.setVisible(false);
    	result3.setVisible(false);
    	result4.setVisible(false);
    	result5.setVisible(false);
    	result6.setVisible(false);
    	result7.setVisible(false);
    	result8.setVisible(false);
    	result9.setVisible(false);
    	result10.setVisible(false);
    	
    	result01.setVisible(false);
    	result02.setVisible(false);
    	result03.setVisible(false);
    	result04.setVisible(false);
    	result05.setVisible(false);
    	result06.setVisible(false);
    	result07.setVisible(false);
    	result08.setVisible(false);
    	result09.setVisible(false);
    	result010.setVisible(false);
    	
    }
    
    @FXML
	public void closeWindow(ActionEvent e){
		 Stage stage = (Stage) cancel.getScene().getWindow(); 
		 stage.close();
	}
	
    
}
