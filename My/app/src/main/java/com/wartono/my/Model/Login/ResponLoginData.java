package com.wartono.my.Model.Login;

import com.google.gson.annotations.SerializedName;

public class ResponLoginData {

	@SerializedName("loginData")
	private ModelLoginData loginData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public void setLoginData(ModelLoginData loginData){

		this.loginData = loginData;
	}

	public ModelLoginData getLoginData(){

		return loginData;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}

	public void setStatus(boolean status){

		this.status = status;
	}

	public boolean isStatus(){

		return status;
	}


}