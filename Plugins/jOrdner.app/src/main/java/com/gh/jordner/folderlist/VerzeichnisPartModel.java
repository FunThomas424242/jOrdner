package com.gh.jordner.folderlist;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.core.runtime.Platform;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.services.log.Logger;
import org.osgi.framework.Bundle;

import com.gh.devtools.lib.swtextension.ErrorMessageDialog;
import com.gh.jordner.exceptions.DataAccessException;
import com.gh.jordner.filsesystem.FileSystemService;
import com.gh.jordner.jpa.filesystem.Verzeichnis;

@Creatable
@Singleton
public class VerzeichnisPartModel {

	@Inject
	private Logger logger;

	@Inject
	private FileSystemService fileSystemService;

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

	public void saveAll() {

		// Alle neuen Einträge hinzufügen
		for (final Verzeichnis verzeichnis : zuErstellendeVerzeichnisse) {
			try {
				fileSystemService.addManagedFolder(verzeichnis);
			} catch (DataAccessException ex) {

				final Bundle bundle = Platform.getBundle("jOrdner.app");
				@SuppressWarnings("unused")
				final ErrorMessageDialog errorDialog = new ErrorMessageDialog(
						logger, bundle, "Datenzugriffsfehler", this.getClass(),
						ex);

			}
		}
		zuErstellendeVerzeichnisse.clear();

		// Alle zu löschenden Einträge entfernen
		for (final Verzeichnis verzeichnis : zuLoeschendeVerzeichnisse) {
			try {
				fileSystemService.removeManagedFolder(verzeichnis);
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
			verzeichnisse = fileSystemService.readAllManagedFolders();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
