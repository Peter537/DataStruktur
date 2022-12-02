package main.torsdagsopgave;

public abstract class DirectoryEntryImpl implements DirectoryEntry {

    private final String name;

    protected DirectoryEntryImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}