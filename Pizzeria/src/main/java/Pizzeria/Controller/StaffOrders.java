package Pizzeria.Controller;

import Pizzeria.Utils.DBManager;
import Pizzeria.Model.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class StaffOrders extends Controller
{
	private List<Order> orders;
	@FXML private ListView listView;
	
	public void changeSceneToStaffMain(ActionEvent event)
	{
		changeScene(event, "StaffMain");
	}
	
	public void initialize()
	{
		orders = DBManager.selectAll("Order");
		for (Order order : orders)
		{
			if (order.isActive())
			{
				listView.getItems().add(order.toString());
			}
		}
	}
	
	public void deliverAll()
	{
		Order activeOrder;
		for (Order order : orders)
		{
			activeOrder = order;
			order.deliver();
			DBManager.update(order, activeOrder);
		}
		orders.clear();
		listView.getItems().clear();
	}
	
	public void deliverOne()
	{
		int selectedIndex = getIndex();
		if (selectedIndex != -1)
		{
			Order activeOrder = orders.get(selectedIndex);
			Order deliveredOrder = activeOrder;
			deliveredOrder.deliver();
			DBManager.update(deliveredOrder, activeOrder);
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
