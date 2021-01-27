<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.product.*" %>
<%@ page import="beans.account.AccountCustomer" %>
<%@ page import="beans.rate.Rate" %>
<%@ page import="beans.rate.Star" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 3:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVT SHOP | Chi tiết sản phẩm</title>

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
    <script src="js/index.js"></script>


    <link rel="stylesheet" href="css/banner.css">
    <link rel="stylesheet" href="css/chitietsanpham.css">
    <link rel="stylesheet" href="css/hienthiform.css">
    <link rel="stylesheet" href="css/hienthiform2.css">
    <%
        AccountCustomer accountCustomer = (AccountCustomer)session.getAttribute("user");

        Product p = (Product) request.getAttribute("product");

//        ArrayList<ProductDetailInformation> pd = (ArrayList<ProductDetailInformation>) request.getAttribute("listSize");
//        System.out.println(pd);


//        HttpSession pdNow = request.getSession();
//        pdNow.setAttribute("pdNow",p.getPrice().getGia_sp());
//        System.out.println(pdNow.getAttribute("pdNow"));



    %>
</head>

<body>

<!-- wpf loader Two -->
<%--<jsp:include page="../share/_LayoutLoadAndScroll.jsp"></jsp:include>--%>

<jsp:include page="../share/_LayoutHeader.jsp"></jsp:include>

<%request.setCharacterEncoding("utf-8");%>
<jsp:include page="../share/_LayoutBanner.jsp">
    <jsp:param name="title" value="Chi tiết sản phẩm"/>
</jsp:include>
<!-- / catg header banner section -->

<!-- Xem nhanh modal -->
<div class="modal fade" id="quick-view-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <div class="row">
                    <!-- Modal view slider -->
                    <div class="col-md-6 col-sm-6 col-xs-12 viewnhanhcol">
                        <div class="aa-product-view-slider viewnhanhcol">
                            <div class="simpleLens-gallery-container viewnhanhcol contentviewnhanh" id="demo-1">
                                <div class="simpleLens-container">
                                    <div class="simpleLens-big-image-container viewnhanhcol">
                                        <a class="simpleLens-lens-image" data-lens-image="../img/modal1.png">
                                            <img src="../img/modal1.png" class="simpleLens-big-image">
                                        </a>
                                    </div>
                                </div>
                                <div class="simpleLens-thumbnails-container div2scl">
                                    <a href="#" class="simpleLens-thumbnail-wrapper"
                                       data-lens-image="../img/modal1.png" data-big-image="../img/modal1.png">
                                        <img src="../img/modal1.png">
                                    </a>
                                    <a href="#" class="simpleLens-thumbnail-wrapper"
                                       data-lens-image="../img/modal2.png" data-big-image="../img/modal2.png">
                                        <img src="../img/modal2.png">
                                    </a>

                                    <a href="#" class="simpleLens-thumbnail-wrapper"
                                       data-lens-image="../img/modal4.png" data-big-image="../img/modal4.png">
                                        <img src="../img/modal4.png">
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Modal view content -->
                    <div class="col-md-6 col-sm-6 col-xs-12">
                        <div class="aa-product-view-content">
                            <h3>Váy ngắn cao cấp <span style="color: #ff7315"> MSY</span></h3>
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
                            <p>Váy ngắn cao cấp MSY TVT Shop với form ôn vừa vặn và dễ mặc dành
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
                                        <span>Danh mục: </span><a href="#">Váy cao cấp SPY</a>
                                    </p>
                                </div>
                            </div>
                            <div class="aa-prod-view-bottom">
                                <button onclick="addCart()"  class="aa-add-to-cart-btn addTocardViewQuick">
                                    <span
                                        class="fa fa-shopping-cart">
                                    </span>Thêm vào giỏ hàng
                                </button>
                                <a href="#" class="aa-add-to-cart-btn"><span class="fa fa-eye"></span>Xem chi
                                    tiết</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- / Xem nhanh modal -->

<!-- main-->
<div class="mainchitiet">
    <div class="dpcontent">

        <div class="dpheader">
            <% if(p.getGioi_tinh() == 0){%>
            <p>Trang chủ <i class="fa fa-circle"></i> Nữ
                <% } else {%>
            <p>Trang chủ <i class="fa fa-circle"></i> Nam
            <%}%>
                <i class="fa fa-circle"></i><%= p.getCategoryName()%> <i
                    class="fa fa-circle"></i></p>
            <p><%= p.getTen_sp()%></p>
        </div>

        <div class="dpbody">
            <div class="dpleft">
                <div class="dpmainimg">
<%--                    <% ArrayList<String> list = (ArrayList<String>) request.getAttribute("colors");%>--%>
<%--                    <% ArrayList<String> st = (ArrayList<String>) request.getAttribute("imgs");%>--%>
                    <div>
                        <% for(int i = 0; i<4;i++){
//                            if(st != null){
                        %>
                        <img src="<%=p.getListIMG().get(i).getLink_hinh()%>" alt="" id="img1">
                        <%}%>

<%--                        <% break; } else{%>--%>
<%--                        <img src="" alt="" id="img1">--%>
<%--                        <%}}%>--%>
                        <p>Mã sản phẩm: <%= p.getMa_sp()%></p>
                    </div>
                        <% for(ProductColor c : p.getListColor()){
                        %>
                    <img src="<%=c.getLink_hinh()%>" alt="" id="img2">
                    <% }%>

                </div>
                <div>
                    <div class="dplistitem" id="dplistitem">

                        <%
