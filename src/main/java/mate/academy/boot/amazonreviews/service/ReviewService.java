package mate.academy.boot.amazonreviews.service;

import java.util.List;
import mate.academy.boot.amazonreviews.entity.Review;

public interface ReviewService {
    Review save(Review review);

    void saveAll(List<Review> reviews);
}
