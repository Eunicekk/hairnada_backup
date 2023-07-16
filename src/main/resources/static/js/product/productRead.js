import * as storeReply from '../module/storeReply.js';

const storeNumber = $(".store-num").val();


// 장바구니 클릭시 나타나는 문구
$(".basket").click(function () {
  alert("장바구니에 추가하였습니다!");
  let storeNumber = $(this).data("num")
  let storeCnt = $("#quantityInput").val();
  console.log(storeNumber);
  console.log(storeCnt);
  $.ajax({
    url : "/storeR/productBuy",
    type : "post",
    contentType : "application/json",
    data : JSON.stringify({storeNumber : storeNumber, basketCnt : storeCnt}),
    success : function (){
      console.log("들어갓다.");
    }
  });
});

// 좋아요
$(document).ready(function () {
  $(".buttons").click(function () {
    var buttonImg = $(this).find(".likeBtn");
    var storeNumber = $(this).find(".likeBtn").val();


    if (buttonImg.hasClass("active")) {
      $.ajax({
        url: "/storeLike/subtract",
        type: "DELETE",
        contentType: "application/json",
        data: JSON.stringify({ storeNumber: storeNumber }),
        success: function(){
          let likeNumber = parseInt($(".like-cnt").text());
          let test = likeNumber + 1;

          $(".like-cnt").text(test)
          console.log("빼기 성공");
        }
      });

      buttonImg.removeClass("active");
      buttonImg.css("background-image", "url('/img/heart1.png')");
    } else {
      $.ajax({
        url: "/storeLike/add",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({ storeNumber: storeNumber }),
        success: function(){
          let likeNumber = parseInt($(".like-cnt").text());
          let test = likeNumber - 1;

          $(".like-cnt").text(test)
          console.log("더하기 성공");
        }
      });

      buttonImg.addClass("active");
      buttonImg.css("background-image", "url('/img/heart2.png')");
    }
  });
});

// 사진 눌렀을 때 모달 띄우면서 확대

$(".img-list").on("click", function () {
  let viewImg = $(this).find('img').attr("src");
  $(".modal").css("display", "flex");
  // $(".view-img").attr("src", viewImg);

  $(".view-img2").css("width", '600px');
  $(".view-img2").css("height", '600px');
  $(".view-img2").css("background-image", `url(${viewImg})`);
  console.log(viewImg)
});

$(".background").on("click", function () {
  $(".modal").css("display", "none");
});

$(".view-img").on("click", function () {
  console.log($(this).attr("background-image"));
});

let storeNum = $('.store-num').val();

console.log(storeNum);
function displayAjax(){
  let storeNumber = storeNum;

  $.ajax({
    url : '/adminFile/storeImgList',
    type : 'get',
    data : {storeNumber : storeNumber},
    success : function(storeImgList){
      let text = '';
      $('.file-wrap').html('');
      storeImgList.forEach(file => {
        let fileName = file.storeFileUploadPath + '/' + file.storeFileUuid + '_' + file.storeFileName;
        text += `
                    <li>
                      <img  class="img-list" src="/adminFile/display?fileName=${fileName}" data-number="${file.storeFileNumber}" data-name="${fileName}" />
                    </li>  
`;
      });

      $('.file-wrap').html(text);
    }
  });
}

displayAjax();

// 초기에 "전 체" 버튼을 클릭된 상태로 설정
document.getElementById("button0").classList.add("active");

// 클릭된 버튼에 active 클래스 추가 및 다른 버튼의 active 클래스 제거
var buttons = document.getElementsByClassName("categoryBtn");
for (var i = 0; i < buttons.length; i++) {
  buttons[i].addEventListener("click", function () {
    var clickedButton = this;

    // 모든 버튼의 active 클래스 제거
    for (var j = 0; j < buttons.length; j++) {
      buttons[j].classList.remove("active");
    }

    // 클릭된 버튼에 active 클래스 추가
    clickedButton.classList.add("active");
  });
}

