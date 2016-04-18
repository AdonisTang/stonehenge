<#-- 这里提供一些项目中工具类  macro、function  -->

<#--
	判断对象是否为空 包括空字符串
-->
<#function isNotEmpty obj="">
    <#return obj?? && obj!="" && obj!="NULL" && obj!="null">
</#function>

<#--
	判断集合是否为空
-->
<#function hasItem list=[]>
    <#return list?? && list?size!=0>
</#function>

<#--
	去掉转义字符
	imgNames：原始图片名字符
-->
<#function removeESCStr4ImgName imgNames>
<#-- "|"的转义字符为“&brvbar;” “&”转义字符为“&amp;”
    不能直接替换“&brvbar;”为“|”
-->
    <#local _imgNames=imgNames?replace("brvbar;","")?replace("amp;","")?replace("&","|")/>
    <#return _imgNames/>
</#function>

<#--
    对url加上contextPath
-->
<#function url url>
    <#local requestContextPath=(requestContext.contextPath)!""/>
    <#return requestContextPath+"/"+url/>
</#function>