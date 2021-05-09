package kr.or.swithme.recrustudy.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.swithme.recrustudy.dto.Member;
import kr.or.swithme.recrustudy.dto.Post;
import kr.or.swithme.recrustudy.service.MemberService;
import kr.or.swithme.recrustudy.service.PostService;

@Controller
@RequestMapping(path = "/members")
public class MemberController {
    // 스프링 컨테이너가 생성자를 통해 자동으로 주입한다.
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final PostService postService;

    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder,PostService postService){
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
        this.postService=postService;
    }

    @GetMapping("/loginform")
    public String loginform(){
        return "members/loginform";
    }

    @RequestMapping("/loginerror")
    public String loginerror(@RequestParam("login_error")String loginError){
        return "members/loginerror";
    }
    
    @GetMapping("/joinform")
    public String joinform(){
        return "members/joinform";
    }

    // 사용자가 입력한 name, email, password가 member에 저장된다.
    @PostMapping("/join")
    public String join(@ModelAttribute Member member){
        member.setPassword(member.getPassword());
        memberService.addMember(member, false);
        return "redirect:/list";
    }
    
    @GetMapping("/mypage")
    public String mypage(Principal principal, ModelMap modelMap){
        String loginId = principal.getName();
        Member member = memberService.getMemberByEmail(loginId);
        modelMap.addAttribute("member", member);
        List<Post> list=postService.getMemberPost(principal);
        List<Post> clist=postService.getCommentPost(principal);
        modelMap.addAttribute("list",list);
        modelMap.addAttribute("clist",clist);
        return "members/mypage";
    }
}
