package domain;

import java.time.LocalDate;

public class CompetitionResult {

        private String competitionName;
        private LocalDate date;
        private Discipline discipline;
        private int placement;
        private double time;

        public CompetitionResult(String competitionName,
                                 LocalDate date,
                                 Discipline discipline,
                                 int placement,
                                 double time) {

            this.competitionName = competitionName;
            this.date = date;
            this.discipline = discipline;
            this.placement = placement;
            this.time = time;
        }

        public String getCompetitionName() {
            return competitionName;
        }

        public LocalDate getDate() {
            return date;
        }

        public Discipline getDiscipline() {
            return discipline;
        }

        public int getPlacement() {
            return placement;
        }

        public double getTime() {
            return time;
        }
}

