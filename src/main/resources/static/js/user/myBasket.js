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
// 체크박스


function mainBasket() {
  $(".big-box").html(getBigBox);
  checkBoxBtn();
}

mainBasket();

$("#my-basket-btn").on("click", mainBasket);

$("#my-pay-btn").on("click", function () {
  $(".big-box").html(getBigBox2);
  createDatePicker();
});

$(".big-box").on("click", ".buy-btn, .cancel-btn", function () {
  console.log("버튼 클릭이다잇~");
});

$(".big-box").on("click", ".cencel-btn", function () {
  console.log("취소버튼이다!!!");
});

function getBigBox() {
  return `

        <div class="product">제품</div>
        <div class="product-list">
          <div class="list-title">
            <div class="check-img-box">
              <input type="checkbox" id="check-label" class="check-img-input" />
              <label for="check-label" class="check-img-label"> </label>
            </div>
            <div class="product-box">제품정보</div>
            <div class="kg-box">수량</div>
            <div class="pay-box">금액</div>
            <div class="real-pay-box">합계금액</div>
          </div>
          <div class="list-detail">
            <div class="check-img-box2">
              <input
                type="checkbox"
                id="check-label2"
                class="check-img-input"
              />
              <label for="check-label2" class="check-img-label"></label>
            </div>
            <div class="product-img-detail">
              <img
                src="https://www.p-city.com/upload_file/202208/1660035370743.jpg"
                alt=""
                class="product-img"
              />
              <div class="product-title">초코비</div>
            </div>
            <div class="product-quantity">
              <div class="quantity-cnt-box">
                <button id="minus-box">-</button>
                <input id="number-box" type="text" value="0" readonly />
                <button id="plus-box">+</button>
              </div>
            </div>
            <div class="amount-box">
              <div class="amount">7000</div>
            </div>
            <div class="real-amount-box">
              <div class="real-amount">70000</div>
            </div>
          </div>
          <div class="list-detail2">
            <div class="check-img-box2">
              <input
                type="checkbox"
                id="check-label3"
                class="check-img-input"
              />
              <label for="check-label3" class="check-img-label"></label>
            </div>
            <div class="product-img-detail">
              <img
                src="https://www.p-city.com/upload_file/202208/1660035370743.jpg"
                alt=""
                class="product-img"
              />
              <div class="product-title">초코비</div>
            </div>
            <div class="product-quantity">
            <div class="quantity-cnt-box">
            <div id="minus-box">-</div>
            <input id="number-box" type="text" value="0" readonly />
            <div id="plus-box">+</div>
          </div>
            </div>
            <div class="amount-box">
              <div class="amount">7000</div>
            </div>
            <div class="real-amount-box">
              <div class="real-amount">70000</div>
            </div>
          </div>
        </div>
        <div class="btn-box">
          <button class="cancel-btn">삭제</button>
          <button class="buy-btn">구매</button>
        </div>
        <div class="buy-text">
          *장바구니 제품은 30일간 보관됩니다.<br /><br />
          *더 오래 보관하려면 [좋아요]로 등록하세요.<br /><br />
          *장바구니 제품은 품절되면 자동으로 목록에서 삭제됩니다.
        </div>

  `;
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
        <div class="history-drop-down">
          <select name="drop-down-select" id="drop-down-select">
            <option value="전체">전체</option>
            <option value="주문접수">주문접수</option>
            <option value="결제완료">결제완료</option>
            <option value="상품준비중">상품준비중</option>
            <option value="배송중">배송중</option>
            <option value="배송완료">배송완료</option>
            <option value="취소/교환/반품">취소/교환/반품</option>
          </select>
        </div>
        <div class="purchase-history-box">
          <div class="history-title">
            <div class="history-date">주문일</div>
            <div class="history-product">상품정보</div>
            <div class="history-quantity">수량</div>
            <div class="history-amount">상품금액</div>
            <div class="history-progress">진행상황</div>
          </div>
          <div class="history-real">
            <div class="real-date">01.21</div>
            <div class="real-product">
              <img
                src="https://static-storychat.pstatic.net/2020/8/30/27/1149627_hlbna0be8nm00.png?type=rsc5"
                alt=""
                class="real-product-img"
              />
              <div class="real-product-name">붕어빵</div>
            </div>
            <div class="real-quantity">1박스 10개입</div>
            <div class="real-amount">100,000,000</div>
            <div class="real-progress">짱구가 붕어 잡는중~</div>
          </div>     
        </div>
        <div class="coopang-box">
           <img src="../img/coopang.png" alt="" class="coopang-img" />
          </div>
  `;
}

let BasketBtn = document.getElementById("my-basket-btn");
let payBtn = document.getElementById("my-pay-btn");

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
