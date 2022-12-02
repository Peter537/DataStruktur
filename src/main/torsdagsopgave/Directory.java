package main.torsdagsopgave;

import java.util.ArrayList;

public interface Directory extends DirectoryEntry {

	void addChild(DirectoryEntry entry);

	ArrayList<DirectoryEntry> getSortedChildren();

	boolean containsFileNamed(String name);

	boolean containsDirectoryNamed(String name);
}