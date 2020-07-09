package mate.academy.boot.amazonreviews.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import mate.academy.boot.amazonreviews.dto.ReviewFromFileDto;
import mate.academy.boot.amazonreviews.entity.Product;
import mate.academy.boot.amazonreviews.entity.Review;
import mate.academy.boot.amazonreviews.entity.Role;
import mate.academy.boot.amazonreviews.entity.User;
import mate.academy.boot.amazonreviews.mapper.ReviewFromFileMapper;
import mate.academy.boot.amazonreviews.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataInjector {
    private static final int CLEAR_THRESHOLD = 50_000;
    private final CsvFileParserService csvFileParserService;
    private final ReviewFromFileMapper reviewFromFileMapper;
    private final ProductService productService;
    private final UserService userService;
    private final ReviewService reviewService;
    private final RoleService roleService;
    private final WordService wordService;
    private final WordMapper wordMapper;

    @Autowired
    public DataInjector(CsvFileParserService csvFileParserService,
                        ReviewFromFileMapper reviewFromFileMapper,
                        ProductService productService,
                        UserService userService,
                        ReviewService reviewService,
                        RoleService roleService,
                        WordService wordService,
                        WordMapper wordMapper) {
        this.csvFileParserService = csvFileParserService;
        this.reviewFromFileMapper = reviewFromFileMapper;
        this.productService = productService;
        this.userService = userService;
        this.reviewService = reviewService;
        this.roleService = roleService;
        this.wordService = wordService;
        this.wordMapper = wordMapper;
    }

    @PostConstruct
    public void init() {
        injectRoles();
        injectAdmin();
    }

    private void injectRoles() {
        Role roleAdmin = new Role();
        roleAdmin.setName(Role.RoleName.ADMIN);
        roleService.save(roleAdmin);
        Role roleUser = new Role();
        roleUser.setName(Role.RoleName.USER);
        roleService.save(roleUser);
    }

    private void injectAdmin() {
        User admin = new User();
        admin.setUserId("admin");
        admin.setProfileName("admin");
        admin.setPassword("admin");
        admin.setRoles(Set.of(roleService.getByName("ADMIN")));
        userService.save(admin);
    }

    public void injectDataFromFile(List<String> lines) {
        Set<Product> products = new HashSet<>();
        Set<User> users = new HashSet<>();
        List<Review> reviews = new ArrayList<>();
        Map<String, Integer> words = new HashMap<>();
        List<ReviewFromFileDto> reviewFromFileDtoList = csvFileParserService.parse(lines);
        reviewFromFileDtoList
                .forEach(review -> addEntitiesToLists(review, products, users, reviews, words));
        saveEntities(products, users, reviews);
        saveWords(words);
    }

    private void addEntitiesToLists(ReviewFromFileDto reviewFromFileDto, Set<Product> products,
                                    Set<User> users, List<Review> reviews,
                                    Map<String, Integer> words) {
        Product product = reviewFromFileMapper.getProduct(reviewFromFileDto);
        User user = reviewFromFileMapper.getUser(reviewFromFileDto);
        Review review = reviewFromFileMapper.getReview(reviewFromFileDto, product, user);
        products.add(product);
        users.add(user);
        reviews.add(review);
        for (String word : review.getText().split("\\W+")) {
            word = word.toLowerCase();
            words.put(word, words.getOrDefault(word, 0) + 1);
        }
        checkReviewsListSize(products, users, reviews);
    }

    private void checkReviewsListSize(Set<Product> products, Set<User> users,
                                      List<Review> reviews) {
        if (reviews.size() >= CLEAR_THRESHOLD) {
            saveEntities(products, users, reviews);
            products.clear();
            users.clear();
            reviews.clear();
        }
    }

    @Transactional
    void saveEntities(Set<Product> products, Set<User> users, List<Review> reviews) {
        productService.saveAll(products);
        userService.saveAll(users);
        reviewService.saveAll(reviews);
    }

    @Transactional
    void saveWords(Map<String, Integer> words) {
        wordService.saveAll(words.entrySet()
                .stream()
                .map(wordMapper::getWord)
                .collect(Collectors.toList()));
    }
}
