package mate.academy.boot.amazonreviews.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import mate.academy.boot.amazonreviews.service.FileParserService;
import org.springframework.stereotype.Service;

@Service
public class FileParserServiceImpl implements FileParserService {
    @Override
    public void parse(File file) {

        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuilder.append(line);
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String textFile = stringBuilder.toString();
        parseTextFile(textFile);
    }

    private void parseTextFile(String textFile) {
        String[] reviews = textFile.split("\\n");
        for (String review : reviews) {
            parseReview(review);
        }
    }

    private void parseReview(String review) {
        String[] data = review.split(",", 10);
        Long reviewId = Long.parseLong(data[0]);
        String productId = data[1];
        String userId = data[2];
        String profileName = data[3];
        Long helpfulnessNumerator = Long.parseLong(data[4]);
        Long helpfulnessDenominator = Long.parseLong(data[5]);
        Long score = Long.parseLong(data[6]);
        LocalDateTime time = convertToLocalDateTime(data[7]);
        String summary = data[8];
        String text = data[9];
        System.out.println(reviewId + " " + productId + " " + userId + " " + profileName + " "
                + helpfulnessNumerator + " " + helpfulnessDenominator
                + " " + score + " " + time + " " + summary + " " + text);
    }

    private LocalDateTime convertToLocalDateTime(String millis) {
        Instant instant = Instant.ofEpochMilli(Long.parseLong(millis));
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
