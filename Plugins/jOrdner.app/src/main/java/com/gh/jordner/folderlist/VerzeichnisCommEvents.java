package com.gh.jordner.folderlist;

public class VerzeichnisCommEvents {

	final public static RemoveManagedFolders REMOVE_MANAGED_FOLDERS = new RemoveManagedFolders();
	final public static AddManagedFolder ADD_MANAGED_FOLDER = new AddManagedFolder();
	final public static SaveAll SAVE_ALL = new SaveAll();

	public static class RemoveManagedFolders extends VerzeichnisCommEvents {
	};

	public static class AddManagedFolder extends VerzeichnisCommEvents {
	};

	public static class SaveAll extends VerzeichnisCommEvents {
	}

	public static final String VIEWCOMMUNICATION_REMOVE_FOLDER = "viewcommunication/removeFolder";
	public static final String VIEWCOMMUNICATION_ADD_FOLDER = "viewcommunication/addFolder";
	public static final String VIEWCOMMUNICATION_SAVE_FOLDERS = "viewcommunication/saveFolders";;

}
