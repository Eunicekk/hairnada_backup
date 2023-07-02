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
// 체크박스 끝

mainBasket1();

function mainBasket1() {
  let basket = '';
  $.ajax({
    url: '/users/myBasket',
    type: 'GET',
    success: function(obj){
      basket = getBigBox(obj);
      $('.big_box').html(basket);
      checkBoxBtn();
      console.log("@@" + obj);
    }
  });
}

$("#my-basket-btn").on("click", mainBasket1);

$("#my-pay-btn").on("click", function () {
  $(".big-box").html(getBigBox2());
  createDatePicker();
});


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
                  <th>배송비</th>
              </tr>
          </thead>
          <tbody>
  `;

  for(let i=0; i<obj.length; i++){
    text += `
      <tr>
        <td class="check-img-box2">
            <input type="checkbox" id="check-label2" class="check-img-input"/>
            <label for="check-label2" class="check-img-label"></label>
        </td>
        <td>
            <img src="/upload/" + ${obj[i].storeFileUploadPath} + "/th_" + ${obj[i].storeFileUUID} + "_" + ${obj[i].storeFileName}" alt="상품">
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
        <td class="test-result">${obj[i].storePriceAll}</td>
        <td class="delivery-charge">${obj[i].deliveryFee === 0 ? '무료배송' : obj[i].deliveryFee}</td>
    </tr>
    `;
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
      </p>
  `;

  return text;
}

function getBigBox2() {
  return `
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
            <li class="dropdown-item">주문접수</li>
            <li class="dropdown-item">결제완료</li>
            <li class="dropdown-item">상품준비중</li>
            <li class="dropdown-item">배송중</li>
            <li class="dropdown-item">배송완료</li>
            <li class="dropdown-item">취소/교환/반품</li>
          </ul>
        </div>
        <table class="buy-tbl">
            <thead>
                <tr>
                    <th>주문날짜</th>
                    <th>상품정보</th>
                    <th>수량</th>
                    <th>총 상품 금액</th>
                    <th>배송비</th>
                    <th>진행상황</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>2023-06-29</td>
                    <td>
                        <img src="https://image.oliveyoung.co.kr/uploads/images/goods/550/10/0000/0014/A00000014950114ko.jpg?l=ko" alt="상품">
                        <p class="test-product">라보에이치 탈모증상완화 샴푸인데 일부러러러러러러러러러 글을 길게 써서 한번 넘겨보자자자자자자자자자자 울지마 바보야 난정말괜찮아아아아아아앙아아아아</p>
                    </td>
                    <td>2</td>
                    <td>52000</td>
                    <td>무료배송</td>
                    <td>취소/교환/반품</td>
                </tr>
            </tbody>
        </table>
        <div class="coopang-box">
           <img src="/img/coopang.png" alt="" class="coopang-img" />
        </div>
  `;

}

let BasketBtn = document.getElementsByClassName("my-basket-btn");
let payBtn = document.getElementsByClassName("my-pay-btn");

BasketBtn.addEventListener("click", function () {
  BasketBtn.querySelector(".active-banner").classList.add("selected");
  payBtn.querySelector(".active-banner").classList.remove("selected");
});

payBtn.addEventListener("click", function () {
  BasketBtn.querySelector(".active-banner").classList.remove("selected");
  payBtn.querySelector(".active-banner").classList.add("selected");
});

// 드롭다운

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

// 수량 처리
const decreaseButton = document.getElementById("minus-box");
const increaseButton = document.getElementById("plus-box");
const quantityInput = document.getElementById("number-box");

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

// 드롭다운
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