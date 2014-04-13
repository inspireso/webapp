(function($) {
    String.prototype.format = function(tokens) {
        var formatted = this;
        for (var token in tokens)
            if (tokens.hasOwnProperty(token))
                formatted = formatted.replace(RegExp('{' + token + '}', 'g'), tokens[token]);
        return formatted;
    };


    var READY_STATE_RE = /^(?:loaded|complete|undefined)$/;
    var IS_CSS_RE = /\.(?:(css|gzcss))(?:\?|$)/i;

    var node = document.getElementById("inspnode");
    var base = node.getAttribute("base") || "/static/";
    (base.slice(-1) === "/") || (base += "/");

    var debug = node.getAttribute("debug") || "false";

    var css = [
        'all/css/all.in.one.min.css'
    ];

    var debugCss = [
        'icons/css/font-awesome.css',
        'bootstrap/css/bootstrap.css',
        // 'bootstrap/css/google-bootstrap.css',
        'messenger/css/messenger.css',
        'messenger/css/messenger-theme-future.css',
        'app/css/app.css',
        'bootstrap/css/bootstrap-responsive.css',
        'app/css/app.responsive.css'

    ];

    var isArray = Array.isArray || function(obj) {
            return Object.prototype.toString.call(obj) === '[object Array]'
        };

    var require = function(urls, callback) {
        if (!isArray(urls))
            urls = [urls];

        var head = document.getElementsByTagName('head')[0] || doc.documentElement;
        var len = urls.length - 1;

        for (var i = 0; i <= len; i++) {
            var url = base + urls[i];
            var isCSS = IS_CSS_RE.test(url)
            var node = document.createElement(isCSS ? 'link' : 'script')

            if ((len == i) && (typeof callback == 'function')) {
                node.onload = node.onerror = node.onreadystatechange = function() {
                    if (READY_STATE_RE.test(node.readyState)) {
                        // Ensure only run once and handle memory leak in IE
                        node.onload = node.onerror = node.onreadystatechange = null;
                        // Remove the script to reduce memory leak
                        if (!isCSS) {
                            head.removeChild(node)
                        }
                        // Dereference the node
                        node = null;
                        callback();
                    }
                }
            }
            if (isCSS) {
                node.rel = 'stylesheet';
                node.href = url;
            } else {
                node.async = true;
                node.src = url;
            }
            head.appendChild(node);
        }
    };


    require(debug === 'true' ? debugCss : css);

    var extend = function($) {
        window.$doc = $(document);
        $.browser.version = (window.navigator.userAgent.toLowerCase().match(/.(?:rv|it|ra|ie)[\/: ]([\d.]+)/) || [0, '0'])[1];

        //if IE 6
        if ($.browser.msie && $.browser.version == 6) {
            require([
                    'ie6/css/ie6.min.css',
                    'ie6/js/ie6.min.js'
                ],
                function() {
                    $('.row div[class^="span"]:last-child').addClass("last-child");
                    $('[class*="span"]').addClass("margin-left-20");
                    $(':button[class="btn"], :reset[class="btn"], :submit[class="btn"], input[type="button"]').addClass("button-reset");
                    $(":checkbox").addClass("input-checkbox");
                    $('[class^="icon-"], [class*=" icon-"]').addClass("icon-sprite");
                    $(".pagination li:first-child a").addClass("pagination-first-child");

                });

        }

        //if IE 7
        if ($.browser.msie && $.browser.version < 8) {
            require('icons/css/font-awesome-ie7.min.css');

        }

        // if IE8
        if ($.browser.msie && $.browser.version < 9) {
            require('jquery/jquery.placeholder.min.js', function() {
                $('input, textarea').placeholder();
                $(document).bind("ajaxSuccess", function(e) {
                    $('input, textarea').placeholder();
                });
            });

        }

        //if less IE 9
        if ($.browser.msie && $.browser.version < 9) {
            require('html5/html5shiv.min.js');

        }

        // 生产环境会统一打包压缩成一个文件，无须单独加载
        var debugjs = [
            'bootstrap/js/bootstrap.js'
            ,'messenger/js/messenger.min.js'
            ,'messenger/js/messenger-theme-future.js'
            ,'app/js/app.extend.js'
            ,'bootstrap/js/bootstrap-hover-dropdown.js'
        ];

        require(debug === 'true' ? debugjs : []);


        $.extend({
            require: require
        });

        // $.noConflict();

    };

    var query = function(callback) {
        if (window.jQuery) {
            callback(window.jQuery);
        } else {
            require('jquery/jquery-1.7.2.min.js', function() {
                callback(window.jQuery)
            });
        }
    };

    var ready = function(callback) {
        query(function($) {
            $(document).ready(function($) {
                callback($);
            });
        })

    };


    window.insp = {};
    window.insp.assets = base;
    window.insp.debug = (debug === 'true' ? true : false);
    window.insp.require = require;
    window.insp.ready = ready;

    query(extend);

})(window.jQuery);
