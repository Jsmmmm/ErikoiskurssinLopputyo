package application.controllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import application.model.*;

public class TreeViewController{

	MainController main;
	
	@FXML
	TreeView<String> treeView;	
	TreeItem<String> root = new TreeItem<>();
	TreeItem<String> kilpailijatLehti = new TreeItem<>("Kilpailijat");
	TreeItem<String> joukkueetLehti = new TreeItem<>("Joukkueet");
	TreeItem<String> lajiLehti = new TreeItem<>("Lajit");
	
	public void lisaaHenkiloOlioPuunakymaan(Kilpailija kilpailija){
		kilpailijatLehti.getChildren().add(new TreeItem<>(kilpailija.toString()));
	}
	
	public void lisaaJoukkueOlioPuunakymaan(Joukkue joukkue){
		joukkueetLehti.getChildren().add(new TreeItem<>(joukkue.toString()));
	}
	
	public void lisaaLajiOlioPuunakymaan(Laji laji){
		lajiLehti.getChildren().add(new TreeItem<>(laji.toString()));
	}
	
	public void init(MainController mainController){
		main=mainController;
	}
	
	
	public void poista(ActionEvent e){
		TreeItem<String> poistettava = treeView.getSelectionModel().getSelectedItem();		
		if(treeView.getSelectionModel().getSelectedItem().getParent() == kilpailijatLehti){
			poistettava.getParent().getChildren().remove(poistettava);
			main.poistaHenkilo(poistettava.getValue());	
			
		}else if(treeView.getSelectionModel().getSelectedItem().getParent() == joukkueetLehti){
			poistettava.getParent().getChildren().remove(poistettava);
			main.poistaJoukkue(poistettava.getValue());
			
		}else if(treeView.getSelectionModel().getSelectedItem().getParent() == lajiLehti){
			poistettava.getParent().getChildren().remove(poistettava);
			main.poistaLaji(poistettava.getValue());
			
		}
	}
	
	
	public void aktivoiKlikatunKohteenValilehti(MouseEvent mouseEvent){
		if (mouseEvent.getClickCount() == 2) {
			TreeItem<String> klikattuKohde = treeView.getSelectionModel().getSelectedItem();

			if (klikattuKohde.getParent() == kilpailijatLehti) {
				main.tabPane.getSelectionModel().select(main.henkiloValilehti);
				
				//main.tabPane.getTabs().add(main.henkiloValilehti);
				main.avaaKilpailijanTiedot(klikattuKohde.getValue());
				
			} else if (klikattuKohde.getParent() == joukkueetLehti) {
				main.tabPane.getSelectionModel().select(main.joukkueValilehti);
				main.avaaJoukkueenTiedot(klikattuKohde.getValue());
				
			} else if (klikattuKohde.getParent() == lajiLehti) {
				main.tabPane.getSelectionModel().select(main.lajiValilehti);
				main.avaaLajinTiedot(klikattuKohde.getValue());
			}
		}
	}
	
	
	
	
	@FXML
	public void initialize() {
		root.getChildren().addAll(kilpailijatLehti, joukkueetLehti, lajiLehti);
		treeView.setRoot(root);
		root.setExpanded(true);
		kilpailijatLehti.setExpanded(true);
		joukkueetLehti.setExpanded(true);
		lajiLehti.setExpanded(true);
	}
	
	
	
	
}
