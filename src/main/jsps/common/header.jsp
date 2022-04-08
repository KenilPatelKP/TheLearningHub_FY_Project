<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <meta http-equiv="x-ua-compatible" content="ie=edge">--%>

<%--    <title>EASY SUBMISSION</title>--%>
<%--    <!-- Font Awesome Icons -->--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/all.min.css">--%>
<%--    <!-- Theme style -->--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">--%>
<%--    <!-- DataTables -->--%>
<%--    <link rel="stylesheet"--%>
<%--          href="${pageContext.request.contextPath}/plugins/datatables-bs4/css/dataTables.bootstrap4.css">--%>
<%--    <!-- Google Font: Source Sans Pro -->--%>
<%--    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">--%>
<%--    <!-- Toastr -->--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/toastr/toastr.min.css">--%>
<%--    &lt;%&ndash;    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/sweetalert2-theme-bootstrap-4/bootstrap-4.min.css">&ndash;%&gt;--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/css/select2.min.css">--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">--%>
<%--</head>--%>
<%--<body class="hold-transition sidebar-mini">--%>
<%--<div class="wrapper">--%>


<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="ISO-8859-1">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="keywords" content="Contact Us">--%>
<%--    <meta name="description" content="">--%>
<%--    <meta name="page_type" content="np-template-header-footer-from-plugin">--%>
<%--    <title>The Learning Hub</title>--%>


<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/nicepage.css" media="screen">--%>
<%--&lt;%&ndash;    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/Home.css" media="screen">&ndash;%&gt;--%>

<%--    <script class="u-script" type="text/javascript" src="${pageContext.request.contextPath}/static/jquery.js" defer=""></script>--%>
<%--    <script class="u-script" type="text/javascript" src="${pageContext.request.contextPath}/static/nicepage.js" defer=""></script>--%>
<%--    <meta name="generator" content="Nicepage 4.3.3, nicepage.com">--%>
<%--    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">--%>


<%--    <script type="application/ld+json">{--%>
<%--        "@context": "http://schema.org",--%>
<%--        "@type": "Organization",--%>
<%--        "name": "The Learning Hub",--%>
<%--        "logo": "${pageContext.request.contextPath}/static/images/The_Learning_Hub_LOGO1.png"--%>
<%--    }</script>--%>
<%--    <meta name="theme-color" content="#478ac9">--%>
<%--    <meta property="og:title" content="Login">--%>
<%--    <meta property="og:description" content="">--%>
<%--    <meta property="og:type" content="website">--%>
<%--</head>--%>
<%--<body class="u-body">--%>


<%--    <%@include file="navbar.jsp" %>--%>
<%--    <%@include file="sidemenu.jsp" %>--%>

<!DOCTYPE html>
<html style="font-size: 16px;">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="?Top categories">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>The Learning Hub</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/nicepage.css" media="screen">

    <script class="u-script" type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="${pageContext.request.contextPath}/js/nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 4.3.3, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">


    <script type="application/ld+json">{
        "@context": "http://schema.org",
        "@type": "Organization",
        "name": "The Learning Hub",
        "logo": "${pageContext.request.contextPath}/images/The_Learning_Hub_LOGO1.png"
    }
    </script>
    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="Home">
    <meta property="og:description" content="">
    <meta property="og:type" content="website">
</head>