//                            if(st != null){
                            for(ProductImage ss : p.getListIMG()){
                                System.out.println(ss);
                                %>
                        <div class="dpitem">
                            <div onclick="doiHinhChinh(this)">
                                <img src="<%=ss.getLink_hinh()%>" alt="" id="doiHinhChinh1">
                            </div>
                            <img src="<%=ss.getLink_hinh()%>" alt="">
                        </div>
                        <%}%>
<%--                       <%}} else {%>--%>
<%--                        <div class="dpitem">--%>
<%--                            <div onclick="doiHinhChinh(this)">--%>
<%--                                <img src="<%=st%>" alt="" id="doiHinhChinh1">--%>
<%--                            </div>--%>
<%--                            <img src="<%=st%>" alt="">--%>
<%--                        </div>--%>
<%--                        <%}%>--%>
<%--                        <div class="dpitem">--%>
<%--                            <div onclick="doiHinhChinh(this)">--%>
<%--                                <img src="../img/product/dp2.webp" alt="" id="doiHinhChinh2">--%>
<%--                            </div>--%>
<%--                            <img src="../img/product/dp2.webp" alt="">--%>
<%--                        </div>--%>
<%--                        <div class="dpitem">--%>
<%--                            <div onclick="doiHinhChinh(this)">--%>
<%--                                <img src="../img/product/dp3.webp" alt="" id="doiHinhChinh3">--%>
<%--                            </div>--%>
<%--                            <img src="../img/product/dp3.webp" alt="">--%>
<%--                        </div>--%>
<%--                        <div class="dpitem">--%>
<%--                            <div onclick="doiHinhChinh(this)">--%>
<%--                                <img src="../img/product/dp4.webp" alt="" id="doiHinhChinh4">--%>
<%--                            </div>--%>
<%--                            <img src="../img/product/dp4.webp" alt="">--%>
<%--                        </div>--%>
                    </div>
                </div>
                <div class="nextdplistitem" style="display: none">
                    <label id="nextdp1" onclick="leftnextdplistitem()"></label>
                    <label id="nextdp2" onclick="rightnextdplistitem()"></label>
                </div>
                <div>
                    <p><i class="fa fa-circle"></i>
                        Người mẫu (Chiều cao 1m65) đang mặc size M
                    </p>
                </div>
            </div>

            <div class="dpright">
                <p class="hangsanxuat"><%=p.getHang_san_xuat().getTen_hsx()%></p>
                <p class="tensanpham"><%=p.getTen_sp()%></p>
                <div class="giasanphamgiamgia">
                    <%if(p.getPriceSale().getGia_sp_km() != 0){%>
                    <span><del><%=p.getPrice().getGia_sp()%> VND</del></span>
                    <span>(GIẢM GIÁ <%= Math.round(((p.getPrice().getGia_sp()-p.getPriceSale().getGia_sp_km())/p.getPrice().getGia_sp())*100) %>%)</span>
                <%}%>
                </div>
                <%if(p.getPriceSale().getGia_sp_km() != 0){%>
                <p class="giasanphamgiachinh"><%=p.getPriceSale().getGia_sp_km()%> VND</p>
                <%} else{%>
                <p class="giasanphamgiachinh"><%=p.getPrice().getGia_sp()%> VND</p>
                <%}%>
                <p class="thongtinghichu">(Giá có thể tăng lên khi thanh toán vì có phí vận chuyển)</p>
                <div class="guidecolor">
                    <p>CHỌN MÀU</p>
<%--                    <% for(ProductColor pc : p.getListColor()){%>--%>
<%--                    <span class="colordpdx" id="colordpdx"><%=pc.getTen_mau()%></span>--%>
<%--                    <%}%>--%>
                    <%
                        for(ProductColor pc : p.getListColor()){
//              vv              if(request.getParameter("ma_mau").equals(pc.getMa_mau())){
                    %>
                    <span class="colordpdx" id="colordpdx"><%=pc.getTen_mau()%></span>
                    <% break;}%>
<%--                    <%} else {%>--%>

<%--          vv          <%}}%>--%>
                </div>
                <div class="selectcolor">

                    <%for(int i = 0; i < p.getListColor().size();i++){
                        if(i==0){
                    %>
                    <input type="radio" name="color" id="color<%=(i+1)%>" style="display: none;"></a>
                    <%}
                    else {%>
                    <input type="radio" name="color" id="color<%=(i+1)%>" style="display: none;"></a>
                    <%}}%>
<%--                    <%} else {%>--%>
<%--              vv      <input type="radio" name="color" id="color<%=(i+1)%>" style="display: none;">--%>
<%--                    <%}}%>--%>

<%--                    <label for="color1" class="labelcolor1" onclick="damXanh()">--%>
<%--                        <div><img src="../img/product/damxanh.webp" alt=""></div>--%>
<%--                    </label>--%>
<%--                    <label for="color2" class="labelcolor2" onclick="xanhNhat()">--%>
<%--                        <div><img src="../img/product/xanhnhat.webp" alt=""></div>--%>
<%--                    </label>--%>


                    <%for(int i = 0; i<p.getListColor().size();i++){%>
                    <label onclick="setmamau(this)" id="<%=p.getListColor().get(i).getMa_mau()%>" for="color<%=(i+1)%>" class="labelcolor<%=(i+1)%>">
                      <div> <img src="<%=p.getListColor().get(i).getLink_hinh()%>"></div>
                    </label>
                    <%}%>


