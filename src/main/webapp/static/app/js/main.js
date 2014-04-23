/*!
 * main.js
 *
 * https://github.com/inspireso
 *
 * Copyright 2014 Inspireso and/or its affiliates.
 * Licensed under the Apache 2.0 License.
 *
 */
(function() {

    var callback = function(insp) {
        var preload = [];

        seajs.config({
            base: insp.assets,
            alias: {},
            preload: preload
        });


        seajs.use("app/js/app", function(app) {
            app.init(true);
        });
    };

    insp.require("sea/sea.js", function() {
        callback(window.insp)
    });

    // insp.require([
    //     "bootstrap/js/bootstrap.js",
    //     "app/js/app.extend.js"
    // ]);

})();