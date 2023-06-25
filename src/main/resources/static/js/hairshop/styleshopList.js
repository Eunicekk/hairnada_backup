// 버튼 클릭시 하트 변경
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

// 등록하기 버튼 누르면 페이지 이동
$('.add-post').on('click', function (){
  window.location.href = '/hairshop/write';
})