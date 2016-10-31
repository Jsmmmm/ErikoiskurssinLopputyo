package application.controllers;

import application.model.Henkilo;
import application.model.Kilpailija;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class HenkilonLuominenController {

	MainController main;
	
	@FXML ToggleGroup group;
	@FXML TextField etunimiKentta;
	@FXML TextField sukunimiKentta;
	@FXML TextField ikaKentta;
	@FXML RadioButton mies;
	@FXML RadioButton nainen;
	@FXML Circle pallo1;
	@FXML Circle pallo2;
	@FXML Circle pallo3;
	@FXML Button tallenna;
	@FXML Button tyhjenna;
	@FXML Button peruuta;
	
	public void init(MainController mainController){
		main=mainController;
	}
	
public Kilpailija tallennaHenkilo(){
		
		boolean x = false;
		boolean y = false;
		boolean z = false;
		pallo1.setVisible(false);
		pallo2.setVisible(false);
		pallo3.setVisible(false);
		Henkilo henkilo=null;
		Kilpailija kilpailija=null;
		if(Henkilo.tarkistaNimi(etunimiKentta.getText())){
			x = true;
		}else {
			pallo1.setVisible(true);
		}
		if(Henkilo.tarkistaNimi(sukunimiKentta.getText())){
			y=true;
		}else{
			pallo2.setVisible(true);
		}
		int ika=0;
		try{
			ika=Integer.parseInt(ikaKentta.getText());
			z=true; 
			
		}catch(NumberFormatException ee){			
			pallo3.setVisible(true);			
		}
		String sukupuoli;
		if(mies.isSelected()){
			sukupuoli="Mies";
		}else sukupuoli="Nainen";
		
		if(x==true && y==true && z==true){
			kilpailija = new Kilpailija(etunimiKentta.getText(), sukunimiKentta.getText(), ika, sukupuoli);
			
			System.out.println(kilpailija.toString());
			
		}tyhjennaTekstikentat();
		return kilpailija;
				
	}


	public void tyhjennaTekstikentat(){
		etunimiKentta.clear();
		sukunimiKentta.clear();
		ikaKentta.clear();
		pallo1.setVisible(false);
		pallo2.setVisible(false);
		pallo3.setVisible(false);
		etunimiKentta.setPromptText("Etunimi");
		sukunimiKentta.setPromptText("Sukunimi");
		ikaKentta.setPromptText("Ikä");
	}
	
	@FXML
	public void tallennaNappiaPainettu(ActionEvent e){
		Kilpailija kilpailija=tallennaHenkilo();
		if(kilpailija!=null){
			main.kilpailijat.add(kilpailija);
			main.treeViewViewController.lisaaHenkiloOlioPuunakymaan(kilpailija); }		
	}
	
	@FXML
	public void tyhjennaNappiaPainettu(ActionEvent e){	
		tyhjennaTekstikentat();		
	}
	
	@FXML
	public void peruutaNappiaPainettu(ActionEvent e){
		 Stage stage = (Stage) peruuta.getScene().getWindow();		   
		 stage.close();
	}
	
}
