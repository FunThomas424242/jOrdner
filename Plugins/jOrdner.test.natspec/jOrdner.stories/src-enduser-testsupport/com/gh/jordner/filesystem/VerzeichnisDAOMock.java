package com.gh.jordner.filesystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gh.jordner.jpa.filesystem.Verzeichnis;
import com.gh.jordner.jpa.filesystem.VerzeichnisDAO;

public class VerzeichnisDAOMock extends VerzeichnisDAO {

	private final List<Verzeichnis> MANAGED_FOLDERS = new ArrayList<Verzeichnis>();

	public VerzeichnisDAOMock() {
		super();
	}

	@Override
	public void insert(Verzeichnis entity) throws SQLException {

		synchronized (MANAGED_FOLDERS) {
			MANAGED_FOLDERS.add(entity);
			int id = MANAGED_FOLDERS.size();
			entity.setId((long) id);
		}

	}

	@Override
	public List<Verzeichnis> listAllVerzeichnisse() {
		final List<Verzeichnis> listKopie = new ArrayList<Verzeichnis>();
		listKopie.addAll(MANAGED_FOLDERS);
		return listKopie;
	}

	@Override
	public void remove(Verzeichnis verzeichnis) throws SQLException {
		MANAGED_FOLDERS.remove(verzeichnis);
	}

	@Override
	public void destroy() {
		MANAGED_FOLDERS.clear();
	}

}
