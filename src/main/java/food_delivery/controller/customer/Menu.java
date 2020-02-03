package food_delivery.controller.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import food_delivery.controller.common.Controller;
import food_delivery.model.Dish;
import food_delivery.model.OrderDish;
import food_delivery.utils.DBManager;
import java.util.ArrayList;
import java.util.List;

public class Menu extends Controller
{
	@FXML private ListView<String> listView;
	@FXML private Label label;
	
	public void initialize()
	{
		if (orderDishes == null)
		{
			orderDishes = new ArrayList<>();
			List<Dish> dishes = DBManager.selectAllWhere(Dish.class, "restaurant", restaurant);
			dishes.forEach(dish -> orderDishes.add(new OrderDish(dish.getName(), dish.getInfo(), dish.getPrice())));
		}
		orderDishes.forEach(dish -> listView.getItems().add(dish.getLongString()));
		updateTotalPrice();
	}
	
	public void changeSceneToCustomerMain(ActionEvent event)
	{
		changeScene(event, "Customer/Main");
	}

	public void validateAndGoConfirmation(ActionEvent event)
	{
		for (OrderDish orderDish : orderDishes)
		{
			if (orderDish.isOrdered())
			{
				changeScene(event, "Customer/ConfirmOrder");
				return;
			}
		}
		
		error("Nie wybrano żadnej potrawy");
	}
	
	public void incQuantity()
	{
		changeQuantity(1);
	}
	
	public void decQuantity()
	{
		changeQuantity(-1);
	}
	
	private void changeQuantity(int change)
	{
		int index = listView.getSelectionModel().getSelectedIndex();
		if (index == -1)
		{
			return;
		}
		
		orderDishes.get(index).changeQuantity(change);
		listView.getItems().set(index, orderDishes.get(index).getLongString());
		updateTotalPrice();
	}
	
	private void updateTotalPrice()
	{
		double price = orderDishes.stream().mapToDouble(OrderDish::getPrice).sum();
		label.setText("Razem: " + String.format("%.2f zł", price));
	}
}
