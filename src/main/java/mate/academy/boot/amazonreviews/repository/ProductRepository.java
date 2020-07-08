package mate.academy.boot.amazonreviews.repository;

import mate.academy.boot.amazonreviews.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
