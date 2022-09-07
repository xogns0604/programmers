package Study;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private int amount;
	private String name;
	//ArrayList<Product> productList = new ArrayList<Product>();
	//public List productList;
	
	Product() {
	}
	
	Product(int amount, String name){
		this.amount = amount;
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
