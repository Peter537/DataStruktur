package main.opgave;

public interface File extends DirectoryEntry {

	String getContent();

	void setContent(String content);
}