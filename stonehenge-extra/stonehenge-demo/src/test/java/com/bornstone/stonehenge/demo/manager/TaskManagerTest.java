package com.bornstone.stonehenge.demo.manager;

import com.bornstone.extra.spring.test.testutils.DBUnitTestUtils;
import com.bornstone.stonehenge.demo.entity.TaskEntity;
import com.bornstone.stonehenge.manager.exception.ManagerException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

/**
 * Created by King.Tang on 14-10-15.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext("application.xml")
@Transactional(TransactionMode.ROLLBACK)
@DataSet
public class TaskManagerTest extends DBUnitTestUtils<TaskEntity> {
    @SpringBeanByType
    private TaskManager manager;

    @Test
    public void test() {
        manager.test();
    }

    @Test
    public void test_添加() throws Exception {
        TaskEntity taskEntity = manager.add(newInstance());
        Assert.assertNotNull(taskEntity);
    }

    @Test
    public void test_更新() throws Exception {
        TaskEntity taskEntity = manager.modify(newInstance());
        Assert.assertNotNull(taskEntity);
    }

    @Test
    public void test_根据Id查询() throws Exception {
        TaskEntity taskEntity = manager.queryById(1);
        Assert.assertNotNull(taskEntity);
    }

    @Test
    public void test_validate() throws ManagerException {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTask("");
        manager.add(taskEntity);
    }
}
