package service;

import domain.CompetitionResult;
import domain.Member;

public class CompetitionResultService {

    public void registerCompetitionResult(Member member, CompetitionResult result){
        member.addCompetitionResult(result);
    }
}
