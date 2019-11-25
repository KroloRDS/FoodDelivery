package Pizzeria.Model;

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
	
	@Column(name = "pizza")
	private String pizza;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "active")
	private int active = 1;
	
	public Order(String pizza, String name, String address, String phone)
	{
		this.pizza = pizza;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public Order()
	{
		//no argument constructor for hibernate to use
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getPizza()
	{
		return pizza;
	}
	
	public void setPizza(String pizza)
	{
		this.pizza = pizza;
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean isActive()
	{
		return active == 1;
	}
	
	public void setId(int id)
	{
		this.id = id;
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
	
	public void deliver()
	{
		this.active = 0;
	}
	
	@Override
	public String toString()
	{
		String ret = this.id + ": ";
		ret += this.pizza + " ";
		ret += this.name + " ";
		ret += this.address + " ";
		ret += this.phone + " ";
		return ret;
	}
}
