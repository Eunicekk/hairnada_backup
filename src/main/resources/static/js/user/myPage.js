function mainPage() {

    dropDown();
    userModify();
    checkNickname();
    box();
    getUser();
    // 성별 체크 css
    $(".main-join").on("click",".female-box", function () {
        $(".female-box").css("background-color", "#e0e0e0");
        $(".male-box").css("background-color", "#FFF");
    });

    $(".main-join").on("click",".male-box", function () {
        $(".male-box").css("background-color", "#e0e0e0");
        $(".female-box").css("background-color", "#FFF");
    });
  //   userUpdate();
}


mainPage();

$("#my-modify-btn").on("click", mainPage);

$("#my-tier-btn").on("click", function () {
  $(".main-join").html(getMainTier);
    tierCheck();
});

$(".main-join").on("click", ".ok-btn", function () {
  console.log("click!!!!!!!");
});

// $("#profile-upload").on("click", function () {
//   let files = this.files;

//   $("#profile-upload").append(
//     ` <img src="" alt="" id="profile-preview" class="profile-img"/>`
//   );
//   console.log(files[0]);
// });

// let users = $('.user').val();
//
// console.log(users);
//
// var dtoArray = [];
// USER_NUMBER, USER_NAME, USER_NICKNAME, USER_GENDER, USER_PHONE_NUMBER, USER_EMAIL, USER_ADDRESS, USER_ADDRESS_DETAIL
// var dto = {}


function getUser(){
    $.ajax({
       url:"/myPages/userInfo",
       type: "GET",
       dataType: "json",
       success: function (result) {
           console.log(result);
           let infoModifyPage = getMainJoin(result);

           $(".main-join").html(infoModifyPage);

       }
    });
}




function getMainJoin(users) {
  return `
<form class="signup-form" action="/user/myPage" method="post" enctype="multipart/form-data">
  <div class="input-box">
            <div class="my-profile">
              <div class="profile">프로필</div>
              <div class="profile-file">
               <ul class="file-wrap">
                <!-- 썸네일 처리 해야함 -->
                <li class="img-list" style="background-image: url('/userFile/display?fileName=${users.userFileUploadPath+'/th_'+users.userFileUuid + '_' + users.userFileName}')">
                  <input
                    type="file"
                    id="post-image"
                    name="userFile"
                    accept="image/*"
                  />
                </li>
              </ul>
              </div>
              </div>
            <div class="input-id">
              
            </div>
           <div class="input-password">
              <div class="password">비밀번호</div>
              <input
                type="password"
                class="password-box"
                name="userPassword"
                placeholder="영문 대소문자 및 숫자 중 2개 이상 조합, 8자리 이상"
                autocomplete="off"
                required
              />
            </div>
            <span class="pw-err-text"
              >영문 대소문자 및 숫자 중 2개 이상 조합, 8자리 이상
              작성해주세요.</span
            >
            <div class="input-repassword">
              <div class="repassword">비밀번호 확인</div>
              <input type="password" class="repassword-box" required autocomplete="off"/>
            </div>
            <span class="pw-err-text1">일치하지 않는 비밀번호 입니다.</span>
            <span class="pw-err-text2">일치하는 비밀번호 입니다.</span>
            <div class="input-name">
              <div class="name">이름</div>
              <input type="text" class="name-box" name="userName" value="${users.userName}" required autocomplete="off"/>
            </div>
            <div class="input-nickname">
              <div class="nickname">닉네임</div>
              <input type="text" class="nickname-box" name="userNickname" value="${users.userNickname}" required autocomplete="off"/>
            </div>
            <span class="nickName-err-text">중복된 닉네임 입니다.</span>
            <span class="nickName-err-text2">사용 가능한 닉네임 입니다.</span>
            <div class="input-gender">
              <div class="gender">성별</div>
              <label for="gender-f">
                <div type="button" class="female-box" ${users.userGender.trim() == 'F' ? 'style="background-color: #e0e0e0"' : ''}>여성</div>
              </label>
              <label for="gender-m">
                <div type="button" class="male-box check-background" ${users.userGender.trim() == 'M' ? 'style="background-color: #e0e0e0"' : ''}>남성</div>
              </label>
              <input type="radio" name="userGender" id="gender-f"  value="F" ${users.userGender.trim() == 'F' ? 'checked' : ''} />
              <input type="radio" name="userGender" id="gender-m" value="M" ${users.userGender.trim() == 'M' ? 'checked' : ''}/>
            </div>
            <div class="input-phone">
              <div class="phone">휴대전화 번호</div>
              <input type="text" class="phone-box" name="userPhoneNumber" value="${users.userPhoneNumber}" required autocomplete="off"/>
            </div>
            <div class="input-email">
              <div class="email">이메일</div>
              <input type="hidden" name="userEmail" class="realEmail" value="${users.userEmail}">
              <input type="text" class="email-box" value="${users.userEmail}" required autocomplete="off"/>

              <div class="dropdown">
                <button class="dropdown-btn" type="button">
                  직접입력
                  <span class="material-symbols-rounded">
                    expand_more
                </span>
                </button>
                <ul class="dropdown-menu">
                  <li>직접입력</li>
                  <li>@naver.com</li>
                  <li>@hanmail.net</li>
                  <li>@gmail.com</li>
                  <li>@nate.com</li>
                </ul>
              </div>
            </div>
            <div class="email-text">
              ※ 아이디 비밀번호 찾기에 활용 되므로 정확하게 입력해 주세요.
            </div>
            <div class="input-address">
              <div class="address">주소</div>
              <input
                type="text"
                id="sample6_postcode"
                placeholder="우편번호"
                value="${users.userPostCode}"
                name="userPostCode"
                readonly
                required
              />
              <button type="button" class="search-address" onclick="sample6_execDaumPostcode();">
                우편변호 검색
              </button>
            </div>
            <input
              type="text"
              id="sample6_address"
              placeholder="주소"
              name="userAddress"
              readonly
              value="${users.userAddress}"
            />
            <input type="text" placeholder="상세주소" value="${users.userAddressDetail}" name="userAddressDetail" autocomplete="off" id="sample6_detailAddress" />
            <input type="text" placeholder="참고항목" id="sample6_extraAddress" name="userReference" value="${users.userReference}" readonly />
            <button type="submit" class="ok-btn">정보수정</button>
          </div>
  </form>
  `;
}

