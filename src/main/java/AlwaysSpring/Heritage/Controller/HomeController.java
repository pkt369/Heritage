package AlwaysSpring.Heritage.Controller;

import AlwaysSpring.Heritage.Domain.CulturalHeritage;
import AlwaysSpring.Heritage.Domain.Dto.MemberDto;
import AlwaysSpring.Heritage.Domain.Member;
import AlwaysSpring.Heritage.Service.HeritageService;
import AlwaysSpring.Heritage.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final HeritageService heritageService;
    private final MemberService memberService;

    @GetMapping("/")
    public String mainPage(Model model) {
        List<CulturalHeritage> heritageList = heritageService.getTopTen();
        model.addAttribute("list", heritageList);
        return "main";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(MemberDto memberDto) {
        memberService.join(memberDto.toEntity());

        return "redirect:/login";
    }

    @GetMapping("/intro")
    public String introPage() {
        return "intro";
    }
}
