package DataBase;

import Training.Training;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Training.Root;


public class TrainingDataBase implements DataBase {
    File file;

    public TrainingDataBase(File _file) {
        file = _file;
    }

    @Override
    public int addTraining(Training training) {
        Root root;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try {
            if (file.exists() && file.length() > 0) {
                root = objectMapper.readValue(file, Root.class);
                root.getTrainings().add(training);

            } else {
                root = new Root(new ArrayList<>());
                root.getTrainings().add(training);
            }
            objectMapper.writeValue(file, root);
            return 0;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 1;
        }
    }


    @Override
    public List<Training> filter(LocalDate start, LocalDate finish) {
        return List.of();
    }

    @Override
    public int count() {
        return 0;
    }
}
