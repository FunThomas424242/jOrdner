package com.gh.jordner.gui.parts;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.swt.widgets.Shell;

import com.gh.jordner.business.service.FileSystemService;
import com.gh.jordner.exceptions.DataAccessException;
import com.gh.jordner.jpa.filesystem.Verzeichnis;

@Creatable
@Singleton
public class VerzeichnisPartModelProvider {

	@Inject
	private FileSystemService fileService;

	/* Instanz */
	private List<Verzeichnis> verzeichnisse;
	private final List<Verzeichnis> zuLoeschendeVerzeichnisse = new ArrayList<Verzeichnis>();
	private final List<Verzeichnis> zuErstellendeVerzeichnisse = new ArrayList<Verzeichnis>();

	public void setVerzeichnisse(List<Verzeichnis> verzeichnisse) {
		this.verzeichnisse = verzeichnisse;
	}

	public void addVerzeichnis(final Verzeichnis verzeichnis) {
		boolean isContained = verzeichnisse.contains(verzeichnis)
				|| zuErstellendeVerzeichnisse.contains(verzeichnis);
		if (!isContained) {
			zuErstellendeVerzeichnisse.add(verzeichnis);
			verzeichnisse.add(verzeichnis);
		}

	}

	public List<Verzeichnis> getInput() {
		return verzeichnisse;
	}

	public void markToRemove(int[] indizesToRemove) {
		for (final Integer listIndex : indizesToRemove) {
			final Verzeichnis verzeichnis = verzeichnisse.get(listIndex);
			if (!zuLoeschendeVerzeichnisse.contains(verzeichnis)) {
				zuLoeschendeVerzeichnisse.add(verzeichnis);
			}
		}
	}

	public void deleteRemovedItemsFromInput() {
		for (final Verzeichnis verzeichnis : zuLoeschendeVerzeichnisse) {
			verzeichnisse.remove(verzeichnis);
		}
	}

	public void saveAll(final Shell shell) {

		// Alle neuen Einträge hinzufügen
		for (final Verzeichnis verzeichnis : zuErstellendeVerzeichnisse) {
			try {
				fileService.addManagedFolder(verzeichnis);
			} catch (DataAccessException e) {
				// TODO print a message box
				e.printStackTrace();
			}
		}
		zuErstellendeVerzeichnisse.clear();

		// Alle zu löschenden Einträge entfernen
		for (final Verzeichnis verzeichnis : zuLoeschendeVerzeichnisse) {
			try {
				fileService.removeManagedFolder(verzeichnis);
			} catch (DataAccessException e) {
				// TODO print a message box
				e.printStackTrace();
			}
		}
		zuLoeschendeVerzeichnisse.clear();
		reloadInput();

	}

	public void reloadInput() {
		try {
			verzeichnisse = fileService.readAllManagedFolders();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
