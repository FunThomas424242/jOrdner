package com.gh.jordner.filesystem;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.gh.jordner.filsesystem.FileSystemService;
import com.gh.jordner.jpa.filesystem.VerzeichnisDAO;

/**
 * JUnit test case generated from the file #className#.natspec.
 * 
 * Never modify this file. It will be overwritten by any changes in
 * #className#.natspec.
 */
@RunWith(MockitoJUnitRunner.class)
public class _NatSpecTemplate {

	private FileSystemServiceTestDriver fileSystemServiceTestDriver = null;

	@Mock
	private VerzeichnisDAO verzeichnisDAO;

	@InjectMocks
	private FileSystemService fileService;

	@BeforeClass
	public static void initClass() {

	}

	@Before
	public void setUp() {
		fileSystemServiceTestDriver = new FileSystemServiceTestDriver();
		fileSystemServiceTestDriver.setFileService(fileService);

		// given(verzeichnisDAO.listAllVerzeichnisse()).willReturn(1);
	}

	@After
	public void shutdown() {
		if (fileSystemServiceTestDriver != null)
			fileSystemServiceTestDriver = null;
	}

	@Test
	public void executeScript() throws Exception {
		/* @MethodBody */
	}

}
