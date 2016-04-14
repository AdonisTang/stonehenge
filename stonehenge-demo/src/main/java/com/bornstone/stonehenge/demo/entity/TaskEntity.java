package com.bornstone.stonehenge.demo.entity;

import com.bornstone.stonehenge.entity.BaseEntity;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * Created by King.Tang on 14-10-9.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class TaskEntity extends BaseEntity<Integer> {
    private Integer id;
    @NotNull
    @NotEmpty
    private String task;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
