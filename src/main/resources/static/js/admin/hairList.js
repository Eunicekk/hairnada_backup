$(document).ready(function () {
  $(".buttons").click(function () {
    var buttonImg = $(this).find(".like");

    if (buttonImg.hasClass("active")) {
      buttonImg.removeClass("active");
      buttonImg.css("background-image", "url('../LogoImg/beforelike.png')");
    } else {
      buttonImg.addClass("active");
      buttonImg.css("background-image", "url('../LogoImg/like.png')");
    }
  });
});

// select option 저장하기
let gender;
let hairLength;
let faceShape;

$(".gender").on("change", function () {
  gender = $(this).val();
});

$(".hair-length").on("change", function () {
  length = $(this).val();
});

$(".face-shape").on("change", function () {
  faceShape = $(this).val();
});

$(".search").on("click", function () {
  console.log("gender : " + gender);
  console.log("length : " + length);
  console.log("face-shape : " + faceShape);
});
