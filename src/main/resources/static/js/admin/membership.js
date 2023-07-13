
findList();

function findList(){
    $.ajax({
        url: "/adminR/acceptList",
        type: "post",
        success: function (result) {

            console.log("succccc");
            let levelNumbers = [];

            // 등업이 완료된 목록만 등급 번호를 levelNumbers 배열에 추가
            for (let i = 0; i < result.list.length; i++) {
                let levelNumber = result.list[i].levelNumber;
                levelNumbers.push(levelNumber);
            }

            $('.num').each(function () {
                let levelNumber = parseInt($(this).text());
                console.log(levelNumber);
                console.log(levelNumbers);

                if (levelNumbers.includes(levelNumber)) {
                    $(this).closest('.member-list').find('li').addClass('add');
                    $(this).closest('.member-list').find('a').css('pointer-events', 'none')
                        .on('click', function(e) {
                        e.preventDefault();
                    });
                }
            })
        }
})
}

