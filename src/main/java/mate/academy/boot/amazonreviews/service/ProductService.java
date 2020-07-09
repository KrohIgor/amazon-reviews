package mate.academy.boot.amazonreviews.service;

import java.util.List;
import java.util.Set;
import mate.academy.boot.amazonreviews.dto.ProductCountReviewDto;
import mate.academy.boot.amazonreviews.entity.Product;

public interface ProductService {
    Product save(Product product);

    void saveAll(Set<Product> products);

    List<ProductCountReviewDto> getMostReviewed(int page, int size);

    Product get(String id);
}
