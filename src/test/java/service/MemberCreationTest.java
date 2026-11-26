package service;

import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberCreationTest {

    private MemberCreation testMember;

    private Member activeMember;
    private Member passiveMember;
    private Member competitionMember;

    @BeforeEach
    void setUp() {
        testMember = new MemberCreation();

        activeMember = testMember.createMember(
                "Hans Andersen",
                LocalDate.of(2000, 5, 10),
                MembershipType.ACTIVE,
                SwimmerType.EXERCISE,
                null);

        passiveMember = testMember.createMember(
                "Peter Jensen",
                LocalDate.of(1995, 1, 1),
                MembershipType.PASSIVE,
                null,
                null);

        competitionMember = testMember.createMember(
                "Mette Hansen",
                LocalDate.of(2002, 3, 15),
                MembershipType.ACTIVE,
                SwimmerType.COMPETITION,
                List.of(Discipline.CRAWL));
    }
    @Test
    void createActiveExerciseMember() {
        assertEquals("Hans Andersen", activeMember.getName());
        assertEquals(MembershipType.ACTIVE, activeMember.getMembershipType());
        assertEquals(SwimmerType.EXERCISE, activeMember.getSwimmerType());
    }
    @Test
    void createPassiveMember() {
        assertEquals(MembershipType.PASSIVE, passiveMember.getMembershipType());
    }
    @Test
    void createCompetitionSwimmerWithDiscipline() {
        assertEquals(SwimmerType.COMPETITION, competitionMember.getSwimmerType());

        assertEquals(1, competitionMember.getDisciplines().size());

        assertTrue(competitionMember.getDisciplines().contains(Discipline.CRAWL));
    }
    @Test
    void createCompetitionSwimmerWithoutDisciplineThrowsException() {

        assertThrows(IllegalArgumentException.class, () -> testMember.createMember("Test Person", LocalDate.of(2000, 1, 1), MembershipType.ACTIVE, SwimmerType.COMPETITION, List.of())
        );
    }
    @Test
    void generatedMemberNumbersAreUnique() {
        assertNotEquals(activeMember.getMemberNumber(), passiveMember.getMemberNumber());
    }
    @Test
    void memberNumbersIncreaseSequentially() {

        assertEquals(activeMember.getMemberNumber() + 1, passiveMember.getMemberNumber());
        assertEquals(passiveMember.getMemberNumber() + 1, competitionMember.getMemberNumber());
    }
    @Test
    void createCompetitionSwimmerWithMultipleDisciplines() {

        Member member = testMember.createMember("Mette Hansen", LocalDate.of(2002, 3, 15),
                MembershipType.ACTIVE,
                SwimmerType.COMPETITION,
                List.of(Discipline.CRAWL, Discipline.BUTTERFLY, Discipline.BACKSTROKE));

        assertEquals(3, member.getDisciplines().size());
    }
    @Test
    void createCompetitionSwimmerWithNullDisciplinesThrowsException() {

        assertThrows(
                IllegalArgumentException.class, () -> testMember.createMember("Test Person", LocalDate.of(2000, 1, 1), MembershipType.ACTIVE, SwimmerType.COMPETITION, null)
        );
    }
}
