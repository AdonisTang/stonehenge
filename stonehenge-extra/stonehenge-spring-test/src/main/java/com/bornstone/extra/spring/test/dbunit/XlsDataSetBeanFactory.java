package com.bornstone.extra.spring.test.dbunit;

import com.bornstone.stonehenge.common.utils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.StringUtils;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * XlsDataSetBeanFactory.java
 *
 * @author King<br/>
 *         email:my249645546@163.com
 * @Description 从Excel数据集文件创建Bean
 * @Date 2012-12-17下午9:54:51
 * @since 1.0.0
 */
public class XlsDataSetBeanFactory {
    /**
     * @param dataSet
     * @param tableName
     * @param entityClass
     * @param nullPropName
     * @return
     * @throws Exception List<T>
     * @Description:创建多个Bean 并可以设置 为null的属性
     * @Date:2012-12-18 下午2:33:06
     * @since 1.0.0
     */
    private static <T> List<T> createBeansAndSetNullProperty(IDataSet dataSet, String tableName,
                                                             Class<T> entityClass, String nullPropName) throws Exception {
        BeanUtilsBean beanUtils = BeanUtils.createBeanUtils();
        List<Map<String, Object>> propsList = createProps(dataSet, tableName, nullPropName);
        List<T> beans = new ArrayList<T>();
        for (Map<String, Object> props : propsList) {
            T bean = entityClass.newInstance();
            beanUtils.populate(bean, props);
            beans.add(bean);
        }
        return beans;
    }

    /**
     * @param dataSet
     * @param tableName
     * @param entityClass
     * @return
     * @throws Exception List<T>
     * @Description:创建多个Bean
     * @Date:2012-12-18 上午9:49:13
     * @since 1.0.0
     */
    public static <T> List<T> createBeans(IDataSet dataSet, String tableName,
                                          Class<T> entityClass) throws Exception {
        return createBeansAndSetNullProperty(dataSet, tableName, entityClass, null);
    }

    /**
     * @param dataSet
     * @param tableName
     * @param entityClass
     * @return
     * @throws Exception T
     * @Description:创建单个Bean
     * @Date:2012-12-18 上午9:49:29
     * @since 1.0.0
     */
    public static <T> T createBean(IDataSet dataSet, String tableName,
                                   Class<T> entityClass) throws Exception {
        return createBeanAndSetNullProperty(dataSet, tableName, entityClass, null);
    }

    /**
     * @param dataSet
     * @param tableName
     * @param entityClass
     * @param nullPropName
     * @return
     * @throws Exception T
     * @Description:创建单个Bean 并可以设置 为null的属性
     * @Date:2012-12-18 下午2:37:18
     * @since 1.0.0
     */
    public static <T> T createBeanAndSetNullProperty(IDataSet dataSet, String tableName,
                                                     Class<T> entityClass, String nullPropName) throws Exception {
        List<T> beans = createBeansAndSetNullProperty(dataSet, tableName, entityClass, nullPropName);
        if (beans.size() > 0) {
            return beans.get(0);
        } else {
            return null;
        }
    }

    /**
     * @param dataSet
     * @param tableName
     * @param nullPropName
     * @return
     * @throws IOException
     * @throws DataSetException List<Map<String,Object>>
     * @Description:封装对象属性
     * @Date:2012-12-18 下午2:33:56
     * @since 1.0.0
     */
    private static List<Map<String, Object>> createProps(IDataSet dataSet,
                                                         String tableName, String nullPropName) throws IOException, DataSetException {
        List<Map<String, Object>> propsList = new ArrayList<Map<String, Object>>();
        ITable table = dataSet.getTable(tableName);
        Column[] columns = table.getTableMetaData().getColumns();
        for (int i = 0; i < table.getRowCount(); i++) {
            Map<String, Object> props = new HashMap<String, Object>();
            for (Column c : columns) {
                Object value = table.getValue(i, c.getColumnName());
                String propName = underlineToCamel(c.getColumnName());
                if (StringUtils.isNotBlank(nullPropName) && nullPropName.equals(propName)) {
                    props.put(propName, null);
                } else {
                    props.put(propName, value);
                }
            }
            propsList.add(props);
        }
        return propsList;
    }

    /**
     * @param str
     * @return String
     * @Description:去掉“_” 并将“_”后第一个字母 转为大写 如user_name 转换为userName
     * @Date:2012-12-18 上午9:42:45
     * @since 1.0.0
     */
    private static String underlineToCamel(String str) {
        String pattern[] = str.split("_");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < pattern.length; i++) {
            if (i == 0) {
                builder.append(pattern[i]);
            } else {
                builder.append(pattern[i].substring(0, 1).toUpperCase());
                builder.append(pattern[i].substring(1));
            }
        }
        return builder.toString();
    }
}
