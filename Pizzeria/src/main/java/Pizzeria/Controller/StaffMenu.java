package Pizzeria.Controller;

import Pizzeria.Utils.DBManager;
import Pizzeria.Model.Pizza;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.List;


public class StaffMenu extends Controller
{
	@FXML private ListView listView;
	private List<Pizza> pizzas;
	
	public void changeSceneToStaffMain(ActionEvent event)
	{
		changeScene(event, "StaffMain");
	}
	
	public void changeSceneToStaffEdit(ActionEvent event)
	{
		changeScene(event, "StaffEdit");
	}
	
	public void validateAndGoToEditView(ActionEvent event)
	{
		if (getIndex() != -1)
		{
			try
			{
				goToEditPizzaView(event);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				error("Nie udało się załadować tego widoku");
			}
		}
		else
		{
			error("Nie wybrano żadnej pizzy");
		}
	}
	
	public void initialize()
	{
		pizzas = DBManager.selectAll("Pizza");
		addPizzasToList();
	}
	
	private int getIndex()
	{
		return listView.getSelectionModel().getSelectedIndex();
	}
	
	private void goToEditPizzaView(ActionEvent event) throws IOException
	{
		FXMLLoader loader = getLoader("StaffEdit");
		try
		{
			Scene scene = new Scene(loader.load());
			StaffEdit controller = loader.getController();
			controller.initView(getIndex());
			changeScene(event, scene);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			error("Nie udało się załadować tego widoku");
		}
	}
	
	private void addPizzasToList()
	{
		int i = 1;
		for (Pizza pizza : pizzas)
		{
			listView.getItems().add(i + ". " + pizza.getName());
			i++;
		}
	}
}
