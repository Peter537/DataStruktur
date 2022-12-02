package main.torsdagsopgave.impl;

import main.torsdagsopgave.DirectoryEntry;

abstract class DirectoryEntryImpl implements DirectoryEntry {

    private final String name;

    protected DirectoryEntryImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}