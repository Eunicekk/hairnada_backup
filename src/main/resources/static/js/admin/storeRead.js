// 사진 눌렀을 때 모달 띄우면서 확대

$(".file-wrap").on("click", '.img-list',function () {
  let viewImg = $(this).attr("src");
  $(".modal").css("display", "flex");
  $(".view-img").attr("src", viewImg);
});

$(".background").on("click", function () {
  $(".modal").css("display", "none");
});

$(".view-img").on("click", function () {
  console.log($(this).attr("background-image"));
});

let storeNum = $('.storeNumber').val();

console.log(storeNum);
function displayAjax(){
  let storeNumber = storeNum;

  $.ajax({
    url : '/adminFile/storeImgList',
    type : 'get',
    data : {storeNumber : storeNumber},
    success : function(storeImgList){
      let text = '';
      $('.file-wrap').html('');
      storeImgList.forEach(file => {
        let fileName = file.storeFileUploadPath + '/' + file.storeFileUuid + '_' + file.storeFileName;
        text += `
                    <li>
                      <img  class="img-list" src="/adminFile/display?fileName=${fileName}" data-number="${file.storeFileNumber}" data-name="${fileName}" />
                    </li>  
`;
      });

      $('.file-wrap').html(text);
    }
  });
}

displayAjax();


// 삭제 버튼
$('.delete').on('click' , function (){
  window.location.href = '/admin/storeRemove?storeNumber=' + storeNum;
});


// modify
$('.modify').on('click', function (){
  window.location.href = '/admin/storeModify?storeNumber=' + storeNum;
});