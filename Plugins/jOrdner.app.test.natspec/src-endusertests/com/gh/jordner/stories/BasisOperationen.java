package com.gh.jordner.stories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test case generated from the file #className#.natspec.
 * 
 * Never modify this file. It will be overwritten by any changes in
 * #className#.natspec.
 */
public class BasisOperationen {

	private TestSupport testSupport = null;

	@Test
	public void executeScript() throws Exception {
		// The code in this method is generated from: /jOrdner.app.test.natspec/src-endusertests/com/gh/jordner/stories/BasisOperationen.natspec
		// Never change this method or any contents of this file, all local changes will be overwritten.
		
		// Erstelle lokal das Verzeichnis C:\\tmp\\test\\folder1
		testSupport.createEntry("C:\\tmp\\test\\folder1");
		// Erstelle lokal das Verzeichnis C:\\tmp\\test\\folder2
		testSupport.createEntry("C:\\tmp\\test\\folder2");
		// Es existiert C:\\tmp\\test\\folder1 vom Typ Verzeichnis
		testSupport.esExistiertVomTypVerzeichnis("C:\\tmp\\test\\folder1");
		// Es existiert C:\\tmp\\test\\folder2 vom Typ Verzeichnis
		testSupport.esExistiertVomTypVerzeichnis("C:\\tmp\\test\\folder2");
		// Füge das Verzeichnis C:\\tmp\\test zur Liste der verwalteten Verzeichnisse hinzu
		testSupport.hinzufügenEinesNeuenVerzeichnissesZurListeDerVerwaltetenVerzeichnisse("C:\\tmp\\test");
		// Importiere den Inhalt vom Verzeichnis C:\\tmp\\test
		testSupport.importiereDasVerzeichnisTmptest("C:\\tmp\\test");
		// Es existiert ein Datenbankeintrag test vom Typ Verzeichnis mit Pfad C:\\tmp\\test\\folder1
		testSupport.esExistiertEinDatenbankeintragMitPfad("test", "C:\\tmp\\test\\folder1");
		// Es existiert ein Datenbankeintrag Test1.txt vom Typ Verzeichnis mit Pfad C:\\tmp\\test\\folder2
		testSupport.esExistiertEinDatenbankeintragMitPfad("Test1.txt", "C:\\tmp\\test\\folder2");
		// Lösche Verzeichnis C:\\tmp\\test\\folder1
		testSupport.löscheVerzeichnis("C:\\tmp\\test\\folder1");
		// Lösche Verzeichnis C:\\tmp\\test\\folder2
		testSupport.löscheVerzeichnis("C:\\tmp\\test\\folder2");
		
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
