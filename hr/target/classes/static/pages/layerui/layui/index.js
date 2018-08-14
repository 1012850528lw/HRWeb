function updatePaw() {
    layer.open({
        type: 2,
        title: '修改密码',
        shade: 0.1,
        shadeClose: true,
        area: ['50%', '50%'],
        content: '/password',
        end: function () {

        }
    })
}

$("#form_password").bootstrapValidator({
    message: 'this value is not valid',
    excluded: 'disabled',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        employeeId: {
            message: '编号不能为空',
            validators: {
                notEmpty: {
                    message: '编号不能为空'
                }
            }
        },
        password: {
            message: '密码不能为空',
            validators: {
                notEmpty: {
                    message: '密码不能为空'
                },
                identical: {
                    field: 'comPaw',
                    message: '两次输入密码不一致'
                }
            }
        },
        comPaw: {
            message: '密码不能为空',
            validators: {
                notEmpty: {
                    message: '密码不能为空'
                },
                identical: {
                    field: 'password',
                    message: '两次输入密码不一致'
                }
            }
        }
    }
}).on(
    'error.form.bv',
    function (e) {
        var $form = $(e.target), validator = $form
            .data('bootstrapValidator'), $invalidField = validator
            .getInvalidFields().eq(0), $collapse = $invalidField
            .parents('.collapse');

        $collapse.collapse('show');
    }
).on(
    'success.form.bv',
    function (e) {
        e.preventDefault();
        updatePassword();
    }
);

function updatePassword() {
    $.ajax({
        type: "get",
        url: "/user/updatePaw",
        async: false,
        data: $("#form_password").serialize(),
        dataType: "text",
        success: function (data) {
            showInfo("修改成功");
            closeAddShow();
        },
        error: function (data) {
            showInfo("系统错误")
        }
    })
}

function showInfo(str) {
    parent.layer.msg(str,{
        offset: 't',
        time: 1000,
        anim: 4
    })
}

function closeAddShow() {
    setTimeout(function () {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    },200);
}
