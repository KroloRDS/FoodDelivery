package food_delivery.controller.customer;

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
		orders = DBManager.selectAllWhere(Order.class, "customer", login);
		orders.forEach(order -> listView.getItems().add(order.getInfoCustomer()));
	}
	
	public void changeSceneToCustomerMain(ActionEvent event)
	{
		changeScene(event, "Customer/Main");
	}
}
