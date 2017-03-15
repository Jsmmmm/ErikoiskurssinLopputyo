package application.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainTabController {

	MainController main;
	
	@FXML Button newPerson;
	@FXML Button editPerson;
	@FXML Button deletePerson;
	
	@FXML Button newTeam;
	@FXML Button editTeam;
	@FXML Button deleteTeam;
	
	@FXML Button newSport;
	@FXML Button editSport;
	@FXML Button deleteSport;
	
	@FXML Label competitors;
	@FXML Label men;
	@FXML Label women;	
	@FXML Label menU18;
	@FXML Label womenU18;
	@FXML Label teams;
	@FXML Label sports;
	@FXML Label series;
	@FXML Label competitionName;
	
	/*@FXML
	public void initialize(){
		
	}*/
	
	public void init(MainController mainController){
		main=mainController;
		
	}

	
	//TODO remove newPerson / newSport / newTeam methods, dublicate code -> ToolbarController
	@FXML
	public void newPerson(ActionEvent e){
		if(main.checkCompetition()){
			try{
				 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/NewPerson.fxml" ));
				 Stage stage = new Stage();		 
				 stage.setScene(new Scene((Parent) loader.load()));
				 stage.setTitle("New Person");
				 NewPersonController controller = loader.<NewPersonController>getController();
				 controller.init(main);
				 stage.show();
				// return stage; 
			}
			catch(Exception i){
				i.printStackTrace();
			}
		}else{
			Dialogs.noCompetitionAlert();
		}
		
	}
	
	//TODO remove newPerson / newSport / newTeam methods, dublicate code -> ToolbarController
	@FXML
	public void newSport(ActionEvent e){
		if(main.checkCompetition()){
			try{
				 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/NewSport.fxml" ));
				 Stage stage = new Stage();		 
				 stage.setScene(new Scene((Parent) loader.load()));
				 stage.setTitle("New Sport");
				 NewSportController controller = loader.<NewSportController>getController();
				 controller.init(main);
				 stage.show();
				 //return stage; 
			}
			catch(Exception i){
				i.printStackTrace();
			}
		}else{
			Dialogs.noCompetitionAlert();
		}
	
	}
	
	//TODO remove newPerson / newSport / newTeam methods, dublicate code -> ToolbarController
	@FXML
	public void newTeam(ActionEvent e){
		if(main.checkCompetition()){
			try{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/NewTeam.fxml" ));
				Stage stage = new Stage();		 
				stage.setScene(new Scene((Parent) loader.load()));
				stage.setTitle("New Team");
				NewTeamController controller = loader.<NewTeamController>getController();
				controller.init(main);
				stage.show();
				//return stage; 		
			}
			catch(Exception i){
				i.printStackTrace();
			}
		}else{
			Dialogs.noCompetitionAlert();
		}
	}
	
	public void setCompetitionNameLabel(String name){
		competitionName.setText(name);
	}
	
	public void refreshMaintabStatistics(){
		refreshCompetitors();
		refreshSports();
		refreshTeams();
	}
	
	private void refreshCompetitors(){
		competitors.setText(Integer.toString(main.competition.amountOfCompetitors));
		men.setText(Integer.toString(main.competition.men));
		menU18.setText(Integer.toString(main.competition.menU18));
		women.setText(Integer.toString(main.competition.women));
		womenU18.setText(Integer.toString(main.competition.womenU18));
	}
	
	private void refreshSports(){
		sports.setText(Integer.toString(main.competition.amountOfSports));
		series.setText(Integer.toString(main.competition.amountOfSeries));
	}
	
	private void refreshTeams(){
		teams.setText(Integer.toString(main.competition.amountOfTeams));
	}
	
}
