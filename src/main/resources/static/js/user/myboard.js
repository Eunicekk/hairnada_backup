$(document).ready(function () {
  $(".buttons").click(function () {
    var buttonImg = $(this).find(".like");

    console.log("클릭~~!")
    if (buttonImg.hasClass("active")) {
      buttonImg.removeClass("active");
      buttonImg.css("background-image", "url('/img/heart1.png')");
    } else {
      buttonImg.addClass("active");
      buttonImg.css("background-image", "url('/img/heart2.png')");
    }
  });
});


$(document).ready(function () {
  $(".buttons").click(function () {
    var buttonImg = $(this).find(".like");
    var boardNumber = $(this).find(".like").val();

    if (buttonImg.hasClass("active")) {
      $.ajax({
        url: "/boardLike/subtract",
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
        url: "/boardLike/add",
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
