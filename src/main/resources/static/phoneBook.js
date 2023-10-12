console.log('phoneBook.js.open');
getList()

function getList(){

    $.ajax({
        url: 'http://localhost:80/todo',
        type: 'get',
        success: data => {
            console.log(data);

            let print = document.querySelector('.print');
            let html = '<tr> <th> 이름 </th> <th> 전화번호 </th> <th> 수정하기 </th> <th> 삭제하기 </th> </tr>';

            data.forEach( p => {
            console.log(p.pno);
                html += `
                     <tr>
                      <td> ${p.name} </td> <td> ${p.phone} </td> <td>
                      <button onclick="doPut(${p.pno})" type="button">수정</button> </td> <td> <button onclick="doDelete(${p.pno})" type="button">삭제</button> </td>
                     </tr>
                `
                print.innerHTML = html;

            })

            },
        error:function(data){
            console.log('에러발생 : '+data)
        }

    })


}


function submit(){
    let name = document.querySelector('.nameValue').value;
    let phone = document.querySelector('.phoneValue').value;

    let jsondata = { name : name, phone: phone };

    let json = JSON.stringify(jsondata);
    console.log(json);


    $.ajax({
        url: 'http://localhost:80/todo',
        type: 'post',
        contentType: 'application/json',
        data: json,
        success: data =>{
            console.log(data);
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
    console.log(json);

    $.ajax({
        url: 'http://localhost:80/todo',
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
    console.log(json);

    $.ajax({
        url: 'http://localhost:80/todo',
        type: 'delete',
        contentType: 'application/json',
        data: json,
        success: data =>{
               getList()
            }

    })



}




