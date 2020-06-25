package mate.academy.boot.amazonreviews.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FileReaderService {
    public List<String> readFile(String path) {
        List<String> listFileStrings = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listFileStrings.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listFileStrings;
    }
}
