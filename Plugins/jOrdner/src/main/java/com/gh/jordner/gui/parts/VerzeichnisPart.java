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
package com.gh.jordner.gui.parts;

import java.text.DateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

@Creatable
public class VerzeichnisPart {

	@Inject
	private IEventBroker eventBroker;

	// private Label label;
	private static TableViewer tableViewer;

	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout());

		tableViewer = new TableViewer(parent);
		tableViewer.add("Sample item 1");
		tableViewer.add("Sample item 2");
		tableViewer.add("Sample item 3");
		tableViewer.add("Sample item 4");
		tableViewer.add("Sample item 5");
		tableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));

		// parent.setLayout(new FillLayout());
		// tableViewer = new TableViewer(parent);
		tableViewer.getTable().setHeaderVisible(true);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				return DateFormat.getDateTimeInstance().format(element);
			}
		});

		// eventBroker.send("viewcommunication/syncEvent",new Date());
		// eventBroker.post("viewcommunication/asyncEvent", new Date());

	}

	@Inject
	@Optional
	void eventReceived(@UIEventTopic("viewcommunication/*") Date obj) {
		tableViewer.add(obj);
		System.out.println(obj);
	}

	@Focus
	public void setFocus() {
		tableViewer.getTable().setFocus();
	}

	// public TableViewer getTableViewer(){
	// return tableViewer;
	// }

	// public void addVerzeichnisEintrag(Verzeichnis verzeichnis) {
	// final String verzeichnisName=verzeichnis.getName();
	// tableViewer.replace("test1", 0);
	// tableViewer.insert("verzeichnisName", 1);
	// tableViewer.add(verzeichnisName);
	// tableViewer.getTable().pack();
	// System.out.println("Verzeichniseintrag "+verzeichnisName+" hinzugefügt.");
	// }
}
