package application.controllers;

import application.model.Competition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateCompetitonController {

	@FXML TextField tekstiKentta;
	@FXML Button tallenna;
	@FXML Button peruuta;
	MainController main;
	
	public void init(MainController main){
		this.main=main;
	}
	
	@FXML
	private void luoUusiKilpailu(){
		Competition kilpailu = new Competition();
		kilpailu.setNimi(tekstiKentta.getText());
		main.lataaKilpailu(kilpailu);	
		
		Stage stage = (Stage) tallenna.getScene().getWindow();
	    stage.close();
	}
}
