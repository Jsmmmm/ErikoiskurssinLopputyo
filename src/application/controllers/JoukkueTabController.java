package application.controllers;

import application.model.Joukkue;
import application.model.Kilpailija;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class JoukkueTabController {

	Tab tab;
	MainController main;
	@FXML Label joukkueenNimiKentta;
	
	/*
	public Joukkue tallennaJoukkue(){
		Joukkue uusiJoukkue=null;
		if(!joukkueenNimiKentta.getText().isEmpty()){
			uusiJoukkue = new Joukkue(joukkueenNimiKentta.getText());
			
			
		}return uusiJoukkue;
	} */
	
	
	@FXML
	public void initialize(){
		
	}
	
	public void init(MainController mainController, Tab tab){
		main=mainController;
		this.tab=tab;
	}
	
	/*
	public void tyhjennaTekstikentat(){
		joukkueenNimiKentta.clear();
		joukkueenNimiKentta.setPromptText("Joukkueen nimi");
	} */
	
	public void avaaJoukkueenTiedot(Joukkue joukkue){
		joukkueenNimiKentta.setText(joukkue.toString());
	}
	
	/*
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
	} */
	
	
	@FXML
	public void poistaPainettu(ActionEvent e){
		main.treeViewViewController.poista(e);	
		main.tabPane.getTabs().remove(tab);
	} 
	
}
