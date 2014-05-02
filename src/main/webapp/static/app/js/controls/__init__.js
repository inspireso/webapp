/*!
 * __init__.js: import controls
 *
 * https://github.com/inspireso
 *
 * Copyright 2014 Inspireso and/or its affiliates.
 * Licensed under the Apache 2.0 License.
 *
 */

define(function(require, exports, module) {

    if(!window.$doc){
        window.$doc = $(document);
     }

    function applyAll() {
        require('./submit');
        require('./checkbox');
        require('./confirm');
        require('./jump');
        require('./link');
        require('./messenger');
        require('./money');
        require('./number');
        require('./pagination');
        require('./required');
        require('./roles');
        require('./submit');
        require('./trim');
        require('./validity');
        require('./dialog');
        require('./async');

    };

    applyAll();


});