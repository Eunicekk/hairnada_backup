

$(document).ready(function () {
  $(".button").click(function () {
    $(".button").removeClass("active");
    $(this).addClass("active");
  });
});



$(document).ready(function () {

  $.ajax({
    url: "/likes/check",
    type: "GET",
    contentType: "application/json",
    success: function (likeList) {
      console.log(likeList);

      // 좋아요 버튼들에 대한 처리
      $(".like").each(function () {
        var buttonImg = $(this);
        var boardNumber = buttonImg.val();

        if (likeList.includes(Number(boardNumber))) {
          buttonImg.addClass("active");
          buttonImg.css("background-image", "url('/img/heart2.png')");
        } else {
          buttonImg.removeClass("active");
          buttonImg.css("background-image", "url('/img/heart1.png')");
        }
      });
    }
  });



  $(".like").on('click', function () {
    console.log("like 버튼 클릭 !!!!");
    var buttonImg = $(this);
    var boardNumber = $(this).val();
    console.log(buttonImg);
    console.log(boardNumber);

    if (buttonImg.hasClass("active")) {
      $.ajax({
        url: "/likes/delete",
        type: "DELETE",
        contentType: "application/json",
        data: JSON.stringify({ boardNumber: boardNumber }),
        success: function(){
          console.log("빼기 성공");
        }
      });

      buttonImg.removeClass("active");
      buttonImg.css("background-image", "url('/img/heart1.png')");
    } else {
      $.ajax({
        url: "/likes/add",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({ boardNumber: boardNumber }),
        success: function(){
          console.log("더하기 성공");
        }
      });

      buttonImg.addClass("active");
      buttonImg.css("background-image", "url('/img/heart2.png')");
    }
  });
});


$('.my-post').css("color", "#FFFFFF");
$('.my-post').css("background-color", "#222");