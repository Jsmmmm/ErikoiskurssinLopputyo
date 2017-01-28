package application.controllers;

import application.model.Competitor;
import application.model.Sport;
import application.model.Osallistuja;
import application.model.Serie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import javafx.util.Callback;

public class SeriesTabController {

	MainController main;
	@FXML ListView<Osallistuja> listView;
	@FXML Label lajinJaSarjanNimi;
	
	Serie sarja;
	Sport laji;
	
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
	
	
	
	
	public void init(MainController main, Serie sarja, Sport laji){
		this.main=main;
		this.sarja=sarja;
		this.laji=laji;
		
	}
	
	public void asetaNimi(){
		lajinJaSarjanNimi.setText(laji.toString()+": "+sarja.toString());
		
	}
	
	
}
