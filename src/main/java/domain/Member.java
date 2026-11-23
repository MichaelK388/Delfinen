package domain;

import java.time.LocalDate;
import java.util.List;

public class Member {

    private int memberNumber;
    private String name;
    private LocalDate birthDate;
    private MembershipType membershipType;
    private SwimmerType swimmerType;
    private List<Discipline> disciplines;

    public Member(int memberNumber, String name, LocalDate birthDate, MembershipType membershipType, SwimmerType swimmerType, List<Discipline> disciplines) {
        this.memberNumber = memberNumber;
        this.name = name;
        this.birthDate = birthDate;
        this.membershipType = membershipType;
        this.swimmerType = swimmerType;
        this.disciplines = disciplines;
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
    public SwimmerType getSwimmerType() {
        return swimmerType;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }
}