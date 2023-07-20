$(document).ready(function () {
  $("#my-community-text").children().first().addClass("selected");
  $("#my-hairshop-text").children().first().removeClass("selected");
  $("#my-product-text").children().first().removeClass("selected");
  $("#my-style-text").children().first().removeClass("selected");
  $("#my-careshop-text").children().first().removeClass("selected");

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

  $('.pagination').on('click', '.li_care', function (e){
    e.preventDefault();

    let number = $(this).text();
    careShopPage(number);
  });


});

// 좋아요 이미지 처리
// function LikeImg() {
//   $(".communityList").ready(function () {
//     $(".buttons").click(function () {
//       // console.log("클릭 한다잇");
//       var buttonImg = $(this).find(".like");
//
//       if (buttonImg.hasClass("active")) {
//         buttonImg.removeClass("active");
//         buttonImg.css("background-image", "url('../img/heart2.png')");
//       } else {
//         buttonImg.addClass("active");
//         buttonImg.css("background-image", "url('../img/heart1.png')");
//       }
//     });
//   });
// }

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
      communityCancle();
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

// 케어샵 좋아요
$("#my-careshop-text").on("click", function(){
  careShopPage(1);
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
      hairCancle();

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
      productCancle();

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
      hairShopCancle();

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

// 케어샵 좋아요 모음
function careShopPage(page) {
  let tagList = '';
  $.ajax({
    url: `/users/likeCareShop/${page}`,
    type: "GET",
    success: function (result) {
      tagList = getCareShop(result.likeCare);
      $(".communityList").html(tagList);
      careShopCancle();

      let pageNum = '';
      let pageinfo = result.pageinfo;

      if (pageinfo.prev) {
        pageNum += `<li class="li_care"><a href="#" class="prev">&laquo;</a></li>`;
      }

      for (let i = pageinfo.startPage; i <= pageinfo.endPage; i++) {
        if (pageinfo.criteria.page == i) {
          pageNum += `<li class="li_care"><a href="#" class="active">${i}</a></li>`;
        } else {
          pageNum += `<li class="li_care"><a href="#" >${i}</a></li>`;
        }
      }

      if (pageinfo.next) {
        pageNum += `<li class="li_care"><a href="#" class="next">&raquo;</a></li>`;
      }

      $('.pagination ul').html(pageNum);
    }
  });
}


// 커뮤니티 좋아요
function getCommunity(obj) {
  console.log(obj)
  let text = '';

  if (obj.length === 0) {
    text += `
      <tbody style="margin: 80px auto;">
        <tr>
          <td colspan="5" class="null-text">좋아요한 게시글이 없습니다.</td>
        </tr>
      </tbody>`;
  } else {

    text += `<ul class="ListUl">`;

    for (let i = 0; i < obj.length; i++) {
      text += `
      <!-- 첫번째 -->
      <li class="ListLi">
        <div class="profile">
          <a href="#">
                <div ${obj[i].userFileName ? 'style="display: none;"' : ''} class="profiles profile-img">
                  <img src="https://www.studiopeople.kr/common/img/default_profile.png" alt="임시 썸네일" class="profile-img-img"/>
                </div>
                <div ${obj[i].userFileName ? '' : 'style="display: none;"'} class="profiles profile-img">
                  <img class="profile-img-img" src="/upload/${obj[i].userFileUploadPath}/th_${obj[i].userFileUuid}_${obj[i].userFileName}" alt="">
                </div>
            <p class="profiles profile-nick">${obj[i].userNickName}</p>
          </a>
          <div class="buttons">
            <!-- <button id="basketButton" type="button" class="basket">구매</button> -->
            <button type="button" class="like" value="${obj[i].boardNumber}">하트</button>
          </div>
        </div>
        <a href="/board/communityRead?boardNumber=${obj[i].boardNumber}">
          <div class="img-list">
            <div ${obj[i].boardFileName ? 'style="display: none;"' : ''} class="main-img">
             <img src="/img/no-image-box.png" alt="썸네일">
            </div>
            <div ${obj[i].boardFileName ? '' : 'style="display: none;"'} class="main-img">
              <img src="/upload/${obj[i].boardFileUploadPath}/th_${obj[i].boardFileUuid}_${obj[i].boardFileName}"/>           
            </div>
          </div>
        </a>
        <div class="titleAndCnt">
          <p class="community-title">${obj[i].boardTitle}</p>
          <div class="count">
            <span class="reply"
              >댓글 <span class="replyCnt">${obj[i].replyCnt}</span></span
            >
            <span class="view"
              >조회수 <span class="viewCnt" >${obj[i].boardViewCnt}</span></span
            >
          </div>
        </div>
      </li>
      `;
    }
  }
  text+= `</ul>`;

  return text;
}

// 미용실 좋아요
function getHairShop(obj) {
  console.log(obj)
  let text = '';

  if (obj.length === 0) {
    text += `
      <tbody style="margin: 80px auto;">
        <tr>
          <td colspan="5" class="null-text">좋아요한 미용실이 없습니다.</td>
        </tr>
      </tbody>`;
  } else {

    text += `<ul class="ListUl">`;

    for (let i = 0; i < obj.length; i++) {
      text += `
      <li class="ListLi">
          <a href="/hairshop/read?hairShopNumber=${obj[i].hairShopNumber}">
              <div class="img-list">
                  <div ${obj[i].hairShopFileName ? 'style="display: none;"' : ''} class="main-img">
                   <img src="/img/no-image-box.png" alt="썸네일">
                  </div>
                  <div ${obj[i].hairShopFileName ? '' : 'style="display: none;"'} class="main-img">
                    <img src="/upload/${obj[i].hairShopFileUploadPath}/th_${obj[i].hairShopFileUuid}_${obj[i].hairShopFileName}" alt="">          
                  </div>
              </div>
          </a>
          <div class="titleAndBtn">
              <p class="shop-title">${obj[i].hairShopName}</p>
              <div class="buttons">
                  <button type="button" class="like" value="${obj[i].hairShopNumber}">하트</button>
              </div>
          </div>
          <div class="address-box">
              <span class="address">${obj[i].hairShopAddress}</span>
          </div>
      </li>
  `;
    }
  }
  text+= `</ul>`;

  return text;
}

function getCareShop(obj) {
  console.log(obj)
  let text = '';

  if (obj.length === 0) {
    text += `
      <tbody style="margin: 80px auto;">
        <tr>
          <td colspan="5" class="null-text">좋아요한 케어샵이 없습니다.</td>
        </tr>
      </tbody>`;
  } else {

    text += `<ul class="ListUl">`;

    for (let i = 0; i < obj.length; i++) {
      text += `
      <li class="ListLi">
          <a href="/read?careShopNumber=${obj[i].careShopNumber}">
              <div class="img-list">
                  <div ${obj[i].careShopFileName ? 'style="display: none;"' : ''} class="main-img">
                   <img src="/img/no-image-box.png" alt="썸네일">
                  </div>
                  <div ${obj[i].careShopFileName ? '' : 'style="display: none;"'} class="main-img">
                    <img src="/upload/${obj[i].careShopFileUploadPath}/th_${obj[i].careShopFileUuid}_${obj[i].careShopFileName}" alt="썸네일">
                  </div>
              </div>
          </a>
          <div class="titleAndBtn">
              <p class="shop-title">${obj[i].careShopName}</p>
              <div class="buttons">
                  <button type="button" class="like" value="${obj[i].careShopNumber}">하트</button>
              </div>
          </div>
          <div class="address-box">
              <span class="address">${obj[i].careShopAddress}</span>
          </div>
      </li>
  `;
    }
  }
  text+= `</ul>`;

  return text;
}



function getProduct(obj) {
  console.log(obj)
  let text = '';

  if (obj.length === 0) {
    text += `
      <tbody style="margin: 80px auto;">
        <tr>
          <td colspan="5" class="null-text">좋아요한 제품이 없습니다.</td>
        </tr>
      </tbody>`;
  } else {
  text += `<ul class="ListUl">`;

  for(let i=0; i<obj.length; i++) {
      text += `
            <!-- 첫번째 -->
            <li class="ListLi">
              <a href="/store/productRead?storeNumber=${obj[i].storeNumber}">
                <div class="img-list">
                  <div class="main-img">
                    <div ${obj[i].storeFileName ? 'style="display: none;"' : ''} class="main-img">
                     <img src="/img/no-image-box.png" alt="썸네일">
                    </div>
                    <div ${obj[i].storeFileName ? '' : 'style="display: none;"'} class="main-img">
                      <img
                      src="/upload/${obj[i].storeFileUploadPath}/th_${obj[i].storeFileUuid}_${obj[i].storeFileName}"
                      alt="제품 이미지"
                    />                    
                    </div>   
                  </div>
                </div>
              </a>
              <div class="titleAndBnt">
                <p class="product-title">${obj[i].storeTitle}</p>
                <div class="profile">
                  <div class="buttons">
                    <button type="button" class="like" value="${obj[i].storeNumber}">하트</button>
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
  }
  text+= `</ul>`;

  return text;
}

function getStyle(obj) {
  console.log(obj)
  let text = '';

  if (obj.length === 0) {
    text += `
      <tbody style="margin: 80px auto;">
        <tr>
          <td colspan="5" class="null-text">좋아요한 스타일이 없습니다.</td>
        </tr>
      </tbody>`;
  } else {

    text += `<ul class="ListUl">`;

    for (let i = 0; i < obj.length; i++) {
      text += `
            <!-- 첫번째 -->
            <li class="ListLi">
              <a href="/hair/hairStyleRead?hairNumber=${obj[i].hairNumber}">
                <div class="img-list">
                  <div ${obj[i].hairFileName ? 'style="display: none;"' : ''} class="main-img">
                   <img src="/img/no-image-box.png" alt="썸네일">
                  </div>
                  <div ${obj[i].hairFileName ? '' : 'style="display: none;"'} class="main-img">
                    <img src="/upload/${obj[i].hairFileUploadPath}/th_${obj[i].hairFileUuid}_${obj[i].hairFileName}" alt="헤어스타일">
                  </div>
                </div>
              </a>
              <div class="hairTitle">
                <p class="product-title">${obj[i].hairName}</p>
                <div class="buttons">
                  <button type="button" class="like" value="${obj[i].hairNumber}">하트</button>
                </div>
              </div>
            </li>

  `;
    }
  }
  text+= `</ul>`;

  return text;
}

let hairBtn = document.getElementById("my-hairshop-text");
let careBtn = document.getElementById("my-careshop-text");
let productBtn = document.getElementById("my-product-text");
let styleBtn = document.getElementById("my-style-text");
let communityBtn = document.getElementById("my-community-text");

hairBtn.addEventListener("click", function () {
  hairBtn.querySelector(".active-banner").classList.add("selected");
  productBtn.querySelector(".active-banner").classList.remove("selected");
  styleBtn.querySelector(".active-banner").classList.remove("selected");
  communityBtn.querySelector(".active-banner").classList.remove("selected");
  careBtn.querySelector(".active-banner").classList.remove("selected");
});

productBtn.addEventListener("click", function () {
  productBtn.querySelector(".active-banner").classList.add("selected");
  hairBtn.querySelector(".active-banner").classList.remove("selected");
  styleBtn.querySelector(".active-banner").classList.remove("selected");
  communityBtn.querySelector(".active-banner").classList.remove("selected");
  careBtn.querySelector(".active-banner").classList.remove("selected");
});

styleBtn.addEventListener("click", function () {
  styleBtn.querySelector(".active-banner").classList.add("selected");
  productBtn.querySelector(".active-banner").classList.remove("selected");
  hairBtn.querySelector(".active-banner").classList.remove("selected");
  communityBtn.querySelector(".active-banner").classList.remove("selected");
  careBtn.querySelector(".active-banner").classList.remove("selected");
});

communityBtn.addEventListener("click", function () {
  communityBtn.querySelector(".active-banner").classList.add("selected");
  productBtn.querySelector(".active-banner").classList.remove("selected");
  styleBtn.querySelector(".active-banner").classList.remove("selected");
  hairBtn.querySelector(".active-banner").classList.remove("selected");
  careBtn.querySelector(".active-banner").classList.remove("selected");
});

careBtn.addEventListener("click", function () {
  careBtn.querySelector(".active-banner").classList.add("selected");
  productBtn.querySelector(".active-banner").classList.remove("selected");
  styleBtn.querySelector(".active-banner").classList.remove("selected");
  hairBtn.querySelector(".active-banner").classList.remove("selected");
  communityBtn.querySelector(".active-banner").classList.remove("selected");
});






// 커뮤니티 좋아요 처리
function communityCancle() {
  // 좋아요 취소 처리
  $(document).ready(function () {
    $(".button").click(function () {
      $(".button").removeClass("active");
      $(this).addClass("active");
    });
  });

  $(document).ready(function () {
    $.ajax({
      url: "/likes/check",
      type: "GET",
      contentType: "application/json",
      success: function (likeList) {
        console.log(likeList);

        // 좋아요 버튼들에 대한 처리
        $(".like").each(function () {
          var buttonImg = $(this);
          var boardNumber = buttonImg.val();

          if (likeList.includes(Number(boardNumber))) {
            buttonImg.addClass("active");
            buttonImg.css("background-image", "url('/img/heart2.png')");
          } else {
            buttonImg.removeClass("active");
            buttonImg.css("background-image", "url('/img/heart1.png')");
          }
        });
      }
    });


    $(".like").on('click', function () {
      console.log("like 버튼 클릭 !!!!");
      var buttonImg = $(this);
      var boardNumber = $(this).val();
      console.log(buttonImg);
      console.log(boardNumber);

      if (buttonImg.hasClass("active")) {
        $.ajax({
          url: "/likes/delete",
          type: "DELETE",
          contentType: "application/json",
          data: JSON.stringify({boardNumber: boardNumber}),
          success: function () {
            console.log("빼기 성공");
          }
        });

        buttonImg.removeClass("active");
        buttonImg.css("background-image", "url('/img/heart1.png')");
      } else {
        $.ajax({
          url: "/likes/add",
          type: "POST",
          contentType: "application/json",
          data: JSON.stringify({boardNumber: boardNumber}),
          success: function () {
            console.log("더하기 성공");
          }
        });

        buttonImg.addClass("active");
        buttonImg.css("background-image", "url('/img/heart2.png')");
      }
    });
  });
}


// 미용실 좋아요 처리
function hairShopCancle() {
  // 좋아요 취소 처리
  $(document).ready(function () {
    $(".button").click(function () {
      $(".button").removeClass("active");
      $(this).addClass("active");
    });
  });

  $(document).ready(function () {
    $.ajax({
      url: "/hairshopLike/check",
      type: "GET",
      contentType: "application/json",
      success: function (likeList) {
        console.log(likeList);

        // 좋아요 버튼들에 대한 처리
        $(".like").each(function () {
          var buttonImg = $(this);
          var hairShopNumber = buttonImg.val();

          if (likeList.includes(Number(hairShopNumber))) {
            buttonImg.addClass("active");
            buttonImg.css("background-image", "url('/img/heart2.png')");
          } else {
            buttonImg.removeClass("active");
            buttonImg.css("background-image", "url('/img/heart1.png')");
          }
        });
      }
    });


    $(".like").on('click', function () {
      console.log("like 버튼 클릭 !!!!");
      var buttonImg = $(this);
      var hairShopNumber = $(this).val();
      console.log(buttonImg);
      console.log(hairShopNumber);

      if (buttonImg.hasClass("active")) {
        $.ajax({
          url: "/hairshopLike/subtract",
          type: "DELETE",
          contentType: "application/json",
          data: JSON.stringify({hairShopNumber: hairShopNumber}),
          success: function () {
            console.log("빼기 성공");
          }
        });

        buttonImg.removeClass("active");
        buttonImg.css("background-image", "url('/img/heart1.png')");
      } else {
        $.ajax({
          url: "/hairshopLike/add",
          type: "POST",
          contentType: "application/json",
          data: JSON.stringify({hairShopNumber: hairShopNumber}),
          success: function () {
            console.log("더하기 성공");
          }
        });

        buttonImg.addClass("active");
        buttonImg.css("background-image", "url('/img/heart2.png')");
      }
    });
  });
}

// 케어샵 좋아요 처리
function careShopCancle() {
  // 좋아요 취소 처리
  $(document).ready(function () {
    $(".button").click(function () {
      $(".button").removeClass("active");
      $(this).addClass("active");
    });
  });

  $(document).ready(function () {
    $.ajax({
      url: "/careshopLike/check",
      type: "GET",
      contentType: "application/json",
      success: function (likeList) {
        console.log(likeList);

        // 좋아요 버튼들에 대한 처리
        $(".like").each(function () {
          var buttonImg = $(this);
          var careShopNumber = buttonImg.val();

          if (likeList.includes(Number(careShopNumber))) {
            buttonImg.addClass("active");
            buttonImg.css("background-image", "url('/img/heart2.png')");
          } else {
            buttonImg.removeClass("active");
            buttonImg.css("background-image", "url('/img/heart1.png')");
          }
        });
      }
    });


    $(".like").on('click', function () {
      console.log("like 버튼 클릭 !!!!");
      var buttonImg = $(this);
      var careShopNumber = $(this).val();
      console.log(buttonImg);
      console.log(careShopNumber);

      if (buttonImg.hasClass("active")) {
        $.ajax({
          url: "/careshopLike/subtract",
          type: "DELETE",
          contentType: "application/json",
          data: JSON.stringify({careShopNumber: careShopNumber}),
          success: function () {
            console.log("빼기 성공");
          }
        });

        buttonImg.removeClass("active");
        buttonImg.css("background-image", "url('/img/heart1.png')");
      } else {
        $.ajax({
          url: "/careshopLike/add",
          type: "POST",
          contentType: "application/json",
          data: JSON.stringify({careShopNumber: careShopNumber}),
          success: function () {
            console.log("더하기 성공");
          }
        });

        buttonImg.addClass("active");
        buttonImg.css("background-image", "url('/img/heart2.png')");
      }
    });
  });
}

// 제품 좋아요 처리
function productCancle() {
  // 좋아요 취소 처리
  $(document).ready(function () {
    $(".button").click(function () {
      $(".button").removeClass("active");
      $(this).addClass("active");
    });
  });

  $(document).ready(function () {
    $.ajax({
      url: "/storeLike/check",
      type: "GET",
      contentType: "application/json",
      success: function (likeList) {
        console.log(likeList);

        // 좋아요 버튼들에 대한 처리
        $(".like").each(function () {
          var buttonImg = $(this);
          var storeNumber = buttonImg.val();

          if (likeList.includes(Number(storeNumber))) {
            buttonImg.addClass("active");
            buttonImg.css("background-image", "url('/img/heart2.png')");
          } else {
            buttonImg.removeClass("active");
            buttonImg.css("background-image", "url('/img/heart1.png')");
          }
        });
      }
    });


    $(".like").on('click', function () {
      console.log("like 버튼 클릭 !!!!");
      var buttonImg = $(this);
      var storeNumber = $(this).val();
      console.log(buttonImg);
      console.log(storeNumber);

      if (buttonImg.hasClass("active")) {
        $.ajax({
          url: "/storeLike/subtract",
          type: "DELETE",
          contentType: "application/json",
          data: JSON.stringify({storeNumber: storeNumber}),
          success: function () {
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
          data: JSON.stringify({storeNumber: storeNumber}),
          success: function () {
            console.log("더하기 성공");
          }
        });

        buttonImg.addClass("active");
        buttonImg.css("background-image", "url('/img/heart2.png')");
      }
    });
  });
}

// 스타일 좋아요 처리
function hairCancle() {
  // 좋아요 취소 처리
  $(document).ready(function () {
    $(".button").click(function () {
      $(".button").removeClass("active");
      $(this).addClass("active");
    });
  });

  $(document).ready(function () {
    $.ajax({
      url: "/hairLike/check",
      type: "GET",
      contentType: "application/json",
      success: function (likeList) {
        console.log(likeList);

        // 좋아요 버튼들에 대한 처리
        $(".like").each(function () {
          var buttonImg = $(this);
          var hairNumber = buttonImg.val();

          if (likeList.includes(Number(hairNumber))) {
            buttonImg.addClass("active");
            buttonImg.css("background-image", "url('/img/heart2.png')");
          } else {
            buttonImg.removeClass("active");
            buttonImg.css("background-image", "url('/img/heart1.png')");
          }
        });
      }
    });


    $(".like").on('click', function () {
      console.log("like 버튼 클릭 !!!!");
      var buttonImg = $(this);
      var hairNumber = $(this).val();
      console.log(buttonImg);
      console.log(hairNumber);

      if (buttonImg.hasClass("active")) {
        $.ajax({
          url: "/hairLike/subtract",
          type: "DELETE",
          contentType: "application/json",
          data: JSON.stringify({hairNumber: hairNumber}),
          success: function () {
            console.log("빼기 성공");
          }
        });

        buttonImg.removeClass("active");
        buttonImg.css("background-image", "url('/img/heart1.png')");
      } else {
        $.ajax({
          url: "/hairLike/add",
          type: "POST",
          contentType: "application/json",
          data: JSON.stringify({hairNumber: hairNumber}),
          success: function () {
            console.log("더하기 성공");
          }
        });

        buttonImg.addClass("active");
        buttonImg.css("background-image", "url('/img/heart2.png')");
      }
    });
  });
}

$('.my-like').css("color", "#FFFFFF");
$('.my-like').css("background-color", "#222");