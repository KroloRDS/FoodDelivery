package food_delivery.controller.common;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import food_delivery.utils.Login;

public class Welcome extends Controller
{
	@FXML private TextField loginTextField;
	@FXML private PasswordField password;
	
	public void initialize()
	{
		login = null;
		restaurant = null;
		dish = null;
		orderDishes = null;
	}
	
	public void login(ActionEvent event)
	{
		String type = Login.validateCredentials(loginTextField.getText(), password.getText());
		
		switch (type)
		{
			case "admin":
				login = loginTextField.getText();
				changeScene(event, "Admin/Main");
				break;
			case "customer":
				login = loginTextField.getText();
				changeScene(event, "Customer/Main");
				break;
			case "restaurant":
				login = loginTextField.getText();
				restaurant = loginTextField.getText();
				changeScene(event, "Restaurant/Main");
				break;
			case "wrong login":
				error("Niepoprawny login");
				break;
			case "wrong password":
				error("Niepoprawne hasło");
				break;
		}
	}
	
	public void changeSceneToRegister(ActionEvent event)
	{
		changeScene(event, "Common/Register");
	}
}
