package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import application.model.Sport;

public class SportTabController {

	Tab tab;
	MainController main;
	Sport sport;
	@FXML Label name;
	@FXML Button addCompetitors;
	@FXML CheckBox generalSeries;
	@FXML CheckBox mensSeries;
	@FXML CheckBox womensSeries;
	@FXML CheckBox menU18Series;
	@FXML CheckBox womenU18Series;
	@FXML Button removeCompetitors;
	@FXML Button newSport;
	@FXML Button deleteSport;
	
	@FXML Label amountOfResults;
	@FXML Label resultType;
	@FXML Label resultFormation;
	@FXML Label winnerHas;
	
	public void init(MainController mainController){
		main=mainController;
	}
	
	//käy uusiks läpi miks oon tehny kaks init metodia
	public void init(MainController mainController, Tab tab){
		main=mainController;
		this.tab=tab;
	}
	
	@FXML
	public void newSportPressed(ActionEvent e){
		try{
			openCreateNewSportWindow(main);
		}
		catch(Exception i){
			i.printStackTrace();
		}
	}
	
	
	public Stage openCreateNewSportWindow(MainController main) throws IOException{
		
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/LajinLuominen.fxml" ));
		 Stage stage = new Stage();		 
		 stage.setScene(new Scene((Parent) loader.load()));
		 stage.setTitle("Create New Sport");
		 NewSportController controller = loader.<NewSportController>getController();
		 controller.init(main);
		 stage.show();
		 return stage; //viittaus avautuneeseen ikkunaan jos halutaan myï¿½hemmin pï¿½ï¿½stï¿½ siihen kï¿½siksi tï¿½stï¿½ luokasta
	}
	
	
	@FXML
	public void addCompetitorsPressed(ActionEvent e){
		try{ showAddCompetitorsToSportWindow(main);
		}//tï¿½mï¿½ ei toimi, koska main controlleria ei olla asetettu! Tï¿½mï¿½n luokan init metodia ei olla tï¿½kï¿½tty luokan ulkopuolelta
		catch(Exception i){
			i.printStackTrace();			
		}	
		
	}
	
	
	public Stage showAddCompetitorsToSportWindow  (MainController main) throws IOException {
		 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/AddPersonToSport.fxml" ));
		 Stage stage = new Stage();		 
		 stage.setScene(new Scene((Parent) loader.load()));
		  stage.setTitle("Add Competitors to Sport: "+sport.toString());
		  AddPersonToSportController controller = loader.<AddPersonToSportController>getController();
		  controller.initData(main, sport/*lajinNimiKentta.getText()*/);
		  stage.show();
		  return stage; //viittaus avautuneeseen ikkunaan jos halutaan myï¿½hemmin pï¿½ï¿½stï¿½ siihen kï¿½siksi tï¿½stï¿½ luokasta
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
		generalSeries.setDisable(true);
		mensSeries.setDisable(true);
		womensSeries.setDisable(true);
		menU18Series.setDisable(true);
		womenU18Series.setDisable(true);
		
		
	}
	
	public void clearFields(){
		name.setText("");
		generalSeries.setSelected(false);
		mensSeries.setSelected(false);
		womensSeries.setSelected(false);
		menU18Series.setSelected(false);
		womenU18Series.setSelected(false);
		
	}
	
	public void openInformationOfSport(Sport laji){
		clearFields();
		this.sport=laji;
		name.setText(laji.toString());
		
		
		if(laji.booleanGeneral==true){		
			generalSeries.setSelected(true);			
		}
		if(laji.booleanMens==true){		
			mensSeries.setSelected(true);			
		}
		if(laji.booleanWomens==true){		
			womensSeries.setSelected(true);			
		}
		if(laji.booleanMensU18==true){		
			menU18Series.setSelected(true);			
		}
		if(laji.booleanWomensU18==true){		
			womenU18Series.setSelected(true);			
		}
		amountOfResults.setText(Integer.toString(laji.numberOfResultsPerParticipant));
		resultType.setText(sport.resultType.toString());
		resultFormation.setText(sport.resultFormation.toString());
		
		if(sport.highestWins){
			winnerHas.setText("Highest Value");
		}else{
			winnerHas.setText("Lowest Value");
		}
		
	}
	
	
}
