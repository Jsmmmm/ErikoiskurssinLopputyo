package application.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import application.model.Competition;
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
	public void newTournamentPressed(ActionEvent e){
		try{
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/NewCompetition.fxml" ));
			 Stage stage = new Stage();		 
			 stage.setScene(new Scene((Parent) loader.load()));
			 stage.setTitle("New Tournament");
			 NewCompetitionController controller = loader.<NewCompetitionController>getController();
			 controller.init(main);
			 stage.show();
			// return stage; //viittaus avautuneeseen ikkunaan jos halutaan myï¿½hemmin pï¿½ï¿½stï¿½ siihen kï¿½siksi tï¿½stï¿½ luokasta
			 
			 //suljetaan tï¿½mï¿½ ikkuna
			 Stage thisStage = (Stage) newTournament.getScene().getWindow();
			 thisStage.close();
		}
		catch(Exception i){
			i.printStackTrace();
		}
	}
	
	/*
	 * ei toimi. palauttaa uuden instanssin MainControllerista
	 */
	@FXML
	public void initialize(){
		/*FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/MainView.fxml"));
		try{
			loader.load();
		}catch(Exception e){
			System.out.println("ei toimi loader");
		}
		
		this.main = loader.getController();*/
		
	}
	
	@FXML
	public void openTournamentPressed(ActionEvent e){
		//hae kilpailu file ja kutsu maincontrollerin lataaKilpailu(kilpailu) metodia
		Competition competition=null;
		
		try {
			FileInputStream fi = new FileInputStream("Competition.ser");	// sit ku toimii nii lisää tähän filechooser
			
			try {
				ObjectInputStream oi = new ObjectInputStream(fi);
				try {
					competition = (Competition) oi.readObject();
					
				} catch (ClassNotFoundException e3) {
					
					e3.printStackTrace();
				}
			} catch (IOException e2) {
				
				e2.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
		if(competition!=null){
			main.lataaKilpailu(competition);
		}else System.out.println("Competition on null");
		
		
	}
	
	
	public void init(MainController main){
		this.main=main;
	}
	
	
}
