<%--
  Created by IntelliJ IDEA.
  User: yamin
  Date: 2018/7/8
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function(){
        $("#multipartFile").filebox({
            buttonText: "选择文件",
            buttonAlign: "right",
            required:true
        });

        $("#submitImportFile").linkbutton({
            onClick:function () {
                $("#importFileForm").form("submit",{
                    url:"${pageContext.request.contextPath}/user/importUser",
                    onSubmit:function(){
                        return $(this).form("validate");
                    },
                    success:function(){
                        $("#importBtnDialog").dialog("close");
                        $.messager.show({
                            title:"系统提示",
                            msg:"保存成功"
                        });
                        $("#queryAllUserTable").datagrid("load");
                    }
                })

            }
        })


    })

</script>
<form id="importFileForm" method="post" enctype="multipart/form-data">
    <input id="multipartFile" name="multipartFile">
    <a id="submitImportFile"></a>
</form></html>
