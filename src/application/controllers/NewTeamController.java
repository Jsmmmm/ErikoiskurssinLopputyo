package application.controllers;

import application.model.Team;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewTeamController {

	MainController main;
	
	@FXML TextField teamName;
	@FXML Button cancel;
	
	
	public Team saveTeam(){
		Team newTeam=null;
		if(!teamName.getText().isEmpty()){
			newTeam = new Team(teamName.getText());						
		}
		return newTeam;
	}
			
	
	public void init(MainController mainController){
		main=mainController;
	}
	
	public void clearTextfields(){
		teamName.clear();		
	}
	
	@FXML
	public void saveButtonPressed(ActionEvent e){
		
			Team team=saveTeam();
			if(team!=null){
				main.joukkueet.add(team);
				main.treeViewViewController.addTeamToTW(team);
				main.joukkueLaskuri(true);
			}
	}
	
	
	@FXML
	public void cancelButtonPressed(ActionEvent e){
		 Stage stage = (Stage) cancel.getScene().getWindow();		   
		 stage.close();
	}
	
	
	
}
