package application.controllers;



import application.model.Competition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewCompetitionController {

	@FXML TextField name;
	@FXML Button save;
	@FXML Button cancel;
	MainController main;
	
	public void init(MainController main){
		this.main=main;
	}
	
	
	@FXML
	private void createNewTournament(ActionEvent e){
		
		if(!name.getText().isEmpty()){
			Competition competition = new Competition();
			competition.setName(name.getText());
			main.setCompetition(competition);	
			closeWindow(e);	
		}
				
	}
	
	@FXML
	private void closeWindow(ActionEvent e){
		Stage stage = (Stage) cancel.getScene().getWindow();
	    stage.close();
	}
	
}
