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

    <form:form method="POST" action="${contextPath}/registration" modelAttribute="accountForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="login">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="login" class="form-control" placeholder="Login"
                            autofocus="true"/>
                <form:errors path="login"/>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"/>
                <form:errors path="password"/>
            </div>
        </spring:bind>

        <spring:bind path="gender">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="gender" class="form-control" placeholder="Gender"/>
                <form:errors path="gender"/>
            </div>
        </spring:bind>

        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstName" class="form-control" placeholder="First Name"/>
                <form:errors path="firstName"/>
            </div>
        </spring:bind>

        <spring:bind path="secondName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="secondName" class="form-control" placeholder="Second Name"/>
                <form:errors path="secondName"/>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="lastName" class="form-control" placeholder="Last Name"/>
                <form:errors path="lastName"/>
            </div>
        </spring:bind>

        <spring:bind path="age">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="age" class="form-control" placeholder="Age"/>
                <form:errors path="age"/>
            </div>
        </spring:bind>

        <spring:bind path="phoneNumber">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="phoneNumber" class="form-control" placeholder="Phone number"/>
                <form:errors path="phoneNumber"/>
            </div>
        </spring:bind>


        <spring:bind path="city">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="city" class="form-control" placeholder="City"/>
                <form:errors path="city"/>
            </div>
        </spring:bind>

        <spring:bind path="region">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="region" class="form-control" placeholder="Region"/>
                <form:errors path="region"/>
            </div>
        </spring:bind>


        <spring:bind path="country">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="country" class="form-control" placeholder="Country"/>
                <form:errors path="country"/>
            </div>
        </spring:bind>
        <span class="${error != null ? 'has-error' : ''}">${error}</span>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
