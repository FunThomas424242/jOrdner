package com.gh.jordner.folderlist;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;

public class AddVerzeichnisHandler {

	@Inject
	private IEventBroker eventBroker;

	@Execute
	public void execute() {

		// HINT:
		// http://tomsondev.bestsolution.at/2011/02/07/enhanced-rcp-how-views-can-communicate-the-e4-way/
		eventBroker.send(VerzeichnisCommEvents.VIEWCOMMUNICATION_ADD_FOLDER,
				VerzeichnisCommEvents.ADD_MANAGED_FOLDER);
		// eventBroker.post("viewcommunication/asyncEvent", verzeichnis);
		// }
	}
}
