
let userMembership = $('.userMembership').val();
let questMembership = $('.membershipNumber').val();

if (userMembership == questMembership){
    $('.accept').css("display", "none");
    $('.refuse').css("display", "none");
    window.alert("이미 수락한 게시글 입니다!");

}

// 수락 버튼
$('.accept').on('click', function (){
    let userNumber = $('.userNumber').val();
    let membershipNumber = $('.membershipNumber').val();

    $.ajax({
        url : '/adminR/membership',
        type : 'post',
        data : {
            userNumber : userNumber,
            membershipNumber : membershipNumber
        },
        success: function (){
            // 페이지 이동
            window.location.href = '/admin/membership';
        }
    });
})

// 목록으로 돌아가기
$('.back-to-list').on('click', function (){
    window.location.href = '/admin/membership';
})