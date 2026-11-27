
package domain;

import java.time.LocalDate;

public class TrainingResult {

    private Discipline discipline;
    private LocalDate date;
    private int timeInHundredths;

    public TrainingResult(Discipline discipline, LocalDate date, int timeInHundredths) {
        if (timeInHundredths <= 0) {
            throw new IllegalArgumentException("Træningstiden skal være større end 0.");
        }

        this.discipline = discipline;
        this.date = date;
        this.timeInHundredths = timeInHundredths;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getTimeInHundredths() {
        return timeInHundredths;
    }
}