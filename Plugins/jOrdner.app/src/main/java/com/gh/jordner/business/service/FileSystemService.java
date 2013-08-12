package com.gh.jordner.business.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;

import com.gh.jordner.exceptions.DataAccessException;
import com.gh.jordner.jpa.filesystem.Verzeichnis;
import com.gh.jordner.jpa.filesystem.VerzeichnisServiceDAOImpl;

@Creatable
public class FileSystemService {

	@Inject
	VerzeichnisServiceDAOImpl dao;

	public List<Verzeichnis> lesenAllerVerzeichnisse() {
		List<Verzeichnis> verzeichnisse = dao.allEntries();
		if (verzeichnisse == null) {
			System.out.println("DAO lieferte null zurück und keine Liste");
		}
		return verzeichnisse;
	}

	public void speichereVerzeichnis(Verzeichnis verzeichnis)
			throws DataAccessException {

		try {
			dao.save(verzeichnis);
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}

	}
}
