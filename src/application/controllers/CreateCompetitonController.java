package application.controllers;

import application.model.Competition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateCompetitonController {

	@FXML TextField name;
	@FXML Button save;
	@FXML Button cancel;
	MainController main;
	
	public void init(MainController main){
		this.main=main;
	}
	
	@FXML
	private void createNewTournament(){
		Competition tournament = new Competition();
		tournament.setName(name.getText());
		main.lataaKilpailu(tournament);	
		
		Stage stage = (Stage) save.getScene().getWindow();
	    stage.close();
	}
}
