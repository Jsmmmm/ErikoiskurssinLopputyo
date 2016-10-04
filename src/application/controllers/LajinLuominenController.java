package application.controllers;

import application.model.Laji;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
 
public class LajinLuominenController {
	
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
		
		String lajinNimi=null;
		if( !(lajinNimiKentta.getText().isEmpty()) ){
			lajinNimi=lajinNimiKentta.getText();
			
			if(yleisSarja.isSelected()){
				booleanYleisSarja=true;
			}
			if(miestenSarja.isSelected()){
				booleanMiestenSarja=true;
			}
			if(naistenSarja.isSelected()){ 
				booleanNaistenSarja=true;
			}
			if(miestenU18.isSelected()){
				booleanMiestenU18=true;
			}
			if(naistenU18.isSelected()){
				booleanNaistenU18=true;
			}
		
			Laji uusiLaji=new Laji(lajinNimi, booleanYleisSarja, booleanMiestenSarja, booleanNaistenSarja, booleanMiestenU18, booleanNaistenU18);
			main.lajit.add(uusiLaji);
			main.lisaaLajiPuunakymaan(uusiLaji);
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
