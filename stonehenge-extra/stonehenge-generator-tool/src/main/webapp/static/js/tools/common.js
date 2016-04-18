/**
 * 公共组件
 */
(function (exportObj, $) {
    /**
     * 通过ajax提交表单
     * @param {} option
     */
    exportObj.ajaxSubmit = function (option) {
        var setting = {
            selector: "",
            component: "",
            type: "POST",
            url: "",
            data: "",
            async: true,
            error: function () {
                alert("出现系统错误……");
            },
            success: function (data) {
                if (data == "1") {
                    alert("操作已成功！");
                } else {
                    alert("操作失败……");
                }
            }
        };
        $.extend(setting, option);

        var form = setting.component ? $(setting.selector, $(setting.component)) : $(setting.selector);
        var formData = setting.data || form.serialize();
        formData += "&isAjaxEvent=true";
        var formAction = "";
        if (form && form.length) {
            formAction = form.attr("action");
        }
        var url = setting.url || formAction;

        $.ajax({
            type: setting.type,
            url: url,
            data: formData,
            async: setting.async,
            error: setting.error,
            success: function (data) {
                var dataObj;
                try {
                    dataObj = $.parseJSON(data);
                } catch (e) {
                    dataObj = {};
                }
                if (dataObj && !dataObj.success && dataObj.message == "notLogin") {
                    alert("登录过期，请重新登录");
                } else {
                    setting.success(dataObj);
                }
            }
        });
    }
})(window, jQuery);