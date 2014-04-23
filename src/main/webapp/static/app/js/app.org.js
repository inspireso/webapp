/**
 * app.org.js
 *
 * https://github.com/inspireso
 *
 * Copyright 2014 Inspireso and/or its affiliates.
 * Licensed under the Apache 2.0 License.
 *
 */
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