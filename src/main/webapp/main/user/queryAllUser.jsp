<%--
  Created by IntelliJ IDEA.
  User: yamin
  Date: 2018/7/8
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#queryAllUserTable").datagrid({
            title:"查所有用户",
            width:1000,
            height:400,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            cache:false,
            toobar:"#userOpt",
            pagination:true,
            pageSize:2,
            pageList:[2,3,5,10,15],
            pageNumber:1,
            fitColumns:true,
            url:"${pageContext.request.contextPath}/user/queryAllUserSplit",
            columns:[[{field:'id', title:'编号',width:100,sortable:true},
                      {field:'photo',title:'头像路径',width:100,align:'right',sortable:true},
                      {field:'dharmaName',title:'法名',width:100,sortable:true},
                      {field:'name',title:'名字',width:100,align:'center'},
                      {field:'sex',title:'性别',width:80,sortable:true},
                      {field:'province',title:'省份',width:100,sortable:true},
                      {field:'city',title:'城市',width:100,sortable:true},
                      {field:'sign',title:'签名',width:150,align:'center'},
                      {field:'phoneNum',title:'手机号',width:200,sortable:true},
                      {field:'password',title:'密码',width:100,sortable:true},
                      {field:'createTime',title:'创建时间',width:150,sortable:true},
                      {field:'status',title:'状态',width:60,sortable:true}
                    ]],
            })
        //全部导出
        $("#exportAllBtn").linkbutton({
            onClick:function(){
                window.location.href ="${pageContext.request.contextPath}/user/allExportUser"
            }
        });

        $("#exportBtnDialog").dialog({
            title:"自定义导出",
            width:500,
            height:300,
            closed:true,
            modal:true,
            href:"${pageContext.request.contextPath}/main/user/userCombotree.jsp"
        });


        $("#downloadImportDialog").dialog({
            title:"自定义导出",
            width:500,
            height:300,
            closed:true,
            modal:true,
            href:"${pageContext.request.contextPath}/main/user/importCustmer.jsp"
        });


        $("#importBtnDialog").dialog({
            title:"导入",
            width:500,
            height:300,
            closed:true,
            modal:true,
            href:"${pageContext.request.contextPath}/main/user/importFile.jsp"
        })



        //自定义导出
        $("#exportBtn").linkbutton({
            onClick:function(){
                $("#exportBtnDialog").dialog("open");
            }
        });
        $("#downloadImportBtn").linkbutton({
            onClick:function(){
                $("#downloadImportDialog").dialog("open");
            }
        });
        $("#importBtn").linkbutton({
            onClick:function(){
                $("#importBtnDialog").dialog("open");
            }
        });
    })
</script>
<div id="userOpt">
    <a id="exportAllBtn">全部导出</a>
    <a id="exportBtn">自定义导出</a>
    <a id="downloadImportBtn">下载模板导入</a>
    <a id="importBtn">导入</a>
</div>

<div id="exportBtnDialog">
</div>

<div id="importBtnDialog">

</div>
<div id="downloadImportDialog">
</div>


<table id="queryAllUserTable">
</table>

