package mate.academy.boot.amazonreviews.service;

import java.util.Set;
import mate.academy.boot.amazonreviews.entity.Product;

public interface ProductService {
    Product save(Product product);

    void saveAll(Set<Product> products);
}
