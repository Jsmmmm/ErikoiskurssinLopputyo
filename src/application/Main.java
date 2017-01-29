package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
								
			//open main window
			Parent root = FXMLLoader.load(getClass().getResource("/application/view/MainView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//open opening screen on top of the main window
			Parent root2 = FXMLLoader.load(getClass().getResource("/application/view/OpeningWindow.fxml"));					
			Stage stage = new Stage();
            stage.setScene(new Scene(root2));
            stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {		
		launch(args);
	}
}
