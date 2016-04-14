/**
 * 浏览器console处理 对不支持console的浏览器 不做任何处理
 */
(function (window) {
    var consoleSystem = window.console;
    if (!consoleSystem) {
        window.console = {
            log: function (message) {
            }
        };
    }
})(window);