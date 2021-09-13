package com.example.cryptoapi.model;

import com.google.gson.annotations.SerializedName;

public class Pagination{

	@SerializedName("next")
	private String next;

	public void setNext(String next){
		this.next = next;
	}

	public String getNext(){
		return next;
	}

	@Override
 	public String toString(){
		return 
			"Pagination{" + 
			"next = '" + next + '\'' + 
			"}";
		}
}