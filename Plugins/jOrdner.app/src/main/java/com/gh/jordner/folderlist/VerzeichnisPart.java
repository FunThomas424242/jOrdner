package com.gh.jordner.folderlist;

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
import org.eclipse.e4.ui.workbench.swt.modeling.EMenuService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;

import com.gh.devtools.lib.swtextension.FolderBrowser;
import com.gh.jordner.jpa.filesystem.Verzeichnis;

@Creatable
public class VerzeichnisPart {

	@Inject
	private VerzeichnisPartModel modelProvider;

	private TableViewer tableViewer;

	@PostConstruct
	public void createComposite(Composite parent, EMenuService service) {
		tableViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		erzeugeSpalten(parent, tableViewer);
		tableViewer.setContentProvider(new ArrayContentProvider());
		modelProvider.reloadInput();
		tableViewer.setInput(modelProvider.getInput());
		tableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		tableViewer.getTable().setHeaderVisible(true);
		tableViewer.getTable().setLinesVisible(true);
		service.registerContextMenu(tableViewer.getTable(),
				"jordner.app.popupmenu.folderlist");

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
				Verzeichnis verzeichnis = (Verzeichnis) element;
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
				Verzeichnis verzeichnis = (Verzeichnis) element;
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

	@Inject
	@Optional
	void eventReceived(
			@UIEventTopic(VerzeichnisCommEvents.VIEWCOMMUNICATION_REMOVE_FOLDER) VerzeichnisCommEvents.RemoveManagedFolders event,
			@Named(IServiceConstants.ACTIVE_PART) MDirtyable dirtyable) {

		System.out.println("viewcommunication/removeFolder ausgeführt");

		int[] indizesToRemove = tableViewer.getTable().getSelectionIndices();

		modelProvider.markToRemove(indizesToRemove);
		modelProvider.deleteRemovedItemsFromInput();
		tableViewer.setInput(modelProvider.getInput());
		dirtyable.setDirty(true);

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
			@UIEventTopic(VerzeichnisCommEvents.VIEWCOMMUNICATION_ADD_FOLDER) VerzeichnisCommEvents.AddManagedFolder event,
			@Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			@Named(IServiceConstants.ACTIVE_PART) MDirtyable dirtyable) {

		System.out.println("viewcommunication/addFolder ausgeführt");

		final FolderBrowser dialog = new FolderBrowser(shell);
		final File folder = dialog.getFolder(null);

		boolean isInvalidEntry = (folder == null || folder.getName().isEmpty());
		if (!isInvalidEntry) {
			final Verzeichnis verzeichnis = new Verzeichnis();
			verzeichnis.setName(folder.getName());
			verzeichnis.setParentPathURI(folder.getParentFile()
					.getAbsolutePath());

			modelProvider.addVerzeichnis(verzeichnis);
			tableViewer.setInput(modelProvider.getInput());
			dirtyable.setDirty(true);

		}

	}

	@Inject
	@Optional
	void eventReceived(
			@UIEventTopic(VerzeichnisCommEvents.VIEWCOMMUNICATION_SAVE_FOLDERS) VerzeichnisCommEvents.SaveAll event,
			@Named(IServiceConstants.ACTIVE_PART) MDirtyable dirtyable) {

		System.out.println("viewcommunication/saveFolders ausgeführt");

		boolean doSave = (dirtyable != null && dirtyable.isDirty());
		if (doSave) {
			modelProvider.saveAll();
			dirtyable.setDirty(false);
		}

	}

	@Focus
	public void setFocus() {
		tableViewer.getTable().setFocus();
	}

}
