package service;

import domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CompetitionResultServiceTest {

    @Test
    void registerCompetitionResultAddsResultToMember(){

        Member member = new Member(
                1,
                "William",
                LocalDate.of(2004,4,9),
                MembershipType.ACTIVE,
                SwimmerType.COMPETITION,
                List.of(Discipline.CRAWL));

        CompetitionResult result = new CompetitionResult(
                "DM 2026",
                LocalDate.of(2026, 11, 26),
                Discipline.CRAWL,
                1,
                50.50);

        CompetitionResultService service = new CompetitionResultService();

        service.registerCompetitionResult(member, result);

        assertEquals(1, member.getCompetitionResults().size());
        assertTrue(member.getCompetitionResults().contains(result));
    }
}
