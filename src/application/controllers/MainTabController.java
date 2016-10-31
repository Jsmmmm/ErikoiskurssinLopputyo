package application.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	
	
	public void init(MainController mainController){
		main=mainController;
	}
	

	@FXML
	public void uusiKilpailijaButton(ActionEvent e){
		try{
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/HenkilonLuominen.fxml" ));
			 Stage stage = new Stage();		 
			 stage.setScene(new Scene(loader.load()));
			 stage.setTitle("Uusi Kilpailija");
			 HenkilonLuominenController controller = loader.<HenkilonLuominenController>getController();
			 controller.init(main);
			 stage.show();
			// return stage; //viittaus avautuneeseen ikkunaan jos halutaan myöhemmin päästä siihen käsiksi tästä luokasta
		}
		catch(Exception i){
			i.printStackTrace();
		}
	}
	
	@FXML
	public void uusiLajiButton(ActionEvent e){
		try{
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/LajinLuominen.fxml" ));
			 Stage stage = new Stage();		 
			 stage.setScene(new Scene(loader.load()));
			 stage.setTitle("Uusi Laji");
			 LajinLuominenController controller = loader.<LajinLuominenController>getController();
			 controller.init(main);
			 stage.show();
			 //return stage; //viittaus avautuneeseen ikkunaan jos halutaan myöhemmin päästä siihen käsiksi tästä luokasta
		}
		catch(Exception i){
			i.printStackTrace();
		}
	}
	
	@FXML
	public void uusiJoukkueButton(ActionEvent e){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/JoukkueenLuominen.fxml" ));
			Stage stage = new Stage();		 
			stage.setScene(new Scene(loader.load()));
			stage.setTitle("Uusi Joukkue");
			JoukkueenLuominenController controller = loader.<JoukkueenLuominenController>getController();
			controller.init(main);
			stage.show();
			//return stage; //viittaus avautuneeseen ikkunaan jos halutaan myöhemmin päästä siihen käsiksi tästä luokasta			
		}
		catch(Exception i){
			i.printStackTrace();
		}
	}
	
	
}
