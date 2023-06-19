let $slideBox = $('.banner-box');
let $slideImg = $('.banner-image');
let $productBox = $('.product-box');
let $productImg = $('.product-image');
let $styleBox = $('.hair-box');
let $styleImg = $('.hair-content');
let $boardBox = $('.ListUl');

// 메인 배너 자동으로 움직이기
let currentIdx = 0;
let slideWidth = 1300;
let slideCnt = $slideImg.length;

setInterval(function(){
    currentIdx++;
    $slideBox.css("left", -(currentIdx * slideWidth));
    $slideBox.css('transition', '1s ease');
    if(currentIdx == slideCnt - 1){
        console.log("마지막이다!")
        setTimeout(function(){
            currentIdx = 0;
            $slideBox.css('transition', '0s');
            $slideBox.css("left", 0);
        }, 1500);
    }
}, 3000);


// 헤어 스타일 추천 양옆 버튼 클릭 시 넘어가기
let currentIdx2 = 0;
let styleWidth = 360;
let styleCnt = $styleImg.length;

checkEnd();

$('.main-content-01 .right').on('click', function(){
    console.log("next!!");
    currentIdx2++;
    $styleBox.css("left", -(currentIdx2 * styleWidth));
    $styleBox.css('transition', '0.5s ease');
    checkEnd();
});

$('.main-content-01 .left').on('click', function(){
    console.log("prev!!");
    currentIdx2--;
    $styleBox.css("left", -(currentIdx2 * styleWidth));
    $styleBox.css('transition', '0.5s ease');
    checkEnd();
})

function checkEnd(){
    if(currentIdx2 <= 0){
        $('.main-content-01 .left').css('display', 'none');
    } else {
        $('.main-content-01 .left').css('display', 'block');
    }

    if(currentIdx2 >= styleCnt-3){
        $('.main-content-01 .right').css('display', 'none');
    } else {
        $('.main-content-01 .right').css('display', 'block');
    }
}


// 제픔 자동으로 움직이기
let productArr = $('.product-category');
let arrIdx = 0;
let currentIdx3 = 0;
let productWidth = 380;
let productCnt = productArr.eq(arrIdx).find('.product-image').length;
console.log(productCnt);

productArr.eq(arrIdx).css('opacity', '1');

setInterval(function(){
    currentIdx3++;
    $productBox.css("left", -(currentIdx3 * productWidth));
    $productBox.css('transition', '1s ease');
    if(currentIdx3 == productCnt - 2){
        setTimeout(function(){
            currentIdx3 = 0;
            productArr.eq(arrIdx).css('transition', '0.5s');
            productArr.eq(arrIdx).css('opacity', '0');
            arrIdx = (arrIdx + 1) % productArr.length;
            productArr.eq(arrIdx).css('transition', '0.5s');
            productArr.eq(arrIdx).css('opacity', '1');
            $productBox.css('transition', '0s');
            $productBox.css("left", 0);
        }, 1500);
    }
}, 3000);


// 커뮤니티 게시물 이동
let currentIdx4 = 0;
let boardWidth = 441.525;
let boardCnt = $('.ListLi').length;

checkEnd2();

$('.main-content-04 .right').on('click', function(){
    console.log("next!!");
    currentIdx4++;
    $boardBox.css('transition', '0.5s ease');
    $boardBox.css("left", -(currentIdx4 * boardWidth) + 'px');
    checkEnd2();
});

$('.main-content-04 .left').on('click', function(){
    console.log("prev!!");
    currentIdx4--;
    $boardBox.css("left", -(currentIdx4 * boardWidth));
    $boardBox.css('transition', '0.5s ease');
    checkEnd2();
})

function checkEnd2(){
    if(currentIdx4 <= 0){
        $('.main-content-04 .left').css('display', 'none');
    } else {
        $('.main-content-04 .left').css('display', 'block');
    }

    if(currentIdx4 >= boardCnt-3){
        $('.main-content-04 .right').css('display', 'none');
    } else {
        $('.main-content-04 .right').css('display', 'block');
    }
}

// 버튼 클릭시 커뮤니티 하트 변경
$(document).ready(function () {
    $(".buttons").click(function () {
      var buttonImg = $(this).find(".like");
  
      if (buttonImg.hasClass("active")) {
        buttonImg.removeClass("active");
        buttonImg.css("background-image", "url('/img/heart1.png')");
      } else {
        buttonImg.addClass("active");
        buttonImg.css("background-image", "url('/img/heart2.png')");
      }
    });
  });