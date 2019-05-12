<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Evergreen books - admin</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />


	<div id="main" align="center">
		<h3>Some admin stuff goes here</h3>
	</div>

	<div id="quick_actions" align="center">
		<hr width="60%" />
		<h3>Quick actions</h3>
		<b> <a href="create_user">New User</a> &nbsp; <a
			href="create_book">New Book</a> &nbsp; <a href="create_category">New
				Category</a> &nbsp; <a href="create_customer">New Customer</a>
		</b>
	</div>

	<div id="recent_sales" align="center">
		<hr width="60%" />
		<h3>Recent Sales</h3>
	</div>

	<div id="recent_reviews" align="center">
		<hr width="60%" />
		<h3>Recent Reviews</h3>
	</div>

	<div id="statistics" align="center">
		<hr width="60%" />
		<h3>Statistics</h3>
		<hr width="60%" />
	</div>

	<jsp:directive.include file="footer.jsp" />
</body>
</html>