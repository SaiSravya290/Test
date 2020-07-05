package com.ibm.interfac;

import java.io.IOException;

import com.ibm.healthplanner.pojos.CasesCountRes;

public interface CasesCountAdapter {
	
	CasesCountRes getCasesCount() throws IOException;
	
//	CasesCountRes getStateWiseCount() throws IOException;

}
