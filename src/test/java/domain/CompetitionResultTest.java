package domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CompetitionResultTest {

    @Test
    void competitionResultIsCreatedCorrectly(){
        CompetitionResult result = new CompetitionResult(
                "DM 2026",
                LocalDate.of(2026, 11, 26),
                Discipline.CRAWL,
                1,
                50.50);

        assertEquals("DM 2026", result.getCompetitionName());
        assertEquals(LocalDate.of(2026, 11, 26), result.getDate());
        assertEquals(Discipline.CRAWL, result.getDiscipline());
        assertEquals(1, result.getPlacement());
        assertEquals(50.50, result.getTime());
    }
}
