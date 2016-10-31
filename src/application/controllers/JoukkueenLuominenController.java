package application.controllers;

import application.model.Joukkue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class JoukkueenLuominenController {

	MainController main;
	
@FXML TextField joukkueenNimiKentta;
	
	
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
			}
	}
	
	@FXML
	public void tyhjennaNappiaPainettu(ActionEvent e){		
		tyhjennaTekstikentat();	
	}
}
