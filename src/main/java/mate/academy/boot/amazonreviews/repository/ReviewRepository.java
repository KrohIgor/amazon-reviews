package mate.academy.boot.amazonreviews.repository;

import mate.academy.boot.amazonreviews.entity.Review;
import mate.academy.boot.amazonreviews.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> getAllByUser(Pageable pageable, User user);
}
