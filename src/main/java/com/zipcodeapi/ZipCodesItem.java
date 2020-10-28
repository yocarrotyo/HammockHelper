package com.zipcodeapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZipCodesItem{

	@JsonProperty("distance")
	private double distance;

	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;

	@JsonProperty("zip_code")
	private String zipCode;

	public double getDistance(){
		return distance;
	}

	public String getCity(){
		return city;
	}

	public String getState(){
		return state;
	}

	public String getZipCode(){
		return zipCode;
	}
}