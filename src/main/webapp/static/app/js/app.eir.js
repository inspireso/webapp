(function($) {
    $(document).on('click', '#cart-pin', function(e) {
        var $cart = $('#cart');
        if ($cart.hasClass('hide')) {
            $cart.removeClass('hide');
        } else {
            $cart.addClass('hide');
        }

    });

    $('a[data-toggle="tab"]').on('shown', function(e) {
        $($(e.target).attr('href') + '-toolbar').show();
        $($(e.relatedTarget).attr('href') + '-toolbar').hide();
    })


})(jQuery);