<%--                    <span class="colordpdx" id="colordpdx">Đậm xanh</span>--%>
<%--                    <span class="colordpxn" id="colordpxn">Xanh nhạt</span>--%>
                </div>
                <div class="guidesize">
                    <p>CHỌN SIZE</p>
                    <a href="chooseSize.jsp">Hướng dẫn chọn size</a>
                </div>
                <div class="selectsize">
                    <%
                        for(int i = 0; i < p.getListSize().size();i++){
                        if(i==0){
                    %>
                    <input type="radio" name="sizeP" id="size<%=(i+1)%>" style="display: none;">
                    <% }else{%>
<%--                    <%}%>--%>
                    <input type="radio" name="sizeP" id="size<%=(i+1)%>" style="display: none;" >
                   <%}}%>

<%--                    <input type="hidden" name="ma_mau" value="<%=request.getParameter("ma_mau")%>">--%>

<%--                    <% for(int i = 0; i < p.getListSize().size();i++){%>--%>
<%--                    <%if(request.getParameter("ma_mau")!=null){%>--%>
<%--                    <label for="size<%=(i+1)%>" class="labelsize<%=(i+1)%>"><div><a href="sLoadNumberController?idProduct=<%=p.getMa_sp()%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%= p.getListSize().get(i).getMa_size()%>"> <%=p.getListSize().get(i).getTen_size()%></a></div></label>--%>
<%--                    <%}}%>--%>
                    <% for(int i = 0; i < p.getListSize().size();i++){%>
                    <label onclick="setmasize(this)" id="<%=p.getListSize().get(i).getMa_size()%>" for="size<%=(i+1)%>" class="labelsize<%=(i+1)%>"><div> <%=p.getListSize().get(i).getTen_size()%></div></label>
                    <%}%>
                    <%--                   < <%}}%>--%>
<%--                                        <% int rest = (Integer) request.getAttribute("rest");%>--%>
<%--                    <% for(int i = 0;i < pd.size();i++){--%>
<%--                        if(pd.get(i).getSo_luong_con_lai()==0){--%>
<%--           vv                 continue;--%>
<%--                        }else{--%>
<%--                    %>--%>
<%--                    <label for="size<%=(i+1)%>" class="labelsize<%=(i+1)%>"><a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=pd.get(i).getMa_size()%>&type=<%=request.getParameter("type")%>&page=<%=request.getParameter("page")%>"> <%=p.getListSize().get(i).getTen_size()%></a></label>--%>
<%--                    <%}}%>--%>

<%--                    <label for="size2" class="labelsize2">M</label>--%>
<%--                    <label for="size3" class="labelsize3">L</label>--%>
<%--                    <label for="size4" class="labelsize4">XL</label>--%>
<%--                    <label for="size5" class="labelsize5">XXL</label>--%>
                </div>
<%--                <% if(rest != 0){%>--%>
<%--                <p class="dpconlai">Còn lại <%= rest%> sản phẩm</p>--%>
<%--                <%}%>--%>
                <div class="inputsl">
                    <button type="button" onclick="subtocard3()"><span>-</span></button>
                    <input type="hidden" name="ma_sp" value="<%=p.getMa_sp()%>">
                    <input type="text" value="1" id="sladdtocard2" name="so_luong">
<%--                    <input type="hidden" name="mau_sp" value="<%=request.getParameter("ma_mau")%>">--%>
<%--      vv              <input type="hidden" name="ma_size" value="<%=request.getParameter("ma_size")%>">--%>

                    <button type="button" onclick="plustocard3()"><span>+</span></button>
                </div>
                <div class="wlaatc">

                    <button onclick="themvaoyeuthich()"><i class="fa fa-heart"></i> YÊU THÍCH</button>

                        <button onclick="addCart()" >
                            <i class=" fa fa-cart-plus"></i> THÊM VÀO GIỎ HÀNG
                        </button>

