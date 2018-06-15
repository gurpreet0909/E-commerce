<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css/" />
<spring:url var="js" value="/resources/js/" />
<spring:url var="images" value="/resources/images/" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- bootstrap readable theme -->
<link href="${css}/bootstrap-theme-pulse.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">
</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->

		<div class="content">

			<div class="container">

				<div class="row">

					<div class="jumbotron">

						<h1>${errorTitle}</h1>
						<hr />
						<blockquote>${errordescription}</blockquote>
					</div>
				</div>

			</div>
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

	</div>
</body>

</html>