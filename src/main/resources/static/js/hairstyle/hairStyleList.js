$(document).ready(function () {
  $("#likeButton").click(function () {
    console.log("버튼이 클릭되었습니다.");
    // 추가적인 로직을 이곳에 작성할 수 있습니다.
  });
});

// 버튼 클릭시
$(document).ready(function () {
  $(".ListUl").on('click','.buttons',function () {
    var buttonImg = $(this).find(".like");

    if (buttonImg.hasClass("active")) {
      buttonImg.removeClass("active");
      buttonImg.css("background-image", "url('/img/heart1.png')");
    } else {
      buttonImg.addClass("active");
      buttonImg.css("background-image", "url('/img/heart2.png')");
    }
  });
});

// 모달 테스트

// 모달 요소 가져오기
var genderModal = document.getElementById("genderModal");
var faceModal = document.getElementById("faceModal");
var hairModal = document.getElementById("hairModal");

// 모달을 여는 버튼 가져오기
var modalBtn1 = document.getElementById("modalBtn1");
var modalBtn2 = document.getElementById("modalBtn2");
var modalBtn3 = document.getElementById("modalBtn3");

// 닫기 버튼 가져오기
var genderCloseBtn = document.getElementsByClassName("close")[0];
var faceCloseBtn = document.getElementsByClassName("close")[1];
var hairCloseBtn = document.getElementsByClassName("close")[2];

// 성별 텍스트 요소 가져오기
var genderText = document.getElementById("genderText");
var faceText = document.getElementById("faceText");
var hairText = document.getElementById("hairText");

// 버튼을 클릭했을 때 모달 열기
modalBtn1.addEventListener("click", function () {
  genderModal.style.display = "block";
});

modalBtn2.addEventListener("click", function () {
  faceModal.style.display = "block";
});

modalBtn3.addEventListener("click", function () {
  hairModal.style.display = "block";
});

// 성별 닫기 버튼을 클릭했을 때 모달 닫기
genderCloseBtn.addEventListener("click", function () {
  genderModal.style.display = "none";
});

// 얼굴형 닫기 버튼을 클릭했을 때 모달 닫기
faceCloseBtn.addEventListener("click", function () {
  faceModal.style.display = "none";
});

// 머리길이 닫기 버튼을 클릭했을 때 모달 닫기
hairCloseBtn.addEventListener("click", function () {
  hairModal.style.display = "none";
});

// 성별 라디오 버튼을 선택했을 때 버튼 텍스트 업데이트 및 모달 닫기
var genderRadioButtons = genderModal.querySelectorAll('input[name="gender"]');
for (var i = 0; i < genderRadioButtons.length; i++) {
  genderRadioButtons[i].addEventListener("change", function () {
    if (this.checked) {
      var selectedValue = this.value;
      var buttonName = genderModal.parentElement.querySelector(".gender-name");
      buttonName.textContent = selectedValue === "M" ? "남성" : "여성";
      genderModal.style.display = "none";
    }
  });
}

// 얼굴형 라디오 버튼을 선택했을 때 버튼 텍스트 업데이트 및 모달 닫기
var faceRadioButtons = faceModal.querySelectorAll('input[name="face"]');
for (var i = 0; i < faceRadioButtons.length; i++) {
  faceRadioButtons[i].addEventListener("change", function () {
    if (this.checked) {
      var selectedValue = this.value;
      var buttonName = faceModal.parentElement.querySelector(".face-name");
      buttonName.textContent = getFaceButtonText(selectedValue);
      faceModal.style.display = "none";
    }
  });
}

// 머리길이 닫기 버튼 가져오기
var hairCloseBtn = document.getElementsByClassName("close")[2];

// 머리길이 라디오 버튼을 선택했을 때 버튼 텍스트 업데이트 및 모달 닫기
var hairRadioButtons = hairModal.querySelectorAll('input[name="hair"]');
for (var i = 0; i < hairRadioButtons.length; i++) {
  hairRadioButtons[i].addEventListener("change", function () {
    if (this.checked) {
      var selectedValue = this.value;
      var buttonName = hairModal.parentElement.querySelector(".hair-name");
      buttonName.textContent = getHairButtonText(selectedValue);
      hairModal.style.display = "none";
    }
  });
}

// 얼굴형 라디오 버튼에 따라 텍스트 반환
function getFaceButtonText(value) {
  switch (value) {
    case "1":
      return "계란형";
    case "2":
      return "긴 얼굴형";
      case "3":
        return "둥근형";
    case "4":
      return "역삼각형";
    case "5":
      return "육각형";
    case "6":
      return "사각형";
    default:
      return "";
  }
}

// 머리길이 라디오 버튼에 따라 텍스트 반환
function getHairButtonText(value) {
  switch (value) {
    case "1":
      return "숏";
    case "2":
      return "미디엄";
    case "3":
      return "롱";
    default:
      return "";
  }
}

