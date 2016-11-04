package application.controllers;


import application.model.*;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;




public class MainController{
	
	KilpailijoidenLisaaminenLajiinController kilpailijoidenLisaaminenLajiinController; 
	@FXML HenkiloTabController henkiloTabController;
	@FXML JoukkueTabController joukkueTabController; 
	@FXML LajiTabController lajiTabController;
	@FXML MainTabController mainTabController;
	@FXML TreeViewController treeViewViewController;
	@FXML ListViewController listViewController;
	
	@FXML TabPane tabPane;
	
	ArrayList<Kilpailija> kilpailijat = new ArrayList<Kilpailija>();
	ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();
	ArrayList<Joukkue> joukkueet = new ArrayList<Joukkue>();
	ArrayList<Laji> lajit = new ArrayList<Laji>(); 
	
	@FXML
	Button tallenna;
	Button tyhjenna;
	Button poista;
	
	//int kilpailijoidenLKM;
	
	@FXML
	Tab lajiValilehti;
	@FXML
	Tab joukkueValilehti;
	@FXML
	Tab henkiloValilehti;
	@FXML
	Tab mainValilehti;
	
	
	public void avaaUusiValilehti(){
		
	}
	
	public void lisaaLajiPuunakymaan(Laji laji){
		treeViewViewController.lisaaLajiOlioPuunakymaan(laji);
	}
	
	public void paivitaStatsit(){
		mainTabController.kilpailijoita.setText( Integer.toString(kilpailijat.size()) );
		mainTabController.joukkueita.setText( Integer.toString(joukkueet.size()) );
	}
	
	public void poistaHenkilo(String nimi){
		Kilpailija kilpailija = haeKilpailija(nimi);	
		if(kilpailija!=null){
			kilpailijat.remove(kilpailija); 
		}else System.out.println("Virhe tuli poistettaessa kilpailijaa");					
	}
	
	public void poistaJoukkue(String nimi){
		Joukkue joukkue = haeJoukkue(nimi);
		if(joukkue!=null){
			joukkueet.remove(joukkue);
		} else System.out.println("Virhe tuli poistettaessa joukkuetta");							
	}
	
	public void poistaLaji(String nimi){
		Laji laji = haeLaji(nimi);		
		if(laji!=null){
			lajit.remove(laji);	
		}else System.out.println("Virhe tuli poistettaessa lajia");										
	}
	
	
	public Laji haeLaji(String lajinNimi){
		Laji laji=null;
		for (Laji haettavaLaji : lajit) {
			if (lajinNimi.equals(haettavaLaji.toString())) {
				laji=haettavaLaji;			
				} 
		}return laji;		
	}
	
	
	public Kilpailija haeKilpailija(String kilpailijanNimi){
		Kilpailija kilpailija=null;
		String nimi[] = kilpailijanNimi.split(" ");
		String etunimi = nimi[0];
		String sukunimi = nimi[1];
		for (Kilpailija kilpailija2 : kilpailijat) {
			if (kilpailija2.kerroEtunimi().equals(etunimi) && kilpailija2.kerroSukunimi().equals(sukunimi)) {
				kilpailija=kilpailija2;				
				}			
		}return kilpailija;
	}
	
	public Joukkue haeJoukkue(String joukkueenNimi){
		Joukkue joukkue = null;
		for(Joukkue haettavaJoukkue : joukkueet){
			if(joukkueenNimi.equals(haettavaJoukkue.toString())){
				joukkue=haettavaJoukkue;
			}
		}return joukkue;
	}
	
	public void avaaKilpailijanTiedot(String kilpailijanNimi){
		Kilpailija kilpailija = haeKilpailija(kilpailijanNimi);
		henkiloTabController.avaaHenkilonTiedot(kilpailija);
	}
	
	public void avaaLajinTiedot(String lajinNimi){
		Laji laji = haeLaji(lajinNimi);
		lajiTabController.avaaLajinTiedot(laji);
		listViewController.taytaListView(); //KESKEN KESKEN KESKEN KESKEN KESKEN KESKEN KESKEN
	}
	
	public void avaaJoukkueenTiedot(String joukkueenNimi){
		Joukkue joukkue = haeJoukkue(joukkueenNimi);
		joukkueTabController.avaaJoukkueenTiedot(joukkue);
	}
	
	@FXML
	public void initialize() {
	
		treeViewViewController.init(this);
		listViewController.init(this);
		mainTabController.init(this);
		
	}
	
	public void printtaa(){
		System.out.println("Toimii");
	}
	
	
	
}
