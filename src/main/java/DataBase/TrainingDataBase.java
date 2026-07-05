package DataBase;

import Training.Training;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Training.Root;


public class TrainingDataBase implements DataBase {
    private final File file;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public TrainingDataBase(File file) {
        this.file = file;
        objectMapper.registerModule(new JavaTimeModule());
    }

    private Root readRoot() {
        Root root;
        if (file.exists() && file.length() > 0) {
            try {
                root = objectMapper.readValue(file, Root.class);
                return root;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return new Root(new ArrayList<>());
    }

    private int writeRoot(Root root) {
        try {
            objectMapper.writeValue(file, root);
            return 0;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return 1;
        }
    }

    @Override
    public int addTraining(Training training) {
        Root root = readRoot();
        root.getTrainings().add(training);
        return writeRoot(root);
    }


    @Override
    public List<Training> filter(LocalDate start, LocalDate finish) {
        Root root = readRoot();

        return root.
                getTrainings().
                stream().
                filter(x -> (!x.getDateOfTraining().isBefore(start) && !x.getDateOfTraining().isAfter(finish))).
                collect(Collectors.toList());

    }

    @Override
    public List<Training> filter(String group) {
        Root root = readRoot();
        return root.getTrainings().
                stream().
                filter(x -> x.getNameOfDay().
                        equalsIgnoreCase(group)).
                collect(Collectors.toList());


    }

    @Override
    public int count() {
        Root root = readRoot();
        return root.getTrainings().size();
    }

    @Override
    public void clear() {
        Root root = readRoot();
        root.getTrainings().clear();
        writeRoot(root);
    }
}
