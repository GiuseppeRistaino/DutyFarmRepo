<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="body" tagdir="/WEB-INF/tags/responsive/common/body"%>


<template:page pageTitle="${pageTitle}">

    <body>
        <div class="slideshow-container">

        <div class="mySlides fade">
          <div class="numbertext"></div>
              <cms:pageSlot position="CarouselA" var="feature">
                <cms:component component="${feature}" />
              </cms:pageSlot>
          <div class="text">Caption Text</div>
        </div>

        <div class="mySlides fade">
          <div class="numbertext"></div>
              <cms:pageSlot position="CarouselB" var="feature">
                <cms:component component="${feature}" />
              </cms:pageSlot>
          <div class="text">Caption Two</div>
        </div>



        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
        <a class="next" onclick="plusSlides(1)">&#10095;</a>

        </div>

        <%--
        <div class="dots">
          <span class="dot" onclick="currentSlide(1)"></span>
          <span class="dot" onclick="currentSlide(2)"></span>
        </div>
        --%>

        <%-- OLD CAROUSEL
        <div class="container">
          <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
              <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
              <li data-target="#myCarousel" data-slide-to="1"></li>
              <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">
              <div class="item active">
                <cms:pageSlot position="Carousel" var="feature">
                              <cms:component component="${feature}" />
                          </cms:pageSlot>
              </div>

              <div class="item">
                <cms:pageSlot position="SectionA" var="feature">
                              <cms:component component="${feature}" />
                          </cms:pageSlot>
              </div>

              <div class="item">
                <cms:pageSlot position="SectionB" var="feature">
                                              <cms:component component="${feature}" />
                                          </cms:pageSlot>
              </div>
            </div>

            <!-- Left and right controls
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
              <span class="glyphicon glyphicon-chevron-left"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
              <span class="glyphicon glyphicon-chevron-right"></span>
              <span class="sr-only">Next</span>
            </a>
            -->
          </div>
        </div>
        --%>
        <script src="${commonResourcePath}/dutyFarm/js/carousel.js"></script>



    </body>

    <%--
    <cms:pageSlot position="Carousel" var="feature">
        <cms:component component="${feature}" />
    </cms:pageSlot>

    <div class="row no-margin">
        <div class="col-xs-12 col-md-6 no-space">
            <cms:pageSlot position="SectionA" var="feature" element="div" class="miniCartSlot componentContainer mobile__nav__row--table">
                <cms:component component="${feature}" element="div" class="mobile__nav__row--table-cell"/>
            </cms:pageSlot>
        </div>
        <div class="col-xs-12 col-md-6 no-space">
            <cms:pageSlot position="SectionB" var="feature" element="div" class="row no-margin">
                <cms:component component="${feature}" element="div" class="col-xs-12 col-sm-6 no-space yComponentWrapper"/>
            </cms:pageSlot>
        </div>
        <div class="col-xs-12">
            <cms:pageSlot position="SectionC" var="feature" element="div" class="landingLayout2PageSection2C">
                <cms:component component="${feature}" element="div" class="yComponentWrapper"/>
            </cms:pageSlot>
        </div>
    </div>
    --%>
    <%--
    <cms:pageSlot position="Section3" var="feature" element="div" class="row no-margin" >
        <cms:component component="${feature}" element="div" class="no-space yComponentWrapper"/>
    </cms:pageSlot>

    <cms:pageSlot position="Section4" var="feature" element="div" class="row no-margin">
        <cms:component component="${feature}" element="div" class="col-xs-6 col-md-3 no-space yComponentWrapper"/>
    </cms:pageSlot>

    <cms:pageSlot position="Section5" var="feature" element="div">
        <cms:component component="${feature}" element="div" class="yComponentWrapper"/>
    </cms:pageSlot>
    --%>
</template:page>
