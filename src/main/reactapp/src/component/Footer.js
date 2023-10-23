import styles from './css/Footer.css';

export default function Footer ( props ){
    return(<>

        <footer>
                <nav>
                    <a href={''} target={'_black'}> 회사소개</a>
                    <a href={''} target={'_black'}> 개인정보규정</a>
                    <a href={''} target={'_black'}> 환불규정</a>
                    <a href={''} target={'_black'}> 찾아오시는길</a>
                    <a href={''} target={'_black'}> 고객센터</a>

                </nav>
                <p className={"footerInfo"}>
                    <div> 이젠 리액트 </div>
                    <div> ys@gmail.com </div>
                    <div> 010-1234-1234 </div>
                    <div> Copyright 2023. ezenreact. All Rights Reserved </div>
                </p>
        </footer>

    </>)


}