import { Link } from 'react-router-dom';
import styles from './css/Header.css';
import axios from "axios";
import {useState, useEffect} from "react";

export default function Header ( props ){

    let [ login, setLogin ] = useState(null);

    // 회원정보 호출, useEffect에 []를 사용해 최초 1회만 실행
    useEffect( ()=>{
        axios
            .get('/member/get')
            .then( r => {
                if( r.data != '' ){
                    setLogin( r.data );
                    sessionStorage.setItem( 'login_token', JSON.stringify(r.data ));
                    setLogin( JSON.parse( sessionStorage.getItem( 'login_token' )))
                }
            })
    } , [ ])





    function logout(){
        axios
            .get('/member/logout')
            .then( r => {
                if (!r.data) {
                    setLogin( null );
                    window.location.href = '/';

                }
            })


    }

    return(<>

        <header>
                <h2> <Link to={'/'}> 리액트 </Link> </h2>
                <ul className={"headerMenu"}>
                    <li> <Link to={'example'}> 리액트예제 </Link> </li>
                    <li> <Link to={'/'}> TODO </Link> </li>
                    <li> <Link to={'/'}> 비회원게시판 </Link> </li>
                    <li> <Link to={'/'}> 회원게시판 </Link> </li>


                    {
                        login == null ? (<>
                                <li> <Link to={'/signup'}> 회원가입 </Link> </li>
                                <li> <Link to={'/login'}> 로그인 </Link> </li>
                            </>) :
                            (<>
                                <li> <Link to={'/info'}> 내정보 </Link> </li>
                                <li> <div onClick={logout} > 로그아웃 </div> </li>
                            </>)
                    }

                </ul>

        </header>
    </>)


}