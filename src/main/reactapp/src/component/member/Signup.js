import axios from "axios";
import {Link} from "react-router-dom";
import styles from '../css/login.css';
import {useState} from "react";

export default function Signup(){

    // 회원 가입 버튼 클릭 시
    function onSignup() {
        let data  = {
            mid : document.querySelector('.mid').value,
            memail : document.querySelector('.memail').value,
            mpassword : document.querySelector('.mpassword').value,
            mname : document.querySelector('.mname').value,
            mphone : document.querySelector('.mphone').value

        }
        axios
            .post('/member/post', data)
            .then( r => {
                if(r.data) { alert("회원가입 성공");  window.location.href = "/login"; }
                else { alert("회원가입 실패") }
            })

    }



    let [mid, setMid] = useState('');
    let [midCheck, setMidCheck] = useState('');

    const midValueChange = (e) => {

        let changeMid = e.target.value;
        setMid(changeMid);


        axios
            .get('/member/idCheck', { params : { 'mid' : mid } } )
            .then(r => {
                if(r.data){
                    setMidCheck('사용중인 아이디입니다.');
                }
                else{
                    setMidCheck('사용가능한 아이디입니다.');
                }

            })
    }


    return(<>

        <div className={"signupContainer"}>
            <form>
                <div className={"loginArea"}>
                    <div>
                        <div className={"textArea"}>아이디</div>
                        <div className={"inputArea"}><input onKeyDown={midValueChange}  type={"text"} className={"mid"} /></div>
                    </div>
                    <div>
                        <div> { midCheck }</div>
                    </div>
                    <div>
                        <div className={"textArea"}>이메일 </div>
                        <div className={"inputArea"}><input type={"text"} className={"memail"} /></div>
                    </div>
                    <div>
                        <div className={"textArea"}>비밀번호 </div>
                        <div className={"inputArea"}><input type={"password"} className={"mpassword"}/></div>
                    </div>
                    <div>
                        <div className={"textArea"}>비밀번호 확인 </div>
                        <div className={"inputArea"}><input type={"password"} className={"pwCheck"}/></div>
                    </div>

                    <div>
                        <div className={"textArea"}>이름 </div>
                        <div className={"inputArea"}><input type={"text"} className={"mname"}/></div>
                    </div>

                    <div>
                        <div className={"textArea"}>전화번호 </div>
                        <div className={"inputArea"}><input type={"text"} className={"mphone"}/></div>
                    </div>

                    <div className={"loginButton"}>
                        <button onClick={onSignup} type={"button"}>회원가입</button>
                    </div>

                </div>


            </form>

        </div>

    
    
    
    </>)

}