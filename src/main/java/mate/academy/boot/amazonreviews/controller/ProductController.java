package mate.academy.boot.amazonreviews.controller;

import java.util.List;
import mate.academy.boot.amazonreviews.dto.ProductCountReviewDto;
import mate.academy.boot.amazonreviews.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/most-reviewed")
    public List<ProductCountReviewDto> getMostReviewedProducts(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "1000") int size) {
        return productService.getMostReviewed(page, size);
    }
}
