package application.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import application.model.Competition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MenuAndToolbarController {

	MainController main;
	
	Image newFile = new Image(getClass().getResourceAsStream("/application/Icons/Toolbar_icons/new-file-icon.png"));
	Image open = new Image(getClass().getResourceAsStream("/application/Icons/Toolbar_icons/folder-open-icon.png"));
	Image save = new Image(getClass().getResourceAsStream("/application/Icons/Toolbar_icons/save-icon.png"));
	Image person = new Image(getClass().getResourceAsStream("/application/Icons/Toolbar_icons/User-icon.png"));
	Image team = new Image(getClass().getResourceAsStream("/application/Icons/Toolbar_icons/team-icon.png"));
	Image sport = new Image(getClass().getResourceAsStream("/application/Icons/Toolbar_icons/sports-icon.png"));
	
	@FXML Button newCompetition;
	@FXML Button openSavedCompetition;
	@FXML Button saveCompetition;
	@FXML Button newPerson;
	@FXML Button newTeam;
	@FXML Button newSport;
	@FXML Button testButton;
	
	@FXML
	public void initialize(){
		newCompetition.setGraphic(new ImageView(newFile));
		newCompetition.setPadding(Insets.EMPTY);
		openSavedCompetition.setGraphic(new ImageView(open));
		openSavedCompetition.setPadding(Insets.EMPTY);
		saveCompetition.setGraphic(new ImageView(save));
		saveCompetition.setPadding(Insets.EMPTY);
		newPerson.setGraphic(new ImageView(person));
		newPerson.setPadding(Insets.EMPTY);
		newTeam.setGraphic(new ImageView(team));
		newTeam.setPadding(Insets.EMPTY);
		newSport.setGraphic(new ImageView(sport));
		newSport.setPadding(Insets.EMPTY);
	}
	
	public void init(MainController mainController){
		main=mainController;
		
	}
	
	//debuggaus testi-metodi
	public void printtaa(ActionEvent e){
		System.out.println("nappi toimii");
		System.out.println(main.competition.getName());
		System.out.println(main.competition.competitors.get(1).toString());
	}
	
	@FXML
	public void newPersonPressed(ActionEvent e){
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
	public void newSportPressed(ActionEvent e){
		try{
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/NewSport.fxml" ));
			 Stage stage = new Stage();		 
			 stage.setScene(new Scene((Parent) loader.load()));
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
	public void newTeamPressed(ActionEvent e){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/NewTeam.fxml" ));
			Stage stage = new Stage();		 
			stage.setScene(new Scene((Parent) loader.load()));
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
	
	@FXML
	public void saveCompetition(ActionEvent e){
		
		try {
			FileOutputStream fs = new FileOutputStream("Competition.ser");
			try {
				ObjectOutputStream os = new ObjectOutputStream(fs);
				os.writeObject(main.competition);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	
	@FXML
	public void openCompetition(ActionEvent e){
		
		try {
			FileInputStream fi = new FileInputStream("Competition.ser");
			
			try {
				ObjectInputStream oi = new ObjectInputStream(fi);
				try {
					Competition opened=(Competition) oi.readObject();
					main.lataaKilpailu(opened);	//t�h�n kohtaan kutsu metodia openCompetition.Se vois olla omassa luokassaan saveCompetitionin kanssa. Ei kuulu menu&toolbar.
				} catch (ClassNotFoundException e3) {
					
					e3.printStackTrace();
				}
			} catch (IOException e2) {
				
				e2.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
	}
	
}
