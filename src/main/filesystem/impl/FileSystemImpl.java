package main.filesystem.impl;

import main.filesystem.Directory;
import main.filesystem.FileSystem;

public class FileSystemImpl implements FileSystem {

    private final Directory root;

    public FileSystemImpl() {
        this.root = new DirectoryImpl(null, "root");
    }

    @Override
    public Directory getRoot() {
        return this.root;
    }
}