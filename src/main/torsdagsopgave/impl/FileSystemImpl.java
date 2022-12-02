package main.torsdagsopgave.impl;

import main.torsdagsopgave.Directory;
import main.torsdagsopgave.FileSystem;

public class FileSystemImpl implements FileSystem {

    private final Directory root;

    public FileSystemImpl() {
        this.root = new DirectoryImpl("root");
    }

    @Override
    public Directory getRoot() {
        return this.root;
    }
}