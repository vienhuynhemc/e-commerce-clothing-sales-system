<%@ page import="java.util.Map" %>
<%@ page import="model.language.IndexLanguageModel" %>
<%@ page import="beans.account.ErrorLogin" %>
<%@ page import="beans.account.AccountCustomer" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/12/2020
  Time: 7:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TVT SHOP | Trang chủ</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link href="css/bootstrap.css" rel="stylesheet">
    <!-- SmartMenus jQuery Bootstrap Addon CSS -->
    <link href="css/jquery.smartmenus.bootstrap.css" rel="stylesheet">
    <!-- Product view slider -->
    <link rel="stylesheet" type="text/css" href="css/jquery.simpleLens.css">
    <!-- slick slider -->
    <link rel="stylesheet" type="text/css" href="css/slick.css">
    <!-- price picker slider -->
    <link rel="stylesheet" type="text/css" href="css/nouislider.css">
    <!-- Theme color -->
    <link id="switcher" href="css/theme-color/default-theme.css" rel="stylesheet">
    <!-- <link id="switcher" href="css/theme-color/bridge-theme.css" rel="stylesheet"> -->
    <!-- Top Slider CSS -->
    <link href="css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">

    <!-- Main style sheet -->
    <link href="css/style.css" rel="stylesheet">

    <!-- Google Font -->
    <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="css/trangChu.css">
    <script src="js/trangChu.js"></script>

</head>

<!--------------------------------Lấy list ngôn ngữ ra---------------------------------------->

<%

    //  Lấy list ngôn ngữ ra
    Map<String ,String> lang = (Map<String, String>) session.getAttribute("langList");

    // Riêng ở trang chủ, khi mở server thì nó vô thẳng trang này nên là lấy thủ công ra 1 tí
    if(lang == null){
        lang = IndexLanguageModel.getInstance().getList("vietnamese");
    }

%>






<body>

<!-- wpf loader Two -->
<jsp:include page="share/_LayoutLoadAndScroll.jsp" />
<!-- SCROLL TOP BUTTON -->
<!-- END SCROLL TOP BUTTON -->

<!-- Start header section -->
<jsp:include page="share/_LayoutHeader.jsp">
    <jsp:param name="linkMainPage" value="IndexLanguageController"/>
    <jsp:param name="levelPage" value=""/>
    <jsp:param name="activeselect" value="index.jsp"/>
</jsp:include>

<!-- / header section -->
<!-- menu -->

<!-- / menu -->
<!-- Start slider -->
<div class="contentslider">

    <div class="sliderleft">
        <div class="mainslider" id="mainslider">
            <div class="fatherimg">
                <img src="img/banner1.jpg" alt="">
                <div class="hiddendivslider">
                </div>
                <div class="noidungslider">
                    <p><%=lang.get("31")%></p>
                    <p><%=lang.get("32")+" "%> 12%</p>
                    <a href="home/product.html" class="shopnow"><%=lang.get("33")%></a>
                </div>
            </div>
            <div class="fatherimg">
                <img src="img/banner2.jpg" alt="">
                <div class="hiddendivslider">
                </div>
                <div class="noidungslider">
                    <p><%=lang.get("34")%></p>
                    <p><%=lang.get("32")+" "%>  14%</p>
                    <a href="home/product.html" class="shopnow"><%=lang.get("33")%></a>
                </div>
            </div>
            <div class="fatherimg">
                <img src="img/banner3.jpg" alt="">
                <div class="hiddendivslider">
                </div>
                <div class="noidungslider">
                    <p><%=lang.get("35")%></p>
                    <p><%=lang.get("32")+" "%>  10%</p>
                    <a href="home/product.html" class="shopnow"><%=lang.get("33")%></a>
                </div>
            </div>
            <div class="fatherimg">
                <img src="img/banner4.jpg" alt="">
                <div class="hiddendivslider">
                </div>
                <div class="noidungslider">
                    <p><%=lang.get("36")%></p>
                    <p><%=lang.get("32")+" "%>  8%</p>
                    <a href="home/product.html" class="shopnow"><%=lang.get("33")%></a>
                </div>
            </div>
        </div>
        <button class="islml" onclick="leftslide()"><i class="fa fa-angle-left"></i></button>
        <button class="islmr" onclick="rightslide()"><i class="fa fa-angle-right"> </i></button>
    </div>

    <div class="sliderright">
        <img src="img/left3.jpg" alt="">
        <div>
            <p><%=lang.get("37")%></p>
            <p><%=lang.get("32")+" "%>  4%</p>
        </div>
    </div>
