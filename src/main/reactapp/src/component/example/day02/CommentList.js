// 외부 컴포넌트 호출

import Comment from './Comment.js';

export default function CommentList( ){

    return(<>
        <div className="commentListBox">
            <Comment name={"유재석"} content = {"안녕하세요1."}/>
            <Comment name={"강호동"} content = {"안녕하세요2."}/>
            <Comment name={"신동엽"} content = {"안녕하세요3."}/>
        </div>

    </>)



}