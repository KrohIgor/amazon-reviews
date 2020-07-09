package mate.academy.boot.amazonreviews.service;

import java.util.List;
import mate.academy.boot.amazonreviews.entity.Word;

public interface WordService {
    List<Word> saveAll(List<Word> words);

    List<Word> getMostUsed(int page, int size);
}
