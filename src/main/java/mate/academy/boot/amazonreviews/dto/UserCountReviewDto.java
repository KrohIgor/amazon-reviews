package mate.academy.boot.amazonreviews.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCountReviewDto {
    private String id;
    private String profileName;
    private Long countReview;
}
