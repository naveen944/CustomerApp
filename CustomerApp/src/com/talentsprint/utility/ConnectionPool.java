package com.talentsprint.utility;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConnectionPool {
	public static Context getEnvironmentContext(){
		/*Context initContext;
		Context envContext = null;*/
		try {
			/*initContext = new InitialContext();
			envContext  = (Context)initContext.lookup("java:/comp/env");*/
			Context context = (Context)new InitialContext().lookup("java:/comp/env");
			return context;
	    } catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
