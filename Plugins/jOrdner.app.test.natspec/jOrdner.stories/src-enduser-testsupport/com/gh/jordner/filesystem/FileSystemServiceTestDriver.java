package com.gh.jordner.filesystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.mockito.InjectMocks;

import com.gh.jordner.exceptions.DataAccessException;
import com.gh.jordner.filsesystem.FileSystemService;
import com.gh.jordner.jpa.filesystem.Verzeichnis;

import de.devboost.natspec.annotations.TextSyntax;

public class FileSystemServiceTestDriver {

	@InjectMocks
	private final FileSystemService fileService;

	/**
	 * Public constructor for test support class
	 */
	public FileSystemServiceTestDriver() {
		super();
		fileService = new FileSystemService();
		fileService.setVerzeichnisDAO(new VerzeichnisDAOMock());
	}

	@TextSyntax("Hinzufügen eines neuen Verzeichnisses #1 zur Liste der verwalteten Verzeichnisse")
	public void hinzufügenEinesNeuenVerzeichnissesZurListeDerVerwaltetenVerzeichnisse(
			final String folderPfad) {

		final Path path = convertPfad2File(folderPfad);
		final Verzeichnis verzeichnis = new Verzeichnis();
		verzeichnis.setName(path.getFileName().toString());
		verzeichnis.setParentPathURI(path.getParent().toString());

		try {
			fileService.addManagedFolder(verzeichnis);

		} catch (DataAccessException e) {
			fail(e.toString());
		}
	}

	public Path convertPfad2File(final String folderPfad) {
		Path path = Paths.get(folderPfad);
		return path;
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

	@TextSyntax("Eintrag #1 in der Liste der verwalteten Verzeichnisse heißt #2 mit Pfad #3")
	public void eintragInDerListeDerVerwaltetenVerzeichnisseHeißt(
			final int itemIndex, final String verzeichnisName,
			final String verzeichnisPfad, final List<Verzeichnis> managedFolders) {

		final Verzeichnis verzeichnis = managedFolders.get(itemIndex - 1);
		assertEquals(verzeichnisName, verzeichnis.getName());
		assertEquals(verzeichnisPfad, verzeichnis.getParentPathURI()
				+ File.separator + verzeichnis.getName());

	}

}
