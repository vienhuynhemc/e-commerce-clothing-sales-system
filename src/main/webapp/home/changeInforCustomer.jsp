<%@ page import="beans.account.AccountCustomer" %>
<%@ page import="beans.DateTime" %>
<%@ page import="beans.account.ErrorEditAccountCustomer" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/12/2020
  Time: 8:50 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8");%>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVT SHOP | Tài khoản khách hàng</title>

    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/jquery.smartmenus.bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/jquery.simpleLens.css">
    <link rel="stylesheet" type="text/css" href="css/nouislider.css">
    <link id="switcher" href="css/theme-color/default-theme.css" rel="stylesheet">
    <link href="css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="css/trangChu.css">
    <script src="js"></script>
    <link rel="stylesheet" href="css/banner.css">
    <link rel="stylesheet" href="css/informationCustomer.css">
    <link rel="stylesheet" href="css/cart.css">

    <script src="js/informationCustomer.js"></script>

    <!-------------------------------------- lấy session chứa tài khoản ------------------------------>
    <% AccountCustomer accountCustomer = (AccountCustomer) session.getAttribute("user"); %>

</head>

<body>

<!-- wpf loader Two -->
<jsp:include page="../share/_LayoutLoadAndScroll.jsp"></jsp:include>
<!-- END SCROLL TOP BUTTON -->

<!-- Start header section -->
<jsp:include page="../share/_LayoutHeader.jsp"></jsp:include>
<!-- / header section -->

<!-- catg header banner section -->
<%request.setCharacterEncoding("utf-8");%>
<jsp:include page="../share/_LayoutBanner.jsp">
    <jsp:param name="title" value="Thay đổi thông tin"/>
</jsp:include>
<!-- / catg header banner section -->

<!-- main-->

