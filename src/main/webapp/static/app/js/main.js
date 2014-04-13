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