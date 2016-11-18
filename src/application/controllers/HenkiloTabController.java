package application.controllers;



import application.model.Henkilo;
import application.model.Joukkue;
import application.model.Kilpailija;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;

public class HenkiloTabController{
 
	Tab tab;
	MainController main;
	@FXML ToggleGroup group;
	@FXML Label etunimiKentta;
	@FXML Label sukunimiKentta;
	@FXML Label ikaKentta;
	@FXML RadioButton mies;
	@FXML RadioButton nainen;
	
	@FXML Button tallenna;
	@FXML Button tyhjenna;
	@FXML Button poista;
	
	
	
	public void avaaHenkilonTiedot(Henkilo henkilo){
		etunimiKentta.setText(henkilo.kerroEtunimi());
		sukunimiKentta.setText(henkilo.kerroSukunimi());
		ikaKentta.setText(Integer.toString(henkilo.kerroIka()));
		if(henkilo.kerroSukupuoli().equals("Mies")){
			mies.setSelected(true);
		}else nainen.setSelected(true);
	}
	
	/*@FXML
	public void initialize() {
		
	}*/
	
	public void init(MainController mainController, Tab tab){
		main=mainController;
		this.tab = tab;
	}
	
	
	@FXML
	public void poistaPainettu(ActionEvent e){
		main.treeViewViewController.poista(e);		
		main.tabPane.getTabs().remove(tab);
	}
	
	
}
