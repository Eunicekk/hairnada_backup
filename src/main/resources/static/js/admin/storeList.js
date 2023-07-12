
// select option 저장하기

let categoryNumber;
$('.category').on('change', function (){
  categoryNumber = $(this).val();
})

// 제목 input
let searchTitle;

$('.select-title').on('change', function (){
  searchTitle = $(this).val();
});

// 페이지 저장
let pageVal;

$('.page-box').on('click','.page-num', function(e) {
  pageVal = $(this).text();
});



// 카테고리 별 상품 조회 ajax
$('.search').on('click', function (){
 pageVal = 1;
 cateList();
})

function cateList(){
  let storeCategoryNumber = categoryNumber;
  let storeTitle = searchTitle;
  let page = pageVal;

  $.ajax({
    url: '/adminR/storeList',
    type: 'get',
    data: {
      storeCategoryNumber: storeCategoryNumber,
      storeTitle : storeTitle,
      page: page
    },

    success: function (result) {
      $('.cl').html(generateStoreList(result.categoryStore));

      let pageInfo = result.pageInfo;
      let pageHtml = generatePageLinks(pageInfo);

      $('.page-box').html(pageHtml);
    },
    error: function (xhr, status, error) {
      console.log('Error:', error);
    }

  });

}

// 검색 함수
function generateStoreList(categoryStore) {

  let storeList = '';
  for (let i = 0; i < categoryStore.length; i++) {
    storeList += `
                <ul class="list-ul">
                  <li class="list-li">
                    <a href="/admin/storeRead?storeNumber=${categoryStore[i].storeNumber}">
                      <div class="img-list">
                       <img src="${'/upload/' + categoryStore[i].storeFileUploadPath + '/th_' + categoryStore[i].storeFileUuid + '_' + categoryStore[i].storeFileName}" alt="">
                      </div>
                    </a>

                    <div class="product-information">
                      <p class="product-title">${categoryStore[i].storeTitle}</p>
                      <p class="product-category">${categoryStore[i].storeCategoryName}</p>
                      <p class="product-price">
                        ₩ <span class="price">${categoryStore[i].storePrice}</span>
                      </p>
                    </div>
                  </li>
                </ul> `;
  }
  return storeList;
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
  pageVal = $(this).data('num');
  cateList();
})
