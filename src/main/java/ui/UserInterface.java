package ui;
import java.util.Scanner;
import domain.Member;
import java.util.List;

public class UserInterface {

    private Scanner scanner;

    private List<Member> members;

public UserInterface(List<Member> members) {
    scanner = new Scanner(System.in);
    this.members = members;
}

    public void startProgram() {
        boolean running = true;

        while (running) {
            printMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Opret medlem");
                    break;

                case 2:
                    showAllMembers();
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
    
private void showAllMembers() {

    System.out.println("\n===== MEDLEMSOVERSIGT =====");

    if (members.isEmpty()) {
        System.out.println("Der er ingen medlemmer registreret.");
        return;
    }

    for (Member member : members) {
        System.out.println("Medlemsnummer: " + member.getMemberNumber());
        System.out.println("Navn:          " + member.getName());
        System.out.println("Fødselsdato:   " + member.getBirthDate());
        System.out.println("Medlemsform:   " + member.getMembershipType());
        System.out.println("Svømmetype:    " + member.getSwimmerType());
        System.out.println("Discipliner:   " + member.getDisciplines());
        System.out.println("----------------------------");
    }

    System.out.println("Antal medlemmer: " + members.size());
}

    private void printMenu() {
        System.out.println();
        System.out.println("=== MENU ===");
        System.out.println("1.Opret medlem");
        System.out.println("2.Vis alle medlemmer");
        System.out.println("0.Afslut");
        System.out.print("Vælg: ");
    }
}