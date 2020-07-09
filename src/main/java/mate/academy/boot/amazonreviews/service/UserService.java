package mate.academy.boot.amazonreviews.service;

import java.util.List;
import java.util.Set;
import mate.academy.boot.amazonreviews.dto.UserCountReviewDto;
import mate.academy.boot.amazonreviews.entity.User;

public interface UserService {
    User save(User user);

    List<User> saveAll(Set<User> users);

    List<UserCountReviewDto> getMostActive(int page, int size);

    User get(String id);

    User getByProfileName(String profileName);
}
