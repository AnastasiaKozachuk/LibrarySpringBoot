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

<div class="container" style="text-align: center">

    <div class="row">

        <div class="col-xs-12">
            <div class="panel panel-default">

                <div class="panel-heading" style="background-color:#abeabe"> ${content.headline}</div>
                <div class="panel-body">
                    ${content.text}
                </div>
                <div class="panel-footer" style="background-color:#abeabe"> ${content.date}</div>
                <div class="panel-footer" style="background-color:#33bf71; color: #fff">  ${content.author}</div>
            </div>
        </div>

    </div>

    <div class="row">
        <div class="col-xs-12 ">
            <div class="panel panel-default">
                <div class="panel-heading" style="background-color:#abeabe">Genres</div>
    <c:forEach var="genre" items="${content.genres}">
                    <div class="panel-body">
                            ${genre.genreName}
                    </div>
    </c:forEach>
            </div>
        </div>
    </div>

    <form:form  method="POST" action="${contextPath}/addReview" modelAttribute="reviewForm" >

        <div style="margin-top: 15px;">

            <h2>Put your assessment</h2>

            <div class="row" style="margin-bottom: 15px;">

                <div class="col-xs-12">
                    1<form:radiobutton path="mark" value="1" checked="checked" style="margin: 15px;"/>
                    2<form:radiobutton path="mark" value="2" style="margin: 15px;"/>
                    3<form:radiobutton path="mark" value="3" style="margin: 15px;"/>
                    4<form:radiobutton path="mark" value="4" style="margin: 15px;"/>
                    5<form:radiobutton path="mark" value="5" style="margin: 15px;"/>
                </div>


            </div>

            <div class="row" >
                <div class="col-xs-12">
                    <spring:bind path="reviewText">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <form:textarea type="text" path="reviewText" class="form-control" placeholder="Review text"
                                           autofocus="true" style="height:150px;resize:none"/>
                            <form:errors path="reviewText"/>
                        </div>
                    </spring:bind>
                </div>
            </div>

            <form:input type="hidden" path="content" class="form-control" value="${content}"/>
            <div class="row" >

                <div class="col-xs-12">
                    <button type="submit" class="btn btn-default" style="background-color:#33bf71; color: #fff">Add review</button>
                </div>


            </div>


        </div>



    </form:form>





</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
