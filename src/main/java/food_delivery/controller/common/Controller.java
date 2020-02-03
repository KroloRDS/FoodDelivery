package food_delivery.controller.common;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import food_delivery.model.OrderDish;
import java.util.List;

public class Controller
{
	protected static String login;
	protected static String restaurant;
	protected static String dish;
	protected static List<OrderDish> orderDishes;
	
	protected void changeScene(ActionEvent event, String viewName)
	{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		viewName = "/View/" + viewName + ".fxml";
		
		Parent newView;
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
	
	protected void error(String message)
	{
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Błąd!");
		alert.setHeaderText(message);
		alert.setContentText(null);
		
		alert.showAndWait();
	}
}
