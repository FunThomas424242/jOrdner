package com.gh.devtools.utils;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * @author SchubertT006
 * 
 */
public class FolderBrowser {

	protected Shell swtShell;

	public FolderBrowser(final Shell shell) {
		swtShell = shell;
	}

	/**
	 * Helper to open the folder chooser dialog.
	 * 
	 */
	public File getFolder(File filterPath) {

		DirectoryDialog dialog = new DirectoryDialog(this.swtShell, SWT.OPEN
				| SWT.SHEET);
		
		if (filterPath != null) {
			dialog.setFilterPath(filterPath.getPath());
		}

		String filePath = dialog.open();
		if (filePath != null) {
			filePath = filePath.trim();
			if (filePath.length() > 0) {
				return new File(filePath);
			}
		}

		return null;
	}
}