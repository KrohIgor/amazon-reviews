package mate.academy.boot.amazonreviews.repository;

import mate.academy.boot.amazonreviews.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
