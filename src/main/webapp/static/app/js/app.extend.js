/**
 * 动态显示数据加载提示框
 */
(function($) {
    var $global = $('#global-waiting');
    if ($global) {
        $global.ajaxStart(function(e) {
            $('#global-waiting').popover('show');
            $('#global-message .popover-content').attr('timeout', 0);

        }).ajaxStop(function(e) {
            var timeout = $('#global-message .popover-content').attr('timeout');

            if (timeout > 0) {
                setTimeout('$("#global-waiting").popover("hide")', timeout);

            } else {
                $('#global-waiting').popover('hide');

            }

        });
    }


})(window.jQuery);


(function($) {
    /**
     * 浏览器版本检测
     */
    if ($.browser.msie && $.browser.version < 8) {
        $('#browser-alert').show();
    }

    var $carousel = $('.carousel');
    if ($carousel.size() > 0 && $carousel.carousel) {
        $carousel.carousel();
    }

})(window.jQuery);


/**
 * 处理快速查询的状态，避免服务器的来回刷新。
 */
(function($) {
    $doc.on('hidden', '#quick-filter', function(e) {
        var $target = $(e.target);
        $target.prev('.accordion-heading').children('a:first')[$target.hasClass('in') ? 'addClass' : 'removeClass']('dropup');

    });

    $doc.on('shown', '#quick-filter', function(e) {
        var $target = $(e.target);
        $target.prev('.accordion-heading').children('a:first')[$target.hasClass('in') ? 'addClass' : 'removeClass']('dropup');

    });

    $doc.on('mousedown', '#quick-filter li', function(e) {
        var $target = $(e.target);
        $(this).parent().children('li').removeClass('active');
        $(this).addClass('active');

    });

    $doc.on('mousedown', '#quick-filter-all>li', function(e) {
        var $target = $(e.target);
        $("#quick-filter li").removeClass('active');

    });

    $doc.on('mousedown', '#quick-filter[data-exclusive=true] li', function(e) {
        var $target = $(e.target);
        $("#quick-filter li").removeClass('active');
        $(this).addClass('active');

    });

    $('#quick-filter>div>div>a:first').click();
    // $('#quick-filter>div li.default>a:first').click();

})(window.jQuery);


(function($) {
    /**
     * 动态显示提示消息
     */
    MessageActions = {
        flash: function(opts) {
            if (opts.message) {
                $('#global-message .popover-content')
                    .text(opts.message)
                    .attr('timeout', opts.timeout);
            }
        }
    };


    TextAreaActions = {
        ckeditor: function(id, opts) {
            var editor = CKEDITOR.replace(id, opts);
            editor.on("instanceReady", function() {
                this.document.on("keyup", sync);
                this.document.on("paste", sync);
                this.document.on("keypress", sync);
                this.document.on("blur", sync);
                this.document.on("change", sync);
            });

            function sync() {
                editor.updateElement();
            };

            // var form = $('#' + id).closest('form');
            // form.submit(function(event) {
            //     event.preventDefault();
            //     $('#' + id).val(editor.getData());
            //     return ture;
            // });

        }
    };


})(jQuery);


/**
 * 覆盖jquery-ui中的时间控件默认配置
 */
(function($) {
    if ($.ui && $.ui.tapestryFieldEventManager) {
        var tapestryFieldEventManager = $.ui.tapestryFieldEventManager;
        if (tapestryFieldEventManager) {
            tapestryFieldEventManager.prototype.getIcon = function() {
                return false;
            };
        };
    }


})(window.jQuery);


