package domain;

import java.time.LocalDate;

public class Member {

    private int memberNumber;
    private String name;
    private LocalDate birthDate;
    private MembershipType membershipType;

    public Member(int memberNumber,
                  String name,
                  LocalDate birthDate,
                  MembershipType membershipType) {
        this.memberNumber = memberNumber;
        this.name = name;
        this.birthDate = birthDate;
        this.membershipType = membershipType;
    }

    public int getMemberNumber(){
        return memberNumber;
    }
    public String getName(){
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }
}