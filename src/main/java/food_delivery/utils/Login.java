package food_delivery.utils;

import food_delivery.model.Account;

import java.util.List;

public class Login
{
	public static String validateCredentials(String login, String password)
	{
		List<Account> accounts = DBManager.selectAllWhere("Account", "login", login);
		if (accounts.size() == 0)
		{
			return "wrong login";
		}
		
		Account account = accounts.get(0);
		if (account.getPassword() != password.hashCode())
		{
			return "wrong password";
		}
		return account.getType();
	}
}
