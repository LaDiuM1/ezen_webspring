console.log('todo.js.open');



// 1. post ajax

function doPost(){

    $.ajax({
        url:'http://localhost:8080/todo/index',
        method:'post',
        data:{ data : '통신성공'},
        success:data => {
            console.log(data);
        },
        error:function(data){
        console.log('에러발생 : '+data)
        }

    })

}



getList();
// 2. get ajax
function getList(){


    $.ajax({
    url:'http://localhost:8080/todo/get',
    method:'get',
    success: data => {
       let todoPrint = document.querySelector('.todo_bottom');
       html = '';

       data.forEach( p => {
          html += `
          <div class="todo">
            <div class="etcbtns">
             <button type="button"> 상태변경 </button>
             <button type="button"> 제거하기 </button>
            </div>
           </div>

          `

       })
        todoPrint.innerHTML = html;

    },
    error:function(data){
        console.log('에러발생 : '+data)
        }
    })

}




// 3. put ajax




// 4. delete ajax