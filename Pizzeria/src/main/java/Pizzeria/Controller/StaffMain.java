package Pizzeria.Controller;

import javafx.event.ActionEvent;

public class StaffMain extends Controller
{
	public void changeSceneToStaffMenu(ActionEvent event)
	{
		changeScene(event, "StaffMenu");
	}
	
	public void changeSceneToStaffOrders(ActionEvent event)
	{
		changeScene(event, "StaffOrders");
	}
	
	public void changeSceneToWelcome(ActionEvent event)
	{
		changeScene(event, "Welcome");
	}
}
