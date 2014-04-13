define(function(require, exports, module) {

    var $ = window.jQuery;

    function init(tagName) {
        var els = document.getElementsByTagName(tagName);
        if (els.length > 0) {
            var requires = [];
            for (var i = 0; i < els.length; i++) {
                requires[i] = els[i].getAttribute('src');
            }
            require.async(requires);
        }
    };

    function applyAll() {
        init('require');
        $(document).bind('ajaxSuccess', function(e) {
            init('require');
        });
    };

    applyAll();

    module.exports = {
        init: init,
        applyAll: applyAll
    };

});
