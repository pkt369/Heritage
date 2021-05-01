package AlwaysSpring.Heritage.Controller;

import AlwaysSpring.Heritage.Service.HeritageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final HeritageService heritageService;

//    http://www.cha.go.kr/cha/SearchKindOpenapiList.do?pageUnit=100&pageIndex=1
}
