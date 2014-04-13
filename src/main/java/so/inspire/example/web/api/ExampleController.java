/*
 * Copyright (c) 2014, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.example.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试类
 * 
 * @author Inspireso Team
 * 
 */
@Controller
@RequestMapping("/example/*")
public class ExampleController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody
    String hello(@RequestParam(value = "result", required = false) String result) {
        return result;

    }

}
