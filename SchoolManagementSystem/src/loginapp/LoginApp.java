package loginapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * Represents the LoginApp class
 */
public class LoginApp extends Application {

	/*
	 * Signature
	 * start : Stage Parent Scene -> Stage
	 * Purpose
	 * GIVEN: a Stage platform, a Parent with children, and a scene containing
	 *        content to show
	 * RETURNS: An updated Stage
	 */
	public void start(Stage stage) throws Exception{
		
		/*
		 * A root is a Parent
		 * INTERP: represents an object hierarchy with children
		 */
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("login.fxml"));
		
		/*
		 * A scene is a Scene
		 * INTERP: represents a graph containing content
		 */
		Scene scene = new Scene(root);
		
		stage.setScene(scene);
		stage.setTitle("School Management System");
		stage.show();
	}
	
	/*
	 * Method that launches the application
	 * 
	 * @returns an application
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
