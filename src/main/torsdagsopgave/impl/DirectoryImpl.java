package main.torsdagsopgave.impl;

import main.torsdagsopgave.Directory;
import main.torsdagsopgave.DirectoryEntry;
import main.torsdagsopgave.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class DirectoryImpl extends DirectoryEntryImpl implements Directory {

    private final ArrayList<DirectoryEntry> children = new ArrayList<>();

    protected DirectoryImpl(String name) {
        super(name);
    }

    @Override
    public void addChild(DirectoryEntry entry) {
        children.add(entry);
    }

    @Override
    public File createFile(String name, String content) throws IOException {
        if(containsFileNamed(name)) {
            throw new IOException("File '" + name + "' already exists!");
        }
        File f = new FileImpl(name, content);
        addChild(f);
        return f;
    }

    @Override
    public Directory createSubDirectory(String name) throws IOException {
        if(containsDirectoryNamed(name)) {
            throw new IOException("Directory '" + name + "' already exists!");
        }
        Directory d = new DirectoryImpl(name);
        addChild(d);
        return d;
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

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public File asFile() {
        throw new UnsupportedOperationException("Not a file");
    }

    @Override
    public Directory asDirectory() {
        return this;
    }

    @Override
    public Iterator<DirectoryEntry> iterator() {
        return children.iterator();
    }
}