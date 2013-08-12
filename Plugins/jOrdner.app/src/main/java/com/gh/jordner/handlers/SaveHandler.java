package com.gh.jordner.handlers;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MContribution;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Shell;

public class SaveHandler {

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
	public void execute(
			final IEclipseContext context,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			@Named(IServiceConstants.ACTIVE_PART) final MContribution contribution)
			throws InvocationTargetException, InterruptedException {

		// HINT:
		// http://tomsondev.bestsolution.at/2011/02/07/enhanced-rcp-how-views-can-communicate-the-e4-way/
		eventBroker.send("viewcommunication/saveFolders", Boolean.TRUE);
		// eventBroker.post("viewcommunication/asyncEvent", verzeichnis);

		// final IEclipseContext pmContext = context.createChild();
		//
		// ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
		// dialog.open();
		// dialog.run(true, true, new IRunnableWithProgress() {
		// @Override
		// public void run(IProgressMonitor monitor)
		// throws InvocationTargetException, InterruptedException {
		// pmContext.set(IProgressMonitor.class.getName(), monitor);
		// if (contribution != null) {
		// Object clientObject = contribution.getObject();
		//					//					ContextInjectionFactory.invoke(clientObject, Persist.class, //$NON-NLS-1$
		// // pmContext, null);
		// }
		// }
		// });
		//
		// pmContext.dispose();
	}
}
