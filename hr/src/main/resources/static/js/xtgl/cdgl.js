function treeInit() {
    $("ul li").remove();
    layui.use('tree', function () {
        layui.tree({
            elem: '#menu_tree',
            nodes: getTreeData(),
            click: function(item){
                var tableData = [];
                $.ajax({
                    type: "get",
                    url: "/menu/selectTree?menuId="+item.menuId,
                    data: "",
                    async: false,
                    dataType: "json",
                    success: function (data) {
                        tableData = JSON.parse(JSON.stringify(data));
                        $("#menu_table").bootstrapTable("removeAll");
                        $("#menu_table").bootstrapTable('append',tableData);
                    }
                });
            }
        })
    });
}
treeInit();

function tableInit(url) {
    $("#menu_table").bootstrapTable({
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
function queryParams(params) {
    var temp = {
        pageSize: params.limit,
        pageNumber: params.offset,
        menuName: $("#menuName").val(),
        menuId: $("#menuId").val(),
        pareMenuId: $("#pareMenuId").val()
    };
    return temp;
}
function addShow() {
    parent.layer.open({
        type: 2,
        title: '增加菜单',
        shade: 0.1,
        shadeClose: true,
        maxmin: true,
        area: ['70%', '60%'],
        content: '/cdgl_add',
        end: function () {
            $("#menu_table").bootstrapTable('refresh');
            treeInit();
        }
    });
}

var midData = [];

function getTreeData() {
    var treeData = [];
    var rootTree = new Array();
    var treeNode;
    $.ajax({
        type: "get",
        url: "/menu/getAll",
        data: "",
        async: false,
        dataType: "json",
        success: function (data) {
            treeData = JSON.parse(JSON.stringify(data));
            midData = JSON.parse(JSON.stringify(data));
        }
    });
    treeData.forEach(function (e) {
        if(e.pareMenuId === ""){
            var obj = {menuId: "", name: "", pareMenuId: "", children: new Array()};
            obj.menuId = e.menuId;
            obj.name = e.menuName;
            obj.pareMenuId = e.pareMenuId;
            obj.children = buildChildren(e.menuId);
            rootTree.push(obj);
        }
    });
    treeNode = JSON.parse(JSON.stringify(rootTree));
    return treeNode;
}

function buildChildren(menuId) {
    var nTypeData = new Array();
    var treeChild = new Array();
    midData.forEach(function (value) {
        if(value.pareMenuId === menuId){
            nTypeData.push(value);
        }
    });
    nTypeData.forEach(function (e) {
        if(e.menuId !== null && e.menuId !== ""){
            var obj = {menuId: "", name: "", pareMenuId: "", children: new Array()};
            obj.menuId = e.menuId;
            obj.name = e.menuName;
            obj.pareMenuId = e.pareMenuId;
            obj.children = buildChildren(e.menuId);
            treeChild.push(obj);
        }else{
            var obj = {menuId: "", name: "", pareMenuId: "", children: new Array()};
            obj.menuId = e.menuId;
            obj.name = e.menuName;
            obj.pareMenuId = e.pareMenuId;
            treeChild.push(obj);
        }
    });
    return treeChild;
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
            area: ['70%','60%'],
            maxmin: true,
            content: '/menu/getOne?menuId='+row.menuId,
            end: function () {
                $("#menu_table").bootstrapTable('refresh');
                treeInit();
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
                url: "/menu/deleteMenu",
                dataType: "text",
                data: {"menuId": row.menuId},
                error: function () {
                    showInfo("系统错误");
                },
                success: function () {
                    showInfo("删除成功");
                    $("#menu_table").bootstrapTable('refresh');
                    treeInit();
                    closeAddShow();
                }
            });
        })
    }
};

//增加菜单
$('#form_menu_add').bootstrapValidator({
    message: 'This value is not valid',
    excluded: ':disabled',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        menuId: {
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
    menuSaveOne();
});

function closeAddShow() {
    setTimeout(function () {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    },200);
}

function showInfo(str) {
    parent.layer.msg(str,{
        offset: 't',
        time: 1000,
        anim: 6
    });
}
//添加提交
function menuSaveOne() {
    $.ajax({
        type: "get",
        url: "/menu/insertMenu",
        async: false,
        data: $("#form_menu_add").serialize(),
        dataType: "text",
        success: function () {
            showInfo("菜单添加成功");
            closeAddShow();
        },
        error: function () {
            showInfo("系统错误");
        }
    });
}

//表单修改校验
$('#form_menu_edit').bootstrapValidator({
    message: 'This value is not valid',
    excluded: ':disabled',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        menuId: {
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
    updateMenu();
});

function updateMenu() {
    $.ajax({
        type: "get",
        url: "/menu/updateMenu",
        async: false,
        data: $("#form_menu_edit").serialize(),
        dataType: "text",
        success: function (data) {
            showInfo("菜单修改成功");
            closeAddShow();
        },
        error: function (data) {
            showInfo("系统错误");
        }
    });
}


function searchMenu() {
    $("#menu_table").bootstrapTable('destroy');
    tableInit("/menu/getList");
}
