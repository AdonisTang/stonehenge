package com.bornstone.stonehenge.demo.manager;

import com.bornstone.stonehenge.demo.entity.TaskEntity;
import com.bornstone.stonehenge.demo.mapper.TaskMapper;
import com.bornstone.stonehenge.manager.IBaseManager;
import com.bornstone.stonehenge.manager.annotations.Manager;
import com.bornstone.stonehenge.manager.annotations.StonehengeWired;

/**
 * Created by King.Tang on 14-10-10.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
@Manager(daoClass = TaskMapper.class)
public abstract class TaskManager implements IBaseManager<Integer, TaskEntity> {
    private TaskEntity entity;

    public void test() {
        TaskMapper taskMapper = getTaskMapper();
        System.out.println("test method!");
    }

    @StonehengeWired
    protected abstract TaskMapper getTaskMapper();
}
