import ComponentList from './ComponentList.js';

import styles from './Component.css';

export default function Component() {

    let response = [
                {content : '리액트 배우기' } ,
                {content : '자바 배우기' } ,
                {content : '파이썬 배우기'} ,
                {content : 'C언어 배우기'}
            ];


    return(<>
        <div className="todowrap">
                <h1> 나만의 할일 목록 </h1>

                <div className="todo_top">
                    <input className="tcontent" type="text"/>
                    <button onClick="doPost()" type="button"> 등록 </button>
                </div>

                <div className="todo_bottom">
                     {
                                    response.map( r => {

                                        return(
                                            <ComponentList content={r.content}/>
                                        );

                                    })
                     }



                </div>

        </div>

    </>);

}