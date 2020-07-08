package mate.academy.boot.amazonreviews.service.impl;

import java.util.List;
import mate.academy.boot.amazonreviews.entity.Review;
import mate.academy.boot.amazonreviews.repository.ReviewRepository;
import mate.academy.boot.amazonreviews.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void saveAll(List<Review> reviews) {
        reviewRepository.saveAll(reviews);
    }
}
