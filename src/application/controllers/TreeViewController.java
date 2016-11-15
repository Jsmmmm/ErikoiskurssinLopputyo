package application.controllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.InputStream;

import application.model.*;

public class TreeViewController{

	MainController main;

	
	private final Image kilpailijaIcon = new Image(getClass().getResourceAsStream("/application/icons/userIcon.png"));
	private final Image joukkueIcon = new Image(getClass().getResourceAsStream("/application/icons/teamIcon.png"));
	private final Image lajiIcon = new Image(getClass().getResourceAsStream("/application/icons/sportsIcon.png"));
	private final Image trophyIcon = new Image(getClass().getResourceAsStream("/application/icons/trophyIcon.jpg"));
	
	
	
	@FXML
	TreeView<String> treeView;	
	TreeItem<String> root = new TreeItem<>();
	TreeItem<String> kilpailijatLehti = new TreeItem<>("Kilpailijat", new ImageView(kilpailijaIcon));
	TreeItem<String> joukkueetLehti = new TreeItem<>("Joukkueet", new ImageView(joukkueIcon));
	TreeItem<String> lajiLehti = new TreeItem<>("Lajit", new ImageView(lajiIcon));
	TreeItem<String> tulosLehti = new TreeItem<>("Tulokset", new ImageView(trophyIcon));
	
	
	
	public void lisaaHenkiloOlioPuunakymaan(Kilpailija kilpailija){
		kilpailijatLehti.getChildren().add(new TreeItem<>(kilpailija.toString()));
	}
	
	
	public void lisaaJoukkueOlioPuunakymaan(Joukkue joukkue){
		joukkueetLehti.getChildren().add(new TreeItem<>(joukkue.toString()));
	}
	
	
	public void lisaaLajiOlioPuunakymaan(Laji laji){
		TreeItem<String> lajiOlio = new TreeItem<>(laji.toString());
		lajiLehti.getChildren().add(lajiOlio);	
	}
	
	
	public void init(MainController mainController){
		main=mainController;
	}
	
	
	public void lisaaTuloksetPuunakymaan(Laji laji){
	TreeItem<String> lajinTulokset = new TreeItem<>(laji.toString());
		tulosLehti.getChildren().add(lajinTulokset);
		
		if(laji.booleanYleisSarja){
			lajinTulokset.getChildren().add(new TreeItem<>("Yleissarja"));
		}
			
		if(laji.booleanMiestenSarja){
			lajinTulokset.getChildren().add(new TreeItem<>("Miesten sarja"));
		}
		if(laji.booleanNaistenSarja){
			lajinTulokset.getChildren().add(new TreeItem<>("Naisten sarja"));
		}
		if(laji.booleanNaistenU18){
			lajinTulokset.getChildren().add(new TreeItem<>("Naisten sarja U18"));
		}
		if(laji.booleanMiestenU18){
			lajinTulokset.getChildren().add(new TreeItem<>("Miesten sarja U18"));
		}
		
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
				
				try{				
					Tab tab = new Tab();
					
					main.tabPane.getTabs().add(tab);
					FXMLLoader loader= new FXMLLoader(getClass().getResource("/application/view/HenkiloTab.fxml" ));
					tab.setContent(loader.load());				
					HenkiloTabController controller = loader.<HenkiloTabController>getController();
					controller.init(main, tab);
					controller.avaaHenkilonTiedot(main.haeKilpailija(klikattuKohde.getValue()));
					tab.setText(klikattuKohde.getValue());
					tab.isClosable();
					//return tab;
				}catch(Exception e){
					e.printStackTrace();
				}
				
				
			} else if (klikattuKohde.getParent() == joukkueetLehti) {
				
				try{				
					Tab tab = new Tab();
					
					main.tabPane.getTabs().add(tab);
					FXMLLoader loader= new FXMLLoader(getClass().getResource("/application/view/JoukkueTab.fxml" ));
					tab.setContent(loader.load());				
					JoukkueTabController controller = loader.<JoukkueTabController>getController();					
					controller.init(main, tab);
					controller.avaaJoukkueenTiedot(main.haeJoukkue(klikattuKohde.getValue()));
					tab.setText(klikattuKohde.getValue());
					tab.isClosable();
				}catch(Exception e){
					e.printStackTrace();
				}
				
			} else if (klikattuKohde.getParent() == lajiLehti) {
				try{				
					Tab tab = new Tab();
					
					main.tabPane.getTabs().add(tab);
					FXMLLoader loader= new FXMLLoader(getClass().getResource("/application/view/LajiTab.fxml" ));
					tab.setContent(loader.load());				
					LajiTabController controller = loader.<LajiTabController>getController();	
					controller.init(main);
					controller.avaaLajinTiedot(main.haeLaji(klikattuKohde.getValue()));
					tab.setText(klikattuKohde.getValue());
					tab.isClosable();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			else if(klikattuKohde.getParent().getParent() == tulosLehti){
				try{
					
					Tab tab = new Tab();					
					main.tabPane.getTabs().add(tab);
					FXMLLoader loader= new FXMLLoader(getClass().getResource("/application/view/SarjaTab.fxml" ));
					tab.setContent(loader.load());				
					SarjaTabController controller = loader.<SarjaTabController>getController();	
					
				
					Laji laji = main.haeLaji(klikattuKohde.getParent().getValue());
					Sarja sarja = main.haeSarja(laji, klikattuKohde.getValue());
					controller.init(main, sarja, laji);
					controller.taytaListView();
					controller.asetaNimi();
					tab.setText(laji.toString()+": "+sarja.toString());
					tab.isClosable();
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
	@FXML
	public void initialize() {
		root.getChildren().addAll(kilpailijatLehti, joukkueetLehti, lajiLehti, tulosLehti);
		
		treeView.setRoot(root);
		root.setExpanded(true);
		kilpailijatLehti.setExpanded(true);
		joukkueetLehti.setExpanded(true);
		lajiLehti.setExpanded(true);
		tulosLehti.setExpanded(true);
	}
	
	
	
	
}
