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

    if (buttonImg.hasClass("active")) {
      buttonImg.removeClass("active");
      buttonImg.css("background-image", "url('/img/heart1.png')");
    } else {
      buttonImg.addClass("active");
      buttonImg.css("background-image", "url('/img/heart2.png')");
    }
  });
});

// 사진 눌렀을 때 모달 띄우면서 확대

$(".img-list").on("click", function () {
  var backgroundImageUrl = $(this).css("background-image");
  backgroundImageUrl = backgroundImageUrl
    .replace(/^url\(["']?/, "")
    .replace(/["']?\)$/, "");
  console.log(backgroundImageUrl);
  $(".modal").css("display", "flex");
  $(".view-img").css("background-image", "url('" + backgroundImageUrl + "')");
});

$(".background").on("click", function () {
  $(".modal").css("display", "none");
});

$(".view-img").on("click", function () {
  console.log($(this).attr("background-image"));
});
