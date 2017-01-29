package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
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
	
	public void printtaa(ActionEvent e){
		System.out.println("toimii");
	}
	
	@FXML
	public void newPersonPressed(ActionEvent e){
		try{
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/NewPerson.fxml" ));
			 Stage stage = new Stage();		 
			 stage.setScene(new Scene(loader.load()));
			 stage.setTitle("New Person");
			 NewPersonController controller = loader.<NewPersonController>getController();
			 controller.init(main);
			 stage.show();
			// return stage; //viittaus avautuneeseen ikkunaan jos halutaan myöhemmin päästä siihen käsiksi tästä luokasta
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
			 stage.setScene(new Scene(loader.load()));
			 stage.setTitle("Uusi Laji");
			 NewSportController controller = loader.<NewSportController>getController();
			 controller.init(main);
			 stage.show();
			 //return stage; //viittaus avautuneeseen ikkunaan jos halutaan myöhemmin päästä siihen käsiksi tästä luokasta
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
			stage.setScene(new Scene(loader.load()));
			stage.setTitle("Uusi Joukkue");
			NewTeamController controller = loader.<NewTeamController>getController();
			controller.init(main);
			stage.show();
			//return stage; //viittaus avautuneeseen ikkunaan jos halutaan myöhemmin päästä siihen käsiksi tästä luokasta			
		}
		catch(Exception i){
			i.printStackTrace();
		}
	}
	
}
