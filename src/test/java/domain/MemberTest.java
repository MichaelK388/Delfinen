package domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void calculateAge() {

        Member member = new Member(
                1,
                "Issa",
                LocalDate.of(2006, 1, 1),
                MembershipType.ACTIVE,
                null,
                new ArrayList<>());

        assertEquals(
                20,
                member.getAge(LocalDate.of(2026, 1, 1))
        );
    }

    @Test
    void newMemberHasNotPaid(){

        Member member = new Member(
                1,
                "John",
                LocalDate.of(2000, 1, 1),
                MembershipType.ACTIVE,
                SwimmerType.COMPETITION,
                List.of());

        assertFalse(member.hasPaid());
    }

    @Test
    void paymentStatusCanBeChanged(){

        Member member = new Member(1,
                "John",
                LocalDate.of(2000, 1, 1),
                MembershipType.ACTIVE,
                SwimmerType.COMPETITION,
                List.of());

        member.setHasPaid(true);

        assertTrue(member.hasPaid());
    }

}