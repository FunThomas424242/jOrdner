/*******************************************************************************
 * Copyright (c) 2012 PE INTERNATIONAL AG.
 * All rights reserved.
 * 
 * Contributors:
 *    Jan Stamer - initial API and implementation
 *******************************************************************************/
package com.gh.jordner.jpa.filesystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "VERZEICHNIS")
public class Verzeichnis {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private String parentPathURI;

	public Verzeichnis() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Verzeichnis(" + name + " " + parentPathURI + ")";
	}

}
