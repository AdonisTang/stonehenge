package com.bornstone.stonehenge.tool.generator.manager.strategy;

import com.bornstone.stonehenge.tool.generator.entity.FieldEntity;
import com.bornstone.stonehenge.tool.generator.entity.TableEntity;
import com.bornstone.stonehenge.tool.generator.entity.entityenum.FieldType;

import java.util.Map;

/**
 * Created by King.Tang on 14-11-17.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class BaseEntityGenerator extends IdentityGenerator {
    @Override
    public void addFieldByExtendedFrom(TableEntity table) {
        Map<String, FieldEntity> fieldEntityMap = table.getFieldEntities();
        fieldEntityMap.remove("createdTime");
        fieldEntityMap.remove("updatedTime");
        super.addFieldByExtendedFrom(table);

        FieldEntity createdTime = new FieldEntity();
        createdTime.setName("createdTime");
        createdTime.setLength(FieldType.DATETIME.getLength());
        createdTime.setIsPK("false");
        createdTime.setIsAllowNull("false");
        createdTime.setFieldType(FieldType.DATETIME);
        createdTime.setDescription("createdTime");
        table.getFieldEntityList().add(1, createdTime);

        FieldEntity updatedTime = new FieldEntity();
        updatedTime.setName("updatedTime");
        updatedTime.setLength(FieldType.DATETIME.getLength());
        updatedTime.setIsPK("false");
        updatedTime.setIsAllowNull("false");
        updatedTime.setFieldType(FieldType.DATETIME);
        updatedTime.setDescription("updatedTime");
        table.getFieldEntityList().add(2, updatedTime);
    }
}
