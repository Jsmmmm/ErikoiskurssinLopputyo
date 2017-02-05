package application.controllers;

import application.model.Participant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    
    
    private void save(ActionEvent e){
    	
    }
    
    public void init(Participant participant, int amountOfResults){
    	this.participant=participant;
    	this.amountOfResults=amountOfResults;
    	hideOtherTextfields();
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
    
}
