<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title>Insert title here</title>
	</head>
	<body>
		<form name="form1" action="login.do" method="post">

			<table width="300" border="1">

				<tr>

					<td colspan="2">
						登录窗口
					</td>

				</tr>

				<tr>

					<td>
						用户名td>
					<td>
						<input type="text" name="username" size="10">
					</td>

				</tr>

				<tr>

					<td>
						密码
					</td>

					<td>
						<input type="password" name="password" size="10">
					</td>

				</tr>

				<tr>

					<td colspan="2">
						<input type="submit" name="submit" value="登录">
						<a href="register.do?method=init">注册新用户</a>
					</td>

				</tr>

			</table>

		</form>
	</body>
</html>