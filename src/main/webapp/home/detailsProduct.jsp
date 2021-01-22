<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.product.*" %><%--
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
    <%
        Product p = (Product) request.getAttribute("product");
        ArrayList<ProductDetailInformation> pd = (ArrayList<ProductDetailInformation>) request.getAttribute("listSize");
        System.out.println(pd);
    %>
</head>

<body>

<!-- wpf loader Two -->
<jsp:include page="../share/_LayoutLoadAndScroll.jsp"></jsp:include>

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
                                <a href="#" class="aa-add-to-cart-btn addTocardViewQuick"><span
                                        class="fa fa-shopping-cart"></span>Thêm vào giỏ hàng</a>
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
                    <div>
                        <img src="<%=p.getListIMG().get(0).getLink_hinh()%>" alt="" id="img1">
                        <p>Mã sản phẩm: <%= p.getMa_sp()%></p>
                    </div>
                    <img src="<%=p.getListIMG().get(0).getLink_hinh()%>" alt="" id="img2">
                </div>
                <div>
                    <div class="dplistitem" id="dplistitem">
                        <% for(ProductImage pi : p.getListIMG()){%>
                        <div class="dpitem">
                            <div onclick="doiHinhChinh(this)">
                                <img src="<%=pi.getLink_hinh()%>" alt="" id="doiHinhChinh1">
                            </div>
                            <img src="<%=pi.getLink_hinh()%>" alt="">
                        </div>
                        <%}%>
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

                    <span><del><%=p.getPrice().getGia_sp()%> VND</del></span>
                    <span>(GIẢM GIÁ <%= Math.round(((p.getPrice().getGia_sp()-p.getPriceSale().getGia_sp_km())/p.getPrice().getGia_sp())*100) %>%)</span>
                </div>
                <p class="giasanphamgiachinh"><%=p.getPriceSale().getGia_sp_km()%> VND</p>
                <p class="thongtinghichu">(Giá có thể tăng lên khi thanh toán vì có phí vận chuyển)</p>
                <div class="guidecolor">
                    <p>CHỌN MÀU</p>
                    <% for(ProductColor pc : p.getListColor()){%>
                    <span class="colordpdx" id="colordpdx"><%=pc.getTen_mau()%></span>
                    <%}%>
<%--                    <span class="colordpdx" id="colordpdx">Đỏ</span>--%>

                </div>
                <div class="selectcolor">
                    <input type="radio" name="color" id="color1" style="display: none;" checked>
                    <input type="radio" name="color" id="color2" style="display: none;">
