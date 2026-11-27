import domain.Discipline;
import domain.Member;
import domain.MembershipType;
import domain.SwimmerType;
import service.MemberCreation;
import ui.UserInterface;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        List<Member> members = new ArrayList<>();

        //Test med 2 medlemmer

                MemberCreation memberCreation = new MemberCreation();

        Member member = memberCreation.createMember(
                "Hans Andersen",
                LocalDate.of(2000, 5, 10),
                MembershipType.ACTIVE,
                SwimmerType.COMPETITION,
                List.of(Discipline.CRAWL, Discipline.BUTTERFLY)
        );
        members.add(member);

        Member member2 = memberCreation.createMember(
                "Anna Jensen",
                LocalDate.of(2010, 8, 15),
                MembershipType.ACTIVE,
                SwimmerType.COMPETITION,
                List.of(Discipline.CRAWL)
        );
        members.add(member2);

        UserInterface userInterface = new UserInterface(members);
        userInterface.startProgram();
    }
}