<header class="u-clearfix u-header u-header" id="sec-e67e"><div class="u-clearfix u-sheet u-sheet-1">
    <a href="Home.html" data-page-id="88793668" class="u-image u-logo u-image-1" data-image-width="985" data-image-height="290" title="Home">
        <img src="${pageContext.request.contextPath}/images/The_Learning_Hub_LOGO1.png" class="u-logo-image u-logo-image-1">
    </a>
    <form action="#" method="get" class="u-border-1 u-border-grey-30 u-radius-50 u-search u-search-left u-white u-search-1">
        <button class="u-search-button" type="submit">
            <span class="u-search-icon u-spacing-10">
              <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 56.966 56.966"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-2b7c"></use></svg>
              <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="svg-2b7c" x="0px" y="0px" viewBox="0 0 56.966 56.966" style="enable-background:new 0 0 56.966 56.966;" xml:space="preserve" class="u-svg-content"><path d="M55.146,51.887L41.588,37.786c3.486-4.144,5.396-9.358,5.396-14.786c0-12.682-10.318-23-23-23s-23,10.318-23,23  s10.318,23,23,23c4.761,0,9.298-1.436,13.177-4.162l13.661,14.208c0.571,0.593,1.339,0.92,2.162,0.92  c0.779,0,1.518-0.297,2.079-0.837C56.255,54.982,56.293,53.08,55.146,51.887z M23.984,6c9.374,0,17,7.626,17,17s-7.626,17-17,17  s-17-7.626-17-17S14.61,6,23.984,6z"></path></svg>
            </span>
        </button>
        <input class="u-search-input" type="search" name="search" value="" placeholder="Search">
    </form>
    <nav class="u-menu u-menu-dropdown u-offcanvas u-menu-1">
        <div class="menu-collapse" style="font-size: 1rem; letter-spacing: 0px;">
            <a class="u-button-style u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="#">
                <svg class="u-svg-link" viewBox="0 0 24 24"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#menu-hamburger"></use></svg>
                <svg class="u-svg-content" version="1.1" id="menu-hamburger" viewBox="0 0 16 16" x="0px" y="0px" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg"><g><rect y="1" width="16" height="2"></rect><rect y="7" width="16" height="2"></rect><rect y="13" width="16" height="2"></rect>
                </g></svg>
            </a>
        </div>
        <div class="u-custom-menu u-nav-container">
            <ul class="u-nav u-spacing-2 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-border-2 u-border-active-grey-90 u-border-hover-grey-50 u-button-style u-nav-link u-text-active-grey-90 u-text-grey-90 u-text-hover-grey-90" href="${pageContext.request.contextPath}/" style="padding: 10px 20px;">Home</a>
            </li><li class="u-nav-item"><a class="u-border-2 u-border-active-grey-90 u-border-hover-grey-50 u-button-style u-nav-link u-text-active-grey-90 u-text-grey-90 u-text-hover-grey-90" href="about.html" style="padding: 10px 20px;">About</a>
            </li><li class="u-nav-item"><a class="u-border-2 u-border-active-grey-90 u-border-hover-grey-50 u-button-style u-nav-link u-text-active-grey-90 u-text-grey-90 u-text-hover-grey-90" href="contact.html" style="padding: 10px 20px;">Contact</a>
            </li><li class="u-nav-item"><a class="u-border-2 u-border-active-grey-90 u-border-hover-grey-50 u-button-style u-nav-link u-text-active-grey-90 u-text-grey-90 u-text-hover-grey-90" href="login" style="padding: 10px 20px;">Log In</a>
            </li><li class="u-nav-item"><a class="u-border-2 u-border-active-grey-90 u-border-hover-grey-50 u-button-style u-nav-link u-text-active-grey-90 u-text-grey-90 u-text-hover-grey-90" href="signUp" style="padding: 10px 20px;">Sign up</a>
            </li></ul>
        </div>
        <div class="u-custom-menu u-nav-container-collapse">
            <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
                <div class="u-inner-container-layout u-sidenav-overflow">
                    <div class="u-menu-close"></div>
                    <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2"><li class="u-nav-item"><a class="u-button-style u-nav-link" href="" style="padding: 10px 20px;">Home</a>
                    </li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="about.html" style="padding: 10px 20px;">About</a>
                    </li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="contact.html" style="padding: 10px 20px;">Contact</a>
                    </li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="login" style="padding: 10px 20px;">Log In</a>
                    </li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="signup" style="padding: 10px 20px;">Sign up</a>
                    </li></ul>
                </div>
            </div>
            <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
        </div>
    </nav>
</div></header>
<%--<body data-home-page="Home.html" data-home-page-title="Home" class="u-body">--%>