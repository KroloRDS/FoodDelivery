package Pizzeria.Controller;

import Pizzeria.Utils.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

public class Welcome extends Controller
{
	@FXML private PasswordField password;
	
	public void login(ActionEvent event)
	{
		if (Login.validatePassword(password.getText()))
		{
			changeSceneToStaffMain(event);
		}
		else
		{
			error("Niepoprawne hasło");
		}
	}
	
	public void changeSceneToCustomerMain(ActionEvent event)
	{
		changeScene(event, "CustomerMain");
	}
	
	public void changeSceneToStaffMain(ActionEvent event)
	{
		changeScene(event, "StaffMain");
	}
}
