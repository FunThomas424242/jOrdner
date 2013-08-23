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
		// The code in this method is generated from: /jOrdner.test.natspec/src-endusertests/com/gh/jordner/filesystem/FileSystemServiceBasics.natspec
		// Never change this method or any contents of this file, all local changes will be overwritten.
		
		// Hinzufügen eines neuen Verzeichnisses C:tmptest zur Liste der verwalteten Verzeichnisse
		fileSystemServiceTestDriver.hinzufügenEinesNeuenVerzeichnissesZurListeDerVerwaltetenVerzeichnisse("C:tmptest");
		// Auslesen aller verwalteten Verzeichnisse
		java.util.List list_ = fileSystemServiceTestDriver.auslesenAllerVerwaltetenVerzeichnisse();
		// Die Liste der verwalteten Verzeichnisse enhält 1 Einträge
		fileSystemServiceTestDriver.dieListeDerVerwaltetenVerzeichnisseEnhältEinträge(1, list_);
		// Eintrag 1 in der Liste der verwalteten Verzeichnisse heißt test mit Pfad C:tmptest
		fileSystemServiceTestDriver.eintragInDerListeDerVerwaltetenVerzeichnisseHeißt(1, "test", "C:tmptest", list_);
		// Hinzufügen eines neuen Verzeichnisses C:tmptest1 zur Liste der verwalteten Verzeichnisse
		fileSystemServiceTestDriver.hinzufügenEinesNeuenVerzeichnissesZurListeDerVerwaltetenVerzeichnisse("C:tmptest1");
		// Die Liste der verwalteten Verzeichnisse enhält 2 Einträge
		fileSystemServiceTestDriver.dieListeDerVerwaltetenVerzeichnisseEnhältEinträge(2, list_);
		// Eintrag 1 in der Liste der verwalteten Verzeichnisse heißt test mit Pfad C:tmptest
		fileSystemServiceTestDriver.eintragInDerListeDerVerwaltetenVerzeichnisseHeißt(1, "test", "C:tmptest", list_);
		// Eintrag 2 in der Liste der verwalteten Verzeichnisse heißt test1 mit Pfad C:tmptest1
		fileSystemServiceTestDriver.eintragInDerListeDerVerwaltetenVerzeichnisseHeißt(2, "test1", "C:tmptest1", list_);
		
	}

}
