package mate.academy.boot.amazonreviews.repository;

import mate.academy.boot.amazonreviews.dto.ProductCountReviewDto;
import mate.academy.boot.amazonreviews.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query(value = "SELECT new mate.academy.boot.amazonreviews.dto.ProductCountReviewDto("
            + "p.productId, COUNT(r)) "
            + "FROM Review r JOIN r.product p "
            + "GROUP BY p ORDER BY COUNT(r) DESC, p.productId ASC")
    Page<ProductCountReviewDto> getMostReviewed(Pageable pageable);
}
