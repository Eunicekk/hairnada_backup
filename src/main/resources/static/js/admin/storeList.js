
// select option 저장하기
let categoryNumber;

$(".category").on("change", function () {
  categoryNumber = $(this).val();
  console.log(categoryNumber);
});



// 카테고리 별 상품 조회 ajax
$('.select').on('click', function (){
  let selectCategoryNumber = categoryNumber;

  if(selectCategoryNumber == 0){
    window.location.href = '/admin/storeList';
  } else {
    $.ajax({
      url: '/adminR/storeList',
      type: 'get',
      data: {
        storeCategoryNumber: selectCategoryNumber
      },

      success: function (result) {
        $('.cl').html(``);
        console.log(result.categoryStore);
        for (let i = 0; i < result.categoryStore.length; i++) {
          $('.cl').append(`
    <ul class="list-ul">
                  <!-- 첫번째 -->
                  <li class="list-li">
                    <a href="/admin/storeRead?storeNumber=${result.categoryStore[i].storeNumber}">
                      <div class="img-list">
                       <img src="${'/upload/' + result.categoryStore[i].storeFileUploadPath + '/th_' +result.categoryStore[i].storeFileUuid + '_' + result.categoryStore[i].storeFileName}" alt="">
                      </div>
                    </a>

                    <div class="product-information">
                      <p class="product-title">${result.categoryStore[i].storeTitle}</p>
                      <p class="product-category">${result.categoryStore[i].storeCategoryName}</p>
                      <p class="product-price">
                        ₩ <span class="price">${result.categoryStore[i].storePrice}</span>
                      </p>
                    </div>
                  </li>
                </ul>
            `);
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
      },
      error: function (xhr, status, error) {
        console.log('Error:', error);
      }

    });
  }
})

let storeTitle;

$('.select-title').on('change', function (){
  storeTitle = $(this).val();
});


// 이름 별 상품 조회 ajax
$('.search').on('click', function (){
  let selectStoreTitle = storeTitle;

  if(storeTitle == null){
    window.location.href = '/admin/storeList';
  } else {
    $.ajax({
      url: '/adminR/storeTitle',
      type: 'get',
      data: {
        storeTitle: selectStoreTitle
      },

      success: function (result) {
        $('.cl').html('');
        for (let i = 0; i < result.titleStore.length; i++) {
          $('.cl').append(`
    <ul class="list-ul">
                  <!-- 첫번째 -->
                  <li class="list-li">
                    <a href="/admin/storeRead?storeNumber=${result.titleStore[i].storeNumber}">
                      <div class="img-list">
                        <img src="${'/upload/' + result.titleStore[i].storeFileUploadPath + '/th_' +result.titleStore[i].storeFileUuid + '_' + result.titleStore[i].storeFileName}" alt="">
                      </div>
                    </a>

                    <div class="product-information">
                      <p class="product-title">${result.titleStore[i].storeTitle}</p>
                      <p class="product-category">${result.titleStore[i].storeCategoryName}</p>
                      <p class="product-price">
                        ₩ <span class="price">${result.titleStore[i].storePrice}</span>
                      </p>
                    </div>
                  </li>
                </ul>
            `);

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
      },
      error: function (xhr, status, error) {
        console.log('Error:', error);
      }

    });
  }
})

