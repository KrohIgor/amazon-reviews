package mate.academy.boot.amazonreviews.dto;

import lombok.Data;

@Data
public class ReviewUpdateDto {
    private Long id;
    private String summary;
    private String text;
}
