$(document).ready(function () {
  $("#likeButton").click(function () {
    console.log("버튼이 클릭되었습니다.");
    // 추가적인 로직을 이곳에 작성할 수 있습니다.
  });
});

// 버튼 클릭시
$(document).ready(function () {
  $(".buttons").click(function () {
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
      buttonName.textContent = selectedValue === "male" ? "남성" : "여성";
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
    case "egg":
      return "계란형";
    case "long-face":
      return "긴 얼굴형";
      case "round":
        return "둥근형";
    case "heart":
      return "하트형";
    case "angular":
      return "각진형";
    case "inverted-triangle":
      return "역삼각형";
    case "hexagon":
      return "육각형";
    case "quadrangle":
      return "사각형";
    case "egg-chin":
      return "계란턱형";
    default:
      return "";
  }
}

// 머리길이 라디오 버튼에 따라 텍스트 반환
function getHairButtonText(value) {
  switch (value) {
    case "short":
      return "숏";
    case "medium":
      return "미디엄";
    case "long":
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
    if (this.value === "male") {
      genderImageMale.style.display = "inline-block";
      genderImageFemale.style.display = "none";
    } else if (this.value === "female") {
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
