package application.controllers;



import application.model.Person;
import application.model.Team;
import application.model.Competitor;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;

public class PersonTabController{
 
	Tab tab;
	MainController main;
	@FXML ToggleGroup group;
	@FXML Label firstName;
	@FXML Label lastName;
	@FXML Label age;
	@FXML RadioButton men;
	@FXML RadioButton women;
	
	@FXML Button save;
	@FXML Button clear;
	@FXML Button delete;
	
	
	
	public void openPersonInformation(Person henkilo){
		firstName.setText(henkilo.getFirstName());
		lastName.setText(henkilo.getLastName());
		age.setText(Integer.toString(henkilo.getAge()));
		if(henkilo.getGender().equals("Mies")){
			men.setSelected(true);
		}else women.setSelected(true);
	}
	
	/*@FXML
	public void initialize() {
		
	}*/
	
	public void init(MainController mainController, Tab tab){
		main=mainController;
		this.tab = tab;
	}
	
	
	@FXML
	public void delete(ActionEvent e){
		main.treeViewViewController.delete(e);		
		main.tabPane.getTabs().remove(tab);
	}
	
	
}
