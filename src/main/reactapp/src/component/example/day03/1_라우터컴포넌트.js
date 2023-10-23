/*

    컴포넌트 만들기
        - 파일명.js / 파일명.jsx


 */

import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Component1 from "../day01/1_component";
import Component2 from "../day01/2_component";
import Component3 from "../day01/3_component";
import Component5 from "../day01/4_component";



export default function 라우터컴포넌트( props ){

        return(<>

            <BrowserRouter> {/* 브라우저 라우터 시작 */}
                <고정컴포넌트 /> { /* BrowserRouter 안에 있고 Routes 밖에 있는 컴포넌트 */}
                <Routes> {/* 화면이 전환되는 컴포넌트들의 url 정의 */}
                    <Route path='day01/1_component.jsx' element = { <Component1/> } />
                    <Route path='day01/2_component.jsx' element = { <Component2/> } />
                    <Route path='day01/3_component.jsx' element = { <Component3/> } />
                    <Route path='day01/4_component.jsx' element = { <Component5/> } />
                </Routes>
            </BrowserRouter> {/* 브라우저 라우터 종료 */}

        </>)


}

function 고정컴포넌트( props ) {

    return(<>
        <div>
            <a href='/day01/1_component.jsx'> 컴포넌트1 </a>
            <a href='/day01/2_component.jsx'> 컴포넌트2 </a>
            <a href='/day01/3_component.jsx'> 컴포넌트3 </a>
            <a href='/day01/4_component.jsx'> 컴포넌트4 </a>
        </div>

        <div>
            <Link to='/day01/1_component.jsx'> 컴포넌트1 </Link>
            <Link to='/day01/2_component.jsx'> 컴포넌트2 </Link>
            <Link to='/day01/3_component.jsx'> 컴포넌트3 </Link>
            <Link to='/day01/4_component.jsx'> 컴포넌트4 </Link>
        </div>


    </>)



}