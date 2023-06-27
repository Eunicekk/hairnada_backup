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
  hairLength = $(this).val();
});

$(".face-shape").on("change", function () {
  faceShape = $(this).val();
});

$(".search").on("click", function () {
  let hairGender = gender;
  let lengthNumber = hairLength;
  let shapeNumber = faceShape;

  console.log(hairGender, lengthNumber, shapeNumber);

  // 카테고리로 헤어스타일 조회
  $.ajax({
    url : "/adminR/hairList",
    type : "get",
    data : {
      hairGender : hairGender,
      lengthNumber : lengthNumber,
      shapeNumber : shapeNumber
    },
    success : function (categoryHair){
      $('.hl').html('');
      for (let i = 0; i < categoryHair.length; i++){
        console.log('Received categoryHair:',categoryHair);
        $('.hl').append(`
         <ul class="list-ul">
                  <!-- 첫번째 -->
                  <li class="list-li">
                    <a href="">
                      <div class="img-list">
                        <img src="https://img1.daumcdn.net/thumb/C360x360/?fname=https://mud-kage.kakao.com/dn/tiTz0/btsjboVScnc/36eDc0R0JCIeBLE6uPouDk/img_1080.jpg&scode=purple" alt="">
                      </div>
                    </a>
                    <div class="hair-title-box">
                      <p class="hair-title">${categoryHair[i].hairName}</p>
                    </div>
                  </li>
                </ul>
        `);
      }
    },
    error: function (xhr, status, error) {
      console.log('Error:', error);
    }
  });
});

let selectName;

$('.select-title').on('change', function (){
  selectName = $(this).val();
})


$('.title').on('click', function (){
  let hairName = selectName;
  $.ajax({
    url: "/adminR/hairName",
    type: 'get',
    data: {hairName : hairName},
    success : function (nameHair){
      $('.hl').html('');
      for (let i = 0; i < nameHair.length; i++){
        console.log('Received nameHair:',nameHair);
        $('.hl').append(`
         <ul class="list-ul">
                  <!-- 첫번째 -->
                  <li class="list-li">
                    <a href="">
                      <div class="img-list">
                        <img src="https://img1.daumcdn.net/thumb/C360x360/?fname=https://mud-kage.kakao.com/dn/tiTz0/btsjboVScnc/36eDc0R0JCIeBLE6uPouDk/img_1080.jpg&scode=purple" alt="">
                      </div>
                    </a>
                    <div class="hair-title-box">
                      <p class="hair-title">${nameHair[i].hairName}</p>
                    </div>
                  </li>
                </ul>
        `);
      }

    }
  });
})