<form action="EditAccountController?UserName=<%=accountCustomer.getUserName()%>" method="post">
        <div class="mainAccount" id="contentaccount">
        <div class="contentAccount">
            <div class="left" id="leftaccount">
                <p class="titleleft"><i class="fa fa-address-card-o"></i> TVTShop</p>
                <div class="leftitemselect activeeselect" onclick="trangthai()" id="buttontrangthai">
                    <p><i class="fa fa-tasks"></i> Trạng thái</p>
                    <i class="fa fa-chevron-right"></i>
                </div>
                <div class="leftitemselect" onclick="lichsumua()" id="buttonlsm">
                    <p><i class="fa fa-history"></i>Lịch sử mua</p>
                    <i class="fa fa-chevron-right"></i>
                </div>
                <div class="leftitemselect">
                    <a href="login.html"><i class="fa fa-power-off"></i>Đăng xuất</a>
                    <i class="fa fa-chevron-right"></i>
                </div>
                <div class="lineleft"></div>

                <div class="customer">
                    <div class="imguser">
                        <img id="avatar" src="../img/about/c1.jpg" alt="">
                    </div>
                    <p class="titleuser"><%=accountCustomer.getFullName()%><i class="fa fa-circle"></i></p>
                    <p class="gmailuser"><%=accountCustomer.getEmail()%></p>
                    <p class="soinoi">Độ sôi nổi: Tiêu chuẩn</p>
                    <input id="fileInput" type="file" style="display:none;" onchange="loadIMG(event)"/>
                    <button class=" changeimg" onclick="document.getElementById('fileInput').click()">Thay đổi ảnh đại
                        diện
                    </button>

                    <div class=" planclick">
                        <div class="headerplanclick">
                            <p>Độ sôi nổi của bạn</p>
                            <div class="lineheaderplanclick">
                                <div></div>
                            </div>
                        </div>
                        <div class="contetnplanclick">
                            <div class="itemplanclick">
                                <h3>5,467</h3>
                                <p>Nhấp chuột trong ngày</p>
                            </div>
                            <div class="lineitemplanclick"></div>
                            <div class="itemplanclick">
                                <h3>102,467</h3>
                                <p>Nhấp chuột trong tháng</p>
                            </div>
                        </div>
                    </div>


                </div>

            </div>


            <div class="rightaccount" id="rightaccount">

                <div class="status" id="status">
                    <p class="statustitle">Tài khoản</p>
                    <p class="statusavatar">Ảnh đại diện</p>
                    <div class="divavatar">
                        <div class="avatar">
                            <img id="avatar2" src="../img/about/c1.jpg" alt="">
                        </div>
                        <button onclick="document.getElementById('fileInput').click()">Thay đổi</button>
                        <button onclick="removeAvatar()">Xóa</button>
                    </div>
                    <div class="linestatus"></div>
                    <div class="statusdivinput">
                        <div class="statusdivinputitem">
                            <div>
                                <p>Tên hiển thị</p>
                                <p>Hiển thị tên người dùng</p>
                            </div>
                            <input name="displayName" type="text" value="<%=accountCustomer.getDisplayName()%>">
                        </div>
                        <div class="statusdivinputitem">
                            <div>
                                <p>Tên đầy đủ</p>
                                <p>Bạn muốn được gọi như thế nào?</p>
                            </div>
                            <input name="fullName" type="text" value="<%=accountCustomer.getFullName()%>">
                        </div>
                    </div>
                    <div class="linestatus"></div>
                    <div class="statusdivinput">
                        <div class="statusdivinputitem">
                            <div>
                                <p>Tài khoản</p>
                                <p>Dùng để đăng nhập</p>
                            </div>
                            <input name="userName" type="text" value="<%=accountCustomer.getUserName()%> " disabled>
                        </div>
                        <div class="statusdivinputitem">
                            <div>
                                <p>Mật khẩu</p>
                                <p id="doimatkhau" onclick="doimatkhau()" class="doimatkhau">Đổi mật khẩu</p>
                            </div>
                            <input type="password" value="<%=accountCustomer.getPassWord() %>" disabled>
                        </div>
                    </div>
                    <div class="linestatus"></div>
                    <div class="statusdivinput">
                        <div class="statusdivinputitem">
                            <div>
                                <p>Địa chỉ email</p>
                                <p>Dùng để nhận thông báo và lấy lại mật khẩu</p>
                            </div>
                            <input type="text" value="<%=accountCustomer.getEmail()%>" disabled>
                        </div>
                        <div class="statusdivinputitem">
                            <div>
                                <p>Số điện thoại</p>
                                <p>Dùng để nhận thông báo và lấy lại mật khẩu</p>
                            </div>
                            <input type="text" value="<%=accountCustomer.getPhone()%>" disabled>
                        </div>
                    </div>
                    <div class="linestatus"></div>
                    <div class="statusdivinput">
                        <div class="statusdivinputitem">
                            <div>
                                <p>Ngày tạo</p>
                                <p>Bạn đã tham gia với chúng tôi lâu chưa?</p>
                            </div>

                            <%DateTime date = accountCustomer.getRegisDate();%>

                            <input type="text" value="<%=date.getDay()%> - <%=date.getMonth()%> - <%=date.getYear()%>" disabled>
                        </div>
                        <div class="statusdivinputitem">
                            <div>
                                <p>Mã tài khoản</p>
                                <p>Để chúng tôi nhận biết tài khoản của bạn</p>
                            </div>
                            <input type="text" value="<%=accountCustomer.getIdUser()%>" disabled>
                        </div>
                    </div>
                    <div class="linestatus"></div>
                    <div class="connectgg">
                        <p>Liên kết tài khoản</p>
                        <p>Chúng tôi sử dụng nó để cho phép bạn đăng nhập và hoàn thiện thông tin của bạn</p>
                        <div>
                            <div><img src="../img/google.jpg" alt="">
                                <p>Đăng nhập với Google</p>
                            </div>
                            <button>Kết nối</button>
                        </div>
                    </div>
                    <div class="linestatus"></div>

                    <div class="deleleaccount">
                        <div>
                            <p>Xóa tài khoản</p>
                            <p>Nếu xóa tài khoản, bạn sẽ mất toàn bộ dữ liệu của mình</p>
                        </div>
                        <p>Xóa tài khoản...</p>
                    </div>

                    <div class="linestatus"></div>

                    <button type="submit" class="savestatus">Lưu thay đổi</button>
                </div>

                <div class="historyorder" id="historyorder">
                    <div class="historyheader">
                        <p class="historytitle">Lịch sử mua hàng</p>
                        <input type="text" placeholder="Tìm kiếm mã đơn hàng">
                    </div>
                    <div class="historycontent">

                        <div class="historyleft">
                            <div class="contentheader">
                                <p class="ma">Mã đơn hàng</p>
                                <p class="soloai">Số loại</p>
                                <p class="sosanpham">Số sản phẩm</p>
                                <p class="gia">Tổng giá</p>
                                <p class="trangthai">Trạng thái</p>
                            </div>

                            <div class="linehistory"></div>

                            <div class="contenthistorymain">
                                <div class="historyitem activehistoryitem">
                                    <p class="ma">DH402</p>
                                    <p class="soloai">5</p>
                                    <p class="sosanpham">14</p>
                                    <p class="gia">4,359,00 VND</p>
                                    <p class="trangthai xuly"><i class="fa fa-circle"></i>Đang xử lý: 3/5</p>
                                </div>
                                <div class="historyitem">
                                    <p class="ma">DH394</p>
                                    <p class="soloai">2</p>
                                    <p class="sosanpham">4</p>
                                    <p class="gia">750,00 VND</p>
                                    <p class="trangthai"><i class="fa fa-circle"></i>Hoàn thành</p>
                                </div>
                                <div class="historyitem">
                                    <p class="ma">DH320</p>
                                    <p class="soloai">4</p>
                                    <p class="sosanpham">7</p>
                                    <p class="gia">1,239,00 VND</p>
                                    <p class="trangthai"><i class="fa fa-circle"></i>Hoàn thành</p>
                                </div>
                                <div class="historyitem">
                                    <p class="ma">DH303</p>
                                    <p class="soloai">1</p>
                                    <p class="sosanpham">2</p>
                                    <p class="gia">498,00 VND</p>
                                    <p class="trangthai"><i class="fa fa-circle"></i>Hoàn thành</p>
                                </div>
                                <div class="historyitem">
                                    <p class="ma">DH255</p>
                                    <p class="soloai">2</p>
                                    <p class="sosanpham">2</p>
                                    <p class="gia">440,00 VND</p>
                                    <p class="trangthai"><i class="fa fa-circle"></i>Hoàn thành</p>
                                </div>
                                <div class="historyitem">
                                    <p class="ma">DH102</p>
                                    <p class="soloai">1</p>
                                    <p class="sosanpham">1</p>
                                    <p class="gia">299,00 VND</p>
                                    <p class="trangthai"><i class="fa fa-circle"></i>Hoàn thành</p>
                                </div>
                            </div>

                            <div class="footerleft">
                                <ul>
                                    <li><i class="fa fa-angle-double-left"></i></li>
                                    <li class="activeli">1</li>
                                    <li>2</li>
                                    <li>3</li>
                                    <li>4</li>
                                    <li class="none">...</li>
                                    <li>5</li>
                                    <li><i class="fa fa-angle-double-right"></i></li>
                                </ul>
                            </div>
                        </div>

                        <div class="linedoc"></div>

                        <div class="historyright">
                            <div class="historyrightheader">
                                <p>Đơn hàng #DH402</p>
                                <p><i class="fa fa-circle"></i>Đang xử lý 3/5</p>
                            </div>
                            <div class="divhinh">
                                <div class="listhinh" id="listhinh">
                                    <div>
                                        <div>
                                            <img src="../img/product/pro11.webp" alt="">
                                        </div>
                                        <p>MST 1010</p>
                                    </div>
                                    <div>
                                        <div>
                                            <img src="../img/product/pro1.webp" alt="">
                                        </div>
                                        <p>MSW 1006</p>
                                    </div>
                                    <div>
                                        <div>
                                            <img src="../img/product/pro4.webp" alt="">
                                        </div>
                                        <p>MSW1003</p>
                                    </div>
                                    <div>
                                        <div>
                                            <img src="../img/product/pro10.webp" alt="">
                                        </div>
                                        <p>MTS 1008</p>
                                    </div>
                                    <div>
                                        <div>
                                            <img src="../img/product/pro12.webp" alt="">
                                        </div>
                                        <p>MTS1010</p>
                                    </div>
                                </div>
                            </div>
                            <span class="fa fa-chevron-left scrollleft" onclick="left()"></span>
                            <span class="fa fa-chevron-right scrollright" onclick="right()"></span>

                            <div class="tongketright">
                                <div>
                                    <p>Tổng tiền sản phẩm:</p>
                                    <p>4,289,000 VND</p>
                                </div>
                                <div>
                                    <p>Phí vận chuyển:</p>
                                    <p>70,000 VND</p>
                                </div>
                                <div class="line"></div>
                                <div>
                                    <p>Tổng tiền:</p>
                                    <p>4,359,000 VND</p>
                                </div>
                            </div>

                            <button class="buttonxemchitiet" onclick="xemchitiet()">Xem chi tiết</button>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>

        <div class="changepassword" id="changepassword">
            <div class="hiddenchangepassword" onclick="gobackpassword()"></div>
            <div class="mainchangepassword">
                <p class="changepasswordtitle"><i class="fa fa-cogs"></i>TVT Shop</p>
                <div class="changepassworddiv" id="changepassworddiv">
                    <p>Đổi mật khẩu của bạn</p>
                    <label for="input1">Mật khẩu cũ</label>
                    <input name="oldPass" type="password" id="input1" placeholder="Nhập mật khẩu cũ">
                    <label for="input1">Mật khẩu mới</label>
                    <input name="newPass" type="password" id="input1" placeholder="Nhập mật khẩu mới">
                    <label for="input1">Xác nhận mật khẩu mới</label>
                    <input name="rePass" type="password" id="input1" placeholder="Xác nhận mật khẩu mới của bạn">
                    <button type="button" onclick="gotosuccesspassword()">Thay đổi mật khẩu</button>
                </div>
                <div class="changepasswordsuccess" id="changepasswordsuccess">
                    <p>Thay đổi mật khẩu thành công</p>
                    <p>Từ bây giờ, bạn có thể sử dụng mật khẩu mới của mình để đăng nhập vào tài khoản của bạn <img
                            src="../img/raising-hands-emoji-218129.png" alt=""></p>
                    <button type="button" onclick="gobackpassword()">Trở về tài khoản</button>
                </div>
            </div>
        </div>




