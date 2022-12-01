package main.torsdagsopgave;

public interface DirectoryEntry {

	String getName();

	boolean isDirectory();

	boolean isFile();

	File asFile();

	Directory asDirectory();
}
