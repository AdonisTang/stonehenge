package com.bornstone.stonehenge.demo.mapper;

import com.bornstone.extra.spring.test.testutils.DBUnitTestUtils;
import com.bornstone.stonehenge.demo.entity.TaskEntity;
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
 * Created by King.Tang on 14-5-26.
 */
@RunWith(UnitilsJUnit4TestClassRunner.class)
@SpringApplicationContext("application.xml")
@Transactional(TransactionMode.ROLLBACK)
@DataSet
public class TaskMapperTest extends DBUnitTestUtils<TaskEntity> {
    @SpringBeanByType
    private TaskMapper mapper;

    @Test
    public void test_添加() {
        Assert.assertEquals(1, mapper.insert(newInstance()));
    }

    @Test
    public void test_更新() {
        Assert.assertEquals(1, mapper.update(newInstance()));
    }

    @Test
    public void test_根据Id查询() {
        Assert.assertNotNull(mapper.selectByPrimaryKey(1));
    }
}
