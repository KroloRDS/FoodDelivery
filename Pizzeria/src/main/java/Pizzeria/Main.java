package Pizzeria;

import Pizzeria.Controller.Loading;
import javafx.application.Application;

public class Main
{
    public static void main(String[] args)
    {
        System.setProperty("javafx.preloader", Loading.class.getName());
        Application.launch(MainApp.class, args);
    }
}