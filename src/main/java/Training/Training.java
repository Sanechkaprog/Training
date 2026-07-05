package Training;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Training implements Serializable {
    private LocalDate dateOfTraining;
    private String nameOfDay;
    private Map<String, List<Integer>> excercises;
    public Training(){}

    public Training(LocalDate dateOfTraining, String nameOfDay, Map<String, List<Integer>> excercises) {
        this.dateOfTraining = dateOfTraining;
        this.nameOfDay = nameOfDay;
        this.excercises = excercises;
    }

    public LocalDate getDateOfTraining() {
        return dateOfTraining;
    }

    public void setDateOfTraining(LocalDate dateOfTraining) {
        this.dateOfTraining = dateOfTraining;
    }

    public String getNameOfDay() {
        return nameOfDay;
    }

    public void setNameOfDay(String nameOfDay) {
        this.nameOfDay = nameOfDay;
    }

    public Map<String, List<Integer>> getExcercises() {
        return excercises;
    }

    public void setExcercises(Map<String, List<Integer>> excercises) {
        this.excercises = excercises;
    }

    @Override
    public String toString() {
        String answer = "";
        answer += "Date of Training: " + dateOfTraining + "\n" +
                "Name of Day: " + nameOfDay + "\n";
        for (String i : excercises.keySet()) {
            answer += i + ": " + excercises.get(i) + "\n";
        }
        return answer;
    }
}
