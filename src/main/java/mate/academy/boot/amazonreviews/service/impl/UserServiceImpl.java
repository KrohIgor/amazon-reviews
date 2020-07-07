package mate.academy.boot.amazonreviews.service.impl;

import java.util.Set;
import mate.academy.boot.amazonreviews.entity.User;
import mate.academy.boot.amazonreviews.repository.UserRepository;
import mate.academy.boot.amazonreviews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void saveAll(Set<User> users) {
        userRepository.saveAll(users);
    }
}
