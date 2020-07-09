package mate.academy.boot.amazonreviews.repository;

import mate.academy.boot.amazonreviews.dto.UserCountReviewDto;
import mate.academy.boot.amazonreviews.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "SELECT new mate.academy.boot.amazonreviews.dto.UserCountReviewDto(u.userId, "
            + "u.profileName, COUNT(r)) "
            + "FROM Review r JOIN r.user u GROUP BY u ORDER BY COUNT(r) DESC, u.profileName ASC")
    Page<UserCountReviewDto> findAllMostActiveUser(Pageable pageable);

    User getByProfileName(String name);
}
