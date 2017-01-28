package application.controllers;

import application.model.Sport;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ListViewController {

	MainController main;
	
	@FXML
	ListView<String> listView;	
	
	/*@FXML
	public void initialize(){
		
	}*/
	
	
	public void init(MainController mainController){
		main=mainController;
	}
	
	public void taytaListView(){
		
	}
}
