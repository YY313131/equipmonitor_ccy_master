/**
 * Created by caihanbin on 2017/4/24.
 */
$(function () {
    $('#ele_3').highcharts({
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
            text: 'CT501回水电导'
        },
        pane: [{
            startAngle: -40,
            endAngle: 40,
            background: null,
            center: ['50%', '105%'],
            size: 300
        }],
        yAxis: [{
            min: 0,
            max: 2,
            minorTickPosition: 'outside',
            tickPosition: 'outside',
            labels: {
                rotation: 'auto',
                distance: 20
            },
            plotBands: [{
                from: 1,
                to: 2,
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
            data: [0.8],
            yAxis: 0
        }]
    },
    //
        function (chart) {
            setInterval(function () {
                if(chart.series){
                    var value=chart.series[0].points[0];
                    $.ajax({
                        url: "../../getSys1TopValue",
                        type: "GET",
                        data:{subsystemId:3,parameterId:7},
                        // async:"false",
                        success: function (data) {
                            //  更新图表
                            console.log(data);
                            var valueArray=data.split(";");
                            var a=parseFloat(valueArray[0]);
                            console.log(a);
                            var a1=Math.floor(a* 100) / 100;
                            $("#ele3_1").html("&nbsp;&nbsp;&nbsp;"+a1+" us");
                            value.update(a1, false);
                            chart.redraw();
                            //更新状态
                            // alert(valueArray[1]);
                            if(valueArray[1]==0){
                                $("#normal4").removeClass("btn-success btn-danger");
                                $("#normal4").addClass("btn-danger");
                                $("#normal4").html("状态异常");
                            }else{
                                $("#normal4").removeClass("btn-danger btn-success");
                                $("#normal4").addClass("btn-success");
                                $("#normal4").html("状态正常");
                            }
                        }
                    })
                }
            },1000);
        }
    );
    $('#temp1_3').highcharts({
        chart: {
            type: 'gauge',
            plotBackgroundColor: null,
            plotBackgroundImage: null,
            plotBorderWidth: 0,
            plotShadow: false
        },
        title: {
            text: 'TT501储水罐温度'
        },
        pane: {
            startAngle: -120,
            endAngle: 120,
            background: [{
                backgroundColor: {
                    linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                    stops: [
                        [0, '#FFF'],
                        [1, '#333']
                    ]
                },
                borderWidth: 0,
                outerRadius: '109%'
            }, {
                backgroundColor: {
                    linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                    stops: [
                        [0, '#333'],
                        [1, '#FFF']
                    ]
                },
                borderWidth: 1,
                outerRadius: '107%'
            }, {
                // default background
            }, {
                backgroundColor: '#DDD',
                borderWidth: 0,
                outerRadius: '105%',
                innerRadius: '103%'
            }]
        },
        // the value axis
        yAxis: {
            min: 0,
            max: 100,
            minorTickInterval: 'auto',
            minorTickWidth: 1,
            minorTickLength: 10,
            minorTickPosition: 'inside',
            minorTickColor: '#666',
            tickPixelInterval: 30,
            tickWidth: 2,
            tickPosition: 'inside',
            tickLength: 10,
            tickColor: '#666',
            labels: {
                step: 2,
                rotation: 'auto'
            },
            title: {
                text: ' '
            },
            plotBands: [{
                from: 0,
                to: 75,
                color: '#DF5353' // green

            }, {
                from: 75,
                to: 82,
                color: '#DDDF0D' // yellow
            }, {
                from: 82,
                to: 100,
                color: '#55BF3B' // red
            }]
        },
        series: [{
            name: 'temprature',
            data: [25],
            tooltip: {
                valueSuffix: ' 度'
            }
        }]
    } ,
        function (chart) {
            setInterval(function () {
                if(chart.series){
                    var value=chart.series[0].points[0];
                    $.ajax({
                        url: "../../getSys1TopValue",
                        type: "GET",
                        data:{subsystemId:3,parameterId:5},
                        // async:"false",
                        success: function (data) {
                            //  更新图表
                            console.log(data);
                            var valueArray=data.split(";");
                            var a=parseFloat(valueArray[0]);
                            console.log(a);
                            var a1=Math.floor(a* 100) / 100;
                            $("#temp3_1").html("&nbsp;&nbsp;&nbsp;"+a1+" ℃");
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
        });
    //TT502A
    $('#temp2_3').highcharts({
        chart: {
            type: 'gauge',
            plotBackgroundColor: null,
            plotBackgroundImage: null,
            plotBorderWidth: 0,
            plotShadow: false
        },
        title: {
            text: 'TT502A回水温度'
        },
        pane: {
            startAngle: -120,
            endAngle: 120,
            background: [{
                backgroundColor: {
                    linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                    stops: [
                        [0, '#FFF'],
                        [1, '#333']
                    ]
                },
                borderWidth: 0,
                outerRadius: '109%'
            }, {
                backgroundColor: {
                    linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                    stops: [
                        [0, '#333'],
                        [1, '#FFF']
                    ]
                },
                borderWidth: 1,
                outerRadius: '107%'
            }, {
                // default background
            }, {
                backgroundColor: '#DDD',
                borderWidth: 0,
                outerRadius: '105%',
                innerRadius: '103%'
            }]
        },
        // the value axis
        yAxis: {
            min: 0,
            max: 100,
            minorTickInterval: 'auto',
            minorTickWidth: 1,
            minorTickLength: 10,
            minorTickPosition: 'inside',
            minorTickColor: '#666',
            tickPixelInterval: 30,
            tickWidth: 2,
            tickPosition: 'inside',
            tickLength: 10,
            tickColor: '#666',
            labels: {
                step: 2,
                rotation: 'auto'
            },
            title: {
                text: ''
            },
            plotBands: [{
                from: 0,
                to: 70,
                color: '#55BF3B' // green
            }, {
                from: 70,
                to: 80,
                color: '#DDDF0D' // yellow
            }, {
                from: 80,
                to: 100,
                color: '#DF5353' // red
            }]
        },
        series: [{
            name: 'temprature',
            data: [0],
            tooltip: {
                valueSuffix: ' 度'
            }
        }]
    });
    $("#temp3_2").html("&nbsp;&nbsp;&nbsp;"+"未采集");
    //TT502B
    $('#temp3_3').highcharts({
        chart: {
            type: 'gauge',
            plotBackgroundColor: null,
            plotBackgroundImage: null,
            plotBorderWidth: 0,
            plotShadow: false
        },
        title: {
            text: 'TT502B回水温度'
        },
        pane: {
            startAngle: -120,
            endAngle: 120,
            background: [{
                backgroundColor: {
                    linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                    stops: [
                        [0, '#FFF'],
                        [1, '#333']
                    ]
                },
                borderWidth: 0,
                outerRadius: '109%'
            }, {
                backgroundColor: {
                    linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                    stops: [
                        [0, '#333'],
                        [1, '#FFF']
                    ]
                },
                borderWidth: 1,
                outerRadius: '107%'
            }, {
                // default background
            }, {
                backgroundColor: '#DDD',
                borderWidth: 0,
                outerRadius: '105%',
                innerRadius: '103%'
            }]
        },
        // the value axis
        yAxis: {
            min: 0,
            max: 3,
            minorTickInterval: 'auto',
            minorTickWidth: 1,
            minorTickLength: 10,
            minorTickPosition: 'inside',
            minorTickColor: '#666',
            tickPixelInterval: 30,
            tickWidth: 2,
            tickPosition: 'inside',
            tickLength: 10,
            tickColor: '#666',
            labels: {
                step: 2,
                rotation: 'auto'
            },
            title: {
                text: ''
            },
            plotBands: [{
                from: 0,
                to: 1,
                color: '#55BF3B' // green
            }, {
                from: 1,
                to: 2,
                color: '#DDDF0D' // yellow
            }, {
                from: 2,
                to: 3,
                color: '#DF5353' // red
            }]
        },
        series: [{
            name: 'temprature',
            data: [0],
            tooltip: {
                valueSuffix: ' 度'
            }
        }]
    });
    $("#temp3_33").html("&nbsp;&nbsp;&nbsp;"+"未采集");


    setInterval(function () {
            $.ajax({
                url: "../../getSys1TopValue",
                type: "GET",
                data:{subsystemId:3,parameterId:4},
                // async:"false",
                success: function (data) {
                    //  更新图表
                    console.log(data);
                    var valueArray=data.split(";");
                    var a=parseFloat(valueArray[0]);
                    console.log(a);
                    var a1=Math.floor(a* 1000) / 1000;
                    $("#liu_state3").val(a1+" t/h");

                }
            })
        },1000)
}
   );