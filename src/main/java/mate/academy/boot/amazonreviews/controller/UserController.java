package mate.academy.boot.amazonreviews.controller;

import java.util.List;
import mate.academy.boot.amazonreviews.dto.UserCountReviewDto;
import mate.academy.boot.amazonreviews.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/most-active")
    public List<UserCountReviewDto> getMostActiveUsers(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "1000") int size) {
        return userService.getMostActive(page, size);
    }
}
