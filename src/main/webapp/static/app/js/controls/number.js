define(function(require, exports, module) {

    var $ = window.jQuery;

    var $doc = $(document);

    function onkeydown() {
        if (event.keyCode == 37 || event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 39 || event.keyCode == 46 || event.keyCode == 190 || event.keyCode == 110 || (event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105)) {

        } else {
            return false;
        }
    };

    function init(selector) {
        $doc.on('keydown', selector, onkeydown);
    };


    function applyAll() {
        init('input[role=number]:visible');
    };

    applyAll();

    module.exports = {
        init: init,
        applyAll: applyAll
    };

});
