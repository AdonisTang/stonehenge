<#-- common BEGIN -->
<#import "common/utils.ftl" as utils>
<#import "common/constant.ftl" as constant>

<#--
    对url加上contextPath
-->
<#function url url>
    <#return utils.url(url)/>
</#function>

<#global contextPath=constant.contextPath/>
<#global webName=constant.webName/>
<#-- common END -->

<#-- pageRender BEGIN -->
<#import "pageRender/pageRender.ftl" as pageRender>
<#-- pageRender END -->