package Training;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Root implements Serializable {
    @JsonProperty("Trainings")
    private List<Training> trainings;

    public Root() {}

    public Root(ArrayList<Training> trainings) {
        this.trainings = trainings;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }
}
