package ezenweb.service;

import ezenweb.model.dto.MemberDto;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.repository.MemberEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;


@Service
public class MemberService {
    // Controller -> Service -> Repository 요청
    // Controller <- Service <- Repository 응답

    @Autowired
    private MemberEntityRepository memberEntityRepository;

    @Transactional
    public boolean signUp(@RequestBody MemberDto memberDto) {

        MemberEntity memberEntity = memberEntityRepository.save(memberDto.toEntity());

        if (memberEntity.getMno() > 0) {
            return true;
        }

        return false;

    }


    // 세션을 구현 안했을 때 호출
    /*
    @Transactional
    public MemberDto getMember(int mno) {
        Optional<MemberEntity> memberEntityOptional = memberEntityRepository.findById(mno);

        if (memberEntityOptional.isPresent()) {

            return memberEntityOptional.get().toDto();

        }

        return null;
    }

    */

    @Transactional
    public boolean updateMember(@RequestBody MemberDto memberDto) {

        Optional<MemberEntity> memberEntityOptional = memberEntityRepository.findById(memberDto.getMno());

        if (memberEntityOptional.isPresent()) {
            MemberEntity memberEntity = memberEntityOptional.get();

            memberEntity.setMname( memberDto.getMname() );
            memberEntity.setMphone( memberDto.getMphone() );
            if(memberDto.getMrole() != null){
                memberEntity.setMrole( memberDto.getMrole() );
            }
            memberEntity.setMemail( memberDto.getMemail() );
            memberEntity.setMpassword( memberDto.getMpassword() );

            return true;

        }

        return false;

    }

    @Transactional
    public boolean deleteMember(int mno){

        Optional<MemberEntity> memberEntityOptional = memberEntityRepository.findById(mno);
        if(memberEntityOptional.isPresent()){
            memberEntityRepository.deleteById(mno);
            return true;
        }

        return false;

    }


    // 아이디 찾기 함수

    @Transactional
    public String findId(@RequestBody MemberDto memberDto) {
        List<MemberEntity> EntityList = memberEntityRepository.findAll();

        for (MemberEntity entity : EntityList) {
            System.out.println("entity = " + entity);
            System.out.println("memberDto = " + memberDto);
            if(entity.getMname().equals(memberDto.getMname())
                && entity.getMphone().equals(memberDto.getMphone())){

                return entity.getMid();
                
            }


        }

        return null;


    }

    // 비밀번호 찾기 함수
    @Transactional
    public String findPw(@RequestBody MemberDto memberDto) {
        List<MemberEntity> EntityList = memberEntityRepository.findAll();

        for (MemberEntity entity : EntityList) {
            if(entity.getMemail().equals(memberDto.getMemail())
                    && entity.getMphone().equals(memberDto.getMphone())){

                return entity.getMpassword();
            }

        }

        return null;

    }

    // 로그인 함수
    @Transactional
    public MemberDto login(@RequestBody MemberDto memberDto) {
        List<MemberEntity> EntityList = memberEntityRepository.findAll();

        for (MemberEntity entity : EntityList) {
            if(entity.getMid().equals(memberDto.getMid())
                    && entity.getMpassword().equals(memberDto.getMpassword())){



                return entity.toDto();
            }

        }
        return null;

    }

    // 아이디 중복 체크
    public boolean idCheck(@RequestParam String mid){

        return memberEntityRepository.existsByMid(mid);

    }

    // 내정보 페이지 데이터 호출
    public MemberDto getInfo(int mno){
        Optional<MemberEntity> OptionalEntity = memberEntityRepository.findById(mno);
        MemberDto memberDto = new MemberDto();

        if(OptionalEntity.isPresent()){
            MemberEntity entity = OptionalEntity.get();

            memberDto.setMid(entity.getMid());
            memberDto.setMemail(entity.getMemail());
            memberDto.setMname(entity.getMname());
            memberDto.setMphone(entity.getMphone());
            memberDto.setMno(entity.getMno());
            memberDto.setMpassword(entity.getMpassword());

        }

        return memberDto;

    }

    // 패스워드 체크 함수
    public boolean passwordCheck(@RequestBody MemberDto memberDto){
        return memberEntityRepository.existsByMnoAndMpassword(memberDto.getMno(), memberDto.getMpassword());
    }


}

