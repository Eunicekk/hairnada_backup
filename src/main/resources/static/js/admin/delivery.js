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





// 배송 미완료 목록
$(".completed-cnt").on("click", function () {
  $.ajax({
    url : "/adminR/complete",
    type : 'get',
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
    }
  });
});

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
                    <option value="1" ${result.incompleteList[i].deliveryNumber == 1 ? 'selected' : ''}>상품 준비중</option>
                    <option value="2" ${result.incompleteList[i].deliveryNumber == 2 ? 'selected' : ''}>배송중</option>
                    <option value="3" ${result.incompleteList[i].deliveryNumber == 3 ? 'selected' : ''}>배송 완료</option>
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
      if(deliveryNumber == 3) {
        window.location.href = '/admin/delivery';
      }
    }
  });
});
