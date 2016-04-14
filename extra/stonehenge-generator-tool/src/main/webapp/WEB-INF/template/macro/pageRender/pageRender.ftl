<#-- 这里提供一些项目中可复用的数据渲染组件 可能是多个UI组件的复合体 -->
<#import "../common/constant.ftl" as constant>
<#import "../common/utils.ftl" as utils>
<#import "../components/tag.ftl" as tag>
<#assign contextPath=constant.contextPath/>
<#assign webName=constant.webName/>

<#--
    header渲染器
    head={
        title:""
        css:[],
        js:[],
        pageFlag:""
    }
-->
<#macro headerRender head={}>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <meta id="J_pageContextPath" neme="pagecontextpath" content="${contextPath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" href="${contextPath}/favicon.ico"/>
    <title>${(head.title)!"首页"}</title>

    <link rel="stylesheet" href="${contextPath}/static/css/common.css">
    <link rel="stylesheet" href="${contextPath}/static/css/generator.css">

    <#list head.css as css>
        <link rel="stylesheet" href="${contextPath}/static/css/${css}.css">
    </#list>

    <script src="${contextPath}/static/js/tools/console.js" type="text/javascript"></script>
    <script src="${contextPath}/static/js/tools/jquery.tools.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${contextPath}/static/js/tools/common.js"></script>

    <script src="${contextPath}/static/js/generator.js" type="text/javascript"></script>
    <#list head.js as js>
        <script src="${contextPath}/static/js/${js}.js" type="text/javascript"></script>
    </#list>
</head>
<body class="fa ft fv fs fw">
<div id="J_nav" class="header">
    <div class="content">
        <div class="item_logo"></div>

        <#if user??>
            <div class="item_user">
            ${(user.realName)!""} | <a href="${contextPath}/user/logout.htm">退出</a>
            </div>
        </#if>
    </div>
</div>
<div id="main" class="page_content">
<#--加载后台消息-->
    <div id="J_serverMsgHide" class="dn">${(message)!""}</div>
</#macro>

<#--
    footer 渲染器
-->
<#macro footerRender>
</div>
<div id="footer" class="footer">
    <div class="content">
        <p>Copyright © ${.now?string("yyyy")}</p>
    </div>
</div>
</body>
</html>
</#macro>

<#--
	页面渲染器
	head={
        title:""
        css:[],
        js:[],
        pageFlag:""
    }
-->
<#macro pageRender head>
    <#local head={"title":"","css":[],"js":[]}+head>

<#-- 头部文件 BEGIN -->
    <@headerRender head=head/>
<#-- 头部文件 END -->

<#-- 主体部分BEGIN -->
    <#nested>
<#-- 主体部分END -->

<#-- 版权部分BEGIN  -->
    <@tag.blank/>
    <@footerRender/>
<#-- 版权部分END  -->
</#macro>

<#--
    管理系统页面渲染器
-->
<#macro mPageRender head rightClass="">
    <@pageRender head=head>
    <#-- menu BEGIN -->
    <div class="main_l menu">
        <div>
            <a href="${contextPath}/database/show.htm?path=${(project.path)!""}" class="item">${(project.name)!""}</a>
            <#if utils.hasItem((project.tableEntities)![])>
                <#list project.tableEntities?keys as tableName>
                    <a href="${contextPath}/table/editEnter.htm?name=${tableName}"
                       class="item child_item">${tableName}</a>
                </#list>
            </#if>
        </div>
    </div>
    <#-- menu END -->

    <div class="main_r ${rightClass}">
        <div class="m_content">
            <#nested>
        </div>
    </div>
    </@pageRender>
</#macro>

<#--
	异常页面渲染器
	title:页面标题
	tips:提示信息
-->
<#macro errrorPageRender title="" tips="">
    <#local componentcssArray = ["exception"]>
    <#local head={"title":title,"componentcssArray":componentcssArray}>
    <@pageRender head=head>
    <div class="exception">
        <div class="xfull"><@componentUtils.imgRender url="error.jpg" alt="访问出错啦" attr='class="errorImg"'/></div>
        <div class="errorTips f20 b">${tips}</div>
        <div class="xfull"><a href="/index.htm" class="link b f14">返回首页</a></div>
    </div>
    </@pageRender>
</#macro>