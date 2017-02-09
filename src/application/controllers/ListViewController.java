package application.controllers;

import application.model.Participant;
import application.model.Serie;
import application.model.Sport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ListViewController {

	MainController main;
	
	@FXML
	ListView<Participant> listView;	
	
	/*@FXML
	public void initialize(){
		
	}*/
	
	
	public void init(MainController mainController){
		main=mainController;
	}
	
	//metodin nimi h‰m‰‰. osallistujien j‰rjestys sortattu jo aikaisemmin, t‰m‰ vain lukee osallistujat listViewhin
	public void showSerieParticipantsInResultOrder(Serie serie){

		ObservableList<Participant> myObservableList = FXCollections.observableList(serie.serieParticipants);
		listView.setItems(myObservableList);
		
		listView.setCellFactory(new Callback<ListView<Participant>, ListCell<Participant>>(){
		
		@Override
        public ListCell<Participant> call(ListView<Participant> p) {
             
            ListCell<Participant> cell = new ListCell<Participant>(){
            	
                @Override
                protected void updateItem(Participant t, boolean bln) {
                    super.updateItem(t, bln);
                    if (t != null) {
                        setText(t.toString());
                    }
                }
            };            
            return cell;
        } });				
	}
}
