package application.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MenuAndToolbarController {

	Image uusi = new Image(getClass().getResourceAsStream("/application/icons/new-file-icon.png"));
	Image avaa = new Image(getClass().getResourceAsStream("/application/icons/folder-open-icon.png"));
	Image tallenna = new Image(getClass().getResourceAsStream("/application/icons/save-icon.png"));
	
	@FXML Button uusiKilpailu;
	@FXML Button avaaKilpailu;
	@FXML Button tallennaKilpailu;
	
	@FXML
	public void initialize(){
		uusiKilpailu.setGraphic(new ImageView(uusi));
		avaaKilpailu.setGraphic(new ImageView(avaa));
		tallennaKilpailu.setGraphic(new ImageView(tallenna));
	}
	
	
	
	
}
