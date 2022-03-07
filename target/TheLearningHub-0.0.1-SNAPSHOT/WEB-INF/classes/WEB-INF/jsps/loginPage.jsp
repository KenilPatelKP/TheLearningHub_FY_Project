<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"--%>
<%--         pageEncoding="ISO-8859-1"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>

<%--<html>--%>

<%--<head>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link href="${pageContext.request.contextPath}/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<%--    <link href="${pageContext.request.contextPath}/css/defaultStyles.css" rel="stylesheet" type="text/css">--%>
<%--</head>--%>

<%--<body class="">--%>
<%--<div class="cover">--%>
<%--    <div class="cover-image" style="background-image : url('${pageContext.request.contextPath}/images/wood-texture.jpg')"></div>--%>
<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-11 text-center">--%>
<%--                <h1 class="mainheader">--%>
<%--                    <a href="#" class="logo"><i class="fa fa-graduation-cap text-muted text-info"></i></a>Lernado</h1>--%>
<%--                <p>Best e-learning portal EVER!</p>--%>
<%--                <form class="form-horizontal" role="form" action="/login" method="post">--%>
<%--                    <div class="form-group text-right">--%>
<%--                        <div class="col-sm-3">--%>
<%--                            <label for="username" class="control-label">Email</label>--%>
<%--                        </div>--%>
<%--                        <div class="col-sm-8">--%>
<%--                            <c:if test="${wrongCredentials==true}"><div class="errorMessage">Email or password are wrong</div></c:if>--%>
<%--                            <input type="email" class="form-control" name="username" id="username" placeholder="Email"--%>
<%--                                   style="max-width: 550px">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-3 text-right">--%>
<%--                            <label for="password" class="control-label">Password</label>--%>
<%--                        </div>--%>
<%--                        <div class="col-sm-8">--%>
<%--                            <input type="password" class="form-control" name="password" id="password" placeholder="Password"--%>
<%--                                   style="max-width: 550px">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-offset-7 col-sm-3">--%>
<%--                            <button type="submit" class="btn btn-default btn-lg">Log In</button>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--                <h3 class="text-center">Doesn't have account?--%>
<%--                    <b>--%>
<%--                        <a class="signUp" href="/signUp">Sign Up!</a>--%>
<%--                    </b>--%>
<%--                </h3>--%>
<%--                <br>--%>
<%--                <br>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<jsp:include page="common/footer.jsp"></jsp:include>--%>
<%--</body>--%>

<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@include file="common/header.jsp" %>
<section class="u-clearfix u-gradient u-section-1" id="sec-fdd2">
    <div class="u-clearfix u-sheet u-sheet-1">
        <h1 class="u-text u-text-default u-text-1">Log In</h1>
        <div class="u-form u-login-control u-form-1">
            <form action="/login" role="form" method="post"  class="u-clearfix u-form-custom-backend u-form-spacing-10 u-form-vertical u-inner-form" source="custom" name="form" style="padding: 10px;">
                                            <c:if test="${wrongCredentials==true}"><div class="errorMessage">Email or password are wrong</div></c:if>
                <div class="u-form-group u-form-name">

                    <label for="username-a30d" class="u-label">Username *</label>
                    <input type="text" placeholder="Enter your Username" id="username-a30d" name="username" class="u-border-grey-30 u-input u-input-rectangle u-input-1" required="">
                </div>
                <div class="u-form-group u-form-password">
                    <label for="password-a30d" class="u-label">Password *</label>
                    <input type="password" placeholder="Enter your Password" id="password-a30d" name="password" class="u-border-grey-30 u-input u-input-rectangle u-input-2" required="">
                </div>
<%--                <div class="u-form-checkbox u-form-group">--%>
<%--                    <input type="checkbox" id="checkbox-a30d" name="remember" value="On">--%>
<%--                    <label for="checkbox-a30d" class="u-label">Remember me</label>--%>
<%--                </div>--%>
                <div class="u-align-center u-form-group u-form-submit">
                    <a href="#" class="u-border-2 u-border-grey-75 u-btn u-btn-round u-btn-submit u-button-style u-hover-palette-2-light-1 u-none u-radius-50 u-btn-1">Sign in</a>
                    <input type="submit" value="submit" class="u-form-control-hidden">
                </div>
                <input type="hidden" value="" name="recaptchaResponse">
            </form>
        </div>
        <a href="#" class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-login-control u-login-forgot-password u-none u-text-palette-1-base u-btn-2">Forgot password?</a>
        <a href="/signUp" class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-login-control u-login-create-account u-none u-text-palette-1-base u-btn-3" target="_blank">Don't have an account?</a>
    </div>
</section>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Login.css" media="screen">
<%@include file="common/footer.jsp" %>