<%--                   <a href="AddCartController?ma_sp=<%=p.getMa_sp()%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>&so_luong=<%=request.getParameter("so_luong")%>"> <button ><i class=" fa fa-cart-plus"></i> THÊM VÀO GIỎ HÀNG</button></a>--%>
                </div>

            </div>
        </div>
    </div>

    <div class="linesesstion"></div>

    <div class="dtp">
        <p class="dtptitle">Thông tin sản phẩm</p>
        <%for(String s : p.getGioi_thieu_sp().getGioi_thieu()){%>
        <p class="dtpinfor1"><%=s%></p>
        <%}%>
        <p class="dtptitle">Vật liệu & sản xuất</p>
        <ul>
            <%for(String ps : p.getCau_tao_sp().getCau_tao()){%>
            <li><%=ps%></li>
            <%}%>

        </ul>
        <p class="dtptitle">Phù hợp cho</p>
        <ul>
            <%for(ProductInfomation pi : p.getListInfo()){%>
            <li><%=pi.getThong_tin()%></li>
            <%}%>

        </ul>
        <p class="dtptitle">Cung cấp bởi</p>
        <p class="hangsanxuat"><%=p.getHang_san_xuat().getTen_hsx()%></p>
        <ul>
            <%for(String s : p.getHang_san_xuat().getThong_tin()){%>
            <li><%=s%></li>
            <%}%>
        </ul>
    </div>

    <div class="linesesstion"></div>
    <div class="danhgiasanpham">
        <%if(accountCustomer != null){%>
        <%System.out.println(accountCustomer.getFullName());%>
        <div class="danhgia" style="display: block !important;" id="danhgia">
            <p class="dgsptitle">Đánh giá sản phẩm này</p>
            <p>Cho người khác biết suy nghĩ của bạn</p>
            <div>
                <i class="fa fa-star-o"></i>
                <i class="fa fa-star-o"></i>
                <i class="fa fa-star-o"></i>
                <i class="fa fa-star-o"></i>
                <i class="fa fa-star-o"></i>
            </div>
            <p onclick="vietdanhgia()">Viết đánh giá</p>



        </div>
        <div id="danhgia2" style="display: block !important;">
            <p class="dgsptitle">Bài đánh giá của bạn</p>
            <div>
                <div class="danhgia2infor">
                    <div>
                        <div>
                            <img src="../img/product/avatar7.jpg" alt="">
                        </div>
                        <div class="danhgia2infor2">
                            <p><%=accountCustomer.getFullName()%></p>
                            <div>
                                <div>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star-half"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <p>5/12/2020</p>
                </div>
                <div onclick="report(this)" class="danhgia2select">
                    <i class="fa fa-circle"></i>
                    <i class="fa fa-circle"></i>
                    <i class="fa fa-circle"></i>
                    <div class="report" onclick="removedanhgia()">
                        <p>Xóa</p>
                    </div>
                    <input type="checkbox" style="display: none;">
                </div>
            </div>
            <p>Cùng 1 size nhưng quần màu xanh mặc chật hơn quần màu đen, không thoải mái mặc dù quần vẫn có co
                giản, ống quần hơi nhỏ
                Shop giao nhanh, về giá cả săn sale nên cũng ok vớ tầm giá</p>
            <p onclick="vietdanhgia()">Chỉnh sửa bài đánh giá của bạn</p>
        </div>
        <%}%>
        <div class="linexephang">
        </div>
<%--        tính sao trung bình--%>

<%--       <%Star star = (Star) request.getAttribute("star");%>--%>

        <div class="xephangdanhgia">
            <p class="dgsptitle">Xếp hạng đánh giá</p>
            <div class="xephang">
                <div class="xephangleft">
<%--                    <p><%=star.getAvgStar()%></p>--%>
                    <div>
                        <div>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                        </div>
                        <div>
<%--                            <% if(star.getAvgStar() % 2 == 0 || star.getAvgStar() % 2 <= 0.4){--%>
<%--                                for(int i = 0;i < (int)star.getAvgStar();i++){--%>
<%--                            %>--%>
<%--                            <i class="fa fa-star"></i>--%>
<%--                            <%}} else {--%>
<%--                                for(int i = 0;i < (int)star.getAvgStar();i++){--%>
<%--                            %>--%>
<%--                            <i class="fa fa-star"></i>--%>
<%--                            <%}%>--%>
<%--                            <i class="fa fa-star-half"></i>--%>
<%--                            <%}%>--%>
                        </div>
                    </div>
<%--                    <p><%=star.getSumRate()%> đánh giá</p>--%>
                </div>
                <div class="xephangright">
                    <div class="xephangrightitem">
                        <p>5</p>
                        <div>
                            <div></div>
                            <div class="div80pt"></div>
                        </div>
                    </div>
                    <div class="xephangrightitem">
                        <p>4</p>
                        <div>
                            <div></div>
                            <div class="div10pt"></div>
                        </div>
                    </div>
                    <div class="xephangrightitem">
                        <p>3</p>
                        <div>
                            <div></div>
                            <div class="div5pt"></div>
                        </div>
                    </div>
                    <div class="xephangrightitem">
                        <p>2</p>
                        <div>
                            <div></div>
                            <div class="div5pt"></div>
                        </div>
                    </div>
                    <div class="xephangrightitem">
                        <p>1</p>
                        <div>
                            <div></div>
                            <div class="div10pt"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="linexephang"></div>

<%--        <div class="bolocbinhluan">--%>
<%--            <% String a = request.getParameter("type");%>--%>


<%--            <% if(a.equals("")){%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button class="activeboloc">Tất cả</button></a>--%>
<%--            <%} else {%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button>Tất cả</button></a>--%>
<%--            <%}%>--%>


<%--               <% if(a.equals("tich_cuc")){%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=tich_cuc&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button class="activeboloc">Tích cực</button></a>--%>
<%--            <%} else {%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=tich_cuc&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button>Tích cực</button></a>--%>
<%--            <%}%>--%>

<%--            <% if(a.equals("tieu_cuc")){%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=tieu_cuc&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button class="activeboloc">Tiêu cực</button></a>--%>
<%--            <%} else {%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=tieu_cuc&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button>Tiêu cực</button></a>--%>
<%--            <%}%>--%>

