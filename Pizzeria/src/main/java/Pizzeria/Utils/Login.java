package Pizzeria.Utils;

public class Login
{
	//PW = pizza
	public static boolean validatePassword(String password)
	{
		return password.hashCode() == 106683528;
	}
}
