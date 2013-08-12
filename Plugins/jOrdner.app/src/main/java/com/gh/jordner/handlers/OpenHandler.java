package com.gh.jordner.handlers;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Shell;

import com.gh.devtools.lib.swtextension.FolderBrowser;
import com.gh.jordner.api.Verzeichnis;
import com.gh.jordner.business.service.FileSystemService;

public class OpenHandler {

	@Inject
	private IEventBroker eventBroker;

	@Inject
	private FileSystemService fileService;

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {

		final FolderBrowser dialog = new FolderBrowser(shell);
		final File folder = dialog.getFolder(null);
		if (folder != null) {
			final Verzeichnis verzeichnis = fileService
					.addManagedFolder(folder);
			// HINT:
			// http://tomsondev.bestsolution.at/2011/02/07/enhanced-rcp-how-views-can-communicate-the-e4-way/
			eventBroker.send("viewcommunication/addFolder", verzeichnis);
			// eventBroker.post("viewcommunication/asyncEvent", verzeichnis);
		}
	}
}
