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
	
	Image uusi = new Image(getClass().getResourceAsStream("/application/Icons/Toolbar_icons/new-file-icon.png"));
	Image avaa = new Image(getClass().getResourceAsStream("/application/Icons/Toolbar_icons/folder-open-icon.png"));
	Image tallenna = new Image(getClass().getResourceAsStream("/application/Icons/Toolbar_icons/save-icon.png"));
	Image henkilo = new Image(getClass().getResourceAsStream("/application/Icons/Toolbar_icons/User-icon.png"));
	Image joukkue = new Image(getClass().getResourceAsStream("/application/Icons/Toolbar_icons/team-icon.png"));
	Image laji = new Image(getClass().getResourceAsStream("/application/Icons/Toolbar_icons/sports-icon.png"));
	
	@FXML Button uusiKilpailu;
	@FXML Button avaaKilpailu;
	@FXML Button tallennaKilpailu;
	@FXML Button uusiKilpailija;
	@FXML Button uusiJoukkue;
	@FXML Button uusiLaji;
	@FXML Button testiNappi;
	
	@FXML
	public void initialize(){
		uusiKilpailu.setGraphic(new ImageView(uusi));
		uusiKilpailu.setPadding(Insets.EMPTY);
		avaaKilpailu.setGraphic(new ImageView(avaa));
		avaaKilpailu.setPadding(Insets.EMPTY);
		tallennaKilpailu.setGraphic(new ImageView(tallenna));
		tallennaKilpailu.setPadding(Insets.EMPTY);
		uusiKilpailija.setGraphic(new ImageView(henkilo));
		uusiKilpailija.setPadding(Insets.EMPTY);
		uusiJoukkue.setGraphic(new ImageView(joukkue));
		uusiJoukkue.setPadding(Insets.EMPTY);
		uusiLaji.setGraphic(new ImageView(laji));
		uusiLaji.setPadding(Insets.EMPTY);
	}
	
	public void init(MainController mainController){
		main=mainController;
		
	}
	
	public void printtaa(ActionEvent e){
		System.out.println("toimii");
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
