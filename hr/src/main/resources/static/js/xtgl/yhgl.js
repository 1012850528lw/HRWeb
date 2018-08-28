function tableInit(url) {
    $("#user_table").bootstrapTable({
        url:url,
        method: 'get',
        cache: false,
        toolbar: '#toolbar',
        pagination: true,
        pageSize: 10,
        pageNumber: 1,
        pageList: [10, 25, 50],
        search: false,
        sidePagination: 'server',
        queryParams: queryParams,
        showColumns: true,
        showExport: false,
        showRefresh: true,
        minimumCountColumns: 1,
        clickToSelect: true,
        smartDisplay: true,
        cardView: false,
        columns: [
            {
                field: 'employeeId',
                title: '员工号',
                align: 'center'
            },
            {
                field: 'password',
                title: '密码',
                align: 'center'
            },
            {
                field: 'roleName',
                title: '角色名称',
                align: 'center'
            },
            {
                field: 'userOpenStatus',
                title: '用户开通状态',
                align: 'center'
            },
            {
                field: 'authOrganId',
                title: '组织编号',
                align: 'center'
            },
            {
                title: '操作',
                align: 'center',
                width: 300,
                events: operateEvents,
                formatter: operationFormatter
            }
        ]
    });

    function queryParams(params) {
        var temp = {
            pageSize: params.limit,
            pageNumber: params.offset,
            employeeId: $("#employeeId").val()
        };
        return temp;
    }
}

function operationFormatter(value, row, index) {
    return [
        '<span class="initPassword" style="margin-left:5px;color: white;text-align: center;background: #fe5722;padding: 4px 16px;cursor: pointer;">初始化密码</span>',
        '<span class="modifiedOperate" style="margin-left:5px;color: white;text-align: center;background: #fe5722;padding: 4px 16px;cursor: pointer;">修改</span>',
        '<span class="deleteOperate" style="margin-left:5px;color: white;text-align: center;background: #fe5722;padding: 4px 16px;cursor: pointer;">删除</span>'
    ].join('');
}

window.operateEvents={
    'click .modifiedOperate': function (e, value, row) {
        parent.layer.open({
            type: 2,
            title: '修改用户',
            shade: 0.1,
            shadeClose: true,
            area: ['70%','60%'],
            maxmin: true,
            content: '/user/getOne?employeeId='+row.employeeId,
            end: function () {
                $("#user_table").bootstrapTable('refresh');
            }
        });
    },
    'click .deleteOperate': function (e, value, row) {
        parent.layer.confirm("是否删除此条记录?",{
            shade: false,
            btn: ['确定', '取消']
        }, function () {
            $.ajax({
                type: "get",
                url: "/user/deleteUser",
                dataType: "text",
                data: {"employeeId": row.employeeId},
                error: function () {
                    showInfo("系统错误");
                },
                success: function () {
                    showInfo("删除成功");
                    $("#user_table").bootstrapTable('refresh');
                    closeAddShow();
                }
            });
        })
    },
    'click .initPassword': function (e, value, row) {
        parent.layer.confirm("是否初始化密码？",{
            shade: false,
            btn: ['确定', '取消']
        },function () {
            $.ajax({
                type: 'get',
                url: '/user/initPaw',
                dataType: "text",
                data: {"employeeId": row.employeeId},
                error: function () {
                    showInfo("系统错误");
                },
                success: function () {
                    showInfo("初始化成功");
                    $("#user_table").bootstrapTable('refresh');
                    closeAddShow();
                }
            });
        })
    }
};


$('#form_user_edit').bootstrapValidator({
    message: 'This value is not valid',
    excluded: ':disabled',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        employeeId: {
            message: '编号不能为空',//默认提示信息
            validators: {
                notEmpty: {
                    message: '编号必填不能为空'
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
    }).on('success.form.bv', function (e) {
    e.preventDefault();
    updateUser();
});

function updateUser() {
    $.ajax({
        type: "get",
        url: "/user/updateUser",
        async: false,
        data: $("#form_user_edit").serialize(),
        dataType: "text",
        success: function (data) {
            showInfo("修改成功");
            closeAddShow();
        },
        error: function (data) {
            showInfo("系统错误");
        }
    });
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

function searchUser() {
    $("#user_table").bootstrapTable('destroy');
    tableInit("/user/getList");
}