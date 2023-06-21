// 현재 quiz페이지 번호 저장
let pageNo = 0;
// 전체 퀴즈페이지 저장하는 배열
let resultPages = [];
// 선택지 저장하는 배열
let answerList = [];

let maxPage = 0;

let finalPage = ``;

// 최종 결과로 작업할 콜백함수를 저장하는 변수
let callFunc = function () {};

// 기본 스타일 객체
let quizBtnStyle = {
    backgroundColor: "rgb(146, 114, 236)",
    borderRadius: 10,
    color: "white",
    border: "none",
};

let quizMainTitleStyle = {
    fontSize: 26,
    color: "rgb(146, 114, 236)",
};

let quizSubTitleStyle = {
    fontSize: 16,
    color: "black",
};

// btn스타일 적용 함수, bar색상도 통일
function quizBtnStyleFunction() {
    let $btn = $(".quiz-btn-sec__btn");
    $btn.css("background-color", quizBtnStyle.backgroundColor);
    $btn.css("border-radius", `${quizBtnStyle.borderRadius}px`);
    $btn.css("color", quizBtnStyle.color);
    $btn.css("border", quizBtnStyle.border);
    $(".quiz-progress").css("background-color", quizBtnStyle.backgroundColor);
}

// 타이틀 스타일 적용 함수
function quizTitleStyleFunction() {
    let [$quizMainTitle, $quizSubTitle] = [
        $(".quiz-main-title"),
        $(".quiz-sub-title"),
    ];

    $quizMainTitle.css("font-size", `${quizMainTitleStyle.fontSize}px`);
    $quizMainTitle.css("color", quizMainTitleStyle.color);

    $quizSubTitle.css("font-size", `${quizSubTitleStyle.fontSize}px`);
    $quizSubTitle.css("color", quizSubTitleStyle.color);
}

// 페이지 로딩시 스타일적용, 버튼 이벤트 바인딩
$(document).ready(function () {
    quizBtnStyleFunction();
    quizTitleStyleFunction();

    addBtnEvent();
    addQuizBtnEvent();
});

//==========================================

// main페이지 시작하기 버튼 이벤트
function addBtnEvent() {
    $(".rec-box").on("click", ".btn-sec__btn", function () {
        console.log(pageNo);
        console.log(resultPages);

        $(".rec-box").html(
            `
      <div class="hairnada-logo">hairnada</div>
      <main class="quiz-main">
          <div class="quiz-progress-bg">
            <div class="quiz-count"><span class="current-count">${
                pageNo + 1
            }</span>/<span class="max-count">${maxPage}</span></div>
            <div class="quiz-progress"></div>
          </div>
          <section class="quiz-around">
          </section>
      </main>
      `
        );

        $(".quiz-around").html(resultPages[pageNo]);

        quizTitleStyleFunction();
        quizBtnStyleFunction();
    });
}

// 퀴즈페이지 상단의 bar 조절 함수
function pageBar(maxPage) {
    let $barBg = $(".quiz-progress-bg");
    let $bar = $(".quiz-progress");
    let per = parseInt($barBg.css("width").slice(0, -2)) / maxPage;

    $bar.css("width", per * pageNo);
}

//quiz페이지 버튼 이벤트
function addQuizBtnEvent() {
    $(".rec-box").on("click", ".quiz-btn-sec__btn", function () {
        let maxCount = $(".max-count").text();
        let answer = $(this).text();

        answerList.push(answer);
        pageNo++;

        $(".quiz-around").html(resultPages[pageNo]);
        pageBar(maxPage);

        quizTitleStyleFunction();
        quizBtnStyleFunction();

        if (maxCount == pageNo) {
            setTimeout(function () {
                $(".rec-box").html(finalPage);
                callFunc(answerList);
            }, 1000);

            setTimeout(() => {
                $(".quiz-progress-bg").css("transition", "all 0.3s linear");
                $(".quiz-progress-bg").css("transform", "scaleX(0)");
            }, 400);
            //+++++++++++++++++++++++++++++++++++++
            $(".quiz-around").css("transition", "all 1s linear");
            $(".quiz-around").css("opacity", "0");
        }
    });
}

// 버튼 html 생성하는 함수
function makeQuizBtns(btns) {
    let btnHtml = "";
    for (let i = 0; i < btns.length; i++) {
        btnHtml += `<button class="quiz-btn-sec__btn">${btns[i]}</button>`;
    }

    return btnHtml;
}

/**
 * 퀴즈 페이지 생성하는 함수
 * btnList는 2중 배열을 사용함
 *
 * @param {Number} numberOfPage
 * @param {String[]} mainTitle
 * @param {String[]} subTitle
 * @param {Array<String[]>} btnList 페이지[버튼]
 *
 * @example
 * quiz.makeQuizPage(
 3,
 ["Q1", "Q2", "Q3"],
 ["당신의 성별은?", "당신의 얼굴 형은?", "당신의 성격은?"],
 [
 ["남", "여"],
 ["둥글다.", "길다.", "계란형이다."],
 ["게으르다.", "부지런하다.", "더럽다.", "착하다."],
 ]
 );
 */
export function makeQuizPage(numberOfPage, mainTitle, subTitle, btnList) {
    maxPage = numberOfPage;

    let pageList = [];
    for (let i = 0; i < numberOfPage; i++) {
        let layout = `
    <section class="quiz-content-sec">
    <div class="quiz-main-title">${mainTitle[i]}</div>
    <div class="quiz-sub-title">${subTitle[i]}</div>
  </section>
  <section class="quiz-btn-sec">
    ${makeQuizBtns(btnList[i])}
  </section>
    `;
        pageList.push(layout);
    }

    resultPages = [...pageList];

    console.log(resultPages);
}

/**
 * 메인 타이틀 설정 함수 모듈
 *
 * @param {Number} fontSize
 * @param {String} color
 */
export function setQuizMainTitleStyle(fontSize, color) {
    quizMainTitleStyle = {
        fontSize: fontSize,
        color: color,
    };
}

/**
 * 서브 타이틀 설정 함수 모듈
 *
 * @param {Number} fontSize
 * @param {String} color
 */
export function setQuizSubTitleStyle(fontSize, color) {
    quizSubTitleStyle = {
        fontSize: fontSize,
        color: color,
    };
}

/**
 * 버튼 스타일 설정 함수 모듈
 *
 * @param {String} backgroundColor
 * @param {Number} borderRadius
 * @param {String} color
 * @param {String} border
 */
export function setQuizBtnStyle(backgroundColor, borderRadius, color, border) {
    quizBtnStyle = {
        backgroundColor: backgroundColor,
        borderRadius: borderRadius,
        color: color,
        border: border,
    };
}

/**
 *
 * @param {Function} callBack
 */
export function setApi(callBack) {
    callFunc = callBack;
}

/**
 * 결과페이지 html을 설정하는 함수
 *
 * @param {String} finalPageHtml  html형식으로 받으면 출력한다.
 */
export function setFinalPage(finalPageHtml) {
    finalPage = finalPageHtml;
}
