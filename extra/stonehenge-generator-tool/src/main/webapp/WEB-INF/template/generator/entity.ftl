<#import "../macro/macro.ftl" as macro>
<#if macro.utils.hasItem((table.fieldEntities)![])>
<pre>
    <#list table.fieldEntities?keys as key>
        <#assign field=table.fieldEntities[key]/>
        private ${(field.fieldType.javaClass.simpleName)!""} ${(field.formatName)!};  //${(field.description)!""}
    </#list>
</pre>
</#if>