<%--                    <label for="color1" class="labelcolor1" onclick="damXanh()">--%>
<%--                        <div><img src="../img/product/damxanh.webp" alt=""></div>--%>
<%--                    </label>--%>
<%--                    <label for="color2" class="labelcolor2" onclick="xanhNhat()">--%>
<%--                        <div><img src="../img/product/xanhnhat.webp" alt=""></div>--%>
<%--                    </label>--%>
                    <%for(ProductColor pc : p.getListColor()){%>
                    <label for="color1" class="labelcolor1" onclick="damXanh()">
                        <div><a href="LoadSizeDetailProductController?idProduct=<%=p.getMa_sp()%>&ma_mau=<%=pc.getMa_mau()%>"><img src="<%=pc.getLink_hinh()%>" alt="" style="width: 45px"></a></div>
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
                    <input type="radio" name="size" id="size1" style="display: none;" checked>
                    <input type="radio" name="size" id="size2" style="display: none;">
                    <input type="radio" name="size" id="size3" style="display: none;">
                    <input type="radio" name="size" id="size4" style="display: none;">
                    <input type="radio" name="size" id="size5" style="display: none;">
                    <% if(pd != null){%>
                    <% for(ProductDetailInformation ps : pd){%>
                    <label for="size1" class="labelsize1"><%=ps.getTen_size()%></label>
                    <%}} else{%>
                    <% for(Size s: p.getListSize()){%>
                    <label for="size1" class="labelsize1"><%=s.getTen_size()%></label>
                    <%}}%>
<%--                    <label for="size2" class="labelsize2">M</label>--%>
<%--                    <label for="size3" class="labelsize3">L</label>--%>
<%--                    <label for="size4" class="labelsize4">XL</label>--%>
<%--                    <label for="size5" class="labelsize5">XXL</label>--%>
                </div>
                <p class="dpconlai">Còn lại 1 sản phẩm</p>
                <div class="inputsl">
                    <button onclick="subtocard2()"><span>-</span></button>
                    <input type="text" value="1" id="sladdtocard2" name="so_luong">
                    <button onclick="plustocard2()"><span>+</span></button>
                </div>
                <div class="wlaatc">
                    <button><i class="fa fa-heart"></i> YÊU THÍCH</button>
                    <a href="AddCartController?id"><button><i class=" fa fa-cart-plus"></i> THÊM VÀO GIỎ HÀNG</button></a>
                </div>
            </div>
        </div>
    </div>

    <div class="linesesstion"></div>

    <div class="dtp">
        <p class="dtptitle">Thông tin sản phẩm</p>
        <%for(ProductInfomation s : p.getListInfo()){%>
        <p class="dtpinfor1"><%=s.getThong_tin()%></p>
        <%}%>
        <p class="dtptitle">Vật liệu & sản xuất</p>
        <ul>
            <%for(String ps : p.getCau_tao_sp().getCau_tao()){%>
            <li><%=ps%></li>
            <%}%>

        </ul>
        <p class="dtptitle">Phù hợp cho</p>
        <ul>
            <%for(String pi : p.getGioi_thieu_sp().getGioi_thieu()){%>
            <li><%=pi%></li>
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
        <div class="danhgia" id="danhgia">
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
        <div id="danhgia2">
            <p class="dgsptitle">Bài đánh giá của bạn</p>
            <div>
                <div class="danhgia2infor">
                    <div>
                        <div>
                            <img src="../img/product/avatar7.jpg" alt="">
                        </div>
                        <div class="danhgia2infor2">
                            <p>Nguyễn Thị Hoa Hồng</p>
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

        <div class="linexephang"></div>

        <div class="xephangdanhgia">
            <p class="dgsptitle">Xếp hạng đánh giá</p>
            <div class="xephang">
                <div class="xephangleft">
                    <p>4,3</p>
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
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star-half"></i>
                        </div>
                    </div>
                    <p>62 đánh giá</p>
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

        <div class="bolocbinhluan">
            <button class="activeboloc">Tất cả</button>
            <button>Tích cực</button>
            <button>Tiêu cực</button>
            <button>5 <i class="fa fa-star"></i></button>
            <button>4 <i class="fa fa-star"></i></button>
            <button>3 <i class="fa fa-star"></i></button>
            <button>2 <i class="fa fa-star"></i></button>
            <button> 1<i class="fa fa-star"></i></button>
        </div>

        <div class="binhluanitem">
            <div class="headerbinhluanitem">
                <div>
                    <div>
                        <img src="../img/product/avatar1.jpg" alt="">
                    </div>
                    <p>Diệu Đặng</p>
                </div>
                <div onclick="report(this)">
                    <i class="fa fa-circle"></i>
                    <i class="fa fa-circle"></i>
                    <i class="fa fa-circle"></i>
                    <div class="report">
                        <p>Báo cáo</p>
                    </div>
                    <input type="checkbox" style="display: none;">
                </div>
            </div>
            <div class="inforbinhluanitem">
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
                    </div>
                </div>
                <p>08/10/2020</p>
            </div>
            <p>Quần ko giống mô tả, shop ghi 87-90cm, mình còn mua size L nhưng quần shop giao dài có 82cm, mình cao
                1m58 mà mặc nó thành quần ngố lun á, cũng khá chật chứ ko rộng các vòng như shop báo. Shop kêu gửi
                lại shop đổi cho cái khác nhưng thủ tục của ghtk quá rườm rà nên thôi chấp nhận bỏ cái quần này vậy
            </p>
        </div>

        <div class="linexephang"></div>

        <div class="binhluanitem">
            <div class="headerbinhluanitem">
                <div>
                    <div>
                        <img src="../img/product/avatar2.jpg" alt="">
                    </div>
                    <p>Cao Anh</p>
                </div>
                <div onclick="report(this)">
                    <i class="fa fa-circle"></i>
                    <i class="fa fa-circle"></i>
                    <i class="fa fa-circle"></i>
                    <div class="report">
                        <p>Báo cáo</p>
                    </div>
                    <input type="checkbox" style="display: none;">
                </div>
            </div>
            <div class="inforbinhluanitem">
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
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                    </div>
                </div>
                <p>08/10/2020</p>
            </div>
            <p>Hàng về thì thấy là quần màu xanh đậm chứ kp xanh nhạt nữa :)) Quần mỏng, mềm nhưng bên trong hơi xù
                và ngứa, chắc giặt thì hết
                Mình m58 eo 64 46kg mặc quần vừa khít, ôm bụng nhưng mỗi tội là bị cộc =)) 4 sao
            </p>
        </div>

        <div class="linexephang"></div>

        <div class="binhluanitem">
            <div class="headerbinhluanitem">
                <div>
                    <div>
                        <img src="../img/product/avatar3.jpg" alt="">
                    </div>
                    <p>Nguyễn Minh Châu</p>
                </div>
                <div onclick="report(this)">
                    <i class="fa fa-circle"></i>
                    <i class="fa fa-circle"></i>
                    <i class="fa fa-circle"></i>
                    <div class="report">
                        <p>Báo cáo</p>
                    </div>
                    <input type="checkbox" style="display: none;">
                </div>
            </div>
            <div class="inforbinhluanitem">
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
                        <i class="fa fa-star"></i>
                    </div>
                </div>
                <p>07/10/2020</p>
            </div>
            <p>Chán<br>
                Bảo shop kiểm tra kĩ cho mình rồi<br>
                Vừa mặc lên sờ vào cúc thì bị rụng. Kb dùng khuy thay vào được k nhỉ
            </p>
        </div>

        <div class="linexephang"></div>

        <div class="binhluanitem">
            <div class="headerbinhluanitem">
                <div>
                    <div>
                        <img src="../img/product/avatar4.jpg" alt="">
                    </div>
                    <p>Lưu Thị Ánh</p>
                </div>
                <div onclick="report(this)">
                    <i class="fa fa-circle"></i>
                    <i class="fa fa-circle"></i>
                    <i class="fa fa-circle"></i>
                    <div class="report">
                        <p>Báo cáo</p>
                    </div>
                    <input type="checkbox" style="display: none;">
                </div>
            </div>
            <div class="inforbinhluanitem">
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
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                    </div>
                </div>
                <p>07/10/2020</p>
            </div>
            <p>Quần màu đen rộng hơn quần xanh cùng size. quần đen này size S nhưng rộng lắm. giặt 2 lần đã xù lông
                rồi. giao hàng nhanhhhhhhhhhhhhhhhhhh
            </p>
        </div>

        <div class="linexephang"></div>

        <div class="binhluanitem">
            <div class="headerbinhluanitem">
                <div>
                    <div>
                        <img src="../img/product/avatar5.jpg" alt="">
                    </div>
                    <p>Khương Hồng Nhan</p>
                </div>
                <div onclick="report(this)">
                    <i class="fa fa-circle"></i>
                    <i class="fa fa-circle"></i>
                    <i class="fa fa-circle"></i>
                    <div class="report">
                        <p>Báo cáo</p>
                    </div>
                    <input type="checkbox" style="display: none;">
                </div>
            </div>
            <div class="inforbinhluanitem">
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
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                    </div>
                </div>
                <p>07/10/2020</p>
            </div>
            <p>Quần đẹp lắm nhưng chắc do mình cao hay sao ấy đặt size M nhưng lại bị ngắn nhưng k sao quần đẹp nên
                bỏ qua<br>
                Mình cũng rất thích cách shop chốt đơn nha❤️❤️
                <br>
                Sẽ ủng hộ shop dài dài😍
            </p>
        </div>

        <div class="linexephang"></div>

        <div class="binhluanitem">
            <div class="headerbinhluanitem">
                <div>
                    <div>
                        <img src="../img/product/avatar6.jpg" alt="">
                    </div>
                    <p>Tran Trần Xinh Gái</p>
                </div>
                <div onclick="report(this)">
                    <i class="fa fa-circle"></i>
                    <i class="fa fa-circle"></i>
                    <i class="fa fa-circle"></i>
                    <div class="report">
                        <p>Báo cáo</p>
                    </div>
                    <input type="checkbox" style="display: none;">
                </div>
            </div>
            <div class="inforbinhluanitem">
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
                    </div>
                </div>
                <p>01/10/2020</p>
            </div>
            <p>Ảnh 1 kiểu hàng về 1 kiểu. Đc cái shipper thân thiện. Chất vải cx đc nhưng mà quá ngắn, k mặc đc.
                Shop phục vụ kém :(((
            </p>
        </div>

    </div>

    <div class="dpnextpage">
        <button><i class="fa fa-caret-left"></i></button>
        <ul>
            <li>1</li>
            <li>2</li>
            <li>3</li>
            <li>4</li>
            <li>5</li>
            <li class="none">...</li>
            <li>11</li>
        </ul>
        <button><i class="fa fa-caret-right"></i></button>
    </div>

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
                            <div class="tab-pane fade in active" id="popular">
                                <ul class="aa-product-catg aa-popular-slider">
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="detailsProduct.html"><img
                                                    src="../img/do/nu/16.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="cart.html"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="detailsProduct.html">Áo
                                                    Sweater Nữ Logo Sài Gòn WSW 2003</a></h4>
                                                <span class="aa-product-price sprice">349,000 VND</span><span
                                                    class="aa-product-price"><del>569,000
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
                                                    src="../img/do/nu/15.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="cart.html"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="detailsProduct.html">Áo
                                                    Thun
                                                    Relax Thêu Ngực WTS 2006</a></h4>
                                                <span class="aa-product-price sprice">229,000 VND</span>
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
                                                    src="../img/do/nu/14.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="cart.html"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                        </figure>
                                        <figcaption>
                                            <h4 class="aa-product-title"><a href="detailsProduct.html">Áo Thun
                                                Regular Think Less WTS 2004</a></h4>
                                            <span class="aa-product-price sprice">229,000 VND</span>
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
                                                    src="../img/do/nu/13.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="cart.html"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="detailsProduct.html">Áo
                                                    Thun
                                                    Dây Kéo WTS 2011</a></h4>
                                                <span class="aa-product-price sprice">299,000 VND</span><span
                                                    class="aa-product-price"><del>499,000
                                                            VND
                                                        </del></span>
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
                                            <a class="aa-product-img" href="detailsProduct.html"><img
                                                    src="../img/do/nu/12.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="cart.html"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="detailsProduct.html">Áo
                                                    Thun
                                                    Nữ WTS 2016
                                                </a></h4>
                                                <span class="aa-product-price sprice"> 219,000 VND</span><span
                                                    class="aa-product-price"><del> 349,000
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
                                            <a class="aa-product-img" href="detailsProduct.html"><img
                                                    src="../img/do/nu/11.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="cart.html"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="detailsProduct.html">Quần
                                                    Jeans Dài Ống Rộng WJE 2002</a></h4>
                                                <span class="aa-product-price sprice">499,000 VND</span><span
                                                    class="aa-product-price"><del>659,000
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
                                        <span class="aa-badge aa-hot" href="#">Mới!</span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="detailsProduct.html"><img
                                                    src="../img/do/nu/10.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="cart.html"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="detailsProduct.html">Áo
                                                    Thun
                                                    Nữ WTS 2035
                                                </a></h4>
                                                <span class="aa-product-price sprice"> 139,000 VND</span><span
                                                    class="aa-product-price"><del> 259,000
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
                                        <span class="aa-badge aa-hot" href="#">Mới!</span>
                                    </li>
                                    <!-- start single product item -->
                                    <li>
                                        <figure>
                                            <a class="aa-product-img" href="detailsProduct.html"><img
                                                    src="../img/do/nu/9.jpg" alt="polo shirt img"></a>
                                            <a class="aa-add-card-btn" href="cart.html"><span
                                                    class="fa fa-shopping-cart"></span>Thêm vào giỏ</a>
                                            <figcaption>
                                                <h4 class="aa-product-title"><a href="detailsProduct.html">Áo
                                                    Sweater Nữ Stay Together WSW 2006</a></h4>
                                                <span class="aa-product-price sprice">379,000 VND</span><span
                                                    class="aa-product-price"><del>419,000
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
                                </ul>
                            </div>
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
<div class="vietdanhgia" id="vietdanhgia">
    <div class="hiddenvdg" onclick="closedanhgia()"></div>
    <div class="formvietdanhgia">
        <div class="headerformvietdanhgia">
            <i class="fa fa-pencil-square-o"></i>
            <div>
                <h3>Đánh giá sản phẩm</h3>
                <p>Quần Jeans Nữ Tưa Lai Túi Lệch WJL 4011</p>
            </div>
        </div>
        <div style="background: white;">
            <div class="contentformvietdanhgia">
                <div>
                    <img src="../img/product/avatar7.jpg" alt="">
                </div>
                <div>
                    <h3>Nguyễn Thị Hoa Hồng</h3>
                    <p>
                        Đánh giá của bạn sẽ được công khai cho mọi người cùng thấy</p>
                </div>
            </div>
            <div class="vdgstar">
                <i class="fa fa-star-o"></i>
                <i class="fa fa-star-o"></i>
                <i class="fa fa-star-o"></i>
                <i class="fa fa-star-o"></i>
                <i class="fa fa-star-o"></i>
            </div>
            <textarea placeholder="Mô tả đánh giá của bạn về sản phẩm (không bắt buộc)"></textarea>
            <div class="vdgsubmit">
                <button onclick="closedanhgia()">Hủy</button>
                <button onclick="dangdanhgia()">Đăng</button>
            </div>
        </div>
    </div>
</div>


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