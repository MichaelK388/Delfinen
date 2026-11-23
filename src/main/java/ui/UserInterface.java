package ui;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void startProgram() {
        boolean running = true;

        while (running) {
            printMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Funktion 1 valgt");
                    break;

                case 2:
                    System.out.println("Funktion 2 valgt");
                    break;

                case 0:
                    System.out.println("Program afsluttes...");
                    running = false;
                    break;

                default:
                    System.out.println("Ugyldigt valg");
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("=== MENU ===");
        System.out.println("1. Funktion 1");
        System.out.println("2. Funktion 2");
        System.out.println("0. Afslut");
        System.out.print("Vælg: ");
    }
}