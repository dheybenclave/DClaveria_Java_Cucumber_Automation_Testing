package com.utils;

public enum ConstantsURL {

	//WEB APPLICATION URL SERVERS////////////////////////////////////////////////////////////////////////////////////////////
	WEB_APP_LOCALHOST("http://localhost:8080/prweb/PRServlet/app/default/beEBp4uRVTogorRwSwWqbOtn9IL2fwdI*/!STANDARD"),
	WEB_APP_QESERVER("blue"),
	WEB_APP_PRODSERVER("brownish"),
	
	//JSON API URL SERVERS////////////////////////////////////////////////////////////////////////////////////////////
	JSON_API_LOCALHOST("http://localhost:3000");

	public final String url;

	 // getter method
    public String getURL()
    {	
        return this.url;
    }
  
    // enum constructor - cannot be public or protected
	private ConstantsURL(String url) {
		this.url = url;
	}

}
