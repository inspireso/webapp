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

        //调试的时候异步加载页面上<require>标签指定的脚本，生产环境统一压缩到同一个文件使用。
        if (insp.debug) {
            require('./async');
        }

    };

    applyAll();


});