var imgSrc = $('.store-main-content img').attr('src');
// 카테고리 클릭시
$(".info1").on("click", function () {

// 추출한 속성 값 출력
  console.log(imgSrc);
  console.log("버튼이당~~!!!");
  $(".bigBox").html("");
  $(".bigBox").append(` <div class="productData">
  <div class="contentImg">
    <img src="${imgSrc}" alt="제품 상세">
  </div>
</div>`);
});

$(".info2").on("click", function () {
  console.log("버튼이당~~!");
  $(".bigBox").html("");
  $(".bigBox").append(` <div class="attentionData">
  <h3 class="attentionTitle">상품정보 제공고시</h3>
  <div class="attentionDetail">
  <dl class="detail-info">
  <dt>내용물의 용량 또는 중량</dt>
  <dd>50ml+50ml</dd>
  </dl>
  <dl class="detail-info">
  <dt>제품 주요 사양</dt>
  <dd>모든 피부 타입</dd>
  </dl>
  <dl class="detail-info">
  <dt>사용기한(또는 개봉 후 사용기간)</dt>
  <dd>30개월(개봉 후 12개월)</dd>
  </dl>
  <dl class="detail-info">
  <dt>사용방법</dt>
  <dd>스킨케어 마지막 단계에서 적당량을 취해 피부에 골고루 펴 발라줍니다.</dd>
  </dl>
  <dl class="detail-info">
  <dt>제조국</dt>
      <dd>대한민국</dd>
    </dl>
    <dl class="detail-info">
    <dt>사용할 때의 주의사항</dt>
    <dd>"1) 화장품 사용 시 또는 사용 후 직사광선에 의하여 사용부위가 붉은 반점, 부어오름 또는 가려움증 등의 이상 증상이나 부작용이 있는 경우 전문의 등과 상담할 것 2) 상처가 있는 부위 등에는 사용을 자제할 것 3) 보관 및 취급 시의 주의사항 가) 어린이의 손이 닿지 않는 곳에 보관할 것 나) 직사광선을 피해서 보관할 것"</dd>
    </dl>
    <dl class="detail-info">
    <dt>소비자상담 전화번호</dt>
    <dd>010-8468-6643</dd>
    </dl>
    </div>
    <h3 class="attentionTitle">배송안내</h3>
  <dl class="detail-info">
  <dt>배송비 / 배송가능일</dt>
  <dd>
  <div>
  <p><strong>[일반 배송]</strong></p>
  <p><strong>배송지역 : </strong>전국</p>
  <p><strong>배송비 : </strong><span class="dataName">3,000원</span></p>
  <p>올리브영 배송 상품의 총 결제금액<span class="dataName">50,000원</span> 이상일 경우<span class="dataName"> 무료 배송</span> 됩니다.</p>
  <p><strong>배송가능일 : </strong><span class="dataName">6</span>일</p>
  <p>배송가능일이란 본 상품을 주문하신 고객님들께 상품 배송이 가능한 기간을 의미합니다. 단, 연휴 및 공휴일은 기간 계산시 제외하며 현금 주문일 경우 입금일 기준 입니다.</p>
  <p>예약 상품의 경우 예약된 날짜에 출고되며, 상품의 입고가 빠르게 진행된 경우 예약일 보다 일찍 배송될 수 있습니다.</p>
  </div>
  </dd>
  </dl>
  </div> `);
});

