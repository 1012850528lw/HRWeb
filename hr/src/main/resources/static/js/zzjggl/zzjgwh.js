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
        queryParams: queryParams,
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
                field: 'organId',
                title: '组织编号',
                align: 'center'
            },
            {
                field: 'pareOrganId',
                title: '上级组织编号',
                align: 'center'
            },
            {
                field: 'organName',
                title: '组织名称',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'organTypeCode',
                title: '组织类型代码',
                align: 'center'
            },
            {
                field: 'organNote',
                title: '组织职能描述',
                align: 'center',
                formatter:emptyWidth
            },
            {
                field: 'establishDate',
                title: '成立日期',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'revokeDate',
                title: '撤销日期',
                align: 'center'
            },
            {
                field: 'revokeReason',
                title: '撤销原因',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'headEmployeeId',
                title: '负责人员工号',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'unSocialCreditCode',
                title: '统一社会信用代码',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'organAddress',
                title: '地址',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'contactNumber',
                title: '联系电话',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'basicDepositAcct',
                title: '基本户账号',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'basicDepositBank',
                title: '基本户开户行名称',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'organStatus',
                title: '组织状态代码',
                align: 'center'
            },
            {
                field: 'createEmployeeId',
                title: '创建员工号',
                align: 'center'
            },
            {
                field: 'mdyEmployeeId',
                title: '修改员工号',
                align: 'center'
            },
            {
                field: 'createTime',
                title: '创建时间',
                align: 'center'
            },
            {
                field: 'mdyTime',
                title: '修改时间',
                align: 'center'
            },
            {
                field: 'post',
                title: '邮编',
                align: 'center'
            },
            {
                field: 'fax',
                title: '传真',
                align: 'center'
            },
            {
                field: 'organLevel',
                title: '组织级别',
                align: 'center'
            },
            {
                title: '操作',
                align: 'center',
                events: operateEvents,
                formatter: operationFormatter
            }
        ]
    });

    function queryParams(params) {
        var temp = {
            pageSize: params.limit,
            pageNumber: params.offset
        };
        return temp;
    }
}

function treeInit() {
    $("ul li").remove();
    layui.use('tree', function () {
        layui.tree({
            elem: '#organ_tree',
            nodes: getTreeData()
        });

    });
}
treeInit();

var midData = [];
function getTreeData() {
    var treeData = [];
    var rootTree = new Array();
    var treeNode;
    $.ajax({
        type: 'get',
        url: '/organ/getAll',
        async: false,
        dataType: 'json',
        success: function (data) {
            treeData = JSON.parse(JSON.stringify(data));
            midData = JSON.parse(JSON.stringify(data));
        }
    });
    treeData.forEach(function (e) {
        if(e.pareOrganId === "～"){
            var obj = {organId: "",name: "",pareOrganId: "",children: new Array()};
            obj.organId = e.organId;
            obj.name = e.organName;
            obj.pareOrganId = e.pareOrganId;
            obj.children = buildChildren(e.organId);
            rootTree.push(obj);
        }
    });
    treeNode = JSON.parse(JSON.stringify(rootTree));
    return treeNode;
}

function buildChildren(organId) {
    var nTypeData = new Array();
    var treeChild = new Array();
    midData.forEach(function (value) {
        if(value.pareOrganId === organId){
            nTypeData.push(value);
        }
    });
    nTypeData.forEach(function (value) {
        if(value.organId != null && value.organId != ""){
            var obj1 = {organId: "",pareOrganId:"",name: "",children: new Array()};
            obj1.organId = value.organId;
            obj1.name = value.organName;
            obj1.pareOrganId = value.pareOrganId;
            obj1.children = buildChildren(value.organId);
            treeChild.push(obj1)
        }else{
            var obj2 = {organId:"",pareOrganId:"",name:"",children:new Array()};
            obj2.organId = value.organId;
            obj2.name = value.organName;
            obj2.pareOrganId = value.pareOrganId;
            treeChild.push(obj2);
        }
    });
    return treeChild;
}

function emptyWidth(value, row, index) {
    var div = "<div style='width:250px;'>"+value+"</div>";//调列宽，在td中嵌套一个div，调整div大小
    return div;
}

function operationFormatter(value, row, index) {
    return [
        '<div style=\'width:200px;\'></div>',
        '<span class="modifiedOperate" style="margin-left:5px;color: white;text-align: center;background: #fe5722;padding: 4px 16px;cursor: pointer;">修改</span>',
        '<span class="deleteOperate" style="margin-left:5px;color: white;text-align: center;background: #fe5722;padding: 4px 16px;cursor: pointer;">删除</span>'
    ].join('');
}

window.operateEvents = {
    'click .modifiedOperate': function (e, value, row) {
        parent.layer.open({
            type: 2,
            title: '修改组织',
            shade: 0.1,
            shadeClose: true,
            area: ['70%','70%'],
            maxmin: true,
            content: '/organ/getOne?organId='+row.organId,
            end: function () {
                $("#organ_table").bootstrapTable('refresh');
                treeInit();
            }
        });
    }
};

$('#form_organ_edit').bootstrapValidator({
    message: 'This value is not valid',
    excluded: ':disabled',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
        organId: {
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
    updateOrgan();
});

function updateOrgan() {
    $.ajax({
        type: "get",
        url: "/organ/updateOrgan",
        async: false,
        data: $("#form_organ_edit").serialize(),
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