package com.gh.jordner.stories;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;

import com.gh.jordner.exceptions.DataAccessException;
import com.gh.jordner.filesystem.VerzeichnisDAOFake;
import com.gh.jordner.filsesystem.FileSystemService;
import com.gh.jordner.jpa.filesystem.Verzeichnis;

import de.devboost.natspec.annotations.TextSyntax;

public class TestSupport {

	private final FileSystemService fileService;

	/**
	 * Public constructor for test support class
	 */
	public TestSupport() {
		super();
		fileService = new FileSystemService();
		fileService.setVerzeichnisDAO(new VerzeichnisDAOFake());
	}

	@TextSyntax("Erstelle lokal das Verzeichnis #1")
	public void createEntry(final String pfad) throws IOException {
		final File folder = new File(pfad);
		folder.mkdir();
	}

	@TextSyntax("Es existiert #1 vom Typ Verzeichnis")
	public void esExistiertVomTypVerzeichnis(final String folderPfad) {
		final File folder = new File(folderPfad);
		Assert.assertTrue(folder.exists());
		Assert.assertTrue(folder.isDirectory());
	}

	@TextSyntax("Erstelle eine Datei #1 im Verzeichnis #2")
	public void erstelleEineDateiImVerzeichnis(final String fileName,
			final String folderPfad) throws IOException {
		final File folder = new File(folderPfad);
		final File file = new File(folder, fileName);
		file.createNewFile();
	}

	@TextSyntax("Füge das Verzeichnis #1 zur Liste der verwalteten Verzeichnisse hinzu")
	public void hinzufügenEinesNeuenVerzeichnissesZurListeDerVerwaltetenVerzeichnisse(
			final String folderPfad) {

		Path path = Paths.get(folderPfad);
		final Verzeichnis verzeichnis = erstelleVerzeichnisAus(path);

		try {
			fileService.addManagedFolder(verzeichnis);

		} catch (DataAccessException e) {
			fail(e.toString());
		}
	}

	@TextSyntax("Importiere den Inhalt vom Verzeichnis #1")
	public void importiereDasVerzeichnisTmptest(final String folderPfad) {
		final Path path = Paths.get(folderPfad);
		final Verzeichnis verzeichnis = erstelleVerzeichnisAus(path);
		// try {
		// fileService.importFolderContent(verzeichnis);
		// } catch (DataAccessException e) {
		// fail(e.toString());
		// }
	}

	@TextSyntax("Es existiert ein Datenbankeintrag #1 vom Typ Verzeichnis mit Pfad #2")
	public void esExistiertEinDatenbankeintragMitPfad(final String folderName,
			final String folderPfad) {
		// TODO
	}

	@TextSyntax("Lösche Verzeichnis #1")
	public void löscheVerzeichnis(final String folderPfad) {
		// TODO
	}

	protected Verzeichnis erstelleVerzeichnisAus(Path path) {
		final Verzeichnis verzeichnis = new Verzeichnis();
		verzeichnis.setName(path.getFileName().toString());
		verzeichnis.setParentPathURI(path.getParent().toString());
		return verzeichnis;
	}

}
