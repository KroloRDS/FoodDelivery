package food_delivery.controller.common;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import food_delivery.model.Account;
import food_delivery.utils.DBManager;
import food_delivery.utils.ValidateForm;

public class Register extends Controller
{
	@FXML private TextField login;
	@FXML private PasswordField password;
	@FXML private TextField name;
	@FXML private TextField surname;
	@FXML private TextField email;
	@FXML private TextField phoneNumber;
	@FXML private TextField street;
	@FXML private TextField postalCode;
	@FXML private TextField city;
	@FXML private TextField houseNumber;
	
	public void register(ActionEvent event)
	{
		String errorMessage = ValidateForm.validateRegistration(
				login.getText(),
				password.getText(),
				name.getText(),
				surname.getText(),
				postalCode.getText(),
				city.getText(),
				houseNumber.getText(),
				street.getText(),
				phoneNumber.getText(),
				email.getText()
		);
		
		if (!errorMessage.isEmpty())
		{
			error(errorMessage);
			return;
		}
		
		Account account = new Account(
				login.getText(),
				password.getText(),
				name.getText(),
				surname.getText(),
				postalCode.getText(),
				city.getText(),
				houseNumber.getText(),
				street.getText(),
				phoneNumber.getText(),
				email.getText()
		);
		
		try
		{
			DBManager.insert(account);
			changeSceneToWelcome(event);
		}
		catch (Exception e)
		{
			error("Ten login jest już zajęty");
		}
	}
	
	public void changeSceneToWelcome(ActionEvent event)
	{
		changeScene(event, "Common/Welcome");
	}
}
