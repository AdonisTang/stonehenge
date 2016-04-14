package com.bornstone.stonehenge.tool.generator.manager.strategy;

import com.bornstone.stonehenge.tool.generator.entity.TableEntity;

/**
 * Created by King.Tang on 14-11-17.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public abstract class AbstractGenerator implements IGenerator {
    public abstract void addFieldByExtendedFrom(TableEntity table);

    public abstract void sqlGenerator(TableEntity table);

    public abstract void entityGenerator(TableEntity table);

    public abstract void mapperGenerator(TableEntity table);

    public abstract void managerGenerator(TableEntity table);

    @Override
    public void sql(TableEntity table, GenerateTo generateTo) {
        addFieldByExtendedFrom(table);
        switch (generateTo) {
            case PAGE:
                break;
            default:
                sqlGenerator(table);
        }
    }

    @Override
    public void entity(TableEntity table, GenerateTo generateTo) {
        addFieldByExtendedFrom(table);
        switch (generateTo) {
            case PAGE:
                break;
            default:
                entityGenerator(table);
        }
    }

    @Override
    public void mapper(TableEntity table, GenerateTo generateTo) {
        addFieldByExtendedFrom(table);
        switch (generateTo) {
            case PAGE:
                break;
            default:
                mapperGenerator(table);
        }
    }

    @Override
    public void manager(TableEntity table, GenerateTo generateTo) {
        addFieldByExtendedFrom(table);
        switch (generateTo) {
            case PAGE:
                break;
            default:
                managerGenerator(table);
        }
    }
}