function getMainTier() {
  return `
 <div class="tier-input-box">
      
      <div class="certificate-img-box">
        <div class="certiflcate">자격증(면허증)</div>
        <div class="certiflcate-img">
        <ul class="file-wrap tier__file-wrap">
        <!-- 썸네일 처리 해야함 -->
        <input
          type="file"
          id="post-image2"
          name="boardFile"
          accept="image/*"
          multiple
        />
        <li class="img-lists"></li>
       
      </ul>
        </div>
      </div>
      <div class="now-tier-box">
        <div class="now-tier">현재등급</div>
        <div class="now-tier-status">일반회원</div>
      </div>
      <div class="now-tier-box">
        <div class="tier">신청등급</div>
        <label for="normal">
          <div class="normal-tier">일반회원</div>
        </label>

        <label for="style">
          <div class="style-tier">스타일 전문가</div>
        </label>

        <label for="care">
          <div class="care-tier">케어 전문가</div>
        </label>

        <input type="radio" name="check-tier" id="normal" value="1" />
        <input type="radio" name="check-tier" id="style" value="2"/>
        <input type="radio" name="check-tier" id="care" value="3"/>
      </div>
      <div class="explanation-box">
        <div class="explanation">제목</div>
        <input
          type="text"
          class="explanation1"
          placeholder="글 제목을 입력해주세요"
        />
        <textarea type="text" class="explanation2"></textarea>
      </div>
      <div class="app-btn">
        <button class="cancel" type="button">취소</button>
        <button class="application" type="button">신청하기</button>
      </div>
    </div>
  `;
}

let modifyBtn = document.getElementById("my-modify-btn");
let tierBtn = document.getElementById("my-tier-btn");

modifyBtn.addEventListener("click", function () {
  modifyBtn.querySelector(".active-banner").classList.add("selected");
  tierBtn.querySelector(".active-banner").classList.remove("selected");
});

tierBtn.addEventListener("click", function () {
  modifyBtn.querySelector(".active-banner").classList.remove("selected");
  tierBtn.querySelector(".active-banner").classList.add("selected");
});

// 정보수정 파일처리

// console.log($input);

