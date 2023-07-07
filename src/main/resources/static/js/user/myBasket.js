$(document).ready(function() {
  mainBasket1();
});

// 장바구니 리스트 실행
function mainBasket1() {
  let basket = '';
  $.ajax({
    url: '/myBasket/list',
    type: 'GET',
    success: function(obj){
      basket = getBigBox(obj);
      $('.big-box').html(basket);
      checkBoxBtn();

      // 삭제 버튼 실행
      $('.cancel-btn').on('click', function(){
        deleteProduct();
      })

      // 구매하기로 이동
      $('.buy-btn').on('click', function (){
        let checkedCount = $('.check-label2:checked').length;
        let basketList = [];
        let basketNumber = $('.check-label2:checked');


        basketNumber.each(function(index, element){
          let basketCnt = $(element).closest('.basket-content').find('.number-box').prop('value');
          let basketVoTemp = {
            basketNumber: $(element).val(),
            basketCnt: basketCnt
          };
          basketList.push(basketVoTemp);
        });

        let basketNumbers = [];
        basketNumber.each(function(){
          basketNumbers.push($(this).val());
        });

        if (checkedCount > 0) {
          // 체크박스가 선택되었을 경우 구매 페이지로 이동
          $.ajax({
            url: '/myBasket/modifyCount',
            type: 'patch',
            traditional : true,
            data: JSON.stringify(basketList),
            contentType: "application/json;charset=utf-8",
            success: function(){
              $.ajax({
                url: '/stores/buy',
                type: 'post',
                traditional: true,
                data: JSON.stringify(basketNumbers),
                contentType: "application/json;charset=utf-8",
                success: function() {
                  window.location.href = '/store/buy';
                }
              });
            }
          });
        } else {
          // 체크박스가 선택되지 않았을 경우 알림 표시
          alert('구매할 상품을 선택해주세요.');
        }
      })
    }
  });
}

// 장바구니에서 상품 삭제
function deleteProduct(){
  let checkNumber = $('.check-label2:checked');
  let basketNumbers = [];
  checkNumber.each(function(){
    basketNumbers.push($(this).val());
  });

  $.ajax({
    url: '/myBasket/remove',
    type: 'DELETE',
    traditional : true,
    contentType : "application/json;charset=utf-8",
    data : JSON.stringify(basketNumbers),
    success: function(){
      console.log(basketNumbers);
      checkNumber.each(function(){
        $(this).closest('.basket-content').remove();
      });
      location.reload();
    }
  });
}

// 구매내역 리스트 실행
function mainBasket2(){
  let basket = '';
  $.ajax({
    url: '/stores/buyList',
    type: 'GET',
    success: function(data) {
      basket = getBigBox2(data);
      $('.big-box').html(basket);
      createDatePicker();
    }
  });
};

$("#my-basket-btn").on("click", mainBasket1);
$("#my-pay-btn").on("click", mainBasket2);


