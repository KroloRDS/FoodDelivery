package Pizzeria;

import Pizzeria.Controller.Loading;
import Pizzeria.Utils.DBManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application
{
	@Override
	public void init() throws Exception
	{
		DBManager.init();
	}
	
	@Override
	public void start(Stage mainStage) throws Exception
	{
		Parent welcomeView = FXMLLoader.load(getClass().getResource("/View/Welcome.fxml"));
		mainStage = Loading.getStage();
		mainStage.setScene(new Scene(welcomeView));
		mainStage.setTitle("Pizzeria");
		mainStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
