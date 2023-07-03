function selectRadio(checkboxId) {
  var checkbox = document.getElementById(checkboxId);
  checkbox.checked = true;
}

$(document).ready(function () {
  $(".category button").click(function () {
    $(".category button").removeClass("active");
    $(this).addClass("active");
  });
});

$(document).ready(function () {
  $(".buttons").click(function () {
    var buttonImg = $(this).find(".like");

    if (buttonImg.hasClass("active")) {
      buttonImg.removeClass("active");
      buttonImg.css("background-image", "url('/img/heart1.png')");
    } else {
      buttonImg.addClass("active");
      buttonImg.css("background-image", "url('/img/heart2.png')");
    }
  });
});

// 초기에 "전체" 버튼을 클릭된 상태로 설정
$(document).ready(function () {
  $("#button0").addClass("active");
});

// 클릭된 버튼에 active 클래스 추가 및 다른 버튼의 active 클래스 제거
$(document).ready(function () {
  $(".categoryBtn").click(function () {
    $(".categoryBtn").removeClass("active");
    $(this).addClass("active");
  });
});

// 글쓰기 버튼
$('.write-btn').on('click', function () {
  window.location.href = '/board/communityWrite';
});

document.addEventListener('DOMContentLoaded', function() {
  var categoryButtons = document.querySelectorAll('.categoryBtn');

  categoryButtons.forEach(function(button) {
    button.addEventListener('click', function() {
      // 선택된 버튼 강조 표시
      categoryButtons.forEach(function(btn) {
        btn.classList.remove('selected');
      });
      this.classList.add('selected');


      // $(document).ready(function() {
        // 초기 로딩 시, 전체 카테고리 게시물 로드
        loadBoardList(0);
        console.log("ready!!")
        $('.categoryBtn').click(function() {
          console.log("click")
          var boardCategoryNumber = $(this).data('board-category-number');
          console.log(boardCategoryNumber);
          loadBoardList(boardCategoryNumber);
        });

        function loadBoardList(boardCategoryNumber) {
          $.ajax({
            url: "/boardR/communityList",
            method: "GET",
            data: { boardCategoryNumber: boardCategoryNumber },
            success: function (response) {
              console.log(response)
              $('.ListUl').html('');
              response.forEach(function (board) {
                $('.ListUl').append(`
                <li class="ListLi">
            <div class="board-category-number" style="display: none;">${board.boardCategoryNumber}</div>
            <div class="profile">
              <a href="#">
                <div class="profiles profile-img">
                  <img src="https://mblogthumb-phinf.pstatic.net/MjAyMTEyMTVfMTgz/MDAxNjM5NTc2MDYxMjQw.jGbcfmGy9UjE1k3obpZy9piP41BQTf_PbLi0VdBRL9sg.vfIiwqDJVvwviW1J9I0QZwNCcfleCTAGemKH_INjJfwg.JPEG.se413496/c55c762ce418abefd071aa7e81c5a213.jpg?type=w800" alt="프로필 이미지">
                </div>
                <p class="profiles profile-nick">${board.userNickName}</p>
              </a>
              <div class="buttons">
                <button type="button" class="like">하트</button>
              </div>
            </div>
            <a href="/board/communityRead?boardNumber=${board.boardNumber}">
              <div class="img-list">
                <div ${board.boardFileName ? 'style="display: none;"' : ''} class="main-img">
                  <img src="https://mblogthumb-phinf.pstatic.net/MjAyMTEyMTVfMTg3/MDAxNjM5NTc2MDYzOTU5.t99xzUpgqkooL2EJY11JEEGTdsf23al8EeL7HymsDV4g.qCXPe5Gie7lwD1mdQNglSJvsOoOCD05oW7g7hdRhv-gg.JPEG.se413496/b9a07eb4e1e3a6773d93309164a98f2b.jpg?type=w800" alt="썸네일">
                </div>
                <div ${board.boardFileName ? '' : 'style="display: none;"'} class="main-img">
                  <img src="/upload/${board.boardFileUploadPath}/th_${board.boardFileUuid}_${board.boardFileName}" alt="썸네일"/>
                </div>
              </div>
            </a>
            <div class="titleAndCnt">
              <p class="community-title">${board.boardTitle}</p>
              <div class="count">
                <span class="reply">댓글</span>
                <span class="replyCnt">3</span>
                <span class="view">조회수 </span>
                <span class="viewCnt">5</span>
              </div>
            </div>
          </li>
          `);
              });
            },
            error: function (xhr, status, error) {
              console.error(error);
            }
          });
        }
      // });
    });
  });
});
