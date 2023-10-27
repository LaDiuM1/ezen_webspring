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

    @Autowired HttpServletRequest request;


    // 1. 회원가입
    @PostMapping("/post")
    public boolean signUp(@RequestBody MemberDto memberDto) {

        return memberService.signUp(memberDto);

    }

    // 세션을 구현 안했을 때 호출
    /*
    // 2. 회원정보 호출
    @GetMapping("/get")
    public MemberDto getMember(@RequestParam("mno") int mno) {

        return memberService.getMember(mno);
    }
    */

    // 세션 구현시 회원 정보 호출
    @GetMapping("/get")
    public MemberDto getMember(HttpServletRequest request) {

        HttpSession session = request.getSession();

        return (MemberDto)session.getAttribute("loginDto");
    }


    // 3. 회원정보 수정
    @PutMapping("/put")
    public boolean updateMember(@RequestBody MemberDto memberDto) {
        System.out.println("memberDto = " + memberDto);
        
        return memberService.updateMember(memberDto);
    }


    // 4. 회원탈퇴
    @DeleteMapping("/delete")
    public boolean deleteMember(@RequestParam("mno") int mno){

        HttpSession session = request.getSession();

        boolean result = memberService.deleteMember(mno);

        if(result){
            session.removeAttribute("loginDto");
        }

        return result;
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
    public boolean login(@RequestBody MemberDto memberDto) {

        HttpSession session = request.getSession();
        MemberDto loginDto = memberService.login(memberDto);
        session.setAttribute("loginDto", loginDto );

        if(loginDto!= null){

            return true;

        }

        return false;
    }

    @GetMapping("/logout")
    public boolean logout() {

        HttpSession session = request.getSession();
        MemberDto loginDto = (MemberDto)session.getAttribute("loginDto");

        if(loginDto!= null){

            request.getSession().removeAttribute("loginDto");
            return true;

        }
        return false;

    }

    @GetMapping("/idCheck")
    public boolean idCheck(@RequestParam String mid){

        return memberService.idCheck(mid);

    }

    // 내정보 페이지 정보 호출
    @GetMapping("/getInfo")
    public MemberDto getInfo (){

        HttpSession session = request.getSession();
        MemberDto memberDto = (MemberDto)session.getAttribute("loginDto");

        return memberService.getInfo(memberDto.getMno());

    }

    @PostMapping("/passwordCheck")
    public boolean passwordCheck(@RequestBody MemberDto memberDto){
        System.out.println("memberDto = " + memberDto);
        return memberService.passwordCheck(memberDto);
    }

}
