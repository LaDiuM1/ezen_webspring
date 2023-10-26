import {useState} from "react"; // 리액트 내장함수중에 useState 훅중 하나의 함수

export default function 상태관리컴포넌트(){

    let value1 = 10;

    function valuePlus(){
        ++value1;
    }



    /*
        useState
            [0] : 매개변수 값
            [1] : 수정 함수명 전달. bound dispatchSetState
        let [ 변수명, set함수명 ] = useState( 초기값 )

     */


    let 상태함수 = useState('훅이 어떤것일까?')
    console.log(상태함수)
    console.log(상태함수[0])
    console.log(상태함수[1])

    let [ value2 , setValue2 ] = useState( 10 );
    function value2증가(e) { setValue2( ++value2 ); }

    let value3 = '텍스트입력';

    let [ value4, setValue4 ] = useState("텍스트 입력");
    const value4변경 = e => { setValue4( e.target.value )}

    // ------------- return 안은 JSX 형식을 맞춰야함 -----------------
    return(<>

            <div> { value1 } </div>
            <button onClick={valuePlus} type={"button"}> value1증가 </button>
            <div> { value2 } </div>
            <button onClick={value2증가} type={"button"}> value2증가 </button>
            <input type={"text"} value = {value3} />
            <input type={"text"} value = {value4} onChange={ value4변경 } />

        </>)

}