package main.filesystem;

import java.io.IOException;
import java.util.ArrayList;

public interface Directory extends DirectoryEntry, Iterable<DirectoryEntry> {

	File createFile(String name, String content) throws IOException;

	Directory createSubDirectory(String name) throws IOException;

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