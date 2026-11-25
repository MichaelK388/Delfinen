import domain.*;
import service.MemberCreation;
import ui.UserInterface;
import java.time.LocalDate;
import java.util.List;
import data.FileHandler;

public class Main {
    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface();
        userInterface.startProgram();

                // Test oprettelse af et medlem for at se om det virker
        MemberCreation memberCreation = new MemberCreation();

        Member member = memberCreation.createMember(
                "Jesper Andersen",
                LocalDate.of(2010, 2, 20),
                MembershipType.ACTIVE,
                SwimmerType.EXERCISE,
                List.of(Discipline.CRAWL, Discipline.BUTTERFLY)
        );
        FileHandler csvService = new FileHandler();
        csvService.saveMember(member);

    }
}