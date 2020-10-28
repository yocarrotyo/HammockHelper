package com.zipcodeapi;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response{

	@JsonProperty("zip_codes")
	private List<ZipCodesItem> zipCodes;

	public List<ZipCodesItem> getZipCodes(){
		return zipCodes;
	}
}