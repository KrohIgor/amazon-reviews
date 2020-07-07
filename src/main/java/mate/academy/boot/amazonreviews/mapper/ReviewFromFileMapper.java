package mate.academy.boot.amazonreviews.mapper;

import mate.academy.boot.amazonreviews.dto.ReviewFromFileDto;
import mate.academy.boot.amazonreviews.entity.Product;
import mate.academy.boot.amazonreviews.entity.Review;
import mate.academy.boot.amazonreviews.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ReviewFromFileMapper {
    public Product getProduct(ReviewFromFileDto review) {
        Product product = new Product();
        product.setProductId(review.getProductId());
        return product;
    }

    public User getUser(ReviewFromFileDto review) {
        User user = new User();
        user.setUserId(review.getUserId());
        user.setProfileName(review.getProfileName());
        return user;
    }

    public Review getReview(ReviewFromFileDto reviewFromFileDto, Product product, User user) {
        Review review = new Review();
        review.setReviewId(reviewFromFileDto.getReviewId());
        review.setProduct(product);
        review.setUser(user);
        review.setHelpfulnessDenominator(reviewFromFileDto.getHelpfulnessDenominator());
        review.setHelpfulnessNumerator(reviewFromFileDto.getHelpfulnessNumerator());
        review.setScore(reviewFromFileDto.getScore());
        review.setSummary(reviewFromFileDto.getSummary());
        review.setText(reviewFromFileDto.getText());
        review.setTime(reviewFromFileDto.getTime());
        return review;
    }
}
