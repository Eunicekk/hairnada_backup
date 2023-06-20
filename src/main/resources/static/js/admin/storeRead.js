// 사진 눌렀을 때 모달 띄우면서 확대

$(".img-list").on("click", function () {
  let viewImg = $(this).attr("src");
  $(".modal").css("display", "flex");
  $(".view-img").attr("src", viewImg);
});

$(".background").on("click", function () {
  $(".modal").css("display", "none");
});

$(".view-img").on("click", function () {
  console.log($(this).attr("background-image"));
});
