<%--
  Created by IntelliJ IDEA.
  User: yamin
  Date: 2018/7/6
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function(){
        $("#title").textbox({
            required:true
        });
        $("#score").textbox({
            required:true
        });
        $("#brodecast").textbox({
            required:true
        });
        $("#author").textbox({
            required:true
        });
        $("#description").textbox({
            required:true
        });
        $("#publicTime").datebox({
            editable:false,
            required:true
        });
        $("#file1").filebox({
            buttonText: "选择文件",
            buttonAlign: "right",
            required:true
        });
        $("#saveAlbumBtn").linkbutton({
            onClick:function(){
                $("#addAlbumForm").form("submit",{
                    url:"${pageContext.request.contextPath}/album/addAlbum",
                    onSubmit:function(){
                        return $(this).form("validate");
                    },
                    success:function(){
                        $("#addAlbumDialog").dialog("close");
                        $.messager.show({
                            title:"系统提示",
                            msg:"保存成功"
                        });
                        $("#queryAlbumTreegrid").datagrid("load");
                    }
                });
            }
        });
        $("#resetAlbumBtn").linkbutton({
            onClick:function(){
                document.getElementById("addAlbumForm").reset();
            }
        });

    })
</script>
<form id="addAlbumForm" method="post" enctype="multipart/form-data">
    标题：<input id="title" name="title"><br/>
    评分：<input id="score" name="score"><br/>
    播音：<input id="brodecast" name="brodecast"><br/>
    作者: <input id="author" name="author"><br/>
    描述: <input id="description" name="description"><br/>
    印刷时间:<input id="publicTime" name="publicTime"><br/>
    封面：<input id="file1" name="file1"><br/>
    状态：<select id="status" class="easyui-combobox" name="status" style="width:200px;">
            <option value="y">上架</option>
            <option value="n">未上架</option>
        </select><br/>
    <a id="saveAlbumBtn">提交</a>
    <a id="resetAlbumBtn">重置</a><br/>
</form>
