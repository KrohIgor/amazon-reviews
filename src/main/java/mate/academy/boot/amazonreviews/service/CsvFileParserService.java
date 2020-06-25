package mate.academy.boot.amazonreviews.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import mate.academy.boot.amazonreviews.dto.ReviewFromFileDto;
import org.springframework.stereotype.Service;

@Service
public class CsvFileParserService {
    public List<ReviewFromFileDto> parse(List<String> reviewStrings) {
        List<ReviewFromFileDto> reviews = new ArrayList<>();
        for (int i = 1; i < reviewStrings.size(); i++) {
            String[] data = reviewStrings.get(i).split(",", 10);
            ReviewFromFileDto reviewFromFileDto = new ReviewFromFileDto();
            reviewFromFileDto.setReviewId(Long.parseLong(data[0]));
            reviewFromFileDto.setProductId(data[1]);
            reviewFromFileDto.setUserId(data[2]);
            reviewFromFileDto.setProfileName(data[3]);
            reviewFromFileDto.setHelpfulnessNumerator(Long.parseLong(data[4]));
            reviewFromFileDto.setHelpfulnessDenominator(Long.parseLong(data[5]));
            reviewFromFileDto.setScore(Long.parseLong(data[6]));
            reviewFromFileDto.setTime(convertToLocalDateTime(data[7]));
            reviewFromFileDto.setSummary(data[8]);
            reviewFromFileDto.setText(data[9]);
            reviews.add(reviewFromFileDto);
        }
        return reviews;
    }

    private LocalDateTime convertToLocalDateTime(String millis) {
        Instant instant = Instant.ofEpochMilli(Long.parseLong(millis));
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
