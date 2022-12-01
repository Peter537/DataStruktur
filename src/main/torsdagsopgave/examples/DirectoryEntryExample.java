package main.torsdagsopgave.examples;

import main.torsdagsopgave.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DirectoryEntryExample {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        DirectoryEntryExample example = new DirectoryEntryExample();
        example.run();
    }

    public void run() {
        Directory root = new DirectoryImpl("root");
        while (true) {
            System.out.println("Du er i " + root.getName());
            System.out.println("Vil du forlade programmet? (ja/nej)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("ja")) {
                break;
            } else if (choice.equalsIgnoreCase("nej")) {
                inDirectory(root);
            } else {
                System.out.println("Forkert svar. Prøv igen.");
            }
        }
    }

    private void inDirectory(Directory directory) {
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
                        File createdFile = createFile();
                        directory.addChild(createdFile);
                        System.out.println("Filen " + createdFile.getName() + " er oprettet.");
                        pressEnterToContinue();
                    }
                    case 2 -> {
                        Directory createdDirectory = createDirectory();
                        directory.addChild(createdDirectory);
                        System.out.println("Mappen " + createdDirectory.getName() + " er oprettet.");
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
        System.out.println("Indhold af " + directory.getName() + ":");
        int i = 1;
        for (DirectoryEntry entry : getDirectoryList(directory)) {
            System.out.println("  " + i + ") " + entry.getName() + " (" + (entry.isDirectory() ? "mappe" : "fil") + ")");
            i++;
        }
    }

    private void chooseDirectoryOrFile(Directory currentDirectory) {
        while (true) {
            try {
                System.out.println("Indhold af " + currentDirectory.getName() + ":");
                ArrayList<DirectoryEntry> entries = getDirectoryList(currentDirectory);
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

    private File createFile() {
        System.out.print("Skriv filnavn: ");
        String name = scanner.nextLine();
        System.out.print("Skriv filindhold: ");
        String content = scanner.nextLine();
        return new FileImpl(name, content);
    }

    private Directory createDirectory() {
        System.out.print("Skriv directorynavn: ");
        String name = scanner.nextLine();
        return new DirectoryImpl(name);
    }

    private void pressEnterToContinue() {
        System.out.println();
        System.out.println("Tryk enter for at fortsætte");
        scanner.nextLine();
    }

    private ArrayList<DirectoryEntry> getDirectoryList(Directory directory) {
        ArrayList<DirectoryEntry> result = new ArrayList<>();
        for (DirectoryEntry entry : directory.getChildren()) {
            if (entry.isDirectory()) {
                result.add(entry);
            }
        }
        for (DirectoryEntry entry : directory.getChildren()) {
            if (entry.isFile()) {
                result.add(entry);
            }
        }
        return result;
    }
}