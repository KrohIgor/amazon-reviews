package mate.academy.boot.amazonreviews.repository;

import mate.academy.boot.amazonreviews.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, String> {
}
