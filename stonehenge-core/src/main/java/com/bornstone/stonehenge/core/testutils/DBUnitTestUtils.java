package com.bornstone.stonehenge.core.testutils;

import com.bornstone.stonehenge.common.dbunit.XlsDataSetBeanFactory;
import org.apache.log4j.Logger;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * DBUnitTestUtils.java
 *
 * @author King<br/>
 *         email:my249645546@163.com
 * @Description 直接读取Excel测试用数据 封装成测试用 EntityBean
 * @Date 2012-12-26下午4:53:20
 * @since 1.0.0
 */
public class DBUnitTestUtils<T> {
    protected final Logger logger = Logger.getLogger(this.getClass());

    /**
     * @return T
     * @Description:创建一个Test实例
     * @Date:2012-12-17 下午5:04:27
     * @since 1.0.0
     */
    public T newInstance() {
        return newInstanceHasNullProperty(null);
    }

    ;

    /**
     * @return T
     * @Description:创建一个Test实例
     * @Date:2012-12-17 下午5:04:27
     * @since 1.0.0
     */
    public T newInstanceHasNullProperty(String nullProperty) {
        T instance = null;
        IDataSet dataSet = null;
        try {
            String dataSource = this.getClass().getSimpleName() + ".xls";
            dataSet = new XlsDataSet(this.getClass().getResourceAsStream(dataSource));
            String tableName = dataSet.getTableNames()[0];
            Type[] typeArr = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
            @SuppressWarnings("unchecked")
            Class<T> entityClass = (Class<T>) typeArr[typeArr.length - 1];
            instance = XlsDataSetBeanFactory.createBeanAndSetNullProperty(dataSet, tableName, entityClass, nullProperty);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return composite(instance);
    }

    protected T composite(T instance) {
        return instance;
    }
}