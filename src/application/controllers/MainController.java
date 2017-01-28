package application.controllers;


import application.model.*;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;




public class MainController{
	
	Kilpailu kilpailu;
	
	KilpailijoidenLisaaminenLajiinController kilpailijoidenLisaaminenLajiinController; 
	@FXML HenkiloTabController henkiloTabController;
	@FXML JoukkueTabController joukkueTabController; 
	@FXML LajiTabController lajiTabController;
	@FXML MainTabController mainTabController;
	@FXML TreeViewController treeViewViewController;
	@FXML ListViewController listViewController;
	@FXML MenuAndToolbarController menuAndToolbarController;
	
	
	@FXML TabPane tabPane;
	
	ArrayList<Kilpailija> kilpailijat = new ArrayList<Kilpailija>();
	ArrayList<Henkilo> henkilot = new ArrayList<Henkilo>();
	ArrayList<Joukkue> joukkueet = new ArrayList<Joukkue>();
	ArrayList<Laji> lajit = new ArrayList<Laji>(); 
		
	
	
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
	
	
	
	public void henkiloLaskuri(Henkilo henkilo, Boolean etumerkki){
		if(etumerkki==true){
			kilpailijoidenLKM++;
			mainTabController.kilpailijoita.setText(Integer.toString(kilpailijoidenLKM));
			if(henkilo.kerroSukupuoli().equals("Mies")){
				if(henkilo.kerroIka()>=18){
					miestenLKM++;
					mainTabController.miehia.setText(Integer.toString(miestenLKM));				
				}else {
					miestenU18LKM++;
					mainTabController.miehiaU18.setText(Integer.toString(miestenU18LKM));
				}
			}else{
				if(henkilo.kerroIka()>=18){
					naistenLKM++;
					mainTabController.naisia.setText(Integer.toString(naistenLKM));
				}else{
					naistenU18LKM++;
					mainTabController.naisiaU18.setText(Integer.toString(naistenU18LKM));
				}
			}
		}else{			
			kilpailijoidenLKM--;
			mainTabController.kilpailijoita.setText(Integer.toString(kilpailijoidenLKM));
			
			if(henkilo.kerroSukupuoli().equals("Mies")){
				if(henkilo.kerroIka()>=18){
					miestenLKM--;
					mainTabController.miehia.setText(Integer.toString(miestenLKM));				
				}else {
					miestenU18LKM--;
					mainTabController.miehiaU18.setText(Integer.toString(miestenU18LKM));
				}
			}else{
				if(henkilo.kerroIka()>=18){
					naistenLKM--;
					mainTabController.naisia.setText(Integer.toString(naistenLKM));
				}else{
					naistenU18LKM--;
					mainTabController.naisiaU18.setText(Integer.toString(naistenU18LKM));
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
		mainTabController.joukkueita.setText(Integer.toString(joukkueidenLKM));
	}
	
	
	public void lajiJaSarjaLaskuri(boolean etumerkki, int sarjat){
		if(etumerkki==true){
			lajienLKM++;
			sarjojenLKM=sarjojenLKM+sarjat;
		}else{
			
		}
		mainTabController.lajeja.setText(Integer.toString(lajienLKM));
		mainTabController.sarjoja.setText(Integer.toString(sarjojenLKM));
	}
	
	public void lisaaLajiPuunakymaan(Laji laji){
		treeViewViewController.lisaaLajiOlioPuunakymaan(laji);
		treeViewViewController.lisaaTuloksetPuunakymaan(laji);
	}
	
	
	
	public void poistaHenkilo(String nimi){
		Kilpailija kilpailija = haeKilpailija(nimi);	
		if(kilpailija!=null){
			kilpailijat.remove(kilpailija);
			henkiloLaskuri(kilpailija, false);
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
	
	public Sarja haeSarja(Laji laji, String sarjanNimi){
		Sarja sarja=null;
		switch(sarjanNimi){
		case "Yleissarja" : sarja = laji.yleisSarja;
			break;
		case "Miesten sarja" : sarja = laji.miestenYleisSarja ;
			break;
		case "Miesten sarja U18" : sarja = laji.miestenU18Sarja;
			break;
		case "Naisten sarja" : sarja = laji.naistenYleisSarja;
			break;
		case "Naisten sarja U18" : sarja=laji.naistenU18Sarja;
			break;
		
		}				
		return sarja;
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
		menuAndToolbarController.init(this);
		
	}
	
	
	
	public void printtaa(){
		System.out.println("Toimii");
	}
	
	public void lataaKilpailu(Kilpailu uusiKilpailu){
		this.kilpailu=uusiKilpailu;
		
		kilpailijat = uusiKilpailu.kilpailijat;
		henkilot = uusiKilpailu.henkilot;
		joukkueet = uusiKilpailu.joukkueet;
		lajit = uusiKilpailu.lajit; 
		
		treeViewViewController.setKilpailunNimi(kilpailu.getNimi());
	}
	
	
}
