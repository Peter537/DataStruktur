package main.torsdagsopgave;

public interface DirectoryEntry {

	String getName();

	Directory getParent();

	boolean isDirectory();

	boolean isFile();

	File asFile();

	Directory asDirectory();
}
