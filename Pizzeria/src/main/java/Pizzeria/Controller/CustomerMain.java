package Pizzeria.Controller;

import Pizzeria.Utils.DBManager;
import Pizzeria.Model.Pizza;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import java.util.List;

public class CustomerMain extends Controller
{
	@FXML private ListView listView;
	private List<Pizza> pizzas;
	
	public void changeSceneToWelcome(ActionEvent event)
	{
		changeScene(event, "Welcome");
	}
	
	public void initialize()
	{
		pizzas = DBManager.selectAll("Pizza");
		addPizzasToList();
	}

	public void validateAndGoToConfirmation(ActionEvent event)
	{
		if (getIndex() != -1)
		{
			goToOrderConfirmation(event);
		}
		else
		{
			error("Nie wybrano żadnej pizzy");
		}
	}
	
	private void goToOrderConfirmation(ActionEvent event)
	{
		FXMLLoader loader = getLoader("CustomerConfirm");
		try
		{
			Scene scene = new Scene(loader.load());
			CustomerConfirm controller = loader.getController();
			controller.initView(getIndex());
			changeScene(event, scene);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			error("Nie udało się załadować tego widoku");
		}
	}

	private int getIndex()
	{
		return listView.getSelectionModel().getSelectedIndex();
	}
	
	private void addPizzasToList()
	{
		int i = 1;
		for (Pizza pizza : pizzas)
		{
			listView.getItems().add(i + listRow(pizza));
			i++;
		}
	}
	
	private String listRow(Pizza pizza)
	{
		String row = ". ";
		row += pizza.getName() + ": ";
		row += pizza.getToppings();
		row += String.format(" (%.2f zł)", pizza.getPrice());
		return row;
	}
}
