// 이미지 리스트
imgAjax();

function imgAjax(){
    let careShopNumber = $('.care-shop-num').val();

    $.ajax({
        url : '/careshopFile/imgList',
        type : 'get',
        data : {careShopNumber : careShopNumber},
        async : false,
        success : function(files) {
            let maintext = '';
            let subtext = '';

            files.forEach(file => {
                let careShopFileName = file.careShopFileUploadPath + '/' + file.careShopFileUuid + '_' + file.careShopFileName;

                maintext += `
                <li>
                    <img src="/careshopFile/display?careShopFileName=${careShopFileName}" data-number="${file.careShopFileNumber}" data-name="${careShopFileName}" alt="메인">
                </li>
               `

                subtext += `
                <li>
                    <img src="/careshopFile/display?careShopFileName=${careShopFileName}" data-number="${file.careShopFileNumber}" data-name="${careShopFileName}" alt="서브">
                </li>
               `
            });
            $('.img-main-box').html(maintext);
            $('.img-sub-box').html(subtext);
        },
        error: function(xhr, status, error) {
            console.log('Ajax 오류 발생');
            console.log('상태 코드:', xhr.status);
            console.log('오류:', error);
        }
    });
}


// 이미지 넘기기
let box = $('.img-main-box');
let img = $('.img-main-box li');
let currentIdx = 0;
let imgWidth = 1200;
let imgCnt = $('.img-sub li').length;

checkEnd();
imageControl();

function imageControl(){
    $('.img-box .right').on('click', function(){
        console.log("next!!");
        currentIdx++;
        box.css('transition', '0.5s ease');
        box.css("left", -(currentIdx * imgWidth) + 'px');
        checkEnd();
    });

    $('.img-box .left').on('click', function(){
        console.log("prev!!");
        currentIdx--;
        box.css("left", -(currentIdx * imgWidth));
        box.css('transition', '0.5s ease');
        checkEnd();
    })
}

function checkEnd(){
    if(currentIdx <= 0){
        $('.img-box .left').css('display', 'none');
    } else {
        $('.img-box .left').css('display', 'block');
    }

    if(currentIdx >= imgCnt-1){
        $('.img-box .right').css('display', 'none');
    } else {
        $('.img-box .right').css('display', 'block');
    }
}


// 지도 API
console.log($('.address').text());

var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
    center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
    level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

var imageSrc = '/img/location.png', // 마커이미지의 주소입니다
    imageSize = new kakao.maps.Size(54, 54), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);

var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch($('.address').text(), function(result, status) {

    // 정상적으로 검색이 완료됐으면 
    if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords,
            image: markerImage // 마커이미지 설정 
        });

        // 마커가 지도 위에 표시되도록 설정합니다
        marker.setMap(map);

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px; text-align:center; padding:10px 0px; font-size:14px; letter-spacing:-1px;">' + $('.place-name').text() + '</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    }
});


// 수정, 삭제 버튼 실행
$('.btn-modify').on('click', function(){
    let careShopNumber = $('.care-shop-num').val();
    window.location.href = '/careshop/modify?careShopNumber=' + careShopNumber;
})

$('.btn-delete').on('click', function(){
    let careShopNumber = $('.care-shop-num').val();
    window.location.href = '/careshop/remove?careShopNumber=' + careShopNumber;
})
