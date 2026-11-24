package domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}