</div>
<!-- / slider -->
<!-- Start Promo section -->
<div class="divsecondindex">
    <div class="divsecondindextitle">
        <h3><%=lang.get("38")%> <span style="color:#ff7315"><%=lang.get("39")%></span></h3>
        <p><%=lang.get("40")+" "%> <span style="color: red;"><i
                class="fa fa-heart"></i></span></p>
    </div>

    <div class="divsecondindexcontent">
        <div class="divsiitem">
            <a href="home/product.html">
                <img src="img/category4.webp" alt="">
                <h3><%=lang.get("33")%> </h3>
            </a>
            <h4><%=lang.get("41")%> </h4>
        </div>
        <div class="divsiitem">
            <a href="home/product.html">
                <img src="img/category5.webp" alt="">
                <h3><%=lang.get("33")%> </h3>
            </a>
            <h4><%=lang.get("42")%> </h4>
        </div>
        <div class="divsiitem">
            <a href="home/product.html">
                <img src="img/banner3.jpg" alt="">
                <h3><%=lang.get("33")%> </h3>
            </a>
            <h4><%=lang.get("43")%> </h4>
        </div>
        <div class="divsiitem">
            <a href="home/product.html">
                <img src="img/grid1.jpg" alt="">
                <h3><%=lang.get("33")%> </h3>
            </a>
            <h4><%=lang.get("44")%> </h4>
        </div>
        <div class="divsiitem">
            <a href="home/product.html">
                <img src="img/grid4.jpg" alt="">
                <h3><%=lang.get("33")%> </h3>
            </a>
            <h4><%=lang.get("45")%> </h4>
        </div>
        <div class="divsiitem">
            <a href="home/product.html">
                <img src="img/left2.jpg" alt="">
                <h3><%=lang.get("33")%> </h3>
            </a>
            <h4><%=lang.get("46")%> </h4>
        </div>

    </div>

</div>
<!-- / Promo section -->

<div class="qc1">
    <div class="qc1ct">
        <div class="qc1cttitle">
            <h3>
                <%=lang.get("47")%> <span style="color:#ff7315"><%=lang.get("32")+" "%> 17%</span>
            </h3>
            <p> <%=lang.get("48")%></p>
            <a href="home/product.html"><%=lang.get("33")%></a>
        </div>
        <div class="qc1ctimg">
            <img src="img/1.jpg" alt="">
        </div>
    </div>
</div>

<div class="qc2">
    <div class="img">
        <img src="img/qc2.jpg" alt="">
    </div>
    <div class="qc1cttitle">
        <h3>
            <%=lang.get("49")+" "%> <span style="color:#ff7315"> <%=lang.get("50")%></span>
        </h3>
        <p> <%=lang.get("51")%></p>
        <a href="home/product.html"><%=lang.get("33")%></a>
    </div>
</div>

<div class="maintt">
    <h3><%=lang.get("38")%> <span style="color:#ff7315"><%=lang.get("39")%></span></h3>
    <p><%=lang.get("52")%></p>
</div>


