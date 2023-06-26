$(document).ready(function() {
  $("#editor").summernote({
    placeholder: '내용을 입력해주세요.',
    tabsize: 2,
    height: 450,
    lang: "ko-KR",
    toolbar: [
      ["style", ["style"]],
      ["font", ["bold", "italic", "underline", "clear"]],
      ["fontname", ["fontname"]],
      ["color", ["color"]],
      ["para", ["ul", "ol", "paragraph"]],
      ["insert", ["picture"]],
    ]
  });

  let $fileInput = $("#file");
  let $fileList = $(".file-list");
  let $cnt = $("cnt");

  $fileInput.on("change", function () {
    let files = this.files;

    if (files.length > 1) {
      let dt = new DataTransfer();
      alert("대표 이미지는 1개만 선택 가능합니다.");
      return;
    }

    for (let i = 0; i < files.length; i++) {
      let src = URL.createObjectURL(files[i]);

      $fileList.append(`
        <li>
          <div class="show-img-box">
            <img src=${src}>
          </div>
          <div class="btn-box">
            <button type='button' class='img-cancel-btn' data-name='${files[i].name}'>×</button>
          </div>
        </li>
      `);
    }

    $(".img-cancel-btn").on("click", function () {
      $(this).parent().parent().remove();
      let fileName = $(this).data("name");
      let dt = new DataTransfer();

      for (let i = 0; i < files.length; i++) {
        if (files[i].name !== fileName) {
          dt.items.add(files[i]);
        }
      }
      files = dt.files;
    });
  });

  // 드롭다운 박스
  $('.dropdown').click(function() {
    $(this).find('.dropdown-menu').toggle();
  });

  $(document).click(function(e) {
    var target = e.target;
    if (!$(target).is('.dropdown') && !$(target).parents().is('.dropdown')) {
      $('.dropdown-menu').hide();
    }
  });

  $(".dropdown-menu li").click(function() {
    var selectedItem = $(this).text();
    var boardCategoryNumber = $(this).data("value");
    $('.dropdown-btn').html(selectedItem + `
      <span class="material-symbols-outlined">
        expand_more
      </span>
    `);
    $('#boardCategoryNumber').val(boardCategoryNumber);
    console.log('카테고리 값 :', boardCategoryNumber);

    // 선택된 항목 강조 표시
    $(".dropdown-menu li").removeClass("selected");
    $(this).addClass("selected");
  });

  // 작성취소버튼
  $('.writeCancel-btn').on('click', function () {
    window.location.href = '/board/communityList';
  });

  // '작성 완료' 버튼 클릭 이벤트 처리
  $("form").submit(function() {
    var selectedItem = $(".dropdown-menu li.selected");
    var boardCategoryNumber = selectedItem ? selectedItem.attr("data-value") : null;
    $("#boardCategoryNumber").val(boardCategoryNumber);
  });
});
