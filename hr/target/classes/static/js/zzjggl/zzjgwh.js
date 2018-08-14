function treeInit() {
    $("ul li").remove();
    layui.use('tree', function () {
        layui.tree({
            elem: '#organ_tree',
            nodes: []
        });

    });
}
treeInit();

function tableInit(url) {
    $("#organ_table").bootstrapTable({
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
        showColumns: true,
        showExport: false,
        showRefresh: true,
        minimumCountColumns: 1,
        clickToSelect: true,
        smartDisplay: true,
        cardView: false,
        columns: [
            {
                field: 'menuId',
                title: '菜单编号',
                align: 'center'
            },
            {
                field: 'pareMenuId',
                title: '上级菜单编号',
                align: 'center'
            },
            {
                field: 'menuIcon',
                title: '菜单图标',
                align: 'center'
            },
            {
                field: 'isEnable',
                title: '是否可用',
                align: 'center'
            },
            {
                field: 'menuName',
                title: '菜单名称',
                align: 'center'
            },
            {
                field: 'menuUrl',
                title: '菜单URL',
                align: 'center'
            },
            {
                field: 'menuOrder',
                title: '菜单顺序',
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
}

function operationFormatter(value, row, index) {
    return [
        '<span class="modifiedOperate" style="margin-left:5px;color: white;text-align: center;background: #fe5722;padding: 4px 16px;cursor: pointer;">修改</span>',
        '<span class="deleteOperate" style="margin-left:5px;color: white;text-align: center;background: #fe5722;padding: 4px 16px;cursor: pointer;">删除</span>'
    ].join('');
}

window.operateEvents = {

};