//  확장자 : jsx, js
import styles from './컴포넌트.css';


function CssComponent() {

    // 1. css를 객체에 속성[카멜표기법] 으로 선언하기

    const cssStyle = {
        backgroundColor: 'red',
        width: '500px',
        height: '200px',
        margin: '0 auto'
    }

    return(<>
        <div style={ cssStyle }> CSS 적용하는 방법1 </div>
        <div style={{
                            backgroundColor: 'blue',
                            width: '500px',
                            height: '200px',
                            margin: '0 auto'
                        }}> CSS 적용하는 방법2 </div>
        <div className="box3"> CSS 적용하는 방법3 </div>
    </>)

}

export default CssComponent;