<!-- Products section -->
<section id="aa-product">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="aa-product-area">
                        <div class="aa-product-inner">
                            <!-- start prduct navigation -->
                            <ul class="nav nav-tabs aa-products-tab">
                                <li class="active"><a href="#men" data-toggle="tab"><%=lang.get("53")%></a></li>
                                <li><a href="#women" data-toggle="tab"><%=lang.get("54")%></a></li>
                            </ul>
                            <!-- Tab panes -->
                            <div class="tab-content">
                                <!-- Start men product category -->
                                <div class="tab-pane fade in active" id="men">
                                    <ul class="aa-product-catg productstt">
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nam/1.jpg"
                                                        alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo
                                                        khoác xanh chấm bi</a></h4>
                                                    <span class="aa-product-price sprice">400,000 VND</span><span
                                                        class="aa-product-price"><del>650,000 VND</del></span>
                                                </figcaption>
                                            </figure>
                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>
                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                            <!-- product badge -->
                                            <span class="aa-badge aa-sale" href="#"><%=lang.get("76")%></span>
                                        </li>
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nam/2.jpg" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo
                                                        sơ mi hồng cánh sen</a></h4>
                                                    <span class="aa-product-price sprice">250,000 VND</span>
                                                </figcaption>
                                            </figure>
                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>

                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                            <!-- product badge -->
                                            <span class="aa-badge aa-sold-out" href="#"><%=lang.get("77")%></span>
                                        </li>
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nam/3.jpg" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo
                                                        thun SR 100 Vàng</a></h4>
                                                    <span class="aa-product-price sprice">330,000 VND</span><span
                                                        class="aa-product-price"><del>420,000 VND</del></span>
                                                </figcaption>
                                            </figure>
                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>

                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                        </li>
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nam/4.jpg" alt=" polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo
                                                        thun STICHERY</a></h4>
                                                    <span class="aa-product-price sprice">230,000 VND</span><span
                                                        class="aa-product-price"><del>380,000 VND</del></span>
                                                </figcaption>
                                            </figure>
                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>

                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                            <!-- product badge -->
                                            <span class="aa-badge aa-hot" href="#"><%=lang.get("75")%></span>
                                        </li>
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nam/5.jpg" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo
                                                        thun MTS 1009</a></h4>
                                                    <span class="aa-product-price sprice">279,000 VND</span>
                                                </figcaption>
                                            </figure>
                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>

                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                        </li>
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nam/6.jpg" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo
                                                        khoác Kaki MOF 1001</a></h4>
                                                    <span class="aa-product-price sprice">559,000 VND</span><span
                                                        class="aa-product-price"><del>650,000 VND</del></span>
                                                </figcaption>
                                            </figure>
                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>

                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                        </li>
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nam/7.jpg" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Quần
                                                        Kaki Nam form Ngắn MSR 1001</a></h4>
                                                    <span class="aa-product-price sprice">349,000 VND</span><span
                                                        class="aa-product-price"><del>530,000 VND</del></span>
                                                </figcaption>
                                            </figure>
                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>

                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                            <!-- product badge -->
                                            <span class="aa-badge aa-sale" href="#"><%=lang.get("76")%></span>
                                        </li>
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nam/8.jpg" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo
                                                        Thun MTS 1011</a></h4>
                                                    <span class="aa-product-price sprice">229,000 VND</span>
                                                </figcaption>
                                            </figure>
                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>

                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                            <!-- product badge -->
                                            <span class="aa-badge aa-sold-out" href="#"><%=lang.get("77")%></span>
                                        </li>
                                    </ul>
                                    <a class="aa-browse-btn" href="home/product.html"><%=lang.get("55")%><span
                                            class="fa fa-angle-double-right"></span></a>
                                </div>
                                <!-- / men product category -->
                                <!-- start women product category -->
                                <div class="tab-pane fade" id="women">
                                    <ul class="aa-product-catg">
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nu/1.jpg" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo
                                                        thun WTS nâu 1109</a></h4>
                                                    <span class="aa-product-price sprice">399,000 VND</span><span
                                                        class="aa-product-price"><del>542,000 VND</del></span>
                                                </figcaption>
                                            </figure>
                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>

                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                            <!-- product badge -->
                                            <span class="aa-badge aa-sale" href="#"><%=lang.get("76")%></span>
                                        </li>
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nu/2.jpg" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo
                                                        thun nữ WAF 1002</a></h4>
                                                    <span class="aa-product-price sprice">799,000 VND</span>
                                                </figcaption>
                                            </figure>
                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>

                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                            <!-- product badge -->
                                            <span class="aa-badge aa-hot" href="#"><%=lang.get("75")%></span>
                                        </li>
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nu/3.jpg" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo
                                                        dài phong cách ấn độ</a></h4>
                                                    <span class="aa-product-price sprice">459,000 VND</span><span
                                                        class="aa-product-price"><del>799,000 VND</del></span>
                                                </figcaption>
                                            </figure>
                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>

                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                        </li>
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nu/4.jpg" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo
                                                        dài phong cách ả rập</a></h4>
                                                    <span class="aa-product-price sprice">639,000 VND</span><span
                                                        class="aa-product-price"><del>899,000 VND</del></span>
                                                </figcaption>
                                            </figure>
                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>

                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                            <!-- product badge -->
                                            <span class="aa-badge aa-sold-out" href="#"><%=lang.get("77")%></span>
                                        </li>
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nu/5.jpg" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo
                                                        len xanh AFT 1009</a></h4>
                                                    <span class="aa-product-price sprice">219,000 VND</span>
                                                </figcaption>
                                            </figure>

                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>

                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                        </li>
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nu/6.jpg" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Quần
                                                        Jogger Kakis COT 2002</a></h4>
                                                    <span class="aa-product-price sprice">269,400 VND</span><span
                                                        class="aa-product-price"><del>449,000 VND</del></span>
                                                </figcaption>
                                            </figure>
                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>

                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                        </li>
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nu/7.jpg" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo
                                                        Polo Lông vũ thiên nga</a></h4>
                                                    <span class="aa-product-price sprice">184,500 VND</span><span
                                                        class="aa-product-price"><del>369,000 VND</del></span>
                                                </figcaption>
                                            </figure>
                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>

                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                            <!-- product badge -->
                                            <span class="aa-badge aa-sale" href="#"><%=lang.get("76")%></span>
                                        </li>
                                        <!-- start single product item -->
                                        <li>
                                            <figure>
                                                <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                        src="img/do/nu/8.jpg" alt="polo shirt img"></a>
                                                <a class="aa-add-card-btn" href="home/cart.html"><span
                                                        class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                                <figcaption>
                                                    <h4 class="aa-product-title"><a href="home/detailsProduct.html">Đầm
                                                        kết hợp ly Millet CSE 2019</a></h4>
                                                    <span class="aa-product-price sprice">233,400 VND</span>
                                                </figcaption>
                                            </figure>
                                            <div class="aa-product-hvr-content">
                                                <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                                   title="<%=lang.get("72")%>"><span
                                                        class="fa fa-heart"></span></a>

                                                <a href="#" data-toggle2="tooltip" data-placement="top"
                                                   title="<%=lang.get("73")%>" data-toggle="modal"
                                                   data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                            </div>
                                            <!-- product badge -->
                                            <span class="aa-badge aa-sold-out" href="#"><%=lang.get("77")%></span>
                                        </li>
                                    </ul>
                                    <a class="aa-browse-btn" href="home/product.html"><%=lang.get("55")%><span
                                            class="fa fa-angle-double-right"></span></a>
                                </div>
                                <!-- / women product category -->
                            </div>
                            <!-- <%=lang.get("73")%> modal -->
                            <div class="modal fade" id="quick-view-modal" tabindex="-1" role="dialog"
                                 aria-labelledby="myModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-body">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                &times;
                                            </button>
                                            <div class="row">
                                                <!-- Modal view slider -->
                                                <div class="col-md-6 col-sm-6 col-xs-12 viewnhanhcol">
                                                    <div class="aa-product-view-slider viewnhanhcol">
                                                        <div class="simpleLens-gallery-container viewnhanhcol contentviewnhanh"
                                                             id="demo-1">
                                                            <div class="simpleLens-container">
                                                                <div class="simpleLens-big-image-container viewnhanhcol">
                                                                    <a class="simpleLens-lens-image"
                                                                       data-lens-image="img/modal1.png">
                                                                        <img src="img/modal1.png" alt="hinh1"
                                                                             class="simpleLens-big-image">
                                                                    </a>
                                                                </div>
                                                            </div>
                                                            <div class="simpleLens-thumbnails-container div2scl">
                                                                <a href="#" class="simpleLens-thumbnail-wrapper"
                                                                   data-lens-image="img/modal1.png"
                                                                   data-big-image="img/modal1.png">
                                                                    <img src="img/modal1.png" alt="hinh2">
                                                                </a>
                                                                <a href="#" class="simpleLens-thumbnail-wrapper"
                                                                   data-lens-image="img/modal2.png"
                                                                   data-big-image="img/modal2.png">
                                                                    <img src="img/modal2.png">
                                                                </a>

                                                                <a href="#" class="simpleLens-thumbnail-wrapper"
                                                                   data-lens-image="img/modal4.png"
                                                                   data-big-image="img/modal4.png">
                                                                    <img src="img/modal4.png">
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- Modal view content -->
                                                <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <div class="aa-product-view-content">
                                                        <h3>Váy ngắn cao cấp <span style="color: #ff7315"> MSY</span>
                                                        </h3>
                                                        <div class="aa-price-block">
                                                            <div class="rating">
                                                                <div>
                                                                    <i class="staryellow fa fa-star"></i>
                                                                    <i class="staryellow fa fa-star"></i>
                                                                    <i class="staryellow fa fa-star"></i>
                                                                    <i class="staryellow fa fa-star"></i>
                                                                    <i class="graystar fa fa-star"></i>
                                                                </div>
                                                                <a href="">( 14 người đánh giá )</a>
                                                                <div class="istock">
                                                                    <i class="fa fa-check-circle-o"></i>
                                                                    <span>Còn hàng ( 14 ) </span>
                                                                </div>
                                                            </div>
                                                            <span class="aa-product-view-price">499,000 VND</span>
                                                        </div>
                                                        <p>Váy ngắn cao cấp MSY TVT Shop với form ôn vừa vặn và dễ mặc
                                                            dành
                                                            cho bạn gái. Chất liệu cotton mang lại cảm giác thoáng mát.
                                                            In thông điệp Be Stronger tạo điểm nhấn cho các bạn gái.
                                                        </p>
                                                        <h4>Size</h4>
                                                        <div class="aa-prod-view-size">
                                                            <a href="#">S</a>
                                                            <a href="#">M</a>
                                                            <a href="#">L</a>
                                                            <a href="#">XL</a>
                                                            <a href="#">XXL</a>
                                                        </div>
                                                        <div class="aa-prod-quantity">
                                                            <div class="inputsl">
                                                                <button onclick="subtocard()"><span>-</span></button>
                                                                <input type="text" value="1" id="sladdtocard">
                                                                <button onclick="plustocard()"><span>+</span></button>
                                                            </div>
                                                            <div class="danhmucprod">
                                                                <p class="aa-prod-category">
                                                                    <span>Danh mục: </span><a href="#">Váy cao cấp
                                                                    SPY</a>
                                                                </p>
                                                            </div>
                                                        </div>
                                                        <div class="aa-prod-view-bottom">
                                                            <a href="#"
                                                               class="aa-add-to-cart-btn addTocardViewQuick"><span
                                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%> hàng</a>
                                                            <a href="#" class="aa-add-to-cart-btn"><span
                                                                    class="fa fa-eye"></span>Xem chi tiết</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div><!-- /.modal-content -->
                                </div><!-- /.modal-dialog -->
                            </div><!-- / <%=lang.get("73")%> modal -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / Products section -->
