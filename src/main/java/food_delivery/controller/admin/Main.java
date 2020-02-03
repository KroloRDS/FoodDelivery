package food_delivery.controller.admin;

import javafx.event.ActionEvent;
import food_delivery.controller.common.Controller;

public class Main extends Controller
{
	public void changeSceneToAddRestaurant(ActionEvent event)
	{
		changeScene(event, "Admin/AddRestaurant");
	}
	
	public void changeSceneToWelcome(ActionEvent event)
	{
		changeScene(event, "Common/Welcome");
	}
}
