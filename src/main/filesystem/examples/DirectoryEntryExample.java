package main.filesystem.examples;

import main.filesystem.*;
import main.filesystem.impl.FileSystemImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DirectoryEntryExample {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        DirectoryEntryExample example = new DirectoryEntryExample();
        example.run();
    }

    public void run() throws IOException {
        FileSystem fileSystem = new FileSystemImpl();
        while (true) {
            System.out.println("Du er i " + fileSystem.getRoot().getName());
            System.out.println("Vil du forlade programmet? (ja/nej)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("ja")) {
                break;
            } else if (choice.equalsIgnoreCase("nej")) {
                inDirectory(fileSystem.getRoot());
            } else {
                System.out.println("Forkert svar. Prøv igen.");
            }
        }
    }

    private void inDirectory(Directory directory) throws IOException {
        while (true) {
            try {
                System.out.println("Du er i " + directory.getName());
                System.out.println();
                System.out.println("Vælg en af følgende:");
                System.out.println("  0) Tilbage");
                System.out.println("  1) Opret en fil");
                System.out.println("  2) Opret en mappe");
                System.out.println("  3) Se indhold af en mappe");
                System.out.println("  4) Vælg en mappe eller en fil");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 0 -> {
                        return;
                    }
                    case 1 -> {
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
                    case 2 -> {
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
                    case 3 -> {
                        showDirectory(directory);
                        pressEnterToContinue();
                    }
                    case 4 -> chooseDirectoryOrFile(directory);
                }
            } catch (InputMismatchException e) {
                System.out.println("Ugyldigt input");
                scanner.nextLine();
            }
        }
    }

    private void showDirectory(Directory directory) {
        System.out.println("Indhold af " + directory.getFullName() + ":");
        int i = 1;
        for (DirectoryEntry entry : directory.getSortedChildren()) {
            System.out.println("  " + i + ") " + entry.getName());
            i++;
        }
    }

    private void chooseDirectoryOrFile(Directory currentDirectory) throws IOException {
        while (true) {
            try {
                System.out.println("Indhold af " + currentDirectory.getFullName() + ":");
                ArrayList<DirectoryEntry> entries = currentDirectory.getSortedChildren();
                int i = 1;
                for (DirectoryEntry entry : entries) {
                    System.out.println("  " + i + ") " + entry.getName() + " (" + (entry.isDirectory() ? "mappe" : "fil") + ")");
                    i++;
                }

                System.out.println();
                System.out.print("Vælg en mappe eller fil indeks: ");
                DirectoryEntry selected;
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 0) {
                    return;
                }
                if (entries.size() >= choice - 1) {
                    selected = entries.get(choice - 1);
                } else {
                    System.out.println("Ugyldigt valg");
                    continue;
                }

                if (selected.isDirectory()) {
                    inDirectory(selected.asDirectory());
                } else {
                    showFile(selected.asFile());
                }
                return;
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
        }
    }

    private void showFile(File file) {
        while (true) {
            try {
                System.out.println("Indhold af " + file.getName() + ":");
                System.out.println(file.getContent());
                System.out.println();
                System.out.println("Vælg en af følgende muligheder:");
                System.out.println("  0) Tilbage");
                System.out.println("  1) Rediger fil");
                System.out.print("Skriv dit valg: ");
                int input = scanner.nextInt();
                scanner.nextLine();
                switch (input) {
                    case 0 -> {
                        return;
                    }
                    case 1 -> {
                        System.out.print("Skriv filindhold: ");
                        String content = scanner.nextLine();
                        file.setContent(content);
                        pressEnterToContinue();
                    }
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
        }
    }

    private void pressEnterToContinue() {
        System.out.println();
        System.out.println("Tryk enter for at fortsætte");
        scanner.nextLine();
    }

    public String getUserInput(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }
}