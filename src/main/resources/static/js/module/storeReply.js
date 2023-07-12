export function add(storeReply, callback, error){
    $.ajax({
       url : '/storeReply/reply',
       type : 'post',
       data : JSON.stringify(storeReply),
       contentType : 'application/json; charset=utf-8',
       success : function (){
           if (callback){
               callback();
           }
       },
        error : error
    });
}

export function getList(storeNumber, callback, error){
    $.ajax({
        url : `/storeReply/list/${storeNumber}`,
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
export function getView(storeReplyNumber, callback, error){
    $.ajax({
       url : `/storeReply/${storeReplyNumber}`,
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

export function modify(storeReply, callback, error){
    $.ajax({
       url : `/storeReply/${storeReply.storeReplyNumber}`,
       type : 'patch',
       data : JSON.stringify(storeReply),
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
        url : `/storeReply/list/${pageInfo.storeNumber}/${pageInfo.page}`,
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


export function remove(storeReplyNumber, callback, error){
    $.ajax({
       url : `/storeReply/${storeReplyNumber}`,
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