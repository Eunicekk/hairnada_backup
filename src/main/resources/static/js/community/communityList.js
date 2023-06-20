function selectRadio(checkboxId) {
  var checkbox = document.getElementById(checkboxId);
  checkbox.checked = true;
}

$(document).ready(function () {
  $(".category button").click(function () {
    $(".category button").removeClass("active"); // 모든 버튼의 active 클래스 제거
    $(this).addClass("active"); // 클릭한 버튼에 active 클래스 추가
  });
});

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

// 초기에 "전 체" 버튼을 클릭된 상태로 설정
document.getElementById("button0").classList.add("active");

// 클릭된 버튼에 active 클래스 추가 및 다른 버튼의 active 클래스 제거
var buttons = document.getElementsByTagName("categoryBtn");
for (var i = 0; i < buttons.length; i++) {
  buttons[i].addEventListener("click", function () {
    var clickedButton = this;

    // 모든 버튼의 active 클래스 제거
    for (var j = 0; j < buttons.length; j++) {
      buttons[j].classList.remove("active");
    }

    // 클릭된 버튼에 active 클래스 추가
    clickedButton.classList.add("active");
  });
}

// 글쓰기 버튼
$('.write-btn').on('click', function (){
  window.location.href = '/board/communityWrite';
});

