package AlwaysSpring.Heritage.Controller;

import AlwaysSpring.Heritage.Service.HeritageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final HeritageService heritageService;

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }
}
