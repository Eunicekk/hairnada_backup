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

$(".category").on("click", function () {
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
    success : function (result){
      console.log(result);
      $('.hl').html('');
      for (let i = 0; i < result.categoryHair.length; i++){
        $('.hl').append(`
         <ul class="list-ul">
                  <!-- 첫번째 -->
                  <li class="list-li">
                    <a href="/admin/hairRead?hairNumber=${result.categoryHair[i].hairNumber}">
                      <div class="img-list">
                        <img src="${'/upload/' + result.categoryHair[i].hairFileUploadPath + '/th_' +result.categoryHair[i].hairFileUuid + '_' + result.categoryHair[i].hairFileName}" alt="">
                      </div>
                    </a>
                    <div class="hair-title-box">
                      <p class="hair-title">${result.categoryHair[i].hairName}</p>
                    </div>
                  </li>
                </ul>
        `);
      }
      let pageNum = '';
      let pageInfo = result.pageInfo;

      if (result.pageInfo.prev){
        pageNum +=
           `<a>
              <li className="page-num prev">&lt</li>
            </a>`;
      }

      for(let i= pageInfo.startPage; i<= result.pageInfo.endPage; i++){
        if (pageInfo.page == i) {
          pageNum += `<a href="hairList?page=${i}"><li class="page-num active">${i}</li></a>`;
        } else {
          pageNum += `<a href="hairList?page=${i}"><li class="page-num">${i}</li></a>`;
        }
      }

      if(pageInfo.next){
        `
        <a href="#" class="page-a">
                <li class="page-num next">&gt</li>
        </a>
        `;
      }

      $('.page-box').html(pageNum);

    },
    error: function (xhr, status, error) {
      console.log('Error:', error);
    }
  });
});

// 제목 Input칸 저장
let selectName;

$('.select-title').on('change', function (){
  selectName = $(this).val();
})

// 제목으로 검색 AJax
$('.title').on('click', function (){
  let hairName = selectName;
  $.ajax({
    url: "/adminR/hairName",
    type: 'get',
    data: {hairName : hairName},
    success : function (result){
      $('.hl').html('');
      for (let i = 0; i < result.nameHair.length; i++){
        $('.hl').append(`
         <ul class="list-ul">
                  <!-- 첫번째 -->
                  <li class="list-li">
                    <a href="/admin/hairRead?hairNumber=${result.nameHair[i].hairNumber}">
                      <div class="img-list">
                      <img src="${'/upload/' + result.nameHair[i].hairFileUploadPath + '/th_' +result.nameHair[i].hairFileUuid + '_' + result.nameHair[i].hairFileName}" alt="">
                      </div>
                    </a>
                    <div class="hair-title-box">
                      <p class="hair-title">${result.nameHair[i].hairName}</p>
                    </div>
                  </li>
                </ul>
        `);
      }
      let pageNum = '';
      let pageInfo = result.pageInfo;

      if (result.pageInfo.prev){
        pageNum +=
            `<a>
              <li className="page-num prev">&lt</li>
            </a>`;
      }

      for(let i= result.pageInfo.startPage; i<= result.pageInfo.endPage; i++){
        if(result.pageInfo.criteria.page == i){
          pageNum += `<a href="#"><li class="page-num active">${i}</li></a>`;
        }else{
          pageNum += `<a href="#"><li class="page-num">${i}</li></a>`;
        }
      }

      if(result.pageInfo.next){
        `
        <a href="#" class="page-a">
                <li class="page-num next">&gt</li>
              </a>
        `;
      }

      $('.page-box').html(pageNum);

    }
  });
})


