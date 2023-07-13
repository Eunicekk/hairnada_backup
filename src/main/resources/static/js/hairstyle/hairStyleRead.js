$(document).ready(function () {
  $(".buttons").click(function () {
    var buttonImg = $(this).find(".likeBtn");

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
  $(".button").click(function () {
    var buttonImg = $(this).find(".like");
    var hairNumber = $(this).find(".like").val();

    if (buttonImg.hasClass("active")) {
      $.ajax({
        url: "/hairLike/subtract",
        type: "DELETE",
        contentType: "application/json",
        data: JSON.stringify({ hairNumber: hairNumber }),
        success: function(){
          console.log("빼기 성공");
        }
      });

      buttonImg.removeClass("active");
      buttonImg.css("background-image", "url('/img/heart1.png')");
    } else {
      $.ajax({
        url: "/hairLike/add",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({ hairNumber: hairNumber }),
        success: function(){
          console.log("더하기 성공");
        }
      });

      buttonImg.addClass("active");
      buttonImg.css("background-image", "url('/img/heart2.png')");
    }
  });
});

// 사진 눌렀을 때 모달 띄우면서 확대

$(".img-list-thumbnail").on("click", function () {
  let viewImg = $(this).find('img').attr("src");
  $(".modal").css("display", "flex");
  // $(".view-img").attr("src", viewImg);

  $(".view-img2").css("width", '600px');
  $(".view-img2").css("height", '600px');
  $(".view-img2").css("background-image", `url(${viewImg})`);
  console.log(viewImg)
});

$(".background").on("click", function () {
  $(".modal").css("display", "none");
});

$(".view-img").on("click", function () {
  console.log($(this).attr("background-image"));
});
