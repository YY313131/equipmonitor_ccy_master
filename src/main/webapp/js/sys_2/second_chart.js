/**
 * Created by admin on 2017/2/23.
 */
// var max=null;
// var min=null;
// function setBound() {
//     $.ajax({
//         url:"/waterEquip/getValueBound",
//         type:"GET",
//         success:function (bound) {
//             var obj=eval('(' + bound + ')');
//             max=obj.max_value;
//             min=obj.min_value;
//         }
//     });
// }
// function excuteAjax1() {
//         $.ajax({
//             url:"/waterEquip/pureWaterPh",
//             type:"GET",
//             success:function (data) {
//                 var last=parseFloat(14-data);
//                 var first=parseFloat(data);
//                 var list=[["当前PH",first],["剩余",last]];
//                 // alert(list);
//                 //alert(data);
//                 if(first>7||first<5){
//                     $("#normal1").removeClass("btn-success btn-danger");
//                     $("#normal1").addClass("btn-danger");
//                     $("#normal1").html("状态异常");
//
//                 }else{
//                     $("#normal1").removeClass("btn-danger btn-success");
//                     $("#normal1").addClass("btn-success");
//                     $("#normal1").html("状态正常");
//                 }
//                 $("#ph").html("&nbsp;&nbsp;&nbsp;"+data);
//
//             }
//         });
//         $.ajax({
//             url:"/waterEquip/pureWaterCt02",
//             type:"GET",
//             success:function (data) {
//                 $("#ct02").html("&nbsp;&nbsp;&nbsp;"+data);
//                 var first=parseFloat(data);
//                 var list=[first];
//                //alert(min);
//                 if(first<min||first>max){
//                     $("#normal2").removeClass("btn-success btn-danger");
//                     $("#normal2").addClass("btn-danger");
//                     $("#normal2").html("状态异常");
//                 }else{
//                     $("#normal2").removeClass("btn-danger btn-success");
//                     $("#normal2").addClass("btn-success");
//                     $("#normal2").html("状态正常");
//                 }
//
//             }
//         });
//         $.ajax({
//             url:"/waterEquip/pureWaterCt04",
//             type:"GET",
//             success:function (data) {
//                 $("#ct04").html("&nbsp;&nbsp;&nbsp;"+data);
//                 var first=parseFloat(data);
//                 if(first<min||first>max){
//                     $("#normal3").removeClass("btn-success btn-danger");
//                     $("#normal3").addClass("btn-danger");
//                     $("#normal3").html("状态异常");
//                 }else{
//                     $("#normal3").removeClass("btn-danger btn-success");
//                     $("#normal3").addClass("btn-success");
//                     $("#normal3").html("状态正常");
//                 }
//                 var list=[first];
//
//             }
//         });
//        //  setTimeout(arguments.callee,2000);
//     }
// setBound();
// excuteAjax1();