</form>



<!-- sử lí hiện bảng thông báo ---->
<%
    //lấy request loginStatus != null thì đăng nhập thất bại

    String status = (String) request.getAttribute("error");

    if (status  != null) {

        //truyển status vào để sử lí
        ErrorEditAccountCustomer editError = new ErrorEditAccountCustomer(status);
%>

<script>

    document.getElementById("doimatkhau").onclick="doimatkhau()";

</script>

<%request.setCharacterEncoding("utf-8");%>
<jsp:include page="../notifyErrorLogin/AccountStatus.jsp">
    <jsp:param name="title" value="<%=editError.getTitle()%>"/>
    <jsp:param name="content" value="<%=editError.getContent()%>"/>
</jsp:include>
<%
    }
%>


<!--cart-->
<div class="inforcart" id="inforcart">
    <div class="hiddencart" onclick="trovetaikhoan()"></div>
    <div class="informationinforcart">
        <section class="contentcart" id="contentcart">
            <div class="cart">
                <div class="cartleft">
                    <div class="cartleftheader">
                        <h3> T<span style="color:#ff7315">V</span>T</h3>
                        <h5>|</h5>
                        <p>Đơn hàng #DH402</p>
                    </div>
                    <div class="scrollmain">
                        <div class="cartleftmain">
                            <div class="cartleftmainitem">
                                <div class="cartleftmainitemleft">
                                    <a href="" class="cartleftmainimg"> <img src="../img/product/pro10.webp" alt=""></a>
                                    <a href="">
                                        <div class="cartleftmainiteminfor">
                                            <p>Áo Thun MTS 1011</p>
                                            <h6>Áo thun | Size: L</h6>
                                        </div>
                                    </a>
                                    <p class="cartleftmainitemcolor">Trắng</p>
                                    <div class="cartleftmainitemsl">
                                        <p>2</p>
                                    </div>
                                    <p class="cartleftmainitemprice">798,000 VND</p>
                                </div>
                            </div>
                            <div class="cartleftmainitem">
                                <div class="cartleftmainitemleft">
                                    <a href="" class="cartleftmainimg"> <img src="../img/product/pro11.webp" alt=""></a>
                                    <a href="">
                                        <div class="cartleftmainiteminfor">
                                            <p>Áo Thun MTS 1010</p>
                                            <h6>Áo thun | Size: L</h6>
                                        </div>
                                    </a>
                                    <p class="cartleftmainitemcolor">Đen</p>
                                    <div class="cartleftmainitemsl">
                                        <p>3</p>
                                    </div>
                                    <p class="cartleftmainitemprice">597,000 VND</p>
                                </div>
                            </div>
                            <div class="cartleftmainitem">
                                <div class="cartleftmainitemleft">
                                    <a href="" class="cartleftmainimg"> <img src="../img/product/pro12.webp" alt=""></a>
                                    <a href="">
                                        <div class="cartleftmainiteminfor">
                                            <p>Áo Thun Nam Raglan Tay Dài MTS 1008</p>
                                            <h6>Áo thun tay dài | Size: M</h6>
                                        </div>
                                    </a>
                                    <p class="cartleftmainitemcolor">Xanh</p>
                                    <div class="cartleftmainitemsl">
                                        <p>1</p>
                                    </div>
                                    <p class="cartleftmainitemprice">399,000 VND</p>
                                </div>
                            </div>
                            <div class="cartleftmainitem">
                                <div class="cartleftmainitemleft">
                                    <a href="" class="cartleftmainimg"> <img src="../img/product/pro4.webp" alt=""></a>
                                    <a href="">
                                        <div class="cartleftmainiteminfor">
                                            <p>Áo Sweater Logo Sài Gòn MSW 1003</p>
                                            <h6>Áo thun tay dài | Size: M</h6>
                                        </div>
                                    </a>
                                    <p class="cartleftmainitemcolor">Vàng</p>
                                    <div class="cartleftmainitemsl">
                                        <p>4</p>
                                    </div>
                                    <p class="cartleftmainitemprice">1,196,000 VND</p>
                                </div>
                            </div>
                            <div class="cartleftmainitem">
                                <div class="cartleftmainitemleft">
                                    <a href="" class="cartleftmainimg"> <img src="../img/product/pro1.webp" alt=""></a>
                                    <a href="">
                                        <div class="cartleftmainiteminfor">
                                            <p>Áo Sweater Nam Stay Together MSW 1006</p>
                                            <h6>Áo len | Size: XL</h6>
                                        </div>
                                    </a>
                                    <p class="cartleftmainitemcolor">Đỏ đô</p>
                                    <div class="cartleftmainitemsl">
                                        <p>3</p>
                                    </div>
                                    <p class="cartleftmainitemprice">900,000 VND</p>
                                </div>
                            </div>
                            <div class="cartleftmainitem">
                                <div class="cartleftmainitemleft">
                                    <a href="" class="cartleftmainimg"> <img src="../img/product/pro9.webp" alt=""></a>
                                    <a href="">
                                        <div class="cartleftmainiteminfor">
                                            <p>Áo Thun MTS 1012</p>
                                            <h6>Áo thun | Size : M</h6>
                                        </div>
                                    </a>
                                    <p class="cartleftmainitemcolor">Trắng</p>
                                    <div class="cartleftmainitemsl">
                                        <p>1</p>
                                    </div>
                                    <p class="cartleftmainitemprice">399,000 VND</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="cartleftfooter">
                        <a onclick="trovetaikhoan()">
                            <i class="fa fa-long-arrow-left"></i> Trở về tài khoản
                        </a>
                        <div class="footertongtien">
                            <p>Tổng tiền sản phẩm:</p>
                            <p>4,289,000 VND</p>
                        </div>

                    </div>
                </div>

                <div class="cartright">
                    <div class="closecartright" onclick="trovetaikhoan()"><i class="fa fa-power-off"></i></div>
                    <h3>Thông tin đơn hàng</h3>
                    <div class="pricecr">
                        <div class="pricedivright">
                            <p>Phí vận chuyển: </p>
                            <p>70,000 VND</p>
                        </div>
                        <div class="pricedivright">
                            <p>Tổng tiền: </p>
                            <p>4,359,000 VND</p>
                        </div>
                    </div>
                    <div class="linecr"></div>
                    <div class="pricecr">
                        <div class="pricedivright">
                            <p>Số loại:</p>
                            <p>5</p>
                        </div>
                        <div class="pricedivright">
                            <p>Số lượng</p>
                            <p>14</p>
                        </div>
                    </div>
                    <div class="linecr"></div>
                    <div class="pricecr">
                        <div class="pricedivrightinfor">
                            <div>
                                <i class="fa fa-clock-o"></i>
                                <p>Thời gian giao hàng từ 1-5 ngày tùy khu vực</p>
                            </div>
                            <div>
                                <i class="fa fa-truck"></i>
                                <p>Free ship cho đơn hàng từ 499k trở lên</p>
                            </div>
                        </div>
                    </div>
                    <div class="linecr"></div>
                    <div class="note">
                        <p>Ghi chú đơn hàng</p>
                        <textarea cols="30"
                                  rows="10">Tui rất hài lòng với các món đồ này, bạn giao nhẹ tay nha!</textarea>
                    </div>
                    <a href="informationOrder.html" class="submit">
                        Kiểm tra tiến trình giao hàng
                    </a>

                    <!-- Lam dep -->>
                    <div class="box1">
                    </div>
                    <div class="box2">
                        <div></div>
                        <div style="background-color: #ff7315;"></div>
                        <div></div>
                    </div>
                </div>
            </div>
        </section>
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


