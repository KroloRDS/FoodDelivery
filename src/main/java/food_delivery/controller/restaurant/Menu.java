package food_delivery.controller.restaurant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import food_delivery.controller.common.Controller;
import food_delivery.model.Dish;
import food_delivery.utils.DBManager;

import java.util.List;

public class Menu extends Controller
{
	@FXML private ListView<String> listView;
	
	public void initialize()
	{
		dish = null;
		List<Dish> dishes = DBManager.selectAllWhere("Dish", "restaurant", restaurant);
		for (Dish dish : dishes)
		{
			listView.getItems().add(dish.getName());
		}
	}
	
	public void changeSceneToRestaurantMain(ActionEvent event)
	{
		changeScene(event, "Restaurant/Main");
	}
	
	public void changeSceneToRestaurantEdit(ActionEvent event)
	{
		changeScene(event, "Restaurant/EditDish");
	}
	
	public void validateAndGoToEditView(ActionEvent event)
	{
		if (listView.getSelectionModel().getSelectedIndex() == -1)
		{
			error("Nie wybrano żadnej potrawy");
		}
		else
		{
			dish = listView.getSelectionModel().getSelectedItem();
			changeScene(event, "Restaurant/EditDish");
		}
	}
}
