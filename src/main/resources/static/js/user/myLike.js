$(document).ready(function () {
  $("#my-community-text").children().first().addClass("selected");
  $("#my-hairshop-text").children().first().removeClass("selected");
  $("#my-product-text").children().first().removeClass("selected");
  $("#my-style-text").children().first().removeClass("selected");
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
function communityPage() {
  $(".communityList").html(getCommunity);
  LikeImg();
}

communityPage();

$("#my-community-text").on("click", communityPage);

// 미용실 좋아요 모음
$("#my-hairshop-text").on("click", function () {
  $(".communityList").html(getHairShop);
  LikeImg();
});

// 제품 좋아요 모음
$("#my-product-text").on("click", function () {
  $(".communityList").html(getProduct);
  LikeImg();

  // 장바구니 클릭시 나타나는 문구
  $(".basket").click(function () {
    alert("장바구니에 추가하였습니다!");
  });
});

// 헤어스타일 좋아요 모음
$("#my-style-text").on("click", function () {
  $(".communityList").html(getStyle);
  LikeImg();

  $(document).ready(function () {
    $("#likeButton").click(function () {
      console.log("버튼이 클릭되었습니다.");
      // 추가적인 로직을 이곳에 작성할 수 있습니다.
    });
  });

  // 모달 테스트
});

// $(".main-join").on("click", ".ok-btn", function () {
//   console.log("click!!!!!!!");
// });

function getCommunity() {
  return `
  <ul class="ListUl">
  <!-- 첫번째 -->
  <li class="ListLi">
    <div class="profile">
      <a href="#">
        <div class="profiles profile-img"></div>
        <p class="profiles profile-nick">닉네임</p>
      </a>
      <div class="buttons">
        <!-- <button id="basketButton" type="button" class="basket">구매</button> -->
        <button type="button" class="like">하트</button>
      </div>
    </div>
    <a href="">
      <div class="img-list">
        <div class="main-img"></div>
      </div>
    </a>
    <div class="titleAndCnt">
      <p class="community-title">제목이여유</p>
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

  <!-- 두번째 -->
  <li class="ListLi">
    <div class="profile">
      <a href="#">
        <div class="profiles profile-img"></div>
        <p class="profiles profile-nick">닉네임</p>
      </a>
      <div class="buttons">
        <!-- <button id="basketButton" type="button" class="basket">구매</button> -->
        <button id="likeButton" type="button" class="like">
          하트
        </button>
      </div>
    </div>
    <a href="">
      <div class="img-list">
        <div class="main-img"></div>
      </div>
    </a>
    <div class="titleAndCnt">
      <p class="community-title">제목이여유</p>
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

  <!-- 테스트 -->
  <li class="ListLi">
    <div class="profile">
      <a href="#">
        <div class="profiles profile-img"></div>
        <p class="profiles profile-nick">닉네임</p>
      </a>
      <div class="buttons">
        <!-- <button id="basketButton" type="button" class="basket">구매</button> -->
        <button id="likeButton" type="button" class="like">
          하트
        </button>
      </div>
    </div>
    <a href="">
      <div class="img-list">
        <div class="main-img"></div>
      </div>
    </a>
    <div class="titleAndCnt">
      <p class="community-title">제목이여유</p>
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

  <!-- 세번째 -->
  <li class="ListLi">
    <div class="profile">
      <a href="#">
        <div class="profiles profile-img"></div>
        <p class="profiles profile-nick">닉네임</p>
      </a>
      <div class="buttons">
        <!-- <button id="basketButton" type="button" class="basket">구매</button> -->
        <button id="likeButton" type="button" class="like">
          하트
        </button>
      </div>
    </div>
    <a href="">
      <div class="img-list">
        <div class="main-img"></div>
      </div>
    </a>
    <div class="titleAndCnt">
      <p class="community-title">제목이여유</p>
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

  <!-- 네번째 -->
  <li class="ListLi">
    <div class="profile">
      <a href="#">
        <div class="profiles profile-img"></div>
        <p class="profiles profile-nick">닉네임</p>
      </a>
      <div class="buttons">
        <!-- <button id="basketButton" type="button" class="basket">구매</button> -->
        <button id="likeButton" type="button" class="like">
          하트
        </button>
      </div>
    </div>
    <a href="">
      <div class="img-list">
        <div class="main-img"></div>
      </div>
    </a>
    <div class="titleAndCnt">
      <p class="community-title">제목이여유</p>
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
</ul>
</div>

<!-- 페이징 처리 -->
<div class="pagination">
<ul>
  <li><a href="#" class="prev">&laquo;</a></li>
  <li><a href="#" class="active">1</a></li>
  <li><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
  <li><a href="#" class="next">&raquo;</a></li>
</ul>
  `;
}

function getHairShop() {
  return `
  <div class="main">
  <!-- 리스트 -->
  <div class="style-content">
      <ul class="style-box">
      <!-- 첫번째 -->
      <li class="ListLi">
          <a href="#">
              <div class="img-list">
                  <div class="main-img">
                      <img src="https://mblogthumb-phinf.pstatic.net/MjAyMTEyMTVfMTg3/MDAxNjM5NTc2MDYzOTU5.t99xzUpgqkooL2EJY11JEEGTdsf23al8EeL7HymsDV4g.qCXPe5Gie7lwD1mdQNglSJvsOoOCD05oW7g7hdRhv-gg.JPEG.se413496/b9a07eb4e1e3a6773d93309164a98f2b.jpg?type=w800" alt="썸네일">
                    </div>
              </div>
          </a>
          <div class="titleAndBtn">
              <p class="shop-title">매장명입니다</p>
              <div class="buttons">
                  <button type="button" class="like">하트</button>
              </div>
          </div>
          <div class="address-box">
              <span class="address">상세 주소 어쩌구 저쩌구</span>
          </div>
      </li>
      <!-- 두번째 -->
      <li class="ListLi">
          <a href="#">
              <div class="img-list">
                  <div class="main-img">
                      <img src="https://mblogthumb-phinf.pstatic.net/MjAyMTEyMTVfMTg3/MDAxNjM5NTc2MDYzOTU5.t99xzUpgqkooL2EJY11JEEGTdsf23al8EeL7HymsDV4g.qCXPe5Gie7lwD1mdQNglSJvsOoOCD05oW7g7hdRhv-gg.JPEG.se413496/b9a07eb4e1e3a6773d93309164a98f2b.jpg?type=w800" alt="썸네일">
                    </div>
              </div>
          </a>
          <div class="titleAndBtn">
              <p class="shop-title">매장명입니다</p>
              <div class="buttons">
                  <button type="button" class="like">하트</button>
              </div>
          </div>
          <div class="address-box">
              <span class="address">상세 주소 어쩌구 저쩌구</span>
          </div>
      </li>
      <!-- 세번째 -->
      <li class="ListLi">
          <a href="#">
              <div class="img-list">
                  <div class="main-img">
                      <img src="https://mblogthumb-phinf.pstatic.net/MjAyMTEyMTVfMTg3/MDAxNjM5NTc2MDYzOTU5.t99xzUpgqkooL2EJY11JEEGTdsf23al8EeL7HymsDV4g.qCXPe5Gie7lwD1mdQNglSJvsOoOCD05oW7g7hdRhv-gg.JPEG.se413496/b9a07eb4e1e3a6773d93309164a98f2b.jpg?type=w800" alt="썸네일">
                    </div>
              </div>
          </a>
          <div class="titleAndBtn">
              <p class="shop-title">매장명입니다</p>
              <div class="buttons">
                  <button type="button" class="like">하트</button>
              </div>
          </div>
          <div class="address-box">
              <span class="address">상세 주소 어쩌구 저쩌구</span>
          </div>
      </li>
      <!-- 네번째 -->
      <li class="ListLi">
          <a href="#">
              <div class="img-list">
                  <div class="main-img">
                      <img src="https://mblogthumb-phinf.pstatic.net/MjAyMTEyMTVfMTg3/MDAxNjM5NTc2MDYzOTU5.t99xzUpgqkooL2EJY11JEEGTdsf23al8EeL7HymsDV4g.qCXPe5Gie7lwD1mdQNglSJvsOoOCD05oW7g7hdRhv-gg.JPEG.se413496/b9a07eb4e1e3a6773d93309164a98f2b.jpg?type=w800" alt="썸네일">
                    </div>
              </div>
          </a>
          <div class="titleAndBtn">
              <p class="shop-title">매장명입니다</p>
              <div class="buttons">
                  <button type="button" class="like">하트</button>
              </div>
          </div>
          <div class="address-box">
              <span class="address">상세 주소 어쩌구 저쩌구</span>
          </div>
      </li>
      <!-- 다섯번째 -->
      <li class="ListLi">
          <a href="#">
              <div class="img-list">
                  <div class="main-img">
                      <img src="https://mblogthumb-phinf.pstatic.net/MjAyMTEyMTVfMTg3/MDAxNjM5NTc2MDYzOTU5.t99xzUpgqkooL2EJY11JEEGTdsf23al8EeL7HymsDV4g.qCXPe5Gie7lwD1mdQNglSJvsOoOCD05oW7g7hdRhv-gg.JPEG.se413496/b9a07eb4e1e3a6773d93309164a98f2b.jpg?type=w800" alt="썸네일">
                    </div>
              </div>
          </a>
          <div class="titleAndBtn">
              <p class="shop-title">매장명입니다</p>
              <div class="buttons">
                  <button type="button" class="like">하트</button>
              </div>
          </div>
          <div class="address-box">
              <span class="address">상세 주소 어쩌구 저쩌구</span>
          </div>
      </li>
      <!-- 여섯번째 -->
      <li class="ListLi">
          <a href="#">
              <div class="img-list">
                  <div class="main-img">
                      <img src="https://mblogthumb-phinf.pstatic.net/MjAyMTEyMTVfMTg3/MDAxNjM5NTc2MDYzOTU5.t99xzUpgqkooL2EJY11JEEGTdsf23al8EeL7HymsDV4g.qCXPe5Gie7lwD1mdQNglSJvsOoOCD05oW7g7hdRhv-gg.JPEG.se413496/b9a07eb4e1e3a6773d93309164a98f2b.jpg?type=w800" alt="썸네일">
                    </div>
              </div>
          </a>
          <div class="titleAndBtn">
              <p class="shop-title">매장명입니다</p>
              <div class="buttons">
                  <button type="button" class="like">하트</button>
              </div>
          </div>
          <div class="address-box">
              <span class="address">상세 주소 어쩌구 저쩌구</span>
          </div>
      </li>
      </ul>
  </div>

  <!-- 페이징 처리 -->
  <div class="pagination">
      <ul>
        <li><a href="#" class="prev">&laquo;</a></li>
        <li><a href="#" class="active">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#" class="next">&raquo;</a></li>
      </ul>
    </div>

</div>
  `;
}

function getProduct() {
  return `
  <div class="container">
      <!-- 배너 -->
      

      <article class="holder">
        <div class="communityList cL">
          <ul class="ListUl">
            <!-- 첫번째 -->
            <li class="ListLi">
              <a href="">
                <div class="img-list">
                  <div class="main-img">
                    <img
                      src="https://image.oliveyoung.co.kr/uploads/images/goods/550/10/0000/0014/A00000014950306ko.jpg?l=ko"
                      alt="제품 이미지"
                    />
                  </div>
                </div>
              </a>
              <div class="titleAndBnt">
                <p class="product-title">제품이름이여유</p>
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
                <p class="productCate">트리트먼트/팩</p>
                <p class="productPrice">₩ <span class="price">22000</span></p>
              </div>
            </li>

            <!-- 두번째 -->
            <li class="ListLi">
              <a href="">
                <div class="img-list">
                  <div class="main-img">
                    <img
                      src="https://image.oliveyoung.co.kr/uploads/images/goods/550/10/0000/0014/A00000014950306ko.jpg?l=ko"
                      alt="제품 이미지"
                    />
                  </div>
                </div>
              </a>
              <div class="titleAndBnt">
                <p class="product-title">제품이름이여유</p>
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
                <p class="productCate">트리트먼트/팩</p>
                <p class="productPrice">₩ <span class="price">22000</span></p>
              </div>
            </li>

            <!-- 세번째 -->
            <li class="ListLi">
              <a href="">
                <div class="img-list">
                  <div class="main-img">
                    <img
                      src="https://image.oliveyoung.co.kr/uploads/images/goods/550/10/0000/0014/A00000014950306ko.jpg?l=ko"
                      alt="제품 이미지"
                    />
                  </div>
                </div>
              </a>
              <div class="titleAndBnt">
                <p class="product-title">제품이름이여유</p>
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
                <p class="productCate">트리트먼트/팩</p>
                <p class="productPrice">₩ <span class="price">22000</span></p>
              </div>
            </li>
          </ul>
        </div>

        <!-- 페이징 처리 -->
        <div class="pagination">
          <ul>
            <li><a href="#" class="prev">&laquo;</a></li>
            <li><a href="#" class="active">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#" class="next">&raquo;</a></li>
          </ul>
        </div>
      </article>
    </div>
  `;
}

function getStyle() {
  return `
<div class="container">
      <!-- 리스트 -->
      <article class="holder">
        <div class="communityList cL">
          <ul class="ListUl">
            <!-- 첫번째 -->
            <li class="ListLi">
              <a href="">
                <div class="img-list">
                  <div class="main-img">
                    <img src="https://img1.daumcdn.net/thumb/C360x360/?fname=https://mud-kage.kakao.com/dn/tiTz0/btsjboVScnc/36eDc0R0JCIeBLE6uPouDk/img_1080.jpg&scode=purple" alt="헤어스타일">
                  </div>
                </div>
              </a>
              <div class="hairTitle">
                <p class="product-title">머리스타일이름이여유</p>
                <div class="buttons">
                  <button type="button" class="like">하트</button>
                </div>
              </div>
            </li>

            <!-- 두번째 -->
            <li class="ListLi">
              <a href="">
                <div class="img-list">
                  <div class="main-img">
                    <img src="https://img1.daumcdn.net/thumb/C360x360/?fname=https://mud-kage.kakao.com/dn/tiTz0/btsjboVScnc/36eDc0R0JCIeBLE6uPouDk/img_1080.jpg&scode=purple" alt="헤어스타일">
                  </div>
                </div>
              </a>
              <div class="hairTitle">
                <p class="product-title">머리스타일이름이여유</p>
                <div class="buttons">
                  <button type="button" class="like">하트</button>
                </div>
              </div>
            </li>

            <!-- 테스트용 -->
            <li class="ListLi">
              <a href="">
                <div class="img-list">
                  <div class="main-img">
                    <img src="https://img1.daumcdn.net/thumb/C360x360/?fname=https://mud-kage.kakao.com/dn/tiTz0/btsjboVScnc/36eDc0R0JCIeBLE6uPouDk/img_1080.jpg&scode=purple" alt="헤어스타일">
                  </div>
                </div>
              </a>
              <div class="hairTitle">
                <p class="product-title">머리스타일이름이여유</p>
                <div class="buttons">
                  <button type="button" class="like">하트</button>
                </div>
              </div>
            </li>

            <!-- 세번째 -->
            <li class="ListLi">
              <a href="">
                <div class="img-list">
                  <div class="main-img">
                    <img src="https://img1.daumcdn.net/thumb/C360x360/?fname=https://mud-kage.kakao.com/dn/tiTz0/btsjboVScnc/36eDc0R0JCIeBLE6uPouDk/img_1080.jpg&scode=purple" alt="헤어스타일">
                  </div>
                </div>
              </a>
              <div class="hairTitle">
                <p class="product-title">머리스타일이름이여유</p>
                <div class="buttons">
                  <button type="button" class="like">하트</button>
                </div>
              </div>
            </li>

            <!-- 네번째 -->
            <li class="ListLi">
              <a href="">
                <div class="img-list">
                  <div class="main-img">
                    <img src="https://img1.daumcdn.net/thumb/C360x360/?fname=https://mud-kage.kakao.com/dn/tiTz0/btsjboVScnc/36eDc0R0JCIeBLE6uPouDk/img_1080.jpg&scode=purple" alt="헤어스타일">
                  </div>
                </div>
              </a>
              <div class="hairTitle">
                <p class="product-title">머리스타일이름이여유</p>
                <div class="buttons">
                  <button type="button" class="like">하트</button>
                </div>
              </div>
            </li>
          </ul>
        </div>

        

            <!-- 페이징 처리 -->
            <div class="pagination">
              <ul>
                <li><a href="#" class="prev">&laquo;</a></li>
                <li><a href="#" class="active">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#" class="next">&raquo;</a></li>
            </div>
          </ul>
      </article>
    </div>
  `;
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
