package food_delivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account
{
	@Id
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private int password;
    
    @Column(name = "type")
    private String type;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "postcode")
	private String postcode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "houseNumber")
	private String houseNumber;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	public Account(
			String login, String password, String name, String surname, String postcode, String city,
			String houseNumber, String street, String phoneNumber, String email)
	{
		this.login = login;
		this.password = password.hashCode();
		this.name = name;
		this.city = city;
		this.houseNumber = houseNumber;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.postcode = postcode;
		this.email = email;
		
		type = "customer";
	}
	
	public Account()
	{
		//no argument constructor for hibernate to use
	}
	
	public void changeType()
	{
		if (type.equals("customer"))
		{
			type = "restaurant";
		}
		else
		{
			type = "customer";
		}
	}
	
	public String getTypeAndLogin()
	{
		return type + ": " + login;
	}
	
	public String getFullName()
	{
		return name + " " + surname;
	}
	
	public String getAddress()
	{
		return street + " " + houseNumber;
	}
	
	public String getLogin()
	{
		return login;
	}
	
	public void setLogin(String login)
	{
		this.login = login;
	}
	
	public int getPassword()
	{
		return password;
	}
	
	public void setPassword(int password)
	{
		this.password = password;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getSurname()
	{
		return surname;
	}
	
	public void setSurname(String surname)
	{
		this.surname = surname;
	}
	
	public String getPostcode()
	{
		return postcode;
	}
	
	public void setPostcode(String postcode)
	{
		this.postcode = postcode;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getHouseNumber()
	{
		return houseNumber;
	}
	
	public void setHouseNumber(String houseNumber)
	{
		this.houseNumber = houseNumber;
	}
	
	public String getStreet()
	{
		return street;
	}
	
	public void setStreet(String street)
	{
		this.street = street;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
}
