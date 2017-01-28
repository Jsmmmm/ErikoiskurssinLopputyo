package application.controllers;

import application.model.Person;
import application.model.Sport;
import application.model.Osallistuja;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.util.Callback;
import application.model.Competitor;
public class AddPersonToSportController {
			
	MainController main;
	@FXML ListView<Competitor> listView;
	@FXML Button lisaa;
	@FXML Button peruuta;
	Sport laji;
	ObservableList<Competitor> valitutKohteet;
	
	
	public void lisaaNappiaPainettu(ActionEvent e){
			
		for(Competitor kilpailija : valitutKohteet){
			laji.lajinOsallistujat.add(new Osallistuja(kilpailija));
			System.out.println(kilpailija.toString()); 
		}
		laji.sijoitaOsallistujatSarjoihin(); 
		
	}
	
	public void initData(MainController main, Sport laji/*String valittuLaji*/){
		this.main=main;
		this.laji=laji;
		taytaListView();
		//laji=main.haeLaji(valittuLaji);					
		
	}
	
	
	public void kohdettaKlikattu(Event e){
		valitutKohteet =  listView.getSelectionModel().getSelectedItems();
		
	}
	
	
	
	public void taytaListView(){
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		ObservableList<Competitor> myObservableList = FXCollections.observableList(main.kilpailijat);
		listView.setItems(myObservableList);
		
		listView.setCellFactory(new Callback<ListView<Competitor>, ListCell<Competitor>>(){
		
		@Override
        public ListCell<Competitor> call(ListView<Competitor> p) {
             
            ListCell<Competitor> cell = new ListCell<Competitor>(){
            	
                @Override
                protected void updateItem(Competitor t, boolean bln) {
                    super.updateItem(t, bln);
                    if (t != null) {
                        setText(t.toString());
                    }
                }
            };            
            return cell;
        } });
    				
	}		
	@FXML
	public void initialize(){
		
		
		
	}
	
	
}
