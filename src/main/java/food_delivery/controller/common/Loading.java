package food_delivery.controller.common;

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
		Parent loadingView = FXMLLoader.load(getClass().getResource("/View/Common/Loading.fxml"));
		mainStage = stage;
		mainStage.setScene(new Scene(loadingView));
		mainStage.setTitle("Wczytywanie...");
		mainStage.centerOnScreen();
		mainStage.show();
	}
	
	public static Stage getStage()
	{
		return mainStage;
	}
}