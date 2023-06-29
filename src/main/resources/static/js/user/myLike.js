$(document).ready(function () {
  $("#my-community-text").children().first().addClass("selected");
  $("#my-hairshop-text").children().first().removeClass("selected");
  $("#my-product-text").children().first().removeClass("selected");
  $("#my-style-text").children().first().removeClass("selected");

  $('.pagination').on('click', '.li__like', function (e){
    e.preventDefault();

    let number = $(this).text();
    communityPage(number);
  });

  $('.pagination').on('click', '.li__hair', function (e){
    e.preventDefault();

    let number = $(this).text();
    hairPage(number);
  });

  $('.pagination').on('click', '.li__hair_shop', function (e){
    e.preventDefault();

    let number = $(this).text();
    hairShopPage(number);
  });

  $('.pagination').on('click', '.li_store', function (e){
    e.preventDefault();

    let number = $(this).text();
    storePage(number);
  });


});

function LikeImg() {
  $(".communityList").ready(function () {
    $(".buttons").click(function () {
      // console.log("클릭 한다잇");
      var buttonImg = $(this).find(".like");

      if (buttonImg.hasClass("active")) {
        buttonImg.removeClass("active");
        buttonImg.css("background-image", "url('../img/heart2.png')");
      } else {
        buttonImg.addClass("active");
        buttonImg.css("background-image", "url('../img/heart1.png')");
      }
    });
  });
}

// 커뮤니티 좋아요 모음
function communityPage(page) {
  if(!page){
    page = 1;
  }

  let tagList = '';
  $.ajax({
    url: `/users/likeCommunity/${page}`,
    type: "GET",
    success: function(result){
      tagList = getCommunity(result.likeboard);
      $(".communityList").html(tagList);
      LikeImg();

      let pageNum = '';
      let pageinfo = result.pageinfo;

      if(pageinfo.prev){
        pageNum += `<li class="li__like"><a href="#" class="prev">&laquo;</a></li>`;
      }

      for(let i= pageinfo.startPage; i<=pageinfo.endPage; i++){
        if(pageinfo.criteria.page == i){
          pageNum += `<li class="li__like"><a href="#" class="active">${i}</a></li>`;
        }else{
          pageNum += `<li class="li__like"><a href="#" >${i}</a></li>`;
        }
      }

      if(pageinfo.next){
        pageNum += `<li class="li__like"><a href="#" class="next">&raquo;</a></li>`;
      }

      $('.pagination ul').html(pageNum);
    }
  });
}

communityPage();

$("#my-community-text").on("click", function(){
  communityPage();
});

// 미용실 좋아요 모음
$("#my-hairshop-text").on("click", function () {
  hairShopPage(1);
});

// 제품 좋아요 모음
$("#my-product-text").on("click", function () {
  storePage(1);

});

// 헤어스타일 좋아요
$("#my-style-text").on("click", function () {
  // $(".communityList").html(getStyle);
  hairPage(1);
});

// 헤어스타일 좋아요 ajax
function hairPage(page){
  let tagList = '';
  $.ajax({
    url: `/users/likeHair/${page}`,
    type: "GET",
    success: function(result){
      tagList = getStyle(result.likeStyle);
      $(".communityList").html(tagList);
      LikeImg();

      let pageNum = '';
      let pageinfo = result.pageinfo;

      if(pageinfo.prev){
        pageNum += `<li class="li__hair"><a href="#" class="prev">&laquo;</a></li>`;
      }

      for(let i= pageinfo.startPage; i<=pageinfo.endPage; i++){
        if(pageinfo.criteria.page == i){
          pageNum += `<li class="li__hair"><a href="#" class="active">${i}</a></li>`;
        }else{
          pageNum += `<li class="li__hair"><a href="#" >${i}</a></li>`;
        }
      }

      if(pageinfo.next){
        pageNum += `<li class="li__hair"><a href="#" class="next">&raquo;</a></li>`;
      }

      $('.pagination ul').html(pageNum);
    }
  });

  // $(document).ready(function () {
  //   $("#likeButton").click(function () {
  //     console.log("버튼이 클릭되었습니다.");
  //     // 추가적인 로직을 이곳에 작성할 수 있습니다.
  //   });
  // });
}

