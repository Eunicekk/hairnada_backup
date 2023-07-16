Kakao.init("f8c795cb98118ca5b620945fd0409812"); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
// 카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
        success: function (response) {
            Kakao.API.request({
                url: '/v2/user/me',
                success: function (userDto) {
                    console.log(userDto)
                    let userId = userDto.id
                    let userGender = userDto.kakao_account.gender == 'male' ? 'M' : 'F'; // 성별을 M 또는 F로 변환

                    const data = {
                        userId: userId,
                        userEmail: userDto.kakao_account.email,
                        userGender: userGender,
                        userName: userDto.properties.nickname
                    };
                    console.log(data);
                    // 서버로 userInfo 객체를 전송하는 로직을 구현
                    sendUserInfoToServer(data);
                    // 페이지 이동
                    window.location.href = "http://localhost:10000/";
                },
                fail: function (error) {
                    console.log(error);
                },
            });
        },
        fail: function (error) {
            console.log(error);
        },
    });
}

// 서버로 사용자 정보 전송
function sendUserInfoToServer(data) {
    const xhr = new XMLHttpRequest();
    xhr.open('POST', '/users/registerKakao');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function () {
        if (xhr.status === 200) {
            // 서버로부터 성공적인 응답을 받았을 때의 처리 로직
            console.log('User info sent successfully.');
        } else {
            // 서버로부터 실패 응답을 받았을 때의 처리 로직
            console.log('Failed to send user info.');
        }
    };
    xhr.send(JSON.stringify(data));
}

// 카카오로그아웃
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
        Kakao.API.request({
            url: '/v1/user/unlink',
            success: function (response) {
                console.log(response);
                // 페이지 이동
                window.location.href = "http://localhost:10000/";
            },
            fail: function (error) {
                console.log(error);
            },
        });
        Kakao.Auth.setAccessToken(undefined);
    }
}


