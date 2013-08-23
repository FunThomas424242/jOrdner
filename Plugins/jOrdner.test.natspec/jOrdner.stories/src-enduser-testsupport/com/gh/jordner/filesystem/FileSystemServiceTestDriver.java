package com.gh.jordner.filesystem;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.gh.jordner.exceptions.DataAccessException;
import com.gh.jordner.filsesystem.FileSystemService;
import com.gh.jordner.jpa.filesystem.Verzeichnis;
import com.gh.jordner.jpa.filesystem.VerzeichnisDAO;

import de.devboost.natspec.annotations.TextSyntax;

public class FileSystemServiceTestDriver {

	@Mock
	private VerzeichnisDAO verzeichnisDAO;

	@InjectMocks
	private final FileSystemService fileService;

	private final List<Verzeichnis> MANAGED_FOLDERS = new ArrayList<Verzeichnis>();

	// given(verzeichnisDAO.listAllVerzeichnisse()).willReturn(1);

	/**
	 * Public constructor for test support class
	 */
	public FileSystemServiceTestDriver() {
		super();
		fileService = mock(FileSystemService.class);
	}

	@TextSyntax("Hinzufügen eines neuen Verzeichnisses #1 zur Liste der verwalteten Verzeichnisse")
	public void hinzufügenEinesNeuenVerzeichnissesZurListeDerVerwaltetenVerzeichnisse(
			final String folderPfad) {

		final File file = new File(folderPfad);
		final Verzeichnis verzeichnis = new Verzeichnis();
		verzeichnis.setName(file.getName());
		verzeichnis.setParentPathURI(file.getParentFile().getAbsolutePath());

		try {
			fileService.addManagedFolder(verzeichnis);

		} catch (DataAccessException e) {
			fail(e.toString());
		}
	}

	@TextSyntax("Auslesen aller verwalteten Verzeichnisse")
	public List<Verzeichnis> auslesenAllerVerwaltetenVerzeichnisse() {
		List<Verzeichnis> managedFolders = null;
		try {
			managedFolders = fileService.readAllManagedFolders();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return managedFolders;
	}

	@TextSyntax("Die Liste der verwalteten Verzeichnisse enhält #1 Einträge")
	public void dieListeDerVerwaltetenVerzeichnisseEnhältEinträge(
			final int itemCount, final List<Verzeichnis> managedFolders) {
		assertEquals(itemCount, managedFolders.size());
	}

	@TextSyntax("Eintrag #1 in der Liste der verwalteten Verzeichnisse heißt #2")
	public void eintragInDerListeDerVerwaltetenVerzeichnisseHeißt(
			final int itemIndex, final String folderName,
			final List<Verzeichnis> managedFolders) {

		final Verzeichnis verzeichnis = managedFolders.get(itemIndex);
		final String verzeichnisName = verzeichnis.getName();
		assertEquals(folderName, verzeichnisName);

	}

}
