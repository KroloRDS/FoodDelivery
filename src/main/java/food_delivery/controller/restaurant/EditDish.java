package food_delivery.controller.restaurant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import food_delivery.controller.common.Controller;
import food_delivery.model.Dish;
import food_delivery.utils.DBManager;
import food_delivery.utils.ValidateForm;

import java.util.List;

public class EditDish extends Controller
{
	@FXML private TextField name;
	@FXML private TextField price;
	@FXML private TextArea description;
	private Dish beforeEdit = null;
	
	public void initialize()
	{
		if (dish != null)
		{
			beforeEdit = (Dish) DBManager.selectAllWhere(
					"Dish",
					"restaurant",
					"name",
					restaurant,
					dish
			).get(0);
			
			name.setText(beforeEdit.getName());
			price.setText(String.valueOf(beforeEdit.getPrice()));
			description.setText(beforeEdit.getDescription());
		}
	}
	
	public void changeSceneToRestaurantMenu(ActionEvent event)
	{
		changeScene(event, "Restaurant/Menu");
	}
	
	public void delete(ActionEvent event)
	{
		if (beforeEdit != null)
		{
			DBManager.delete(beforeEdit);
		}
		changeSceneToRestaurantMenu(event);
	}
	
	public void validateAndSave(ActionEvent event)
	{
		String errorMessage = ValidateForm.validateDish(name.getText(), description.getText(), price.getText());
		if (!errorMessage.isEmpty())
		{
			error(errorMessage);
			return;
		}
		
		try
		{
			save(event);
		}
		catch (Exception e)
		{
			error("Nazwa potrawy jest już zajęta");
		}
	}
	
	private void save(ActionEvent event)
	{
		if (beforeEdit == null || !beforeEdit.getName().equals(name.getText()))
		{
			DBManager.insert(readForm());
			delete(event);
		}
		else
		{
			DBManager.update(readForm());
			changeSceneToRestaurantMenu(event);
		}
	}
	
	private Dish readForm()
	{
		return new Dish(name.getText(), description.getText(), Double.parseDouble(price.getText()), restaurant);
	}
}
