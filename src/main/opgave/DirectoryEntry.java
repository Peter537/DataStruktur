package main.opgave;

public interface DirectoryEntry {

	String getName();

	boolean isDirectory();

	boolean isFile();

	File asFile();

	Directory asDirectory();
}
