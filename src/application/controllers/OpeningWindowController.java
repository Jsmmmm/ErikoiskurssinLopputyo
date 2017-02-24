package application.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OpeningWindowController {

	@FXML Button newTournament;
	@FXML Button openTournament;
	MainController main;
	
	@FXML
	public void closeWindow(ActionEvent e){
		 Stage stage = (Stage) newTournament.getScene().getWindow();		   
		 stage.close();
	}
	
	@FXML
	public void newTournamentPressed(ActionEvent e){
		
		main.toolbarController.newCompetition(e);	 			 
		closeWindow(e);

	}
	

	@FXML
	public void initialize(){
		
	}
	
	@FXML
	public void openTournamentPressed(ActionEvent e){
		
		closeWindow(e);		
		main.toolbarController.openCompetition(e);
		
	}
	
	
	public void init(MainController main){
		this.main=main;
	}
	
	
}
