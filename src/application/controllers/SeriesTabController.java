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
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

public class SeriesTabController {

	MainController main;
	@FXML ListView<Participant> participantsListview;
	@FXML Label nameOfSportAndSerie;
	@FXML ImageView firstPlace;
	@FXML ImageView secondPlace;
	@FXML ImageView thirdPlace;
	@FXML Button refresh;
	@FXML Button refresh1;//testausnappi
	Image first = new Image(getClass().getResourceAsStream("/application/Icons/Other_icons/iconFirst.png"));
	Image second = new Image(getClass().getResourceAsStream("/application/Icons/Other_icons/iconSecond.png"));
	Image third = new Image(getClass().getResourceAsStream("/application/Icons/Other_icons/iconThird.png"));
	
	Serie serie;
	Sport sport;
	
	@FXML Label firstLabel, secondLabel, thirdLabel;
	
	
	public void taytaListView(){
		
		ObservableList<Participant> myObservableList = FXCollections.observableList(serie.serieParticipants);
		participantsListview.setItems(myObservableList);
		
		participantsListview.setCellFactory(new Callback<ListView<Participant>, ListCell<Participant>>(){
		
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
		
		if (e.getClickCount() == 2) {
			Participant participant=null;
			participant = participantsListview.getSelectionModel().getSelectedItem();
		
			try{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/SetResults.fxml" ));
				Stage stage = new Stage();		 
				stage.setScene(new Scene((Parent)loader.load()));
				stage.setTitle("Set Results for: "+participant.toString());
				SetResultsController controller = loader.<SetResultsController>getController();
				controller.init(participant, sport.numberOfResultsPerParticipant);
				stage.show();
				// return stage; //viittaus avautuneeseen ikkunaan jos halutaan myï¿½hemmin pï¿½ï¿½stï¿½ siihen kï¿½siksi tï¿½stï¿½ luokasta
			}
			catch(Exception i){
				i.printStackTrace();
			}
			
		}		
	}
	
	
	@FXML
	public void initialize(){
		firstPlace.setImage(first);
		secondPlace.setImage(second);
		thirdPlace.setImage(third);
	}
	
	
	@FXML
	private void refreshParticipants(ActionEvent e){		
		taytaListView();
	}
	
	
	@FXML	//mieti tää metodi uusiks
	public void refreshListView(ActionEvent e){
		serie.sortParticipantsByResult(sport.resultFormation, sport.highestWins);		
		main.listViewController.showSerieParticipantsInResultOrder(serie, sport);
		setWinnersNames();		// Siirrä muualle tästä metodista
		
	}
	
	private void setWinnersNames(){
		firstLabel.setText(serie.sortedParticipants.get(0).toString());
		secondLabel.setText(serie.sortedParticipants.get(1).toString());
		thirdLabel.setText(serie.sortedParticipants.get(2).toString());
	}
}
