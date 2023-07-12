
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
// 페이지 저장
let pageVal;

$('.page-box').on('click','.page-num', function(e) {
  pageVal = $(this).text();
});

// 제목 Input칸 저장
let selectName;

$('.select-title').on('change', function (){
  selectName = $(this).val();
})

// 카테고리로 헤어스타일 조회 AJAX
$(".title").on("click", function () {
  pageVal = 1;
  cateList();
});

function cateList(){
  let hairGender = gender;
  let lengthNumber = hairLength;
  let shapeNumber = faceShape;
  let hairName = selectName;
  let page = pageVal;

  $.ajax({
    url : "/adminR/hairList",
    type : "get",
    data : {
      hairGender : hairGender,
      lengthNumber : lengthNumber,
      shapeNumber : shapeNumber,
      hairName : hairName,
      page: page
    },
    success : function (result){
      $('.hl').html(generateHairList(result.categoryHair));

      let pageInfo = result.pageInfo;
      let pageHtml = generatePageLinks(pageInfo);

      $('.page-box').html(pageHtml);
    },
    error: function (xhr, status, error) {
      console.log('Error:', error);
    }
  });
}

// 카테고리로 헤어 검색 함수
function generateHairList(categoryHair) {
let hairList = '';

for (let i = 0; i < categoryHair.length; i++) {
  hairList += `
      <ul class="list-ul">
        <li class="list-li">
          <a href="/admin/hairRead?hairNumber=${categoryHair[i].hairNumber}">
            <div class="img-list">
              <img src="${'/upload/' + categoryHair[i].hairFileUploadPath + '/th_' + categoryHair[i].hairFileUuid + '_' + categoryHair[i].hairFileName}" alt="">
            </div>
          </a>
          <div class="hair-title-box">
            <p class="hair-title">${categoryHair[i].hairName}</p>
          </div>
        </li>
      </ul>
    `;
}

return hairList;
}

// 페이징 처리 함수
function generatePageLinks(pageInfo) {
  let pageNum = '';

  if (pageInfo.prev) {
    pageNum += `<a href="" class="cate-a" data-num="${pageInfo.startPage -1}"><li class="page-num prev">&lt;</li></a>`;
  }

  for (let i = pageInfo.startPage; i <= pageInfo.endPage; i++) {
    if (pageInfo.criteria.page == i) {
      pageNum += `<a href="" class="page-a cate-a" data-num="${i}"><li class="page-num active">${i}</li></a>`;
    } else {
      pageNum += `<a href="" class="page-a cate-a" data-num="${i}"><li class="page-num">${i}</li></a>`;
    }
  }

  if (pageInfo.next) {
    pageNum += `<a href="" class="cate-a" data-num="${pageInfo.endPage+1}"><li class="page-num next">&gt;</li></a>`;
  }

  return pageNum;
}

$('.page-box').on('click', '.cate-a', function (e){
  e.preventDefault();
  console.log("click!!!!!")
  pageVal = $(this).data('num');

  cateList();
})



// 제목으로 검색 AJax
//   $('.title').on('click', function () {
//     let hairName = selectName;
//     $.ajax({
//       url: "/adminR/hairName",
//       type: 'get',
//       data: {hairName: hairName},
//       success: function (result) {
//         $('.hl').html(findHairByName(result.nameHair));
//         let pageInfo = result.pageInfo;
//         let pageNum = generatePageLinks(pageInfo);
//
//         $('.page-box').html(pageNum);
//       }
//     });
//   })


// 제목으로 검색 함수
function findHairByName(nameHair) {
  $('.hl').html('');
  for (let i = 0; i < nameHair.length; i++) {
    $('.hl').append(`
         <ul class="list-ul">
                  <!-- 첫번째 -->
                  <li class="list-li">
                    <a href="/admin/hairRead?hairNumber=${nameHair[i].hairNumber}">
                      <div class="img-list">
                      <img src="${'/upload/' + nameHair[i].hairFileUploadPath + '/th_' + nameHair[i].hairFileUuid + '_' + nameHair[i].hairFileName}" alt="">
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
