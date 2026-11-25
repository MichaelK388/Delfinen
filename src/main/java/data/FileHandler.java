package data;
import domain.Member;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class FileHandler {

    private static final String FILE_NAME = "members.csv";

    public void saveMember(Member member) {

        File file = new File(FILE_NAME);
        boolean newFile = !file.exists();

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {

            if (newFile) {
                writer.println("memberNumber;name;birthDate;membershipType;swimmerType;disciplines");
            }

            writer.println(
                    member.getMemberNumber() + ";" +
                            member.getName() + ";" +
                            member.getBirthDate() + ";" +
                            member.getMembershipType() + ";" +
                            member.getSwimmerType() + ";" +
                            member.getDisciplines()
            );

        } catch (IOException e) {
            System.out.println("Fejl ved gemning: " + e.getMessage());
        }
    }
    public void savePayment(Member member) {

        String fileName = "payments.csv";

        File file = new File(fileName);
        boolean writeHeader = !file.exists() || file.length() == 0;

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {

            if (writeHeader) {
                writer.println("memberNumber;year;paid");
            }

            writer.println(
                    member.getMemberNumber() + ";" +
                            "2026" + ";" +
                            member.hasPaid()
            );

        } catch (IOException e) {
            System.out.println("Fejl ved gemning: " + e.getMessage());
        }
    }
}