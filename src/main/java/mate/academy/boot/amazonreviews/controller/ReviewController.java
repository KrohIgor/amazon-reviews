package mate.academy.boot.amazonreviews.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.boot.amazonreviews.dto.ReviewResponseDto;
import mate.academy.boot.amazonreviews.mapper.ReviewMapper;
import mate.academy.boot.amazonreviews.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/")
    public List<ReviewResponseDto> getAllReviews(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "1000") int size) {
        return reviewService.getAll(page, size)
                .stream()
                .map(reviewMapper::getReviewResponseDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/")
    public String deleteReview(@RequestParam Long id) {
        reviewService.delete(id);
        return "The review with id " + id + " was deleted";
    }
}
