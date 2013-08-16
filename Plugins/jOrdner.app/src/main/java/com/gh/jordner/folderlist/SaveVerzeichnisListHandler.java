package com.gh.jordner.folderlist;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.services.IServiceConstants;

public class SaveVerzeichnisListHandler {

	@Inject
	private IEventBroker eventBroker;

	@CanExecute
	public boolean canExecute(
			@Named(IServiceConstants.ACTIVE_PART) MDirtyable dirtyable) {
		if (dirtyable == null) {
			return false;
		}
		return dirtyable.isDirty();
	}

	@Execute
	public void execute(final IEclipseContext context)

	throws InvocationTargetException, InterruptedException {

		// HINT:
		// http://tomsondev.bestsolution.at/2011/02/07/enhanced-rcp-how-views-can-communicate-the-e4-way/
		eventBroker.send(VerzeichnisCommEvents.VIEWCOMMUNICATION_SAVE_FOLDERS,
				VerzeichnisCommEvents.SAVE_ALL);

	}
}
