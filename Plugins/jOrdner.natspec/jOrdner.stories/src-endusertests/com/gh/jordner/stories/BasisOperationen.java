package com.gh.jordner.stories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gh.jordner.stories.TestSupport;

/**
 * JUnit test case generated from the file #className#.natspec. 
 *
 * Never modify this file. It will be overwritten by any changes
 * in #className#.natspec. 
 */
public class BasisOperationen {

	private TestSupport testSupport = null;

	@Test
	public void executeScript() throws Exception {
		// The code in this method is generated from: /jOrdner.natspec/src-endusertests/com/gh/jordner/stories/BasisOperationen.natspec
		// Never change this method or any contents of this file, all local changes will be overwritten.
		
		// Erstelle ein Verzeichnis /tmp/test/folder1
		testSupport.createEntry("/tmp/test/folder1");
		// Es existiert /tmp/test/folder1 vom Typ Verzeichnis
		testSupport.esExistiertVomTypVerzeichnis("/tmp/test/folder1");
		// Erstelle ein Verzeichnis /tmp/test/folder2
		testSupport.createEntry("/tmp/test/folder2");
		// Es existiert /tmp/test/folder2 vom Typ Verzeichnis
		testSupport.esExistiertVomTypVerzeichnis("/tmp/test/folder2");
		// Erstelle eine Datei Test1.txt im Verzeichnis /tmp/test/folder1
		testSupport.erstelleEineDateiImVerzeichnis("Test1.txt", "/tmp/test/folder1");
		// Erstelle eine Datei Test1.txt im Verzeichnis /tmp/test/folder2
		testSupport.erstelleEineDateiImVerzeichnis("Test1.txt", "/tmp/test/folder2");
		// Importiere das Verzeichnis /tmp/test
		testSupport.importiereDasVerzeichnisTmptest("/tmp/test");
		// Es existiert ein Datenbankeintrag Test1.txt mit Pfad /tmp/test/folder1
		testSupport.esExistiertEinDatenbankeintragMitPfad("Test1.txt", "/tmp/test/folder1");
		// Es existiert ein Datenbankeintrag Test1.txt mit Pfad /tmp/test/folder2
		testSupport.esExistiertEinDatenbankeintragMitPfad("Test1.txt", "/tmp/test/folder2");
		// Lösche Verzeichnis /tmp/test/folder1
		testSupport.löscheVerzeichnis("/tmp/test/folder1");
		// Lösche Verzeichnis /tmp/test/folder2
		testSupport.löscheVerzeichnis("/tmp/test/folder2");
		
	}
	
	@Before
	public void setUp() {
		testSupport = new TestSupport();
	}
	
	@After 
	public void shutdown() {
		if (testSupport != null)  
			testSupport = null;
	}
}
