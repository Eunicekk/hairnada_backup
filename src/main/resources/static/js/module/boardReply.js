export function add(boardReply, callback, error){
    $.ajax({
       url : '/boardReply/reply',
       type : 'post',
       data : JSON.stringify(boardReply),
       contentType : 'application/json; charset=utf-8',
       success : function (){
           if (callback){
               callback();
           }
       },
        error : error
    });
}

export function getList(boardNumber, callback, error){
    $.ajax({
        url : `/boardReply/list/${boardNumber}`,
        type : 'get',
        dataType : 'json',
        success : function (result){
            if (callback){
                callback(result);
            }
        },
        error : error
    });
}
export function getView(boardReplyNumber, callback, error){
    $.ajax({
       url : `/boardReply/${boardReplyNumber}`,
       type : 'get',
       dataType : 'json',
       success : function (result){
           if (callback){
               callback(result);
           }
       } ,
        error : error
    });
}

export function modify(boardReply, callback, error){
    $.ajax({
       url : `/boardReply/${boardReply.boardReplyNumber}`,
       type : 'patch',
       data : JSON.stringify(boardReply),
        contentType : 'application/json; charset=utf-8',
        success : function (){
           if (callback){
               callback();
           }
        },
        error : error
    });
}

export function getListPage(pageInfo, callback, error){
    $.ajax({
        url : `/boardReply/list/${pageInfo.boardNumber}/${pageInfo.page}`,
        type : 'get',
        dataType : 'json',
        success : function (result){
            if (callback){
                callback(result);
            }
        },
        error : error
    });
}


export function remove(boardReplyNumber, callback, error){
    $.ajax({
       url : `/boardReply/${boardReplyNumber}`,
        type : 'delete',
        success : function (){
           if (callback){
               callback();
           }
        },
        error : error
    });
}


export function timeForToday(value){
    const today = new Date();
    const timeValue = new Date(value);

    console.log(today);
    console.log(timeValue);

    const betweenTime = Math.floor((today.getTime() - timeValue.getTime()) / 1000 / 60);

    console.log(betweenTime);

    if(betweenTime < 1) { return "방금 전"; }
    if(betweenTime < 60) {
        return `${betweenTime}분 전`;
    }

    const betweenTimeHour = Math.floor(betweenTime / 60);
    if(betweenTimeHour < 24){
        return `${betweenTimeHour}시간 전`;
    }

    const betweenTimeDay = Math.floor(betweenTime / 60 / 24);
    if(betweenTimeDay < 365){
        return `${betweenTimeDay}일 전`;
    }

    return `${Math.floor(betweenTimeDay / 365)}년 전`;
}