package mate.academy.boot.amazonreviews.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mate.academy.boot.amazonreviews.dto.ReviewFromFileDto;
import mate.academy.boot.amazonreviews.entity.Product;
import mate.academy.boot.amazonreviews.entity.Review;
import mate.academy.boot.amazonreviews.entity.User;
import mate.academy.boot.amazonreviews.mapper.ReviewFromFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInjector {
    @Autowired
    private CsvFileParserService csvFileParserService;
    @Autowired
    private ReviewFromFileMapper reviewFromFileMapper;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReviewService reviewService;

    public void injectDataFromFile(List<String> lines) {
        Set<Product> products = new HashSet<>();
        Set<User> users = new HashSet<>();
        List<Review> reviews = new ArrayList<>();
        //Map<String, Integer> words = new HashMap<>();
        List<ReviewFromFileDto> reviewFromFileDtoList = csvFileParserService.parse(lines);
        reviewFromFileDtoList.stream()
                .forEach(review -> addEntitiesToLists(review, products, users, reviews));
        saveEntities(products, users, reviews);
        //saveWords(words);
    }

    private void addEntitiesToLists(ReviewFromFileDto reviewFromFileDto, Set<Product> products,
                                    Set<User> users, List<Review> reviews) {
        Product product = reviewFromFileMapper.getProduct(reviewFromFileDto);
        User user = reviewFromFileMapper.getUser(reviewFromFileDto);
        Review review = reviewFromFileMapper.getReview(reviewFromFileDto, product, user);
        products.add(product);
        users.add(user);
        reviews.add(review);
    }
    /*private void checkReviewsListSize(Set<Product> products, Set<User> users,
                                      List<Review> reviews) {
        if (reviews.size() >= CLEAR_THRESHOLD) {
            saveEntities(products, users, reviews);
            products.clear();
            users.clear();
            reviews.clear();
        }
    }*/

    void saveEntities(Set<Product> products, Set<User> users, List<Review> reviews) {
        productService.saveAll(products);
        userService.saveAll(users);
        reviewService.saveAll(reviews);
    }
}
