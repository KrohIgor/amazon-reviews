package mate.academy.boot.amazonreviews.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ReviewResponseDto {
    private Long id;
    private String productId;
    private String userId;
    private Long score;
    private LocalDateTime time;
    private String summary;
}
