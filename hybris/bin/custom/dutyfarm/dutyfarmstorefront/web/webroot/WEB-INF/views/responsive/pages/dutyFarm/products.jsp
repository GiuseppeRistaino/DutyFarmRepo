<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/responsive/user"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<template:page pageTitle="${pageTitle}">
    <head>
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" type="text/css" href="${commonResourcePath}/dutyFarm/products/css/animate.css">
	<link rel="stylesheet" type="text/css" href="${commonResourcePath}/dutyFarm/products/css/style.css">
	<link rel="stylesheet" type="text/css" href="${commonResourcePath}/dutyFarm/products/css/ionicons.min.css">
    <link rel="stylesheet" type="text/css" href="${commonResourcePath}/dutyFarm/products/css/pagination.css">
    </head>
    <body>

        <div class="category-container">
            <c:forEach var="category" items="${categories}">
                <div class="category-cell">
                    <img src="${category.thumbnail.url}"/></a>
                    <a class="category-link" href="/${fn:toLowerCase(category.code)}">${category.code}</a>
                </div>
            </c:forEach>
        </div>

        <div class="container-products">
               <div class="row-products">
                    <c:forEach var="product" items="${products}">
                        <div class="col-md-6-products col-lg-3-products">
                            <div class="cell-product">
                                <c:forEach var="image" items="${product.getImages()}" varStatus="loopCount">
                                    <c:if test="${loopCount.count eq 1}">
                                        <a href="#" class="img-prod"><img class="img-fluid" src="${image.url}" alt="Colorlib Template">

                                        </a>
                                    </c:if>
                                </c:forEach>
                                <div class="text py-3 pb-4 px-3 text-center">
                                    <h3><a href="#">${product.name}</a></h3>
                                    <div class="d-flex">
                                        <div class="pricing">
                                            <p class="price"><span>${product.price.value} ${" "} ${product.price.currencyIso}</span></p>
                                        </div>
                                    </div>
                                    <div class="bottom-area d-flex px-3">
                                        <div class="m-auto d-flex">
                                            <a href="#" class="add-to-cart d-flex justify-content-center align-items-center text-center">
                                                <span><i class="ion-ios-menu"></i></span>
                                            </a>
                                            <a href="#" class="buy-now d-flex justify-content-center align-items-center mx-1">
                                                <span><i class="ion-ios-cart"></i></span>
                                            </a>
                                            <a href="#" class="heart d-flex justify-content-center align-items-center ">
                                                <span><i class="ion-ios-heart"></i></span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
               </div>
        </div>
        <div class="pagination-wrapper">
          <div class="pagination">
            <a class="prev page-numbers" href="javascript:;">prev</a>
            <span aria-current="page" class="page-numbers current">1</span>
            <a class="page-numbers" href="javascript:;">2</a>
            <a class="page-numbers" href="javascript:;">3</a>
            <a class="page-numbers" href="javascript:;">4</a>
            <a class="page-numbers" href="javascript:;">5</a>
            <a class="page-numbers" href="javascript:;">6</a>
            <a class="page-numbers" href="javascript:;">7</a>
            <a class="page-numbers" href="javascript:;">8</a>
            <a class="page-numbers" href="javascript:;">9</a>
            <a class="page-numbers" href="javascript:;">10</a>
            <a class="next page-numbers" href="javascript:;">next</a>
          </div>
        </div>


        <script src="${commonResourcePath}/dutyFarm/products/js/aos.js"></script>
            <script src="${commonResourcePath}/dutyFarm/products/js/jquery.min.js"></script>
            <script src="${commonResourcePath}/dutyFarm/products/js/jquery.stellar.min.js"></script>
            <script src="${commonResourcePath}/dutyFarm/products/js/jquery.waypoints.min.js"></script>
            <script src="${commonResourcePath}/dutyFarm/products/js/jquery.jquery-migrate-3.0.1.min.js"></script>
            <script src="${commonResourcePath}/dutyFarm/products/js/main.js"></script>
            <script src="${commonResourcePath}/dutyFarm/products/js/owl.carousel.min.js"></script>
            <script src="${commonResourcePath}/dutyFarm/products/js/scrollax.min.js"></script>

    </body>
</template:page>

<%--
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category List</title>
</head>
<body>
	<h1>Category Listing</h1>
	<ul>
		<c:forEach var="category" items="${categories}">
        			<li>${category.code}</li>
        </c:forEach>
	</ul>
</body>
</html>
--%>