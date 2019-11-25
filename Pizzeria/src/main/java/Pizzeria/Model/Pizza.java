package Pizzeria.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "pizzas")
public class Pizza
{
	public Pizza(String name, String toppings, double price)
	{
		this.name = name;
		this.toppings = toppings;
		this.price = price;
	}
	
	public Pizza()
	{
		//no argument constructor for hibernate to use
	}
	
	@Id
	@Column (name = "name")
	private String name;
	
	@Column (name = "toppings")
	private String toppings;
	
	@Column (name = "price")
	private double price;
	
	public String getName()
	{
		return name;
	}
	
	public String getToppings()
	{
		return toppings;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setToppings(String toppings)
	{
		this.toppings = toppings;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
}
