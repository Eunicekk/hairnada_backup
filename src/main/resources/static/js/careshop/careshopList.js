// 버튼 클릭시 하트 변경
$(document).ready(function () {

  $.ajax({
    url: "/careshopLike/check",
    type: "GET",
    contentType: "application/json",
    success: function(likeList) {
      $('.ListLi').each(function() {
        var hiddenNumber = $(this).find('.hidden-number').val();
        var $likeButton = $(this).find('.like');
        if (likeList.includes(Number(hiddenNumber))) {
          $likeButton.addClass("active");
          $likeButton.css("background-image", "url('/img/heart2.png')");
        }
      });
    }
  });

  $(".buttons").click(function () {
    var buttonImg = $(this).find(".like");
    var careShopNumber = $(this).find(".like").val();

    if (buttonImg.hasClass("active")) {
      $.ajax({
        url: "/careshopLike/subtract",
        type: "DELETE",
        contentType: "application/json",
        data: JSON.stringify({ careShopNumber: careShopNumber }),
        success: function(){
          console.log("빼기 성공");
        }
      });

      buttonImg.removeClass("active");
      buttonImg.css("background-image", "url('/img/heart1.png')");
    } else {
      $.ajax({
        url: "/careshopLike/add",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({ careShopNumber: careShopNumber }),
        success: function(){
          console.log("더하기 성공");
        }
      });

      buttonImg.addClass("active");
      buttonImg.css("background-image", "url('/img/heart2.png')");
    }
  });
});

// 등록하기 버튼 누르면 페이지 이동
$('.add-post').on('click', function (){
  window.location.href = '/careshop/write';
})