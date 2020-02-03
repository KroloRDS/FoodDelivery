package food_delivery.controller.restaurant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import food_delivery.controller.common.Controller;
import food_delivery.model.Order;
import food_delivery.utils.DBManager;

import java.util.List;

public class Orders extends Controller
{
	private List<Order> orders;
	@FXML private ListView<String> listView;
	
	public void initialize()
	{
		orders = DBManager.selectAllWhere(Order.class, "restaurant", restaurant);
		orders.removeIf(order -> !order.isActive());
		orders.forEach(order -> listView.getItems().add(order.getInfoRestaurant()));
	}
	
	public void changeSceneToRestaurantMain(ActionEvent event)
	{
		changeScene(event, "Restaurant/Main");
	}
	
	public void deliverAll()
	{
		for (Order order : orders)
		{
			order.deliver();
			DBManager.update(order);
		}
		orders.clear();
		listView.getItems().clear();
	}
	
	public void deliverOne()
	{
		int selectedIndex = getIndex();
		if (selectedIndex != -1)
		{
			Order order = orders.get(selectedIndex);
			order.deliver();
			DBManager.update(order);
			listView.getItems().remove(selectedIndex);
			orders.remove(selectedIndex);
		}
		else
		{
			error("Nie wybrano żadnego zamówienia");
		}
	}
	
	private int getIndex()
	{
		return listView.getSelectionModel().getSelectedIndex();
	}
}
