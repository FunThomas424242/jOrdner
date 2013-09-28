package com.gh.jordner.gui.stories;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * JUnit test case generated from the file #className#.natspec.
 * 
 * Never modify this file. It will be overwritten by any changes in
 * #className#.natspec.
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class EclipseActions {

	private EclipseActionDriver eclipseActionDriver = null;

	@Test
	public void executeScript() throws Exception {
		// The code in this method is generated from: /jOrdner.app.test.natspec/src-endusertests/com/gh/jordner/gui/stories/EclipseActions.natspec
		// Never change this method or any contents of this file, all local changes will be overwritten.
		
		// Starte jOrdner
		eclipseActionDriver.starteJOrdner();
		// Füge Verzeichnis c:\\tmp zur Liste der verwalteten Verzeichnisse hinzu.
		eclipseActionDriver.fügeVerzeichnisZurListeDerVerwaltetenVerzeichnisseHinzu("c:\\tmp");
		// Beende jOrdner
		eclipseActionDriver.beende();
		
	}

	@Before
	public void setUp() {
		eclipseActionDriver = new EclipseActionDriver();
	}

	@After
	public void shutdown() {
		if (eclipseActionDriver != null)
			eclipseActionDriver = null;
	}
}
