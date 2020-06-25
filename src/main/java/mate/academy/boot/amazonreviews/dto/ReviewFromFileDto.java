package mate.academy.boot.amazonreviews.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ReviewFromFileDto {
    private Long reviewId;
    private String productId;
    private String userId;
    private String profileName;
    private Long helpfulnessNumerator;
    private Long helpfulnessDenominator;
    private Long score;
    private LocalDateTime time;
    private String summary;
    private String text;
}
