package application.controllers;

import application.model.Participant;
import application.model.Serie;
import application.model.Sport;
import application.model.Sport.ResultFormation;
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
	
	//metodin nimi h�m��. osallistujien j�rjestys sortattu jo aikaisemmin, t�m� vain lukee osallistujat listViewhin
	public void showSerieParticipantsInResultOrder(Serie serie, Sport sport){

		ObservableList<Participant> myObservableList = FXCollections.observableList(serie.sortedParticipants);
		listView.setItems(myObservableList);
		
		listView.setCellFactory(new Callback<ListView<Participant>, ListCell<Participant>>(){
		
		@Override
        public ListCell<Participant> call(ListView<Participant> p) {
             
            ListCell<Participant> cell = new ListCell<Participant>(){
            	
                @Override
                protected void updateItem(Participant participant, boolean bln) {
                    super.updateItem(participant, bln);
                    if (participant != null && sport.resultFormation==ResultFormation.BEST) {
                        setText(String.format("%-35s %s", participant.toString()," Decisive result: ")+participant.getHighestOfResults());
                        //setText(t.toString()+" Decisive result: "+t.getHighestOfResults()); vanha tulostus
                    }
                    else if (participant != null && sport.resultFormation==ResultFormation.AVERAGE) {
                    	setText(String.format("%-35s %s", participant.toString()," Decisive result: ")+participant.getAverageOfResults());
                    }
                    else if (participant != null && sport.resultFormation==ResultFormation.SUM) {
                    	setText(String.format("%-35s %s", participant.toString()," Decisive result: ")+participant.getSumOfResults());
                    }
                }
            };            
            return cell;
        } });				
	}
}
