package food_delivery.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import food_delivery.controller.common.Controller;
import food_delivery.model.Account;
import food_delivery.utils.DBManager;

import java.util.List;

public class AddRestaurant extends Controller
{
	private List<Account> accounts;
	@FXML private ListView<String> listView;
	
	public void changeSceneToAdminMain(ActionEvent event)
	{
		changeScene(event, "Admin/Main");
	}
	
	public void initialize()
	{
		accounts = DBManager.selectAll(Account.class);
		accounts.forEach(account -> listView.getItems().add(account.getTypeAndLogin()));
	}
	
	public void changeType()
	{
		int selectedIndex = getIndex();
		
		if (selectedIndex == -1)
		{
			error("Nie wybrano żadnego konta");
			return;
		}
		
		Account account = accounts.get(selectedIndex);
		if (account.getType().equals("admin"))
		{
			error("Nie można zmienić uprawnień administratora");
			return;
		}
		
		account.changeType();
		DBManager.update(account);
		listView.getItems().set(selectedIndex, account.getTypeAndLogin());
		accounts.set(selectedIndex, account);
	}
	
	private int getIndex()
	{
		return listView.getSelectionModel().getSelectedIndex();
	}
}
