/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.gh.jordner.gui.handlers;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.gh.devtools.lib.swtextension.FolderBrowser;
import com.gh.jordner.gui.parts.VerzeichnisPart;
import com.gh.jordner.integration.dao.VerzeichnisServiceDAOImpl;
import com.gh.jordner.integration.entity.Verzeichnis;

public class OpenHandler {

	@Inject
	VerzeichnisServiceDAOImpl dao;

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			@Named("jordner.part.folderlist") VerzeichnisPart part) {

		final FolderBrowser dialog = new FolderBrowser(shell);
		final File folder = dialog.getFolder(null);
		if (folder != null) {
			final Verzeichnis verzeichnis = new Verzeichnis();
			verzeichnis.setName(folder.getName());
			dao.create(verzeichnis);
			printTable(part);
			part.addVerzeichnisEintrag(verzeichnis);
			printTable(part);		
		}
	}

	private void printTable(VerzeichnisPart part) {
		final Table table=part.getTableViewer().getTable();
		final TableItem[] items = table.getItems();
		for (TableItem item : items) {
			System.out.println(item.getText());
		}
	}
}
