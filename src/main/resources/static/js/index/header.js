
// 드롭다운 박스 설정
$(document).ready(function() {
    $('.header-icon').click(function() {
      $(this).find('.dropdown-content').toggle();
    //   헤더 제외 다른 부분 어둡게 하는 코드 추가 필요
    });
  
    $(document).click(function(e) {
      var target = e.target;
      if (!$(target).is('.header-icon') && !$(target).parents().is('.header-icon')) {
        $('.dropdown-content').hide();
      }
    });
});