console.log('todo.js.open');



// 1. post ajax

function doPost(){



    tcontent = document.querySelector('.tcontent').value;

    if(tcontent == ''){ alert('내용을 입력해주세요.'); return; }

    jsondata = { tcontent : tcontent, tstate : false };

    json = JSON.stringify(jsondata);

    console.log(json);


    $.ajax({
        url:'/todo',
        method:'post',
        contentType: 'application/json',
        data: json,
        success:data => {
            document.querySelector('.tcontent').value = '';
            getList();
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
    url:'/todo',
    method:'get',
    success: data => {
    console.log(data);
       let todoPrint = document.querySelector('.todo_bottom');
       html = '';

       data.forEach( p => {
          html += `
          <div class="${p.tstate ? 'successTodo' : ''} todo">
           <div class="${p.tstate ? 'successTodo' : ''} tcontent"> ${p.tcontent}</div>
           <div class="etcbtns">
             <button onclick="doPut(${p.tno},${p.tstate})" type="button"> 상태변경 </button>
             <button onclick="doDelete(${p.tno})" type="button"> 제거하기 </button>
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
function doPut(tno, tstate){


    jsondata = { tno : tno, tstate : !tstate };

    json = JSON.stringify(jsondata);

    console.log(json);


    $.ajax({
        url:'/todo',
        method:'put',
        contentType: 'application/json',
        data: json,
        success: data => {

            getList();

        },
        error:function(data){
            console.log('에러발생 : '+data)
            }
        })



}



// 4. delete ajax

function doDelete(tno){


        $.ajax({
            url:'/todo',
            method:'delete',
            data: { tno : tno },
            success: data => {
                getList();
            },
            error:function(data){
                console.log('에러발생 : '+data)
                }
            })



}