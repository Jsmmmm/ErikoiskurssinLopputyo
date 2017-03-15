package application.controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Dialogs {

	//alert dialog that pops up if user tries to create new sport / competitor / team without first creating / loading competition.
	protected static void noCompetitionAlert(){		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("No competition selected");		
		alert.setContentText("Create new competition or load existing one and try again.");
		alert.showAndWait();
	}
}
