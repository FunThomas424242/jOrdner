package com.gh.jordner.filsesystem;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;

import com.gh.jordner.exceptions.DataAccessException;
import com.gh.jordner.jpa.filesystem.Verzeichnis;
import com.gh.jordner.jpa.filesystem.VerzeichnisDAO;

@Creatable
public class FileSystemService {

	@Inject
	VerzeichnisDAO dao;

	public List<Verzeichnis> readAllManagedFolders() throws DataAccessException {
		List<Verzeichnis> verzeichnisse = dao.listAllVerzeichnisse();
		if (verzeichnisse == null) {
			throw new DataAccessException(
					"DAO lieferte null zurück und keine Liste");
		}
		return verzeichnisse;
	}

	public void addManagedFolder(Verzeichnis verzeichnis)
			throws DataAccessException {

		try {
			dao.insert(verzeichnis);
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}

	}

	public void removeManagedFolder(Verzeichnis verzeichnis)
			throws DataAccessException {

		try {
			dao.remove(verzeichnis);
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}

	}
}
