import axios from "axios";
import styles from '../css/login.css';
import {Link} from "react-router-dom";
import Main from "../Main";



export default function Login(){


    // 로그인 버튼 클릭 시
    function onLogin() {
        // axios를 통한 input 데이터 전송

        let data = {
            mid : document.querySelector('.mid').value,
            mpassword : document.querySelector('.mpassword').value

        }

        axios
            .post('http://192.168.17.10:80/member/login', data)
            .then( r => {
                if(r.data) { alert("로그인 성공")
                    window.location.href = "/";

                }
                else { alert("로그인 실패") }
            })
            // CORS policy 오류 해결 방안
                // - 스프링 controller 클래스 @CrossOrigin 어노테이션 사용



    }


    return(<>

        <div className={"loginContainer"}>

            <form>
                <div className={"loginArea"}>
                    <div>
                        <div className={"textArea"}>아이디 </div>
                        <div className={"inputArea"}><input type={"text"} className={"mid"} /></div>
                    </div>
                    <div>
                        <div className={"textArea"}>비밀번호 </div>
                        <div className={"inputArea"}><input type={"password"} className={"mpassword"}/></div>
                    </div>

                    <div className={"bottomArea"}>
                        <Link to={''}> 아이디 찾기 </Link> <Link to={''}> 비밀번호 찾기 </Link>

                    </div>
                    <div className={"loginButton"}>
                        <button onClick={onLogin} type={"button"}>로그인</button>
                    </div>

                </div>


            </form>

        </div>
    </>)

}
