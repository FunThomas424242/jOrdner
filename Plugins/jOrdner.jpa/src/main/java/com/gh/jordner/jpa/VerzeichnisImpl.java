/*******************************************************************************
 * Copyright (c) 2012 PE INTERNATIONAL AG.
 * All rights reserved.
 * 
 * Contributors:
 *    Jan Stamer - initial API and implementation
 *******************************************************************************/
package com.gh.jordner.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.gh.jordner.api.Verzeichnis;


@Entity
public class VerzeichnisImpl implements Verzeichnis {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String parentPathURI;
	
	public VerzeichnisImpl(){
		super();
	}
	
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
	}

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

	
	
	public String toString() {
		return "VerzeichnisImpl(" + name + " " + parentPathURI +")";
	}

	
}
