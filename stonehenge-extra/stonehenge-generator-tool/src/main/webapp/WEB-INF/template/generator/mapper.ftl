<#import "../macro/macro.ftl" as macro>
<#if macro.utils.hasItem((table.fieldEntityList)![])>
<textarea style="margin: 0px; width: 1265px; height: 571px;">
<?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${beanNameSpace}.mapper.${table.upperCaseFirstOneName}Mapper">
    <resultMap id="BaseResultMap" type="${table.upperCaseFirstOneName}Entity">
        <id column="id" property="id" jdbcType="INTEGER"/>
        <result column="created_time" property="createdTime" jdbcType="TIMESTAMP"/>
        <result column="updated_time" property="updatedTime" jdbcType="TIMESTAMP"/>
        <result column="enable" property="enable" jdbcType="INTEGER"/>
        <#list table.fieldEntities?keys as key>
            <#assign field=table.fieldEntities[key]/>
            <result column="${field.name}" property="${field.formatName}" jdbcType="${field.fieldType}"/>
        </#list>
    </resultMap>

    <sql id="Base_Column_List">
        id, created_time, updated_time, enable, <#list table.fieldEntities?keys as key>${table.fieldEntities[key].name}
        , </#list>
    </sql>

    <sql id="Query_Where_Clause">
        <where>
            <#list table.fieldEntities?keys as key>
                <#assign field=table.fieldEntities[key]/>
                <#if ((field.isQuery)!"")=="true">
                    <if test="${field.formatName} != null">
                        and ${field.name} = ${field.freemarkerFieldInfo}
                    </if>
                </#if>
            </#list>
            and enable=0
        </where>
    </sql>

    <insert id="insert" parameterType="${table.upperCaseFirstOneName}Entity">
        insert into ${table.name} (
        created_time, updated_time, enable, <#list table.fieldEntities?keys as key>${table.fieldEntities[key].name}
        , </#list>
        )
        values
        (now(), now(), 0, <#list table.fieldEntities?keys as key>${table.fieldEntities[key].freemarkerFieldName}
        , </#list>)
        <selectKey resultType="INTEGER" keyProperty="id">SELECT LAST_INSERT_ID()</selectKey>
    </insert>

    <update id="update" parameterType="${table.upperCaseFirstOneName}Entity">
        update ${table.name}
        <set>
            <#list table.fieldEntities?keys as key>
                <#assign field=table.fieldEntities[key]/>
                <#if ((field.updateAble)!"")=="true">
                    <if test="${field.formatName} != null">
                    ${field.name} = ${field.freemarkerFieldName},
                    </if>
                </#if>
            </#list>
            updated_time = now(),
        </set>
        where id = ${id}
    </update>

    <select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="java.lang.Integer">
        select
        <include refid="Base_Column_List"/>
        from ${table.name} where id=${id} and enable=0
    </select>

    <select id="countByQuery" parameterType="${table.upperCaseFirstOneName}QueryEntity" resultType="java.lang.Integer">
        select count(id) from ${table.name}
        <include refid="Query_Where_Clause"/>
    </select>

    <select id="selectByQuery" parameterType="${table.upperCaseFirstOneName}QueryEntity" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${table.name}
        <include refid="Query_Where_Clause"/>
        order by ${orderBy}
        limit ${queryLimit}
    </select>
</mapper>
</textarea>
</#if>
