package com.ibm.healthplanner.pojos;

import java.util.Collections;
import java.util.List;

public class CasesCountRes {
	
	
	List<CasesCountPojo> countPojo = Collections.emptyList();
	
	public List<CasesCountPojo> getData() {
		return countPojo;
	}

	public void setData(List<CasesCountPojo> countPojo) {
		this.countPojo= countPojo;
		
	}

}
