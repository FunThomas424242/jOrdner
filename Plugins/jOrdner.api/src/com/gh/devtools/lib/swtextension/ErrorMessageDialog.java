package com.gh.devtools.lib.swtextension;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;
import org.osgi.framework.Version;

public class ErrorMessageDialog {

	private void logErrorStatus(final Logger logger,
			final MultiStatus errorStatus) {
		logger.error(errorStatus.getMessage());
	}

	public ErrorMessageDialog(final Logger logger, final Bundle bundle,
			String errorTitle, final Class callerClass,
			final Exception exception) {
		// read informations
		final Long id = bundle.getBundleId();

		// add details
		final String bundleName = bundle.getSymbolicName();
		final Version version = bundle.getVersion();
		final String className = callerClass.getName();
		// create Error status
		final MultiStatus errorStatus = new MultiStatus(bundleName,
				IStatus.ERROR, exception.getLocalizedMessage(), exception);
		String message = "Bundle-Id: " + Long.toString(id);
		appendMessage(bundleName, errorStatus, message);
		message = "Bundle-Version: " + version;
		appendMessage(bundleName, errorStatus, message);
		message = "Bundle-Name: " + bundleName;
		appendMessage(bundleName, errorStatus, message);
		message = "Class: " + className;
		appendMessage(bundleName, errorStatus, message);
		message = "Exception: " + exception.toString();
		appendMessage(bundleName, errorStatus, message);

		logErrorStatus(logger, errorStatus);
		// FIXME must be localized
		if (errorTitle == null) {
			errorTitle = "Error";
		}
		ErrorDialog.openError((Shell) null, errorTitle,
				"There was a error occur."
						+ "\n Select Details >> for more information."
						+ "\n See the Error Log for more information.",
				errorStatus);
	} // ErrorMessageDialog

	/**
	 * @param bundleName
	 * @param errorStatus
	 * @param message
	 */
	protected void appendMessage(final String bundleName,
			final MultiStatus errorStatus, String message) {
		errorStatus.add(new Status(IStatus.ERROR, bundleName, IStatus.ERROR,
				message, null));
	}

} // ErrorMessageDialog
