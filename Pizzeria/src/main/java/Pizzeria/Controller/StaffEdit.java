package Pizzeria.Controller;

import Pizzeria.Utils.DBManager;
import Pizzeria.Model.Pizza;
import Pizzeria.Utils.ValidateForm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StaffEdit extends Controller
{
	@FXML private TextField name;
	@FXML private TextField price;
	@FXML private TextArea toppings;
	private Pizza beforeEdit = null;
	
	public void changeSceneToStaffMenu(ActionEvent event)
	{
		changeScene(event, "StaffMenu");
	}
	
	public void initView(int selectedIndex)
	{
		beforeEdit = DBManager.selectByIndex("Pizza", selectedIndex);
		name.setText(beforeEdit.getName());
		price.setText(String.valueOf(beforeEdit.getPrice()));
		toppings.setText(beforeEdit.getToppings());
	}
	
	public void delete(ActionEvent event)
	{
		if (beforeEdit != null)
		{
			DBManager.delete(beforeEdit);
		}
		changeSceneToStaffMenu(event);
	}
	
	public void validate(ActionEvent event)
	{
		String errorMessage = ValidateForm.validatePizza(name.getText(), toppings.getText(), price.getText());
		if (errorMessage.isEmpty())
		{
			try
			{
				save(event);
			}
			catch (Exception e)
			{
				error("Ta nazwa jest już zajęta");
			}
		}
		else
		{
			error(errorMessage);
		}
	}
	
	private void save(ActionEvent event)
	{
		if (beforeEdit == null)
		{
			DBManager.insert(readForm());
		}
		else
		{
			DBManager.update(readForm(), beforeEdit);
		}
		changeSceneToStaffMenu(event);
	}
	
	private Pizza readForm()
	{
		return new Pizza(name.getText(), toppings.getText(), Double.parseDouble(price.getText()));
	}
}
