package food_delivery.controller.customer;

import javafx.event.ActionEvent;
import food_delivery.controller.common.Controller;

public class ThankYou extends Controller
{
	public void changeSceneToCustomerMain(ActionEvent event)
	{
		changeScene(event, "Customer/Main");
	}
}
