package application.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainTabController {

	MainController main;
	
	@FXML Button uusiKilpailija;
	@FXML Button muokkaaKilpailija;
	@FXML Button poistaKilpailija;
	
	@FXML Button uusiJoukkue;
	@FXML Button muokkaaJoukkue;
	@FXML Button poistaJoukkue;
	
	@FXML Button uusiLaji;
	@FXML Button muokkaaLaji;
	@FXML Button poistaLaji;
	
	@FXML Label kilpailijoita;
	@FXML Label miehia;
	@FXML Label naisia;
	@FXML Label miehiaU18;
	@FXML Label naisiaU18;
	@FXML Label joukkueita;
	@FXML Label lajeja;
	@FXML Label sarjoja;
	/*@FXML
	public void initialize(){
		
	}*/
	
	public void init(MainController mainController){
		main=mainController;
		
	}
	
	
	

	@FXML
	public void uusiKilpailijaButton(ActionEvent e){
		try{
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/NewPerson.fxml" ));
			 Stage stage = new Stage();		 
			 stage.setScene(new Scene(loader.load()));
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
	public void uusiLajiButton(ActionEvent e){
		try{
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/NewSport.fxml" ));
			 Stage stage = new Stage();		 
			 stage.setScene(new Scene(loader.load()));
			 stage.setTitle("Uusi Laji");
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
	public void uusiJoukkueButton(ActionEvent e){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/NewTeam.fxml" ));
			Stage stage = new Stage();		 
			stage.setScene(new Scene(loader.load()));
			stage.setTitle("Uusi Joukkue");
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
