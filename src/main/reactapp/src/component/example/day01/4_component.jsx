
function Component5() {

    return(<>
        <input type="text" />
        <CustomProperty 이름="유재석" 나이 = {30}/>
        <CustomProperty 이름="강호동" 나이 = {40}/>
    </>)

}

function CustomProperty( props ) {
    console.log( props );
    return(<>
        <div> component5가 전달한 속성 : 이름 :  {props.이름} / 나이 :  {props.나이} </div>
    </>)

}

export default Component5;