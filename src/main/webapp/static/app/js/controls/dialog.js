define(function(require, exports, module) {
    var $ = window.jQuery;

    function init(selector) {
        var $dialog = $(selector);
        $dialog.modal({
            'backdrop': false
        });


    };

    function applyAll() {
        init('div[role=dialog]');
        $(document).bind('ajaxSuccess', function(e) {
            init('div[role=dialog]');
        });
    };

    applyAll();

    module.exports = {
        init: init,
        applyAll: applyAll
    }

});