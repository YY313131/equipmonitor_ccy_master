/**
 * Created by caihanbin on 2017/7/26.
 */

window.onload=function () {
    var dataList2=[];
    $.ajax({
        url:"../../defaultValueList",
        data:{subsystemId:4,parameterId:7},
        type:"GET",
        success:function (data2) {
            //  alert(data);
            dataList2=data2;
            buildChart();
        }
    });
    function buildChart() {
        $('#dynamic3').highcharts({
            chart: {
                type: 'line'
            },
            title: {
                text: 'CT301 回水电导'
            },
            subtitle: {
                text: '电导'
            },
            xAxis: {
                categories: ['8:30', '9:00', '9:30', '10:00', '10:30', '11:00', '11:30', '12:00', '12:30', '13:00', '13:30', '14:00','14:30','15:00','15:30','16:00']
            },
            yAxis: {
                title: {
                    text: '电导'
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
                name: '历史曲线',
                data: dataList2
            },{
                name:'平均曲线',
                data:[7.0, 6.9, 7.8, 8.6, 8.3, 7.2, 6.3,4.3, 3.5, 2.5, 5.5, 4.2,5.3,4.2,5.6,6.2]
            }]
        });
    }
}