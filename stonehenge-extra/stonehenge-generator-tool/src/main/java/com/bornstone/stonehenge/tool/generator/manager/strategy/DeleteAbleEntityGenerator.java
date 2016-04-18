package com.bornstone.stonehenge.tool.generator.manager.strategy;

import com.bornstone.stonehenge.tool.generator.entity.FieldEntity;
import com.bornstone.stonehenge.tool.generator.entity.TableEntity;
import com.bornstone.stonehenge.tool.generator.entity.entityenum.FieldType;

/**
 * Created by King.Tang on 14-11-17.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class DeleteAbleEntityGenerator extends BaseEntityGenerator {
    @Override
    public void addFieldByExtendedFrom(TableEntity table) {
        table.getFieldEntities().remove("status");
        super.addFieldByExtendedFrom(table);

        FieldEntity status = new FieldEntity();
        status.setName("status");
        status.setLength(FieldType.INT.getLength());
        status.setIsPK("false");
        status.setIsAllowNull("false");
        status.setFieldType(FieldType.INT);
        status.setDescription("status:0-normal;1-deleted");
        table.getFieldEntityList().add(3, status);
    }
}
