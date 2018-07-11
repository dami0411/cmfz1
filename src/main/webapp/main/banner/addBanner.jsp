<%--
  Created by IntelliJ IDEA.
  User: yamin
  Date: 2018/7/5
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function(){
        $("#picName").textbox({
            required:true,
        });
        $("#picPath").textbox({
            required:true,
        });
        $("#description").textbox({
            required:true,
        });
        $("#createTime").datebox({
            editable:false,
            required:true
        });
        $("#url").textbox({
            required:true,
        });
        $("#saveBannerFormBtn").linkbutton({
            onClick:function(){
                $("#addBannerForm").form("submit",{
                    url:"${pageContext.request.contextPath}/banner/addBanner",
                    onSubmit:function(){
                        return $(this).form("validate");
                    },
                    success:function(){
                        $("#addBannerDialog").dialog("close");
                        $.messager.show({
                            title:"系统提示",
                            msg:"保存成功"
                        });
                        $("#queryAllTable").datagrid("load");
                    }
                })
            }
        });
        $("#resetBannerFormBtn").linkbutton({
            onClick:function(){
                document.getElementById("addBannerForm").reset();
            }
        });
    })

</script>

<form id="addBannerForm" method="post" enctype="multipart/form-data">
    <%--图片名字：<input id="picName" name="picName"><br/>
    图片路径： <input id="picPath" name="picPath"><br/>--%>
    图片：<input id="file1" name="file1" type="file"><br/>
    图片描述：<input id="description" name="description"><br/>
    图片状态：<select id="status" class="easyui-combobox" name="status" style="width:200px;">
                <option value="y">上架</option>
                <option value="n">未上架</option>
             </select><br/>
    创建时间：<input id="createTime" name="createTime"><br/>
    图片路径：<input id="url" name="url"><br/>
        <a id="saveBannerFormBtn">提交</a>
        <a id="resetBannerFormBtn">重置</a>
</form>