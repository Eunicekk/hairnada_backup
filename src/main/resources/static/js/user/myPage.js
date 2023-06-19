function mainPage() {
  $(".main-join").html(getMainJoin);
}

mainPage();

$("#my-modify-btn").on("click", mainPage);

$("#my-tier-btn").on("click", function () {
  $(".main-join").html(getMainTier);
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

function getMainJoin() {
  return `
  <div class="input-box">
            <div class="my-profile">
              <div class="profile">프로필</div>
              <div class="profile-file">
               <ul class="file-wrap">
                <!-- 썸네일 처리 해야함 -->
                <li class="img-list">
                  <input
                    type="file"
                    id="post-image"
                    name="boardFile"
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
                type="text"
                class="password-box"
                placeholder="영문 대소문자 및 숫자 중 2개 이상 조합, 8자리 이상"
              />
            </div>
            <span class="err-text">이전 비밀번호와 동일합니다.</span>
            <div class="input-repassword">
              <div class="repassword">비밀번호 확인</div>
              <input type="text" class="repassword-box" />
            </div>
            <span class="err-text">일치하지 않는 비밀번호 입니다.</span>
            <div class="input-name">
              <div class="name">이름</div>
              <input type="text" class="name-box" />
            </div>
            <div class="input-nickname">
              <div class="nickname">닉네임</div>
              <input type="text" class="nickname-box" />
            </div>
            <span class="err-text">이전 닉네임과 동일합니다.</span>
            <div class="input-gender">
              <div class="gender">성별</div>
              <button type="button" class="female-box">여성</button>
              <button type="button" class="male-box">남성</button>
            </div>
            <div class="input-phone">
              <div class="phone">휴대전화 번호</div>
              <input type="text" class="phone-box" />
            </div>
            <div class="input-email">
              <div class="email">이메일</div>
              <input type="text" class="email-box" />
              <div class="dropdown">
                <button class="dropdown-btn">
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
              readonly
            />
            <button type="button" class="search-address" onclick="sample6_execDaumPostcode()">
              우편변호 검색
            </button>
          </div>
          <input
            type="text"
            id="sample6_address"
            placeholder="주소"
            readonly
          />
          <input type="text" placeholder="상세주소" id="sample6_detailAddress" />
          <input type="text" placeholder="참고항목" id="sample6_extraAddress" readonly />
            <button class="ok-btn">정보수정</button>
            <div class="my-remove">
              회원을 탈퇴하고 싶으신가요?
              <a href="#" class="remove-btn">회원탈퇴</a>
            </div>
          </div>
  `;
}

function getMainTier() {
  return `
  <div class="tier-input-box">
      <div class="now-tier-box">
        <div class="tier">현재등급</div>
        <div class="tier-input">일반회원</div>
      </div>
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
        <li class="img-lists"></li>
        <li class="img-lists"></li>
        <li class="img-lists"></li>
      </ul>
        </div>
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