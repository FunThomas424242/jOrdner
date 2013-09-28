package com.gh.jordner.gui.actions.test;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public class QuitHandlerTest {

	private static SWTBot bot;

	@BeforeClass
	public static void beforeClass() throws Exception {
		SWTBotPreferences.TIMEOUT = 6000;
		bot = new SWTBot();
	}

	@AfterClass
	public static void sleep() {
		bot.sleep(2000);
	}

	@Test
	public void executeExit() {
		SWTBotMenu fileMenu = bot.menu("File");
		Assert.assertNotNull(fileMenu);
		SWTBotMenu exitMenu = fileMenu.menu("Quit");
		Assert.assertNotNull(exitMenu);
		exitMenu.click();
	}

}