package application.controllers;


import application.model.*;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;



//this class still needs to be translated to english
public class MainController{
	
	Competition competition;
	
	AddPersonToSportController addPersonToSportController; 
	@FXML PersonTabController personTabController;
	@FXML TeamTabController teamTabController; 
	@FXML SportTabController sportTabController;
	@FXML MainTabController mainTabController;
	@FXML TreeViewController treeViewViewController;
	@FXML ListViewController listViewController;
	@FXML MenuAndToolbarController menuAndToolbarController;
	
	
	@FXML TabPane tabPane;
	
	ArrayList<Competitor> competitors = new ArrayList<Competitor>();
	ArrayList<Person> persons = new ArrayList<Person>();	//persons&competitors seperate arraylists because of future use. //toimihenkilöt
	ArrayList<Team> teams = new ArrayList<Team>();
	ArrayList<Sport> sports = new ArrayList<Sport>(); 
		
	
	
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
			competitors.remove(kilpailija);
			henkiloLaskuri(kilpailija, false);
		}else System.out.println("Virhe tuli poistettaessa kilpailijaa");					
	}
	
	public void poistaJoukkue(String nimi){
		Team joukkue = haeJoukkue(nimi);
		if(joukkue!=null){
			teams.remove(joukkue);
		} else System.out.println("Virhe tuli poistettaessa joukkuetta");							
	}
	
	public void poistaLaji(String nimi){
		Sport laji = haeLaji(nimi);		
		if(laji!=null){
			sports.remove(laji);	
		}else System.out.println("Virhe tuli poistettaessa lajia");										
	}
	
	
	public Sport haeLaji(String lajinNimi){
		Sport laji=null;
		for (Sport haettavaLaji : sports) {
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
		for (Competitor kilpailija2 : competitors) {
			if (kilpailija2.getFirstName().equals(etunimi) && kilpailija2.getLastName().equals(sukunimi) && kilpailija2.getCompetitorNumber()==(number)) {
				kilpailija=kilpailija2;				
				}			
		}return kilpailija;
	}
	
	
	
	
	public Team haeJoukkue(String joukkueenNimi){
		Team joukkue = null;
		for(Team haettavaJoukkue : teams){
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
		listViewController.taytaListView(); //KESKEN KESKEN KESKEN KESKEN KESKEN KESKEN KESKEN
	}
	
	public void avaaJoukkueenTiedot(String joukkueenNimi){
		Team joukkue = haeJoukkue(joukkueenNimi);
		teamTabController.openTeamInformation(joukkue);
	}
	
	
	
	@FXML
	public void initialize() {
		
		treeViewViewController.init(this);
		listViewController.init(this);
		mainTabController.init(this);
		menuAndToolbarController.init(this);
		
	}
	
	
	
	public void printtaa(){
		System.out.println("Toimii");
	}
	
	public void lataaKilpailu(Competition uusiKilpailu){
		this.competition=uusiKilpailu;
		
		competitors = uusiKilpailu.competitors;
		persons = uusiKilpailu.persons;
		teams = uusiKilpailu.teams;
		sports = uusiKilpailu.sports; 
		
		treeViewViewController.setKilpailunNimi(competition.getName());
	}
	
	
}
