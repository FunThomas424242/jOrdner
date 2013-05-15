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
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
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
	private IEventBroker eventBroker;

	@Inject
	VerzeichnisServiceDAOImpl dao;

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {

		final FolderBrowser dialog = new FolderBrowser(shell);
		final File folder = dialog.getFolder(null);
		if (folder != null) {
			final Verzeichnis verzeichnis = new Verzeichnis();
			verzeichnis.setName(folder.getName());
			dao.create(verzeichnis);
			//HINT: http://tomsondev.bestsolution.at/2011/02/07/enhanced-rcp-how-views-can-communicate-the-e4-way/
			eventBroker.send("viewcommunication/syncEvent", verzeichnis);
			//eventBroker.post("viewcommunication/asyncEvent", verzeichnis);
		}
	}

}