package mate.academy.boot.amazonreviews.mapper;

import mate.academy.boot.amazonreviews.dto.ReviewResponseDto;
import mate.academy.boot.amazonreviews.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public ReviewResponseDto getReviewResponseDto(Review review) {
        ReviewResponseDto reviewResponseDto = new ReviewResponseDto();
        reviewResponseDto.setId(review.getReviewId());
        reviewResponseDto.setProductId(review.getProduct().getProductId());
        reviewResponseDto.setUserId(review.getUser().getUserId());
        reviewResponseDto.setScore(review.getScore());
        reviewResponseDto.setTime(review.getTime());
        reviewResponseDto.setSummary(review.getSummary());
        return reviewResponseDto;
    }
}
