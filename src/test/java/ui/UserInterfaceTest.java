package ui;

import domain.Member;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserInterfaceTest {

    @Test
    void showMessageWhenNoMembersExist() {
        List<Member> members = new ArrayList<>();

        PrintStream originalOut = System.out;
        var originalIn = System.in;

        ByteArrayInputStream input =
                new ByteArrayInputStream("2\n0\n".getBytes());

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(input);
            System.setOut(new PrintStream(output));

            UserInterface ui = new UserInterface(members);
            ui.startProgram();

            String result = output.toString();

            assertTrue(result.contains(
                    "Der er ingen medlemmer registreret."));

        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    void showMemberWhenMemberExists() {
        List<Member> members = new ArrayList<>();

        Member member = new Member(
            1,
            "Arnold",
            java.time.LocalDate.of(2001, 3, 5),
            domain.MembershipType.ACTIVE,
            domain.SwimmerType.COMPETITION,
            new ArrayList<>()
        );
        members.add(member);

        PrintStream originalOut = System.out;
        var originalIn = System.in;

        ByteArrayInputStream input =
        new ByteArrayInputStream("2\n0\n".getBytes());

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(input);
            System.setOut(new PrintStream(output));

            UserInterface ui = new UserInterface(members);
            ui.startProgram();

            String result = output.toString();

            assertTrue(result.contains(member.getName()));
            assertTrue(result.contains(
            String.valueOf(member.getMemberNumber())));
            assertTrue(result.contains("Alder:"));
            assertTrue(result.contains("Senior"));
            assertTrue(result.contains("Konkurrencesvømmer"));

        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
    @Test
    void showAllMembersWhenMultipleMembersExist() {
        List<Member> members = new ArrayList<>();

        Member member = new Member(
            1,
            "Arnold",
            java.time.LocalDate.of(2001, 3, 5),
            domain.MembershipType.ACTIVE,
            domain.SwimmerType.COMPETITION,
            new ArrayList<>()
        );
        members.add(member);

        Member member2 = new Member(
            2,
            "Hanne",
            java.time.LocalDate.of(1998, 6, 7),
            domain.MembershipType.ACTIVE,
            domain.SwimmerType.COMPETITION,
            new ArrayList<>()
        );
        members.add(member2);

        PrintStream originalOut = System.out;
        var originalIn = System.in;

        ByteArrayInputStream input =
        new ByteArrayInputStream("2\n0\n".getBytes());

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(input);
            System.setOut(new PrintStream(output));

            UserInterface ui = new UserInterface(members);
            ui.startProgram();

            String result = output.toString();

            assertTrue(result.contains(member.getName()));
            assertTrue(result.contains(member2.getName()));
            assertTrue(result.contains("Antal medlemmer: 2"));

        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
    @Test
    void showPassiveMemberActivity() {
        List<Member> members = new ArrayList<>();

        Member member3 = new Member(
            3,
            "Jamie",
            java.time.LocalDate.of(1993, 8, 5),
            domain.MembershipType.PASSIVE,
            domain.SwimmerType.COMPETITION,
            new ArrayList<>()
        );
        members.add(member3);

        PrintStream originalOut = System.out;
        var originalIn = System.in;

        ByteArrayInputStream input =
        new ByteArrayInputStream("2\n0\n".getBytes());

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(input);
            System.setOut(new PrintStream(output));

            UserInterface ui = new UserInterface(members);
            ui.startProgram();

            String result = output.toString();

            assertTrue(result.contains("Passivt medlem"));  

        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
    @Test
    void showExerciseSwimmerActivity() {
        List<Member> members = new ArrayList<>();

        Member member4 = new Member(
            4,
            "Linda",
            java.time.LocalDate.of(1999, 10, 2),
            domain.MembershipType.ACTIVE,
            domain.SwimmerType.EXERCISE,
            new ArrayList<>()
        );
        members.add(member4);

        PrintStream originalOut = System.out;
        var originalIn = System.in;

        ByteArrayInputStream input =
        new ByteArrayInputStream("2\n0\n".getBytes());

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(input);
            System.setOut(new PrintStream(output));

            UserInterface ui = new UserInterface(members);
            ui.startProgram();

            String result = output.toString();

            assertTrue(result.contains("Motionssvømmer"));  

        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
    @Test
    void showJuniorMemberCategory() {
                List<Member> members = new ArrayList<>();

        Member member5 = new Member(
            5,
            "Tina",
            java.time.LocalDate.of(2011, 5, 10),
            domain.MembershipType.ACTIVE,
            domain.SwimmerType.EXERCISE,
            new ArrayList<>()
        );
        members.add(member5);

        PrintStream originalOut = System.out;
        var originalIn = System.in;

        ByteArrayInputStream input =
        new ByteArrayInputStream("2\n0\n".getBytes());

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setIn(input);
            System.setOut(new PrintStream(output));

            UserInterface ui = new UserInterface(members);
            ui.startProgram();

            String result = output.toString();

            assertTrue(result.contains("Junior"));  

        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}