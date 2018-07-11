<%--
  Created by IntelliJ IDEA.
  User: yamin
  Date: 2018/7/9
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>



<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById("statisticsMain"));

    $.get("${pageContext.request.contextPath}/statistics/activeUser",function(data){
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '持名法州App活跃用户'
            },
            tooltip: {},
            legend: {
                data:['用户数量']
            },
            xAxis: {
                data: data.intervals
            },
            yAxis: {},
            series: [{
                name: '数量',
                type: 'bar',
                data: data.count
            }]
        };
        myChart.setOption(option);
    },"json");




    /*
     Map<String,Object> map = new HashMap<String,Object>();
     map.put("intervals",new String[]{"7天","15天"});
     map.put("counts",new int[]{5,10});'
     return map;

     [{"intervals":["7天","15天"]},{}]
     */
    // 异步加载统计信息
   /* $.post("/statistics/activeUser",function(data){
        console.log(data);
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption({
            xAxis: {
                data: data
            },
            series: [{
                // 根据名字对应到相应的系列
                name: '活跃用户',
                data: data.counts
            }]
        });
    },"json");*/
</script>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="statisticsMain" style="width: 600px;height: 400px;;margin-top: 30px;margin-left: 30px"></div>