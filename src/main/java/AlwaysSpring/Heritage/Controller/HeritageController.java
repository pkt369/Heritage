package AlwaysSpring.Heritage.Controller;

import AlwaysSpring.Heritage.Domain.CulturalHeritage;
import AlwaysSpring.Heritage.Domain.Dto.ReviewDto;
import AlwaysSpring.Heritage.Domain.Review;
import AlwaysSpring.Heritage.Service.HeritageService;
import AlwaysSpring.Heritage.Service.ReviewService;
import AlwaysSpring.Heritage.Service.XmlParsingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequiredArgsConstructor
public class HeritageController {

    private final HeritageService heritageService;
    private final XmlParsingService xmlParsingService;
    private final ReviewService reviewService;

    @GetMapping("/heritage/getList")
    public String setHeritage() {
        xmlParsingService.saveList();

        return "redirect:/";
    }

    @GetMapping("/heritageDetail")
    public String heritageDetail(@RequestParam(value = "heritage") Long id, Model model) {
        CulturalHeritage heritage = heritageService.findOne(id);
        model.addAttribute("heritage", heritage);
        heritageService.plusSearchCount(id);

        List<Review> reviewList = reviewService.findByHeritage(id);
        if (!reviewList.isEmpty()) {
            model.addAttribute("reviewList", reviewList);
        }
        return "heritageDetail";
    }

    @GetMapping("/search")
    public String searchPage(@RequestParam(name = "val") String val,
                             Model model) {
        List<CulturalHeritage> find = heritageService.findByName(val);
        model.addAttribute("findList", find);
        model.addAttribute("listSize", find.size());
        return "search";
    }

    @ResponseBody
    @PostMapping("/saveReview")
    public Map<String, Object> saveReview(@RequestBody ReviewDto reviewDto,
                                          Principal principal) {
        Map<String, Object> map = new HashMap<>();
        if (principal == null) {
            map.put("msg", "로그인이 되어있지 않습니다.");
            return map;
        }
        System.out.println(reviewDto);
        CulturalHeritage heritage = heritageService.findOne(reviewDto.getHeritageId());
        Review review = Review.createReview(heritage, principal.getName(), reviewDto.getContent());
        reviewService.save(review);
        List<Review> reviewList = reviewService.findByHeritage(reviewDto.getHeritageId());
        map.put("list", reviewList);
        return map;
    }

    @GetMapping("/todayHeritage")
    public String todayHeritagePage() {
        return "todayHeritage";
    }
}
