package mate.academy.boot.amazonreviews.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCountReviewDto {
    private String id;
    private Long countReview;
}
