function tableInit(url) {
    $("#role_table").bootstrapTable({
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
        '<span class="modifiedOperate" style="margin-left:5px;color: white;text-align: center;background: #fe5722;padding: 4px 16px;cursor: pointer;">修改</span>',
        '<span class="deleteOperate" style="margin-left:5px;color: white;text-align: center;background: #fe5722;padding: 4px 16px;cursor: pointer;">删除</span>'
    ].join('');
}

window.operateEvents={};