package food_delivery.controller.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import food_delivery.controller.common.Controller;
import food_delivery.model.Account;
import food_delivery.model.Order;
import food_delivery.model.OrderDish;
import food_delivery.utils.DBManager;
import food_delivery.utils.ValidateForm;

public class ConfirmOrder extends Controller
{
	@FXML private TextArea order;
	@FXML private TextField name;
	@FXML private TextField address;
	@FXML private TextField phone;
	@FXML private Label label;
	private double totalPrice = 0.0;
	
	public void initialize()
	{
		setOrderText();
		Account account = DBManager.selectAllWhere(Account.class, "login", login).get(0);
		name.setText(account.getFullName());
		address.setText(account.getAddress());
		phone.setText(account.getPhoneNumber());
	}
	
	public void changeSceneToCustomerMenu(ActionEvent event)
	{
		changeScene(event, "Customer/Menu");
	}
	
	private void changeSceneToCustomerThankYou(ActionEvent event)
	{
		changeScene(event, "Customer/ThankYou");
	}
	
	public void validate(ActionEvent event)
	{
		String errorMessage = ValidateForm.validateOrder(name.getText(), address.getText(), phone.getText());
		if (errorMessage.isEmpty())
		{
			placeOrder(event);
		}
		else
		{
			error(errorMessage);
		}
	}
	
	private void placeOrder(ActionEvent event)
	{
		StringBuilder stringBuilder = new StringBuilder();
		for (OrderDish orderDish : orderDishes)
		{
			if (orderDish.isOrdered())
			{
				stringBuilder.append(orderDish.getShortStringWithoutPrice());
			}
		}
		stringBuilder.append(String.format("%.2f zł ", totalPrice));
		Order newOrder = new Order(stringBuilder.toString(), name.getText(), address.getText(), phone.getText(), restaurant, login);
		DBManager.insert(newOrder);
		changeSceneToCustomerThankYou(event);
	}
	
	private void setOrderText()
	{
		StringBuilder stringBuilder = new StringBuilder();
		for (OrderDish orderDish : orderDishes)
		{
			if (orderDish.isOrdered())
			{
				stringBuilder.append(orderDish.getShortString());
				stringBuilder.append("\n");
				totalPrice += orderDish.getPrice();
			}
		}
		order.setText(stringBuilder.toString());
		label.setText("Razem: " + String.format("%.2f zł", totalPrice));
	}
}