<!-- banner section -->
<section id="aa-banner">
    <div class="qc3">
        <div class="imgqc3">
            <img src="img/qc3.jpg" alt="">
        </div>
        <div class="hdqc3">
        </div>
        <div class="ctqc3">
            <h3><%=lang.get("56")+" "%> <span style="color:#ff7315"> <%=lang.get("57")%> </span></h3>
            <p><%=lang.get("58")%></p>
            <a href="home/product.html"><%=lang.get("33")%></a>
        </div>

    </div>
    <div class="maintt mainttt">
        <h3><%=lang.get("59")+" "%><span style="color:#ff7315"><%=lang.get("60")%></span></h3>
        <p><%=lang.get("61")%></p>
    </div>
</section>


<!-- popular section -->
<section id="aa-popular-category">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="aa-popular-category-area">
                        <!-- start prduct navigation -->
                        <ul class="nav nav-tabs aa-products-tab">
                            <li class="active"><a href="#popular" data-toggle="tab"><%=lang.get("62")%></a></li>
                            <li><a href="#featured" data-toggle="tab"><%=lang.get("63")%></a></li>
                        </ul>
                        <!-- Tab panes -->
                        <div class="tab-content">
                            <!-- Start men popular category -->
                            <div class="tab-pane fade in active" id="popular">
                                <ul class="aa-product-catg aa-popular-slider">
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                    src="img/do/nu/16.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="home/cart.html"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo
                                                    Sweater Nữ Logo Sài Gòn WSW 2003</a></h4>
                                                <span class="aa-product-price sprice">349,000 VND</span><span
                                                    class="aa-product-price"><del>569,000
                              VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="wishlist.jsp" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>
                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-sale" href="#"><%=lang.get("76")%></span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                    src="img/do/nu/15.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="home/cart.html"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo Thun
                                                    Relax Thêu Ngực WTS 2006</a></h4>
                                                <span class="aa-product-price sprice">229,000 VND</span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>
                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-sold-out" href="#"><%=lang.get("77")%></span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                    src="img/do/nu/14.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="home/cart.html"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                        </figure>
                                        <figcaption>
                                            <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo Thun
                                                Regular Think Less WTS 2004</a></h4>
                                            <span class="aa-product-price sprice">229,000 VND</span>
                                        </figcaption>
                                        <div class="aa-product-hvr-content">
                                            <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>
                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-sold-out" href="#"><%=lang.get("77")%></span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                    src="img/do/nu/13.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="home/cart.html"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo Thun
                                                    Dây Kéo WTS 2011</a></h4>
                                                <span class="aa-product-price sprice">299,000 VND</span><span
                                                    class="aa-product-price"><del>499,000
                              VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                    src="img/do/nu/12.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="home/cart.html"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo Thun
                                                    Nữ WTS 2016
                                                </a></h4>
                                                <span class="aa-product-price sprice"> 219,000 VND</span><span
                                                    class="aa-product-price"><del> 349,000
                              VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                    src="img/do/nu/11.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="home/cart.html"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="home/detailsProduct.html">Quần
                                                    Jeans Dài Ống Rộng WJE 2002</a></h4>
                                                <span class="aa-product-price sprice">499,000 VND</span><span
                                                    class="aa-product-price"><del>659,000
                              VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-hot" href="#"><%=lang.get("75")%></span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                    src="img/do/nu/10.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="home/cart.html"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo Thun
                                                    Nữ WTS 2035
                                                </a></h4>
                                                <span class="aa-product-price sprice"> 139,000 VND</span><span
                                                    class="aa-product-price"><del> 259,000
                              VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-hot" href="#"><%=lang.get("75")%></span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                    src="img/do/nu/9.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="home/cart.html"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo
                                                    Sweater Nữ Stay Together WSW 2006</a></h4>
                                                <span class="aa-product-price sprice">379,000 VND</span><span
                                                    class="aa-product-price"><del>419,000
                              VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-sale" href="#"><%=lang.get("76")%></span>
                                    </li>
                                </ul>
                                <a class="aa-browse-btn" href="home/product.html"><%=lang.get("55")%><span
                                        class="fa fa-angle-double-right"></span></a>
                            </div>
                            <!-- / popular product category -->

                            <!-- start featured product category -->
                            <div class="tab-pane fade" id="featured">
                                <ul class="aa-product-catg aa-featured-slider">
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                    src="img/do/nu/17.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="home/cart.html"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo Len
                                                    Nữ Phối Sọc Ngang WOS 2002</a></h4>
                                                <span class="aa-product-price sprice">429,000 VND</span><span
                                                    class="aa-product-price"><del>559,000
                              VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-sale" href="#"><%=lang.get("76")%></span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                    src="img/do/nu/18.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="home/cart.html"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo Len
                                                    Nữ Phối Màu Zigzag WOS 2001</a></h4>
                                                <span class="aa-product-price sprice">429,000 VND</span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-sold-out" href="#"><%=lang.get("77")%></span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                    src="img/do/nu/19.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="home/cart.html"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                        </figure>
                                        <figcaption>
                                            <h4 class="aa-product-title"><a href="home/detailsProduct.html">Quần Thun Nữ
                                                Form Slim Feeling Inside WTS 2022</a></h4>
                                            <span class="aa-product-price sprice">219,000 VND</span>
                                        </figcaption>
                                        <div class="aa-product-hvr-content">
                                            <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-sold-out" href="#"><%=lang.get("77")%></span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="home/detailsProduct.html"><img
                                                    src="img/do/nu/20.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="home/cart.html"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="home/detailsProduct.html">Áo Thun
                                                    Nữ WTS 2021</a></h4>
                                                <span class="aa-product-price sprice">219,000 VND</span><span
                                                    class="aa-product-price"><del>339,000
                              VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="home/wishlist.html" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="#"><img src="img/do/nu/21.jpg"
                                                                                    alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="#"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="#">Áo Thun Nữ Form Slim Sunshine
                                                    WTS 2019</a></h4>
                                                <span class="aa-product-price sprice">219,000 VND</span><span
                                                    class="aa-product-price"><del>339,000
                              VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="#" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="#"><img src="img/do/nu/22.jpg"
                                                                                    alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="#"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="#">Áo Thun Nữ Form Slim Be
                                                    Stronger WTS 2018</a></h4>
                                                <span class="aa-product-price sprice">219,000 VND</span><span
                                                    class="aa-product-price"><del>359,000
                              VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="#" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-hot" href="#"><%=lang.get("75")%></span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="#"><img src="img/do/nu/23.jpg"
                                                                                    alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="#"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="#">Áo Thun Nữ WTS 2017
                                                </a></h4>
                                                <span class="aa-product-price sprice">219,000 VND</span><span
                                                    class="aa-product-price"><del>259,000
                              VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="#" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-hot" href="#"><%=lang.get("75")%></span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="#"><img src="img/do/nu/24.jpg"
                                                                                    alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="#"><span
                                                    class="fa fa-shopping-cart"></span><%=lang.get("74")%></a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="#">Áo Thun Nữ The North Land WTS
                                                    2024</a></h4>
                                                <span class="aa-product-price sprice">229,000 VND</span><span
                                                    class="aa-product-price"><del>299,000
                              VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="#" data-toggle="tooltip" data-placement="top"
                                               title="<%=lang.get("72")%>"><span
                                                    class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top" title="<%=lang.get("73")%>"
                                               data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-sale" href="#"><%=lang.get("76")%></span>
                                    </li>
                                </ul>
                                <a class="aa-browse-btn" href="home/product.html"><%=lang.get("55")%><span
                                        class="fa fa-angle-double-right"></span></a>
                            </div>
                            <!-- / featured product category -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- / popular section -->
