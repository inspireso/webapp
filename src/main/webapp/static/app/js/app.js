define(function(require, exports, module) {

    var $ = window.jQuery;
    var util = require("./controls/__init__");

    var jsArray = [

    ];

    var jsArrayDebug = [

    ];

    App = {
        production: true,
        version: 1.0
    };

    App.require = require;
    App.require.async = require.async;

    App.overrideStyle = function() {
        var self = this; // this.fixIE();
        $(document).ready(function($) {
            self.require.async(self.production ? jsArray : jsArrayDebug);

        })
        return this;

    };

    App.init = function(debug) {
        this.production = !debug;
        this.overrideStyle();

        // $(window).unload( function () { alert("Bye now!"); } );
    };

    module.exports = App;

});
