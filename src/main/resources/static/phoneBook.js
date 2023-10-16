console.log('phoneBook.js.open');
getList()

function getList(){

    $.ajax({
        url: '/todo',
        type: 'get',
        async: false,
        success: data => {

            let todo_bottom = document.querySelector('.todo_bottom');
            let html = '';

            data.forEach( p => {
                html += `
                    <div class="todo"> <!-- todo 항목 1개 -->
                                <div class="tcontent"> ${p.name} </div>
                                <div class="tcontent"> ${p.phone} </div>
                                <div class="etcbtns">
                                    <button onclick="doPut(${p.pno})" type="button"> 수정 </button>
                                    <button onclick="doDelete(${p.pno})" type="button"> 삭제 </button>
                                </div>

                    </div>

                `

            })
            todo_bottom.innerHTML = html;

            },
        error:function(data){
            console.log('에러발생 : '+data)
        }

    })


}


function submit(){
    let name = document.querySelector('.nameValue').value;
    let phone = document.querySelector('.phoneValue').value;

    if(name == '' || phone == ''){
        alert('이름과 전화번호를 입력해주세요')
        return;
    }

    let jsondata = { name : name, phone: phone };

    let json = JSON.stringify(jsondata);


    $.ajax({
        url: '/todo',
        type: 'post',
        contentType: 'application/json',
        data: json,
        success: data =>{
            document.querySelector('.nameValue').value = '';
            document.querySelector('.phoneValue').value = '';
            getList()
            }

    })



}

function doPut(pno){

  let name = prompt('수정할 이름 입력')
  let phone = prompt('수정할 전화번호 입력')

    let jsondata = { pno : pno, name : name, phone: phone };

    let json = JSON.stringify(jsondata);

    $.ajax({
        url: '/todo',
        type: 'put',
        contentType: 'application/json',
        data: json,
        success: data =>{
               getList()
            }

    })
}

function doDelete(pno){

    let jsondata = { pno : pno };

    let json = JSON.stringify(jsondata);

    $.ajax({
        url: '/todo',
        type: 'delete',
        async: false,
        contentType: 'application/json',
        data: json,
        success: data =>{
               getList()
            }

    })

}




