package com.wartono.my.Model.Register;

import com.google.gson.annotations.SerializedName;

public class ModelRegisterData {

	@SerializedName("nama")
	private String nama;

	@SerializedName("usernama")
	private String usernama;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setUsernama(String usernama){
		this.usernama = usernama;
	}

	public String getUsernama(){
		return usernama;
	}
}