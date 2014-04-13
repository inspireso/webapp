define(function(require, exports, module) {

    var $ = window.jQuery;
    var $doc = $(document);

    function init(selector) {
        $(selector).each(function() {
            if (this.setCustomValidity) {
                this.setCustomValidity($(this).data('title'));
            }
        });
    };

    function applyAll() {
        init('input[data-title]');
        $doc.bind('ajaxSuccess', function(e) {
            init('input[data-title]:visible');
        });

    };


    applyAll();

    module.exports = {
        init: init,
        applyAll: applyAll
    };

});
