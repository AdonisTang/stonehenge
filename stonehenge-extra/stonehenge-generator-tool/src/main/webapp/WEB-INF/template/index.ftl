<#import "macro/macro.ftl" as macro>
<@macro.pageRender.pageRender head={"title":"项目管理"}>
<div id="J_loginBox" class="login_box">
    <div class="content">
        <form id="J_projectForm" action="#" method="post">
            <div class="form-group title">项目管理</div>
            <div class="form-group">
                <input type="text" id="J_path" name="path" placeholder="描述文件">
            </div>
            <div class="form-group">
                <input type="text" id="J_name" name="name" placeholder="数据库名">
            </div>
            <div class="form-group">
                <input type="text" id="J_description" name="description" placeholder="描述">
            </div>
            <div class="form-group">
                <input id="J_showProject" type="button" class="l sub_btn fw" value="打开">
                <input id="J_newProject" type="button" class="r sub_btn fw" value="创建">
            </div>
        </form>
    </div>
</div>
</@macro.pageRender.pageRender>