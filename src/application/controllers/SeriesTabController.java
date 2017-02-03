package application.controllers;

import java.util.List;

import application.model.Competitor;
import application.model.Sport;
import application.model.Participant;
import application.model.Serie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class SeriesTabController {

	MainController main;
	@FXML ListView<Participant> listView;
	@FXML Label nameOfSportAndSerie;
	@FXML ImageView firstPlace;
	@FXML ImageView secondPlace;
	@FXML ImageView thirdPlace;
	
	Image first = new Image(getClass().getResourceAsStream("/application/Icons/Other_icons/iconFirst.png"));
	Image second = new Image(getClass().getResourceAsStream("/application/Icons/Other_icons/iconSecond.png"));
	Image third = new Image(getClass().getResourceAsStream("/application/Icons/Other_icons/iconThird.png"));
	
	Serie serie;
	Sport sport;
	
	
	
	public void taytaListView(){
		
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

	
	public void init(MainController main, Serie serie, Sport sport){
		
		this.main=main;
		this.serie=serie;
		this.sport=sport;		
	}
	
	public void setName(){
		nameOfSportAndSerie.setText(sport.toString()+": "+serie.toString());		
	}
	
	@FXML
	public void listViewClicked(MouseEvent e){
		
		Participant participant = listView.getSelectionModel().getSelectedItem();

		System.out.println(participant.toString());
	}
	
	@FXML
	public void initialize(){
		firstPlace.setImage(first);
		secondPlace.setImage(second);
		thirdPlace.setImage(third);
	}
	
	
}
