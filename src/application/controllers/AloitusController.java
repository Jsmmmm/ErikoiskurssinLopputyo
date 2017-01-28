package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AloitusController {

	@FXML Button uusiKilpailu;
	@FXML Button avaaKilpailu;
	MainController main;
	
	@FXML
	public void uusiKilpailu(ActionEvent e){
		try{
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/UusiKilpailu.fxml" ));
			 Stage stage = new Stage();		 
			 stage.setScene(new Scene(loader.load()));
			 stage.setTitle("Uusi Kilpailu");
			 UusiKilpailuController controller = loader.<UusiKilpailuController>getController();
			 controller.init(main);
			 stage.show();
			// return stage; //viittaus avautuneeseen ikkunaan jos halutaan my�hemmin p��st� siihen k�siksi t�st� luokasta
			 
			 //suljetaan t�m� ikkuna
			 Stage thisStage = (Stage) uusiKilpailu.getScene().getWindow();
			 thisStage.close();
		}
		catch(Exception i){
			i.printStackTrace();
		}
	}
	
	/*
	 * T�� on aika omituinen ja ehk� dirty tapa hakee maincontroller. Ja miks haen sen jo t�s vaihees ku tartten sit� vast uusi kilpailu ikkunassa?
	 * 
	 */
	@FXML
	public void initialize(){
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/MainView.fxml"));
		try{
			loader.load();
		}catch(Exception e){
			System.out.println("ei toimi loader");
		}
		
		this.main = loader.getController();
	}
	
	@FXML
	public void avaaKilpailu(){
		System.out.println("Nappi toimii");
	}
	
	
	
}
