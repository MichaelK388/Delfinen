package service;
import domain.Member;
import domain.Discipline;
import domain.TrainingResult;
import domain.SwimmerType;
import java.time.LocalDate;

public class TrainingService {

    public void registerTrainingTime(Member member, Discipline discipline, 
                                    LocalDate date, int timeInHundredths) {
        
            if (member == null || discipline == null || date == null) {
                throw new IllegalArgumentException("Ugyldige oplysninger.");
            }
            if (member.getSwimmerType() != SwimmerType.COMPETITION) {
                System.out.println("Kun konkurrencesvømmere kan få registreret træningstider.");
                return;
            }
            if (!member.getDisciplines().contains(discipline)) {
                System.out.println("Svømmeren er ikke aktiv i denne disciplin.");
                return;
            }

            TrainingResult newResult =
                new TrainingResult(discipline, date, timeInHundredths);

            TrainingResult bestResult = member.getBestTrainingResult(discipline);
                if (bestResult == null ||
                timeInHundredths < bestResult.getTimeInHundredths()) {
                member.addTrainingResult(newResult);
                System.out.println("Træningstiden er registreret!");

                } else {
                member.addTrainingResult(newResult);
                System.out.println("Træningstiden er registreret, men den er ikke en ny personlig rekord.");
                }
    }
}