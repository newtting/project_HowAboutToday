$(function() {

    $('#faqAll').click(function(event){
        $('.col-board').css('display', 'block');
    });

    $('.faq').click(function(){

        $('.col-board').css('display', 'none');

        let id = $(this).attr("id");
        $('#' + id  + '-content').css('display', 'block');
    });

});