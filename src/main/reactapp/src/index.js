import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

// 3. 내가 만든 컴포넌트 호출 ( 사용자 정의 함수 )
// import 컴포넌트명 from 'jsx파일경로';

import 라우터컴포넌트 from './component/example/day03/1_라우터컴포넌트.js';
/*
import Component2 from './component/example/day01/2_component.jsx';
import Component1 from './component/example/day01/1_component.jsx';
import Component3 from './component/example/day01/3_component.jsx';
import Component5 from './component/example/day01/4_component.jsx';
import Print from './component/example/day01/과제1.jsx';
import CssComponent from './component/example/day02/1_컴포넌트css.js';
import CommentList from './component/example/day02/CommentList.js';
import Component from './component/과제/과제2/Component.js';
import CommentList from "./component/example/day02/CommentList";
*/
import Index from './component/Index.js';
import 생명주기컴포넌트 from './component/example/day05/2_생명주기컴포넌트'

// 1. index.html에 <div id="root"> dom 객체 호출npx
const root = ReactDOM.createRoot(document.getElementById('root'));


// 2. 리액트 랜더링 ( jsx --> html 변환 )
root.render(  <Index />  );
// 원본 root.render( <React.StrictMode> <Index /> </React.StrictMode> );
// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
