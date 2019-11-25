package Pizzeria.Controller;

import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.ArrayList;

public class Controller
{
	protected void changeScene(ActionEvent event, String viewName)
	{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		viewName = "/View/" + viewName + ".fxml";
		
		Parent newView = null;
		try
		{
			newView = FXMLLoader.load(getClass().getResource(viewName));
			window.setScene(new Scene(newView));
			window.show();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			error("Nie udało się załadować widoku: " + viewName);
		}
	}
	
	protected void changeScene(ActionEvent event, Scene scene)
	{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	protected FXMLLoader getLoader(String viewName)
	{
		viewName = "/View/" + viewName + ".fxml";
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(viewName));
		return loader;
	}
	
	protected void error(String message)
	{
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Błąd!");
		alert.setHeaderText(message);
		alert.setContentText(null);
		
		alert.showAndWait();
	}
}
