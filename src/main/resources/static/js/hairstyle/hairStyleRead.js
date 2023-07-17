
$(document).ready(function () {
  $(".buttons").click(function () {
    var buttonImg = $(this).find(".likeBtn");
    var hairNumber = $(this).find(".likeBtn").val();

    if (buttonImg.hasClass("active")) {
      $.ajax({
        url: "/hairLike/subtract",
        type: "DELETE",
        contentType: "application/json",
        data: JSON.stringify({ hairNumber: hairNumber }),
        success: function(){
          let likeNumber = parseInt($(".like-cnt").text());
          let test = likeNumber - 1;

          $(".like-cnt").text(test)
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
          let likeNumber = parseInt($(".like-cnt").text());
          let test = likeNumber + 1;

          $(".like-cnt").text(test)
          console.log("더하기 성공");
        }
      });

      buttonImg.addClass("active");
      buttonImg.css("background-image", "url('/img/heart2.png')");
    }
  });
});

// 사진 눌렀을 때 모달 띄우면서 확대

$(".file-wrap").on("click", '.img-list-thumbnail',function () {
  console.log("클릭했다")
  let viewImg = $(this).attr("src");
  $(".modal").css("display", "flex");
  $(".view-img2").attr("src", viewImg);
});

$(".background").on("click", function () {
  $(".modal").css("display", "none");
});

$(".view-img2").on("click", function () {
  console.log($(this).attr("background-image"));
});



let hairNum = $('.hairNumber').val();

function displayAjax(){
  let hairNumber = hairNum;

  $.ajax({
    url : '/adminFile/hairImgList',
    type : 'get',
    data : {hairNumber : hairNumber},
    success : function(hairImgList){
      let text = '';
      $('.file-wrap').html('');
      hairImgList.forEach(file => {
        let fileName = file.hairFileUploadPath + '/' + file.hairFileUuid + '_' + file.hairFileName;
        text += `
                    <li>
                      <img  class="img-list" src="/adminFile/display?fileName=${fileName}" data-number="${file.hairFileNumber}" data-name="${fileName}" />
                    </li>  
`;
      });

      $('.file-wrap').html(text);
    }
  });
}

displayAjax();