package com.gh.jordner.filesystem;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import com.gh.jordner.exceptions.DataAccessException;
import com.gh.jordner.filsesystem.FileSystemService;
import com.gh.jordner.jpa.filesystem.Verzeichnis;

import de.devboost.natspec.annotations.TextSyntax;

public class FileSystemServiceTestDriver {

	// Service under Test
	private FileSystemService fileService;

	// private final static List<Verzeichnis> MANAGED_FOLDERS = new
	// ArrayList<Verzeichnis>();

	public FileSystemService getFileService() {
		return fileService;
	}

	public void setFileService(FileSystemService fileService) {
		this.fileService = fileService;
	}

	/**
	 * Public constructor for test support class
	 */
	public FileSystemServiceTestDriver() {
		super();
	}

	@TextSyntax("Hinzufügen eines neuen Verzeichnisses #1 zur Liste der verwalteten Verzeichnisse")
	public void hinzufügenEinesNeuenVerzeichnissesZurListeDerVerwaltetenVerzeichnisse(
			final String folderPfad) {

		final File file = new File(folderPfad);
		final Verzeichnis verzeichnis = new Verzeichnis();
		verzeichnis.setName(file.getName());
		verzeichnis.setParentPathURI(file.getParentFile().getAbsolutePath());

		try {
			fileService.addManagedFolder(verzeichnis);

		} catch (DataAccessException e) {
			fail(e.toString());
		}
	}

	@TextSyntax("Auslesen aller verwalteten Verzeichnisse")
	public List<Verzeichnis> auslesenAllerVerwaltetenVerzeichnisse() {
		List<Verzeichnis> managedFolders = null;
		try {
			managedFolders = fileService.readAllManagedFolders();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return managedFolders;
	}

	@TextSyntax("Die Liste der verwalteten Verzeichnisse enhält #1 Einträge")
	public void dieListeDerVerwaltetenVerzeichnisseEnhältEinträge(
			final int itemCount, final List<Verzeichnis> managedFolders) {
		assertEquals(itemCount, managedFolders.size());
	}

	@TextSyntax("Eintrag #1 in der Liste der verwalteten Verzeichnisse heißt #2")
	public void eintragInDerListeDerVerwaltetenVerzeichnisseHeißt(
			final int itemIndex, final String folderName,
			final List<Verzeichnis> managedFolders) {

		final Verzeichnis verzeichnis = managedFolders.get(itemIndex);
		final String verzeichnisName = verzeichnis.getName();
		assertEquals(folderName, verzeichnisName);

	}

}