$(function () {
    $('#container1').highcharts({
            chart: {
                type: 'gauge',
                plotBorderWidth: 1,
                plotBackgroundColor: {
                    linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                    stops: [
                        [0, '#FFF4C6'],
                        [0.3, '#FFFFFF'],
                        [1, '#FFF4C6']
                    ]
                },
                plotBackgroundImage: null,
                height: 300
            },
            title: {
                text: 'RO膜 出水电导'
            },
            pane: [{
                startAngle: -45,
                endAngle: 45,
                background: null,
                center: ['50%', '105%'],
                size: 300
            }],
            yAxis: [{
                min: 0,
                max: 30,
                minorTickPosition: 'outside',
                tickPosition: 'outside',
                labels: {
                    rotation: 'auto',
                    distance: 20
                },
                plotBands: [{
                    from: 21,
                    to: 30,
                    color: '#C02316',
                    innerRadius: '100%',
                    outerRadius: '105%'
                }],
                pane: 0,
                title: {
                    text: '电导<br/>',
                    y: -40
                }
            }],
            plotOptions: {
                gauge: {
                    dataLabels: {
                        enabled: false
                    },
                    dial: {
                        radius: '100%'
                    }
                }
            },
            series: [{
                data:[4.5],
                yAxis: 0
            }]
        },
        //1秒请求一次
        function (chart) {
                setInterval(function () {
                    if(chart.series){
                    var value=chart.series[0].points[0];
                    $.ajax({
                        url: "../../getSys1TopValue",
                        type: "GET",
                        data:{subsystemId:1,parameterId:1},
                        // async:"false",
                        success: function (data) {
                            //  更新图表
                            console.log(data);
                            var valueArray=data.split(";");
                            var a=parseFloat(valueArray[0]);
                            console.log(a);
                            var a1=Math.floor(a* 100) / 100;
                            $("#ph").html("&nbsp;&nbsp;&nbsp;"+a1+" uS");
                            value.update(a1, false);
                            chart.redraw();
                            //更新状态
                           // alert(valueArray[1]);
                            if(valueArray[1]==0){
                                $("#normal1").removeClass("btn-success btn-danger");
                                $("#normal1").addClass("btn-danger");
                                $("#normal1").html("状态异常");
                            }else{
                                $("#normal1").removeClass("btn-danger btn-success");
                                $("#normal1").addClass("btn-success");
                                $("#normal1").html("状态正常");
                            }
                        }
                     })
                    }
                },1000);
        }
    );
    $('#container2').highcharts({
        chart: {
            type: 'gauge',
            plotBorderWidth: 1,
            plotBackgroundColor: {
                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                stops: [
                    [0, '#FFF4C6'],
                    [0.3, '#FFFFFF'],
                    [1, '#FFF4C6']
                ]
            },
            plotBackgroundImage: null,
            height: 300
        },
        title: {
            text: 'RO膜 PH值'
        },
        pane: [{
            startAngle: -45,
            endAngle: 45,
            background: null,
            center: ['50%', '105%'],
            size: 300
        }],
        yAxis: [{
            min: 0,
            max: 14,
            minorTickPosition: 'outside',
            tickPosition: 'outside',
            labels: {
                rotation: 'auto',
                distance: 20
            },
            plotBands: [{
                from: 7,
                to: 14,
                color: '#C02316',
                innerRadius: '100%',
                outerRadius: '105%'
            }],
            pane: 0,
            title: {
                text: 'PH<br/>',
                y: -40
            }
        }],
        plotOptions: {
            gauge: {
                dataLabels: {
                    enabled: false
                },
                dial: {
                    radius: '100%'
                }
            }
        },
        series: [{
            data: [2.5],
            yAxis: 0
        }]
    },
        function (chart) {
            setInterval(function () {
                if(chart.series){
                    var value=chart.series[0].points[0];
                    $.ajax({
                        url: "../../getSys1TopValue",
                        type: "GET",
                        data:{subsystemId:1,parameterId:2},
                        // async:"false",
                        success: function (data) {
                            //  value=data;
                            var valueArray=data.split(";");
                            var a=parseFloat(valueArray[0]);
                            console.log(a);
                            var a1=Math.floor(a* 100) / 100;
                            $("#ct02").html("&nbsp;&nbsp;&nbsp;"+a1);
                            value.update(a1, false);
                            chart.redraw();
                            if(valueArray[1]==0){
                                $("#normal2").removeClass("btn-success btn-danger");
                                $("#normal2").addClass("btn-danger");
                                $("#normal2").html("状态异常");
                            }else{
                                $("#normal2").removeClass("btn-danger btn-success");
                                $("#normal2").addClass("btn-success");
                                $("#normal2").html("状态正常");
                            }
                        }
                    })
                }
            },1000);
        }
    );
    $('#container3').highcharts({
        chart: {
            type: 'gauge',
            plotBorderWidth: 1,
            plotBackgroundColor: {
                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                stops: [
                    [0, '#FFF4C6'],
                    [0.3, '#FFFFFF'],
                    [1, '#FFF4C6']
                ]
            },
            plotBackgroundImage: null,
            height: 300
        },
        title: {
            text: 'EDI  出水电导'
        },
        pane: [{
            startAngle: -45,
            endAngle: 45,
            background: null,
            center: ['50%', '105%'],
            size: 300
        }],
        yAxis: [{
            min: 0,
            max: 8,
            minorTickPosition: 'outside',
            tickPosition: 'outside',
            labels: {
                rotation: 'auto',
                distance: 20
            },
            plotBands: [{
                from: 4.3,
                to: 8,
                color: '#C02316',
                innerRadius: '100%',
                outerRadius: '105%'
            }],
            pane: 0,
            title: {
                text: '电导<br/>',
                y: -40
            }
        }],
        plotOptions: {
            gauge: {
                dataLabels: {
                    enabled: false
                },
                dial: {
                    radius: '100%'
                }
            }
        },
        series: [{
            data:[5.5],
            yAxis: 0
        }]
    }
    ,
        function (chart) {
            setInterval(function () {
                if(chart.series){
                    var value=chart.series[0].points[0];
                    $.ajax({
                        url: "../../getSys1TopValue",
                        type: "GET",
                        data:{subsystemId:1,parameterId:3},
                        // async:"false",
                        success: function (data) {
                            //  value=data;
                            var valueArray=data.split(";");
                            var a=parseFloat(valueArray[0]);
                            console.log(a);
                            var a1=Math.floor(a* 100) / 100;
                            $("#ct04").html("&nbsp;&nbsp;&nbsp;"+a1+" uS");
                            value.update(a1, false);
                            chart.redraw();
                            if(valueArray[1]==0){
                                $("#normal3").removeClass("btn-success btn-danger");
                                $("#normal3").addClass("btn-danger");
                                $("#normal3").html("状态异常");
                            }else{
                                $("#normal3").removeClass("btn-danger btn-success");
                                $("#normal3").addClass("btn-success");
                                $("#normal3").html("状态正常");
                            }
                        }
                    })
                }
            },1000);
        });
})

