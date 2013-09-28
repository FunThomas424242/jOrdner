package com.gh.jordner.filesystem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test case generated from the file #className#.natspec.
 * 
 * Never modify this file. It will be overwritten by any changes in
 * #className#.natspec.
 */
public class FileSystemServiceBasics {

	private FileSystemServiceTestDriver fileSystemServiceTestDriver = null;

	@Before
	public void setUp() {
		fileSystemServiceTestDriver = new FileSystemServiceTestDriver();

	}

	@After
	public void shutdown() {
		if (fileSystemServiceTestDriver != null)
			fileSystemServiceTestDriver = null;
	}

	@Test
	public void executeScript() throws Exception {
		// The code in this method is generated from: /jOrdner.app.test.integration/src-endusertests/com/gh/jordner/filesystem/FileSystemServiceBasics.natspec
		// Never change this method or any contents of this file, all local changes will be overwritten.
		
		// Hinzufügen eines neuen Verzeichnisses C:\\tmp\\test zur Liste der verwalteten Verzeichnisse
		fileSystemServiceTestDriver.hinzufügenEinesNeuenVerzeichnissesZurListeDerVerwaltetenVerzeichnisse("C:\\tmp\\test");
		// Auslesen aller verwalteten Verzeichnisse
		java.util.List list_ = fileSystemServiceTestDriver.auslesenAllerVerwaltetenVerzeichnisse();
		// Die Liste der verwalteten Verzeichnisse enhält 1 Einträge
		fileSystemServiceTestDriver.dieListeDerVerwaltetenVerzeichnisseEnhältEinträge(1, list_);
		// Eintrag 1 in der Liste der verwalteten Verzeichnisse heißt test mit Pfad C:\\tmp\\test
		fileSystemServiceTestDriver.eintragInDerListeDerVerwaltetenVerzeichnisseHeißt(1, "test", "C:\\tmp\\test", list_);
		// Hinzufügen eines neuen Verzeichnisses C:\\tmp\\test1 zur Liste der verwalteten Verzeichnisse
		fileSystemServiceTestDriver.hinzufügenEinesNeuenVerzeichnissesZurListeDerVerwaltetenVerzeichnisse("C:\\tmp\\test1");
		// Auslesen aller verwalteten Verzeichnisse
		java.util.List list_0 = fileSystemServiceTestDriver.auslesenAllerVerwaltetenVerzeichnisse();
		// Die Liste der verwalteten Verzeichnisse enhält 2 Einträge
		fileSystemServiceTestDriver.dieListeDerVerwaltetenVerzeichnisseEnhältEinträge(2, list_0);
		// Eintrag 1 in der Liste der verwalteten Verzeichnisse heißt test mit Pfad C:\\tmp\\test
		fileSystemServiceTestDriver.eintragInDerListeDerVerwaltetenVerzeichnisseHeißt(1, "test", "C:\\tmp\\test", list_0);
		// Eintrag 2 in der Liste der verwalteten Verzeichnisse heißt test1 mit Pfad C:\\tmp\\test1
		fileSystemServiceTestDriver.eintragInDerListeDerVerwaltetenVerzeichnisseHeißt(2, "test1", "C:\\tmp\\test1", list_0);
		
	}

}
