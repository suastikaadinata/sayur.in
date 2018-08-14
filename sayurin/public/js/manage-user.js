$('.hapus-user-btn').click(function () {
    var form = $('.hapus-user form');
    form.attr('action', form.data('url') + '/' + $(this).data('id'));
});