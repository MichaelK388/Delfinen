package service;

import domain.Member;
import domain.Discipline;
import domain.MembershipType;
import domain.SwimmerType;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TrainingServiceTest {

    @Test
    void registerFasterTrainingTime() {
        Member member = new Member(
                1,
                "Kim",
                LocalDate.of(2006, 1, 1),
                MembershipType.ACTIVE,
                SwimmerType.COMPETITION,
                List.of(Discipline.CRAWL)
        );

        TrainingService service = new TrainingService();

        service.registerTrainingTime(
                member, Discipline.CRAWL,
                LocalDate.of(2026, 11, 27), 7000
        );

        service.registerTrainingTime(
                member, Discipline.CRAWL,
                LocalDate.of(2026, 11, 28), 6500
        );

        assertEquals(
                6500,
                member.getBestTrainingResult(Discipline.CRAWL)
                        .getTimeInHundredths()
        );
    }

    @Test
    void slowerTimeDoesNotReplaceBestTime() {
        Member member = new Member(
                2,
                "Anna",
                LocalDate.of(2010, 8, 15),
                MembershipType.ACTIVE,
                SwimmerType.COMPETITION,
                List.of(Discipline.CRAWL)
        );

        TrainingService service = new TrainingService();

        service.registerTrainingTime(
                member, Discipline.CRAWL,
                LocalDate.of(2026, 11, 27), 6500
        );

        service.registerTrainingTime(
                member, Discipline.CRAWL,
                LocalDate.of(2026, 11, 28), 7000
        );

        assertEquals(
                6500,
                member.getBestTrainingResult(Discipline.CRAWL)
                        .getTimeInHundredths()
        );
    }

    @Test
    void cannotRegisterInactiveDiscipline() {
        Member member = new Member(
                3,
                "Peter",
                LocalDate.of(2005, 5, 10),
                MembershipType.ACTIVE,
                SwimmerType.COMPETITION,
                List.of(Discipline.CRAWL)
        );

        TrainingService service = new TrainingService();

        service.registerTrainingTime(
                member, Discipline.BUTTERFLY,
                LocalDate.of(2026, 11, 27), 6500
        );

        assertTrue(member.getTrainingResults().isEmpty());
    }

    @Test
    void exerciseSwimmerCannotRegisterTrainingTime() {
        Member member = new Member(
                4,
                "Sofie",
                LocalDate.of(2008, 3, 12),
                MembershipType.ACTIVE,
                SwimmerType.EXERCISE,
                List.of(Discipline.CRAWL)
        );

        TrainingService service = new TrainingService();

        service.registerTrainingTime(
                member, Discipline.CRAWL,
                LocalDate.of(2026, 11, 27), 6500
        );

        assertTrue(member.getTrainingResults().isEmpty());
    }
}
