function selectRadio(checkboxId) {
  var checkbox = document.getElementById(checkboxId);
  checkbox.checked = true;
}

$(document).ready(function () {
  $(".category button").click(function () {
    $(".category button").removeClass("active"); // 모든 버튼의 active 클래스 제거
    $(this).addClass("active"); // 클릭한 버튼에 active 클래스 추가
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

// 초기에 "전 체" 버튼을 클릭된 상태로 설정
document.getElementById("button0").classList.add("active");

// 클릭된 버튼에 active 클래스 추가 및 다른 버튼의 active 클래스 제거
var buttons = document.getElementsByTagName("categoryBtn");
for (var i = 0; i < buttons.length; i++) {
  buttons[i].addEventListener("click", function () {
    var clickedButton = this;

    // 모든 버튼의 active 클래스 제거
    for (var j = 0; j < buttons.length; j++) {
      buttons[j].classList.remove("active");
    }

    // 클릭된 버튼에 active 클래스 추가
    clickedButton.classList.add("active");
  });
}

// 글쓰기 버튼
$('.write-btn').on('click', function (){
  window.location.href = '/board/communityWrite';
});


document.addEventListener('DOMContentLoaded', function() {
  var categoryButtons = document.querySelectorAll('.categoryBtn');
  var listItems = document.querySelectorAll('.ListLi');

  categoryButtons.forEach(function(button) {
    button.addEventListener('click', function() {
      // 선택된 버튼 강조 표시
      categoryButtons.forEach(function(btn) {
        btn.classList.remove('selected');
      });
      this.classList.add('selected');

      // 선택된 카테고리의 boardCategoryNumber 가져오기
      var boardCategoryNumber = this.getAttribute('id').replace('button', '');

      // 게시물 필터링하여 보여주기
      listItems.forEach(function(item) {
        var categoryNumber = item.querySelector('.board-category-number').textContent;
        if (boardCategoryNumber === '0' || boardCategoryNumber === categoryNumber) {
          item.style.display = 'block';
        } else {
          item.style.display = 'none';
        }
      });
    });
  });
});

// 검색기능
$('#searchForm').submit(function(event) {
  event.preventDefault(); // 폼 제출 동작 중단

  // 입력한 검색어와 검색 타입 가져오기
  var keyword = $('#text').val();
  var searchType = $('input[name="search"]:checked').val();

  // AJAX를 사용하여 서버로 검색 요청 보내기
  $.ajax({
    url: '/board/communitySearch',
    method: 'GET',
    data: {
      keyword: keyword,
      search: searchType
    },
    success: function(data) {
      console.log(data);
      // 검색 결과를 받아서 처리하는 코드 작성
      $('#boardList').html(data);
    },
    error: function(error) {
      console.log(error);
    }
  });
});
