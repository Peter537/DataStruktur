package main.filesystem.examples;

import main.filesystem.Directory;
import main.filesystem.File;
import main.filesystem.FileSystem;
import main.filesystem.impl.FileSystemImpl;

import java.io.IOException;

public class FileVisitorExample {

    public static void main(String[] args) throws IOException {
        FileSystem fs = new FileSystemImpl();
        Directory root = fs.getRoot();
        Directory dir1 = root.createSubDirectory("dir1");
        Directory dir2 = dir1.createSubDirectory("dir2");
        Directory dir3 = dir2.createSubDirectory("dir3");
        dir3.createFile("file1.txt", "content1");
        dir3.createFile("file2.txt", "content2");
        dir2.createFile("file3.txt", "content3");
        dir1.createFile("file4.txt", "content4");
        Directory dir4 = dir2.createSubDirectory("dir4");
        dir4.createFile("file5.txt", "content5");

        System.out.println("FILES:");
        System.out.println();
        root.visitFiles(f -> {
            System.out.println(f.getFullName());
            System.out.println(" -> " + f.getContent());
        });

        System.out.println();
        System.out.println("DIRECTORIES:");
        System.out.println();
        root.visitDirectories(d -> System.out.println(d.getFullName()));

        System.out.println();
        System.out.println("FILES AND DIRECTORIES:");
        System.out.println();
        root.visitDirectoryEntries(e -> {
            System.out.println(e.getFullName());
            if (e instanceof File) {
                System.out.println(" -> " + e.asFile().getContent());
            }
        });
    }
}