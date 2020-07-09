package mate.academy.boot.amazonreviews.mapper;

import java.util.Map;
import mate.academy.boot.amazonreviews.dto.WordCountDto;
import mate.academy.boot.amazonreviews.entity.Word;
import org.springframework.stereotype.Component;

@Component
public class WordMapper {
    public WordCountDto getWordResponseDto(Word word) {
        WordCountDto wordCountDto = new WordCountDto();
        wordCountDto.setValue(word.getValue());
        wordCountDto.setUseCount(word.getUseCount());
        return wordCountDto;
    }

    public Word getWord(Map.Entry<String, Integer> entry) {
        Word word = new Word();
        word.setValue(entry.getKey());
        word.setUseCount(entry.getValue());
        return word;
    }
}
