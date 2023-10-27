import axios from "axios";
import {Link} from "react-router-dom";
import styles from '../css/login.css';
import {useEffect, useState} from "react";
import Header from "../Header";


export default function Info(){




    let [ member, setMember ] = useState({mid : '', memail: '', mname : '', mphone: '', mno : 0 } );

    // 이메일 변경 상태관리

    const emailChange = e =>{
        let changeMember = { ...member };

        changeMember.memail = e.target.value;

        setMember(changeMember);
    }

    const phoneChange = e =>{
        let changeMember = { ...member };

        changeMember.mphone = e.target.value;

        setMember(changeMember);
    }


    // 회원정보 호출, useEffect에 []를 사용해 최초 1회만 실행
    useEffect( ()=>{
        axios
            .get('/member/getInfo')
            .then( r => {
                console.dir(r)
                if( r.data !== '' ){
                    setMember(r.data);
                }
            })
    } , [ ])

    // 회원 탈퇴
    const withdrawal = e => {
        if(!window.confirm('회원을 탈퇴하시겠습니까?')){
            return;
        }

        axios
            .delete('/member/delete', { params : { mno : member.mno } })
            .then( r=> {
                if(r.data){
                    alert('회원 탈퇴하였습니다.')
                    sessionStorage.removeItem( 'login_token');
                    window.location.href = '/';
                }
            })

    }

    const passwordChange = e => {
        if (newPassword.mpassword === newPassword.mpassword2) {
            setPwCheck('비밀번호가 일치합니다. [테스트, 한글자 늦게 인식]')
        } else {
            setPwCheck('비밀번호가 일치하지 않습니다. [테스트, 한글자 늦게 인식]')
        }

        let changePassword = { ...newPassword };

        changePassword.mpassword = e.target.value;

        setNewpassword(changePassword);

    }

    const passwordChange2 = e => {
        if (newPassword.mpassword === newPassword.mpassword2) {
            setPwCheck('비밀번호가 일치합니다. [테스트, 한글자 늦게 인식]')
        } else {
            setPwCheck('비밀번호가 일치하지 않습니다.[테스트, 한글자 늦게 인식]')
        }


        let changePassword = { ...newPassword };

        changePassword.mpassword2 = e.target.value;

        setNewpassword(changePassword);

    }



    let [ newPassword, setNewpassword] = useState({ mpassword : '', mpassword2 : ''})
    // 회원 정보 수정
    const update = e => {
        if (newPassword.mpassword !== newPassword.mpassword2) {
            alert('비밀번호가 다릅니다.')
            return;
        }

        let password = prompt('기존 비밀번호 입력')

        let data = { mno : member.mno, mpassword : password };

        axios
            .post('member/passwordCheck', data)
            .then( r => {
                if(r.data){
                    updateMember();
                }
                else{
                    alert('비밀번호가 일치하지 않습니다.')
                }
            })


    }

    let [ pwCheck, setPwCheck ] = useState('');


    const updateMember = e => {


        member.mpassword = newPassword.mpassword;

        axios
            .put('/member/put', member)
            .then( r => {
                if(r.data){
                    alert('회원정보 수정 완료')
                    window.location.href = '/';
                }
                else{
                    alert('회원정보 수정 실패')
                }
            })




    }

    return(<>

        <div className={"signupContainer"}>
            <form>
                <div className={"loginArea"}>
                    <div>
                        <div className={"textArea"}>회원등급 : 5 </div>
                    </div>
                    <div>
                        <div className={"textArea"}>아이디</div>
                        <div className={"inputArea"}>
                        <input disabled={true} type={"text"} className={"mid"} value={member.mid} /></div>
                    </div>
                    <div>
                        <div className={"textArea"}> 이메일 </div>
                        <div className={"inputArea"}>
                        <input type={"text"} onChange={emailChange} className={"memail"} value={member.memail} /></div>
                    </div>
                    <div>
                        <div className={"textArea"}> 새로운 비밀번호 </div>
                        <div className={"inputArea"}>
                        <input type={"password"} onChange={passwordChange} className={"mpassword"} value={ newPassword.mpassword } /></div>
                    </div>
                    <div>
                        <div className={"textArea"}> 비밀번호 확인 </div>
                        <div className={"inputArea"}><
                        input type={"password"} onChange={passwordChange2} className={"pwCheck"} value={ newPassword.mpassword2 }/></div>
                    </div>
                    <div>
                        <div> { pwCheck }</div>
                    </div>
                    <div>
                        <div className={"textArea"}> 이름 </div>
                        <div className={"inputArea"}>
                        <input disabled={true} type={"text"} className={"mname"} value={member.mname} /></div>
                    </div>

                    <div>
                        <div className={"textArea"}> 전화번호 </div>
                        <div className={"inputArea"}>
                        <input type={"text"} onChange={phoneChange} className={"mphone"}  value={member.mphone} /></div>
                    </div>

                    <div className={"loginButton"}>
                        <button onClick={update} type={"button"}> 정보수정 </button>
                        <button onClick={withdrawal} type={"button"}> 회원탈퇴 </button>
                    </div>

                </div>


            </form>

        </div>

    
    
    
    </>)

}