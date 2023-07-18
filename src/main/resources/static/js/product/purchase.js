let rowCount = 0;
let buyCnt = 0;
let basketNumbers = [];

// 장바구니에서 가져온 구매할 상품 띄우기
$.ajax({
    url: '/stores/basketList',
    type: 'GET',
    success: function(data) {
        let text = '';
        let resultPrice = 0;

        for(let i = 0; i < data.length; i++) {
            var src = "/upload/" + data[i].storeFileUploadPath + "/th_" + data[i].storeFileUuid + "_" + data[i].storeFileName;
            text += `
            <tr>
                <td>
                    <img src=${src} alt="상품">
                    <p class="test-product">${data[i].storeTitle}</p>
                </td>
                <td class="test-count">${data[i].basketCnt}</td>
                <td class="test-price">${data[i].storePrice}</td>
                <td class="test-result">${data[i].basketCnt * data[i].storePrice}</td>
                <input type="hidden" class="store-number" value="${data[i].storeNumber}">
                <input type="hidden" class="basket-number" value="${data[i].basketNumber}">
            </tr>
            `;
            resultPrice += data[i].basketCnt * data[i].storePrice;
            rowCount++;
            setTimeout(function() {
                buyCnt = parseInt($('.test-count').eq(i).text(), 10);
                basketNumbers.push($(".basket-number").eq(i).val());
            }, 500);
        }
        $(".tbody").html(text);
        $('.price-number').text(resultPrice);

        if(resultPrice <= 50000){
            $('.delivery-number').text(3000);
            $('.final-price-number').text(resultPrice + 3000);
        }else{
            $('.delivery-number').text(0);
            $('.final-price-number').text(resultPrice);
        }
    }
});


// 드롭다운 박스 설정
$(document).ready(function() {
    $('.dropdown').click(function() {
      $(this).find('.dropdown-content').toggle();
    });
  
    $(document).click(function(e) {
      var target = e.target;
      if (!$(target).is('.dropdown') && !$(target).parents().is('.dropdown')) {
        $('.dropdown-content').hide();
      }
    });
});

$('.dropdown-content li').on('click', function(){
  let $input = $('.require-input');
  if($(this).is('.li-write')){
    $input.val('');
    $input.attr('readonly', false);
    return;
  }

  $input.attr('readonly',true);
  let text = $(this).text();
  $input.val(text);
});


// 가격에 천 단위마다 컴마
function comma(str) {
  str = String(str);
  return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
}

function uncomma(str) {
  str = String(str);
  return str.replace(/[^\d]+/g, '');
} 


// 우편번호 및 주소 API 추가
function sample6_execDaumPostcode() {
  new daum.Postcode({
      oncomplete: function(data) {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 각 주소의 노출 규칙에 따라 주소를 조합한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          var addr = ''; // 주소 변수
          var extraAddr = ''; // 참고항목 변수

          //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
          if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
              addr = data.roadAddress;
          } else { // 사용자가 지번 주소를 선택했을 경우(J)
              addr = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if(data.userSelectedType === 'R'){
              // 법정동명이 있을 경우 추가한다. (법정리는 제외)
              // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
              if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                  extraAddr += data.bname;
              }
              // 건물명이 있고, 공동주택일 경우 추가한다.
              if(data.buildingName !== '' && data.apartment === 'Y'){
                  extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
              }
              // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
              if(extraAddr !== ''){
                  extraAddr = ' (' + extraAddr + ')';
              }
              // 조합된 참고항목을 해당 필드에 넣는다.
              document.getElementById("sample6_extraAddress").value = extraAddr;
          
          } else {
              document.getElementById("sample6_extraAddress").value = '';
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          document.getElementById('sample6_postcode').value = data.zonecode;
          document.getElementById("sample6_address").value = addr;
          // 커서를 상세주소 필드로 이동한다.
          document.getElementById("sample6_detailAddress").focus();
      }
  }).open();
}


// 결제 API
var IMP = window.IMP;
IMP.init("imp80646252"); // 가맹점 식별코드

var today = new Date();
var hours = today.getHours(); // 시
var minutes = today.getMinutes();  // 분
var seconds = today.getSeconds();  // 초
var milliseconds = today.getMilliseconds();
var makeMerchantUid = hours + minutes + seconds + milliseconds;

let buyArray = [];

function requestPay() {
    IMP.request_pay({
        pg: 'html5_inicis', // PG사 코드표에서 선택
        pay_method: 'card', // 결제 방식
        merchant_uid: "IMP" + makeMerchantUid, // 결제 고유 번호
        name: $('.test-product:first').text() + " 외 " + (rowCount - 1) + "개", // 제품명
        /*amount : $('.final-price-number).text(), // 사용할 가격*/
        amount: 10, // 연결 확인을 위해 사용한 가격 확인 후 지우기

        buyer_email: '',
        buyer_name: $('#userName').val(),
        buyer_tel: $('#userPhoneNumber').val(),
        buyer_addr: $('#sample6_address').val() + $('#sample6_detailAddress').val() + $('#sample6_extraAddress').val(),
        buyer_postcode: $('#sample6_postcode').val()
    }, function(rsp) { // callback
        if (rsp.success) {
            console.log(rsp);
            let buyInfo = {};
            for (let i = 0; i < rowCount; i++) {
                buyInfo = {
                    buyName: $('#userName').val(),
                    buyPhoneNumber: $('#userPhoneNumber').val(),
                    buyPostCode: $('#sample6_postcode').val(),
                    buyAddress: $('#sample6_address').val(),
                    buyAddressDetail: $('#sample6_detailAddress').val(),
                    buyReference: $('#sample6_extraAddress').val(),
                    buyCnt: buyCnt,
                    buyMsg: $('.require-input').val(),
                    storeNumber: $('.store-number').eq(i).val()
                };
                buyArray.push(buyInfo);
                console.log(buyInfo);
            };

            $.ajax({
                url: '/stores/buyOk',
                data: JSON.stringify(buyArray),
                contentType: 'application/json; charset=utf-8',
                type: 'POST',
                traditional: true,
                success: function(result) {
                    //페이지 이동
                    $.ajax({
                        url: '/stores/remove',
                        type: 'delete',
                        traditional: true,
                        data: JSON.stringify(basketNumbers),
                        contentType: "application/json;charset=utf-8",
                        success: function () {
                            window.location.href = "/user/myBasket";
                            $(document).ready(function () {
                                mainBasket2();
                            });
                        }
                    });
                }
            });
        } else {
            console.log(rsp);
        }
    });
}