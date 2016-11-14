package application.controllers;

import application.model.Kilpailija;
import application.model.Laji;
import application.model.Osallistuja;
import application.model.Sarja;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import javafx.util.Callback;

public class SarjaTabController {

	MainController main;
	@FXML ListView<Osallistuja> listView;
	//ObservableList<Kilpailija> sarjanKilpailijat;
	Sarja sarja;
	
	public void taytaListView(){
		
		ObservableList<Osallistuja> myObservableList = FXCollections.observableList(sarja.sarjanOsallistujat);
		listView.setItems(myObservableList);
		
		listView.setCellFactory(new Callback<ListView<Osallistuja>, ListCell<Osallistuja>>(){
		
		@Override
        public ListCell<Osallistuja> call(ListView<Osallistuja> p) {
             
            ListCell<Osallistuja> cell = new ListCell<Osallistuja>(){
            	
                @Override
                protected void updateItem(Osallistuja t, boolean bln) {
                    super.updateItem(t, bln);
                    if (t != null) {
                        setText(t.toString());
                    }
                }
            };            
            return cell;
        } });
    				
	}		
	
	
	
	
	public void init(MainController main, Sarja sarja){
		this.main=main;
		this.sarja=sarja;
	}
	
	
	
}
