<%--
  Created by IntelliJ IDEA.
  User: yamin
  Date: 2018/7/9
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function(){
        $("#importSubmitBtn").linkbutton({
            onClick:function(){
                var texts = $("#myImportCombotree").combotree("getText");
                var fileds = $("#myImportCombotree").combotree("getValues");
                var values="";
                $.each(fileds,function(index,filed){
                    if(index==fileds.length-1){
                        values +=filed;
                    }else{
                        values +=filed+",";
                    }
                })
                $("#importCombotreeForm").form("submit",{
                    url:"${pageContext.request.contextPath}/user/userImport",
                    queryParams:{
                        "titles":texts,
                        "fileds":values
                    }
                })

            }
        })
    })

</script>
<select id="myImportCombotree" class="easyui-combotree" style="width:200px;"
        data-options="required:true,multiple:true,data:
            [{
             'id':'custom',
             'text':'自定义导出',
             'state':'closed',
             'children':[{
                    'id':'id',
                    'text':'编号'
                },{
                    'id':'photo',
                    'text':'头像'
                },{
                    'id':'dharmaName',
                    'text':'法名'
                },{
                    'id':'name',
                    'text':'名字'
                },{
                    'id':'sex',
                    'text':'性别'
                },{
                    'id':'province',
                    'text':'省份'
                },{
                    'id':'city',
                    'text':'城市'
                },{
                    'id':'sign',
                    'text':'标签'
                },{
                    'id':'phoneNum',
                    'text':'手机号'
                },{
                    'id':'password',
                    'text':'密码'
                },{
                    'id':'salt',
                    'text':'盐'
                },{
                    'id':'createTime',
                    'text':'创建时间'
                },{
                    'id':'status',
                    'text':'状态'
                }]
            }]"
></select>
<form id="importCombotreeForm">
    <a id="importSubmitBtn">提交</a>
</form>