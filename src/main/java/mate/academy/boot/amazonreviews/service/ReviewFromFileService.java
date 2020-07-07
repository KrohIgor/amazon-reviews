package mate.academy.boot.amazonreviews.service;

import java.util.List;
import mate.academy.boot.amazonreviews.dto.ReviewFromFileDto;

public interface ReviewFromFileService {
    void addToDB(List<ReviewFromFileDto> reviews);
}
