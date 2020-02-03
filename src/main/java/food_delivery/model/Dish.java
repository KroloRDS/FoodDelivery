package food_delivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table (name = "dishes")
public class Dish implements Serializable
{
	@Id
	@Column (name = "name")
	private String name;
	
	@Column (name = "description")
	private String description;
	
	@Id
	@Column (name = "restaurant")
	private String restaurant;
	
	@Column (name = "price")
	private double price;
	
	public Dish(String name, String description, double price, String restaurant)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.restaurant = restaurant;
	}
	
	public Dish()
	{
		//no argument constructor for hibernate to use
	}
	
	public String getInfo()
	{
		return getName() + " (" + getPrice() + " zł):\n" + getDescription();
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getRestaurant()
	{
		return restaurant;
	}
	
	public void setRestaurant(String restaurant)
	{
		this.restaurant = restaurant;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
}
