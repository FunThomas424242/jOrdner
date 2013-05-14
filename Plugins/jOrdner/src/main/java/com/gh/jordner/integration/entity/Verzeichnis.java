package com.gh.jordner.integration.entity;

import javax.persistence.Entity;

@Entity
public class Verzeichnis {

	private String name;
	
	private String parentPathURI;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentPathURI() {
		return parentPathURI;
	}

	public void setParentPathURI(String parentPathURI) {
		this.parentPathURI = parentPathURI;
	}
	
}
