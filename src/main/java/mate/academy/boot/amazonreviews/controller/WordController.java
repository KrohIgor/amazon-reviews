package mate.academy.boot.amazonreviews.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.boot.amazonreviews.dto.WordCountDto;
import mate.academy.boot.amazonreviews.mapper.WordMapper;
import mate.academy.boot.amazonreviews.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/words")
public class WordController {
    @Autowired
    private WordService wordService;
    @Autowired
    private WordMapper wordMapper;

    @GetMapping("/most-used")
    public List<WordCountDto> getMostUsedWords(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "1000") int size) {
        return wordService.getMostUsed(page, size)
                .stream()
                .map(wordMapper::getWordResponseDto)
                .collect(Collectors.toList());
    }
}
