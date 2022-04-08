<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"--%>
<%--         pageEncoding="ISO-8859-1"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>--%>
<%--<html>--%>

<%--<head>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link href="${pageContext.request.contextPath}/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
<%--    <link href="${pageContext.request.contextPath}/css/defaultStyles.css" rel="stylesheet" type="text/css">--%>
<%--    <script type="text/javascript" src="${pageContext.request.contextPath}/js/SignUp.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="cover" id="home">--%>
<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-12 text-center">--%>
<%--                <div class="col-md-11 text-center">--%>
<%--                    <h1 class="mainheader">--%>
<%--                        <a href="#" class="logo"><i class="fa fa-graduation-cap text-muted text-info"></i></a>Lernado</h1>--%>
<%--                    <p>Best e-learning portal EVER!</p>--%>
<%--                </div>--%>
<%--                <form:form class="form-horizontal text-right" role="form" action="/user/create" method="POST" modelAttribute="previousUser" onsubmit="return validateForm()">--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-3">--%>
<%--                            <label for="firstName" class="control-label">First name</label>--%>
<%--                        </div>--%>
<%--                        <div class="col-sm-8">--%>
<%--                            <form:input type="text" class="form-control input-sm" id="firstName" name="firstName" placeholder="First name"--%>
<%--                                   required="" style="max-width: 550px" path="firstName"/>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-3">--%>
<%--                            <label for="lastName" class="control-label">Last name</label>--%>
<%--                        </div>--%>
<%--                        <div class="col-sm-8">--%>
<%--                            <form:input type="text" class="form-control input-sm" id="lastName" name="lastName" placeholder="Last name"--%>
<%--                                   required="" style="max-width: 550px" path="lastName"/>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-3">--%>
<%--                            <label for="email" class="control-label">Email</label>--%>
<%--                        </div>--%>
<%--                        <div class="col-sm-8">--%>
<%--                            <c:if test="${emailInUse==true}"><div class="errorMessage">This email is already in use :(</div></c:if>--%>
<%--                            <form:input type="email" class="form-control" id="email" name="email" placeholder="Email"--%>
<%--                                   required="" style="max-width: 550px" path="email"/>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-3">--%>
<%--                            <label for="password" class="control-label">Password</label>--%>
<%--                        </div>--%>
<%--                        <div class="col-sm-8">--%>
<%--                            <input type="password" class="form-control input-sm" id="password" name="password"--%>
<%--                                   placeholder="Password" required="" style="max-width: 550px">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-3">--%>
<%--                            <label for="password2" class="control-label">Repeat password</label>--%>
<%--                        </div>--%>
<%--                        <div class="col-sm-8">--%>
<%--                            <input type="password" class="form-control input-sm" id="password2" name="password2"--%>
<%--                                   placeholder="Repeat password" required="" onkeyup="checkPass(); return false;"--%>
<%--                                   style="max-width: 550px">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-offset-2 col-sm-10">--%>
<%--                            <div class="checkbox left" style="float:left">--%>
<%--                                <label class="checkbox">--%>
<%--                                    <input type="checkbox" required="">I have read and agree to the Terms and Conditions and Privacy Policy.</label>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <div class="col-sm-offset-4 col-sm-5">--%>
<%--                            <button id="submitButton" type="submit" class="btn btn-default btn-md">Sign Up</button>--%>
<%--                            <button type="reset" class="btn btn-default btn-md">Clear form</button>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </form:form>--%>
<%--                <br>--%>
<%--                <br>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<jsp:include page="common/footer.jsp"></jsp:include>--%>
<%--</body>--%>

<%--</html>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="common/header.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/SignUp.js"></script>
<section class="u-clearfix u-gradient u-section-1" id="sec-fdd2">
    <div class="u-clearfix u-sheet u-sheet-1">
        <h1 class="u-text u-text-default u-text-1">Sign Up</h1>
        <div class="u-form u-form-1">
            <sform:form role="form" action="/user/create" method="POST" modelAttribute="previousUser" class="u-clearfix u-form-spacing-10 u-form-vertical u-inner-form" style="padding: 10px;">
                <%--                onsubmit="return validateForm()"--%>
                <div class="u-form-group u-form-name">
                    <label for="firstName" class="u-label">First Name</label>
                    <sform:input type="text" cssClass="form-control input-sm" id="firstName" name="firstName" placeholder="First name"
                                 required="" style="max-width: 550px" path="firstName"/>
                </div>
                <div class="u-form-group">
                    <label for="lastName" class="u-label">Last Name</label>
                    <sform:input type="text" cssClass="form-control input-sm" id="lastName" name="lastName" placeholder="Last name" required="" style="max-width: 550px" path="lastName"/>
                </div>
                <div class="u-form-email u-form-group u-form-group-3">
                    <label for="email" class="u-label">Email</label>
                    <c:if test="${emailInUse==true}"><div class="errorMessage">This email is already in use :(</div></c:if>
                    <sform:input type="email" cssClass="form-control" id="email" name="email" placeholder="Email"
                                 required="" style="max-width: 550px" path="email"/>
                </div>
                <div class="u-form-group u-form-group-4">
                    <label for="password" class="u-label">Password</label>
                    <input type="password" class="form-control input-sm" id="password" name="password"
                           placeholder="Password" required="" style="max-width: 550px">

                </div>
                <div class="u-form-group u-form-group-5">
                    <label for="password2" class="u-label">Retype Password</label>
                    <input type="password" class="form-control input-sm" id="password2" name="password2"
                           placeholder="Repeat password" required="" onkeyup="checkPass(); return false;"
                           style="max-width: 550px">

                </div>
                <div class="u-form-group u-form-checkbox u-form-group-6">
                        <%--                    <label for="" class="u-label">Phone Number</label>--%>
                    <input type="checkbox" required="">I have read and agree to the Terms and Conditions and Privacy Policy.</label>
                </div>
                <div class="u-align-left u-form-group u-form-submit">
                    <button id="submitButton" type="submit" class="u-border-2 u-border-black u-btn u-btn-round u-btn-submit u-button-style u-hover-palette-2-light-1 u-none u-radius-50 u-text-black u-text-hover-white u-btn-1">Sign Up</button>
                    <button type="reset" class="btn btn-default btn-md">Clear form</button>

                </div>
                <div class="u-form-send-message u-form-send-success"> Thank you! Your message has been sent. </div>
                <%--<div class="u-form-send-error u-form-send-message"> Unable to send your message. Please fix errors then try again. </div>--%>
                <input type="hidden" value="" name="recaptchaResponse">

            </sform:form>
        </div>
        <a href="/login" class="u-border-2 u-border-black u-btn u-btn-round u-button-style u-hover-palette-2-light-1 u-none u-radius-50 u-text-black u-text-hover-white u-btn-2">Already have an account</a>
    </div>
</section>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Sign-Up.css" media="screen">
<script>
    function checkPass(){
        return $("#password")===$("#password2");
    }
</script>
<%@include file="common/footer.jsp" %>