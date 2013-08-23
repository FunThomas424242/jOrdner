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
		
		// Hinzufügen eines neuen Verzeichnisses c:tmptest zur Liste der verwalteten Verzeichnisse
		fileSystemServiceTestDriver.hinzufügenEinesNeuenVerzeichnissesZurListeDerVerwaltetenVerzeichnisse("c:tmptest");
		// Auslesen aller verwalteten Verzeichnisse
		java.util.List list_ = fileSystemServiceTestDriver.auslesenAllerVerwaltetenVerzeichnisse();
		// Die Liste der verwalteten Verzeichnisse enhält 1 Einträge
		fileSystemServiceTestDriver.dieListeDerVerwaltetenVerzeichnisseEnhältEinträge(1, list_);
		// Eintrag 1 in der Liste der verwalteten Verzeichnisse heißt c:tmptest
		fileSystemServiceTestDriver.eintragInDerListeDerVerwaltetenVerzeichnisseHeißt(1, "c:tmptest", list_);
		// Hinzufügen eines neuen Verzeichnisses c:tmptest1 zur Liste der verwalteten Verzeichnisse
		fileSystemServiceTestDriver.hinzufügenEinesNeuenVerzeichnissesZurListeDerVerwaltetenVerzeichnisse("c:tmptest1");
		// Die Liste der verwalteten Verzeichnisse enhält 2 Einträge
		fileSystemServiceTestDriver.dieListeDerVerwaltetenVerzeichnisseEnhältEinträge(2, list_);
		// Eintrag 1 in der Liste der verwalteten Verzeichnisse heißt c:tmptest
		fileSystemServiceTestDriver.eintragInDerListeDerVerwaltetenVerzeichnisseHeißt(1, "c:tmptest", list_);
		// Eintrag 2 in der Liste der verwalteten Verzeichnisse heißt c:tmptest1
		fileSystemServiceTestDriver.eintragInDerListeDerVerwaltetenVerzeichnisseHeißt(2, "c:tmptest1", list_);
		
	}

}