<!-- Support section -->
<!-- / Support section -->
<!-- Testimonial -->
<!-- / Testimonial -->


<!-- / Latest Blog -->

<!-- Client Brand -->
<section id="aa-testimonial">
    <div class="kh">
        <h3><%=lang.get("64")%> <span style="color:#ff7315"><%=lang.get("65")%></span></h3>
        <p><%=lang.get("66")%></p>

        <div class="khlist">
            <div class="runkhlist" id="runkhlist">
                <div class="khlistitem">
                    <div class="khlistitemchild">
                        <div class="khlistitemchildheader">
                            <span class="fa fa-quote-left"></span>
                            <p><br><br>Trên đời này, phải có làm mới có ăn, muốn đẹp thì phải mua đồ, bạn nhé! Tôi thì
                                tôi thích cái
                                trang này
                                rồi đấy:3 <br><br><br><br></p>
                        </div>
                        <div class="arrowbottom"><img src="img/arrowbotton.png" alt=""></div>
                        <div class="khlistitemchildfooter">
                            <img src="img/khbl1.jpg" alt="">
                            <h5>Huấn Rose</h5>
                        </div>
                    </div>

                    <div class="khlistitemchild">
                        <div class="khlistitemchildheader">
                            <span class="fa fa-quote-left"></span>
                            <p><br><br>Tôi năm nay hơn 70 tuổi rồi mà chưa gặp cái trang bán đồ nào như thế này cả, phải
                                tôi tôi mua
                                cho mười
                                bộ<br><br><br><br>
                            </p>
                        </div>
                        <div class="arrowbottom"><img src="img/arrowbotton.png" alt=""></div>
                        <div class="khlistitemchildfooter">
                            <img src="img/khbl2.jpg" alt="">
                            <h5>Nguyễn Hữu Đa</h5>
                        </div>
                    </div>

                    <div class="khlistitemchild">
                        <div class="khlistitemchildheader">
                            <span class="fa fa-quote-left"></span>
                            <p>Lần đầu đến với TVT Shop tôi chỉ nghĩ là mua thử, nhưng khi mặc thật tôi mới thấy thoải
                                mái từ
                                phom dáng đến chất liệu. Một cảm giác mà tôi ít khi gặp được khi mua hàng may sẵn, nhất
                                là về chất
                                liệu.
                                Giá thì vô cũng hợp lí.
                                Rất mong được gắn bó lâu dài với nhãn hàng.
                            </p>
                        </div>
                        <div class="arrowbottom"><img src="img/arrowbotton.png" alt=""></div>
                        <div class="khlistitemchildfooter">
                            <img src="img/khbl3.jpg" alt="">
                            <h5>Khương Hồng Nhan</h5>
                        </div>
                    </div>

                    <div class="khlistitemchild">
                        <div class="khlistitemchildheader">
                            <span class="fa fa-quote-left"></span>
                            <p>Một ngày nghỉ với chuyến đi chơi thật vui vẻ bên gia đình để lấy lại tinh thần
                                cho tuần làm việc kế tiếp. Với lựa chọn bộ đồ sao cho thật thoải mái và năng động mình
                                rất ưng
                                ý với đồ của thời trang TVT Shop, chất liệu tốt, màu sắc nhã nhặn, thiết kế ko cầu kỳ
                                nhưng lại tinh tế.
                            </p>
                        </div>
                        <div class="arrowbottom"><img src="img/arrowbotton.png" alt=""></div>
                        <div class="khlistitemchildfooter">
                            <img src="img/khbl4.jpg" alt="">
                            <h5>Lý Thu Thủy</h5>
                        </div>
                    </div>

                </div>
                <div class="khlistitem">
                    <div class="khlistitemchild">
                        <div class="khlistitemchildheader">
                            <span class="fa fa-quote-left"></span>
                            <p><br>Một người bạn thủa xưa đã hỏi mình mặc đồ của thương hiệu nào mà đẹp vậy? Thật sự là
                                mặc đồ mình
                                cảm
                                thấy thoải mái, hợp phong cách của bản thân đã là điều làm mình thấy tự tin và mình trả
                                lời ngay là
                                TVT
                                Shop<br></p>
                        </div>
                        <div class="arrowbottom"><img src="img/arrowbotton.png" alt=""></div>
                        <div class="khlistitemchildfooter">
                            <img src="img/khbl5.jpg" alt="">
                            <h5>Nguyễn Hải Thanh</h5>
                        </div>
                    </div>

                    <div class="khlistitemchild">
                        <div class="khlistitemchildheader">
                            <span class="fa fa-quote-left"></span>
                            <p><br>Ăn mặc đẹp không những khiến bạn đẹp hơn mà còn khiến bạn thành công hơn, vì vậy
                                chúng ta nên
                                mặc đẹp. Thời trang TVT Shop khiến tôi rất hài lòng về kiểu dáng và chất lượng. Tôi luôn
                                chọn trang
                                phục
                                TVT Shop làm bạn đồng hành<br>
                            </p>
                        </div>
                        <div class="arrowbottom"><img src="img/arrowbotton.png" alt=""></div>
                        <div class="khlistitemchildfooter">
                            <img src="img/khbl6.jpg" alt="">
                            <h5>Hữu Sơn</h5>
                        </div>
                    </div>

                    <div class="khlistitemchild">
                        <div class="khlistitemchildheader">
                            <span class="fa fa-quote-left"></span>
                            <p>Đến TVT Shop bạn còn có thể lựa chọn đồ đi chơi, dự tiệc…
                                . Tôi còn rất ấn tượng với TVT Shop ở đường kim mũi chỉ sắc nét và chắc
                                chắn, và chiếc quần âu hay chiếc áo dạ luôn có đính kèm cúc sơ cua- đó là sự chu đáo mà
                                TVT Shop dành
                                tới
                                khách hàng của mình.
                            </p>
                        </div>
                        <div class="arrowbottom"><img src="img/arrowbotton.png" alt=""></div>
                        <div class="khlistitemchildfooter">
                            <img src="img/khbl7.jpg" alt="">
                            <h5>Phạm Nhung</h5>
                        </div>
                    </div>

                    <div class="khlistitemchild">
                        <div class="khlistitemchildheader">
                            <span class="fa fa-quote-left"></span>
                            <p>Mình thấy những sản phẩm của TVT Shop không chỉ phong phú đa dạng về màu mắc, form
                                dáng,mẫu mã, mà
                                còn
                                cảm
                                nhận được những giá trị không thể nhìn thấy - đó là tình yêu của những nhà thiết kế,nhân
                                viên. Thế nên
                                lựa chọn hàng đầu của tôi luôn là TVT Shop
                            </p>
                        </div>
                        <div class="arrowbottom"><img src="img/arrowbotton.png" alt=""></div>
                        <div class="khlistitemchildfooter">
                            <img src="img/khbl8.jpg" alt="">
                            <h5>Hoàng Quốc Thắng</h5>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <input type="radio" name="rd1" id="rd1" checked>
        <input type="radio" name="rd1" id="rd2">
        <label for="rd1" class="lb1" onclick="leftRD()"></label>
        <label for="rd2" class="lb2" onclick="rightRD()"></label>

    </div>
