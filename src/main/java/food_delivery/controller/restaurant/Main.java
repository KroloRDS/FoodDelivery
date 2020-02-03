package food_delivery.controller.restaurant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import food_delivery.controller.common.Controller;

public class Main extends Controller
{
	@FXML private Label label;
	
	public void initialize()
	{
		label.setText("Panel restauracji: " + restaurant);
	}
	
	public void changeSceneToRestaurantMenu(ActionEvent event)
	{
		changeScene(event, "Restaurant/Menu");
	}
	
	public void changeSceneToRestaurantOrders(ActionEvent event)
	{
		changeScene(event, "Restaurant/Orders");
	}
	
	public void changeSceneToEditAccount(ActionEvent event)
	{
		changeScene(event, "Common/EditAccount");
	}
	
	public void changeSceneToWelcome(ActionEvent event)
	{
		changeScene(event, "Common/Welcome");
	}
}
