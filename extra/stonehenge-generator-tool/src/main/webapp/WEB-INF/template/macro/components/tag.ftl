<#-- 这里提供一些项目中UI组件  -->
<#import "../common/utils.ftl" as utils>

<#--
	构造标签属性
	attr：属性名
	value：属性值
-->
<#function tagAttr attr="" value="">
    <#return tagAttrEvaluate(utils.isNotEmpty(value),attr,value)/>
</#function>

<#function tagAttrEvaluate evaluate attr="" value="">
    <#if evaluate>
        <#return '${attr}="${value}"'/>
    <#else>
        <#return ""/>
    </#if>
</#function>

<#--
	href为js的a标签
	id:控件ID
	class:控件class
	title:控件title
	attr:其他属性配置
-->
<#macro jsa id="" class="" title="" attr="">
<a ${tagAttr("id",id)} ${tagAttr("class",class)} href="javascript:void(0);" ${tagAttr("title",title)} ${attr!""}>
    <#nested/>
</a>
</#macro>

<#--
	产生一个10像素的间距
-->
<#macro blank divisor=1>
    <#list 0..divisor as index>
    <div class="blank"></div>
    </#list>
</#macro>

<#--
    select
    optionMap=[{"value":"text"}];
-->
<#macro select attr optionMap value="" isAddHeader=true>
<select ${attr}>
    <#if isAddHeader>
        <option value="">不限</option>
    </#if>
    <#if utils.hasItem(optionMap)>
        <#list optionMap?keys as key>
            <#local selected="">
            <#if key==(value?string)>
                <#local selected="selected">
            </#if>
            <option value="${key}" ${selected}>${optionMap[key]}</option>
        </#list>
    </#if>
</select>
</#macro>