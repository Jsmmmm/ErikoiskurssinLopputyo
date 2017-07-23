package application.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OpeningWindowController {

	@FXML Button newTournament;
	@FXML Button openTournament;
	MainController main;
	
	@FXML
	private void initialize(){
		
	}
	
	@FXML
	private void closeWindow(ActionEvent e){
		 Stage stage = (Stage) newTournament.getScene().getWindow();		   
		 stage.close();
	}
	
	@FXML
	private void newTournamentPressed(ActionEvent e){		
		main.toolbarController.newCompetition(e);	 			 
		closeWindow(e);
	}
	
	@FXML
	private void openTournamentPressed(ActionEvent e){		
		closeWindow(e);		
		main.toolbarController.openCompetition(e);		
	}
	
	protected void init(MainController main){
		this.main=main;
	}	
	
}
