package ezenweb.controller;

import ezenweb.model.dto.MemberDto;
import ezenweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
public class MemberController {
    // Controller -> Service 요청
    // Controller <- Service 응답

    @Autowired
    private MemberService memberService;


    // 1. 회원가입
    @PostMapping("/post")
    public boolean signUp(@RequestBody MemberDto memberDto) {

        return memberService.signUp(memberDto);

    }


    // 2. 회원정보 호출
    @GetMapping("/get")
    public MemberDto getMember(@RequestParam("mno") int mno) {

        return memberService.getMember(mno);
    }


    // 3. 회원정보 수정
    @PutMapping("/put")
    public boolean updateMember(@RequestBody MemberDto memberDto) {

        return memberService.updateMember(memberDto);
    }


    // 4. 회원탈퇴
    @DeleteMapping("/delete")
    public boolean deleteMember(@RequestParam("mno") int mno){

        return memberService.deleteMember(mno);
    }

    @PostMapping("/findId")
    public String findId(@RequestBody MemberDto memberDto) {

        return memberService.findId(memberDto);
    }

    @PostMapping("/findPw")
    public String findPw(@RequestBody MemberDto memberDto) {

        return memberService.findPw(memberDto);
    }

    @PostMapping("/login")
    public boolean login(HttpServletRequest request, @RequestBody MemberDto memberDto) {

        HttpSession session = request.getSession();
        session.setAttribute("loginDto", memberService.login(memberDto));
        MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");

        if(loginDto!= null){

            return true;

        }

        return false;
    }

    @GetMapping("/logout")
    public boolean logout(HttpServletRequest request) {

        HttpSession session = request.getSession();
        MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");

        if(loginDto!= null){

            request.getSession().removeAttribute("loginDto");
            return true;

        }
        return false;

    }


}