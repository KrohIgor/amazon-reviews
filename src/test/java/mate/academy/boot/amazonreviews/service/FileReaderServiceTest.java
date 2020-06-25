package mate.academy.boot.amazonreviews.service;

import java.io.File;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileReaderServiceTest {
    private final FileReaderService fileReaderService = new FileReaderService();

    @Test
    void readFile_Ok() {
        String filePath = "src\\test\\resources\\Content.txt";
        File file = new File(filePath);
        Assertions.assertTrue(file.exists());
        List<String> expected = List.of("content");
        List<String> actual = fileReaderService.readFile(filePath);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void readNotExistsFile() {
        String filePath = "src\\test\\resources\\NotExistsFile.txt";
        File file = new File(filePath);
        Assertions.assertFalse(file.exists());
        try {
            fileReaderService.readFile(filePath);
        } catch (RuntimeException e) {
            return;
        }
        Assertions.fail("RuntimeException was expected");
    }
}