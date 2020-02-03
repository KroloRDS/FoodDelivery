package food_delivery.utils;

public class ValidateForm
{
	public static String validateDish(String name, String toppings, String price)
	{
		if (name.isEmpty() || toppings.isEmpty() || price.isEmpty())
		{
			return "Prosimy wypełnić wszystkie pola";
		}
		try
		{
			Double.parseDouble(price);
			return "";
		}
		catch (NumberFormatException e)
		{
			return "Wprowadzona cena nie jest liczbą";
		}
	}
	
	public static String validateOrder(String name, String address, String phone)
	{
		if (name.isEmpty() || address.isEmpty() || phone.isEmpty())
		{
			return "Prosimy wypełnić wszystkie pola";
		}
		return "";
	}
	
	public static String validateRegistration(
			String login, String password, String name, String surname, String postcode, String city,
			String houseNumber, String street, String phoneNumber, String email)
	{
		if (login.isEmpty() ||
			password.isEmpty() ||
			name.isEmpty() ||
			surname.isEmpty() ||
			postcode.isEmpty() ||
			city.isEmpty() ||
			houseNumber.isEmpty() ||
			street.isEmpty() ||
			phoneNumber.isEmpty() ||
			email.isEmpty())
		{
			return "Prosimy wypełnić wszystkie pola";
		}
		
		if (!phoneNumber.matches("[\\d]{9}$"))
		{
			return "Niepoprawny numer telefonu";
		}
		
		if (!email.matches(".+@.+"))
		{
			return "Niepoprawny adres email";
		}
		
		if (!postcode.matches("[\\d]{2}-?[\\d]{3}$"))
		{
			return "Niepoprawny kod pocztowy";
		}
		
		if (!houseNumber.matches("[1-9][\\d]*$") || houseNumber.length() > 4)
		{
			return "Niepoprawny numer domu";
		}
		
		return "";
	}
}
