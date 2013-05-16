package com.gh.jordner.api;

public interface Verzeichnis {

	public Long getId();
	public void setId(Long id);
	
	public String getName();
	public void setName(String name) ;

	public String getParentPathURI() ;
	public void setParentPathURI(String parentPathURI) ;
	
}
