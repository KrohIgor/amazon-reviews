package mate.academy.boot.amazonreviews.repository;

import mate.academy.boot.amazonreviews.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
