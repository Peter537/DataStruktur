package main.torsdagsopgave;

public interface File extends DirectoryEntry {

	String getContent();

	void setContent(String content);
}