// 제품 좋아요
function storePage(page){
  let tagList = '';
  $.ajax({
    url: `/users/likeStore/${page}`,
    type: "GET",
    success: function (result) {
      tagList = getProduct(result.likeStore);
      $(".communityList").html(tagList);
      LikeImg();

      // 장바구니 클릭시 나타나는 문구
      $(".basket").click(function () {
        alert("장바구니에 추가하였습니다!");
      });


      let pageNum = '';
      let pageinfo = result.pageinfo;

      if (pageinfo.prev) {
        pageNum += `<li class="li_store"><a href="#" class="prev">&laquo;</a></li>`;
      }

      for (let i = pageinfo.startPage; i <= pageinfo.endPage; i++) {
        if (pageinfo.criteria.page == i) {
          pageNum += `<li class="li_store"><a href="#" class="active">${i}</a></li>`;
        } else {
          pageNum += `<li class="li_store"><a href="#" >${i}</a></li>`;
        }
      }

      if (pageinfo.next) {
        pageNum += `<li class="li_store"><a href="#" class="next">&raquo;</a></li>`;
      }

      $('.pagination ul').html(pageNum);
    }
  });
}



// 미용실 좋아요 모음
function hairShopPage(page) {
  let tagList = '';
  $.ajax({
    url: `/users/likeHairShop/${page}`,
    type: "GET",
    success: function (result) {
      tagList = getHairShop(result.likeShop);
      $(".communityList").html(tagList);
      LikeImg();

      let pageNum = '';
      let pageinfo = result.pageinfo;

      if (pageinfo.prev) {
        pageNum += `<li class="li__hair_shop"><a href="#" class="prev">&laquo;</a></li>`;
      }

      for (let i = pageinfo.startPage; i <= pageinfo.endPage; i++) {
        if (pageinfo.criteria.page == i) {
          pageNum += `<li class="li__hair_shop"><a href="#" class="active">${i}</a></li>`;
        } else {
          pageNum += `<li class="li__hair_shop"><a href="#" >${i}</a></li>`;
        }
      }

      if (pageinfo.next) {
        pageNum += `<li class="li__hair_shop"><a href="#" class="next">&raquo;</a></li>`;
      }

      $('.pagination ul').html(pageNum);
    }
  });
}


// 커뮤니티 좋아요
function getCommunity(obj) {
  console.log(obj)
  let text = '';

  text += `<ul class="ListUl">`;

  for(let i=0; i<obj.length; i++){
    text += `
      <!-- 첫번째 -->
      <li class="ListLi">
        <div class="profile">
          <a href="#">
            <div class="profiles profile-img"></div>
            <p class="profiles profile-nick">${obj[i].userNickName}</p>
          </a>
          <div class="buttons">
            <!-- <button id="basketButton" type="button" class="basket">구매</button> -->
            <button type="button" class="like">하트</button>
          </div>
        </div>
        <a href="">
          <div class="img-list">
            <div class="main-img">
                <img src="/upload/${obj[i].boardFileUploadPath}/th_${obj[i].boardFileUuid}_${obj[i].boardFileName}"/>
            </div>
          </div>
        </a>
        <div class="titleAndCnt">
          <p class="community-title">${obj[i].boardTitle}</p>
          <div class="count">
            <span class="reply"
              >댓글 <span class="replyCnt">3</span></span
            >
            <span class="view"
              >조회수 <span class="viewCnt">5</span></span
            >
          </div>
        </div>
      </li>
      `;
  }
  text+= `</ul>`;

  return text;
}

