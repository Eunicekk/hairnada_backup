import * as boardReply from '../module/boardReply.js';

const boardNumber = $('.board-num').val();
let page = 1;

boardReply.getListPage({boardNumber: boardNumber, page : page}, showReply, showError);

function showReply(map){

  console.log(map);

  let text = '';

  map.replyList.forEach(r => {
    text += `
      <ul id="comment-list" class="reply" data-num="${r.boardReplyNumber}">
          <li>
            <div class="comment-wrap">
              <div class="comment-info">
                <span class="writer">${r.userNickName}</span>
                <span class="date">${boardReply.timeForToday(r.boardReplyRegisterDate == r.boardReplyUpdateDate ? r.boardReplyRegisterDate : r.boardReplyUpdateDate)}</span>
              </div>
             <div class="comment-btn-group">`;


    if (r.userNumber == loginNumber) {
    text += `
                <button type="button" class="comment-modify-ready">수정</button>
                <button type="button" class="comment-delete">삭제</button>
              </div>
            </div>`;
        }

          text += `
            <div class="comment-content">
            <p>
              ${r.boardReplyContent}
            </p>
            </div>
          </li>
        </ul>
    `;
  });

  $('.comment-list').html(text);
}

function appendText(map){
  let text = '';

  map.replyList.forEach(r => {
    text += `
      <ul id="comment-list" class="reply" data-num="${r.boardReplyNumber}">
          <li>
            <div class="comment-wrap">
              <div class="comment-info">
                <span class="writer">${r.userNickName}</span>
                <span class="date">${boardReply.timeForToday(r.boardReplyRegisterDate == r.boardReplyUpdateDate ? r.boardReplyRegisterDate : r.boardReplyUpdateDate)}</span>
              </div>
             <div class="comment-btn-group">`;


    if (r.userNumber == loginNumber) {
      text += `
                <button type="button" class="comment-modify-ready">수정</button>
                <button type="button" class="comment-delete">삭제</button>
                `;
    }

    text +=`
              </div>
            </div>`;


    text += `
            <div class="comment-content">
            <p>
              ${r.boardReplyContent}
            </p>
            </div>
          </li>
        </ul>
    `;
  });

  $('.comment-list').append(text);
}

// 댓글 스크롤로 페이징
$(window).on('scroll', function (){
  if(Math.round($(window).scrollTop()) == $(document).height() - $(window).height()){
    // console.log(++page);
    boardReply.getListPage({boardNumber : boardNumber, page : page}, appendText, showError);
  }
});


function showError(a, b, c){
  console.error(c);
}


// 댓글 작성 완료
$('.submit-btn').on('click',function (){
  let boardReplyContent = $('#boardReplyContent').val();

  let replyObj = {
    boardReplyContent : boardReplyContent,
    boardNumber : boardNumber
  }

  page = 1;

  boardReply.add(replyObj,
      function (){
        boardReply.getListPage({boardNumber : boardNumber, page : page}, showReply, showError);
      }
      ,showError)
});

// 댓글 삭제
$('.comment-list').on('click', '.comment-delete', function (){

  let boardReplyNumber = $(this).closest('.reply').data('num')

  page = 1;

  boardReply.remove(boardReplyNumber,function (){
    boardReply.getListPage({boardNumber : boardNumber, page : page}, showReply, showError);
  } ,showError)
});

// 댓글 수정
$('.comment-list').on('click','.comment-modify-ready', function (){
  let $boardReplyContent = $(this).closest('.reply').find('.comment-content');
  $boardReplyContent.replaceWith(`
  <div class='modify-box'>
  <textarea class="modify-content">${$boardReplyContent.text()}</textarea>
  <button type="button" class="comment-modify">수정 완료</button>
  </div>
  `);
  $('.comment-btn-group').addClass('none');
});

// 수정 완료
$('.comment-list').on('click','.comment-modify', function (){
  console.log("수정됐다.");
  let boardReplyNumber = $(this).closest('.reply').data('num');
  let boardReplyContent = $(this).closest('.modify-box').find('.modify-content').val();

  let replyObj = {
    boardReplyNumber : boardReplyNumber,
    boardReplyContent : boardReplyContent
  }

  page = 1;

  boardReply.modify(replyObj, function (){
    boardReply.getListPage({boardNumber : boardNumber, page : page}, showReply, showError);
  }, showError);
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

// 게시물 삭제
$('.btn-remove').on('click',function (){
  let boardNumber = $('.board-num').val();
  window.location.href = '/board/communityRemove?boardNumber' + boardNumber;
});

// 게시물 수정
$('.btn-modify').on('click', function (){
  let boardNumber = $('.board-num').val();
  window.location.href = '/board/communityModify?boardNumber=' + boardNumber;
});


// 목록 버튼
$('.btn-back').on('click', function (){
  window.location.href = '/board/communityList';
});