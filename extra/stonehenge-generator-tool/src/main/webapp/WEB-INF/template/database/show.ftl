<#import "../macro/macro.ftl" as macro>
<@macro.pageRender.mPageRender head={"title":"欢迎"} rightClass="welcome">
<div class="panel_title">${(project.databaseName)!""}</div>
<div class="xfull m_r_from">
    <form id="J_tableManager" action="${contextPath}/database/edit.htm" method="post">
        <div class="form-group">
            <label for="J_name">名称：</label>
            <input type="text" id="J_name" name="name" value="${(project.name)!""}">
        </div>
        <div class="form-group">
            <label for="J_description">描述：</label>
            <input type="text" id="J_description" name="description" value="${(project.description)!""}">
        </div>

        <div class="form-group">
            <label for="J_path">路径：</label>
            <input type="text" id="J_path" name="path" value="${(project.path)!""}">
        </div>
        <div class="form-group">
            <label for="J_beanNameSpace">命名空间：</label>
            <input type="text" id="J_beanNameSpace" name="beanNameSpace" value="${(project.beanNameSpace)!""}">
        </div>
        <div class="form-group">
            <label>表：</label>
            <a href="${contextPath}/table/addEnter.htm">添加一张</a>
        </div>
        <div class="form-group">
            <table class="data_table">
                <thead>
                <tr class="t_header">
                    <td class="t_name">名称</td>
                    <td class="t_operation">操作</td>
                </tr>
                </thead>
                <tbody>
                    <#if macro.utils.hasItem((project.tableEntities)![])>
                        <#list project.tableEntities?keys as key>
                            <#assign trClass="odd"/>
                            <#if (key_index%2 == 0)>
                                <#assign trClass="even"/>
                            </#if>

                        <tr class="${trClass}">
                            <td>
                                <a href="${contextPath}/table/editEnter.htm?name=${key}">${key}</a>
                            </td>
                            <td>
                                <a href="${contextPath}/table/entityGenerator.htm?name=${key}"
                                   target="_blank">生成Entity</a>
                                <a href="${contextPath}/table/createTableSqlGenerator.htm?name=${key}" target="_blank">生成创建脚本</a>
                                <a href="${contextPath}/table/mapperGenerator.htm?name=${key}" target="_blank">生成Mapper文件</a>
                            </td>
                        </tr>
                        </#list>
                    <#else>
                    <tr class="odd">
                        <td colspan="2">没有表,<a href="${contextPath}/table/addEnter.htm">添加一张</a></td>
                    </tr>
                    </#if>
                </tbody>
            </table>
        </div>
        <div class="form-group">
            <label>&nbsp;</label>
            <input type="submit" class="sub_btn fw" value="提交">
        </div>
    </form>
</div>
</@macro.pageRender.mPageRender>