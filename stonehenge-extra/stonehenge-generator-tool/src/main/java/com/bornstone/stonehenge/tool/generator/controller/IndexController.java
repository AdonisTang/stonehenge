package com.bornstone.stonehenge.tool.generator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by King.Tang on 14-11-3.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
