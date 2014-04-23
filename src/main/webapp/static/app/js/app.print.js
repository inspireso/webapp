/*!
 * app.print.js
 *
 * https://github.com/inspireso
 *
 * Copyright 2014 Inspireso and/or its affiliates.
 * Licensed under the Apache 2.0 License.
 *
 */
(function($) {
    $(document).ready(function($) {
        if (/msie/.test(navigator.userAgent.toLowerCase())) {
            document.all.WebBrowser.ExecWB(6, 2);
            window.opener = null;
            window.open('', '_self');
            window.close();
        } else if (window.chrome) {
            window.print();
            // this.onmouseover = (function() { window.close(); });
            setTimeout(function() {
                window.close();

            }, 10000); //give them 10 seconds to print, then close
        } else {
            window.print();
            window.close();
        }
    });

})(jQuery);
