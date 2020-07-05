package com.ibm.enumertr;

public enum StateNamesEnum {

	ANDAMAN("an"), ANDHRAPRADESH("ap");
	
	private String name;
	
	StateNamesEnum(String value){
		
		name=value;
	}
	
	
	/**
	 * 
	 * @param desired
	 * @return
	 */
	public static String getStateNamesEnum(String desired) {
		String states = null;
		System.out.println(".... desired"+desired);
		for (StateNamesEnum stateNames : values()) {
			System.out.println(".... inside enum"+stateNames.toString());
			
			for(int i=0;i<desired.length();i++) {
				
//				System.out.println(".... desired inside for"+desired[i]);
				
			if (desired.equalsIgnoreCase(stateNames.toString())) {
				System.out.println(".... inside enum if"+stateNames.toString());
				states = stateNames.name;
				System.out.println("..sates"+states);
			}
		}
	}
		return states;

	}
	
}
