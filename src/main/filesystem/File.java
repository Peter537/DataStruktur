package main.filesystem;

public interface File extends DirectoryEntry {

	String getContent();

	void setContent(String content);
}