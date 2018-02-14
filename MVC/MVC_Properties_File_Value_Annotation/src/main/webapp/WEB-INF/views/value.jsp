<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Properties File Value Annotation</title>
</head>
<body>

	<br />
	<h2>Database details are following -</h2>
	<br />
	<table style="spa">
		<tbody>
			<tr>
				<td>Driver Class Name</td>
				<td>${driverClassName}</td>
			</tr>
			<tr>
				<td>Database URL</td>
				<td>${url}</td>
			</tr>
			<tr>
				<td>Database Username</td>
				<td>${username}</td>
			</tr>
			<tr>
				<td>Database Password</td>
				<td>${password}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>