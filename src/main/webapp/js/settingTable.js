/**
 * Created by caihanbin on 2017/4/9.
 */
/**
 * Created by admin on 2017/2/23.
 */

$(function () {
    //1.初始化Table
    var oTable1 = new TableInit();
    oTable1.Init();

    //2.初始化Button的点击事件
    var oButtonInit2 = new ButtonInit();
    oButtonInit2.Init();

});


var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#setting').bootstrapTable({
            url: '/waterEquip/settingValue',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination:true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showExport: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            //  uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                field: 'check_state',
                checkbox:true
            },
               {
                field: 'system_id',
                title: '系统名称',
                width:'25%'
            }, {
                field: 'sensor_id',
                title: '传感器编号',
                width:'25%'
            }, {
                field: 'max_value',
                title: '上限值',
                editable:{
                    type: 'text',
                    title: '上限值',
                    validate: function (v) {
                        if (!v) return '输入值不能为空';

                    }
                },
                width:'25%'
            }, {
                field: 'min_value',
                title: '下限值',
                    editable:{
                        type: 'text',
                        title: '下限值',
                        validate: function (v) {
                            if (!v) return '输入值不能为空';

                        }
                    },
                width:'25%'
            }],
            onEditableSave: function (field, row, oldValue, $el) {
                $.ajax({
                    type: "GET",
                    url: "/waterEquip/settingEdit",
                    data: { strJson: JSON.stringify(row) },
                    success: function (data) {
                      alert(data);
                    }
                });
            }
        });
    };

    // 得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            // departmentname: $("#txt_search_departmentname").val(),
            // statu: $("#txt_search_statu").val()
        };
        return temp;
    };
    return oTableInit;
};


var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        $("#btn_add").click(function () {
            $("#myModalLabel").text("新增");
            $("#myModal").find(".form-control").val("");
            $('#myModal').modal();
        });
        $("#btn_submit").click(function () {
            postdata.system_id=$("#sys_name").val();
            postdata.sensor_id=$("#sensor_id").val();
            postdata.max_value=$("#max_value").val();
            postdata.min_value=$("#min_value").val();
            postdata.check_state=false;
            $.ajax({
                type:"post",
                url:"/waterEquip/settingAdd",
                data:{str: JSON.stringify(postdata)},
                success:function (data) {
                    // alert(data);
                    $("#setting").bootstrapTable('refresh');
                }
            })
        })
        $("#btn_edit").click(function () {
            var arrselections = $("#setting").bootstrapTable('getSelections');
            if (arrselections.length > 1) {
                alert("只能选择一行数据");
                return;
            }
            if (arrselections.length <= 0) {
                alert("请选择有效数据");
                return;
            }
            // $("#myModalLabel").text("编辑");
            // $("#txt_rolename").val(arrselections[0].ROLE_NAME);
            // $("#txt_roledesc").val(arrselections[0].DESCRIPTION);
            // $("#txt_defaulturl").val(arrselections[0].ROLE_DEFAULTURL);
            // $("#txt_defaulturl_Web").val(arrselections[0].ROLE_DEFAULTURL_WEB);

            postdata.ROLE_ID = arrselections[0].ROLE_ID;
            $('#myModal').modal();
        });
    };
    $("#btn_delete").click(function () {
        var arrselections = $("#setting").bootstrapTable('getSelections');
        if(arrselections.length<=0){
            alert("请选择有效数据进行删除");
            return;
        }
        if(confirm("确认要删除该数据么？")==true){
            // return true;
            alert("删除")
            $.ajax({
                type:"GET",
                url:"/waterEquip/settingDelete",
                data:{str:JSON.stringify(arrselections[0])},
                success:function (data) {
                    alert("删除成功");
                    $("#setting").bootstrapTable('refresh');
                }
            })
        }else {
            return false;
        }
    })
    return oInit;
};

