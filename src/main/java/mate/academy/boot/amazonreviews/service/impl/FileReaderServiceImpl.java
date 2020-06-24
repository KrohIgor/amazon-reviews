package mate.academy.boot.amazonreviews.service.impl;

import java.io.File;
import java.io.IOException;
import mate.academy.boot.amazonreviews.service.FileReaderService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public File readFile(String path) {
        Resource resource = new ClassPathResource(path);
        File file = null;
        try {
            file = resource.getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
