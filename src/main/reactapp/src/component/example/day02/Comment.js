// 사진 호출하기 : import 사진명 from '사진경로';
import logo from '../../../logo.svg';
// css 파일 호출
import styles from './Comment.css';

export default function Comment( props ){

    // ajax가 response한 데이터

    let response = [
            {name : '유재석' , content : '안녕하세요1'} ,
            {name : '강호동' , content : '안녕하세요2'} ,
            {name : '신동엽' , content : '안녕하세요3'}
        ];

    return(<>
        <div>
            <img src={logo} className="pimg" /> {/* 하나의 게시물 구역 */}
        </div>

        <div className="commentBox">
            {
                response.map( r => {

                    return(
                        <Comment name={r.name} content={r.content} />

                    );

                })
            }

        </div>


    </>)



}