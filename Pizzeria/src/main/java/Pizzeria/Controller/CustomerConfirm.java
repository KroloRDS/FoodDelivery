package Pizzeria.Controller;

import Pizzeria.Utils.DBManager;
import Pizzeria.Model.Order;
import Pizzeria.Model.Pizza;
import Pizzeria.Utils.ValidateForm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CustomerConfirm extends Controller
{
	@FXML private TextArea order;
	@FXML private TextField name;
	@FXML private TextField address;
	@FXML private TextField phone;
	
	public void changeSceneToCustomerMain(ActionEvent event)
	{
		changeScene(event, "CustomerMain");
	}
	
	public void initView(int selectedIndex)
	{
		Pizza selectedPizza = DBManager.selectByIndex("Pizza", selectedIndex);
		order.setText(selectedPizza.getName());
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
	
	private void changeSceneToCustomerThankYou(ActionEvent event)
	{
		changeScene(event, "CustomerThankYou");
	}
	
	private void placeOrder(ActionEvent event)
	{
		Order newOrder = new Order(order.getText(), name.getText(), address.getText(), phone.getText());
		DBManager.insert(newOrder);
		changeSceneToCustomerThankYou(event);
	}
}
