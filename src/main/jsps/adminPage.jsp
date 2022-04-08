<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="common/header.jsp"></jsp:include>
<body>
<div class="section tlo" ng-app="" ng-show="${isAdmin}">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <h1>All Courses</h1>
                <div class="row">
                    <div class="col-md-12">
                        <c:choose>
                            <c:when test="${courses.size() >= 1}">
                                <c:forEach var="i" begin="0" end="${courses.size()-1}">
                            <div class="row roomBorder">
                                <div class="col-md-6">
                                    <a href='${pageContext.request.contextPath}/course/${courses.get(i).getIdcourse()}'>
                                        <h3>${courses.get(i).getTitle()}</h3></a>
                                        <h4>Validated: ${courses.get(i).isValidated()}</h4>
                                        <h4>Highligted: ${courses.get(i).isHighlighted()}</h4>
                                        <h4>Private: ${courses.get(i).isPrivate()}</h4>
                                </div>
                                <div class="col-md-5">
                                    <form id="myFormValidate" class="form-horizontal" role="form" method="GET" action="${pageContext.request.contextPath}/course/setValidated">
                                        <input type="hidden" name="idCourse" value="${courses.get(i).idcourse}">
                                        <input type="radio" name="isValidated" value="true">Validate
                                        <input type="radio" name="isValidated" value="false">Not validate
                                        <button type="submit" class='btn btn-primary pull-right'>Change</button>
                                    </form>
                                    <form id="myFormHighlight" class="form-horizontal" role="form" method="GET" action="${pageContext.request.contextPath}/course/setHighlighted">
                                        <input type="hidden" name="idCourse" value="${courses.get(i).idcourse}">
                                        <input ng-change="document.getElementById('myFormHighlight').submit();" type="radio" name="isHighlighted" value="true">Highlighted
                                        <input ng-change="document.getElementById('myFormHighlight').submit();" type="radio" name="isHighlighted" value="false">Not highlighted
                                        <button type="submit" class='btn btn-primary pull-right'>Change</button>
                                    </form>
                                </div>
                                </div>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <h4 style="color:grey">There are no courses</h4>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="fillScreen">
    </div>
</div>
<jsp:include page="common/footer.jsp"></jsp:include>