<#import "../macro/macro.ftl" as macro>
<#import "components.ftl" as components>

<@macro.pageRender.mPageRender head={"title":"修改表"} rightClass="welcome">
<div class="panel_title">修改表</div>
<div class="xfull m_r_from">
    <@components.formRender entity=table!{} action="edit"/>
</div>
</@macro.pageRender.mPageRender>