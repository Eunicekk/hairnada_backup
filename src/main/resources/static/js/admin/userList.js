$('.stop-button').on('click', function (){
    let userNumber = $(this).closest('.member').find('.member-number').text();
   $.ajax({
      url : "/adminR/suspension" ,
       type: 'get',
       data: {
          userNumber : userNumber
       },
       success : function (){
           window.location.href = "/admin/userList";
           window.alert(userNumber + "번 회원이 정지 처리 되었습니다!");
       },
       error(a, b ,c ){
          console.log(b);
       }
   });
})

$('.recovery-button').on('click', function (){
    let userNumber = $(this).closest('.member').find('.member-number').text();
    $.ajax({
        url : "/adminR/restore" ,
        type: 'get',
        data: {
            userNumber : userNumber
        },
        success : function (){
            window.location.href = "/admin/userList";
            window.alert(userNumber + "번 회원이 복구 처리 되었습니다!");
        },
        error(a, b ,c ){
            console.log(b);
        }
    });
});