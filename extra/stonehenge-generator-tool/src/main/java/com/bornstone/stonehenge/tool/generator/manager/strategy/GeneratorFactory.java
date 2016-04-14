package com.bornstone.stonehenge.tool.generator.manager.strategy;

import com.bornstone.stonehenge.tool.generator.entity.entityenum.ExtendedFrom;

/**
 * Created by King.Tang on 14-11-17.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class GeneratorFactory {
    public static IGenerator getGenerator(ExtendedFrom extendedFrom) {
        switch (extendedFrom) {
            case DELETEABLEENTITY:
                return new DeleteAbleEntityGenerator();
            case IDENTITY:
            case IDENTITY_LONG:
                return new IdentityGenerator();
            case IENTITY:
                return new EntityGenerator();
            default:
                return new BaseEntityGenerator();
        }
    }
}
