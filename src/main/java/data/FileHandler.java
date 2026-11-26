package data;
import domain.Member;
import domain.Discipline;
import domain.MembershipType;
import domain.SwimmerType;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public List<Member> loadMembers() {

        List<Member> members = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            reader.readLine(); // spring header over

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(";");

                int memberNumber = Integer.parseInt(data[0]);
                String name = data[1];
                LocalDate birthDate = LocalDate.parse(data[2]);

                MembershipType membershipType =
                        MembershipType.valueOf(data[3]);

                SwimmerType swimmerType =
                        SwimmerType.valueOf(data[4]);

                List<Discipline> disciplines = new ArrayList<>();

                Member member = new Member(
                        memberNumber,
                        name,
                        birthDate,
                        membershipType,
                        swimmerType,
                        disciplines
                );

                members.add(member);
            }

        } catch (IOException e) {
            System.out.println("Fejl ved indlæsning: " + e.getMessage());
        }

        return members;
    }

}