package com.gh.jordner.business.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;

import com.gh.jordner.jpa.filesystem.VerzeichnisImpl;
import com.gh.jordner.jpa.filesystem.VerzeichnisServiceDAOImpl;

@Creatable
public class FileSystemService {

	@Inject
	VerzeichnisServiceDAOImpl dao;

	public VerzeichnisImpl addManagedFolder(final File folder) {
		final VerzeichnisImpl verzeichnis = new VerzeichnisImpl();
		verzeichnis.setName(folder.getName());
		verzeichnis.setParentPathURI(folder.getParentFile().getAbsolutePath());
		try {
			dao.save(verzeichnis);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return verzeichnis;
	}

	public List<VerzeichnisImpl> lesenAllerVerzeichnisse() {
		List<VerzeichnisImpl> verzeichnisse = dao.allEntries();
		if (verzeichnisse == null) {
			System.out.println("DAO lieferte null zurück und keine Liste");
		}
		return verzeichnisse;
	}

	public void speichernVerzeichnis(VerzeichnisImpl verzeichnis)
			throws Exception {

		dao.save(verzeichnis);

	}
}
