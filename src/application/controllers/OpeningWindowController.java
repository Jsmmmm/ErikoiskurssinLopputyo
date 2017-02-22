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
		try{
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/NewCompetition.fxml" ));
			 Stage stage = new Stage();		 
			 stage.setScene(new Scene((Parent) loader.load()));
			 stage.setTitle("New Tournament");
			 NewCompetitionController controller = loader.<NewCompetitionController>getController();
			 controller.init(main);
			 stage.show();
			// return stage; //viittaus avautuneeseen ikkunaan jos halutaan my�hemmin p��st� siihen k�siksi t�st� luokasta
			 			 
			 closeWindow(e);
		}
		catch(Exception i){
			i.printStackTrace();
		}
	}
	

	@FXML
	public void initialize(){
		
	}
	
	@FXML
	public void openTournamentPressed(ActionEvent e){
		
		closeWindow(e);
		main.menuAndToolbarController.openCompetition(e);

	}
	
	
	public void init(MainController main){
		this.main=main;
	}
	
	
}