$(".info3").on("click", function () {
  console.log("버튼이당~~2");
  $(".bigBox").html("");
  $(".bigBox").append(`  <div class="commentBox">
  <div class="comment-form">
  <div class="holder">
  <form action="">
  <fieldset>
  <div class="star-score">
  <span class="star-text">별점&nbsp; | &nbsp;</span>
  <label for="star1" data-star="1">
  <span class="material-symbols-rounded">star</span>
  </label>
  <label for="star2" data-star="2">
  <span class="material-symbols-rounded">star</span>
  </label>
  <label for="star3" data-star="3">
  <span class="material-symbols-rounded">star</span>
  </label>
  <label for="star4" data-star="4">
  <span class="material-symbols-rounded">star</span>
  </label>
  <label for="star5" data-star="5">
  <span class="material-symbols-rounded">star</span>
  </label>
  <input type="radio" value="1" id="star1" class="input-star" name="input-star"/>
  <input type="radio" value="2" id="star2" class="input-star" name="input-star" />
            <input type="radio" value="3" id="star3" class="input-star"  name="input-star"/>
            <input type="radio" value="4" id="star4" class="input-star" name="input-star" />
            <input type="radio" value="5" id="star5" class="input-star" name="input-star" />
            </div>
            </fieldset>
            <div>
            <div class="replyBox">
            <textarea
              id="storeReplyContent"
              name="storeReplyContent"
              required
              placeholder="댓글을 작성하세요."
            ></textarea>
          </div>
          <button type="button" class="submit-btn">확인</button>
            </div>
            </div>
            </form>
            </div>
            
            <div class="comment-list">
            </div>
            </div> `);




  // 별점
  let $star = $(".star-score label");

  $star.on("click", function () {
    $(this).children().css("text-shadow", "0 0 0 black");
    $(this).prevAll("label").children().css("text-shadow", "0 0 0 black");
    $(this)
      .nextAll("label")
      .children()
      .css("text-shadow", "0 0 0 rgb(203, 203, 203)");

    // console.log($(this).data('star'));

  });
});

// 수량 처리
const decreaseButton = document.getElementById("decreaseButton");
const increaseButton = document.getElementById("increaseButton");
const quantityInput = document.getElementById("quantityInput");

decreaseButton.addEventListener("click", () => {
  console.log("내려간다!!!!");
  let currentValue = parseInt(quantityInput.value);
  if (currentValue > 0) {
    currentValue--;
    quantityInput.value = currentValue;
  }
});

increaseButton.addEventListener("click", () => {
  console.log("올라간다!!!!");
  let currentValue = parseInt(quantityInput.value);
  currentValue++;
  quantityInput.value = currentValue;
});

// 댓글
let page = 1;

storeReply.getListPage({storeNumber : storeNumber, page : page}, showReply, showError);

function showReply(map) {

  console.log('==========================')
  console.log(map);
  console.log('==========================')

  let text = '';

  map.replyList.forEach(r => {
    text += `
          <ul id="comment-list" class="reply" data-num="${r.storeReplyNumber}">
            <li>
            <div class="comment-wrap">
              <div class="comment-info">
                <span class="writer">${r.userNickName}</span> ｜ 
                <div class="user-star-score">
                      <span class="material-symbols-rounded">star</span> <span>${r.storeScore}</span>
                </div> ｜ 
                <span class="date">${storeReply.timeForToday(r.storeReplyRegisterDate == r.storeReplyUpdateDate ? r.storeReplyRegisterDate : r.storeReplyUpdateDate)}</span>
              </div>
                <div class="comment-btn-group">`;

    if(r.userNumber == loginNumber){
      text +=`
                  <button type="button" class="comment-modify-ready">수정</button>
                  <button type="button" class="comment-delete">삭제</button>
                `;
    }

    text += `</div>
              </div>`;

    text += `
            </div>
            <div class="comment-content">
            <p>${r.storeReplyContent}</p>
            </div>
            </li>
            </ul>
    `;
  });

  $(".comment-list").html(text);
}


