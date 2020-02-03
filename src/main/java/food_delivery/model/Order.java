package food_delivery.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order
{
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	private int id;
	
	@Column(name = "dish")
	private String dish;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "active")
	private int active = 1;
	
	@Column(name = "restaurant")
	private String restaurant;
	
	@Column(name = "customer")
	private String customer;
	
	public Order(String dish, String name, String address, String phone, String restaurant, String customer)
	{
		this.dish = dish;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.restaurant = restaurant;
		this.customer = customer;
	}
	
	public Order()
	{
		//no argument constructor for hibernate to use
	}
	
	public String getInfoRestaurant()
	{
		return id + ": " + dish + name + ", " + address + ", " + phone;
	}
	
	public String getInfoCustomer()
	{
		if (isActive())
		{
			return restaurant + ":\n" + dish + "\nStatus: W trakcie przygotowania";
		}
		return restaurant + ":\n" + dish + "\nStatus: Doręczono";
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getDish()
	{
		return dish;
	}
	
	public void setDish(String dish)
	{
		this.dish = dish;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public int getActive()
	{
		return active;
	}
	
	public void setActive(int active)
	{
		this.active = active;
	}
	
	public String getRestaurant()
	{
		return restaurant;
	}
	
	public void setRestaurant(String restaurant)
	{
		this.restaurant = restaurant;
	}
	
	public String getCustomer()
	{
		return customer;
	}
	
	public void setCustomer(String customer)
	{
		this.customer = customer;
	}
	
	public void deliver()
	{
		this.active = 0;
	}
	
	public boolean isActive()
	{
		return active == 1;
	}
}
