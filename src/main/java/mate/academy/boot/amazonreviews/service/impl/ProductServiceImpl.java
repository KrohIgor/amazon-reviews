package mate.academy.boot.amazonreviews.service.impl;

import java.util.List;
import java.util.Set;
import mate.academy.boot.amazonreviews.dto.ProductCountReviewDto;
import mate.academy.boot.amazonreviews.entity.Product;
import mate.academy.boot.amazonreviews.repository.ProductRepository;
import mate.academy.boot.amazonreviews.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public List<ProductCountReviewDto> getMostReviewed(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.getMostReviewed(pageable).toList();
    }

    @Override
    public Product get(String id) {
        return productRepository.getOne(id);
    }
}
