package com.gh.jordner.gui.parts;

import java.util.List;

import com.gh.jordner.jpa.filesystem.Verzeichnis;

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
	private List<Verzeichnis> verzeichnisse;

	public void setVerzeichnisse(List<Verzeichnis> verzeichnisse) {
		this.verzeichnisse = verzeichnisse;
	}

	public void addVerzeichnis(final Verzeichnis verzeichnis) {
		verzeichnisse.add(verzeichnis);
	}

	public List<Verzeichnis> getVerzeichnisse() {
		return verzeichnisse;
	}
}
