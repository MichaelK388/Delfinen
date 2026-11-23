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
