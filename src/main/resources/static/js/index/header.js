// 드롭다운 박스 설정
$('.header-icon').click(function() {
  $(this).find('.dropdown-content-header').toggle();
//   헤더 제외 다른 부분 어둡게 하는 코드 추가 필요
});

$(document).click(function(e) {
  var target = e.target;
  if (!$(target).is('.header-icon') && !$(target).parents().is('.header-icon')) {
    $('.dropdown-content-header').hide();
  }
});


// 장바구니에 담긴 상품 개수 표시
$.ajax({
    url: '/myBasket/count',
    type: 'GET',
    success: function(count){
        $('.basket-count').text(count);
    }
});