<#-- 这里提供一些项目中页面渲染的 工具宏  -->
<#import "../common/utils.ftl" as utils>
<#assign contextPath=(requestContext.contextPath)!""/>

<#--
	将常量描述Map 转换成标签数据源
	如果有不希望被显示出来的标识值 请将key放入filter
-->
<#function conversionConstMapToTagData constMap={} constFilter=[]>
    <#local data = []/>
    <#if utils.hasItem(constFilter![])>
        <#list (constMap?keys)![] as const>
            <#local isFilter=false/>
            <#list constFilter as filterConst>
                <#if (filterConst?string)==const>
                    <#local isFilter=true/>
                    <#break/>
                </#if>
            </#list>
            <#if !isFilter>
                <#local data=data+[{"value":const,"text":constMap[const]}]/>
            </#if>
        </#list>
    <#else>
        <#list (constMap?keys)![] as const>
            <#local data=data+[{"value":const,"text":constMap[const]}]/>
        </#list>
    </#if>
    <#return data/>
</#function>