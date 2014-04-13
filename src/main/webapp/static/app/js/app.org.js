(function($) {
    $('.closed-click').click(function(event) {
        $(this).parents('.btn-group').removeClass("open");
    });

    $(document).bind("ajaxsuccess", function(e) {
        $('a.closed-click').click(function(event) {
            $(this).parents('.btn-group').removeClass("open");
        });
    });


})(jQuery);