package com.bornstone.stonehenge.tool.generator.entity.entityenum;

import com.bornstone.stonehenge.entity.BaseEntity;
import com.bornstone.stonehenge.entity.DeleteAbleEntity;
import com.bornstone.stonehenge.entity.IEntity;
import com.bornstone.stonehenge.entity.Identity;

/**
 * Created by King.Tang on 14-11-12.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public enum ExtendedFrom {
    BASEENTITY("BaseEntity", BaseEntity.class.getName()),
    DELETEABLEENTITY("DeleteAbleEntity", DeleteAbleEntity.class.getName()),
    IDENTITY("Identity", Identity.class.getName()),
    IDENTITY_LONG("Identity", Identity.class.getName()),
    IENTITY("IEntity", IEntity.class.getName());

    private String superClassName;
    private String packageName;

    private ExtendedFrom(String superClassNam, String packageName) {
        this.superClassName = superClassNam;
        this.packageName = packageName;
    }

    public String getSuperClassName() {
        return superClassName;
    }

    public String getPackageName() {
        return packageName;
    }
}
