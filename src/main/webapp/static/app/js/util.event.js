/*!
 * util.event.js
 *
 * https://github.com/inspireso
 *
 * Copyright 2014 Inspireso and/or its affiliates.
 * Licensed under the Apache 2.0 License.
 *
 */
var util = (function(util) {

    function handleEvent(event) {    
        var returnValue = true,
            i = 0;    
        event = event || fixEvent(window.event);    
        var handlers = this.events[event.type],
            length = handlers.length;    
        for (; i < length; i++) {        
            if (handlers[i].call(this, event) === false) {            
                returnValue = false;        
            }    
        }    
        return returnValue;
    }

    function fixEvent(event) {    
        event.preventDefault = fixEvent.preventDefault;    
        event.stopPropagation = fixEvent.stopPropagation;    
        return event;
    }

    fixEvent.preventDefault = function() {    
        this.returnValue = false;
    };

    fixEvent.stopPropagation = function() {    
        this.cancelBubble = true;
    };

    util.addEvent = function(element, type, fun) {    
        if (!element.events) element.events = {};                
        var handlers = element.events[type];    
        if (!handlers) {        
            handlers = element.events[type] = [];        
            if (element['on' + type]) {                    
                handlers[0] = element['on' + type];        
            }    
        }    
        handlers.append(fun, true);
        element['on' + type] = handleEvent;
    };

    util.removeEvent　 = function(element, type, fun) {    
        if (element.events && element.events[type]) {        
            element.events[type].remove(fun);    
        }
    };

    return util;

})(window.util || {});