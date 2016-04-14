package com.bornstone.stonehenge.tool.generator.controller;

import com.bornstone.stonehenge.tool.generator.common.Constants;
import com.bornstone.stonehenge.tool.generator.entity.DatabaseEntity;
import com.bornstone.stonehenge.tool.generator.manager.DataBaseManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by King.Tang on 14-11-3.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
@Controller
@RequestMapping("/database")
public class DataBaseController {
    private static final Logger logger = Logger.getLogger(DataBaseController.class);

    @Autowired
    private DataBaseManager dataBaseManager;

    @RequestMapping(value = "/add.htm", method = RequestMethod.POST)
    public String add(DatabaseEntity databaseEntity, String path) {
        databaseEntity.setPath(path + "/project.define");
        dataBaseManager.save(databaseEntity);
        return "redirect:/database/show.htm?path=" + path;
    }

    @RequestMapping(value = "/show.htm")
    public String show(String path, HttpSession session) {
        DatabaseEntity databaseEntity = dataBaseManager.get(path);
        session.setAttribute(Constants.SESSION_PROJECT_DEFINE, databaseEntity);
        return "/database/show";
    }

    @RequestMapping(value = "/edit.htm")
    public String edit(DatabaseEntity databaseEntity, HttpSession session) {
        DatabaseEntity databaseEntityInSession = (DatabaseEntity) session.getAttribute(Constants.SESSION_PROJECT_DEFINE);
        databaseEntity.setTableEntities(databaseEntityInSession.getTableEntities());
        session.setAttribute(Constants.SESSION_PROJECT_DEFINE, databaseEntity);
        dataBaseManager.save(databaseEntity);
        return "/database/show";
    }
}
