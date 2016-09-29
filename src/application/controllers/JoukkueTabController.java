package application.controllers;

import application.model.Joukkue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class JoukkueTabController {

	
	MainController main;
	@FXML TextField joukkueenNimiKentta;
	
	
	public Joukkue tallennaJoukkue(){
		Joukkue uusiJoukkue=null;
		if(!joukkueenNimiKentta.getText().isEmpty()){
			uusiJoukkue = new Joukkue(joukkueenNimiKentta.getText());
			System.out.println(uusiJoukkue.toString());	
			
		}return uusiJoukkue;
	}
	
	
	@FXML
	public void initialize(){
		
	}
	
	public void init(MainController mainController){
		main=mainController;
	}
	
	public void tyhjennaTekstikentat(){
		joukkueenNimiKentta.clear();
		joukkueenNimiKentta.setPromptText("Joukkueen nimi");
	}
	
	public void avaaJoukkueenTiedot(Joukkue joukkue){
		joukkueenNimiKentta.setText(joukkue.toString());
	}
	
}
