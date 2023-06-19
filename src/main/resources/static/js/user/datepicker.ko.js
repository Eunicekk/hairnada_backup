(function ($) {
  $.fn.datepicker.language["ko"] = {
    days: [
      "일요일",
      "월요일",
      "화요일",
      "수요일",
      "목요일",
      "금요일",
      "토요일",
    ],
    daysShort: ["일", "월", "화", "수", "목", "금", "토"],
    daysMin: ["일", "월", "화", "수", "목", "금", "토"],
    months: [
      "01월",
      "02월",
      "03월",
      "04월",
      "05월",
      "06월",
      "07월",
      "08월",
      "09월",
      "10월",
      "11월",
      "12월",
    ],
    monthsShort: [
      "01",
      "02",
      "03",
      "04",
      "05",
      "06",
      "07",
      "08",
      "09",
      "10",
      "11",
      "12",
    ],
    today: "Today",
    clear: "Clear",
    dateFormat: "yyyy-mm-dd",
    timeFormat: "hh:ii:ss",
    firstDay: 0,
  };
})(jQuery);

function datePickerSet(sDate, eDate, flag) {
  //시작 ~ 종료 2개 짜리 달력 datepicker
  if (
    !isValidStr(sDate) &&
    !isValidStr(eDate) &&
    sDate.length > 0 &&
    eDate.length > 0
  ) {
    var sDay = sDate.val();
    var eDay = eDate.val();

    if (flag && !isValidStr(sDay) && !isValidStr(eDay)) {
      //처음 입력 날짜 설정, update...
      var sdp = sDate.datepicker().data("datepicker");
      sdp.selectDate(new Date(sDay.replace(/-/g, "/"))); //익스에서는 그냥 new Date하면 -을 인식못함 replace필요

      var edp = eDate.datepicker().data("datepicker");
      edp.selectDate(new Date(eDay.replace(/-/g, "/"))); //익스에서는 그냥 new Date하면 -을 인식못함 replace필요
    }

    //시작일자 세팅하기 날짜가 없는경우엔 제한을 걸지 않음
    if (!isValidStr(eDay)) {
      sDate.datepicker({
        maxDate: new Date(eDay.replace(/-/g, "/")),
      });
    }
    sDate.datepicker({
      language: "ko",
      autoClose: true,
      onSelect: function () {
        datePickerSet(sDate, eDate);
      },
    });

    //종료일자 세팅하기 날짜가 없는경우엔 제한을 걸지 않음
    if (!isValidStr(sDay)) {
      eDate.datepicker({
        minDate: new Date(sDay.replace(/-/g, "/")),
      });
    }
    eDate.datepicker({
      language: "ko",
      autoClose: true,
      onSelect: function () {
        datePickerSet(sDate, eDate);
      },
    });

    //한개짜리 달력 datepicker
  } else if (!isValidStr(sDate)) {
    var sDay = sDate.val();
    if (flag && !isValidStr(sDay)) {
      //처음 입력 날짜 설정, update...
      var sdp = sDate.datepicker().data("datepicker");
      sdp.selectDate(new Date(sDay.replace(/-/g, "/"))); //익스에서는 그냥 new Date하면 -을 인식못함 replace필요
    }

    sDate.datepicker({
      language: "ko",
      autoClose: true,
    });
  }

  function isValidStr(str) {
    if (str == null || str == undefined || str == "") return true;
    else return false;
  }
}
