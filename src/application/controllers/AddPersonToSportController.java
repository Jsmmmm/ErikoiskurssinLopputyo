package application.controllers;

import application.model.Person;
import application.model.Sport;
import application.model.Participant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import javafx.util.Callback;
import application.model.Competitor;
public class AddPersonToSportController {
			
	MainController main;
	@FXML ListView<Competitor> listView;
	@FXML Button add;
	@FXML Button cancel;
	Sport sport;
	ObservableList<Competitor> targetedCompetitors;
	
	
	public void addPressed(ActionEvent e){
			
		for(Competitor competitor : targetedCompetitors){
			sport.sportParticipants.add(new Participant(competitor, sport.numberOfResultsPerParticipant));		
		}
		sport.placeParticipantsToSeries();
		cancel(e);
	}
	
	public void initData(MainController main, Sport sport/*String valittuLaji*/){
		this.main=main;
		this.sport=sport;
		fillListView();
		//laji=main.haeLaji(valittuLaji);					
		
	}
	
	
	public void getTargetedCompetitors(Event e){
		targetedCompetitors =  listView.getSelectionModel().getSelectedItems();
		
	}
	
	
	
	public void fillListView(){
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		ObservableList<Competitor> myObservableList = FXCollections.observableList(main.competition.competitors);
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
	
	@FXML
	public void cancel(ActionEvent e){
		 Stage stage = (Stage) cancel.getScene().getWindow(); 
		 stage.close();
	}
	
	
}