<%--&lt;%&ndash;            <% for (int i = 5; i >=1 ; i--){%>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <% if(a.equals(i)){%>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <a href="LoadDetailProductController?idProduct=<%=p.getMa_sp()%>&type=<%=i%>&page=<%= request.getParameter("page")%>"><button  style="border: 1px solid #fff1e8 !important;&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                                                        background-color: #fff1e8 !important;&ndash;%&gt;--%>
<%--&lt;%&ndash;                                                                                color: #ff7315 !important;"><%=i%> <i class="fa fa-star"></i></button></a>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <%} else {%>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <a href="LoadDetailProductController?idProduct=<%=p.getMa_sp()%>&type=<%=i%>&page=<%= request.getParameter("page")%>"><button><%=i%> <i class="fa fa-star"></i></button></a>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <%}}%>&ndash;%&gt;--%>
<%--            <% if(a.equals("5")){%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=5&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button class="activeboloc">5<i class="fa fa-star"></i></button></a>--%>
<%--            <%} else {%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=5&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button>5<i class="fa fa-star"></i></button></a>--%>
<%--            <%}%>--%>

<%--            <% if(a.equals("4")){%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=4&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button class="activeboloc">4<i class="fa fa-star"></i></button></a>--%>
<%--            <%} else {%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=4&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button>4<i class="fa fa-star"></i></button></a>--%>
<%--            <%}%>--%>

<%--            <% if(a.equals("3")){%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=3&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button class="activeboloc">3<i class="fa fa-star"></i></button></a>--%>
<%--            <%} else {%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=3&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button>3<i class="fa fa-star"></i></button></a>--%>
<%--            <%}%>--%>

<%--            <% if(a.equals("2")){%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=2&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button class="activeboloc">2<i class="fa fa-star"></i></button></a>--%>
<%--            <%} else {%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=2&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button>2<i class="fa fa-star"></i></button></a>--%>
<%--            <%}%>--%>

<%--            <% if(a.equals("1")){%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=1&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button class="activeboloc">1<i class="fa fa-star"></i></button></a>--%>
<%--            <%} else {%>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=1&page=<%= request.getParameter("page")%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button>1<i class="fa fa-star"></i></button></a>--%>
<%--            <%}%>--%>


<%--        </div>--%>
<%--        <input type="hidden" name="page" value="1">--%>
<%--        <input type="hidden" name="type" value="">--%>


<%--        load danh sách đánh giá--%>
<%--        <%  ArrayList<Rate> lists = (ArrayList<Rate>) request.getAttribute("listRate");%>--%>
<%--        <% for(Rate r : lists){%>--%>
<%--        <div class="binhluanitem">--%>
<%--            <div class="headerbinhluanitem">--%>
<%--                <div>--%>
<%--                    <div>--%>
<%--                        <img src="<%=r.getImgCustomer()%>" alt="">--%>
<%--                    </div>--%>
<%--                    <p><%= r.getNameCustomer()%></p>--%>
<%--                </div>--%>
<%--                <div onclick="report(this)">--%>
<%--                    <i class="fa fa-circle"></i>--%>
<%--                    <i class="fa fa-circle"></i>--%>
<%--                    <i class="fa fa-circle"></i>--%>
<%--                    <div class="report">--%>
<%--                        <p>Báo cáo</p>--%>
<%--                    </div>--%>
<%--                    <input type="checkbox" style="display: none;">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="inforbinhluanitem">--%>
<%--                <div>--%>
<%--                    <div>--%>
<%--                        <i class="fa fa-star"></i>--%>
<%--                        <i class="fa fa-star"></i>--%>
<%--                        <i class="fa fa-star"></i>--%>
<%--                        <i class="fa fa-star"></i>--%>
<%--                        <i class="fa fa-star"></i>--%>
<%--                    </div>--%>

<%--                    <div>--%>
<%--                     <% for(int i = 1 ; i <= r.getNumberStar();i++){%>--%>
<%--                        <i class="fa fa-star"></i>--%>
<%--                        <%}%>--%>
<%--                    </div>--%>


<%--                </div>--%>
<%--                <p><%=r.getDateCreated()%></p>--%>
<%--            </div>--%>
<%--            <p><%=r.getContent()%></p>--%>
<%--        </div>--%>

<%--        <div class="linexephang"></div>--%>
<%--        <%}%>--%>


    </div>

<%--    <div class="dpnextpage">--%>
<%--        <%--%>
<%--            int pageNow = Integer.parseInt(request.getParameter("page"));--%>
<%--            int numPage = (int)request.getAttribute("numPage");--%>
<%--        %>--%>
<%--        <% if(pageNow <= numPage && pageNow > 1){%>--%>
<%--        <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=<%=request.getParameter("type")%>&page=<%= Integer.parseInt(request.getParameter("page")) -1%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button><i class="fa fa-caret-left"></i></button></a>--%>
<%--        <%} else{%>--%>
<%--        <button><i class="fa fa-caret-left"></i></button>--%>
<%--        <%}%>--%>

<%--        <ul>--%>

<%--            <% for(int i = 1; i <= numPage;i++){--%>
<%--                if(i==pageNow){--%>
<%--            %>--%>
<%--            <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=<%=request.getParameter("type")%>&page=<%=i%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><li style="background-color: #ff6600"><%=i%></li></a>--%>
<%--            <%} else{%>--%>
<%--            <li><%=i%></li>--%>
<%--            <%}}%>--%>
<%--        </ul>--%>

<%--        <% if(pageNow < numPage && pageNow >= 1){%>--%>
<%--        <a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&type=<%=request.getParameter("type")%>&page=<%= Integer.parseInt(request.getParameter("page")) -1%>&ma_mau=<%=request.getParameter("ma_mau")%>&ma_size=<%=request.getParameter("ma_size")%>"><button><i class="fa fa-caret-right"></i></button></a>--%>
<%--        <%} else{%>--%>
<%--        <button><i class="fa fa-caret-right"></i></button>--%>
<%--        <%}%>--%>
<%--    </div>--%>

    <div class="linesesstion"></div>

</div>

<!-- San pham lien quan-->
<section id="aa-popular-category">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="aa-popular-category-area">
                        <!-- start prduct navigation -->
                        <ul class="nav nav-tabs aa-products-tab">
                            <li class="active"><a href="#popular" data-toggle="tab">Sản phẩm liên quan</a></li>
                            <li><a href="#featured" data-toggle="tab">Có thể bạn sẽ thích</a></li>
                        </ul>
                        <!-- Tab panes -->
                        <div class="tab-content">
                            <!-- Start men popular category -->

<%--                            <div class="tab-pane fade in active" id="popular">--%>
<%--                                <ul class="aa-product-catg aa-popular-slider">--%>
<%--                                    <!-- start single product item -->--%>
<%--                                    <% ArrayList<Product> pds = (ArrayList<Product>) request.getAttribute("listRalated");%>--%>

<%--                                    <%for(Product pr : pds){%>--%>
<%--                                    <li>--%>
<%--                                        <figure>--%>
<%--                                            <a class="aa-product-img" href="detailsProduct.html"><img--%>
<%--                                                    src="<%=pr.getListIMG().get(0).getLink_hinh()%>" alt="polo shirt img"></a>--%>
<%--                                            <a class="aa-add-card-btn" href="cart.html"><span--%>
<%--                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>--%>
<%--                                            <figcaption>--%>
<%--                                                <h4 class="aa-product-title"><a href="detailsProduct.html"><%=pr.getTen_sp()%>></a></h4>--%>
<%--                                                <% if(pr.getPriceSale().getGia_sp_km() != 0){%>--%>
<%--                                                <span class="aa-product-price sprice"><%=pr.getPriceSale().getGia_sp_km()%>> VND</span><span--%>
<%--                                                    <%}%>--%>
<%--                                                    class="aa-product-price"><del><%=pr.getPrice().getGia_sp()%>--%>
<%--                                                            VND</del></span>--%>
<%--                                            </figcaption>--%>
<%--                                        </figure>--%>
<%--                                        <div class="aa-product-hvr-content">--%>
<%--                                            <a href="wishlist.html" data-toggle="tooltip" data-placement="top"--%>
<%--                                               title="Thêm vào yêu thích"><span class="fa fa-heart"></span></a>--%>
<%--                                            <a href="#" data-toggle2="tooltip" data-placement="top"--%>
<%--                                               title="Xem nhanh" data-toggle="modal"--%>
<%--                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>--%>
<%--                                        </div>--%>
<%--                                        <!-- product badge -->--%>
<%--                                        <span class="aa-badge aa-sale" href="#">Giảm giá!</span>--%>
<%--                                    </li>--%>
<%--                                    <!-- start single product item -->--%>
<%--                                    <%}%>--%>
<%--                                </ul>--%>
<%--                            </div>--%>
<%--                            </div>--%>
<%--                            --%>

                            <!-- / popular product category -->

                            <!-- start featured product category -->
                            <div class="tab-pane fade" id="featured">
                                <ul class="aa-product-catg aa-featured-slider">
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="detailsProduct.html"><img
                                                    src="../img/do/nu/17.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="cart.html"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="detailsProduct.html">Áo
                                                    Len Nữ
                                                    Phối Sọc Ngang WOS 2002</a></h4>
                                                <span class="aa-product-price sprice">429,000 VND</span><span
                                                    class="aa-product-price"><del>559,000
                                                            VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="wishlist.html" data-toggle="tooltip" data-placement="top"
                                               title="Thêm vào yêu thích"><span class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top"
                                               title="Xem nhanh" data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-sale" href="#">Giảm giá!</span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="detailsProduct.html"><img
                                                    src="../img/do/nu/18.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="cart.html"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="detailsProduct.html">Áo
                                                    Len Nữ
                                                    Phối Màu Zigzag WOS 2001</a></h4>
                                                <span class="aa-product-price sprice">429,000 VND</span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="wishlist.html" data-toggle="tooltip" data-placement="top"
                                               title="Thêm vào yêu thích"><span class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top"
                                               title="Xem nhanh" data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-sold-out" href="#">Hết hàng!</span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="detailsProduct.html"><img
                                                    src="../img/do/nu/19.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="cart.html"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                        </figure>
                                        <figcaption>
                                            <h4 class="aa-product-title"><a href="detailsProduct.html">Quần Thun
                                                Nữ
                                                Form Slim Feeling Inside WTS 2022</a></h4>
                                            <span class="aa-product-price sprice">219,000 VND</span>
                                        </figcaption>
                                        <div class="aa-product-hvr-content">
                                            <a href="wishlist.html" data-toggle="tooltip" data-placement="top"
                                               title="Thêm vào yêu thích"><span class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top"
                                               title="Xem nhanh" data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-sold-out" href="#">Hết hàng!</span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="detailsProduct.html"><img
                                                    src="../img/do/nu/20.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="cart.html"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="detailsProduct.html">Áo
                                                    Thun
                                                    Nữ WTS 2021</a></h4>
                                                <span class="aa-product-price sprice">219,000 VND</span><span
                                                    class="aa-product-price"><del>339,000
                                                            VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="wishlist.html" data-toggle="tooltip" data-placement="top"
                                               title="Thêm vào yêu thích"><span class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top"
                                               title="Xem nhanh" data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="#"><img src="../img/do/nu/21.jpg"
                                                                                    alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="#"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="#">Áo Thun Nữ Form Slim
                                                    Sunshine WTS 2019</a></h4>
                                                <span class="aa-product-price sprice">219,000 VND</span><span
                                                    class="aa-product-price"><del>339,000
                                                            VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="#" data-toggle="tooltip" data-placement="top"
                                               title="Thêm vào yêu thích"><span class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top"
                                               title="Xem nhanh" data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="#"><img src="../img/do/nu/22.jpg"
                                                                                    alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="#"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
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
                                               title="Thêm vào yêu thích"><span class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top"
                                               title="Xem nhanh" data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-hot" href="#">Mới!</span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="#"><img src="../img/do/nu/23.jpg"
                                                                                    alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="#"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
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
                                               title="Thêm vào yêu thích"><span class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top"
                                               title="Xem nhanh" data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-hot" href="#">Mới!</span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="#"><img src="../img/do/nu/24.jpg"
                                                                                    alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="#"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="#">Áo Thun Nữ The North
                                                    Land
                                                    WTS 2024</a></h4>
                                                <span class="aa-product-price sprice">229,000 VND</span><span
                                                    class="aa-product-price"><del>299,000
                                                            VND</del></span>
                                            </figcaption>
                                        </figure>
                                        <div class="aa-product-hvr-content">
                                            <a href="#" data-toggle="tooltip" data-placement="top"
                                               title="Thêm vào yêu thích"><span class="fa fa-heart"></span></a>

                                            <a href="#" data-toggle2="tooltip" data-placement="top"
                                               title="Xem nhanh" data-toggle="modal"
                                               data-target="#quick-view-modal"><span class="fa fa-eye"></span></a>
                                        </div>
                                        <!-- product badge -->
                                        <span class="aa-badge aa-sale" href="#">Giảm giá!</span>
                                    </li>
                                </ul>
                            </div>
                            <!-- / featured product category -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!--Viết đánh giá-->
<% if(accountCustomer != null){%>
<div class="vietdanhgia" id="vietdanhgia">
    <div class="hiddenvdg" onclick="closedanhgia()"></div>
    <div class="formvietdanhgia">
        <div class="headerformvietdanhgia">
            <i class="fa fa-pencil-square-o"></i>
            <div>
                <h3>Đánh giá sản phẩm</h3>
                <input type="hidden" name="idProduct" value="<%= p.getMa_sp()%>">
                <p><%=p.getTen_sp()%>></p>
            </div>
        </div>
        <div style="background: white;">
            <div class="contentformvietdanhgia">
                <div>
                    <img src="<%=accountCustomer.getAvatar()%>" alt="">
                </div>
                <div>
                    <h3><%=accountCustomer.getFullName()%></h3>
                    <p>
                        Đánh giá của bạn sẽ được công khai cho mọi người cùng thấy</p>
                </div>
            </div>
            <div class="vdgstar">
                <%for(int i = 1 ;i <=5;i++){%>
                <label for="vote">
                    <input id="vote" name="vote" value ="<%=i%>" type="hidden"><i class="fa fa-star-o"></i>
                </label>
                <%}%>
<%--                <input type="hidden" name =><i class="fa fa-star-o" name="vote" value="2"></i>--%>
<%--                <i class="fa fa-star-o" name="vote" value="3"></i>--%>
<%--                <i class="fa fa-star-o" name="vote" value="4"></i>--%>
<%--                <i class="fa fa-star-o" name="vote" value="5"></i>--%>
            </div>
            <textarea placeholder="Mô tả đánh giá của bạn về sản phẩm (không bắt buộc)"></textarea>
            <div class="vdgsubmit">
                <button onclick="closedanshgia()">Hủy</button>

                <button onclick="dangdanhgia()">Đăng</button>
            </div>
        </div>
    </div>
</div>
<%--<div id="addCartStatus">--%>
<%--    <div class="changepassword" id="changepassword">--%>
<%--        <div class="hiddenchangepassword" onclick="gobackpassword()"></div>--%>
<%--        <div class="mainchangepassword">--%>
<%--            <p class="changepasswordtitle"><i class="fa fa-cogs"></i>TVT Shop</p>--%>
<%--            <div class="changepasswordsuccess" id="changepasswordsuccess">--%>


<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>


<%--<div id="addCartStatus2">--%>
<%--    <div class="changepassword" id="changepassword2">--%>
<%--        <div class="hiddenchangepassword" onclick="gobackpassword()"></div>--%>
<%--        <div class="mainchangepassword">--%>
<%--            <p class="changepasswordtitle"><i class="fa fa-cogs"></i>TVT Shop</p>--%>
<%--            <div class="changepasswordsuccess" id="changepasswordsuccess2">--%>
<%--                <p> Vui lòng chọn đầy đủ thông tin để thêm sản phẩm vào giỏ hàng </p>--%>
<%--                <button onclick="gobackpassword()">Trở về--%>
<%--                </button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%}%>



<div id="addCartStatus2" style="display:none; z-index: 100000;position: relative">
    <div class="changepassword" id="changepassword2">
        <div class="hiddenchangepassword" onclick="gobackpassword()"></div>
        <div class="mainchangepassword">
            <p class="changepasswordtitle"><i class="fa fa-cogs"></i>TVT Shop</p>
            <div class="changepasswordsuccess" id="changepasswordsuccess2">
                <p> Vui lòng chọn đầy đủ thông tin để thêm sản phẩm vào giỏ hàng </p>
                <button onclick="gobackpassword()">Trở về
                </button>
            </div>
        </div>
    </div>
</div>
<div id="addCartStatus" style="display:none; z-index: 100000;position: relative">
    <div class="changepassword" id="changepassword">
        <div class="hiddenchangepassword" onclick="gobackpassword()"></div>
        <div class="mainchangepassword">
            <p class="changepasswordtitle"><i class="fa fa-cogs"></i>TVT Shop</p>
            <div class="changepasswordsuccess" id="changepasswordsuccess">


            </div>
        </div>
    </div>
</div>

<input type="hidden" name="" id="layma_sanphamthemvaogiohang" value="<%=request.getParameter("idProduct")%>">
<input type="hidden" name="" id="layma_sizethemvaogiohang" value="">
<input type="hidden" name="" id="layma_mauthemvaogiohang" value="">
<input type="hidden" name="" id="soluongsp" value="1">

<!--End main-->

<jsp:include page="../share/_LayoutChatBox.jsp"></jsp:include>

<!-- footer -->
<jsp:include page="../share/_LayoutFooter.jsp"></jsp:include>
<!-- / footer -->

</body>

</html>


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

<script src="js/chitietsanpham.js"></script>

<script>


    function addCart(){

        var ma_sp = $("#layma_sanphamthemvaogiohang").val();
        var ma_size =  $("#layma_sizethemvaogiohang").val();
        var ma_mau = $("#layma_mauthemvaogiohang").val();
        var soluong = $("#soluongsp").val();

        // console.log(ma_sp);
        // console.log(ma_size);
        // console.log(ma_mau);
        // console.log(soluong);
        document.getElementById("addCartStatus2").style.display = "none";
        document.getElementById('changepassword2').style.transform = 'scaleY(0)';

        if(ma_sp == "" || ma_size == "" || ma_mau == ""){

            document.getElementById("addCartStatus2").style.display = "block";
            document.getElementById('changepassword2').style.transform = 'scaleY(1)';

        }else{
            document.getElementById("addCartStatus").style.display = "none";
            document.getElementById('changepassword').style.transform = 'scaleY(0)';
            $.ajax({
                url:'AddCartController',
                type:'get',
                dataType:'html',
                data:{
                    ma_sp:ma_sp,
                    ma_mau:ma_mau,
                    ma_size:ma_size,
                    so_luong:soluong
                },
                success:function (data){
                    //console.log(data);
                    $('#changepasswordsuccess').html(data);

                    document.getElementById("addCartStatus").style.display = "block";
                    document.getElementById('changepassword').style.transform = 'scaleY(1)';

                },
                error:function () {
                    alert(" them sp that bai");
                    // window.location.href = 'index.jsp';
                }
            });

        }
    }

    function themvaoyeuthich() {

        var ma_sp = $("#layma_sanphamthemvaogiohang").val();
        var ma_size =  $("#layma_sizethemvaogiohang").val();
        var ma_mau = $("#layma_mauthemvaogiohang").val();
        var soluong = $("#soluongsp").val();

        // console.log(ma_sp);
        // console.log(ma_size);
        // console.log(ma_mau);
        // console.log(soluong);
        document.getElementById("addCartStatus2").style.display = "none";
        document.getElementById('changepassword2').style.transform = 'scaleY(0)';

        if(ma_sp == "" || ma_size == "" || ma_mau == ""){

            document.getElementById("addCartStatus2").style.display = "block";
            document.getElementById('changepassword2').style.transform = 'scaleY(1)';

        }else{

            window.location.href = "AddWishListController?color-w="+ma_mau+"&ma_sp="+ma_sp+"&size-w=" + ma_size;

        }


    }


    function setmamau(event){

        var mamau = $(event).attr("id");

        $("#layma_mauthemvaogiohang").prop("value",mamau);

        }
    function setmasize(event){

        var masize = $(event).attr("id");

        $("#layma_sizethemvaogiohang").prop("value",masize);

    }

    function plustocard3() {
        console.log($("#laysoluong").val());
        let inputsl = document.getElementById('sladdtocard2');

        var n = parseInt(inputsl.value) + 1;

        inputsl.value = n;

        $("#soluongsp").prop("value",n);
        console.log($("#laysoluong").val());
    }

    function subtocard3() {
        let inputsl = document.getElementById('sladdtocard2');
        if (inputsl.value > 1) {
            var n = parseInt(inputsl.value) - 1;
            inputsl.value = n;
            $("#soluongsp").prop("value",n);
            console.log($("#laysoluong").val());
        }
    }

    function gobackpassword() {
        document.getElementById('changepassword').style.transform = 'scaleY(0)';
        document.getElementById('changepassword2').style.transform = 'scaleY(0)';
    }
</script>