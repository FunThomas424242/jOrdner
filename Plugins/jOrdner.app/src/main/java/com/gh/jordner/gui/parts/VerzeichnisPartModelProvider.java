package com.gh.jordner.gui.parts;

import java.util.List;

import com.gh.jordner.jpa.filesystem.VerzeichnisImpl;

public class VerzeichnisPartModelProvider {

	private static VerzeichnisPartModelProvider instance;

	// Erzeugung nur in der Klasse selbst möglich
	private VerzeichnisPartModelProvider() {
	}

	// Liefert die Instanz zurück (und erzeugt sie)
	public synchronized static VerzeichnisPartModelProvider getInstance() {
		if (instance == null) {
			instance = new VerzeichnisPartModelProvider();
		}
		return instance;
	}

	/* Instanz */
	private List<VerzeichnisImpl> verzeichnisse;

	public void setVerzeichnisse(List<VerzeichnisImpl> verzeichnisse) {
		this.verzeichnisse = verzeichnisse;
	}

	public void addVerzeichnis(final VerzeichnisImpl verzeichnis) {
		verzeichnisse.add(verzeichnis);
	}

	public List<VerzeichnisImpl> getVerzeichnisse() {
		return verzeichnisse;
	}
}
