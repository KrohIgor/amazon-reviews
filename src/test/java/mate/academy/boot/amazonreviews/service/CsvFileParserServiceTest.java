package mate.academy.boot.amazonreviews.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import mate.academy.boot.amazonreviews.dto.ReviewFromFileDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CsvFileParserServiceTest {
    private final CsvFileParserService csvFileParserService = new CsvFileParserService();

    @Test
    public void parse_Ok() {
        List<String> reviewStrings = List.of("Id,ProductId,UserId,ProfileName,HelpfulnessNumerator,"
                +"HelpfulnessDenominator,Score,Time,Summary,Text",
                "1,B001E4KFG0,A3SGXH7AUHU8GW,delmartian,1,1,5,1303862400,Good Quality Dog Food,I "
                        + "have bought several of the Vitality canned dog food products and have "
                        + "found them all to be of good quality. The product looks more like a "
                        + "stew than a processed meat and it smells better. My Labrador is finicky "
                        + "and she appreciates this product better than  most.");
        ReviewFromFileDto review = new ReviewFromFileDto();
        review.setReviewId(1L);
        review.setProductId("B001E4KFG0");
        review.setUserId("A3SGXH7AUHU8GW");
        review.setProfileName("delmartian");
        review.setHelpfulnessNumerator(1L);
        review.setHelpfulnessDenominator(1L);
        review.setScore(5L);
        review.setTime(LocalDateTime.parse("1970-01-16T05:11:02.400"));
        review.setSummary("Good Quality Dog Food");
        review.setText("I have bought several of the Vitality canned dog food products and have "
                + "found them all to be of good quality. The product looks more like a stew than a "
                + "processed meat and it smells better. My Labrador is finicky and she appreciates "
                + "this product better than  most.");
        List<ReviewFromFileDto> expected = new ArrayList<>();
        expected.add(review);

        List<ReviewFromFileDto> actual = csvFileParserService.parse(reviewStrings);
        Assertions.assertEquals(expected, actual);
    }
}