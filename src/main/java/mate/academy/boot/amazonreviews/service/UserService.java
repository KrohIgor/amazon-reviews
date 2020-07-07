package mate.academy.boot.amazonreviews.service;

import java.util.Set;
import mate.academy.boot.amazonreviews.entity.User;

public interface UserService {
    User save(User user);

    void saveAll(Set<User> users);
}