// 성별 라디오 버튼을 선택했을 때 이미지 표시
var genderRadioButtons = genderModal.querySelectorAll('input[name="gender"]');
for (var i = 0; i < genderRadioButtons.length; i++) {
  genderRadioButtons[i].addEventListener("change", function () {
    var genderImageMale = document.getElementById("male-image");
    var genderImageFemale = document.getElementById("female-image");
    if (this.value === "M") {
      genderImageMale.style.display = "inline-block";
      genderImageFemale.style.display = "none";
    } else if (this.value === "F") {
      genderImageMale.style.display = "none";
      genderImageFemale.style.display = "inline-block";
    }
  });
}

// 얼굴형 라디오 버튼을 선택했을 때 이미지 표시
var faceRadioButtons = faceModal.querySelectorAll('input[name="face"]');

for (var i = 0; i < faceRadioButtons.length; i++) {
  faceRadioButtons[i].addEventListener("change", function () {
    var selectedFace = document.querySelector(
      'input[name="face"]:checked'
    ).value;
    var faceImages = faceModal.querySelectorAll(".face-image");
    for (var j = 0; j < faceImages.length; j++) {
      var faceImage = faceImages[j];
      if (faceImage.classList.contains("face-image-" + selectedFace)) {
        faceImage.style.display = "inline-block";
      } else {
        faceImage.style.display = "none";
      }
    }
  });
}

// 머리 길이 라디오 버튼을 선택했을 때 이미지 표시
var hairRadioButtons = hairModal.querySelectorAll('input[name="hair"]');

for (var i = 0; i < hairRadioButtons.length; i++) {
  hairRadioButtons[i].addEventListener("change", function () {
    var selectedHair = document.querySelector(
      'input[name="hair"]:checked'
    ).value;
    var hairImages = hairModal.querySelectorAll(".hair-image");
    for (var j = 0; j < hairImages.length; j++) {
      var hairImage = hairImages[j];
      if (hairImage.classList.contains("hair-image-" + selectedHair)) {
        hairImage.style.display = "inline-block";
      } else {
        hairImage.style.display = "none";
      }
    }
  });
}


let obj ={};

// 검색 버튼 클릭 이벤트
$('.search-btn').on('click', function (){
  obj = {
    hairGender: $('.gender:checked').val(),
    shapeNumber: $('.face:checked').val(),
    lengthNumber: $('.hair:checked').val(),
    keyword : $('.select-name').val()
  };
  searchModule(1, obj, showSearchResult, paging);
});


// 카테고리 체크박스 change이벤트
$('input[type=radio]').on('change', function (){
  obj = {
    hairGender: $('.gender:checked').val(),
    shapeNumber: $('.face:checked').val(),
    lengthNumber: $('.hair:checked').val(),
    keyword : $('.select-name').val()
  };

  searchModule(1, obj, showSearchResult, paging);
});

// 검색 모듈(비동기)
function searchModule(page, obj, callback, paging){
  $.ajax({
    url : `/hairStyleR/hairSearchList/${page}`,
    type : 'get',
    data : obj,
    dataType : 'json',
    success : function (result){
      if(callback){
        callback(result);
        paging(result);
      }
    },
    error : function (a,b,c){
      console.error(c);
    }
  });
}

// 검색 결과 화면에 뿌리는 함수
function showSearchResult(result){
  console.log(result);

  let hairList = result.hairList;

  $('.ListUl').html('');
  for (let i =0; i < hairList.length; i++){
    $('.ListUl').append(`
            <li class="ListLi">
              <a href="">
                <div class="img-list">
                  <div class="main-img">
                    <img src="https://img1.daumcdn.net/thumb/C360x360/?fname=https://mud-kage.kakao.com/dn/tiTz0/btsjboVScnc/36eDc0R0JCIeBLE6uPouDk/img_1080.jpg&scode=purple" alt="헤어스타일">
                  </div>
                </div>
              </a>
              <div class="hairTitle">
                <p class="product-title">${hairList[i].hairName}</p>
                <div class="buttons">
                  <button type="button" class="like">하트</button>
                </div>
              </div>
            </li>
        `);
  }
}

// 페이징 처리
function paging(result){
  let pageInfo = result.page;
  let text = '';

  text += `
    ${pageInfo.prev ? 
        '<a href="javascript:void(0)" class="prev" onclick="searchModule(' + (pageInfo.startPage-1) + ',obj,showSearchResult,paging)"><li>&laquo;</li></a>'
      :''}
  `;

  for(let i=pageInfo.startPage; i<=pageInfo.endPage; i++){
    text +=`
      <a href="javascript:void(0)" onclick="searchModule(${i},obj,showSearchResult,paging)">
      ${pageInfo.criteria.page == i ?
        '<li class="active">' + i + '</li>'
        :
        '<li>' + i +'</li>'
      }
      </a>
    `;
  }

  text += `
    ${pageInfo.next ?
      '<a href="javascript:void(0)" class="next" onclick="searchModule(' + (pageInfo.endPage+1) + ',obj,showSearchResult,paging)"><li>&raquo;</li></a>'
      :''}
  `;

  $('.pagination > ul').html(text);
}

