
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

      success: function (categoryStore) {
        console.log('Received categoryStore:', categoryStore);
        $('.cl').html(``);
        for (let i = 0; i < categoryStore.length; i++) {
          $('.cl').append(`
    <ul class="list-ul">
                  <!-- 첫번째 -->
                  <li class="list-li">
                    <a>
                      <div class="img-list">
                        <img src="https://sitem.ssgcdn.com/69/72/95/item/1000197957269_i2_750.jpg" alt="">
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
                </ul>
            `);
        }
      },
      error: function (xhr, status, error) {
        console.log('Error:', error);
      }

    });
  }
})


