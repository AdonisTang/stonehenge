<#import "../macro/macro.ftl" as macro>
<#if macro.utils.hasItem((table.fieldEntityList)![])>
<pre>
CREATE TABLE `${table.name}` (
	`id` INT NOT NULL AUTO_INCREMENT COMMENT 'id',
	`created_time` DATETIME NOT NULL COMMENT '创建时间',
    `updated_time` DATETIME NOT NULL COMMENT '最后修改时间',
    <#if table.extendedFrom=="DELETEABLEENTITY">
        `enable` INT NOT NULL DEFAULT '0' COMMENT '状态:0-正常;1-删除',
    </#if>
    <#list table.fieldEntities?keys as key>
        <#assign field=table.fieldEntities[key]/>
        <#if field.isAllowNull=="true">
            <#assign isNull="NULL"/>
        <#else>
            <#assign isNull="NOT NULL"/>
        </#if>
        <#if field.fieldType=="VARCHAR">
            <#assign fieldType=field.fieldType+"("+field.length+")"/>
        <#else>
            <#assign fieldType=field.fieldType/>
        </#if>
        `${field.name}` ${fieldType} ${isNull} COMMENT '${field.description}',
    </#list>
    PRIMARY KEY (`id`)
)
COMMENT='${table.description}'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
</pre>
</#if>
