package com.bornstone.stonehenge.tool.generator.entity;

import com.bornstone.stonehenge.entity.Identity;

import java.io.Serializable;

/**
 * Created by King.Tang on 14-10-30.
 *
 * @author King.Tang
 *         my249645546@163.com
 * @since 0.2
 */
public class BaseEntity implements Serializable, Identity<Integer> {
    private Integer id;
    private String name;
    private String description;

    public String getUpperCaseFirstOneName() {
        return getUpperCaseFirstOne(getFormatName());
    }

    private String getUpperCaseFirstOne(String string) {
        if (Character.isUpperCase(string.charAt(0)))
            return string;
        else
            return (new StringBuilder()).append(Character.toUpperCase(string.charAt(0))).append(string.substring(1)).toString();
    }

    public String getFormatName() {
        String[] split = getName().split("_");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (i == 0) {
                stringBuilder.append(s);
            } else {
                stringBuilder.append(getUpperCaseFirstOne(s));
            }
        }
        return stringBuilder.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
