<%--
  Created by IntelliJ IDEA.
  User: yamin
  Date: 2018/7/6
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    var groubId = "";
    var groubQueryOne;
    $(function(){
        $('#queryAlbumTreegrid').treegrid({
            url:"${pageContext.request.contextPath}/album/queryAllAlbumSplit",
            idField:'id',
            treeField:'title',
            fitColumns:true,
            toolbar:"#albumOpt",
            pagination:true,
            pageSize:2,
            pageList:[2,5,10,15,20],
            pageNumber:1,
            onDblClickRow:function(row){
               var mySelect = $("#queryAlbumTreegrid").datagrid("getSelected");
               var bb = $("#queryAlbumTreegrid").treegrid("getLevel",mySelect.id);
                if(bb==2){
                    var a = $("<video id='videoOpen' width='500px'><source src='${pageContext.request.contextPath}"+row.url+"' type='video/mp4' id='mySource'></video>");
                    $("#d1").append(a);
                    var oVideo = $("#videoOpen");
                    oVideo.load();
                    document.getElementById("videoOpen").play();
                    $.get("${pageContext.request.contextPath}/chapter/changeTimes?id="+row.id);
                }else{
                    $.messager.alert('我的消息','请选择章节所在行！','info');
                }

            },
            columns:[[
                //{field:'id',title:'编号',width:60},
                {field:'title',title:'标题',width:60},
                {field:'size',title:'大小',width:40},
                {field:'url',title:'路径',width:120},
                {field:'times',title:'播放次数',width:40},
                {field:'createTime',title:'时间',width:80}
            ]],
        });

        $("#albumDetailDialog").dialog({
            title:"查看专辑",
            width:500,
            height:300,
            closed:true,
            cache:false,
            modal:true,
        })

        $("#albumDetail").linkbutton({

            onClick:function(){
                var mySelect = $("#queryAlbumTreegrid").datagrid("getSelected");
                if(mySelect==null){
                    $.messager.alert('我的消息','请选择一个专辑节点！','info');
                }else{
                    var d = $("#queryAlbumTreegrid").treegrid("getLevel",mySelect.id);
                    if(d==1){
                        $("#albumDetailDialog").dialog("open");
                        $("#albumDetailTable").empty();
                        var queryOne = $("<tr><td>作者:  </td><td>"+mySelect.author+"</td></tr><tr><td>播音:  </td><td>"+mySelect.brodecast+"</td></tr><tr><td>描述:  </td><td>"+mySelect.description+"</td></tr><tr><td>封面:  </td><td><img src='${pageContext.request.contextPath}/"+mySelect.coverImg+"' width='100' height='150'></td></tr>")
                        $("#albumDetailTable").append(queryOne);
                    }else{
                        $.messager.alert('我的消息','请选择专辑节点！','info');
                    }
                }


                //console.log(mySelect);
            }
        });
        //初始化添加专辑按钮
        $("#addAlbumDialog").dialog({
            title:"添加专辑",
            width:500,
            height:300,
            closed:true,
            cache:false,
            modal:true,
            href:"${pageContext.request.contextPath}/main/album/addAlbum.jsp"
        })

        //初始化添加章节按钮
        $("#addChapterDialog").dialog({
            title:"添加章节",
            width:500,
            height:300,
            closed:true,
            cache:false,
            modal:true,
            href:"${pageContext.request.contextPath}/main/album/addChapter.jsp"
        })

        $("#addAlbum").linkbutton({
            onClick:function(){
                $("#addAlbumDialog").dialog("open");
            }
        });
        $("#addChapter").linkbutton({

            onClick:function(){
                var mySelect = $("#queryAlbumTreegrid").datagrid("getSelected");
                if(mySelect==null){
                    $.messager.alert('我的消息','请选择一个专辑节点！','info');
                }else {
                    var level = $("#queryAlbumTreegrid").treegrid("getLevel", mySelect.id);
                    if (level == 1){
                        $("#addChapterDialog").dialog("open");
                        groubId = mySelect.id;
                    } else {
                        $.messager.alert('我的消息', '请选择你要添加的专辑！', 'info');
                    }
                }
            }
        });


        $("#downloadAudio").linkbutton({
            onClick:function(){
                var mySelect = $("#queryAlbumTreegrid").datagrid("getSelected");
                var ddd = $("#queryAlbumTreegrid").treegrid("getLevel",mySelect.id);
                if(ddd==2){
                    window.location.href="${pageContext.request.contextPath}/chapter/download?url="+mySelect.url;
                }else{
                    $.messager.alert('我的消息','请选择你要下载的章节！','info');
                }
            }
        })
        $("#end").linkbutton({
            onClick:function(){
                var oEnd = document.getElementById('end');
                document.getElementById("videoOpen").pause();
                document.getElementById("videoOpen").currentTime=0;

            }
        })
        $("#pause").linkbutton({
            onClick:function(){
                var oPause = $("#pause");
                if(oPause.text("暂停")){
                    document.getElementById("videoOpen").pause();
                    oPause.text("播放");
                }else{
                    document.getElementById("videoOpen").play();
                    oPause.text("暂停");
                }
            }
        })

        $("#close").linkbutton({
            onClick:function(){
               // $("#d1").prop("style","display:none")
                $("#d1").empty();
                $("#queryAlbumTreegrid").datagrid("load");
            }
        })



    })

</script>
<div id="albumOpt">
    <a id="albumDetail">专辑详情</a>
    <a id="addAlbum">添加专辑</a>
    <a id="addChapter">添加章节</a>
    <a id="downloadAudio">下载音频</a>
    <a id="end">停止</a>
    <a id="pause">暂停</a>
    <a id="close">关闭</a>
</div>
<div id="albumDetailDialog">
    <table id="albumDetailTable">

    </table>
</div>
<div id="addAlbumDialog"></div>
<div id="addChapterDialog"></div>
<div id="d1" style="display: block"></div>
<table id="queryAlbumTreegrid" style="width:1000px;height:500px">

</table>