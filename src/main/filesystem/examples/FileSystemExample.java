package main.filesystem.examples;

import main.filesystem.*;
import main.filesystem.impl.FileSystemImpl;

import java.io.IOException;
import java.util.Scanner;

public class FileSystemExample {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        FileSystemExample example = new FileSystemExample();
        example.run();
    }

    public void createDefaultFiles(FileSystem fs) throws IOException {
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
    }

    public void run() throws IOException {
        FileSystem fileSystem = new FileSystemImpl();
        createDefaultFiles(fileSystem);
        while (true) {
            clearConsole();
            System.out.println("Du er i " + fileSystem.getRoot().getName());
            System.out.println("Vil du forlade programmet? (ja/nej)");
            String choice = getUserInput("Vil du forlade programmet? (ja/nej): ");
            if (choice.equalsIgnoreCase("ja")) {
                break;
            } else if (choice.equalsIgnoreCase("nej")) {
                inDirectory(fileSystem.getRoot());
            } else {
                System.out.println("Forkert svar. Prøv igen.");
                pressEnterToContinue();
            }
        }
    }

    private void inDirectory(Directory directory) throws IOException {
        while (true) {
            clearConsole();
            System.out.println("Du er i " + directory.getFullName());
            System.out.println();
            System.out.println("Vælg en af følgende:");
            System.out.println("  0) Tilbage");
            System.out.println("  1) Opret en fil");
            System.out.println("  2) Opret en mappe");
            System.out.println("  3) Se indhold af en mappe");
            System.out.println("  4) Vælg en mappe eller en fil");
            String choice = getUserInput("Skriv dit valg: ");
            switch (choice) {
                case "0" -> {
                    return;
                }
                case "1" -> {
                    String name = getUserInput("Filnavn: ");
                    String content = getUserInput("Filindhold: ");
                    System.out.println();
                    if (!directory.containsFileNamed(name)) {
                        File createdFile = directory.createFile(name, content);
                        System.out.println("Filen '" + createdFile.getName() + "' oprettet.");
                    } else {
                        System.out.println("Filen findes allerede.");
                    }
                    pressEnterToContinue();
                }
                case "2" -> {
                    String name = getUserInput("Mappenavn: ");
                    System.out.println();
                    if (!directory.containsDirectoryNamed(name)) {
                        Directory createdDirectory = directory.createSubDirectory(name);
                        System.out.println("Mappen '" + createdDirectory.getName() + "' oprettet.");
                    } else {
                        System.out.println("Mappen findes allerede.");
                    }
                    pressEnterToContinue();
                }
                case "3" -> {
                    showDirectory(directory);
                    pressEnterToContinue();
                }
                case "4" -> chooseDirectoryOrFile(directory);
            }
        }
    }

    private void showDirectory(Directory directory) {
        clearConsole();
        System.out.println("Indhold af " + directory.getFullName());
        for (DirectoryEntry entry : directory.getSortedChildren()) {
            System.out.println("  -> " + entry.getName() + " (" + (entry.isDirectory() ? "mappe" : "fil") + ")");
        }
    }

    private void chooseDirectoryOrFile(Directory directory) throws IOException {
        while (true) {
            clearConsole();
            showDirectory(directory);
            System.out.println();
            String searchName = getUserInput("Skriv navnet på en mappe eller fil: ");
            if (!directory.containsEntryNamed(searchName)) {
                System.out.println("Der fandtes ingen mapper eller filer med navnet '" + searchName + "'.");
                continue;
            }

            DirectoryEntry selected = directory.getEntry(searchName);
            if (selected.isDirectory()) {
                inDirectory(selected.asDirectory());
            } else {
                showFile(selected.asFile());
            }
            return;
        }
    }

    private void showFile(File file) {
        while (true) {
            clearConsole();
            System.out.println("Du har valgt filen " + file.getName());
            System.out.println("Vælg en af følgende muligheder:");
            System.out.println("  0) Tilbage");
            System.out.println("  1) Se indhold");
            System.out.println("  2) Rediger indhold");
            String choice = getUserInput("Skriv dit valg: ");
            switch (choice) {
                case "0" -> {
                    return;
                }
                case "1" -> {
                    clearConsole();
                    System.out.println("Indhold af " + file.getName());
                    System.out.println(" -> " + file.getContent());
                    pressEnterToContinue();
                }
                case "2" -> {
                    clearConsole();
                    System.out.println("Hvilket nye filindhold vil du have i filen '" + file.getName() + "'?");
                    String content = getUserInput("Skriv nyt filindhold: ");
                    file.setContent(content);
                    pressEnterToContinue();
                }
            }
        }
    }

    private void pressEnterToContinue() {
        System.out.println();
        System.out.println("Tryk enter for at fortsætte");
        scanner.nextLine();
    }

    private String getUserInput(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    private void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}