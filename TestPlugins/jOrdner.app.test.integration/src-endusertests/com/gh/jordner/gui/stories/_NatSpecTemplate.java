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
public class _NatSpecTemplate {

	private EclipseActionDriver eclipseActionDriver = null;

	@Test
	public void executeScript() throws Exception {
		/* @MethodBody */
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
