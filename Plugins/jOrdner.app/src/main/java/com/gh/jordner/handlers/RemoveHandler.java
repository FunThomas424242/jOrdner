package com.gh.jordner.handlers;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;

public class RemoveHandler {

	@Inject
	private IEventBroker eventBroker;

	@CanExecute
	public boolean canExecute() {
		// TODO Your code goes here
		return true;
	}

	@Execute
	public void execute() {

		// HINT:
		// http://tomsondev.bestsolution.at/2011/02/07/enhanced-rcp-how-views-can-communicate-the-e4-way/
		eventBroker.send("viewcommunication/removeFolder",
				CommEventTyp.REMOVE_MANAGED_FOLDERS);

	}
}