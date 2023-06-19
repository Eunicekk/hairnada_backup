// console.log($input);

// file change이벤트로 미리보기 갱신하기
$(".main-join").on("change", "#post-image2", function () {
  let $inputs = $("#post-image2");
  let $imgLists = $(".img-lists");

  let files = this.files;
  //   console.log(files);

  // 길이 체크함수 (files, 원하는 길이)
  let newFiles = checkLength(files, 4);

  appendImgs(newFiles);
});

// 클릭 이벤트로 이미지 지우고 미리보기 갱신하기
$(".main-join").on("click", ".img-lists", function (e) {
  let name = $(e.target).data("name");
  removeImg(name);
  appendImgs($inputs[0].files);
});

//미리보기 삭제 함수
function removeImg(name) {
  let dt = new DataTransfer();

  let files = $inputs[0].files;

  for (let i = 0; i < files.length; i++) {
    if (files[i].name !== name) {
      dt.items.add(files[i]);
    }
  }
  $inputs[0].files = dt.files;
}

//파일 길이 체크 함수(체크할 files객체, 제한할 길이)
function checkLength(files, num) {
  if (files.length > num) {
    alert(`파일은 최대 ${num}개까지만 첨부 가능합니다.`);
    // 최대 수를 넘으면 비어있는 files객체 반환
    return new DataTransfer().files;
  }
  return files;
}

// 이미지 미리보기 처리 함수
function appendImgs(files) {
  let $imgLists = $(".img-lists");
  for (let i = 0; i < 5; i++) {
    if (i < files.length) {
      let srcs = URL.createObjectURL(files[i]);

      $imgLists
        .eq(i)
        .css("background-image", `url(${srcs})`)
        .css("background-size", "cover")
        .data("name", `${files[i].name}`);
    } else {
      $imgLists
        .eq(i)
        .css(
          "background",
          "url(data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzNiIgaGVpZ2h0PSIzNiI+PGcgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj48ZyBzdHJva2U9IiNCNUI1QjUiIHN0cm9rZS13aWR0aD0iMS41IiB0cmFuc2Zvcm09InRyYW5zbGF0ZSg0IDQpIj48cmVjdCB3aWR0aD0iMjgiIGhlaWdodD0iMjgiIHJ4PSIzLjUiLz48Y2lyY2xlIGN4PSI4LjU1NiIgY3k9IjguNTU2IiByPSIyLjMzMyIvPjxwYXRoIGQ9Ik0yOCAxOC42NjdsLTcuNzc3LTcuNzc4TDMuMTExIDI4Ii8+PC9nPjxwYXRoIGQ9Ik0wIDBoMzZ2MzZIMHoiLz48L2c+PC9zdmc+) no-repeat 50%"
        )
        .data("name", null);
    }
  }
}
