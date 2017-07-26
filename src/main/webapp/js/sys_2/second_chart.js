/**
 * Created by admin on 2017/2/27.
 */
$(function () {
    // alert(document.URL);
    // var url=document.URL;
    // var preUrl=url.split("?");
    // var temp=preUrl[1].split("=");
    // alert(temp[1]);
    $('#ele').highcharts({
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
            text: 'CT201回水电导'
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
    } ,
        //一秒请求一次
        function (chart) {
            setInterval(function () {
                if(chart.series){
                    var value=chart.series[0].points[0];
                    $.ajax({
                        url: "../../getSys1TopValue",
                        type: "GET",
                        data:{subsystemId:2,parameterId:7},
                        // async:"false",
                        success: function (data) {
                            //  更新图表
                            console.log(data);
                            var valueArray=data.split(";");
                            var a=parseFloat(valueArray[0]);
                            console.log(a);
                            var a1=Math.floor(a* 100) / 100;
                            $("#ele1").html("&nbsp;&nbsp;&nbsp;"+a1+" us");
                            value.update(a1, false);
                            chart.redraw();
                            //更新状态
                            // alert(valueArray[1]);
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

    //temp1
    $('#temp1').highcharts({
        chart: {
            type: 'gauge',
            plotBackgroundColor: null,
            plotBackgroundImage: null,
            plotBorderWidth: 0,
            plotShadow: false
        },
        title: {
            text: 'TT201储水罐温度'
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
            max: 50,
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
                to: 26.4,
                color: '#55BF3B' // green
            }, {
                from: 26.4,
                to: 40,
                color: '#DDDF0D' // yellow
            }, {
                from: 40,
                to: 50,
                color: '#DF5353' // red
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
                        data:{subsystemId:2,parameterId:5},
                        // async:"false",
                        success: function (data) {
                            //  更新图表
                            console.log(data);
                            var valueArray=data.split(";");
                            var a=parseFloat(valueArray[0]);
                            console.log(a);
                            var a1=Math.floor(a* 100) / 100;
                            $("#temp1_1").html("&nbsp;&nbsp;&nbsp;"+a1+" ℃");
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


    //temp2
    $('#temp2').highcharts({
        chart: {
            type: 'gauge',
            plotBackgroundColor: null,
            plotBackgroundImage: null,
            plotBorderWidth: 0,
            plotShadow: false
        },
        title: {
            text: 'TT202A回水温度'
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
            max: 50,
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
                to: 26.4,
                color: '#55BF3B' // green
            }, {
                from: 26.4,
                to: 40,
                color: '#DDDF0D' // yellow
            }, {
                from: 40,
                to: 50,
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
    $("#temp2_1").html("&nbsp;&nbsp;&nbsp;"+"未采集");

    setInterval(function () {
        $.ajax({
            url: "../../getSys1TopValue",
            type: "GET",
            data:{subsystemId:2,parameterId:4},
            // async:"false",
            success: function (data) {
                //  更新图表
                console.log(data);
                var valueArray=data.split(";");
                var a=parseFloat(valueArray[0]);
                console.log(a);
                var a1=Math.floor(a* 1000) / 1000;
                $("#liu_state2").val(a1+" t/h");

            }
        })
    },1000)
})

