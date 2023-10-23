import { Link } from 'react-router-dom';
import Assi from "../과제/과제1/Assi";
import Comment from "./day02/Comment";

export default function ExampleList( props ){

    return(<>
            <div style={{ display: 'flex', justifyContent: 'space-between'}}>
                <Link to={'/example/day01/1_component'}> 컴포넌트1 예제 </Link>
                <Link to={'/example/day01/2_component'}> 컴포넌트2 예제 </Link>
                <Link to={'/example/day01/3_component'}> 컴포넌트3 예제 </Link>
                <Link to={'/example/day01/4_component'}> 컴포넌트4 예제 </Link>
                <Link to={'/example/day02/1_컴포넌트css'}> css 적용 예제 </Link>
                <Link to={'/example/day02/CommentList'}> 코멘트 리스트 예제 </Link>
                <Link to={'/과제/과제2/Assi'}> 리액트과제1 </Link>
                <Link to={'/과제/과제2/Component'}> 리액트과제2 </Link>


            </div>


        </>)
}