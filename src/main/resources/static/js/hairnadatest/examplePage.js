// 모듈 설정 필수
import * as recommend from "/js/hairnadatest/recommendation.js";
import * as quiz from "/js/hairnadatest/quiz-recommendation.js";

// main페이지 설정 예시
recommend.setMainText(
    "헤어 추천",
    "각 문항에 답변하시면 헤어 스타일을 추천합니다."
);

// rec-box에 main모듈 넣기
// main모듈이 main html을 반환함
$(".rec-box").html(recommend.main());

// 메인 페이지 btn스타일 변경 예시
recommend.setBtnStyle("#222", 20, "white", "none");
recommend.setMainTitleStyle(50, "#222");

//quiz 페이지 스타일 예시
quiz.setQuizBtnStyle("#222", 20, "white", "none");
quiz.setQuizMainTitleStyle(50, "#222");

//quiz페이지 만들기 예시
quiz.makeQuizPage(
    6,
    ["Q1", "Q2", "Q3", "Q4", "Q5", "Q6"],
    [
        "당신의 성별은?",
        "당신은 광대가 부각된 편입니까?",
        "당신의 얼굴 길이는?",
        "당신은 턱이 부각된 편입니까?",
        "당신이 듣는 첫인상은?",
        "당신은 어떤 각도의 얼굴도 자신 있습니까?",
    ],
    [
        ["남", "여"],
        ["그렇다.", "그렇지 않다.", "모르겠다."],
        ["긴 편이다.", "짧은 편이다."],
        ["그렇다.", "그렇지 않다.", "모르겠다."],
        ["차갑다.", "귀엽다.", "친근하다."],
        ["그렇다.", "그렇지 않다.", "모르겠다."],
    ]
);

// 사용자가 선택한 문항을 처리하도록 콜백함수를 설정한다..
// 실제 사용시 ajax 실행을 하면 된다.
quiz.setApi(function (resultList) {
    console.log(resultList);
    $.ajax({
        url: "/tests/hairTest",
        type: "get",
        tranditional : true,
        data: {resultList:resultList}, //resultList에 사용자가 선택한 문항이 배열 형태로 저장되어 있다.
        success: function (result) {
            console.log(result)
            //성공시 실행시킬 함수를 정의한다.
            //아래의 setFinalPage()와 함께 사용하면 된다.
            //예시
            /*
            let finalPage = `
            <div class="title aa">완료 페이지다</div>
            <img src="${result.image}"/>
          `;

            quiz.setFinalPage(finalPage);
            */
        },
    });
});

// 결과 페이지 만들기 예시
// css는 해당 페이지 css에 추가하면 적용됨
let finalPage = `
<div class="hairnada-logo">hairnada</div>
      <div class="result-box">
        <div class="result-text">짱구형</div>
        <div class="hair-recommend">hair recommendation</div>
        <div class="hair-img-box">
          <div class="hair-img">
            <div class="img">
              <img
                src="https://storage.googleapis.com/static.smalljoys.me/2021/12/7195833_69cb9f3d-6c6a-4a76-afe8-b127152222b5_1639976100.png"
                alt=""
                class="real-img"
              />
            </div>
            <div class="hair-name">갓파컷</div>
          </div>
          <div class="hair-img">
            <div class="img">
              <img
                src="https://static-storychat.pstatic.net/2020/8/30/27/1149627_hlbn3bmma3jb0.png?type=rsc5"
                alt=""
                class="real-img"
              />
            </div>
            <div class="hair-name">가재컷</div>
          </div>
        </div>
        <div class="button-box">
          <button class="next-button">더 많은 헤어스타일을 보고싶다면?</button>
          <button class="next-button2">홈으로</button>
        </div>
      </div>
`;

quiz.setFinalPage(finalPage);

console.log("examplePage.js");
