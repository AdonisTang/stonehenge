package com.bornstone.stonehenge.demo.controller;

import com.bornstone.stonehenge.demo.manager.TaskManager;

/**
 * Created by King.Tang on 14-10-10.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
//@Service
public class TaskController {
    //    @Autowired
    private TaskManager taskManager;

    public String queryTask() {
        return "query";
    }
}
