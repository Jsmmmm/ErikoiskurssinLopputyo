package application.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MenuAndToolbarController {

	Image uusi = new Image(getClass().getResourceAsStream("/application/Icons/Toolbar_icons/new-file-icon.png"));
	Image avaa = new Image(getClass().getResourceAsStream("/application/Icons/Toolbar_icons/folder-open-icon.png"));
	Image tallenna = new Image(getClass().getResourceAsStream("/application/Icons/Toolbar_icons/save-icon.png"));
	
	@FXML Button uusiKilpailu;
	@FXML Button avaaKilpailu;
	@FXML Button tallennaKilpailu;
	@FXML Button uusiKilpailija;
	@FXML Button uusiJoukkue;
	@FXML Button uusiLaji;
	
	@FXML
	public void initialize(){
		uusiKilpailu.setGraphic(new ImageView(uusi));
		avaaKilpailu.setGraphic(new ImageView(avaa));
		tallennaKilpailu.setGraphic(new ImageView(tallenna));
	}
	
	
	
	
}
