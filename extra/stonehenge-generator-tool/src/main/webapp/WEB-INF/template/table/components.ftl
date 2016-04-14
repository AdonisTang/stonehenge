<#--
    这里存放的是页面级别的公共模块
-->
<#import "../macro/macro.ftl" as macro>

<#macro formRender action="add" entity={}>
<form id="J_tableManager" action="${contextPath}/table/${action}.htm" method="post">
    <input type="hidden" name="action" value="${action}">
    <#if action=="edit">
        <input type="hidden" id="J_caseIdHide" name="id" value="${(entity.id)!""}">
    </#if>
    <div class="form-group">
        <label for="J_name">名称：</label>
        <input type="text" id="J_name" name="name" value="${(entity.name)!""}">
    </div>
    <div class="form-group">
        <label for="J_description">描述：</label>
        <input type="text" id="J_description" name="description" value="${(entity.description)!""}">
    </div>
    <div class="form-group">
        <label for="J_extendedFrom">继承自：</label>
        <select name="extendedFrom" id="J_extendedFrom" class="J_selectInputInit" value="${(entity.extendedFrom)!""}"
                init-value="${(entity.extendedFrom)!""}">
            <option value="BASEENTITY">BaseEntity</option>
            <option value="DELETEABLEENTITY">DeleteAbleEntity</option>
            <option value="IDENTITY">Identity</option>
            <option value="IDENTITY_LONG">LongIdentity</option>
            <option value="IENTITY">IEntity</option>
        </select>
    </div>
    <div class="form-group">
        <label>字段列表：</label>
        <a href="javascript:void(0);" class="add_field J_addField">添加一个</a>
    </div>
    <div class="form-group">
        <table class="data_table">
            <thead>
            <tr class="t_header">
                <td class="f_name">名称</td>
                <td class="f_fieldType">类型</td>
                <td class="f_length">长度</td>
                <td class="f_isAllowNull">允许为空</td>
                <td class="f_isPK">主键</td>
                <td class="f_isPK">可修改</td>
                <td class="f_isPK">可查询</td>
                <td class="f_description">描述</td>
                <td class="f_operation">操作</td>
            </tr>
            </thead>
            <tbody id="J_fieldInfoList">
                <#if macro.utils.hasItem(entity.fieldEntities)>
                    <#list entity.fieldEntities?keys as key>
                        <#assign trClass="odd"/>
                        <#if (key_index%2 == 0)>
                            <#assign trClass="even"/>
                        </#if>

                        <#assign field=entity.fieldEntities[key]/>
                        <#assign fieldName=(field.name)!""/>
                    <tr class="${trClass} J_dataItem">
                        <td><input type="text" name="fieldEntities[${fieldName}].name" class="f_i_name"
                                   value="${fieldName}"></td>
                        <td>
                            <select name="fieldEntities[${fieldName}].fieldType" class="f_i_fieldType J_selectInputInit"
                                    value="${(field.fieldType)!""}" init-value="${(field.fieldType)!""}">
                                <option value="INT">INT</option>
                                <option value="BIGINT">BIGINT</option>
                                <option value="VARCHAR">VARCHAR</option>
                                <option value="TEXT">TEXT</option>
                                <option value="DATETIME">DATETIME</option>
                            </select>
                        </td>
                        <td><input type="text" name="fieldEntities[${fieldName}].length" class="f_i_length"
                                   value="${(field.length)!""}"></td>
                        <td>
                            <div class="f_ch_box J_checkBoxInit" init-value="${(field.isAllowNull)!""}">
                                <input type="radio" name="fieldEntities[${fieldName}].isAllowNull" value="true"
                                       class="f_i_isAllowNull"> 是
                                <input type="radio" name="fieldEntities[${fieldName}].isAllowNull" value="false"
                                       class="f_i_isAllowNull"> 否
                            </div>
                        </td>
                        <td>
                            <div class="f_ch_box J_checkBoxInit" init-value="${(field.isPK)!""}">
                                <input type="radio" name="fieldEntities[${fieldName}].isPK" value="true"
                                       class="f_i_isPK"> 是
                                <input type="radio" name="fieldEntities[${fieldName}].isPK" value="false"
                                       class="f_i_isPK"> 否
                            </div>
                        </td>
                        <td>
                            <div class="f_ch_box J_checkBoxInit" init-value="${(field.updateAble)!"false"}">
                                <input type="radio" name="fieldEntities[${fieldName}].updateAble" value="true"
                                       class="f_i_isPK"> 是
                                <input type="radio" name="fieldEntities[${fieldName}].updateAble" value="false"
                                       class="f_i_isPK"> 否
                            </div>
                        </td>
                        <td>
                            <div class="f_ch_box J_checkBoxInit" init-value="${(field.isQuery)!"false"}">
                                <input type="radio" name="fieldEntities[${fieldName}].isQuery" value="true"
                                       class="f_i_isPK"> 是
                                <input type="radio" name="fieldEntities[${fieldName}].isQuery" value="false"
                                       class="f_i_isPK"> 否
                            </div>
                        </td>
                        <td><input type="text" name="fieldEntities[${fieldName}].description" class="f_i_descript"
                                   value="${(field.description)!""}"></td>
                        <td class="f_operation"><a href="#">删除</a></td>
                    </tr>
                    </#list>
                <#else>
                <tr id="J_tempField" class="odd">
                    <td colspan="6">没有字段,<a href="javascript:void(0);" class="add_field J_addField">添加一个</a></td>
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

<table class="dn">
    <tbody id="J_fieldInfoHideBox">
    <tr class="J_fieldInfo">
        <td><input type="text" name="name" class="f_i_name J_fieldName"></td>
        <td>
            <select name="fieldType" class="f_i_fieldType">
                <option value="INT">INT</option>
                <option value="BIGINT">BIGINT</option>
                <option value="VARCHAR">VARCHAR</option>
                <option value="TEXT">TEXT</option>
                <option value="DATETIME">DATETIME</option>
            </select>
        </td>
        <td><input type="text" name="length" class="f_i_length"></td>
        <td>
            <div class="f_ch_box">
                <input type="radio" name="isAllowNull" value="true" class="f_i_isAllowNull"> 是
                <input type="radio" name="isAllowNull" value="false" class="f_i_isAllowNull"> 否
            </div>
        </td>
        <td>
            <div class="f_ch_box">
                <input type="radio" name="isPK" value="true" class="f_i_isPK"> 是
                <input type="radio" name="isPK" value="false" class="f_i_isPK"> 否
            </div>
        </td>
        <td>
            <div class="f_ch_box">
                <input type="radio" name="updateAble" value="true" class="f_i_isPK"> 是
                <input type="radio" name="updateAble" value="false" class="f_i_isPK"> 否
            </div>
        </td>
        <td>
            <div class="f_ch_box">
                <input type="radio" name="isQuery" value="true" class="f_i_isPK"> 是
                <input type="radio" name="isQuery" value="false" class="f_i_isPK"> 否
            </div>
        </td>
        <td><input type="text" name="description" class="f_i_descript"></td>
        <td class="f_operation"><a href="#">删除</a></td>
    </tr>
    </tbody>
</table>
</#macro>