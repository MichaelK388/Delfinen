package domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Member {

    private int memberNumber;
    private String name;
    private LocalDate birthDate;
    private MembershipType membershipType;
    private SwimmerType swimmerType;
    private List<Discipline> disciplines;
    private boolean hasPaid;
    private List<CompetitionResult> competitionResults;

    public Member(int memberNumber, String name, LocalDate birthDate, MembershipType membershipType, SwimmerType swimmerType, List<Discipline> disciplines) {
        this.memberNumber = memberNumber;
        this.name = name;
        this.birthDate = birthDate;
        this.membershipType = membershipType;
        this.swimmerType = swimmerType;
        this.disciplines = disciplines;
        this.hasPaid = false;
        this.competitionResults = new ArrayList<>();
    }

    public int getMemberNumber(){
        return memberNumber;
    }
    public String getName(){
        return name;
    }

    public boolean hasPaid(){ return hasPaid;}
    public void setHasPaid(boolean hasPaid){
        this.hasPaid = hasPaid;
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

    public List<CompetitionResult> getCompetitionResults(){return competitionResults;}
    public void addCompetitionResult(CompetitionResult result) {
        competitionResults.add(result);
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }
    public int getAge(LocalDate date) {return Period.between(birthDate, date).getYears();}
    public double calculateMembershipFee(LocalDate date) {
        if (membershipType == MembershipType.PASSIVE){
            return 500;
        }
        int age = getAge(date);
        if (age < 18){
            return 1000;
        }
        if (age >= 60){
            return 1200;
        }
        return 1600;
    }
}