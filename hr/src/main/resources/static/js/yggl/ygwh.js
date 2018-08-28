function tableInit(url) {
    $("#employee_table").bootstrapTable({
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
                title: '操作',
                align: 'center',
                events: operateEvents,
                formatter: operationFormatter
            },
            {
                field: 'employeeId',
                title: '员工号',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'organId',
                title: '组织编号',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'employeeName',
                title: '员工姓名',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'postName',
                title: '职务',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'sexTypeCode',
                title: '性别',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'birthDate',
                title: '出生日期',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'age',
                title: '年龄',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'identId',
                title: '身份证号',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'mobile',
                title: '主用移动电话',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'postalAddress',
                title: '通讯地址',
                align: 'center',
                formatter: emptyBigWidth
            },
            {
                field: 'postalPost',
                title: '通讯地址邮编',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'residAddress',
                title: '户籍地址',
                align: 'center',
                formatter: emptyBigWidth
            },
            {
                field: 'residPost',
                title: '户籍地址邮编',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'baseLocation',
                title: '工作基地',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'socialPayLocation',
                title: '社保缴纳地区',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'eduBackLevelCode',
                title: '最高学历代码',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'gradDate',
                title: '毕业日期',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'gradSchoolName',
                title: '毕业院校名称',
                align: 'center',
                formatter: emptyBigWidth
            },
            {
                field: 'gradProfessName',
                title: '毕业专业名称',
                align: 'center',
                formatter: emptyBigWidth
            },
            {
                field: 'gradSchoolTypeCode',
                title: '毕业院校类型代码',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'joinWorkDate',
                title: '参加工作日期',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'workAge',
                title: '工龄',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'joinCompDate',
                title: '入司日期',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'compAge',
                title: '司龄',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'lastContTypeCode',
                title: '最近一次合同类型代码',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'lastContBeginDate',
                title: '最近一次合同开始日期',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'lastContEndDate',
                title: '最近一次合同到期日期',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'resumeSource',
                title: '简历来源',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'payCardId',
                title: '工资卡号',
                align: 'center',
                formatter: emptyBigWidth
            },
            {
                field: 'payCardBankName',
                title: '工资卡开户行名称',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'dingdingOpenStatus',
                title: '钉钉开通状态',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'mailOpenStatus',
                title: '邮箱开通状态',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'wipeSysOpenStatus',
                title: '报销系统开通状态',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'trainSysOpenStatus',
                title: '培训系统开通状态',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'employeeStatus',
                title: '员工状态',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'putOffDate',
                title: '使用顺延日期',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'becomeDate',
                title: '转正日期',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'leaveDate',
                title: '离职日期',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'leaveReason',
                title: '离职原因',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'leaveNote',
                title: '离职说明',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'professCert',
                title: '专业证书',
                align: 'center',
                formatter: emptyWidth
            },
            {
                field: 'remark',
                title: '备注',
                align: 'center',
                formatter: emptyWidth
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

function operationFormatter(value, row, index) {
    return [
        '<div style=\'width:150px;\'></div>',
        '<span class="modifiedOperate" style="margin-left:5px;color: white;text-align: center;background: #fe5722;padding: 4px 16px;cursor: pointer;">修改</span>',
        '<span class="deleteOperate" style="margin-left:5px;color: white;text-align: center;background: #fe5722;padding: 4px 16px;cursor: pointer;">删除</span>'
    ].join('');
}
function emptyWidth(value, row, index) {
    var div = "<div style='width:130px;'>"+value+"</div>";//调列宽，在td中嵌套一个div，调整div大小
    return div;
}
function emptyBigWidth(value,row,index) {
    var div = "<div style='width:350px;'>"+value+"</div>";
    return div;
}
window.operateEvents = {};

function treeInit() {
    $("ul li").remove();
    layui.use('tree',function () {
        layui.tree({
            elem: '#employee_tree',
            nodes: getTreeData(),
            click: function (item) {
                $("#employee_table").bootstrapTable('destroy');
                tableInit("/employee/selectByOrganId?organId="+item.organId);
            }
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
