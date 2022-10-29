$(function() {

    // FAQ 카테고리 클릭 시
    $('#faqAll').click(function(){
        $('.col-board').css('display', 'block');
    });

    $('.faq').click(function(){

        let id = $(this).attr("id");

        $('.col-board').css('display', 'none');
        $('#' + id  + '-content').css('display', 'block');
    });

    let page = 0;


    // Board, Event 더보기 버튼 클릭 시
    $('#loadMore').click(function(){

        page += 1;
        let listData = "";

        $.ajax({

            url: 'notice-more?page=' + page,
            type: 'GET',
            data: listData,
            contentType: 'application/json; charset=utf-8',

        }).done(function(result){

            listLow = low(result);
            listData = result;

//            $('#list-more').append(listLow); // #list-more의 안쪽의 마지막 위치에 출력
            $('#loadMore').before(listLow); // #loadMore의 바깥쪽의 바로 위에 출력

            if(result.content.length < 5){
                alert("게시글이 더 이상 존재하지 않습니다.");
                $('#loadMore').css('display', 'none');
            }
        });
    });

    // Board, Event 더보기 Content
    const low = function (result){

        let board = result.content;
        let newlow = "";

        for (i = 0; i < board.length; i++) {

            newlow += `<div class="col-lg-4 responsive-column col-board">`
            newlow += `<div class="card-item blog-card">`
            newlow += `<input type="hidden" id="${board[i].boardNum}">`
            newlow += `<div class="card-footer d-flex align-items-center justify-content-between hwt-board-list" onclick="|location.href=\'@{|/notice/${board[i].boardNum}|}\'|">`
            newlow += `<div class="author-content d-flex hwt-board-title">`
            newlow += `<div class="author-bio"><a class="author__title">${board[i].boardTitle}</a></div>`
            newlow += `<div class="hwt-board-date"><a class="author__title">${board[i].boardCreate}</a></div>`
            newlow += `</div>`
            newlow += `<div class="post-share"><ul><li><a><i class="la la-share icon-element hwt-icon"></i></a></li></ul></div>`
            newlow += `</div></div></div>`
        }

        return newlow;
    }

});