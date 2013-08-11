package com.gh.jordner.stories;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

import org.junit.Assert;

import com.gh.jordner.business.service.FileSystemService;

import de.devboost.natspec.annotations.TextSyntax;

public class TestSupport {

	@Inject
	private FileSystemService fileService;

	/**
	 * Public constructor for test support class
	 */
	public TestSupport() {
		super();
	}

	@TextSyntax("Erstelle ein Verzeichnis #1")
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

	@TextSyntax("Importiere das Verzeichnis #1")
	public void importiereDasVerzeichnisTmptest(final String folderPfad) {
		final File folder = new File(folderPfad);
		fileService.addManagedFolder(folder);
	}

	@TextSyntax("Es existiert ein Datenbankeintrag #1 mit Pfad #2")
	public void esExistiertEinDatenbankeintragMitPfad(final String Test1txt,
			final String tmptestfolder1) {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	@TextSyntax("Lösche Verzeichnis #1")
	public void löscheVerzeichnis(final String folderPfad) {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

}
