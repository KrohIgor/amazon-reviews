package mate.academy.boot.amazonreviews.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "review")
public class Review {
    @Id
    //@MapsId
    private Long reviewId;
    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;
    private Long helpfulnessNumerator;
    private Long helpfulnessDenominator;
    private Long score;
    private LocalDateTime time;
    private String summary;
    private String text;
}
