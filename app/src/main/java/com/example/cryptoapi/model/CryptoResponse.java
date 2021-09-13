package com.example.cryptoapi.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CryptoResponse{

	@SerializedName("overview")
	private List<Object> overview;

	@SerializedName("assets")
	private List<AssetsItem> assets;

	@SerializedName("pagination")
	private Pagination pagination;

	public void setOverview(List<Object> overview){
		this.overview = overview;
	}

	public List<Object> getOverview(){
		return overview;
	}

	public void setAssets(List<AssetsItem> assets){
		this.assets = assets;
	}

	public List<AssetsItem> getAssets(){
		return assets;
	}

	public void setPagination(Pagination pagination){
		this.pagination = pagination;
	}

	public Pagination getPagination(){
		return pagination;
	}

	@Override
 	public String toString(){
		return 
			"CryptoResponse{" + 
			"overview = '" + overview + '\'' + 
			",assets = '" + assets + '\'' + 
			",pagination = '" + pagination + '\'' + 
			"}";
		}
}