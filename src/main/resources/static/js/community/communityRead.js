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

// 게시물 삭제
$('.btn-remove').on('click',function (){
  let boardNumber = $('.board-num').val();
  window.location.href = '/board/communityRemove?boardNumber' + boardNumber;
});

// 게시물 수정
$('.btn-modify').on('click', function (){
  let boardNumber = $('.board-num').val();
  window.location.href = '/board/communityModify?boardNumber=' + boardNumber;
});


// 목록 버튼
$('.btn-back').on('click', function (){
  window.location.href = '/board/communityList';
});
