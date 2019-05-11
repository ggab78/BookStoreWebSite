<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />

	<div id="main" align="center">
		<h2>Please login:</h2>
		<form>
			<label>Email:<input type="text" size="10"><br/></label>
			<label>Password:<input
				type="password" size="10" /><br/></label>
				<label><input type="submit"
				value="Login"></label>
		</form>
	</div>
<jsp:directive.include file="footer.jsp" />

</body>
</html>