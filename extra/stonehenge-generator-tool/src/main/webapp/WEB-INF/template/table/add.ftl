<#import "../macro/macro.ftl" as macro>
<#import "components.ftl" as components>

<@macro.pageRender.mPageRender head={"title":"新建表"} rightClass="welcome">
<div class="panel_title">新建表</div>
<div class="xfull m_r_from">
    <@components.formRender entity=table!{}/>
</div>
</@macro.pageRender.mPageRender>