package com.ibm.healthplanner.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.healthplanner.pojos.CasesCountPojo;
import com.ibm.healthplanner.pojos.CasesCountRes;
import com.ibm.healthplanner.pojos.StatesWisePojo;
import com.ibm.interfac.CasesCountAdapter;

@Service
@Transactional(timeout=360000)
public class HealthPlannerServiceImpl implements CasesCountAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(HealthPlannerServiceImpl.class);

	
public CasesCountRes getCasesCount() throws IOException {
		
		CasesCountPojo pojo = new CasesCountPojo();
		CasesCountRes response = new CasesCountRes();
		URL url;
		try {
			url = new URL("https://api.covid19india.org/state_test_data.json");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			conn.setRequestMethod("GET");
			
			conn.connect();
			conn.setConnectTimeout(360000);
			
			String output = "";
			int resCode = conn.getResponseCode();
			
			if(resCode != 200) {
				
				throw new RuntimeException("HttpsResCode:"+resCode);
			}
			else {
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					output+= sc.nextLine();
				}
				sc.close();
			}
			
			JSONObject jsonObj = new JSONObject(output);
			JSONArray jsonArr = jsonObj.getJSONArray("states_tested_data");
			response.setData(getData(pojo, jsonArr));
		} 
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return response;
	}


private List<CasesCountPojo> getData(CasesCountPojo pojo, JSONArray jsonArr) {
	
	List<CasesCountPojo> pojoList = new ArrayList<>();
	
	for(int i=0 ;i <jsonArr.length();i++) {
		
		JSONObject obj = jsonArr.getJSONObject(i);
		
		pojo.setNegative(obj.getString("negative"));
		pojo.setPositive(obj.getString("positive"));
		pojo.setState(obj.getString("state"));
		pojo.setTestspermillion( obj.getString("testspermillion"));
		pojo.setTotaltested( obj.getString("totaltested"));
		pojo.setUnconfirmed(obj.getString("unconfirmed"));
		pojo.setUpdatedon(obj.getString("updatedon"));
		  
		  pojoList.add(pojo);
	}
	
	return pojoList;
} 


////	public JSONArray getStateWiseCount() throws IOException {
//		
//		JSONArray newObj = new JSONArray();
//		
//		CasesCountRes response = new CasesCountRes();
////		List<StatesWisePojo> stateWisepojo = new ArrayList<>();
//		
//		StatesWisePojo states = new StatesWisePojo();
//		URL url;
//		try {
//			url = new URL("https://api.covid19india.org/states_daily.json");
//			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
//			
//			conn.setRequestMethod("GET");
//			
//			conn.connect();
//
//			String output = "";
//			int resCode = conn.getResponseCode();
//			
//			if(resCode != 200) {
//				
//				throw new RuntimeException("HttpsResCode:"+resCode);
//			}
//			else {
//				Scanner sc = new Scanner(url.openStream());
//				while (sc.hasNext()) {
//					output+= sc.nextLine();
//				}
//				sc.close();
//			}
//			
//			JSONObject jsonObj = new JSONObject(output);
//			JSONArray jsonArr = jsonObj.getJSONArray("states_daily");
//			 newObj = getNewNames(states, jsonArr);
//			
//		}
//		catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//			return newObj;
//				
//				
////				Set<String> keys = obj.keySet();
//////				
////				for(String items: keys) {
//////					
////					System.out.println("keyss"+items);
//////					
//////					
//////					
////					String changedNames = StateNamesEnum.getStateNamesEnum(items);
////					
//////					JSONObject json = new JSONObject(changedNames);
////					
//////					System.out.println("changes names"+json.getString("an"));
////					states.setAndaman(changedNames);
////					
//////					System.out.println("..."+states.getAndaman());
////					
////					
//////				
//////					switch(items) {
//////					
//////					case "an":
//////						
//////						states.setAndaman("ANDAMAN");
//////						
//////					
////					}
////					System.out.println(".......switch...."+obj.getString("ANDAMAN"));	
//					
//				
//		
//		
//	}
//	
//	public JSONArray getNewNames(StatesWisePojo states,JSONArray jsonArr) {
//		
//		JSONArray newNamesList = new JSONArray(); 
//		JSONObject object = new JSONObject();
//		
//		
//		for(int i=0;i<jsonArr.length();i++) {
//			
//			JSONObject	 obj = jsonArr.getJSONObject(i);
//			
//			obj.put("Andaman", obj.get("an"));
//			obj.remove("an");
//			
//			obj.put("AndhraPradesh", obj.get("ap"));
//			obj.remove("ap");
//			
//			obj.put("ArunachalPradesh", obj.get("ar"));
//			obj.remove("ar");
//			
//			obj.put("Assam", obj.get("as"));
//			obj.remove("as");
//			
//			obj.put("Bihar", obj.get("br"));
//			obj.remove("br");
//			
//			obj.put("Chandigarh", obj.get("ch"));
//			obj.remove("ch");
//	
////			object = obj;
//			
//			
////			System.out.println("Inside for"+object);
////		states.setAndaman(obj.toString().replace("\"an\":","\"Andaman\":"));
////		
////		states.setAndhra(obj.toString().replace("\"ap\":","\"AndhraPradesh\":"));
////		
////		states.setArunachal(obj.toString().replace("\"ar\":","\"ArunachalPradesh\":"));
//		
//			/*
//			 * newNamesList.add(obj.toString().replace("\"an\":","\"Andaman\":")); //
//			 * \"Andaman\":
//			 */
//			
//		newNamesList.put(obj);
//		}
//		return newNamesList;
//
//	
//	}

}
