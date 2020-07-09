package mate.academy.boot.amazonreviews.service.impl;

import java.util.List;
import mate.academy.boot.amazonreviews.entity.Word;
import mate.academy.boot.amazonreviews.repository.WordRepository;
import mate.academy.boot.amazonreviews.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    private WordRepository wordRepository;

    @Override
    public List<Word> saveAll(List<Word> words) {
        return wordRepository.saveAll(words);
    }

    @Override
    public List<Word> getMostUsed(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("useCount")
                        .descending()
                        .and(Sort.by("value")));
        return wordRepository.findAll(pageable).toList();
    }
}
