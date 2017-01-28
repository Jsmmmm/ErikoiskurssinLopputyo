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
	@FXML TextField lajinNimiKentta;
	@FXML CheckBox yleisSarja;	
	@FXML CheckBox miestenSarja;
	@FXML CheckBox naistenSarja;
	@FXML CheckBox miestenU18;
	@FXML CheckBox naistenU18;
	@FXML Button tallenna;
	@FXML Button peruuta;
	
	boolean booleanYleisSarja=false;
	boolean booleanMiestenSarja=false;
	boolean booleanNaistenSarja=false;
	boolean booleanMiestenU18=false;
	boolean booleanNaistenU18=false;
	
	
	@FXML
	void tallennaNappiaPainettu(ActionEvent e){
		int sarjojenLKM=0;
		String lajinNimi=null;
		if( !(lajinNimiKentta.getText().isEmpty()) ){
			lajinNimi=lajinNimiKentta.getText();
			
			if(yleisSarja.isSelected()){
				booleanYleisSarja=true;
				sarjojenLKM++;
			}
			if(miestenSarja.isSelected()){
				booleanMiestenSarja=true;
				sarjojenLKM++;
			}
			if(naistenSarja.isSelected()){ 
				booleanNaistenSarja=true;
				sarjojenLKM++;
			}
			if(miestenU18.isSelected()){
				booleanMiestenU18=true;
				sarjojenLKM++;
			}
			if(naistenU18.isSelected()){
				booleanNaistenU18=true;
				sarjojenLKM++;
			}
		
			Sport uusiLaji=new Sport(lajinNimi, booleanYleisSarja, booleanMiestenSarja, booleanNaistenSarja, booleanMiestenU18, booleanNaistenU18);
			main.lajit.add(uusiLaji);
			main.lisaaLajiPuunakymaan(uusiLaji);
			main.lajiJaSarjaLaskuri(true, sarjojenLKM);
			suljeIkkuna(e);
		
		}						
	}
	
	
	public void suljeIkkuna(ActionEvent e){
		 Stage stage = (Stage) tallenna.getScene().getWindow();
		    stage.close();
	}
	
	
	public void init(MainController main){
		this.main=main;
	}
}
