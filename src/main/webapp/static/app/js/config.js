/*!
 * config.js
 *
 * https://github.com/inspireso
 *
 * Copyright 2014 Inspireso and/or its affiliates.
 * Licensed under the Apache 2.0 License.
 *
 */
(function() {

    seajs.config({
        base: insp.assets,
        alias: {}
    });

    seajs.use("all/app/1.0.1/app", function(app) {
        app.init(false)
    });
})();