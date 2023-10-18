
function Print() {

    return(<>
        <h1> 도서명 : 이것이 자바다 </h1>
        <CustomProperty 이름="유재석" 가격 = {30000} />
        <h1> 도서명 : 이것이 파이썬 </h1>
        <CustomProperty 이름="강호동" 가격 = {25000} />
        <h1> 도서명 : 이것이 리액트 </h1>
        <CustomProperty 이름="신동엽" 가격 = {28000} />
    </>)


}

function CustomProperty( props ) {

    return(<>
            <div> 저자 : {props.이름} / 소비자가격: {props.가격} </div>
        </>)

}


export default Print;