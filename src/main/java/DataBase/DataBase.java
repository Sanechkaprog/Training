package DataBase;

import Training.Training;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface DataBase {
    int addTraining(Training training) throws IOException;

    List<Training> filter(LocalDate start, LocalDate finish);

    int count();
}
