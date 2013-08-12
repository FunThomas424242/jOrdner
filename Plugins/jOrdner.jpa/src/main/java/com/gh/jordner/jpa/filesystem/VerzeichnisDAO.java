package com.gh.jordner.jpa.filesystem;

import java.sql.SQLException;
import java.util.List;

public interface VerzeichnisDAO {

	public void save(Verzeichnis verzeichnis) throws SQLException;

	public List<Verzeichnis> allEntries();

}