</section>

<!-- / Client Brand -->

<!---------------MAIL LIÊN HỆ------------------>
<a href="#aa-subscribe" id="movetosubscribe" style="display: none"></a>

<%

    //  Nếu như paggAddress != null thì có nghĩa ta đã được đi tới controller mail, nó sẽ trả về 1 pageAddress
    if (request.getAttribute("pageAddress") != null) {

        //  Lấy link trang đó ra để include vào, đó là trang hiện lên 1 thông báo để người dùng biết trạng thái
        String address = (String) request.getAttribute("pageAddress");

%>

<jsp:include page="<%=address%>"/>

<script>
    document.getElementById("movetosubscribe").click();
</script>

<%
    }
%>
<!------------------------------------------------>

<!-- sử lí đăng nhập thành công-->

<%
    //lấy request user == null thì đăng nhập thành công

    //AccountCustomer accountCustomer = (AccountCustomer) session.getAttribute("user");

    String status = (String) request.getAttribute("loginStatus");

    if (status  != null) {
        //truyển status vào để sử lí
        ErrorLogin errorLogin = new ErrorLogin(status);

%>

<%request.setCharacterEncoding("utf-8");%>
<jsp:include page="notifyErrorLogin/AccountStatus.jsp">
    <jsp:param name="title" value="<%=errorLogin.getTitle()%>"/>
    <jsp:param name="content" value="<%=errorLogin.getContent()%>"/>
</jsp:include>
<%
    }
