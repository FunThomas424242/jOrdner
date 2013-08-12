package com.gh.jordner.gui.parts;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;

import com.gh.jordner.business.service.FileSystemService;
import com.gh.jordner.jpa.filesystem.VerzeichnisImpl;

@Creatable
public class VerzeichnisPart {

	@Inject
	FileSystemService fileService;

	VerzeichnisPartModelProvider modelProvider;

	private TableViewer tableViewer;

	@PostConstruct
	public void createComposite(Composite parent) {
		modelProvider = VerzeichnisPartModelProvider.getInstance();
		modelProvider.setVerzeichnisse(fileService.lesenAllerVerzeichnisse());
		tableViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		erzeugeSpalten(parent, tableViewer);
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setInput(modelProvider.getVerzeichnisse());
		tableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		tableViewer.getTable().setHeaderVisible(true);
		tableViewer.getTable().setLinesVisible(true);

	}

	// This will create the columns for the table
	private void erzeugeSpalten(final Composite parent, final TableViewer viewer) {
		final String[] titles = { "Verzeichnis", "Pfad" };
		final int[] spaltenBreiten = { 100, 200 };

		int spaltenIndex = -1;
		// Verzeichnis Name
		spaltenIndex = 0;
		TableViewerColumn col = erzeugeSpaltenDefinition(viewer,
				titles[spaltenIndex], spaltenBreiten[spaltenIndex],
				spaltenIndex);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				VerzeichnisImpl verzeichnis = (VerzeichnisImpl) element;
				return verzeichnis.getName();
			}
		});

		// Verzeichnis Pfad
		spaltenIndex = 1;
		col = erzeugeSpaltenDefinition(viewer, titles[spaltenIndex],
				spaltenBreiten[spaltenIndex], spaltenIndex);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				VerzeichnisImpl verzeichnis = (VerzeichnisImpl) element;
				return verzeichnis.getParentPathURI();
			}
		});

	}

	private TableViewerColumn erzeugeSpaltenDefinition(
			final TableViewer viewer, final String spaltenName,
			int spaltenBreite, final int spaltenNummer) {
		final TableViewerColumn spaltenDefinition = new TableViewerColumn(
				viewer, SWT.NONE);
		final TableColumn spalte = spaltenDefinition.getColumn();
		spalte.setText(spaltenName);
		spalte.setWidth(spaltenBreite);
		spalte.setResizable(true);
		spalte.setMoveable(true);
		return spaltenDefinition;
	}

	/**
	 * http://tomsondev.bestsolution.at/2011/02/07/enhanced-rcp-how-views-can-
	 * communicate-the-e4-way/
	 * 
	 * @param folder
	 */
	@Inject
	@Optional
	void eventReceived(
			@UIEventTopic("viewcommunication/addFolder") File folder,
			@Named(IServiceConstants.ACTIVE_PART) MDirtyable dirtyable) {

		System.out.println("viewcommunication/addFolder ausgeführt");

		boolean isInvalidEntry = (folder == null || folder.getName().isEmpty());
		if (!isInvalidEntry) {
			final VerzeichnisImpl verzeichnis = new VerzeichnisImpl();
			verzeichnis.setName(folder.getName());
			verzeichnis.setParentPathURI(folder.getParentFile()
					.getAbsolutePath());

			modelProvider.addVerzeichnis(verzeichnis);
			tableViewer.setInput(modelProvider.getVerzeichnisse());
			dirtyable.setDirty(true);

		}

	}

	@Inject
	@Optional
	void eventReceived(
			@UIEventTopic("viewcommunication/saveFolders") Boolean isDirty,
			@Named(IServiceConstants.ACTIVE_PART) MDirtyable dirtyable) {

		System.out.println("viewcommunication/saveFolders ausgeführt");

		boolean doSave = (dirtyable != null && dirtyable.isDirty());
		if (doSave) {
			final ArrayContentProvider contentProvider = (ArrayContentProvider) tableViewer
					.getContentProvider();
			final Object[] items = contentProvider.getElements(tableViewer
					.getInput());
			for (int i = 0; i < items.length; i++) {
				final VerzeichnisImpl verzeichnis = (VerzeichnisImpl) items[i];
				if (verzeichnis.getId() == null) {
					try {
						fileService.speichernVerzeichnis(verzeichnis);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println("getElements()");
			dirtyable.setDirty(false);
		}

	}

	@Focus
	public void setFocus() {
		tableViewer.getTable().setFocus();
	}

}
