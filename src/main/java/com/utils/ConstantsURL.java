package com.utils;

public enum ConstantsURL {

	LOCALHOST("http://localhost:8080/prweb/PRServlet/app/default/beEBp4uRVTogorRwSwWqbOtn9IL2fwdI*/!STANDARD"),
	QESERVER("blue"),
	PRODSERVER("brownish");

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
