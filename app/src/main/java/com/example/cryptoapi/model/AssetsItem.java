package com.example.cryptoapi.model;

import com.google.gson.annotations.SerializedName;

public class AssetsItem{

	@SerializedName("change_7d")
	private double change7d;

	@SerializedName("price")
	private double price;

	@SerializedName("change_24h")
	private double change24h;

	@SerializedName("name")
	private String name;

	@SerializedName("volume_24h")
	private double volume24h;

	@SerializedName("id")
	private String id;

	@SerializedName("change_1h")
	private double change1h;

	@SerializedName("time")
	private String time;

	@SerializedName("status")
	private String status;

	public void setChange7d(double change7d){
		this.change7d = change7d;
	}

	public double getChange7d(){
		return change7d;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	public void setChange24h(double change24h){
		this.change24h = change24h;
	}

	public double getChange24h(){
		return change24h;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setVolume24h(double volume24h){
		this.volume24h = volume24h;
	}

	public double getVolume24h(){
		return volume24h;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setChange1h(double change1h){
		this.change1h = change1h;
	}

	public double getChange1h(){
		return change1h;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"AssetsItem{" + 
			"change_7d = '" + change7d + '\'' + 
			",price = '" + price + '\'' + 
			",change_24h = '" + change24h + '\'' + 
			",name = '" + name + '\'' + 
			",volume_24h = '" + volume24h + '\'' + 
			",id = '" + id + '\'' + 
			",change_1h = '" + change1h + '\'' + 
			",time = '" + time + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}