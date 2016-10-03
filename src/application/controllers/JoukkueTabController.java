package application.controllers;

import application.model.Joukkue;
import application.model.Kilpailija;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class JoukkueTabController {

	
	MainController main;
	@FXML TextField joukkueenNimiKentta;
	
	
	public Joukkue tallennaJoukkue(){
		Joukkue uusiJoukkue=null;
		if(!joukkueenNimiKentta.getText().isEmpty()){
			uusiJoukkue = new Joukkue(joukkueenNimiKentta.getText());
			
			
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
	
	@FXML
	public void poistaNappiaPainettu(ActionEvent e){
		main.treeViewViewController.poista(e);		
	}
	
}
