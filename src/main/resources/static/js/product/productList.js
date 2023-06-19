// 장바구니 클릭시 나타나는 문구
$(".basket").click(function () {
  alert("장바구니에 추가하였습니다!");
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

const buttons = document.querySelectorAll(".category button");

buttons.forEach((button) => {
  button.addEventListener("click", () => {
    buttons.forEach((btn) => {
      btn.classList.remove("active");
      btn.style.color = ""; // 모든 버튼의 텍스트 색상을 기본값으로 재설정합니다.
    });
    button.classList.add("active");
    button.style.color = "#222"; // 클릭한 버튼의 텍스트 색상을 검은색으로 설정합니다.
    button.style.fontWeight = "600";
  });
});

// "전체" 버튼을 초기에 선택한 상태로 설정합니다.
const allButton = document.querySelector(".category button:first-child");
allButton.classList.add("active");
allButton.style.color = "#222";
allButton.style.fontWeight = "600";

// 드롭다운
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

$(".dropdown-menu li").click(function() {
    var selectedItem = $(this).text();
    $('.dropdown-btn').html(selectedItem + `
        <span class="material-symbols-rounded">
          expand_more
        </span>
    `);
});