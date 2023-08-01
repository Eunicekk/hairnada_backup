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
  $(".ListUl").on('click', '.like', function () {
    console.log("like 버튼 클릭 !!!!");
    var buttonImg = $(this);
    var boardNumber = $(this).val();
    console.log(boardNumber);

    if (buttonImg.hasClass("active")) {
      $.ajax({
        url: "/boardLike/subtract",
        type: "DELETE",
        contentType: "application/json",
        data: JSON.stringify({ boardNumber: boardNumber }),
        success: function(){
          console.log("빼기 성공");
        }
      });

      buttonImg.removeClass("active");
      buttonImg.css("background-image", "url('/img/heart1.png')");
    } else {
      $.ajax({
        url: "/boardLike/add",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({ boardNumber: boardNumber }),
        success: function(){
          console.log("더하기 성공");
        }
      });

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

// 글쓰기
$('.write-btn').on('click', function () {
  window.location.href = '/board/communityWrite';
});

let obj = {};

document.addEventListener('DOMContentLoaded', function() {
  var categoryButtons = document.querySelectorAll('.categoryBtn');

  categoryButtons.forEach(function(button) {
    button.addEventListener('click', function() {
      // 선택된 버튼 강조 표시
      categoryButtons.forEach(function (btn) {
        btn.classList.remove('selected');
      });
      this.classList.add('selected');
    });

  });
});




      $(".search-btn").on("click", function () {
        let searchType = $("input[name='searchType']:checked").val();
        console.log(searchType);
        console.log("검색했디")
        obj = {
          searchType : $("input[name='searchType']:checked").val(),
          boardCategoryNumber: $('.selected').val(),
          keyword: $('.select-name').val()
        };
        searchModule(1, obj, showSearchResult, paging);
      });

      $(".categoryBtn").on("click", function () {
        console.log("클릭했디")
        obj = {
          searchType : $("input[name='searchType']:checked").val(),
          boardCategoryNumber: $(this).val(),
          keyword: $('.select-name').val()
        };
        console.log("카테고리 ================== " + obj.boardCategoryNumber);
        searchModule(1, obj, showSearchResult, paging);
      });

      function searchModule(page, obj, callback, paging) {
        $.ajax({
          url: `/boardR/communitySearchList/${page}`,
          type: 'get',
          data: obj,
          dataType: 'json',
          success: function (result) {
            if (callback) {
              callback(result);
              paging(result);
            }
          },
          error: function (a, b, c) {
            console.error(c);
          }
        });
      }

      function showSearchResult(result) {
        console.log(result);

        let boardList = result.boardList;

        $(".ListUl").html('');
        for (let i = 0; i < boardList.length; i++) {
          let likeClass = boardList[i].likeCnt == 1 ? 'like ifILike active' : 'like';

          // 등급 처리
          let membershipText;
          if (boardList[i].membershipNumber == 1) {
            membershipText = '👤일반 회원'
          } else if (boardList[i].membershipNumber == 2) {
            membershipText = '✂️스타일 전문가';
          } else if (boardList[i].membershipNumber == 3) {
            membershipText = '🎓케어 전문가';
          }

          $('.ListUl').append(`
                <li class="ListLi">
            <div class="board-category-number" style="display: none;">${boardList[i].boardCategoryNumber}</div>
            <div class="profile">
              <a href="#">
                  <div ${boardList[i].userFileName ? 'style="display: none;"' : ''} class="profiles profile-img">
                  <img src="https://www.studiopeople.kr/common/img/default_profile.png" alt="임시 썸네일"/>
                </div>
                <div ${boardList[i].userFileName ? '' : 'style="display: none;"'} class="profiles profile-img">
                  <img src="/upload/${boardList[i].userFileUploadPath}/th_${boardList[i].userFileUuid}_${boardList[i].userFileName}" alt="썸네일"/>
                </div>
                <p class="profiles profile-nick">${boardList[i].userNickName}</p>
                <span class="membership-span">${membershipText}</span>
              </a>
              <div class="buttons">
                <button type="button"  class="${likeClass}" value="${boardList[i].boardNumber}">하트</button>
              </div>
            </div>
            <a href="/board/communityRead?boardNumber=${boardList[i].boardNumber}">
              <div class="img-list">
                <div ${boardList[i].boardFileName ? 'style="display: none;"' : ''} class="main-img">
                  <img src="https://www.studiopeople.kr/common/img/default_profile.png" alt="썸네일">
                </div>
                <div ${boardList[i].boardFileName ? '' : 'style="display: none;"'} class="main-img">
                  <img src="/upload/${boardList[i].boardFileUploadPath}/th_${boardList[i].boardFileUuid}_${boardList[i].boardFileName}" alt="썸네일"/>
                </div>
              </div>
            </a>
            <div class="titleAndCnt">
              <p class="community-title">${boardList[i].boardTitle}</p>
              <div class="count">
                <span class="reply">댓글</span>
                <span class="replyCnt">${boardList[i].replyCnt}</span>
                <span class="view">조회수 </span>
                <span class="viewCnt">${boardList[i].boardViewCnt}</span>
              </div>
            </div>
          </li>
          `);
        }
      }

      // 페이징
      function paging(result) {
        console.log("페이징 펑션=====================================")
        console.log(result)
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



