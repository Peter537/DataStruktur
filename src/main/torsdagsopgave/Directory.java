package main.torsdagsopgave;

import java.util.ArrayList;

public interface Directory extends DirectoryEntry, Iterable<DirectoryEntry> {

	void addChild(DirectoryEntry entry);

	ArrayList<DirectoryEntry> getSortedChildren();

	default boolean containsFileNamed(String fileName) {
		for (DirectoryEntry entry : this) {
			if (entry.isFile() && entry.getName().equalsIgnoreCase(fileName)) {
				return true;
			}
		}
		return false;
	}

	default boolean containsDirectoryNamed(String directoryName) {
		for (DirectoryEntry entry : this) {
			if (entry.isDirectory() && entry.getName().equalsIgnoreCase(directoryName)) {
				return true;
			}
		}
		return false;
	}
}