import { useState, useEffect } from "react";

export default function 생명주기컴포넌트(){

    // 1. useState 함수를 이용한 [ 변수, 상태관리함수 ] 반환
    let [ value, setValue ] = useState( 0 );
    const valueUpdate =  e => { setValue(++value); }

    let [ value2, setValue2 ] = useState( 0 );
    const valueUpdate2 =  e => { setValue2(++value2); }

    // 2. 컴포넌트의 생명주기
        // 1. 컴포넌트 생성 / 업데이트 / 제거 시 자동 실행되는 함수


        // 2. 컴포넌트 생성시에만 실행
        // useEffect( 함수 , [] ); 대괄호는 의존성배열이라고 부름
    useEffect( ()=>{ console.log('[2]Effect 실행') } , [ ])

        //3. 컴포넌트 탄생 / [] 대괄호에 연관된 값의 상태가 변경 시에만 적용
    // useEffect( 함수 , [value] )
    useEffect( ()=>{ console.log('[3]Effect 실행') } , [ value ])

    return(<>
        <div> { value } </div>
        <button onClick={ valueUpdate } > value 증가 </button>

        <div> { value2 } </div>
        <button onClick={ valueUpdate2 } > value2 증가 </button>


        </>)

}