package application.controllers;

import application.model.Joukkue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class JoukkueenLuominenController {

	MainController main;
	
	@FXML TextField joukkueenNimiKentta;
	@FXML Button peruuta;
	
	
	public Joukkue tallennaJoukkue(){
		Joukkue uusiJoukkue=null;
		if(!joukkueenNimiKentta.getText().isEmpty()){
			uusiJoukkue = new Joukkue(joukkueenNimiKentta.getText());
			
			
		}return uusiJoukkue;
	}
			
	
	public void init(MainController mainController){
		main=mainController;
	}
	
	public void tyhjennaTekstikentat(){
		joukkueenNimiKentta.clear();
		joukkueenNimiKentta.setPromptText("Joukkueen nimi");
	}
	
	@FXML
	public void tallennaNappiaPainettu(ActionEvent e){
		
			Joukkue joukkue=tallennaJoukkue();
			if(joukkue!=null){
				main.joukkueet.add(joukkue);
				main.treeViewViewController.lisaaJoukkueOlioPuunakymaan(joukkue);
				main.joukkueLaskuri(true);
			}
	}
	
	
	@FXML
	public void peruutaPainettu(ActionEvent e){
		 Stage stage = (Stage) peruuta.getScene().getWindow();		   
		 stage.close();
	}
	
	
	
}
