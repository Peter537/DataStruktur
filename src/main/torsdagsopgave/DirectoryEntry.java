package main.torsdagsopgave;

public interface DirectoryEntry {

	String getName();

	String getFullName();

	Directory getParent();

	boolean isDirectory();

	boolean isFile();

	File asFile();

	Directory asDirectory();
}
