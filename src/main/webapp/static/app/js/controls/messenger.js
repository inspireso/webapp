/*!
 * messenger.js
 *
 * https://github.com/inspireso
 *
 * Copyright 2014 Inspireso and/or its affiliates.
 * Licensed under the Apache 2.0 License.
 *
 */
define(function(require, exports, module) {

    var $ = window.jQuery;

    function config() {
        Messenger.options = {
            extraClasses: 'messenger-fixed messenger-on-bottom messenger-on-right',
            theme: 'future'
        };

    }

    function init(selector) {
        var $messenger = $(selector);
        var message = $messenger.data('message');
        var target = $messenger.data('target');
        var label = $messenger.data('label');
        var messenger = Messenger().post({
            message: message,
            type: 'info',
            actions: {
                run: {
                    label: label,
                    action: function() {
                        location.href = target;
                    }
                },

                cancel: {
                    label: '取消',
                    action: function() {
                        return messenger.cancel();
                    }
                }
            }
        });
    }

    function applyAll() {
        var selector = 'div[role=messenger]';
        var $messenger = $(selector);
        if ($messenger.size() == 0 || $messenger.attr('disabled')) {
            return;
        }

        init(selector);

    };

    config();
    applyAll();

    module.exports = {
        init: init,
        applyAll: applyAll
    };

});
