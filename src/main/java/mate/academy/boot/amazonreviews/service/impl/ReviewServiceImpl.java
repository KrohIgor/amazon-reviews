package mate.academy.boot.amazonreviews.service.impl;

import java.util.List;
import mate.academy.boot.amazonreviews.dto.ReviewUpdateDto;
import mate.academy.boot.amazonreviews.entity.Review;
import mate.academy.boot.amazonreviews.entity.User;
import mate.academy.boot.amazonreviews.repository.ReviewRepository;
import mate.academy.boot.amazonreviews.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> saveAll(List<Review> reviews) {
        return reviewRepository.saveAll(reviews);
    }

    @Override
    public Review get(Long id) {
        return reviewRepository.getOne(id);
    }

    @Override
    public List<Review> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return reviewRepository.findAll(pageable).toList();
    }

    @Override
    public List<Review> getAllByUser(int page, int size, User user) {
        Pageable pageable = PageRequest.of(page, size);
        return reviewRepository.getAllByUser(pageable, user).toList();
    }

    @Override
    public Review update(ReviewUpdateDto reviewUpdateDto) {
        Review reviewFromDB = reviewRepository.getOne(reviewUpdateDto.getId());
        reviewFromDB.setSummary(reviewUpdateDto.getSummary());
        reviewFromDB.setText(reviewUpdateDto.getText());
        return reviewRepository.save(reviewFromDB);
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }
}