function getBigBox(obj) {
  let text = '';

  text += `
      <table class="product-tbl">
          <thead>
              <tr>
                  <th class="check-img-box">
                      <input type="checkbox" id="check-label" class="check-img-input" />
                      <label for="check-label" class="check-img-label"> </label>
                  </th>
                  <th>상품정보</th>
                  <th>수량</th>
                  <th>가격</th>
                  <th>총 상품 금액</th>
              </tr>
          </thead>
          <tbody>
  `;

  if (obj.length === 0) {
    text += `
    <tr>
      <td colspan="5">장바구니에 담은 상품이 없습니다.</td>
    </tr>
  `;
  } else {
    for (let i = 0; i < obj.length; i++) {
      let priceAll = obj[i].basketCnt * obj[i].storePrice;
      text += `
      <tr class="basket-content">
        <td class="check-img-box2">
            <input type="checkbox" id="check-label${i}" class="check-img-input check-label2" value="${obj[i].basketNumber}"/>
            <label for="check-label${i}" class="check-img-label"></label>
        </td>
        <td>
            <img src="/upload/${obj[i].storeFileUploadPath}/th_${obj[i].storeFileUUID}_${obj[i].storeFileName}" alt="상품">
            <p class="test-product">${obj[i].storeTitle}</p>
        </td>
        <td class="test-count">
            <div class="quantity-cnt-box">
                <button class="minus-box">-</button>
                <input class="number-box" type="text" value="${obj[i].basketCnt}" readonly />
                <button class="plus-box">+</button>
            </div>
        </td>
        <td class="test-price">${obj[i].storePrice}</td>
        <td class="test-result">${priceAll}</td>
    </tr>
    `;
    }
  }

  text += `
            </tbody>
      </table>
      <div class="btn-box">
        <button class="cancel-btn">삭제하기</button>
        <button class="buy-btn">구매하기</button>
      </div>
      <p class="buy-text">
          *장바구니 제품은 30일간 보관됩니다.
      </p>
      <p class="buy-text">
          *더 오래 보관하려면 [좋아요]로 등록하세요.
      </p>
      <p class="buy-text">
          *장바구니 제품은 품절되면 자동으로 목록에서 삭제됩니다.
      </p><p class="buy-text">
          *5만원 이상 구매 시 배송비는 무료입니다.
      </p>
  `;

  return text;
}

function getBigBox2(data) {
  let text = '';

  text += `
    <div class="find-purchase-history">
      <div class="double">
        <input id="datepicker1" type="text" name="test" autocomplete='off'/> ~
        <input id="datepicker2" type="text" name="test2" autocomplete='off'/>
      </div>
      <button class="check-btn" type="submit">조회</button>
    </div>
      
    <div class="dropdown-buy">
      <button class="dropdown-btn">
        전체
        <span class="material-symbols-rounded">
          expand_more
        </span>
      </button>
      <ul class="dropdown-menu">
        <li class="dropdown-item">전체</li>
        <li class="dropdown-item">결제완료</li>
        <li class="dropdown-item">상품준비중</li>
        <li class="dropdown-item">배송중</li>
        <li class="dropdown-item">배송완료</li>
      </ul>
    </div>
    <table class="buy-tbl">
      <thead>
        <tr>
          <th>주문날짜</th>
          <th>상품정보</th>
          <th>수량</th>
          <th>총 상품 금액</th>
          <th>진행상황</th>
        </tr>
      </thead>`;

  if (data.length === 0) {
    text += `
      <tbody>
        <tr>
          <td colspan="5">구매한 상품이 없습니다.</td>
        </tr>
      </tbody>`;
  } else {
    text += `<tbody>`;
    for (let i = 0; i < data.length; i++) {
    let priceAll = data[i].buyCnt * data[i].storePrice;
      text += `
        <tr>
          <td>${data[i].buyDateFormat}</td>
          <td>
            <img src="/upload/${data[i].storeFileUploadPath}/th_${data[i].storeFileUUID}_${data[i].storeFileName}" alt="상품">
            <p class="test-product">${data[i].storeTitle}</p>
          </td>
          <td>${data[i].buyCnt}</td>
          <td>${priceAll}</td>
          <td>${data[i].deliveryName}</td>
        </tr>`;
    }
    text += `</tbody>`;
  }

  text += `
    </table>
    <div class="coopang-box">
      <img src="/img/coopang.png" alt="" class="coopang-img" />
    </div>`;

  return text;
}

