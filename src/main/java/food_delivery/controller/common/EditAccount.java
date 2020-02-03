package food_delivery.controller.common;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import food_delivery.model.Account;
import food_delivery.model.Dish;
import food_delivery.model.Order;
import food_delivery.utils.DBManager;
import food_delivery.utils.ValidateForm;

import java.util.List;

public class EditAccount extends Controller
{
	@FXML private TextField loginTextField;
	@FXML private PasswordField password;
	@FXML private TextField name;
	@FXML private TextField surname;
	@FXML private TextField email;
	@FXML private TextField phoneNumber;
	@FXML private TextField street;
	@FXML private TextField postalCode;
	@FXML private TextField city;
	@FXML private TextField houseNumber;
	private Account account;
	
	public void initialize()
	{
		account = getAccount();
		loginTextField.setText(login);
		name.setText(account.getName());
		surname.setText(account.getSurname());
		email.setText(account.getEmail());
		phoneNumber.setText(account.getPhoneNumber());
		street.setText(account.getStreet());
		postalCode.setText(account.getPostcode());
		city.setText(account.getCity());
		houseNumber.setText(account.getHouseNumber());
	}
	
	public void updateAndGoBack(ActionEvent event)
	{
		account.setName(name.getText());
		account.setSurname(surname.getText());
		account.setEmail(email.getText());
		account.setPhoneNumber(phoneNumber.getText());
		account.setStreet(street.getText());
		account.setPostcode(postalCode.getText());
		account.setCity(city.getText());
		account.setHouseNumber(houseNumber.getText());
		account.setPassword(password.getText().hashCode());
		
		validateAndGoBack(event);
	}
	
	public void goBack(ActionEvent event)
	{
		if (account.getType().equals("customer"))
		{
			changeScene(event, "Customer/Main");
		}
		else
		{
			changeScene(event, "Restaurant/Main");
		}
	}
	
	private Account getAccount()
	{
		return (Account) DBManager.selectAllWhere("Account", "login", login).get(0);
	}
	
	private void validateAndGoBack(ActionEvent event)
	{
		String errorMessage = ValidateForm.validateRegistration(
				loginTextField.getText(),
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
		
		if (login.equals(loginTextField.getText()))
		{
			DBManager.update(account);
			goBack(event);
			return;
		}
		
		try
		{
			account.setLogin(loginTextField.getText());
			DBManager.insert(account);
		}
		catch (Exception e)
		{
			error("Ta nazwa jest już zajęta");
			return;
		}
		
		updateDishesAndOrders();
		DBManager.delete(getAccount());
		login = loginTextField.getText();
		restaurant = loginTextField.getText();
		goBack(event);
	}
	
	private void updateDishesAndOrders()
	{
		if (account.getType().equals("customer"))
		{
			return;
		}
		
		String newName = loginTextField.getText();
		
		List<Order> orders = DBManager.selectAllWhere("Order", "restaurant", restaurant);
		for (Order order : orders)
		{
			order.setRestaurant(newName);
			DBManager.update(order);
		}
		
		List<Dish> dishes = DBManager.selectAllWhere("Dish", "restaurant", restaurant);
		for (Dish dish : dishes)
		{
			DBManager.delete(dish);
			dish.setRestaurant(newName);
			DBManager.insert(dish);
		}
	}
}
