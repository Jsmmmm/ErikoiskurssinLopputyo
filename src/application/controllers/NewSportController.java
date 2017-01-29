package application.controllers;

import application.model.Sport;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
 
public class NewSportController {
	
	MainController main;
	@FXML TextField sportName;
	@FXML CheckBox general;	
	@FXML CheckBox men;
	@FXML CheckBox women;
	@FXML CheckBox menU18;
	@FXML CheckBox womenU18;
	@FXML Button save;
	@FXML Button cancel;
	
	boolean booleanGeneral=false;
	boolean booleanMen=false;
	boolean booleanWomen=false;
	boolean booleanMenU18=false;
	boolean booleanWomenU18=false;
	
	
	@FXML
	void saveButton(ActionEvent e){
		int amountOfSeries=0;
		String lajinNimi=null;
		if( !(sportName.getText().isEmpty()) ){
			lajinNimi=sportName.getText();
			
			if(general.isSelected()){
				booleanGeneral=true;
				amountOfSeries++;
			}
			if(men.isSelected()){
				booleanMen=true;
				amountOfSeries++;
			}
			if(women.isSelected()){ 
				booleanWomen=true;
				amountOfSeries++;
			}
			if(menU18.isSelected()){
				booleanMenU18=true;
				amountOfSeries++;
			}
			if(womenU18.isSelected()){
				booleanWomenU18=true;
				amountOfSeries++;
			}
		
			Sport newSport=new Sport(lajinNimi, booleanGeneral, booleanMen, booleanWomen, booleanMenU18, booleanWomenU18);
			main.lajit.add(newSport);
			main.lisaaLajiPuunakymaan(newSport);
			main.lajiJaSarjaLaskuri(true, amountOfSeries);
			closeWindow(e);
		
		}						
	}
	
	
	public void closeWindow(ActionEvent e){
		 Stage stage = (Stage) save.getScene().getWindow();
		    stage.close();
	}
	
	
	public void init(MainController main){
		this.main=main;
	}
}
