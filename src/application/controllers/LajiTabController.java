package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import application.model.Laji;

public class LajiTabController {

	MainController main;
	Laji laji;
	@FXML Label lajinNimiKentta;
	@FXML Button kilpailijoidenLisaaminenNappi;
	@FXML CheckBox yleisSarja;
	@FXML CheckBox miestenSarja;
	@FXML CheckBox naistenSarja;
	@FXML CheckBox miestenU18;
	@FXML CheckBox naistenU18;
	@FXML Button kilpailijoidenPoistaminen;
	@FXML Button luoUusiLaji;
	
	public void init(MainController mainController){
		main=mainController;
	}
	
	@FXML
	public void luoUusiLajiNappiaPainettu(ActionEvent e){
		try{
			avaaUudenLajinLuontiIkkuna(main);
		}
		catch(Exception i){
			i.printStackTrace();
		}
	}
	
	
	public Stage avaaUudenLajinLuontiIkkuna(MainController main) throws IOException{
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/LajinLuominen.fxml" ));
		 Stage stage = new Stage();		 
		 stage.setScene(new Scene(loader.load()));
		  stage.setTitle("Uuden lajin luominen ");
		  LajinLuominenController controller = loader.<LajinLuominenController>getController();
		  controller.init(main);
		  stage.show();
		  return stage; //viittaus avautuneeseen ikkunaan jos halutaan myöhemmin päästä siihen käsiksi tästä luokasta
	}
	
	
	@FXML
	public void kilpailijoidenLisaaminenNappiaPainettu(ActionEvent e){
		try{ naytaLajiinLisaamisIkkuna(main);}
		catch(Exception i){i.printStackTrace();
			
		}		
	}
	
	
	public Stage naytaLajiinLisaamisIkkuna  (MainController main) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/KilpailijoidenLisaaminenLajiin.fxml" ));
		 Stage stage = new Stage();		 
		 stage.setScene(new Scene(loader.load()));
		  stage.setTitle("Kilpailijoiden lisaaminen lajiin: "+lajinNimiKentta.getText());
		  KilpailijoidenLisaaminenLajiinController controller = loader.<KilpailijoidenLisaaminenLajiinController>getController();
		  controller.initData(main, laji/*lajinNimiKentta.getText()*/);
		  stage.show();
		  return stage; //viittaus avautuneeseen ikkunaan jos halutaan myöhemmin päästä siihen käsiksi tästä luokasta
	}
	
	
	/*
	public Laji tallennaLaji(){
		Laji uusiLaji=null;
		if(!lajinNimiKentta.getText().isEmpty()){
			uusiLaji = new Laji(lajinNimiKentta.getText());						
		} return uusiLaji;
	}*/
	
	@FXML
	public void initialize(){
		yleisSarja.setDisable(true);
		miestenSarja.setDisable(true);
		naistenSarja.setDisable(true);
		miestenU18.setDisable(true);
		naistenU18.setDisable(true);
		
		
	}
	
	public void tyhjennaTekstikentat(){
		lajinNimiKentta.setText("");
		yleisSarja.setSelected(false);
		miestenSarja.setSelected(false);
		naistenSarja.setSelected(false);
		miestenU18.setSelected(false);
		naistenU18.setSelected(false);
		
	}
	
	public void avaaLajinTiedot(Laji laji){
		tyhjennaTekstikentat();
		this.laji=laji;
		lajinNimiKentta.setText(laji.toString());
		
		
		if(laji.booleanYleisSarja==true){		
			yleisSarja.setSelected(true);			
		}
		if(laji.booleanMiestenSarja==true){		
			miestenSarja.setSelected(true);			
		}
		if(laji.booleanNaistenSarja==true){		
			naistenSarja.setSelected(true);			
		}
		if(laji.booleanMiestenU18==true){		
			miestenU18.setSelected(true);			
		}
		if(laji.booleanNaistenU18==true){		
			naistenU18.setSelected(true);			
		}
	}
	
	
}
