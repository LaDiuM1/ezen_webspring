import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

// 3. 내가 만든 컴포넌트 호출 ( 사용자 정의 함수 )
// import 컴포넌트명 from 'jsx파일경로';

import Component1 from './component/example/day01/1_component.jsx';
import Component2 from './component/example/day01/2_component.jsx';
import Component3 from './component/example/day01/3_component.jsx';
import Component5 from './component/example/day01/4_component.jsx';
import Print from './component/example/day01/과제1.jsx';

// 1. index.html에 <div id="root"> dom 객체 호출npx
const root = ReactDOM.createRoot(document.getElementById('root'));


// 2. 리액트 랜더링 ( jsx --> html 변환 )
root.render( <React.StrictMode> <Print /> </React.StrictMode> );

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
