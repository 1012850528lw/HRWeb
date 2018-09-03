layui.use('laydate',function () {
    var laydate = layui.laydate;
    laydate.render({
        elem: '#createTime'
    });
    laydate.render({
        elem: '#mdyTime',
        lang: 'en'
    })
});

function tableInit(url) {
    $("#role_table").bootstrapTable({
        url: url,
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
                field: 'roleId',
                title: '角色编号',
                align: 'center'
            },
            {
                field: 'pareRoleId',
                title: '上级角色编号',
                align: 'center'
            },
            {
                field: 'roleName',
                title: '角色名称',
                align: 'center'
            },
            {
                field: 'roleTypeCode',
                title: '角色类型代码',
                align: 'center'
            },
            {
                field: 'createEmployeeId',
                title: '创建员工号',
                align: 'center'
            },
            {
                field: 'createTime',
                title: '创建时间',
                align: 'center'
            },
            {
                field: 'mdyEmployeeId',
                title: '修改员工号',
                align: 'center'
            },
            {
                field: 'mdyTime',
                title: '修改时间',
                align: 'center'
            },
            {
                title: '操作',
                align: 'center',
                width: 200,
                events: operateEvents,
                formatter: operationFormatter
            }
        ]
    });

    function queryParams(params) {
        var temp = {
            pageSize: params.limit,
            pageNumber: params.offset,
            roleId: $("#roleId").val(),
            pareRoleId: $("#pareRoleId").val(),
            roleName: $("#roleName").val()
        };
        return temp;
    }
}

function operationFormatter(value, row, index) {
    return [
        '  <button class="layui-btn layui-btn-primary layui-btn-sm" id="modifiedOperate">\n' +
        '    <i class="layui-icon">&#xe642;</i>\n' +
        '  </button>',
        '  <button class="layui-btn layui-btn-primary layui-btn-sm" id="deleteOperate">\n' +
        '    <i class="layui-icon">&#xe640;</i>\n' +
        '  </button>'
    ].join('');
}

window.operateEvents = {
    'click #modifiedOperate': function (e, value, row) {
        parent.layer.open({
            type: 2,
            title: '修改菜单',
            shade: 0.1,
            shadeClose: true,
            area: ['70%','70%'],
            maxmin: true,
            content: '/role/getOne?roleId='+row.roleId,
            end: function () {
                $("#menu_table").bootstrapTable('refresh');
            }
        });
    },
    'click #deleteOperate': function (e, value, row) {
        parent.layer.confirm("是否删除此条记录?",{
            shade: false,
            btn: ['确定', '取消']
        }, function () {
            $.ajax({
                type: "get",
                url: "/role/deleteRole",
                dataType: "text",
                data: {"roleId": row.roleId},
                error: function () {
                    showInfo("系统错误");
                },
                success: function () {
                    showInfo("删除成功");
                    $("#role_table").bootstrapTable('refresh');
                    closeAddShow();
                }
            });
        })
    }
};

function addShow() {
    parent.layer.open({
        type: 2,
        title: '增加角色',
        shade: 0.1,
        shadeClose: true,
        area: ['70%', '70%'],
        content: '/jsgl_add',
        end: function () {
            $("#role_table").bootstrapTable('refresh');
        }
    });
}

//增加
$("#form_role_add").bootstrapValidator({
    message: 'this value is not valid',
    excluded: 'disabled',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        roleId: {
            message: '编号不能为空',
            validators: {
                notEmpty: {
                    message: '编号不能为空'
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
        roleSaveOne();
    }
);

//添加提交
function roleSaveOne() {
    $.ajax({
        type: "get",
        url: "/role/insertRole",
        async: false,
        data: $("#form_role_add").serialize(),
        dataType: "text",
        success: function (data) {
            showInfo("添加成功");
            closeAddShow();
        },
        error: function (data) {
            showInfo("系统错误")
        }
    })
}

$('#form_role_edit').bootstrapValidator({
    message: 'This value is not valid',
    excluded: ':disabled',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        roleId: {
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
    updateRole();
});

function updateRole() {
    $.ajax({
        type: "get",
        url: "/role/updateRole",
        async: false,
        data: $("#form_role_edit").serialize(),
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

function searchRole() {
    $("#role_table").bootstrapTable('destroy');
    tableInit("/role/getList");
}