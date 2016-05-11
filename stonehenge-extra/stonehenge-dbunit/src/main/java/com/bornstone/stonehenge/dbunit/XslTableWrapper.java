package com.bornstone.stonehenge.dbunit;

import org.apache.commons.lang.StringUtils;
import org.dbunit.dataset.*;
import org.unitils.core.UnitilsException;

/**
 * Created by king on 16-5-11.
 */
public class XslTableWrapper extends AbstractTable {
    private ITable delegate;
    private String tableName;

    public XslTableWrapper(String tableName, ITable table) {
        this.delegate = table;
        this.tableName = tableName;
    }

    public int getRowCount() {
        return this.delegate.getRowCount();
    }

    public ITableMetaData getTableMetaData() {
        ITableMetaData meta = this.delegate.getTableMetaData();

        try {
            return new DefaultTableMetaData(this.tableName, meta.getColumns(), meta.getPrimaryKeys());
        } catch (DataSetException var3) {
            throw new UnitilsException("Don\'t get the meta info from  " + meta, var3);
        }
    }

    public Object getValue(int row, String column) throws DataSetException {
        Object delta = this.delegate.getValue(row, column);
        return delta instanceof String && StringUtils.isEmpty((String) delta) ? null : delta;
    }
}
