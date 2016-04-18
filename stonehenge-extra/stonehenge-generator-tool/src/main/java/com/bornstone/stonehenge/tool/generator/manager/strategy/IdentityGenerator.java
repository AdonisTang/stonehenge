package com.bornstone.stonehenge.tool.generator.manager.strategy;

import com.bornstone.stonehenge.tool.generator.entity.FieldEntity;
import com.bornstone.stonehenge.tool.generator.entity.TableEntity;
import com.bornstone.stonehenge.tool.generator.entity.entityenum.FieldType;

import java.util.List;
import java.util.Map;

/**
 * Created by King.Tang on 14-11-17.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class IdentityGenerator extends FileGeneratorTemp {
    @Override
    public void addFieldByExtendedFrom(TableEntity table) {
        table.getFieldEntities().remove("id");
        sortField(table);

        FieldEntity id = new FieldEntity();
        id.setName("id");
        id.setIsPK("true");
        id.setIsAllowNull("false");
        id.setDescription("id");

        switch (table.getExtendedFrom()) {
            case IDENTITY:
                id.setLength(FieldType.INT.getLength());
                id.setFieldType(FieldType.INT);
                break;
            default:
                id.setLength(FieldType.BIGINT.getLength());
                id.setFieldType(FieldType.BIGINT);
        }
        table.getFieldEntityList().add(0, id);
    }

    private void sortField(TableEntity table) {
        Map<String, FieldEntity> fieldEntityMap = table.getFieldEntities();
        List<FieldEntity> fieldEntities = table.getFieldEntityList();
        for (String name : fieldEntityMap.keySet()) {
            FieldEntity fieldEntity = fieldEntityMap.get(name);
            fieldEntities.add(fieldEntity);
        }
    }
}
