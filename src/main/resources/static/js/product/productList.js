// 장바구니 클릭시 나타나는 문구
$(".basket").click(function () {
  alert("장바구니에 추가하였습니다!");
});

$(document).ready(function () {
  $(".buttons").click(function () {
    var buttonImg = $(this).find(".like");
    var storeNumber = $(this).find(".like").val();

    if (buttonImg.hasClass("active")) {
      $.ajax({
        url: "/storeLike/subtract",
        type: "DELETE",
        contentType: "application/json",
        data: JSON.stringify({ storeNumber: storeNumber }),
        success: function(){
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
          console.log("더하기 성공");
        }
      });

      buttonImg.addClass("active");
      buttonImg.css("background-image", "url('/img/heart2.png')");
    }
  });
});

const buttons = document.querySelectorAll(".category button");

buttons.forEach((button) => {
  button.addEventListener("click", () => {
    buttons.forEach((btn) => {
      btn.classList.remove("active");
      btn.style.color = ""; // 모든 버튼의 텍스트 색상을 기본값으로 재설정합니다.
    });
    button.classList.add("active");
    button.style.color = "#222"; // 클릭한 버튼의 텍스트 색상을 검은색으로 설정합니다.
    button.style.fontWeight = "600";
  });
});

// "전체" 버튼을 초기에 선택한 상태로 설정합니다.
const allButton = document.querySelector(".category button:first-child");
allButton.classList.add("active");
allButton.style.color = "#222";
allButton.style.fontWeight = "600";

// 드롭다운
// 드롭다운 박스
$(document).ready(function() {
  $('.dropdown').click(function() {
    $(this).find('.dropdown-menu').toggle();
  });

  $(document).click(function(e) {
    var target = e.target;
    if (!$(target).is('.dropdown') && !$(target).parents().is('.dropdown')) {
      $('.dropdown-menu').hide();
    }
  });
});

$(".dropdown-menu li").click(function() {
    var selectedItem = $(this).text();
    $('.dropdown-btn').html(selectedItem + `
        <span class="material-symbols-rounded">
          expand_more
        </span>
    `);
});

let obj = {};

$(".category-btn").on("click", function (){
  console.log("클릭했어")
  obj = {storeCategoryNumber : $(this).val()};
  console.log("카테고리 =========== " + obj.storeCategoryNumber);
  searchModule(1, obj, showSearchResult, paging);
});

$(".btn-drop").on("click", function (){
  console.log("이것도 클릭했다")
  // obj = {storeCategoryNumber : $(this).val(),
  //     sortingType : $(this).val()};
  obj.sortingType = $(this).data('sort-type');
  console.log("this ============== " + this);
  console.log("sortingType ============= " + obj.sortingType);
  searchModule(1, obj, showSearchResult, paging)
})

function searchModule(page, obj, callback, paging){
  $.ajax({
    url : `/storeR/productSearchList/${page}`,
    type : 'get',
    data : obj,
    dataType : 'json',
    success : function (result){
      if (callback){
        callback(result);
        paging(result);
      }
    },
    error : function (a, b, c){
      console.error(c);
    }
  });
}

function showSearchResult(result){
  console.log(result);

  let  productList = result.productList;

  $(".ListUl").html('');
  for (let i = 0; i < productList.length; i++){
    $('.ListUl').append(`
       <li class="ListLi">
              <div class="store-category-number"style="display: none;"> ${productList[i].storeCategoryNumber} </div>
              <a href="/store/productRead?storeNumber=${productList[i].storeNumber}">
                <div class="img-list">
                  <div class="main-img">
                    <img src="${'/upload/' + productList[i].storeFileUploadPath + '/th_' + productList[i].storeFileUuid + '_' + productList[i].storeFileName }" alt="제품 이미지">
                  </div>
                </div>
              </a>
              <div class="titleAndBnt">
                <p class="product-title">${productList[i].storeTitle}</p>
                <div class="profile">
                  <button id="basketButton" type="button" class="basket">
                    구매
                  </button>
                  <div class="buttons">
                    <button type="button" class="like">하트</button>
                  </div>
                </div>
              </div>
              <div class="productInformation">
                <p class="productCate">${productList[i].storeCategoryName}</p>
                <p class="productPrice">₩ <span class="price">${productList[i].storePrice}</span></p>
              </div>
            </li>
    `);
  }
}

// 페이징
function paging(result) {
  let pageInfo = result.page;
  let text = '';

  text += `
      ${pageInfo.prev ?
      '<a href="javascript:void(0)" class="prev" onclick="searchModule(' + (pageInfo.startPage - 1) + ',obj,showSearchResult,paging)"><li>&laquo;</li></a>'
      : ''}
    `;

  for (let i = pageInfo.startPage; i <= pageInfo.endPage; i++) {
    text += `
        <a href="javascript:void(0)" onclick="searchModule(${i},obj,showSearchResult,paging)">
        ${pageInfo.criteria.page == i ?
        '<li class="active">' + i + '</li>'
        :
        '<li>' + i + '</li>'
    }
        </a>
      `;
  }

  text += `
      ${pageInfo.next ?
      '<a href="javascript:void(0)" class="next" onclick="searchModule(' + (pageInfo.endPage + 1) + ',obj,showSearchResult,paging)"><li>&raquo;</li></a>'
      : ''}
    `;

  $('.pagination > ul').html(text);
}
