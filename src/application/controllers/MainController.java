package application.controllers;


import application.model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;



//this class still needs to be translated to english
public class MainController{
	
	public Competition competition;
	
	AddPersonToSportController addPersonToSportController; 
	@FXML PersonTabController personTabController;
	@FXML TeamTabController teamTabController; 
	@FXML SportTabController sportTabController;
	@FXML MainTabController mainTabController;
	@FXML TreeViewController treeViewViewController;
	@FXML ListViewController listViewController;
	@FXML MenuAndToolbarController menuAndToolbarController;
	
	
	@FXML TabPane tabPane;
	
	
	int amountOfCompetitors;
	int men;
	int women;
	int menU18;
	int womenU18;
	int amountOfSports;
	int amountOfSeries;
	int amountOfTeams;
	
	@FXML Tab lajiValilehti;
	@FXML Tab joukkueValilehti;
	@FXML Tab henkiloValilehti;
	@FXML Tab mainValilehti;
	
	
	
	public void henkiloLaskuri(Person henkilo, Boolean etumerkki){
		if(etumerkki==true){
			amountOfCompetitors++;
			mainTabController.competitors.setText(Integer.toString(amountOfCompetitors));
			if(henkilo.isMale()){
				if(henkilo.getAge()>=18){
					men++;
					mainTabController.men.setText(Integer.toString(men));				
				}else {
					menU18++;
					mainTabController.menU18.setText(Integer.toString(menU18));
				}
			}else{
				if(henkilo.getAge()>=18){
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
			
			if(henkilo.isMale()){
				if(henkilo.getAge()>=18){
					men--;
					mainTabController.men.setText(Integer.toString(men));				
				}else {
					menU18--;
					mainTabController.menU18.setText(Integer.toString(menU18));
				}
			}else{
				if(henkilo.getAge()>=18){
					women--;
					mainTabController.women.setText(Integer.toString(women));
				}else{
					womenU18--;
					mainTabController.womenU18.setText(Integer.toString(womenU18));
				}
			}
		}		
	}
	
	public void joukkueLaskuri(boolean etumerkki){
		if(etumerkki==true){
			amountOfTeams++;			
		}else{
			amountOfTeams--;
		}
		mainTabController.teams.setText(Integer.toString(amountOfTeams));
	}
	
	
	public void lajiJaSarjaLaskuri(boolean etumerkki, int sarjat){
		if(etumerkki==true){
			amountOfSports++;
			amountOfSeries=amountOfSeries+sarjat;
		}else{
			
		}
		mainTabController.sports.setText(Integer.toString(amountOfSports));
		mainTabController.series.setText(Integer.toString(amountOfSeries));
	}
	
	public void lisaaLajiPuunakymaan(Sport laji){
		
		treeViewViewController.addSportToTW(laji);
		treeViewViewController.addResultsToTW(laji);
	}
	
	
	
	public void poistaHenkilo(String nimi){
		Competitor kilpailija = haeKilpailija(nimi);	
		if(kilpailija!=null){
			competition.competitors.remove(kilpailija);
			henkiloLaskuri(kilpailija, false);
		}else System.out.println("Virhe tuli poistettaessa kilpailijaa");					
	}
	
	public void poistaJoukkue(String nimi){
		Team joukkue = haeJoukkue(nimi);
		if(joukkue!=null){
			competition.teams.remove(joukkue);
		} else System.out.println("Virhe tuli poistettaessa joukkuetta");							
	}
	
	public void poistaLaji(String nimi){
		Sport laji = haeLaji(nimi);		
		if(laji!=null){
			competition.sports.remove(laji);	
		}else System.out.println("Virhe tuli poistettaessa lajia");										
	}
	
	
	public Sport haeLaji(String lajinNimi){
		Sport laji=null;
		for (Sport haettavaLaji : competition.sports) {
			if (lajinNimi.equals(haettavaLaji.toString())) {
				laji=haettavaLaji;			
				} 
		}return laji;		
	}
	
	
	public Competitor haeKilpailija(String kilpailijanNimi){
		
		Competitor kilpailija=null;
		String nimi[] = kilpailijanNimi.split(" ");
		String etunimi = nimi[0];
		String sukunimi = nimi[1];
		int number =Integer.parseInt(nimi[2].substring(1));
		for (Competitor kilpailija2 : competition.competitors) {
			if (kilpailija2.getFirstName().equals(etunimi) && kilpailija2.getLastName().equals(sukunimi) && kilpailija2.getCompetitorNumber()==(number)) {
				kilpailija=kilpailija2;				
				}			
		}return kilpailija;
	}
	
	
	
	
	public Team haeJoukkue(String joukkueenNimi){
		Team joukkue = null;
		for(Team haettavaJoukkue : competition.teams){
			if(joukkueenNimi.equals(haettavaJoukkue.toString())){
				joukkue=haettavaJoukkue;
			}
		}return joukkue;
	}
	
	public Serie haeSarja(Sport laji, String sarjanNimi){
		Serie sarja=null;
		switch(sarjanNimi){
		case "General series" : sarja = laji.general;
			break;
		case "Men's series" : sarja = laji.mens ;
			break;
		case "Men's U-18" : sarja = laji.mensU18;
			break;
		case "Women's series" : sarja = laji.womens;
			break;
		case "Women's U-18" : sarja=laji.womensU18;
			break;
		
		}				
		return sarja;
	}
	
	public void avaaKilpailijanTiedot(String kilpailijanNimi){
		Competitor kilpailija = haeKilpailija(kilpailijanNimi);
		personTabController.openPersonInformation(kilpailija);
	}
	
	public void avaaLajinTiedot(String lajinNimi){
		Sport laji = haeLaji(lajinNimi);
		sportTabController.openInformationOfSport(laji);
	//	listViewController.taytaListView(); //KESKEN
	}
	
	public void avaaJoukkueenTiedot(String joukkueenNimi){
		Team joukkue = haeJoukkue(joukkueenNimi);
		teamTabController.openTeamInformation(joukkue);
	}
	
	
	
	@FXML
	public void initialize() {
		openOpeningWindow();
		treeViewViewController.init(this);
		listViewController.init(this);
		mainTabController.init(this);
		menuAndToolbarController.init(this);
		
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
			
			// return stage; //viittaus avautuneeseen ikkunaan jos halutaan myï¿½hemmin pï¿½ï¿½stï¿½ siihen kï¿½siksi tï¿½stï¿½ luokasta
		}
		catch(Exception i){
			i.printStackTrace();
		}
		
	}
	
	
	
	public void printtaa(){
		System.out.println("toimii");
	}
	
	
	public void uusiKilpailu(Competition competition){
		
		this.competition=competition;
		
		//competition.competitors = new ArrayList<Competitor>();
		//competition.persons = new ArrayList<Person>();	//persons&competitors seperate arraylists because of future use. //toimihenkilöt
		//competition.teams = new ArrayList<Team>();
		//competition.sports = new ArrayList<Sport>(); 
		
	}
	
	
	
	//pitäsköhän vasta tässä vaiheessa luoda arraylistit, eika mainControllerissa.  
	public void lataaKilpailu(Competition loadedCompetition){
		
		//lisää tähän metodiin: ennen treeView:hen tietojenlataamista tyhjennä treeView!
		
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
	
	
	
}
