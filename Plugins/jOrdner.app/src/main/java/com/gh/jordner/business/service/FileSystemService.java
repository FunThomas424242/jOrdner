package com.gh.jordner.business.service;

import java.io.File;
import java.sql.SQLException;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;

import com.gh.jordner.api.Verzeichnis;
import com.gh.jordner.jpa.filesystem.VerzeichnisImpl;
import com.gh.jordner.jpa.filesystem.VerzeichnisServiceDAOImpl;

@Creatable
public class FileSystemService {

	@Inject
	VerzeichnisServiceDAOImpl dao;

	public Verzeichnis addManagedFolder(final File folder) {
		final String folderName = folder.getName();
		final Verzeichnis verzeichnis = new VerzeichnisImpl();
		verzeichnis.setName(folderName);
		try {
			dao.save(verzeichnis);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return verzeichnis;
	}
}
