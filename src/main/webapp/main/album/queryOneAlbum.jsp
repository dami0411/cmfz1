<%--
  Created by IntelliJ IDEA.
  User: yamin
  Date: 2018/7/6
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function(){
        console.log(groubQueryOne)
        var d = $("#queryAlbumTreegrid").treegrid("getParent",groubQueryOne);
        console.log(d);
       // $("#myImg").prop("src","${pageContext.request.contextPath}/"+d.coverImg);
        //$("#myDescription").text(d.description);
    })
</script>
<div id="queryOneAlbumForm" align="center">
    <img src="" id="myImg" width="300" height="200"><br/>
    <div id="myDescription">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
</div>
