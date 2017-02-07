package application.controllers;

import application.model.Sport;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
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
	@FXML ComboBox<Integer> numberOfResults;
	@FXML ComboBox<String> resultFormat;
	
	boolean booleanGeneral=false;
	boolean booleanMen=false;
	boolean booleanWomen=false;
	boolean booleanMenU18=false;
	boolean booleanWomenU18=false;
	
	
	@FXML
	public void saveButton(ActionEvent e){
		
		int amountOfSeries=0;
		String lajinNimi=null;
		String format;
		int results;
				
		
		if( !(sportName.getText().isEmpty()) && !(numberOfResults.getSelectionModel().isEmpty()) && !(resultFormat.getSelectionModel().isEmpty()) ){
			lajinNimi=sportName.getText();
			format=resultFormat.getValue();
			results=numberOfResults.getValue();
			
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
		
			Sport newSport=new Sport(lajinNimi, booleanGeneral, booleanMen, booleanWomen, booleanMenU18, booleanWomenU18, format, results);
			main.sports.add(newSport);
			main.lisaaLajiPuunakymaan(newSport);
			main.lajiJaSarjaLaskuri(true, amountOfSeries);
			
			//vie uuteen metodiin
			try{				
				Tab tab = new Tab();
				
				main.tabPane.getTabs().add(tab);
				FXMLLoader loader= new FXMLLoader(getClass().getResource("/application/view/SportTab.fxml" ));
				tab.setContent( (Node) loader.load());				
				SportTabController controller = loader.<SportTabController>getController();
				controller.init(main, tab);
				controller.openInformationOfSport(newSport);
				tab.setText(newSport.toString());
				tab.isClosable();
				main.tabPane.getSelectionModel().select(tab);;
				//return tab;
				
			}catch(Exception i){
				i.printStackTrace();
			}
			
			
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
	
	@FXML
	private void initialize(){
		numberOfResults.getItems().addAll( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		resultFormat.getItems().addAll("Points", "Time", "Distance");
	}
	
}
