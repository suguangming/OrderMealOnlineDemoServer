package utils;

public class Order {
	private int id;
	private String username;
	private String foodname;
	private int foodnumber;
	private double foodprice;
	private String status;
	
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public int getFoodnumber() {
		return foodnumber;
	}
	public void setFoodnumber(int foodnumber) {
		this.foodnumber = foodnumber;
	}
	public double getFoodprice() {
		return foodprice;
	}
	public void setFoodprice(double foodprice) {
		this.foodprice = foodprice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
		
}
