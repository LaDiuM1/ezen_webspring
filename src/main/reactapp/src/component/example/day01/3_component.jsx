/*
    컴포넌트 내부에서 다른 컴포넌트 호출 하는 방법
    1. 같은 jsx 파일이면 import 생략
    2. 다른 jsx파일이면 import



*/






function Component3() {


    return(<>
        <h3> Component3에서 작성된 HTML </h3>
        <CustomTag3 />
    </>)

}

function CustomTag3() {


    return(<>
        <div> 커스텀 태그3 </div>
        <input/>
        <Component4 />
    </>)

}

function Component4() {


    return(<>
        <h3> Component4에서 작성된 HTML </h3>
        <CustomTag4 />
    </>)

}

function CustomTag4() {


    return(<>
        <div> 커스텀 태그4 </div>
        <input />
    </>)

}

export default Component3;