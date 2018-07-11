<%--
  Created by IntelliJ IDEA.
  User: yamin
  Date: 2018/7/5
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function(){
        var editRow = undefined;
        $("#queryAllTable").edatagrid({
            title:"查所有",
            width:800,
            height:400,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            cache:false,
            toobar:"#opts",
            pagination:true,
            pageSize:2,
            pageList:[2,5,10,15,20],
            pageNumber:1,
            fitColumns:true,
            updateUrl:"${pageContext.request.contextPath}/banner/changeBanner",
            onLoadSuccess:function(){
                $.parser.parse($("a[name=optBtn]").parent());
            },
            url:"${pageContext.request.contextPath}/banner/queryAllBannerSplit",
            columns:[[{field:'id', title:'id',width:300,sortable:true},
                {field:'picName',title:'图片名字',width:300,align:'right',sortable:true,
                    editor:{
                        type:"text" ,
                        options:{
                            required:true ,
                            missingMessage:'图片名字必填!'
                        }
                    }
                },
                {field:'picPath',title:'图片路径',width:80,align:'right',sortable:true},
                {field:'description',title:'图片描述',width:150,sortable:true,
                    editor:{
                        type:"text",
                        options:{
                            required:true ,
                            missingMessage:'图片描述必填!'
                        }
                    }
                },
                {field:'status',title:'图片状态',width:60,align:'center',
                    editor:{
                        type:"text",
                        options:{
                            required:true ,
                            missingMessage:'图片状态必填!'
                        }
                    }
                },
                {field:'createTime',title:'创建时间',width:150,sortable:true,
                    editor:{
                        type:"text",
                        options:{
                            required:true ,
                            missingMessage:'创建时间必填!'
                        }
                    }
                },
                {field:'url',title:'跳转路径',width:150,sortable:true,
                    editor:{
                        type:"text",
                        options:{
                            required:true ,
                            missingMessage:'跳转路径必填!'
                        }
                    }
                },
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr><td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.picName+'"  style="height:150px;"></td>' +
                '<td style="border:0">' +
                    '<p>图片名字: ' + rowData.picName + '</p>' +
                    '<p>图片路径: ' + rowData.picPath + '</p>' +
                    '<p>图片描述: ' + rowData.description + '</p>' +
                    '<p>图片状态: ' + rowData.status + '</p>' +
                    '<p>创建时间: ' + rowData.createTime + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },

        })

        //初始化添加按钮
        $("#addBannerBtn").linkbutton({
            iconCls:"icon-application_add",
            onClick:function(){
                $("#addBannerDialog").dialog("open");
            }

        });
        //初始化修改按钮
        $("#changeBannerBtn").linkbutton({
            iconCls:"icon-application_edit",
            onClick:function(){
                var mySelect = $("#queryAllTable").datagrid("getSelected");
                if(mySelect!=null){
                    var index = $("#queryAllTable").edatagrid("getRowIndex",mySelect);
                    $("#queryAllTable").edatagrid("editRow",index);
                }else{
                    $.messager.alert('我的消息','请选择一个！','info');
                }
            }
        });
        //初始化删除按钮
        $("#removeBannerBtn").linkbutton({
            iconCls:"icon-application_delete",
            onClick:function(){
                var mySelect = $("#queryAllTable").datagrid("getSelected");
                if(mySelect!=null){
                    $.get("${pageContext.request.contextPath}/banner/removeBanner/"+mySelect.id,function(){
                        $("#queryAllTable").edatagrid("load");
                    });
                }else{
                    $.messager.alert('我的消息','请选择一个！','info');
                }
            }

        });
        //初始化保存按钮
        $("#saveBannerBtn").linkbutton({
            iconCls:"icon-award_star_silver_3",
            onClick : function() {
                $('#queryAllTable').edatagrid("saveRow");
                $('#queryAllTable').datagrid("load");
            }
        })

        //初始化添加dialog
        $("#addBannerDialog").dialog({
            title:"添加轮播图",
            width:500,
            height:300,
            closed:true,
            modal:true,
            href:"${pageContext.request.contextPath}/main/banner/addBanner.jsp"
        })
    })
</script>
<div id="opts">
    <a id="addBannerBtn">添加</a>
    <a id="changeBannerBtn">修改</a>
    <a id="removeBannerBtn">删除</a>
    <a id="saveBannerBtn">保存</a>
</div>
<div id="addBannerDialog"></div>
<table id="queryAllTable">
</table>
