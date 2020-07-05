package com.ibm.healthplanner.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
	"stateName"
})
public class StatesWisePojo {
	
	
	/*
	 * public String andaman; public String andhra; public String arunachal; public
	 * String assam; public String bihar; public String chandigarh; public String
	 * ct; public String date; public String dadra; public String delhi; public
	 * String daman; public String goa; public String gujarat; public String
	 * himachal; public String haryana; public String jharkhand; public String
	 * jammu; public String karnataka; public String kerala; public String la;
	 * public String lakshadweep; public String maharashtra; public String
	 * meghalaya; public String manipur; public String madhya; public String
	 * mizoram; public String nagaland; public String orissa; public String punjab;
	 * public String pondy; public String rajasthan; public String sikkim; public
	 * String status; public String telagana; public String tamilnadu; public String
	 * tripura; public String tt; public String uttaraKhand; public String
	 * uttarpradesh; public String ut; public String westBengal;
	 */
	 
	
	@JsonProperty("stateName")
	private String stateName = "";
	
	
	@JsonProperty("stateName")
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
	@JsonProperty("stateName")
	public String getStateName() {
		return stateName;
	}

}
