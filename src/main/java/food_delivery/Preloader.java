package food_delivery;

import javafx.application.Application;
import food_delivery.controller.common.Loading;

public class Preloader
{
    public static void main(String[] args)
    {
        System.setProperty("javafx.preloader", Loading.class.getName());
        Application.launch(MainApp.class, args);
    }
}