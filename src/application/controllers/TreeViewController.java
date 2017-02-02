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
	
	
	  Image kilpailijaIcon = new Image(getClass().getResourceAsStream("/application/Icons/Treeview_icons/userIcon.png"));
	  Image joukkueIcon = new Image(getClass().getResourceAsStream("/application/Icons/Treeview_icons/teamIcon.png"));
	  Image lajiIcon = new Image(getClass().getResourceAsStream("/application/Icons/Treeview_icons/sportsIcon.png"));
	  Image trophyIcon = new Image(getClass().getResourceAsStream("/application/Icons/Treeview_icons/trophyIcon.jpg"));
	
	
	
	@FXML
	TreeView<String> treeView;	
	TreeItem<String> root = new TreeItem<>();
	TreeItem<String> competitorsLeaf = new TreeItem<>("Competitors", new ImageView(kilpailijaIcon));
	TreeItem<String> teamsLeaf = new TreeItem<>("Teams", new ImageView(joukkueIcon));
	TreeItem<String> sportsLeaf = new TreeItem<>("Sports", new ImageView(lajiIcon));
	TreeItem<String> resultsLeaf = new TreeItem<>("Scoreboards", new ImageView(trophyIcon));
	
	
	
	public void addCompetitorToTW(Competitor competitor){
		competitorsLeaf.getChildren().add(new TreeItem<>(competitor.toString()));
	}
	
	
	public void addTeamToTW(Team team){
		teamsLeaf.getChildren().add(new TreeItem<>(team.toString()));
	}
	
	
	public void addSportToTW(Sport sport){
		TreeItem<String> lajiOlio = new TreeItem<>(sport.toString());
		sportsLeaf.getChildren().add(lajiOlio);	
	}
	
	
	public void init(MainController mainController){
		main=mainController;
	}
	
	
	public void addResultsToTW(Sport sport){
	TreeItem<String> results = new TreeItem<>(sport.toString());
		resultsLeaf.getChildren().add(results);
		
		if(sport.booleanGeneral){
			results.getChildren().add(new TreeItem<>("General series"));
		}
			
		if(sport.booleanMens){
			results.getChildren().add(new TreeItem<>("Men's series"));
		}
		if(sport.booleanWomens){
			results.getChildren().add(new TreeItem<>("Women's series"));
		}
		if(sport.booleanWomensU18){
			results.getChildren().add(new TreeItem<>("Women's U-18"));
		}
		if(sport.booleanMensU18){
			results.getChildren().add(new TreeItem<>("Men's U-18"));
		}
		
	}
	
	public void delete(ActionEvent e){
		TreeItem<String> toBeRemoved = treeView.getSelectionModel().getSelectedItem();		
		if(treeView.getSelectionModel().getSelectedItem().getParent() == competitorsLeaf){
			toBeRemoved.getParent().getChildren().remove(toBeRemoved);
			main.poistaHenkilo(toBeRemoved.getValue());	
			
			
		}else if(treeView.getSelectionModel().getSelectedItem().getParent() == teamsLeaf){
			toBeRemoved.getParent().getChildren().remove(toBeRemoved);
			main.poistaJoukkue(toBeRemoved.getValue());
			
		}else if(treeView.getSelectionModel().getSelectedItem().getParent() == sportsLeaf){
			toBeRemoved.getParent().getChildren().remove(toBeRemoved);
			main.poistaLaji(toBeRemoved.getValue());
			
		}
	}
	
	
	public void openTabByClickingTW(MouseEvent mouseEvent){
		if (mouseEvent.getClickCount() == 2) {
			TreeItem<String> target = treeView.getSelectionModel().getSelectedItem();
			if(target!=root){
				if (target.getParent() == competitorsLeaf) {
					
					try{				
						Tab tab = new Tab();
						
						main.tabPane.getTabs().add(tab);
						FXMLLoader loader= new FXMLLoader(getClass().getResource("/application/view/PersonTab.fxml" ));
						tab.setContent((Node) loader.load());				
						PersonTabController controller = loader.<PersonTabController>getController();
						controller.init(main, tab);
						controller.openPersonInformation(main.haeKilpailija(target.getValue()));
						tab.setText(target.getValue());
						tab.isClosable();
						//return tab;
					}catch(Exception e){
						e.printStackTrace();
					}
					
					
				} else if (target.getParent() == teamsLeaf) {
					
					try{				
						Tab tab = new Tab();
						
						main.tabPane.getTabs().add(tab);
						FXMLLoader loader= new FXMLLoader(getClass().getResource("/application/view/TeamTab.fxml" ));
						tab.setContent((Node) loader.load());				
						TeamTabController controller = loader.<TeamTabController>getController();					
						controller.init(main, tab);
						controller.openTeamInformation(main.haeJoukkue(target.getValue()));
						tab.setText(target.getValue());
						tab.isClosable();
					}catch(Exception e){
						e.printStackTrace();
					}
					
				} else if (target.getParent() == sportsLeaf) {
					try{				
						Tab tab = new Tab();
						
						main.tabPane.getTabs().add(tab);
						FXMLLoader loader= new FXMLLoader(getClass().getResource("/application/view/SportTab.fxml" ));
						tab.setContent((Node) loader.load());				
						SportTabController controller = loader.<SportTabController>getController();	
						controller.init(main);
						controller.openInformationOfSport(main.haeLaji(target.getValue()));
						tab.setText(target.getValue());
						tab.isClosable();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				else if(target.getParent().getParent() == resultsLeaf){
					try{
						
						Tab tab = new Tab();					
						main.tabPane.getTabs().add(tab);
						FXMLLoader loader= new FXMLLoader(getClass().getResource("/application/view/SeriesTab.fxml" ));
						tab.setContent((Node) loader.load());				
						SeriesTabController controllerX = loader.<SeriesTabController>getController();	
						
					
						Sport sport = main.haeLaji(target.getParent().getValue());
						
						Serie serie = main.haeSarja(sport, target.getValue());
						
						controllerX.init(main, serie, sport);
						controllerX.taytaListView();
						controllerX.setName();
						tab.setText(sport.toString()+": "+serie.toString());
						tab.isClosable();
						
					}catch(Exception e){
						e.printStackTrace();
					}
			}
			
			}
		}
	}
	
	public void setKilpailunNimi(String nimi){
	
		

	}
	
	
	
	@FXML
	public void initialize() {
		
		root.getChildren().addAll(competitorsLeaf, teamsLeaf, sportsLeaf, resultsLeaf);
		
		treeView.setRoot(root);
		root.setExpanded(true);
		competitorsLeaf.setExpanded(true);
		teamsLeaf.setExpanded(true);
		sportsLeaf.setExpanded(true);
		resultsLeaf.setExpanded(true);
	}
	
	   
	
	
	
}