<!-- The core Firebase JS SDK is always required and must be listed first -->
<script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-storage.js"></script>
<script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-database.js"></script>

<!-- TODO: Add SDKs for Firebase products that you want to use
https://firebase.google.com/docs/web/setup#available-libraries -->
<script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-analytics.js"></script>

<script>
    // Your web app's Firebase configuration
    // For Firebase JS SDK v7.20.0 and later, measurementId is optional
    var firebaseConfig = {
        apiKey: "AIzaSyCNKrWfzyctIJeK4XgPlU5AKR1y2hY1zA0",
        authDomain: "ecommerce-b6c08.firebaseapp.com",
        databaseURL: "https://ecommerce-b6c08-default-rtdb.firebaseio.com",
        projectId: "ecommerce-b6c08",
        storageBucket: "ecommerce-b6c08.appspot.com",
        messagingSenderId: "390576423583",
        appId: "1:390576423583:web:efcf73909008a68dcd18aa",
        measurementId: "G-LR0V7PWKZN"
    };
    // Initialize Firebase
    firebase.initializeApp(firebaseConfig);
    firebase.analytics();

    function loadIMG(event) {
        if (event.target.files.length > 0) {

            const ref = firebase.storage().ref();
            const file = event.target.files[0];
            const name = file.name;
            let link;
            let nameData = name.split('.')[0];
            const folder = "ProductNam/" + nameData;
            const metadata = {contentType: file.type};
            const task = ref.child(folder).put(file, metadata);
            task
                .then(snapshot => snapshot.ref.getDownloadURL())
                .then(url => {
                    alert("Thanh cong");
                    document.getElementById('avatar').src = url;
                    document.getElementById('avatar2').src = url;
                    link = url;
                    firebase.database().ref(folder).set({
                        Name: nameData,
                        Link: link
                    })
                });

//Lấy dữ liệu xuống như lấy thuộc tính từ đối tượng ra , chỉ cần truyền đúng link thì oke
            firebase.database().ref("ProductNam/index").on('value', function (snapshot) {
                document.getElementById('avatar').src = snapshot.val().Link;
            })
        }
    }

    function removeAvatar() {
        document.getElementById('avatar').src = '../img/user.jpg';
        document.getElementById('avatar2').src = '../img/user.jpg';

// xoá thì truyền link vào
//database
        firebase.database().ref('ProductNam/map').remove();
        // img
        firebase.storage().ref('ProductNam/map').delete();
    }

</script>
