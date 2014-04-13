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
