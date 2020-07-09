package mate.academy.boot.amazonreviews.service;

import java.util.List;
import mate.academy.boot.amazonreviews.dto.ReviewUpdateDto;
import mate.academy.boot.amazonreviews.entity.Review;
import mate.academy.boot.amazonreviews.entity.User;

public interface ReviewService {
    Review save(Review review);

    List<Review> saveAll(List<Review> reviews);

    Review get(Long id);

    List<Review> getAll(int page, int size);

    List<Review> getAllByUser(int page, int size, User user);

    Review update(ReviewUpdateDto reviewUpdateDto);

    void delete(Long id);
}
