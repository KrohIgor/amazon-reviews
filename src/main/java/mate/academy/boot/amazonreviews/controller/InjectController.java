package mate.academy.boot.amazonreviews.controller;

import java.util.List;
import mate.academy.boot.amazonreviews.service.DataInjector;
import mate.academy.boot.amazonreviews.service.FileReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectController {
    @Autowired
    private DataInjector dataInjector;
    @Autowired
    private FileReaderService fileReaderService;

    @GetMapping
    public String injectDataToDB() {
        List<String> list = fileReaderService.readFile("src/main/resources/Reviews.csv");
        dataInjector.injectDataFromFile(list);
        return "Success inject data to DB!";
    }
}
