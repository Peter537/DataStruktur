package main.opgave;

public abstract class DirectoryEntryImpl implements DirectoryEntry {

    private final String name;
    private final boolean isDirectory;
    private final boolean isFile;

    public DirectoryEntryImpl(String name, boolean isDirectory, boolean isFile) {
        this.name = name;
        this.isDirectory = isDirectory;
        this.isFile = isFile;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isDirectory() {
        return this.isDirectory;
    }

    @Override
    public boolean isFile() {
        return this.isFile;
    }

    @Override
    public File asFile() {
        if (!this.isFile()) {
            throw new IllegalStateException("Not a file");
        }
        return (File) this;
    }

    @Override
    public Directory asDirectory() {
        if (!this.isDirectory()) {
            throw new IllegalStateException("Not a directory");
        }
        return (Directory) this;
    }
}