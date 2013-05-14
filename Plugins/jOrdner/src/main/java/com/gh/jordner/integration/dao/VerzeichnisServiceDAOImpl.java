package com.gh.jordner.integration.dao;

import org.eclipse.e4.core.di.annotations.Creatable;

import com.gh.jordner.integration.entity.Verzeichnis;

@Creatable
public class VerzeichnisServiceDAOImpl implements VerzeichnisDAO {

	public Verzeichnis create(Verzeichnis verzeichnis) {
		System.out.println(verzeichnis);
		return verzeichnis;
	}

}