function appendText(map){
  let text = '';

  map.replyList.forEach(r => {
    text += `
           <ul id="comment-list" class="reply" data-num="${r.storeReplyNumber}">
            <li>
            <div class="comment-wrap">
              <div class="comment-info">
                <span class="writer">${r.userNickName}</span>  
                <div class="user-star-score">
                      <span class="material-symbols-rounded">star</span> <span>${r.storeScore}</span>
                </div>
                <span class="date">${storeReply.timeForToday(r.storeReplyRegisterDate == r.storeReplyUpdateDate ? r.storeReplyRegisterDate : r.storeReplyUpdateDate)}</span>
              </div>
                <div class="comment-btn-group">`;

    if(r.userNumber == loginNumber){
      text +=`
                  <button type="button" class="comment-modify-ready">수정</button>
                  <button type="button" class="comment-delete">삭제</button>
                `;
    }

    text += `</div>
              </div>`;

    text += `
            </div>
            <div class="comment-content">
            <p>${r.storeReplyContent}</p>
            </div>
            </li>
            </ul>     
    `
  });
  $('.comment-list').append(text);
}

// 댓글 스크롤로 페이징
$(window).on('scroll', function (){
  if(Math.round($(window).scrollTop()) == $(document).height() - $(window).height()){
    console.log(++page);
    storeReply.getListPage({storeNumber : storeNumber, page : page}, appendText, showError);
  }
});

function showError(a, b, c){
  console.error(c);
}


$(".bigBox").on('click', '.submit-btn', function (){
  console.log($(".replyCnt").text());
  console.log($(".starSecore-avg").text());
  let replyAvg = parseFloat($(".starSecore-avg").text());
  let replyNumber = parseInt($(".replyCnt").text());
  let storeReplyContent = $('#storeReplyContent').val();
  let starScore = $('.input-star:checked').val();
  console.log($('.input-star:checked').val())
  let test = replyNumber + 1;
  let testAvg = ((replyAvg * replyNumber) + starScore)/test;
  testAvg = testAvg.toFixed(1);
  console.log("============================================")
  console.log(test);
  console.log(testAvg);
  console.log("============================================")

  $(".replyCnt").text(test)
  $(".starSecore-avg").text(testAvg)

  console.log($('.input-star:checked'))
  console.log($('.input-star:checked').val())

  let replyObj = {
    storeReplyContent : storeReplyContent,
    storeNumber : storeNumber,
    storeScore : $('.input-star:checked').val()
  }

  page = 1;


  storeReply.add(replyObj,
      function (){
    storeReply.getListPage({storeNumber : storeNumber, page : page}, showReply, showError);
      },
      showError)
});

$(".bigBox").on("click",".comment-delete", function (){
  let storeReplyNumber = $(this).closest(".reply").data("num")
  let replyNumber = parseInt($(".replyCnt").text());
  let test = replyNumber - 1;

  $(".replyCnt").text(test)

  page = 1;

  storeReply.remove(storeReplyNumber, function (){
    storeReply.getListPage({storeNumber : storeNumber, page : page}, showReply, showError);
  }, showError);
});


// 댓 수정
$(".bigBox").on("click", ".comment-modify-ready", function (){
  console.log("클릭했디")
  let $storeReplyContent = $(this).closest(".reply").find(".comment-content");
  $storeReplyContent.replaceWith(`
    <div class='modify-box'>
  <textarea class="modify-content">${$storeReplyContent.text()}</textarea>
  <button type="button" class="comment-modify">수정 완료</button>
  </div>
  `)
  $(".comment-btn-group").addClass("none");
});


$(".bigBox").on("click", ".comment-modify", function (){
  console.log("수정됐다.");
  let storeReplyNumber = $(this).closest(".reply").data("num");
  let storeReplyContent = $(this).closest(".modify-box").find(".modify-content").val();

  let replyObj = {
    storeReplyNumber : storeReplyNumber,
    storeReplyContent : storeReplyContent
  }

  page = 1;

  storeReply.modify(replyObj, function (){
    storeReply.getListPage({storeNumber : storeNumber, page : page}, showReply, showError);
  }, showError);
});

// 구매하기 버튼
$(".buyBtn").on("click", function (){
  window.location.href = "/store/buy";
})