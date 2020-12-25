<%@ page import="model.language.FooterLanguageModel" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 25/12/2020
  Time: 3:03 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<%
    //  Lấy ra ngôn ngữ hiện tại của session
    String language = (String) session.getAttribute("lang");

    //  Nếu session chưa có thì có nghĩa index mới đc mở lần đầu, cho mặc định là tiếng việt
    if (language == null) language = "vietnamese";

    //  Xong rồi lấy list ngôn ngữ từ model ra, vì trang này làm include nên ko gọi tới controller serverlet được
    Map<String, String> lang = FooterLanguageModel.getInstance().getList(language);

%>

<body>
<footer id="aa-footer">
    <!-- footer bottom -->
    <div class="aa-footer-top">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="aa-footer-top-area">
                        <div class="row">
                            <div class="col-md-3 col-sm-6">
                                <div class="aa-footer-widget">
                                    <h3><%=lang.get("1") + " "%> <span style="color:#ff7315;">TVT</span> SHOP</h3>
                                    <ul class="aa-footer-nav">
                                        <li><a href="#"><%=lang.get("2")%>
                                        </a></li>
                                        <li><a href="#"><%=lang.get("3")%>
                                        </a></li>
                                        <li><a href="#"><%=lang.get("4")%>
                                        </a></li>
                                        <li><a href="#"><%=lang.get("5")%>
                                        </a></li>

                                    </ul>
                                    <img src="<%=request.getParameter("levelPage")%>img/logosalenoti.png" alt=""
                                         style=" width: 130px;margin-top: 20px;">
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6">
                                <div class="aa-footer-widget">
                                    <div class="aa-footer-widget">
                                        <h3><%=lang.get("6")%>
                                        </h3>
                                        <ul class="aa-footer-nav">
                                            <li>
                                                <a href="<%=request.getParameter("levelPage")%>ChooseSizeLanguageController"><%=lang.get("7")%>
                                                </a></li>
                                            <li>
                                                <a href="<%=request.getParameter("levelPage")%>ShoppingGuideLanguageController"><%=lang.get("8")%>
                                                </a></li>
                                            <li><a href="home/membership_policy.html"><%=lang.get("9")%>
                                            </a></li>
                                            <li><a href="home/payment_policy.html"><%=lang.get("10")%>
                                            </a></li>
                                            <li><a href="home/guarantee.html"><%=lang.get("11")%>
                                            </a></li>
                                            <li><a href="home/check_orders.html"><%=lang.get("12")%>
                                            </a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6">
                                <div class="aa-footer-widget">
                                    <div class="aa-footer-widget">
                                        <h3><%=lang.get("13")%>
                                        </h3>
                                        <ul class="aa-footer-nav giaohang">
                                            <li><img src="<%=request.getParameter("levelPage")%>img/giaohangnhanh.webp"
                                                     alt=""></li>
                                            <li><img
                                                    src="<%=request.getParameter("levelPage")%>img/giaohangtietkiem.webp"
                                                    alt=""></li>
                                            <li><img src="<%=request.getParameter("levelPage")%>img/grap.webp" alt="">
                                            </li>

                                        </ul>
                                        <h3><%=lang.get("14")%>
                                        </h3>
                                        <ul class="aa-footer-nav giaohang">
                                            <li><img src="<%=request.getParameter("levelPage")%>img/vnpay.webp" alt="">
                                            </li>
                                            <li><img src="<%=request.getParameter("levelPage")%>img/momo.webp" alt="">
                                            </li>
                                            <li><img src="<%=request.getParameter("levelPage")%>img/cash.webp" alt="">
                                            </li>

                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6">
                                <div class="aa-footer-widget">
                                    <div class="aa-footer-widget">
                                        <h3><%=lang.get("15")%>
                                        </h3>
                                        <address>
                                            <p><%=lang.get("16")%>
                                            </p>
                                            <p><span class="fa fa-phone"></span>+1 212-982-4589</p>
                                            <p><span class="fa fa-envelope"></span>tvtshop@gmail.com</p>
                                        </address>
                                        <div class="aa-footer-social">
                                            <a href="#"><i class="fa fa-facebook"></i></a>
                                            <a href="#"><i class="fa fa-twitter"></i></a>
                                            <a href="#"><i class="fa fa-google"></i></a>
                                            <a href="#"><i class="fa fa-youtube"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- footer-bottom -->
    <div class="aa-footer-bottom">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="aa-footer-bottom-area">
                        <a>© 2020 TVTShop. <%=lang.get("17")%>
                        </a>
                        <a href=""><%=lang.get("18")%>
                        </a>
                        <a href=""><%=lang.get("19")%>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
