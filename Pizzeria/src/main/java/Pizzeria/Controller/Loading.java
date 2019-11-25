package Pizzeria.Controller;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Loading extends Preloader
{
	private static Stage mainStage;
	
	@Override
	public void start(Stage stage) throws Exception
	{
		Parent loadingView = FXMLLoader.load(getClass().getResource("/View/Loading.fxml"));
		mainStage = stage;
		mainStage.setScene(new Scene(loadingView));
		mainStage.setTitle("Wczytywanie...");
		mainStage.show();
	}
	
	public static Stage getStage()
	{
		return mainStage;
	}
}