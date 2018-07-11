<%--
  Created by IntelliJ IDEA.
  User: yamin
  Date: 2018/7/6
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function(){
        $("#title").textbox({
            required:true
        });
        $("#file1").filebox({
            buttonText: "选择音频",
            buttonAlign: "right",
            required:true
        });
        $("#size").textbox({
            required:true
        });
        $("#length").textbox({
            required:true
        });

        $("#albumId").textbox({
            required:true
        });

        $("#saveChapterBtn").linkbutton({
            onClick:function(){
                alert(groubId);
                $("#addChapterForm").form("submit",{
                    url:"${pageContext.request.contextPath}/chapter/addChapter?id="+groubId,
                    onSubmit:function(){
                        return $(this).form("validate");
                    },
                    success:function(){
                        $("#addChapterDialog").dialog("close");
                        $.messager.show({
                            title:"系统提示",
                            msg:"保存成功"
                        });
                        $("#queryAlbumTreegrid").treegrid("load");
                    }
                });
            }
        });

        $("#resetChapterBtn").linkbutton({
            onClick:function(){
                document.getElementById("addChapterForm").reset();
            }
        });

    })
</script>
<form id="addChapterForm" method="post" enctype="multipart/form-data">
    标题：<input id="title" name="title"><br/>
    路径：<input id="file1" name="file1"><br/>
    大小：<input id="size" name="size"><br/>
    时长: <input id="length" name="length"><br/>
    <a id="saveChapterBtn">提交</a>
    <a id="resetChapterBtn">重置</a><br/>
</form>
