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
let hairNum = $('.hairNumber').val();

function displayAjax(){
  let hairNumber = hairNum;

  $.ajax({
    url : '/adminFile/hairImgList',
    type : 'get',
    data : {hairNumber : hairNumber},
    success : function(hairImgList){
      let text = '';
      $('.file-wrap').html('');
      hairImgList.forEach(file => {
        let fileName = file.hairFileUploadPath + '/' + file.hairFileUuid + '_' + file.hairFileName;
        text += `
                    <li>
                      <img  class="img-list" src="/adminFile/display?fileName=${fileName}" data-number="${file.hairFileNumber}" data-name="${fileName}" />
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
  window.location.href = '/admin/hairRemove?hairNumber=' + hairNum;
});

// modify
$('.modify').on('click', function (){
  window.location.href = '/admin/hairModify?hairNumber=' + hairNum;
});