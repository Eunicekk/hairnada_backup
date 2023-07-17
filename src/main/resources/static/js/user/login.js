
// 로그인 실패 alert로 했음 css실행은 왜 안될까..?
$(document).ready(function(){
$('.login-button').click(function (){
  var userId = $(".login-box").val();
  var userPassword = $(".password-box").val();

  $.ajax({
    url : "/users/loginFail",
    type: "GET",
    data: {
      userId : userId,
      userPassword : userPassword
    },
    success : function(result){
      if(result == 0){
        alert("로그인 또는 비밀번호가 일치하지 않습니다");
        // $('id-pw-no').css("display", "inline-block");
      }
    },
    error: function(){
      console.log("로그인 오류!!");
    }
  });
});
});


