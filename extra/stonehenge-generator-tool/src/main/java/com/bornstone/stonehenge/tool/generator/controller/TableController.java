package com.bornstone.stonehenge.tool.generator.controller;

import com.bornstone.stonehenge.tool.generator.common.Constants;
import com.bornstone.stonehenge.tool.generator.entity.DatabaseEntity;
import com.bornstone.stonehenge.tool.generator.entity.FieldEntity;
import com.bornstone.stonehenge.tool.generator.entity.TableEntity;
import com.bornstone.stonehenge.tool.generator.manager.DataBaseManager;
import com.bornstone.stonehenge.tool.generator.manager.strategy.GenerateTo;
import com.bornstone.stonehenge.tool.generator.manager.strategy.GeneratorFactory;
import com.bornstone.stonehenge.tool.generator.manager.strategy.IGenerator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by King.Tang on 14-11-5.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
@Controller
@RequestMapping("/table")
public class TableController {
    private static final Logger logger = Logger.getLogger(TableController.class);

    @Autowired
    private DataBaseManager dataBaseManager;

    private DatabaseEntity getDatabaseEntity(HttpSession session) {
        return (DatabaseEntity) session.getAttribute(Constants.SESSION_PROJECT_DEFINE);
    }

    @RequestMapping(value = "/add.htm", method = RequestMethod.POST)
    public String add(TableEntity table, HttpSession session) {
        setDefaultLength(table);

        DatabaseEntity databaseEntity = getDatabaseEntity(session);
        databaseEntity.getTableEntities().put(table.getName(), table);
        dataBaseManager.save(databaseEntity);
        return "redirect:/table/editEnter.htm?name=" + table.getName();
    }

    @RequestMapping(value = "/addEnter.htm", method = RequestMethod.GET)
    public String addEnter() {
        return "/table/add";
    }

    @RequestMapping(value = "/editEnter.htm", method = RequestMethod.GET)
    public String editEnter(String name, Model model, HttpSession session) {
        model.addAttribute("table", getTableEntityByNameFromSession(name, session));
        return "/table/edit";
    }

    private TableEntity getTableEntityByNameFromSession(String name, HttpSession session) {
        DatabaseEntity databaseEntity = getDatabaseEntity(session);
        return databaseEntity.getTableEntities().get(name);
    }

    @RequestMapping(value = "/edit.htm")
    public String edit(TableEntity table, Model model, HttpSession session) {
        setDefaultLength(table);

        DatabaseEntity databaseEntity = getDatabaseEntity(session);
        databaseEntity.getTableEntities().put(table.getName(), table);
        dataBaseManager.save(databaseEntity);

        model.addAttribute("table", table);
        return "/table/edit";
    }

    private void setDefaultLength(TableEntity table) {
        Map<String, FieldEntity> fieldEntityMap = table.getFieldEntities();
        for (String field : fieldEntityMap.keySet()) {
            FieldEntity fieldEntity = fieldEntityMap.get(field);
            if (fieldEntity.getLength() == null) {
                fieldEntity.setLength(fieldEntity.getFieldType().getLength());
            }
        }
    }

    @RequestMapping(value = "/entityGenerator.htm")
    public String entityGenerator(String name, Model model, HttpSession session) {
        TableEntity table = getTableEntityByNameFromSession(name, session);
        table.getFieldEntityList().clear();
        IGenerator generator = GeneratorFactory.getGenerator(table.getExtendedFrom());
        generator.entity(table, GenerateTo.PAGE);
        model.addAttribute("table", table);
        return "/generator/entity";
    }

    @RequestMapping(value = "/createTableSqlGenerator.htm")
    public String createTableSqlGenerator(String name, Model model, HttpSession session) {
        TableEntity table = getTableEntityByNameFromSession(name, session);
        table.getFieldEntityList().clear();
        IGenerator generator = GeneratorFactory.getGenerator(table.getExtendedFrom());
        generator.sql(table, GenerateTo.PAGE);
        model.addAttribute("table", table);
        return "/generator/createTableSql";
    }

    @RequestMapping(value = "/mapperGenerator.htm")
    public String mapperGenerator(String name, Model model, HttpSession session) {
        DatabaseEntity databaseEntity = getDatabaseEntity(session);
        TableEntity table = databaseEntity.getTableEntities().get(name);
        ;
        table.getFieldEntityList().clear();
        IGenerator generator = GeneratorFactory.getGenerator(table.getExtendedFrom());
        generator.mapper(table, GenerateTo.PAGE);
        model.addAttribute("table", table);
        model.addAttribute("beanNameSpace", databaseEntity.getBeanNameSpace());
        model.addAttribute("orderBy", "${orderAble.orderBy} ${orderAble.orderValue.value}");
        model.addAttribute("queryLimit", "#{startRow},#{pageSize}");

        model.addAttribute("id", "#{id}");
        return "/generator/mapper";
    }
}
