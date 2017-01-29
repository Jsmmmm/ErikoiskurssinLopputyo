package application.controllers;


import application.model.*;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;




public class MainController{
	
	Competition kilpailu;
	
	AddPersonToSportController kilpailijoidenLisaaminenLajiinController; 
	@FXML PersonTabController henkiloTabController;
	@FXML TeamTabController joukkueTabController; 
	@FXML SportTabController lajiTabController;
	@FXML MainTabController mainTabController;
	@FXML TreeViewController treeViewViewController;
	@FXML ListViewController listViewController;
	@FXML MenuAndToolbarController menuAndToolbarController;
	
	
	@FXML TabPane tabPane;
	
	ArrayList<Competitor> kilpailijat = new ArrayList<Competitor>();
	ArrayList<Person> henkilot = new ArrayList<Person>();
	ArrayList<Team> joukkueet = new ArrayList<Team>();
	ArrayList<Sport> lajit = new ArrayList<Sport>(); 
		
	
	
	int kilpailijoidenLKM;
	int miestenLKM;
	int naistenLKM;
	int miestenU18LKM;
	int naistenU18LKM;
	int lajienLKM;
	int sarjojenLKM;
	int joukkueidenLKM;
	
	@FXML Tab lajiValilehti;
	@FXML Tab joukkueValilehti;
	@FXML Tab henkiloValilehti;
	@FXML Tab mainValilehti;
	
	
	
	public void henkiloLaskuri(Person henkilo, Boolean etumerkki){
		if(etumerkki==true){
			kilpailijoidenLKM++;
			mainTabController.competitors.setText(Integer.toString(kilpailijoidenLKM));
			if(henkilo.getGender().equals("Mies")){
				if(henkilo.getAge()>=18){
					miestenLKM++;
					mainTabController.men.setText(Integer.toString(miestenLKM));				
				}else {
					miestenU18LKM++;
					mainTabController.menU18.setText(Integer.toString(miestenU18LKM));
				}
			}else{
				if(henkilo.getAge()>=18){
					naistenLKM++;
					mainTabController.women.setText(Integer.toString(naistenLKM));
				}else{
					naistenU18LKM++;
					mainTabController.womenU18.setText(Integer.toString(naistenU18LKM));
				}
			}
		}else{			
			kilpailijoidenLKM--;
			mainTabController.competitors.setText(Integer.toString(kilpailijoidenLKM));
			
			if(henkilo.getGender().equals("Mies")){
				if(henkilo.getAge()>=18){
					miestenLKM--;
					mainTabController.men.setText(Integer.toString(miestenLKM));				
				}else {
					miestenU18LKM--;
					mainTabController.menU18.setText(Integer.toString(miestenU18LKM));
				}
			}else{
				if(henkilo.getAge()>=18){
					naistenLKM--;
					mainTabController.women.setText(Integer.toString(naistenLKM));
				}else{
					naistenU18LKM--;
					mainTabController.womenU18.setText(Integer.toString(naistenU18LKM));
				}
			}
		}		
	}
	
	public void joukkueLaskuri(boolean etumerkki){
		if(etumerkki==true){
			joukkueidenLKM++;			
		}else{
			joukkueidenLKM--;
		}
		mainTabController.teams.setText(Integer.toString(joukkueidenLKM));
	}
	
	
	public void lajiJaSarjaLaskuri(boolean etumerkki, int sarjat){
		if(etumerkki==true){
			lajienLKM++;
			sarjojenLKM=sarjojenLKM+sarjat;
		}else{
			
		}
		mainTabController.sports.setText(Integer.toString(lajienLKM));
		mainTabController.series.setText(Integer.toString(sarjojenLKM));
	}
	
	public void lisaaLajiPuunakymaan(Sport laji){
		treeViewViewController.addSportToTW(laji);
		treeViewViewController.addResultsToTW(laji);
	}
	
	
	
	public void poistaHenkilo(String nimi){
		Competitor kilpailija = haeKilpailija(nimi);	
		if(kilpailija!=null){
			kilpailijat.remove(kilpailija);
			henkiloLaskuri(kilpailija, false);
		}else System.out.println("Virhe tuli poistettaessa kilpailijaa");					
	}
	
	public void poistaJoukkue(String nimi){
		Team joukkue = haeJoukkue(nimi);
		if(joukkue!=null){
			joukkueet.remove(joukkue);
		} else System.out.println("Virhe tuli poistettaessa joukkuetta");							
	}
	
	public void poistaLaji(String nimi){
		Sport laji = haeLaji(nimi);		
		if(laji!=null){
			lajit.remove(laji);	
		}else System.out.println("Virhe tuli poistettaessa lajia");										
	}
	
	
	public Sport haeLaji(String lajinNimi){
		Sport laji=null;
		for (Sport haettavaLaji : lajit) {
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
		for (Competitor kilpailija2 : kilpailijat) {
			if (kilpailija2.getFirstName().equals(etunimi) && kilpailija2.getLastName().equals(sukunimi)) {
				kilpailija=kilpailija2;				
				}			
		}return kilpailija;
	}
	
	public Team haeJoukkue(String joukkueenNimi){
		Team joukkue = null;
		for(Team haettavaJoukkue : joukkueet){
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
		henkiloTabController.openPersonInformation(kilpailija);
	}
	
	public void avaaLajinTiedot(String lajinNimi){
		Sport laji = haeLaji(lajinNimi);
		lajiTabController.openInformationOfSport(laji);
		listViewController.taytaListView(); //KESKEN KESKEN KESKEN KESKEN KESKEN KESKEN KESKEN
	}
	
	public void avaaJoukkueenTiedot(String joukkueenNimi){
		Team joukkue = haeJoukkue(joukkueenNimi);
		joukkueTabController.openTeamInformation(joukkue);
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
		this.kilpailu=uusiKilpailu;
		
		kilpailijat = uusiKilpailu.competitors;
		henkilot = uusiKilpailu.persons;
		joukkueet = uusiKilpailu.teams;
		lajit = uusiKilpailu.sports; 
		
		treeViewViewController.setKilpailunNimi(kilpailu.getName());
	}
	
	
}
