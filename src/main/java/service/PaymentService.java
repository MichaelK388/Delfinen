package service;

import domain.Member;

import java.util.List;

public class PaymentService {

    public Member findMemberByNumber(List<Member> members, int memberNumber){

        for (Member member : members){
            if (member.getMemberNumber() == memberNumber){
                return member;
            }
        }
        return null;
    }

    public boolean registerPayment(List<Member> members, int memberNumber){

        Member member = findMemberByNumber(members, memberNumber);

        if (member != null){
            member.setHasPaid(true);
            return true;
        }
        return false;
    }

}
