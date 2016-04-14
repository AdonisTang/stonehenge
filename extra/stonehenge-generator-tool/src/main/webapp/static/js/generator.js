/**
 * 工具类
 */
(function ($, window) {
    /**
     * 判断元素是否存在
     * @param selector
     * @returns {Number}
     */
    window.exist = function (selector) {
        return $(selector).length;
    };

    window.message = function (msg) {
        alert(msg);
    };

    window.pageContextPath = $("#J_pageContextPath").attr("content");
})(jQuery, window);

$(function () {
    loginInit();
    tableManagerInit();
});

function loginInit() {
    if (exist("#J_loginBox")) {
        var main = $("#main"), header = $("#J_nav"), footer = $("#footer"), login = $("#J_loginBox");
        var mainHeight = $(document).height() - header.height() - footer.height() - 21;
        main.height(mainHeight);

        var loginMarginTop = (mainHeight - login.height()) / 2;
        login.css({
            "margin-top": loginMarginTop
        });

        var form = $("#J_projectForm");
        $("#J_newProject").click(function () {
            form.attr("action", pageContextPath + "/database/add.htm").submit();
        });

        $("#J_showProject").click(function () {
            form.attr("action", pageContextPath + "/database/show.htm").submit();
        });
    }
}

function tableManagerInit() {
    if (exist("#J_tableManager")) {
        var fieldInfoTemplate = $("#J_fieldInfoHideBox").html();
        $(document).delegate(".J_addField", "click", function () {
            var fieldInfoList = $("#J_fieldInfoList");
            if (!fieldInfoList.find(".J_dataItem").length) {
                $("#J_tempField").hide();
            }
            $(fieldInfoTemplate).appendTo($("#J_fieldInfoList"));
        });

        $(document).delegate(".J_fieldName", "change", function () {
            var fieldName = $(this).val();
            if (fieldName) {
                $(this).parents(".J_fieldInfo").find("input,select").each(function () {
                    var input = $(this);
                    var name = input.attr("name");
                    input.attr("name", "fieldEntities[" + fieldName + "]." + name);
                });
            }
        });

        $(".J_selectInputInit").each(function () {
            var select = $(this);
            select.val(select.attr("init-value"));
        });

        $(".J_checkBoxInit").each(function () {
            var box = $(this);
            var initValue = box.attr("init-value");
            box.find("[value='" + initValue + "']").get(0).checked = true;
        });
    }
}