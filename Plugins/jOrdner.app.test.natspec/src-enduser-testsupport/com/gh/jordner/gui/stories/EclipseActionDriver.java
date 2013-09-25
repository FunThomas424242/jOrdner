package com.gh.jordner.gui.stories;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.junit.Assert;

import de.devboost.natspec.annotations.TextSyntax;

public class EclipseActionDriver {

	private final SWTBot bot;

	/**
	 * Public constructor for test support class
	 */
	public EclipseActionDriver() {
		super();
		SWTBotPreferences.TIMEOUT = 6000;
		this.bot = new SWTBot();
	}

	@TextSyntax("Starte jOrdner")
	public void starteJOrdner() {
		this.bot.browserWithLabel("jOrdnerApp");
	}

	@TextSyntax("Füge Verzeichnis #1 zur Liste der verwalteten Verzeichnisse hinzu.")
	public void fügeVerzeichnisZurListeDerVerwaltetenVerzeichnisseHinzu(
			String ctmp) {
		SWTBotMenu fileMenu = bot.menu("File");
		Assert.assertNotNull(fileMenu);
		SWTBotMenu exitMenu = fileMenu.menu("Quit");
		Assert.assertNotNull(exitMenu);
		exitMenu.click();
	}

	@TextSyntax("Beende jOrdner")
	public void beende() {
		bot.sleep(2000);
	}
}
