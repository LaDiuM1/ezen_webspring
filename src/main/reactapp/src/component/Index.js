
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";

import styles from "./css/index.css";
import Header from "./Header";
import Main from "./Main";
import Footer from "./Footer";
import Component1 from "./example/day01/1_component";
import Component2 from "./example/day01/2_component";
import Component3 from "./example/day01/3_component";
import Component5 from "./example/day01/4_component";
import ExampleList from "./example/ExampleList";
import CssComponent from "./example/day02/1_컴포넌트css";
import CommentList from "./example/day02/CommentList";
import Component from "./과제/과제2/Component";
import Assi from "./과제/과제1/Assi";
import Login from "./member/Login";
import Signup from "./member/Signup";
import Comment from "./example/day02/Comment";


export default function Index ( props ){

    return (<>
    <div className={'webContainer'}>
        <BrowserRouter>

                <Header/>
                <Routes>
                    <Route path='/' element={<Main/>}/>

                    {/* 예제 */}
                    <Route path={'/example'} element={<ExampleList/>}/>
                        <Route path={'/example/day01/1_component'} element={<Component1/>}/>
                        <Route path={'/example/day01/2_component'} element={<Component2/>}/>
                        <Route path={'/example/day01/3_component'} element={<Component3/>}/>
                        <Route path={'/example/day01/4_component'} element={<Component5/>}/>
                        <Route path={'/example/day02/1_컴포넌트css'} element={<CssComponent/>}/>
                        <Route path={'/example/day02/CommentList'} element={<CommentList/>}/>
                        <Route path={'/과제/과제2/Assi'} element={<Assi/>}/>
                        <Route path={'/과제/과제2/Component'} element={<Component/>}/>

                    {/* 회원 */}
                    <Route path={'/login'} element={ <Login /> } />
                    <Route path={'/signup'} element={ <Signup /> } />

                </Routes>
                <Footer/>

        </BrowserRouter>
    </div>


    </>);

}