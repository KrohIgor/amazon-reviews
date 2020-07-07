package mate.academy.boot.amazonreviews.service.impl;

import java.util.Set;
import mate.academy.boot.amazonreviews.entity.Product;
import mate.academy.boot.amazonreviews.repository.ProductRepository;
import mate.academy.boot.amazonreviews.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void saveAll(Set<Product> products) {
        productRepository.saveAll(products);
    }
}
