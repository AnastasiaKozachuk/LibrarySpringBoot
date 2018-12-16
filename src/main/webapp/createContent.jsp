<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <div style="text-align: right; margin-bottom: 15px;">
        <form method="GET" action="${contextPath}/viewAll" style="display: inline; width: 200px;">
            <button class="btn btn-view-all" type="submit">Back</button>
        </form>
    </div>

    <form:form method="POST" action="${contextPath}/createNew" modelAttribute="contentForm" class="form-signin">
        <h2 class="form-signin-heading">Create your own story</h2>

        <spring:bind path="headline">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="headline" class="form-control" placeholder="Type your headline"
                            autofocus="true"/>
                <form:errors path="headline"/>
            </div>
        </spring:bind>

        <spring:bind path="text">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:textarea type="text" path="text" class="form-control" placeholder="Tell your story"
                               autofocus="true" style="height:400px;resize:none"/>
                <form:errors path="text"/>
            </div>
        </spring:bind>

        <form:select multiple="multiple" path="genres">
            <form:options items="${options}"/>
        </form:select>

        <spring:bind path="author">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="author" class="form-control" placeholder="Sign you as author"
                            autofocus="true"/>
                <form:errors path="author"/>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
