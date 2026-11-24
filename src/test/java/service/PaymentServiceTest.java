package service;

import domain.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentServiceTest {

    @Test
    void findMemberByNumberReturnsCorrectMember(){

        Member member = new Member(
                1,
                "John",
                LocalDate.of(2000, 1, 1),
                MembershipType.ACTIVE,
                SwimmerType.COMPETITION,
                List.of());

        PaymentService paymentService = new PaymentService();

        Member result = paymentService.findMemberByNumber(List.of(member), 1);

        assertEquals(member, result);
    }

    @Test
    void registerPaymentMarksMemberAsPaid(){

        Member member = new Member(
                1,
                "John",
                LocalDate.of(2000, 1, 1),
                MembershipType.ACTIVE,
                SwimmerType.COMPETITION,
                List.of());

        PaymentService paymentService = new PaymentService();

        paymentService.registerPayment(List.of(member), 1);

        assertTrue(member.hasPaid());
    }

}
