package com.ibm.healthplanner.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.healthplanner.pojos.CasesCountRes;
import com.ibm.interfac.CasesCountAdapter;

import io.swagger.annotations.Api;
@RestController
@CrossOrigin(origins="*")
@RequestMapping(value={"/","/healthplanner"})
@Api(value="onlinestore", description="Operations pertaining to Health Advisor")
@Transactional(timeout=360000)
public class HealthPlannerController {
	
	private static final Logger log = LoggerFactory.getLogger(HealthPlannerController.class);
	
	@Autowired
	CasesCountAdapter casesCountAdapter;
	
	@GetMapping(value="/",produces = MediaType.APPLICATION_JSON_VALUE)
	public String get(){
		return "Please give url as Spring-Boot-Rest/patient/get";
		
	}
	
	
	@GetMapping(value="/testsCount", headers="Accept=application/json")
	public CasesCountRes getStatesTestCount() {
		
		CasesCountRes casesCountResponse = new CasesCountRes();
		try {
			casesCountResponse = casesCountAdapter.getCasesCount();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return casesCountResponse;
	}
	

//	
//	@GetMapping(value="/state-wise", headers="Accept=application/json")
//	public JSONArray getStateWiseDetails() {
//		
//		JSONArray stateWiseCountRes = new JSONArray();
//		try {
//			stateWiseCountRes = casesCountAdapter.getStateWiseCount();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		return stateWiseCountRes;
//	}
    
}
