<%@ page import="java.util.Map" %>
<%@ page import="model.language.HeaderLanguageModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //  Lấy ra ngôn ngữ hiện tại của session
    String language = (String) session.getAttribute("lang");

    //  Nếu session chưa có thì có nghĩa index mới đc mở lần đầu, cho mặc định là tiếng việt
    if (language == null) language = "vietnamese";

    //  Xong rồi lấy list ngôn ngữ từ model ra, vì trang này làm include nên ko gọi tới controller serverlet được
    Map<String, String> lang = HeaderLanguageModel.getInstance().getList(language);

%>

<header id="aa-header">
    <!-- start header top  -->
    <div class="aa-header-top">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="aa-header-top-area">
                        <!-- start header top left -->
                        <div class="aa-header-top-left">
                            <!-- start language -->

                            <!-- / language -->
                            <span id="qc"><%=lang.get("1")%> <span
                                    style="color:#ff7315; font-weight:bold"><%=lang.get("2")%></span> <%=lang.get("3")%> <span
                                    style="color:#ff7315; font-weight:bold">499,000đ</span></span>
                            <!-- start currency -->
                            <!-- / currency -->
                            <!-- start cellphone -->

                            <!-- / cellphone -->
                        </div>
                        <!-- / header top left -->
                        <div class="aa-header-top-right">
                            <ul class="aa-head-top-nav-right">
                                <li class="iconRound"><a href="thong-tin"><i class="fa fa-user"
                                                                                                 aria-hidden="true"></i></a>
                                </li>
                                <li class="hidden-xs iconRound"><a href="wishlist.jsp"><i class="fa fa-heart"></i></a>
                                </li>
                                <li class="hidden-xs iconRoundLenght"><a href="cart.jsp"><%=lang.get("4")%>
                                    <span class="fa fa-shopping-cart"></span></a></li>
                                <li class="hidden-xs iconRoundLenght"><a href="checkout.jsp"><%=lang.get("5")%>
                                    <span
                                            class="fa fa-credit-card"></span></a></li>
                                <!-- <li><a href="" data-toggle="modal" data-target="#login-modal">Login</a></li> -->
                                <li class="hidden-xs iconRoundLenghtt">
                                    <div class="aa-language">
                                        <div class="dropdown">
                                            <a class="btn dropdown-toggle" href="#" type="button" id="dropdownMenu1"
                                               data-toggle="dropdown"
                                               aria-haspopup="true" aria-expanded="true">

                                                <img class="country"

                                                    <% if(lang.get("type").equals("vietnamese")){%>
                                                     src="<%=request.getParameter("levelPage")%>img/vietnam.png"
                                                    <%} else{%>
                                                     src="<%=request.getParameter("levelPage")%>img/language.png"
                                                    <%}%>

                                                     alt="english flag">

                                                <% if (lang.get("type").equals("vietnamese")) {%>
                                                Việt Nam
                                                <%} else {%>
                                                English
                                                <%}%>

                                                <span class="caret"></span>
                                            </a>
                                            <ul class="dropdown-menu menucountry choiselanguage"
                                                aria-labelledby="dropdownMenu1">
                                                <li

                                                        <%
                                                            //  Nếu như là ngôn ngữ việt nam thì ta thêm classs active vào
                                                            if (lang.get("type").equals("vietnamese")) {
                                                        %>
                                                        class="activengonngu"
                                                        <%}%>

                                                >
                                                    <a href="<%=request.getParameter("levelPage")%><%=request.getParameter("linkMainPage")%>?lang=vietnamese"><img
                                                            class="country"
                                                            src="<%=request.getParameter("levelPage")%>img/vietnam.png"
                                                            alt="">Việt
                                                        Nam</a></li>
                                                <li

                                                        <%
                                                            //  Nếu như là ngôn ngữ english thì ta thêm classs active vào
                                                            if (lang.get("type").equals("english")) {
                                                        %>
                                                        class="activengonngu"
                                                        <%}%>

                                                >
                                                    <a href="<%=request.getParameter("levelPage")%><%=request.getParameter("linkMainPage")%>?lang=english"><img
                                                            class="country"
                                                            src="<%=request.getParameter("levelPage")%>img/language.png"
                                                            alt="">English</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </li>
                                <li class="hidden-xs iconRoundLenghtt iconPhone">
                                    <div class="cellphone hidden-xs">
                                        <p id="phone"><span class="fa fa-phone"></span>09-7112-209</p>
                                    </div>
                                </li>

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- / header top  -->

    <!-- start header bottom  -->
    <div class="aa-header-bottom">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="aa-header-bottom-area">
                        <!-- logo  -->
                        <div class="aa-logo">
                            <!-- Text based logo -->
                            <a href="<%=request.getParameter("levelPage")%>IndexLanguageController">
                                <span class="fa fa-shopping-cart"></span>
                                <p>TVT<strong style="color:#ff7315">S</strong>hop
                                    <span><%=lang.get("24")%>, <%=" " + lang.get("25")%></span></p>
                            </a>
                            <!-- img based logo -->
                            <!-- <a href="index.html"><img src="img/logo.jpg" alt="logo img"></a> -->
                        </div>
                        <!-- / logo  -->
                        <section id="menu">
                            <div class="container">
                                <div class="menu-area">
                                    <!-- Navbar -->
                                    <div class="navbar navbar-default" role="navigation">
                                        <div class="navbar-header">
                                            <button type="button" class="navbar-toggle" data-toggle="collapse"
                                                    data-target=".navbar-collapse">
                                                <span class="sr-only">Toggle navigation</span>
                                                <span class="icon-bar"></span>
                                                <span class="icon-bar"></span>
                                                <span class="icon-bar"></span>
                                            </button>
                                        </div>
                                        <div class="navbar-collapse collapse menuselect">
                                            <!-- Left nav -->
                                            <ul class="nav navbar-nav leftnav">
                                                <li>
                                                    <a href="<%=request.getParameter("levelPage")%>IndexLanguageController"

                                                            <% if (request.getParameter("activeselect") != null && request.getParameter("activeselect").equals("index.jsp")) { %>
                                                       class="activeee"
                                                            <%}%>

                                                    ><%=lang.get("6")%>
                                                    </a></li>
                                                <li><a href="home/product.html"><%=lang.get("7")%><span
                                                        class="caret"></span></a>
                                                    <ul class="dropdown-menu">
                                                        <li><a href="home/product.html"><%=lang.get("8")%> <span
                                                                class="caret"></span></a>
                                                            <ul class="dropdown-menu">
                                                                <li><a href="home/product.html"><%=lang.get("9")%>
                                                                </a></li>
                                                                <li><a href="home/product.html"><%=lang.get("10")%>
                                                                </a></li>
                                                                <li><a href="home/product.html"><%=lang.get("11")%>
                                                                </a></li>
                                                                <li><a href="home/product.html"><%=lang.get("12")%>
                                                                </a></li>
                                                            </ul>
                                                        </li>
                                                        <li><a href="home/product.html"><%=lang.get("13")%><span
                                                                class="caret"></span></a>
                                                            <ul class="dropdown-menu">
                                                                <li><a href="home/product.html"><%=lang.get("14")%>
                                                                </a></li>
                                                                <li><a href="home/product.html"><%=lang.get("15")%>
                                                                </a></li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </li>
                                                <li><a href="home/product2.html"><%=lang.get("16")%><span
                                                        class="caret"></span></a>
                                                    <ul class="dropdown-menu">
                                                        <li><a href="home/product2.html"><%=lang.get("17")%><span
                                                                class="caret"></span></a>
                                                            <ul class="dropdown-menu">
                                                                <li><a href="home/product2.html"><%=lang.get("9")%>
                                                                </a></li>
                                                                <li><a href="home/product2.html"><%=lang.get("10")%>
                                                                </a></li>
                                                                <li><a href="home/product2.html"><%=lang.get("11")%>
                                                                </a></li>
                                                                <li><a href="home/product2.html"><%=lang.get("12")%>
                                                                </a></li>
                                                            </ul>
                                                        </li>
                                                        <li><a href="home/product2.html"><%=lang.get("18")%><span
                                                                class="caret"></span></a>
                                                            <ul class="dropdown-menu">
                                                                <li><a href="home/product2.html"><%=lang.get("19")%>
                                                                </a></li>
                                                                <li><a href="home/product2.html"><%=lang.get("26")%>
                                                                </a></li>
                                                                <li><a href="home/product2.html"><%=lang.get("14")%>
                                                                </a></li>
                                                                <li><a href="home/product2.html"><%=lang.get("15")%>
                                                                </a></li>
                                                            </ul>
                                                        </li>
                                                    </ul>
                                                </li>
                                                <li><a href="home/contact.html"><%=lang.get("21")%>
                                                </a></li>
                                                <li><a href="home/about_US.html"><%=lang.get("22")%>
                                                </a></li>
                                                <li><a href="admin/home/login.html"><%=lang.get("23")%>
                                                </a></li>
                                            </ul>
                                        </div>
                                        <!--/.nav-collapse -->
                                    </div>
                                </div>
                            </div>
                        </section>
                        <!-- cart box -->
                        <div class="aa-cartbox">
                            <a class="aa-cart-link" href="home/cart.html">
                                <span class="fa fa-cart-arrow-down"></span>
                                <span class="aa-cart-title"><%=lang.get("27")%></span>
                                <span class="aa-cart-notify">2</span>
                            </a>
                            <div class="aa-cartbox-summary  xemnhanhgiohang">
                                <ul>
                                    <li>
                                        <a class="aa-cartbox-img" href="home/detailsProduct.html"><img
                                                src="<%=request.getParameter("levelPage")%>img/do/nu/12.jpg" alt="img"></a>
                                        <div class="aa-cartbox-info">
                                            <h4><a href="home/detailsProduct.html">Áo thun MST 1002</a></h4>
                                            <p>2 x 299,000 VND</p>
                                        </div>
                                        <a class="aa-remove-product" href="home/detailsProduct.html"><span
                                                class="fa fa-times"></span></a>
                                    </li>
                                    <li>
                                        <a class="aa-cartbox-img" href="home/detailsProduct.html"><img
                                                src="<%=request.getParameter("levelPage")%>img/do/nu/13.jpg" alt="img"></a>
                                        <div class="aa-cartbox-info">
                                            <h4><a href="home/detailsProduct.html">Áo thun kéo ASF 1209</a></h4>
                                            <p>3 x 129,000 VND</p>
                                        </div>
                                        <a class="aa-remove-product" href="#"><span class="fa fa-times"></span></a>
                                    </li>
                                    <li>
                      <span class="aa-cartbox-total-title">
                        <%=lang.get("30")%>
                      </span>
                                        <span class="aa-cartbox-total-price">
                        985,000 VND
                      </span>
                                    </li>
                                </ul>
                                <a class="aa-cartbox-checkout aa-primary-btn tinhtien"
                                   href="home/checkout.html"><%=lang.get("28")%>
                                </a>
                            </div>
                        </div>
                        <!-- / cart box -->
                        <!-- search box -->
                        <div class="aa-search-box">
                            <form action="">
                                <input type="text" name="" id="" placeholder="<%=lang.get("29")%>">
                                <button type="submit"><span class="fa fa-search"></span></button>
                            </form>
                        </div>
                        <!-- / search box -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- / header bottom  -->
</header>