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

    @Override
    public ArrayList<DirectoryEntry> getSortedChildren() {
        ArrayList<DirectoryEntry> sortedChildren = new ArrayList<>(this.children);
        sortedChildren.sort((o1, o2) -> {
            if (o1.isDirectory() && o2.isFile()) {
                return -1;
            } else if (o1.isFile() && o2.isDirectory()) {
                return 1;
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return sortedChildren;
    }
}