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

    private List<TrainingResult> trainingResults = new ArrayList<>();
    
    private boolean hasPaid;

    public Member(int memberNumber, String name, LocalDate birthDate, MembershipType membershipType, SwimmerType swimmerType, List<Discipline> disciplines) {
        this.memberNumber = memberNumber;
        this.name = name;
        this.birthDate = birthDate;
        this.membershipType = membershipType;
        this.swimmerType = swimmerType;
        this.disciplines = disciplines;
        this.hasPaid = false;
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
    public void addTrainingResult(TrainingResult result) {
    trainingResults.add(result);
    }
    public List<TrainingResult> getTrainingResults() {
    return trainingResults;
    }
    public TrainingResult getBestTrainingResult(Discipline discipline) {
    TrainingResult bestResult = null;

    for (TrainingResult result : trainingResults) {
        if (result.getDiscipline() == discipline) {
            if (bestResult == null ||
                    result.getTimeInHundredths() < bestResult.getTimeInHundredths()) {
                bestResult = result;
            }
        }
    }
    return bestResult;
    }
}