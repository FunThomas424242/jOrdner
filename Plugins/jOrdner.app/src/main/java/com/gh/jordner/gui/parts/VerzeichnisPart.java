package com.gh.jordner.gui.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.gh.jordner.api.Verzeichnis;

@Creatable
public class VerzeichnisPart {

	// private Label label;
	private static TableViewer tableViewer;

	@PostConstruct
	public void createComposite(Composite parent) {
		parent.setLayout(new GridLayout());

		tableViewer = new TableViewer(parent);
		tableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		tableViewer.getTable().setHeaderVisible(true);
		tableViewer.getTable().setLinesVisible(true);

	}

	/**
	 * http://tomsondev.bestsolution.at/2011/02/07/enhanced-rcp-how-views-can-
	 * communicate-the-e4-way/
	 * 
	 * @param verzeichnis
	 */
	@Inject
	@Optional
	void eventReceived(
			@UIEventTopic("viewcommunication/addFolder") Verzeichnis verzeichnis) {
		final String folderName = verzeichnis.getName();
		if (!folderName.isEmpty()) {
			tableViewer.add(folderName);
		}
		System.out.println(">" + folderName + "<");
	}

	@Focus
	public void setFocus() {
		tableViewer.getTable().setFocus();
	}

}
