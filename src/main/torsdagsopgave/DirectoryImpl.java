package main.torsdagsopgave;

import java.util.ArrayList;

public class DirectoryImpl extends DirectoryEntryImpl implements Directory {

    private final ArrayList<DirectoryEntry> children = new ArrayList<>();

    public DirectoryImpl(String name) {
        super(name, true, false);
    }

    @Override
    public void addChild(DirectoryEntry entry) {
        children.add(entry);
    }

    @Override
    public Iterable<DirectoryEntry> getChildren() {
        return this.children;
    }
}