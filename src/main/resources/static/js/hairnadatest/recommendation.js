// 기본 스타일 객체
let btnStyle = {
    backgroundColor: "rgb(146, 114, 236)",
    borderRadius: 10,
    color: "white",
    border: "none",
};

let mainTitleStyle = {
    fontSize: 50,
    color: "rgb(146, 114, 236)",
};

let subTitleStyle = {
    fontSize: 20,
    color: "#222",
    fontWeiht: 500,
};

//============================

// 기본 타이틀
let [mainTitleText, subTitleText] = ["test main title", "test sub title"];

/**
 * main페이지 타이틀(컨텐트) 설정 함수
 *
 * @param {String} mainTitle
 * @param {String} subTitle
 */
export function setMainText(mainTitle, subTitle) {
    mainTitleText = mainTitle;
    subTitleText = subTitle;
}

/**
 * main html을 반환하는 함수
 *
 * @returns main html 반환
 */
export function main() {
    return `
  <div class="hairnada-logo">
    <img src="/img/logo.png" alt="로고" height="60px">
  </div>
  <section class="main">
  <div class="space"></div>
  <section class="around">
    <section class="content-sec">
      <div class="main-title">${mainTitleText}</div>
      <div class="sub-title">${subTitleText}</div>
    </section>
    <section class="btn-sec">
      <button class="btn-sec__btn">시작하기</button>
      <form action="/" method="get">
          <button class="btn-sec__btn2">메인으로</button>
        </form>
    </section>
  </section>
  </section>
  `;
}

/**
 * 메인 타이틀 설정 함수 모듈
 *
 * @param {Number} fontSize
 * @param {String} color
 */
export function setMainTitleStyle(fontSize, color) {
    mainTitleStyle = {
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
export function setSubTitleStyle(fontSize, color) {
    subTitleStyle = {
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
export function setBtnStyle(backgroundColor, borderRadius, color, border) {
    btnStyle = {
        backgroundColor: backgroundColor,
        borderRadius: borderRadius,
        color: color,
        border: border,
    };
}

//==============================================

// btn 스타일 설정 함수
function btnStyleFunction() {
    let $btn = $(".btn-sec__btn");
    $btn.css("background-color", btnStyle.backgroundColor);
    $btn.css("border-radius", `${btnStyle.borderRadius}px`);
    $btn.css("color", btnStyle.color);
    $btn.css("border", btnStyle.border);
}

// function btnStyleFunction2() {
//     let $btn = $(".btn-sec__btn2");
//     $btn.css("background-color", btnStyle.backgroundColor);
//     $btn.css("border-radius", `${btnStyle.borderRadius}px`);
//     $btn.css("color", btnStyle.color);
//     $btn.css("border", btnStyle.border);
// }


// 타이틀 스타일 설정 함수(main, sub)
function titleStyleFunction() {
    let [$mainTitle, $subTitle] = [$(".main-title"), $(".sub-title")];

    $mainTitle.css("font-size", `${mainTitleStyle.fontSize}px`);
    $mainTitle.css("color", mainTitleStyle.color);

    $subTitle.css("font-size", `${subTitleStyle.fontSize}px`);
    $subTitle.css("color", subTitleStyle.color);
}

// 스타일 함수 페이지에 반영
$(document).ready(function () {
    btnStyleFunction();
    // btnStyleFunction2();
    titleStyleFunction();
});

console.log("recommendation.js");