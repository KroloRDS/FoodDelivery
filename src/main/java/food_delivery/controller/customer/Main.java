package food_delivery.controller.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import food_delivery.controller.common.Controller;
import food_delivery.model.Account;
import food_delivery.utils.DBManager;

import java.util.List;

public class Main extends Controller
{
	@FXML private ListView<String> listView;
	
	public void initialize()
	{
		restaurant = null;
		orderDishes = null;
		List<Account> restaurants = DBManager.selectAllWhere("Account", "type", "restaurant");
		restaurants.forEach(restaurant -> listView.getItems().add(restaurant.getLogin()));
	}
	
	public void changeSceneToWelcome(ActionEvent event)
	{
		changeScene(event, "Common/Welcome");
	}
	
	public void changeSceneToEditAccount(ActionEvent event)
	{
		changeScene(event, "Common/EditAccount");
	}
	
	public void changeSceneToCustomerOrders(ActionEvent event)
	{
		changeScene(event, "Customer/Orders");
	}

	public void validateAndGoToMenu(ActionEvent event)
	{
		if (listView.getSelectionModel().getSelectedIndex() == -1)
		{
			error("Nie wybrano żadnej restauracji");
		}
		else
		{
			restaurant = listView.getSelectionModel().getSelectedItem();
			changeScene(event, "Customer/Menu");
		}
	}
}
