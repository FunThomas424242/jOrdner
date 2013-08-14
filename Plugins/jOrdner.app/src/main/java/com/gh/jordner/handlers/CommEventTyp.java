package com.gh.jordner.handlers;

public class CommEventTyp {

	final public static RemoveManagedFolders REMOVE_MANAGED_FOLDERS = new RemoveManagedFolders();
	final public static AddManagedFolder ADD_MANAGED_FOLDER = new AddManagedFolder();
	final public static SaveAll SAVE_ALL = new SaveAll();

	public static class RemoveManagedFolders extends CommEventTyp {
	};

	public static class AddManagedFolder extends CommEventTyp {
	};

	public static class SaveAll extends CommEventTyp {
	};

}
