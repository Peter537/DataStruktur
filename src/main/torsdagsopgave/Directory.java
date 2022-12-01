package main.torsdagsopgave;

import java.util.ArrayList;

public interface Directory extends DirectoryEntry {

	void addChild(DirectoryEntry entry);

	Iterable<DirectoryEntry> getChildren();

	ArrayList<DirectoryEntry> getSortedChildren();
}