%>





<!-- Subscribe section -->
<section id="aa-subscribe">
    <div class="subscribediv">
        <div class="subscribedivchild">
            <h3><%=lang.get("67")+" "%> <span style="color:#ff7315"><%=lang.get("68")%></span></h3>
            <p>
                <%=lang.get("69")%></p>
            <form action="MailController" method="post">
                <div class="form-action-sr">
                    <input type="text" name="email" required
                           value=""
                           placeholder="<%=lang.get("70")%>">
                    <button><%=lang.get("71")%></button>
                </div>
            </form>
        </div>
        <div>
            <img src="img/subrai.jpg" alt="">
        </div>
    </div>
</section>
<!-- / Subscribe section -->

<jsp:include page="share/_LayoutChatBox.jsp" />

<!-- footer --><jsp:include page="share/_LayoutFooter.jsp">
    <jsp:param name="levelPage" value=""/>
</jsp:include>

<!-- / footer -->

<!-- Login Modal -->
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4>Login or Register</h4>
                <form class="aa-login-form" action="">
                    <label for="">Username or Email address<span>*</span></label>
                    <input type="text" placeholder="Username or email">
                    <label for="">Password<span>*</span></label>
                    <input type="password" placeholder="Password">
                    <button class="aa-browse-btn" type="submit">Login</button>
                    <label for="rememberme" class="rememberme"><input type="checkbox" id="rememberme"> Remember me
                    </label>
                    <p class="aa-lost-password"><a href="#">Lost your password?</a></p>
                    <div class="aa-register-now">
                        Don't have an account?<a href="account.html">Register now!</a>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.js"></script>
<!-- SmartMenus jQuery plugin -->
<script type="text/javascript" src="js/jquery.smartmenus.js"></script>
<!-- SmartMenus jQuery Bootstrap Addon -->
<script type="text/javascript" src="js/jquery.smartmenus.bootstrap.js"></script>
<!-- To Slider JS -->
<script src="js/sequence.js"></script>
<script src="js/sequence-theme.modern-slide-in.js"></script>
<!-- Product view slider -->
<script type="text/javascript" src="js/jquery.simpleGallery.js"></script>
<script type="text/javascript" src="js/jquery.simpleLens.js"></script>
<!-- slick slider -->
<script type="text/javascript" src="js/slick.js"></script>
<!-- Price picker slider -->
<script type="text/javascript" src="js/nouislider.js"></script>
<!-- Custom js -->
<script src="js/custom.js"></script>


</body>

</html>