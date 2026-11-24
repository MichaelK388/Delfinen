import domain.*;
import service.MemberCreation;
import ui.UserInterface;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        List<Member> members = new ArrayList<>();

        UserInterface userInterface = new UserInterface(members);
        userInterface.startProgram();

                // Test oprettelse af et medlem for at se om det virker
//        MemberCreation memberCreation = new MemberCreation();
//
//        Member member = memberCreation.createMember(
//                "Hans Andersen",
//                LocalDate.of(2000, 5, 10),
//                MembershipType.ACTIVE,
//                SwimmerType.COMPETITION,
//                List.of(Discipline.CRAWL, Discipline.BUTTERFLY)
//        );
//
//        System.out.println(member.getName());
//        System.out.println(member.getMembershipType());
//        System.out.println(member.getDisciplines());
//        System.out.println(member.getSwimmerType());
//        System.out.println(member.getBirthDate());
//        System.out.println(member.getMemberNumber());
    }
}