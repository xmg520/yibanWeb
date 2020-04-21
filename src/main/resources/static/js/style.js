var windowH = $(window).height();

$('#myModal').find('.modal-dialog').css({
    'margin-top': windowH / 2 - 406
});
$('#myModa2').find('.modal-dialog').css({
    'margin-top': windowH / 2 - 108
});
$('#myModa3').find('.modal-dialog').css({
    'margin-top': windowH / 2 - 210
});
$('#myModa4').find('.modal-dialog').css({
    'margin-top': windowH / 2 - 143
});
$('.top').css('height',window.innerHeight + 'px');
$('.title').css('margin-top',(window.innerHeight - 732)/2 + 'px');
$('#signIn').css('margin-left',((window.innerWidth - 460) / 2) + 'px');
$('#editSignIn').css('margin-left',((window.innerWidth - 460) / 2) + 280 + 'px');


