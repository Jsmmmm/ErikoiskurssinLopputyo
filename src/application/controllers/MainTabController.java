package application.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainTabController {

	MainController main;
	
	@FXML Button newPerson;
	@FXML Button editPerson;
	@FXML Button deletePerson;
	
	@FXML Button newTeam;
	@FXML Button editTeam;
	@FXML Button deleteTeam;
	
	@FXML Button newSport;
	@FXML Button editSport;
	@FXML Button deleteSport;
	
	@FXML Label competitors;
	@FXML Label men;
	@FXML Label women;	
	@FXML Label menU18;
	@FXML Label womenU18;
	@FXML Label teams;
	@FXML Label sports;
	@FXML Label series;
	/*@FXML
	public void initialize(){
		
	}*/
	
	public void init(MainController mainController){
		main=mainController;
		
	}
	
	
	

	@FXML
	public void newPerson(ActionEvent e){
		try{
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/NewPerson.fxml" ));
			 Stage stage = new Stage();		 
			 stage.setScene(new Scene((Parent) loader.load()));
			 stage.setTitle("New Person");
			 NewPersonController controller = loader.<NewPersonController>getController();
			 controller.init(main);
			 stage.show();
			// return stage; //viittaus avautuneeseen ikkunaan jos halutaan my�hemmin p��st� siihen k�siksi t�st� luokasta
		}
		catch(Exception i){
			i.printStackTrace();
		}
	}
	
	@FXML
	public void newSport(ActionEvent e){
		try{
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/NewSport.fxml" ));
			 Stage stage = new Stage();		 
			 stage.setScene(new Scene((Parent) loader.load()));
			 stage.setTitle("New Sport");
			 NewSportController controller = loader.<NewSportController>getController();
			 controller.init(main);
			 stage.show();
			 //return stage; //viittaus avautuneeseen ikkunaan jos halutaan my�hemmin p��st� siihen k�siksi t�st� luokasta
		}
		catch(Exception i){
			i.printStackTrace();
		}
	}
	
	@FXML
	public void newTeam(ActionEvent e){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/NewTeam.fxml" ));
			Stage stage = new Stage();		 
			stage.setScene(new Scene((Parent) loader.load()));
			stage.setTitle("New Team");
			NewTeamController controller = loader.<NewTeamController>getController();
			controller.init(main);
			stage.show();
			//return stage; //viittaus avautuneeseen ikkunaan jos halutaan my�hemmin p��st� siihen k�siksi t�st� luokasta			
		}
		catch(Exception i){
			i.printStackTrace();
		}
	}
	
	
}
