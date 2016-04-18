package com.bornstone.extra.spring.test.dbunit.xlssuport;

import org.apache.commons.lang3.StringUtils;
import org.dbunit.dataset.*;
import org.unitils.core.UnitilsException;

/**
 * 为了获得strip datasource后的表名
 *
 * @author xumin
 * @since 2012-3-5
 */
public class XlsTableWrapper extends AbstractTable {
    private ITable delegate;
    private String tableName;

    public XlsTableWrapper(String tableName, ITable table) {
        this.delegate = table;
        this.tableName = tableName;
    }

    public int getRowCount() {
        return delegate.getRowCount();
    }

    public ITableMetaData getTableMetaData() {
        ITableMetaData meta = delegate.getTableMetaData();
        try {
            return new DefaultTableMetaData(tableName, meta.getColumns(),
                    meta.getPrimaryKeys());
        } catch (DataSetException e) {
            throw new UnitilsException("Don't get the meta info from  " + meta,
                    e);
        }
    }

    public Object getValue(int row, String column) throws DataSetException {
        Object delta = delegate.getValue(row, column);
        if (delta instanceof String) {
            if (StringUtils.isEmpty((String) delta)) {
                return null;
            }
        }
        return delta;
    }

}