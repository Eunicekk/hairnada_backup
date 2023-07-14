// 성별 체크 css
$(".female-box").on("click", function () {
  $(".female-box").css("background-color", "#e0e0e0");
  $(".male-box").css("background-color", "#FFF");
});

$(".male-box").on("click", function () {
  $(".male-box").css("background-color", "#e0e0e0");
  $(".female-box").css("background-color", "#FFF");
});


// 드롭다운 박스
$(document).ready(function() {
    $('.dropdown').click(function() {
      $(this).find('.dropdown-menu').toggle();
    });
  
    $(document).click(function(e) {
      var target = e.target;
      if (!$(target).is('.dropdown') && !$(target).parents().is('.dropdown')) {
        $('.dropdown-menu').hide();
      }
    });
});

$('.dropdown-menu li').on('click', function(){
    let $input = $('.dropdown-btn');
    let text = $(this).text();
    $input.html(text + `
    <span class="material-symbols-rounded">
    expand_more
    </span>
    `);
  })


// 주소 api
function sample6_execDaumPostcode() {
  new daum.Postcode({
      oncomplete: function(data) {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 각 주소의 노출 규칙에 따라 주소를 조합한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          var addr = ''; // 주소 변수
          var extraAddr = ''; // 참고항목 변수

          //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
          if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
              addr = data.roadAddress;
          } else { // 사용자가 지번 주소를 선택했을 경우(J)
              addr = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if(data.userSelectedType === 'R'){
              // 법정동명이 있을 경우 추가한다. (법정리는 제외)
              // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
              if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                  extraAddr += data.bname;
              }
              // 건물명이 있고, 공동주택일 경우 추가한다.
              if(data.buildingName !== '' && data.apartment === 'Y'){
                  extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
              }
              // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
              if(extraAddr !== ''){
                  extraAddr = ' (' + extraAddr + ')';
              }
              // 조합된 참고항목을 해당 필드에 넣는다.
              document.getElementById("sample6_extraAddress").value = extraAddr;
          
          } else {
              document.getElementById("sample6_extraAddress").value = '';
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          document.getElementById('sample6_postcode').value = data.zonecode;
          document.getElementById("sample6_address").value = addr;
          // 커서를 상세주소 필드로 이동한다.
          document.getElementById("sample6_detailAddress").focus();
      }
  }).open();
}

// 아이디 중복검사
$(document).ready(function() {
    // 중복 검사 버튼 클릭 시 이벤트 처리
    $(".double-check").click(function() {
        var userId = $(".id-box").val();  // 입력된 사용자 아이디

        // Ajax 요청
        $.ajax({
            url: "/users/checkId",
            type: "GET",
            data: { userId: userId },
            success: function(result) {
                // 중복 여부에 따라 처리
                if (result == 0) {
                    $('.id-err-text2').css("display","inline-block");
                     $('.id-err-text').css("display", "none");
                } else {
                    $('.id-err-text').css("display","inline-block");
                    $('.id-err-text2').css("display", "none");
                }
            },
            error: function() {
                console.log("오류 발생");
            }
        });
    });
});


// 비밀번호 일치
let pw1;
let pw2;

// 비밀번호 정규식 (특수문자, 8글자 이상)
let regex;

$('.password-box').on('change', function(){
    pw1 = $(this).val();
    regex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
    console.log(pw1);
    if(regex.test(pw1)){
        $('.pw-err-text').css("display","none");
    } else {
        $('.pw-err-text').css("display","inline-block");
    }
});

$('.repassword-box').on('change', function(){
    pw2 = $(this).val();
    console.log(pw2);
    if(pw1 == pw2){
        $('.pw-err-text2').css("display","inline-block");
        $('.pw-err-text1').css("display","none");
    }else {
        $('.pw-err-text1').css("display","inline-block");
        $('.pw-err-text2').css("display","none");
    }
});



// 닉네임 중복검사
$('.nickname-box').on('blur', function (){
    var userNickname = $(".nickname-box").val();

    $.ajax({
        url: "/users/checkNickname",
        type: "GET",
        data: { userNickname : userNickname },
        success: function(result) {
            // 중복 여부에 따라 처리
            if (result == 0) {
                $('.nickName-err-text2').css("display","inline-block");
                $('.nickName-err-text').css("display", "none");
            } else {
                $('.nickName-err-text').css("display","inline-block");
                $('.nickName-err-text2').css("display", "none");
            }
        },
        error: function() {
            console.log("오류 발생");
        }
    });
});


// 이메일 주소 연결
let emailReal;
let email2;
let result;

$('.email-box').on('change', function () {
        let email = $(this).val();
        console.log(email);

        email2 = email;
    });

$('.dropdown-menu li').on('click', function () {
        let text = $(this).text();
        if (text == '직접입력') {
            $('.realEmail').val(email2);
            console.log($('.realEmail').val());
            return;
        }else {
            emailReal = email2 + text;
            $('.realEmail').val(emailReal);
        }

    console.log($('.realEmail').val());
    });


// 회원가입 실패처리


// $(document).ready(function(){
//     if(pw1 != pw2){
//         return;
//     }
// });
