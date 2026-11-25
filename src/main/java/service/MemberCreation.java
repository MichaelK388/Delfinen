package service;

import domain.*;

import java.time.LocalDate;
import java.util.List;

public class MemberCreation {

    private int nextMemberNumber = 1;

    public Member createMember(
            String name,
            LocalDate birthDate,
            MembershipType membershipType,
            SwimmerType swimmerType,
            List<Discipline> disciplines) {

        if (swimmerType == SwimmerType.COMPETITION && (disciplines == null || disciplines.isEmpty())) {

            throw new IllegalArgumentException("Konkurrence svømmere skal have mindst 1 disciplin.");
        }

        Member member = new Member(
                nextMemberNumber++,
                name,
                birthDate,
                membershipType,
                swimmerType,
                disciplines
        );

        return member;
    }
}
