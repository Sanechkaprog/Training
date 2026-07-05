import DataBase.DataBase;
import DataBase.TrainingDataBase;
import Training.Training;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static void main() throws IOException {
        File file = new File("Trainings.json");
        DataBase dataBase = new TrainingDataBase(file);
        LocalDate date = LocalDate.now();
        Map<String, List<Integer>> exc = new HashMap<>();
        exc.put("Жим штанги", new ArrayList<>(List.of(10, 9, 8)));
        exc.put("Отжимания на брусьях", new ArrayList<>(List.of(15, 15, 15)));
        Training training = new Training(date, "День ", exc);
        Training training2 = new Training(date, "День ног", exc);
        dataBase.clear();
    }
}
