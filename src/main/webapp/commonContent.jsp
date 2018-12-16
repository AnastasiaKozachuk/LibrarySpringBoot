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

    <title>Log in with your account</title>

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
        <form method="GET" action="${contextPath}/login" style="display: inline; width: 200px;">
            <button class="btn btn-view-all" type="submit">Log Out</button>
        </form>

        <form method="GET" action="${contextPath}/createNew" style="display: inline;width: 200px;">
            <button class="btn btn-view-all" type="submit">Create new</button>
        </form>
    </div>

    <div class="filters">

        <form method="GET" action="${contextPath}/filterContent" class="form-signin">

            <h2 style="text-align: center; padding-bottom: 10px; margin-top: 0px">Filtering the content</h2>
            <input name="author" type="text" class="form-control" placeholder="Enter author"
                   autofocus="true"/>
            <input name="headline" type="text" class="form-control" placeholder="Enter headline"/>

            <input name="date" type="date" class="form-control" placeholder="Pick up date"/>

            <select name="genre" style="margin-top: 10px; width: 200px; height: 40px;">
                <option value="0">Not selected</option>
                <c:forEach var="option" items="${options}">
                    <option value="${option.genreID}">${option.genreName}</option>
                </c:forEach>
            </select>

            <button class="btn btn-primary btn-block" type="submit">Filter</button>


        </form>

    </div>

    <c:forEach var="subList" items="${elements}">
        <div class="row">
            <div class="col-xs-12 panel-style">
                <div class="panel panel-default">
                    <div class="panel-heading" style="background-color:#abeabe">${subList.headline}</div>
                    <div class="panel-body">
                            ${subList.author}
                    </div>

                </div>

                <form method="GET" action="${contextPath}/showOne">
                    <input hidden type="text" name="contentID" value="${subList.contentID}">
                    <button type="submit" class="btn btn-default" style="background-color:#33bf71; color: #fff">Show
                        story
                    </button>
                </form>

            </div>
        </div>

    </c:forEach>
    <h3 style="text-align: center; padding-bottom: 10px; margin-top: 50px; color:green;">${notFound}</h3>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
