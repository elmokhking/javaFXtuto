package application;
	


import java.util.List;

import application.models.Client;
import application.repositories.ClientRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			 Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
	         
	        // Create the Scene
	        Scene scene = new Scene(root,900,500);
	   
	        primaryStage.setTitle("tuto");
	        
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
			
		launch(args);
	
	}
}
