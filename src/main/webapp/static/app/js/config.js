(function() {

    seajs.config({
        base: insp.assets,
        alias: {}
    });

    seajs.use("all/app/1.0.1/app", function(app) {
        app.init(false)
    });
})();