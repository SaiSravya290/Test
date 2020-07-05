//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Set;
//
//import javax.net.ssl.HttpsURLConnection;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import com.ibm.enumertr.StateNamesEnum;
//import com.ibm.healthplanner.pojos.CasesCountRes;
//import com.ibm.healthplanner.pojos.StatesWisePojo;
//
//public class Demo {
//	
//
//	
//	public static void main(String[] args) throws IOException {
//	
//	CasesCountRes response = new CasesCountRes();
////	List<StatesWisePojo> stateWisepojo = new ArrayList<>();
//	
//	StatesWisePojo states = new StatesWisePojo();
//	URL url;
////	try {
//		url = new URL("https://api.covid19india.org/states_daily.json");
//		HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
//		
//		conn.setRequestMethod("GET");
//		
//		conn.connect();
//
//		String output = "";
//		int resCode = conn.getResponseCode();
//		
//		if(resCode != 200) {
//			
//			throw new RuntimeException("HttpsResCode:"+resCode);
//		}
//		else {
//			Scanner sc = new Scanner(url.openStream());
//			while (sc.hasNext()) {
//				output+= sc.nextLine();
//			}
//			sc.close();
//		}
//		
//		JSONObject jsonObj = new JSONObject(output);
//		JSONArray jsonArr = jsonObj.getJSONArray("states_daily");
//		
////		stateWisepojo = 
//		
//		for(int i=0;i<jsonArr.length();i++) {
//			
//			JSONObject obj = jsonArr.getJSONObject(i);
//			
//			String state = obj.getString("an");
//			
//			states.setStateName(obj.getString("an"));
//			
////			states.setStateName(obj.toString()); 
////			
////			System.out.println(""+obj);
//			
//			
//		
////		String stateName = ;
////		response.setStateName(getFullForms() );
//		}
////	}
////	catch (MalformedURLException e) {
////		e.printStackTrace();
////	}
////	return response;
//}
//
//	
//	
//}
//
