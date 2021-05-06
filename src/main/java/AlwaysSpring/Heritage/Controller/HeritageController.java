package AlwaysSpring.Heritage.Controller;

import AlwaysSpring.Heritage.Service.HeritageService;
import AlwaysSpring.Heritage.Service.XmlParsingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class HeritageController {

    private final HeritageService heritageService;
    private final XmlParsingService xmlParsingService;

    @GetMapping("/heritage/getList")
    public String getTop100List() {
        xmlParsingService.saveList();

        return "";
    }
}
