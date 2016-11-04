package application.controllers;

import application.model.Henkilo;
import application.model.Laji;
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
import application.model.Kilpailija;
public class KilpailijoidenLisaaminenLajiinController {
			
	MainController main;
	@FXML ListView<Kilpailija> listView;
	@FXML Button lisaa;
	@FXML Button peruuta;
	Laji laji;
	ObservableList<Kilpailija> valitutKohteet;
	
	
	public void lisaaNappiaPainettu(ActionEvent e){
			
		for(Kilpailija kilpailija : valitutKohteet){
			laji.lajinOsallistujat.add(new Osallistuja(kilpailija));
			System.out.println(kilpailija.toString()); 
		}
		laji.sijoitaOsallistujatSarjoihin(); 
		
	}
	
	public void initData(MainController main, Laji laji/*String valittuLaji*/){
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
		ObservableList<Kilpailija> myObservableList = FXCollections.observableList(main.kilpailijat);
		listView.setItems(myObservableList);
		
		listView.setCellFactory(new Callback<ListView<Kilpailija>, ListCell<Kilpailija>>(){
		
		@Override
        public ListCell<Kilpailija> call(ListView<Kilpailija> p) {
             
            ListCell<Kilpailija> cell = new ListCell<Kilpailija>(){
            	
                @Override
                protected void updateItem(Kilpailija t, boolean bln) {
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