// 달력
function createDatePicker() {
  //input을 datepicker로 선언
  $("#datepicker1, #datepicker2").datepicker({
    dateFormat: "yy-mm-dd", //달력 날짜 형태
    showOtherMonths: true, //빈 공간에 현재월의 앞뒤월의 날짜를 표시
    showMonthAfterYear: true, // 월- 년 순서가아닌 년도 - 월 순서
    changeYear: true, //option값 년 선택 가능
    changeMonth: true, //option값  월 선택 가능
    showOn: "both", //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시
    buttonImage:
      "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif", //버튼 이미지 경로
    buttonImageOnly: true, //버튼 이미지만 깔끔하게 보이게함
    buttonText: "선택", //버튼 호버 텍스트
    yearSuffix: "년", //달력의 년도 부분 뒤 텍스트
    monthNamesShort: [
      "1월",
      "2월",
      "3월",
      "4월",
      "5월",
      "6월",
      "7월",
      "8월",
      "9월",
      "10월",
      "11월",
      "12월",
    ], //달력의 월 부분 텍스트
    monthNames: [
      "1월",
      "2월",
      "3월",
      "4월",
      "5월",
      "6월",
      "7월",
      "8월",
      "9월",
      "10월",
      "11월",
      "12월",
    ], //달력의 월 부분 Tooltip
    dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"], //달력의 요일 텍스트
    dayNames: [
      "일요일",
      "월요일",
      "화요일",
      "수요일",
      "목요일",
      "금요일",
      "토요일",
    ], //달력의 요일 Tooltip
    minDate: "-5Y", //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
    maxDate: "+5y", //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)
  });

  //초기값을 오늘 날짜로 설정해줘야 합니다.
  $("#datepicker").datepicker("setDate", "today"); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
}

// 장바구니, 주문완료 탭 변경
$(document).on("click", "#my-basket-btn", function() {
  $(this).find(".active-banner").addClass("selected");
  $("#my-pay-btn").find(".active-banner").removeClass("selected");
});

$(document).on("click", "#my-pay-btn", function() {
  $(this).find(".active-banner").addClass("selected");
  $("#my-basket-btn").find(".active-banner").removeClass("selected");
});

// 수량 처리
$(document).on("click", ".minus-box", function() {
  console.log("내려간다!!!!");
  let quantityInput = $(this).siblings(".number-box");
  let currentValue = parseInt(quantityInput.val());
  if (currentValue > 1) {
    currentValue--;
    quantityInput.val(currentValue);
    calculatePriceAll($(this));
  }
});

$(document).on("click", ".plus-box", function() {
  console.log("올라간다!!!!");
  let quantityInput = $(this).siblings(".number-box");
  let currentValue = parseInt(quantityInput.val());
  currentValue++;
  quantityInput.val(currentValue);
  calculatePriceAll($(this));
});

function calculatePriceAll(element) {
  let quantityInput = element.siblings(".number-box");
  let priceElement = element.closest(".basket-content").find(".test-price");
  let resultElement = element.closest(".basket-content").find(".test-result");

  let basketCnt = parseInt(quantityInput.val());
  let storePrice = parseFloat(priceElement.text());
  let priceAll = basketCnt * storePrice;
  resultElement.text(priceAll);
}

// 드롭다운 박스
$(document).ready(function() {
  $(document).on("click", ".dropdown-buy", function() {
    $(this).find('.dropdown-menu').toggle();
  });

  $(document).on("click", function(e) {
    var target = e.target;
    if (!$(target).is('.dropdown-buy') && !$(target).parents().is('.dropdown-buy')) {
      $('.dropdown-menu').hide();
    }
  });
});

$(document).on("click", ".dropdown-menu li", function() {
  var selectedItem = $(this).text();
  $('.dropdown-btn').html(selectedItem + `
        <span class="material-symbols-rounded">
          expand_more
        </span>
     `);
});

// 체크박스
function checkBoxBtn(){
  $("#check-label").click(function () {
    var chk = $(this).is(":checked");

    if (chk) {
      $(".check-img-input").prop("checked", true);
    } else {
      $(".check-img-input").prop("checked", false);
    }
  });
}

$(".product-list").on("change", ".check-img-input", function (e) {
  let target = e.target;
  if (!$(target).is(":checked")) {
    $("#check-label").prop("checked", false);
  }
});