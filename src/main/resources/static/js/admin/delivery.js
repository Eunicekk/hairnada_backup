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

// 일단 테스트 용으로 한거임~~~ 나중에 처리 다시해야돼용 ~~
$(".order-cnt").on("click", function () {
  $(".delivery-status").html("");
  $(".delivery-status").append(`<select name="delivery" class="delivery">
  <option value="">배송 상태</option>
  <option value="preparing-product">상품 준비중</option>
  <option value="shipping">배송중</option>
  <option value="completed">배송 완료</option>
  <option value="cancel">취소/교환/반품</option>
</select>
<button type="submit" class="registration">등록</button>`);
});

$(".completed-cnt").on("click", function () {
  let text = "배송 완료";
  $(".delivery-status").html("");
  $(".delivery-status").append(text);
});

// select option 값 뽑아오기

let test; // select 안에 들어있는 option value 담을 변수 선언

$(".delivery").on("change", function () {
  test = $(this).val(); // select option value 뽑아서 변수에 값 넣어주기
  // 담은 값으로 백 작업 하면 됩니당~~~
});

$(".registration").on("click", function () {
  console.log(test); // 테스트로 해봤어요 ~
});
