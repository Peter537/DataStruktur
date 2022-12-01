package main.opgave;

public class FileImpl extends DirectoryEntryImpl implements File {

    private final String content;

    public FileImpl(String name, String content) {
        super(name, false, true);
        this.content = content;
    }

    @Override
    public String getContent() {
        return this.content;
    }
}