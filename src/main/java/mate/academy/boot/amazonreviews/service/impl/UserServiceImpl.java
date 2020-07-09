package mate.academy.boot.amazonreviews.service.impl;

import java.util.List;
import java.util.Set;
import mate.academy.boot.amazonreviews.dto.UserCountReviewDto;
import mate.academy.boot.amazonreviews.entity.User;
import mate.academy.boot.amazonreviews.repository.UserRepository;
import mate.academy.boot.amazonreviews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<User> saveAll(Set<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public List<UserCountReviewDto> getMostActive(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAllMostActiveUser(pageable).toList();
    }

    @Override
    public User get(String id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getByProfileName(String profileName) {
        return userRepository.getByProfileName(profileName);
    }
}
