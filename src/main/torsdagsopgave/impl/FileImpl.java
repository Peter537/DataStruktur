package main.torsdagsopgave.impl;

import main.torsdagsopgave.Directory;
import main.torsdagsopgave.File;

class FileImpl extends DirectoryEntryImpl implements File {

    private String content;

    protected FileImpl(String name, String content) {
        super(name);
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

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public File asFile() {
        return this;
    }

    @Override
    public Directory asDirectory() {
        throw new UnsupportedOperationException("Not a directory");
    }
}