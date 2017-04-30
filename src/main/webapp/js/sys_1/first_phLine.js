/**
 * Created by caihanbin on 2017/4/30.
 */
window.onload=function () {
    var dataList=[];
    $("#select").click(function () {
        var url;
        var data1={};
        if(($("#startTime").val())!=$("#endTime").val()){
            url="../../valueListBetweenDate";
            data1={subsystemId:1,parameterId:1,
                beginTime:$("#startTime").val(),
                endTime:$("#endTime").val()};
        }else {
            url="../../valueListAfterDate";
            data1={subsystemId:1,parameterId:1,
                beginTime:$("#startTime").val()};
        }
        $.ajax({
            url:url,
            type:"GET",
            data:data1,
            success:function (data) {
                //   alert(data);
                dataList=data;
                buildChart();
            }
        })
    })
    $.ajax({
        url:"../../valueListAfterDate",
        data:{subsystemId:1,parameterId:1,beginTime:$("#startTime").val()},
        type:"GET",
        success:function (data) {
          //  alert(data);
            dataList=data;
            buildChart();
        }
    });
    //绘制曲线
    function buildChart() {
        $('#dynamic1').highcharts({
            chart: {
                type: 'line'
            },
//                    colors:[
//                        '#7cb5ec',//蓝
//                        '#00FF00',//绿
//                        '#000000',//黑
//                        '#FF0000',//红
//                        '#FFFF00',//黄
//                        '#FF00FF',//紫
//                        '#FFFFFF',//紫
//                    ],
            title: {
                text: 'PH-01 RO膜'
            },
            subtitle: {
                text: 'PH值'
            },
            xAxis: {
                categories: ['8:30', '9:00', '9:30', '10:00', '10:30', '11:00', '11:30', '12:00', '12:30', '13:00', '13:30', '14:00','14:30','15:00','15:30','16:00']
            },
            yAxis: {
                title: {
                    text: 'PH(5-7)'
                }
            },
            plotOptions: {
                line: {
                    dataLabels: {
                        enabled: true
                    },
                    enableMouseTracking: false
                }
            },
            series: [{
                name: 'PH当前数据',
                data: dataList
            },{
                name:'PH历史数据',
                data:[7.0, 6.9, 7.8, 8.6, 8.3, 7.2, 6.3,4.3, 3.5, 2.5, 5.5, 4.2,5.3,4.2,5.6,6.2]
            }]
        });
    }
    // submmitAjax();

}
$(function(){
    $('#startTime').datetimepicker({
        dayOfWeekStart: 1,
        lang: 'CN',
        disabledDates: ['1986/01/08', '1986/01/09', '1986/01/10'],
        startDate: '2015/11/01'
    });
    $('#startTime').datetimepicker({ value: '2015/11/02 ', step: 10 });
    $('#endTime').datetimepicker({
        dayOfWeekStart: 1,
        lang: 'CN',
        disabledDates: ['1986/01/08', '1986/01/09', '1986/01/10'],
        startDate: '2015/11/01'
    });
    $('#endTime').datetimepicker({ value: '2015/11/02 ', step: 10 });
});