package application.controllers;

import application.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainController{
	
	public Competition competition;	
	@FXML AddPersonToSportController addPersonToSportController; 
	@FXML PersonTabController personTabController;
	@FXML TeamTabController teamTabController; 
	@FXML SportTabController sportTabController;
	@FXML MainTabController mainTabController;
	@FXML TreeViewController treeViewViewController;
	@FXML ListViewController listViewController;
	@FXML ToolbarController toolbarController;		
	@FXML TabPane tabPane;
	
	
	int amountOfCompetitors;
	int men;
	int women;
	int menU18;
	int womenU18;
	int amountOfSports;
	int amountOfSeries;
	int amountOfTeams;
	
	@FXML Tab sportTab;
	@FXML Tab teamTab;
	@FXML Tab personTab;
	@FXML Tab competitionTab;
	

	
	public void addSportToTW(Sport sport){
		
		treeViewViewController.addSportToTW(sport);
		treeViewViewController.addResultsToTW(sport);
	}
		
	
	public void deleteCompetitor(String name){
		Competitor competitor = getCompetitor(name);	
		if(competitor != null){
			competition.competitors.remove(competitor);
			personCounter(competitor, false);
		}else{
			System.out.println("Virhe tuli poistettaessa kilpailijaa");					
		}
	}
	
	public void deleteTeam(String name){
		Team team = getTeam(name);
		if(team != null){
			competition.teams.remove(team);
		} else{
			System.out.println("Virhe tuli poistettaessa joukkuetta");							
		}
	}
	
	public void deleteSport(String name){
		Sport sport = getSport(name);		
		if(sport != null){
			competition.sports.remove(sport);	
		}else {
			System.out.println("Virhe tuli poistettaessa lajia");										
		}
	}
	
	
	public Sport getSport(String name){
		Sport sport = null;
		for (Sport sport2 : competition.sports) {
			if ( name.equals(sport2.toString()) ) {
				sport=sport2;			
				} 
		}return sport;		
	}
	
	
	public Competitor getCompetitor(String name){		
		Competitor competitor = null;
		String splittedName[] = name.split(" ");
		String firstName = splittedName[0];
		String lastName = splittedName[1];
		int number = Integer.parseInt(splittedName[2].substring(1));
		for (Competitor competitor2 : competition.competitors) {
			if (competitor2.getFirstName().equals(firstName) && competitor2.getLastName().equals(lastName) && competitor2.getCompetitorNumber()==(number)) {
				competitor=competitor2;				
				}			
		}return competitor;
	}
	
	
	
	
	public Team getTeam(String name){
		Team team = null;
		for(Team team2 : competition.teams){
			if(name.equals(team2.toString())){
				team=team2;
			}
		}return team;
	}
	
	public Serie getSerie(Sport sport, String nameOfSerie){
		Serie serie=null;
		switch(nameOfSerie){
		case "General series" : serie = sport.general;
			break;
		case "Men's series" : serie = sport.mens ;
			break;
		case "Men's U-18" : serie = sport.mensU18;
			break;
		case "Women's series" : serie = sport.womens;
			break;
		case "Women's U-18" : serie=sport.womensU18;
			break;		
		}				
		return serie;
	}
	
	public void openCompetitorDetails(String nameOfCompetitor){
		Competitor competitor = getCompetitor(nameOfCompetitor);
		personTabController.openPersonInformation(competitor);
	}
	
	public void openSportDetails(String nameOfSport){
		Sport sport = getSport(nameOfSport);
		sportTabController.openInformationOfSport(sport);
	//	listViewController.taytaListView(); //KESKEN
	}
	
	public void openTeamDetails(String nameOfTeam){
		Team team = getTeam(nameOfTeam);
		teamTabController.openTeamInformation(team);
	}
	
	
	
	@FXML
	public void initialize() {
		openOpeningWindow();
		treeViewViewController.init(this);
		listViewController.init(this);
		mainTabController.init(this);
		toolbarController.init(this);
		
	}
	
	public void openOpeningWindow(){
		try{
			 FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/OpeningWindow.fxml" ));
			 Stage stage = new Stage();		 
			 stage.setScene(new Scene((Parent) loader.load()));
			 stage.setTitle("Welcome");
			 OpeningWindowController controller = loader.<OpeningWindowController>getController();
			 controller.init(this);
			 stage.setAlwaysOnTop(true);
			 stage.show();
			
			// return stage; //viittaus avautuneeseen ikkunaan
		}
		catch(Exception i){
			i.printStackTrace();
		}
		
	}		
	
	//for debugging
	public void printtaa(){
		System.out.println("toimii");
	}
	
	
	public void setCompetition(Competition competition){
		
		this.competition=competition;
		
	}
		
		
	public void loadCompetition(Competition loadedCompetition){
		
		//lisää tähän metodiin: ennen treeView:hen kilpailun tietojenlataamista tyhjennä treeView!
		
		this.competition=loadedCompetition;		
			
		for(Competitor competitor : competition.competitors){
			treeViewViewController.addCompetitorToTW(competitor);
		}								
		
		
		for(Team team : competition.teams){
			treeViewViewController.addTeamToTW(team);
		}
		
		
		for(Sport sport : competition.sports){
			treeViewViewController.addSportToTW(sport);
			treeViewViewController.addResultsToTW(sport);
		}
	
	}
	
	public void personCounter(Person person, Boolean addPerson){
		if(addPerson==true){
			amountOfCompetitors++;
			mainTabController.competitors.setText(Integer.toString(amountOfCompetitors));
			if(person.isMale()){
				if(person.getAge()>=18){
					men++;
					mainTabController.men.setText(Integer.toString(men));				
				}else {
					menU18++;
					mainTabController.menU18.setText(Integer.toString(menU18));
				}
			}else{
				if(person.getAge()>=18){
					women++;
					mainTabController.women.setText(Integer.toString(women));
				}else{
					womenU18++;
					mainTabController.womenU18.setText(Integer.toString(womenU18));
				}
			}
		}else{			
			amountOfCompetitors--;
			mainTabController.competitors.setText(Integer.toString(amountOfCompetitors));
			
			if(person.isMale()){
				if(person.getAge()>=18){
					men--;
					mainTabController.men.setText(Integer.toString(men));				
				}else {
					menU18--;
					mainTabController.menU18.setText(Integer.toString(menU18));
				}
			}else{
				if(person.getAge()>=18){
					women--;
					mainTabController.women.setText(Integer.toString(women));
				}else{
					womenU18--;
					mainTabController.womenU18.setText(Integer.toString(womenU18));
				}
			}
		}		
	}
	
	public void teamCounter(boolean addTeam){
		if(addTeam==true){
			amountOfTeams++;			
		}else{
			amountOfTeams--;
		}
		mainTabController.teams.setText(Integer.toString(amountOfTeams));
	}
	
	
	//TODO: separate serieCounter to its own method
	public void sportAndSerieCounter(boolean add, int sarjat){
		if(add==true){
			amountOfSports++;
			amountOfSeries=amountOfSeries+sarjat;
		}else{
			//you cannot delete sport in the program. yet.
		}
		mainTabController.sports.setText(Integer.toString(amountOfSports));
		mainTabController.series.setText(Integer.toString(amountOfSeries));
	}
	
	
	
	
}
