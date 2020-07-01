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
    private static final int REVIEW_ID = 0;
    private static final int PRODUCT_ID = 1;
    private static final int USER_ID = 2;
    private static final int PROFILE_NAME = 3;
    private static final int HELPFULNESS_NUMERATOR = 4;
    private static final int HELPFULNESS_DENOMINATOR = 5;
    private static final int SCORE = 6;
    private static final int TIME = 7;
    private static final int SUMMARY = 8;
    private static final int TEXT = 9;

    public List<ReviewFromFileDto> parse(List<String> reviewStrings) {
        List<ReviewFromFileDto> reviews = new ArrayList<>();
        for (int i = 1; i < reviewStrings.size(); i++) {
            String[] data = reviewStrings.get(i).split(",", 10);
            ReviewFromFileDto reviewFromFileDto = new ReviewFromFileDto();
            reviewFromFileDto.setReviewId(Long.parseLong(data[REVIEW_ID]));
            reviewFromFileDto.setProductId(data[PRODUCT_ID]);
            reviewFromFileDto.setUserId(data[USER_ID]);
            reviewFromFileDto.setProfileName(data[PROFILE_NAME]);
            reviewFromFileDto.setHelpfulnessNumerator(Long.parseLong(data[HELPFULNESS_NUMERATOR]));
            reviewFromFileDto.setHelpfulnessDenominator(
                    Long.parseLong(data[HELPFULNESS_DENOMINATOR]));
            reviewFromFileDto.setScore(Long.parseLong(data[SCORE]));
            reviewFromFileDto.setTime(convertToLocalDateTime(data[TIME]));
            reviewFromFileDto.setSummary(data[SUMMARY]);
            reviewFromFileDto.setText(data[TEXT]);
            reviews.add(reviewFromFileDto);
        }
        return reviews;
    }

    private LocalDateTime convertToLocalDateTime(String millis) {
        Instant instant = Instant.ofEpochMilli(Long.parseLong(millis));
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
