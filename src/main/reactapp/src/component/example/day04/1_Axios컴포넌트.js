
import axios from 'axios';
export default function Axios컴포넌트 ( props ){


        // 컴포넌트(함수) 안에서 함수 정의하기
        // 1. 기본함수
        function 함수1( e ){ console.log(e) }

        // 2. 화살표함수를 저장하는 상수
        const 함수2 = function(e){ console.log(e) }

        // 3. 화살표함수를 저장하는 상수
        const 함수3 = (e, data) => { console.log(e); console.log(data) }


        // 1. get
        function doGet(){
            // axios.메소드 ( url ).then( 리턴값 => { } )
            axios
                .get('https://jsonplaceholder.typicode.com/posts')
                .then( response => { console.log( response ); })

            axios
                .get('https://jsonplaceholder.typicode.com/posts/1')
                .then( response => {console.log( response )})

            axios
                .get('https://jsonplaceholder.typicode.com/comments?postId=1')
                .then( result => { console.log( result )})

            axios
                .get('https://jsonplaceholder.typicode.com/comments', { params : { 'postId' : 1 } } )
                .then( r => {console.log(r)})

        }

        function doPost(){
            let saveInfo = { title: 'foo', body: 'bar',  userId: 1, }

            axios
                .post('https://jsonplaceholder.typicode.com/posts', saveInfo)
                .then( r => { console.log(r)} )



        }

        function doPut(){
            let updateInfo = {  id: 1,  title: 'updateFoo',  body: 'updateBar',   userId: 1 }

            axios
                .put('https://jsonplaceholder.typicode.com/posts/1', updateInfo)
                .then( r => { console.log(r)})

        }

        function doDelete() {

            axios
                .delete('https://jsonplaceholder.typicode.com/posts/1')
                .then( r => { console.log( r )})

        }


    return(<>


            <h3> Axios 테스트 </h3>
            <button onClick={ 함수1 } type={"button"}> 함수1 </button>
            <button onClick={ 함수2 } type={"button"}> 함수2 </button>
            <button onClick={ e => 함수3(e, 3) } type={"button"}> 함수3 </button>
            <button onClick={ doGet } type={"button"}> doGet </button>
            <button onClick={ doPost } type={"button"}> doPost </button>
            <button onClick={ doPut } type={"button"}> doPut </button>
            <button onClick={ doDelete } type={"button"}> doDelete </button>

        </>)






}