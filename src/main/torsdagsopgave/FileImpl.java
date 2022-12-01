package main.torsdagsopgave;

public class FileImpl extends DirectoryEntryImpl implements File {

    private String content;

    public FileImpl(String name, String content) {
        super(name, false, true);
        this.content = content;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }
}