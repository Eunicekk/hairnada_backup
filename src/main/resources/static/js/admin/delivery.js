$(".completed-cnt").on("click", function () {
  $(".completed-orders-box").css("color", "#FFFFFF");
  $(".completed-orders-box").css("background-color", "#222");

  $(".order-list-box").css("color", "#222");
  $(".order-list-box").css("background-color", "#FFFFFF");
});

$(".order-cnt").on("click", function () {
  $(".order-list-box").css("color", "#FFFFFF");
  $(".order-list-box").css("background-color", "#222");

  $(".completed-orders-box").css("color", "#222");
  $(".completed-orders-box").css("background-color", "#FFFFFF");
});

// 배송 완료 목록
$(".completed-cnt").on("click", function () {
  findCompleteList();
});

function findCompleteList(){
  let page = pageVal;
  $.ajax({
    url : "/adminR/complete",
    type : 'get',
    data: {page : page},
    success: function(result){
      $('.quest-list').html('');
      for (let i = 0; i < result.completeList.length; i++) {
        $('.quest-list').append(`
       <ul class="order-list">
                <li class="order-number">${result.completeList[i].buyNumber}</li>
                <li class="member-number">${result.completeList[i].userName}</li>
                <li class="product-title">${result.completeList[i].storeTitle}</li>
                <li class="member-address">
                 ${result.completeList[i].buyAddress}
                </li>
                <li class="member-quest">${result.completeList[i].buyMsg}</li>
                <li class="delivery-status">배송 완료</li>
              </ul>
  `);
      }
      let pageInfo = result.pageInfo;
      let pageHtml = generatePageLinks(pageInfo);

      $('.page-box').html(pageHtml);
    }
  });
}

$('.order-cnt').on('click', function (){
  $.ajax({
    url : "/adminR/incomplete",
    type : 'get',
    success: function(result){
      $('.quest-list').html('');
      for (let i = 0; i < result.incompleteList.length; i++) {
        $('.quest-list').append(`
       <ul class="order-list">
                <li class="order-number">${result.incompleteList[i].buyNumber}</li>
                <li class="member-number">${result.incompleteList[i].userName}</li>
                <li class="product-title">${result.incompleteList[i].storeTitle}</li>
                <li class="member-address">${result.incompleteList[i].buyAddress}</li>
                <li class="member-quest">${result.incompleteList[i].buyMsg}</li>
                <li class="delivery-status"> 
                 <select name="delivery" class="delivery">
                    <option value="">배송 상태</option>
                    <option value="1" ${result.incompleteList[i].deliveryNumber == 1 ? 'selected' : ''}>결제 완료</option>
                    <option value="2" ${result.incompleteList[i].deliveryNumber == 2 ? 'selected' : ''}>상품 준비중</option>
                    <option value="3" ${result.incompleteList[i].deliveryNumber == 3 ? 'selected' : ''}>배송중</option>
                    <option value="4" ${result.incompleteList[i].deliveryNumber == 4 ? 'selected' : ''}>배송 완료</option>
                 </select>
                  <button type="submit" class="registration">등록</button></li>
              </ul>
  `);
      }
    }
  });
});


let deliveryNum;
let buyNum;

$('.delivery').on('change', function (){
  deliveryNum = $(this).val();
  buyNum = $(this).closest('.order-list').find('.order-number').text();
})

$('.registration').on('click', function (){
  let deliveryNumber = deliveryNum;
  let buyNumber = buyNum;

  $.ajax({
    url : "/adminR/delivery",
    type: 'get',
    data : {
      deliveryNumber : deliveryNumber,
      buyNumber : buyNumber
    },
    success : function (){
      window.alert("배송 상태가 변경 되었습니다!");
      if(deliveryNumber == 4) {
        window.location.href = '/admin/delivery';
      }
    }
  });
});



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

// 페이지 저장
let pageVal;

$('.page-box').on('click','.page-num', function(e) {
  pageVal = $(this).text();
});


$('.page-box').on('click', '.cate-a', function (e){
  e.preventDefault();
  console.log("click!!!!!")
  pageVal = $(this).data('num');
  findCompleteList();
})