<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css"></link>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/common.js"></script>
	<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/func.js"></script>--%>
	<script type="text/javascript">
		$(function(){
		    /*alert($("#name"));*/
			/*$("#name").textbox({
				required:true
			})*/

			/*$("#password").textbox({
                required:true,
                /!*validType:"checkLength[6]"*!/
            });

            $("#vrifyCode").textbox({
                required:true,
               /!* validType:"checkLength[4]"*!/
            });*/
		});
	</script>
</head>
<body>
		<div class="login">
			<form id="loginForm" action="${pageContext.request.contextPath}/admin/login" method="post" >
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="${pageContext.request.contextPath}/img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input id="name" class="easyui-textbox" data-options="required:true" type="text"  name="name" class="text" value="xxx" maxlength="20"/>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input id="password" type="password" name="password" class="text" value="xxx" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>

						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<h1 th:text="${info}" />
								<div>
									<img alt="点击更换验证码" onclick = "this.src='${pageContext.request.contextPath}/admin/defaultKaptcha?d='+new Date()*1" src="${pageContext.request.contextPath}/admin/defaultKaptcha" />
								</div>
								<input id="vrifyCode" type="text" name="vrifyCode"/>

							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>