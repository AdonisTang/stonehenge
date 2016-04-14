package com.bornstone.stonehenge.tool.generator.manager.strategy;

import com.bornstone.stonehenge.tool.generator.entity.TableEntity;

/**
 * Created by King.Tang on 14-11-17.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public interface IGenerator {
    void sql(TableEntity table, GenerateTo generateTo);

    void entity(TableEntity table, GenerateTo generateTo);

    void mapper(TableEntity table, GenerateTo generateTo);

    void manager(TableEntity table, GenerateTo generateTo);
}
