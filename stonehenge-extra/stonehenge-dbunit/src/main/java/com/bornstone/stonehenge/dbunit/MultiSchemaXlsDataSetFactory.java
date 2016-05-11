package com.bornstone.stonehenge.dbunit;

import org.dbunit.database.AmbiguousTableNameException;
import org.dbunit.dataset.DefaultDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.excel.XlsDataSet;
import org.unitils.core.UnitilsException;
import org.unitils.dbunit.datasetfactory.DataSetFactory;
import org.unitils.dbunit.util.MultiSchemaDataSet;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by king on 16-5-11.
 */
public class MultiSchemaXlsDataSetFactory implements DataSetFactory {
    private static Pattern pattern = Pattern.compile("\\.");
    protected String defaultSchemaName;

    public MultiSchemaXlsDataSetFactory() {
    }

    public void init(Properties configuration, String defaultSchemaName) {
        this.defaultSchemaName = defaultSchemaName;
    }

    public MultiSchemaDataSet createDataSet(File... dataSetFiles) {
        Map tableMap = this.getTables(dataSetFiles);
        MultiSchemaDataSet dataSets = new MultiSchemaDataSet();
        Iterator var5 = tableMap.entrySet().iterator();

        while (var5.hasNext()) {
            Map.Entry entry = (Map.Entry) var5.next();
            List tables = (List) entry.getValue();

            try {
                DefaultDataSet e = new DefaultDataSet((ITable[]) tables.toArray(new ITable[0]));
                dataSets.setDataSetForSchema((String) entry.getKey(), e);
            } catch (AmbiguousTableNameException var8) {
                throw new UnitilsException(String.format("使用指定表[%s]重新构造DataSet失败", new Object[]{tables}), var8);
            }
        }

        return dataSets;
    }

    private Map<String, List<ITable>> getTables(File... dataSetFiles) {
        HashMap tableMap = new HashMap();

        try {
            File[] var6 = dataSetFiles;
            int var5 = dataSetFiles.length;

            for (int var4 = 0; var4 < var5; ++var4) {
                File e = var6[var4];
                XlsDataSet dataSet = new XlsDataSet(new FileInputStream(e));
                String[] tableNames = dataSet.getTableNames();
                String[] var12 = tableNames;
                int var11 = tableNames.length;

                for (int var10 = 0; var10 < var11; ++var10) {
                    String each = var12[var10];
                    String schema = null;
                    String[] temp = pattern.split(each);
                    String tableName;
                    if (temp.length == 2) {
                        schema = temp[0];
                        tableName = temp[1];
                    } else {
                        schema = this.defaultSchemaName;
                        tableName = each;
                    }

                    ITable table = dataSet.getTable(each);
                    if (!tableMap.containsKey(schema)) {
                        tableMap.put(schema, new ArrayList());
                    }

                    ((List) tableMap.get(schema)).add(new XslTableWrapper(tableName, table));
                }
            }

            return tableMap;
        } catch (Exception var17) {
            throw new UnitilsException("Unable to create DbUnit dataset for data set files: " + Arrays.toString(dataSetFiles), var17);
        }
    }

    public String getDataSetFileExtension() {
        return "xls";
    }
}
