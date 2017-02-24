package application.controllers;

import application.model.Person;
import application.model.Competitor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class NewPersonController {

	MainController main;
	
	@FXML ToggleGroup group;
	@FXML TextField firstName;
	@FXML TextField lastName;
	@FXML TextField age;
	@FXML RadioButton Man;
	@FXML RadioButton Female;
	@FXML Circle ball1;
	@FXML Circle ball2;
	@FXML Circle ball3;
	@FXML Button save;
	@FXML Button clear;
	@FXML Button cancel;
	
	public void init(MainController mainController){
		main=mainController;
	}
	
	public Competitor createPerson(){
		
		boolean x=false;
		boolean y=false;
		boolean z=false;
		
		ball1.setVisible(false);
		ball2.setVisible(false);
		ball3.setVisible(false);
		
		//Person henkilo=null;
		Competitor competitor=null;
		if(Person.checkName(firstName.getText())){
			x=true;
		}else{
			ball1.setVisible(true);
		}
		if(Person.checkName(lastName.getText())){
			y=true;
		}else{
			ball2.setVisible(true);
		}
		
		int personsAge=0;
		
		try{
			personsAge=Integer.parseInt(age.getText());
			z=true; 			
		}catch(NumberFormatException ee){			
			ball3.setVisible(true);			
		}
		
		
		boolean isMale;
		
		if(Man.isSelected()){
			
			isMale=true;
			
		}else 
		isMale=false;
		
		if(x==true && y==true && z==true){
			
			competitor = new Competitor(firstName.getText(), lastName.getText(), personsAge, isMale);
			
			System.out.println(competitor.toString()); //testi
			
			
			
		}//clearTextfields();
		return competitor;
				
	}


	public void clearTextfields(){		
		firstName.clear();
		lastName.clear();
		age.clear();
		ball1.setVisible(false);
		ball2.setVisible(false);
		ball3.setVisible(false);
		firstName.setPromptText("First Name");
		lastName.setPromptText("Last Name");
		age.setPromptText("Age");
	}
	
	@FXML
	public void saveButtonPressed(ActionEvent e){
		
		Competitor kilpailija=createPerson();
		
		if(kilpailija!=null){
			main.competition.competitors.add(kilpailija);				
			main.treeViewViewController.addCompetitorToTW(kilpailija);
			main.personCounter(kilpailija, true);
			closeWindow(e);
		}		
	}
	
	@FXML
	public void clearButtonPressed(ActionEvent e){	
		clearTextfields();		
	}
	
	@FXML
	public void closeWindow(ActionEvent e){
		 Stage stage = (Stage) cancel.getScene().getWindow();		   
		 stage.close();
	}
	
	
	
	@FXML
	private void initialize(){
		
		ball1.setVisible(false);
		ball2.setVisible(false);
		ball3.setVisible(false);
	}
	
}