// 미용실 좋아요
function getHairShop(obj) {
  console.log(obj)
  let text = '';

  text += `<ul class="ListUl">`;

  for(let i=0; i<obj.length; i++) {
    text += `
      <li class="ListLi">
          <a href="#">
              <div class="img-list">
                  <div class="main-img">
                      <img src="/upload/${obj[i].hairShopFileUploadPath}/th_${obj[i].hairShopFileUuid}_${obj[i].hairShopFileName}" alt="썸네일">
                    </div>
              </div>
          </a>
          <div class="titleAndBtn">
              <p class="shop-title">${obj[i].hairShopName}</p>
              <div class="buttons">
                  <button type="button" class="like">하트</button>
              </div>
          </div>
          <div class="address-box">
              <span class="address">${obj[i].hairShopAddress}</span>
          </div>
      </li>
  `;
  }
  text+= `</ul>`;

  return text;
}



function getProduct(obj) {
  console.log(obj)
  let text = '';

  text += `<ul class="ListUl">`;

  for(let i=0; i<obj.length; i++){
    text += `
            <!-- 첫번째 -->
            <li class="ListLi">
              <a href="">
                <div class="img-list">
                  <div class="main-img">
                    <img
                      src="/upload/${obj[i].storeFileUploadPath}/th_${obj[i].storeFileUuid}_${obj[i].storeFileName}"
                      alt="제품 이미지"
                    />
                  </div>
                </div>
              </a>
              <div class="titleAndBnt">
                <p class="product-title">${obj[i].storeTitle}</p>
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
                <p class="productCate">${obj[i].storeCategoryName}</p>
                <p class="productPrice">₩ <span class="price">${obj[i].storePrice}</span></p>
              </div>
            </li>

            
  `;
  }
  text+= `</ul>`;

  return text;
}

function getStyle(obj) {
  console.log(obj)
  let text = '';

  text += `<ul class="ListUl">`;

  for(let i=0; i<obj.length; i++) {
    text += `
            <!-- 첫번째 -->
            <li class="ListLi">
              <a href="">
                <div class="img-list">
                  <div class="main-img">
                    <img src="/upload/${obj[i].hairFileUploadPath}/th_${obj[i].hairFileUuid}_${obj[i].hairFileName}" alt="헤어스타일">
                  </div>
                </div>
              </a>
              <div class="hairTitle">
                <p class="product-title">${obj[i].hairName}</p>
                <div class="buttons">
                  <button type="button" class="like">하트</button>
                </div>
              </div>
            </li>

  `;
  }
  text+= `</ul>`;

  return text;
}

let hairBtn = document.getElementById("my-hairshop-text");
let productBtn = document.getElementById("my-product-text");
let styleBtn = document.getElementById("my-style-text");
let communityBtn = document.getElementById("my-community-text");

hairBtn.addEventListener("click", function () {
  hairBtn.querySelector(".active-banner").classList.add("selected");
  productBtn.querySelector(".active-banner").classList.remove("selected");
  styleBtn.querySelector(".active-banner").classList.remove("selected");
  communityBtn.querySelector(".active-banner").classList.remove("selected");
});

productBtn.addEventListener("click", function () {
  productBtn.querySelector(".active-banner").classList.add("selected");
  hairBtn.querySelector(".active-banner").classList.remove("selected");
  styleBtn.querySelector(".active-banner").classList.remove("selected");
  communityBtn.querySelector(".active-banner").classList.remove("selected");
});

styleBtn.addEventListener("click", function () {
  styleBtn.querySelector(".active-banner").classList.add("selected");
  productBtn.querySelector(".active-banner").classList.remove("selected");
  hairBtn.querySelector(".active-banner").classList.remove("selected");
  communityBtn.querySelector(".active-banner").classList.remove("selected");
});

communityBtn.addEventListener("click", function () {
  communityBtn.querySelector(".active-banner").classList.add("selected");
  productBtn.querySelector(".active-banner").classList.remove("selected");
  styleBtn.querySelector(".active-banner").classList.remove("selected");
  hairBtn.querySelector(".active-banner").classList.remove("selected");
});

