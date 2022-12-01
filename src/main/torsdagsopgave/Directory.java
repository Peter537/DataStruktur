package main.torsdagsopgave;

public interface Directory extends DirectoryEntry {

	void addChild(DirectoryEntry entry);

	Iterable<DirectoryEntry> getChildren();
}