$(".main-join").on("change", "#post-image", function (event) {
  let $input = $("#post-image");
  let $imgList = $(".img-lists");
  let file = event.target.files[0]; // 파일 객체를 얻음
  console.log(file);
  console.log("aaaaaaaaaaaaaaa");
  appendImg(file);
});

function appendImg(file) {
  let $imgList = $(".img-list");
  let src = URL.createObjectURL(file);

  $imgList
    .css("background-image", `url(${src})`)
    .css("background-size", "contain")
    .data("name", `${file.name}`);

  $imgList.addClass("x-box");
}

// 등급 파일처리





// 드롭다운 박스
function dropDown() {
    $('.main-join').ready(function() {
        $('.main-join').on('click', '.dropdown', function() {
            $(this).find('.dropdown-menu').toggle();
        });

        $('.main-join').on('click', function(e) {
            var target = e.target;
            if (!$(target).is('.dropdown') && !$(target).parents().is('.dropdown')) {
                $('.dropdown-menu').hide();
            }
        });
    });

    $('.main-join').on('click', '.dropdown-menu li', function(){
        let $input = $('.dropdown-btn');
        let text = $(this).text();
        $input.html(text + `
    <span class="material-symbols-rounded">
    expand_more
    </span>
    `);
    });
}







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



function userModify() {
// 비밀번호 일치
    let pw1;
    let pw2;

// 비밀번호 정규식 (특수문자, 8글자 이상)
    let regex;


    $('.main-join').on('change', '.password-box', function () {
        pw1 = $(this).val();
        regex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
        console.log(pw1);
        if (regex.test(pw1)) {
            $('.pw-err-text').css("display", "none");
        } else {
            $('.pw-err-text').css("display", "inline-block");
        }
    });

    $('.main-join').on('change', '.repassword-box', function () {
        pw2 = $(this).val();
        console.log(pw2);
        if (pw1 == pw2) {
            $('.pw-err-text2').css("display", "inline-block");
            $('.pw-err-text1').css("display", "none");
        } else {
            $('.pw-err-text1').css("display", "inline-block");
            $('.pw-err-text2').css("display", "none");
        }
    });





// 이메일 주소 연결
    let emailReal;
    let email2;
    let result;

    $('.main-join').on('change','.email-box', function () {
        let email = $(this).val();
        console.log(email);

        email2 = email;
    });

    $('.main-join').on('click', '.dropdown-menu li', function () {
        let text = $(this).text();
        if (text == '직접입력') {
            $('.realEmail').val(email2);
            console.log($('.realEmail').val());
            return;
        } else {
            emailReal = email2 + text;
            $('.realEmail').val(emailReal);
        }

        console.log($('.realEmail').val());
    });
}

function box(){
$(".female-box").on("click", function () {
    $(".female-box").css("background-color", "#e0e0e0");
    $(".male-box").css("background-color", "#FFF");
});

$(".male-box").on("click", function () {
    $(".male-box").css("background-color", "#e0e0e0");
    $(".female-box").css("background-color", "#FFF");
});
}

// 닉네임 중복검사
function checkNickname() {
    $('.main-join').on('blur', '.nickname-box', function () {
        var userNickname = $(".nickname-box").val();

        $.ajax({
            url: "/users/checkNickname",
            type: "GET",
            data: {userNickname: userNickname},
            success: function (result) {
                // 중복 여부에 따라 처리
                if (result == 0) {
                    $('.nickName-err-text2').css("display", "inline-block");
                    $('.nickName-err-text').css("display", "none");
                } else {
                    $('.nickName-err-text').css("display", "inline-block");
                    $('.nickName-err-text2').css("display", "none");
                }
            },
            error: function () {
                console.log("오류 발생");
            }
        });
    });
}

// 등급 체크박스
function tierCheck() {
    $(".normal-tier").on("click", function () {
        $(".normal-tier").css("background-color", "#e0e0e0");
        $(".style-tier").css("background-color", "#FFF");
        $(".care-tier").css("background-color", "#FFF");
    });

    $(".style-tier").on("click", function () {
        $(".style-tier").css("background-color", "#e0e0e0");
        $(".care-tier").css("background-color", "#FFF");
        $(".normal-tier").css("background-color", "#FFF");
    });

    $(".care-tier").on("click", function () {
        $(".care-tier").css("background-color", "#e0e0e0");
        $(".normal-tier").css("background-color", "#FFF");
        $(".style-tier").css("background-color", "#FFF");
    });
}


