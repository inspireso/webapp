/**
 * 控制重复提交
 */
define(function(require, exports, module) {

    var $ = window.jQuery;

    $doc.on('click', ':submit', function(e) {
        var $this = $(this);
        var $form = $this.parents("form");
        if ($form.length == 1) {
            e.preventDefault();
            e.stopPropagation();
            $this.attr("disabled", "disabled");
            $form.submit();
        }
    });
});
