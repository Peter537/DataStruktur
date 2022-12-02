package main.filesystem.impl;

import main.filesystem.Directory;
import main.filesystem.DirectoryEntry;

abstract class DirectoryEntryImpl implements DirectoryEntry {

    private final String name;
    private final Directory parent;

    protected DirectoryEntryImpl(Directory parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Directory getParent() {
        return this.parent;
    }

    @Override
    public String getFullName() {
        if (getParent() == null) {
            return getName() + ":"; // root
        }
        return getParent().getFullName() + "/" + getName();
    }
}