$('#modalExcluir').on('show.bs.modal', function (event) {
    var button    = $(event.relatedTarget);
    var descricao = button.data('descr');
    var modal     = $(this);

    modal.find('.modal-body p').html('Deseja realmente excluir: <strong>'  + descricao + '</strong> ?');

    $('#btnModalSim').click(function(){
        $(button).find('form').submit();
    });
})