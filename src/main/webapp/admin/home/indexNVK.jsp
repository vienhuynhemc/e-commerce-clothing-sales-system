<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 8:36 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVTSHOP ADMIN | Trang chủ nhân viên kho</title>
    <link rel="stylesheet" href="../../fonts/font-awesome-4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="../../css/indexAdmin.css">
    <link rel="stylesheet" href="../../css/trangchuAdmin.css">

    <script src="../../js/indexAdmin.js"></script>
</head>

<body>
<%

    //----------------------Kiểm tra thử đăng nhập hay chưa và có vai trò ở trang này hay không------------------------------------//
    if (request.getSession().getAttribute("userAdmin") == null) {

        //  Lưu vô session biến trang chờ đợi là trang này để có gì đăng nhập thành công chuyển tới trang này
        request.getSession().setAttribute("trackPage", "admin.indexNVK");

        //  Lưu trackpage xong thì sendredirect tới login
        response.sendRedirect("login.jsp");

    } else {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

%>

<jsp:include page="../share/_LayoutLeftNVK.jsp">
    <jsp:param name="activeSelect" value="trangchu"/>
</jsp:include>

<div class="indexright">
    <jsp:include page="../share/_LayoutTop.jsp">
        <jsp:param name="level" value="Nhân viên kho"/>
    </jsp:include>

    <!-- Code trang ở đây-->

    <div class="indexmain">
        <div class="div1">
            <div class="div1item">
                <div class="div1item1">
                    <i class="fa fa-users"></i>
                    <div>
                        <h3>5680</h3>
                        <p>Tổng số khách hàng đăng nhập</p>
                    </div>
                    <p>71%</p>
                </div>
                <div class="div1item2">
                    <div></div>
                    <div class="div1item2color1"></div>
                </div>
            </div>
            <div class="div1item">
                <div class="div1item1">
                    <i class="fa fa-user-plus"></i>
                    <div>
                        <h3>126</h3>
                        <p>Khách hàng đăng ký mới</p>
                    </div>
                    <p>63%</p>
                </div>
                <div class="div1item2">
                    <div></div>
                    <div class="div1item2color2"></div>
                </div>
            </div>
            <div class="div1item">
                <div class="div1item1">
                    <i class="fa fa-comment-o"></i>
                    <div>
                        <h3>803</h3>
                        <p>Đánh giá mới của khách hàng</p>
                    </div>
                    <p>40%</p>
                </div>
                <div class="div1item2">
                    <div></div>
                    <div class="div1item2color3"></div>
                </div>
            </div>
        </div>

        <div class="div2">
            <div class="div21">
                <h3>
                    <div class="iconheader"></div>
                    Mục tiêu doanh số
                    <div class="lineh3header"></div>
                </h3>
                <p>Tổng hiệu suất của tháng này</p>
                <div class="div21item">
                    <div>
                        <p>Đơn đặt hàng</p>
                        <h3 class="div21itemcolor1">366</h3>
                    </div>
                    <div>
                        <div></div>
                        <div class="div21itemcolor2"></div>
                    </div>
                    <div>
                        <p>Mục tiêu hàng tháng</p>
                        <p>100%</p>
                    </div>
                </div>
                <div class="div21item">
                    <div>
                        <p>Tổng thu nhập</p>
                        <h3 class="div21itemcolor3">127,429,288 VND</h3>
                    </div>
                    <div>
                        <div></div>
                        <div class="div21itemcolor4"></div>
                    </div>
                    <div>
                        <p>Mục tiêu hàng tháng</p>
                        <p>100%</p>
                    </div>
                </div>
            </div>
            <div class="div22">
                <h3>
                    <div class="iconheader"></div>
                    Top khách hàng
                    <div class="lineh3header"></div>
                </h3>
                <div>
                    <div>
                        <div class="div22item">
                            <div>
                                <img src="../../img/product/avatar1.jpg" alt="">
                            </div>
                            <div>
                                <p>Diệu Đặng</p>
                                <p>1,172,000 VND</p>
                            </div>
                            <p>14,240,404 VND</p>
                            <i class="fa fa-angle-up div22up"></i>
                        </div>
                        <div class="div22line"></div>
                        <div class="div22item">
                            <div>
                                <img src="../../img/product/avatar2.jpg" alt="">
                            </div>
                            <div>
                                <p>Nguyễn Văn A</p>
                                <p>499,000 VND</p>
                            </div>
                            <p>13,160,000 VND</p>
                            <i class="fa fa-angle-up div22up"></i>
                        </div>
                        <div class="div22line"></div>
                        <div class="div22item">
                            <div>
                                <img src="../../img/product/avatar3.jpg" alt="">
                            </div>
                            <div>
                                <p>Nguyễn Văn B</p>
                                <p>699,000 VND</p>
                            </div>
                            <p>12,990,000 VND</p>
                            <i class="fa fa-angle-down div22down"></i>
                        </div>
                        <div class="div22line"></div>
                        <div class="div22item">
                            <div>
                                <img src="../../img/product/avatar4.jpg" alt="">
                            </div>
                            <div>
                                <p>Nguyễn Văn D</p>
                                <p>250,000 VND</p>
                            </div>
                            <p>10,060,000 VND</p>
                            <i class="fa fa-angle-down div22down"></i>
                        </div>
                        <div class="div22line"></div>
                        <div class="div22item">
                            <div>
                                <img src="../../img/product/avatar5.jpg" alt="">
                            </div>
                            <div>
                                <p>Nguyễn Văn E</p>
                                <p>1,720,000 VND</p>
                            </div>
                            <p>9,450,000 VND</p>
                            <i class="fa fa-angle-up div22up"></i>
                        </div>
                        <div class="div22line"></div>
                        <div class="div22item">
                            <div>
                                <img src="../../img/product/avatar6.jpg" alt="">
                            </div>
                            <div>
                                <p>Nguyễn Văn F</p>
                                <p>120,000 VND</p>
                            </div>
                            <p>9,230,000 VND</p>
                            <i class="fa fa-angle-down div22down"></i>
                        </div>
                        <div class="div22line"></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="div3">
            <div class="div31">
                <h3>
                    <div class="iconheader"></div>
                    Lịch sử hành động
                    <div class="lineh3header"></div>
                </h3>
                <div>
                    <div>
                        <div class="div31item">
                            <div class="div31itemcolor1">
                                <i class="fa fa-circle"></i>
                                <div></div>
                            </div>
                            <div>
                                <p>5 giây trước</p>
                                <p>Admin <strong>Nguyễn Thị Hoa Hồng</strong> vừa duyệt đơn hàng
                                    <strong>DH1003</strong> cho nhân viên kho <strong>Nguyễn Văn A</strong>
                                </p>
                            </div>
                        </div>
                        <div class="div31item">
                            <div class="div31itemcolor2">
                                <i class="fa fa-circle"></i>
                                <div></div>
                            </div>
                            <div>
                                <p>29 giây trước</p>
                                <p>Admin <strong>Nguyễn Thị Hoa Hồng</strong> vừa duyệt đơn hàng
                                    <strong>DH1002</strong> cho nhân viên kho <strong>Nguyễn Văn B</strong>
                                </p>
                            </div>
                        </div>
                        <div class="div31item">
                            <div class="div31itemcolor3">
                                <i class="fa fa-circle"></i>
                                <div></div>
                            </div>
                            <div>
                                <p>52 giây trước</p>
                                <p>Nhân viên giao hàng<strong> Nguyễn Hữu Đa</strong> vừa xác nhận giao hàng thành
                                    công đơn hàng <strong>DH0994</strong></p>
                            </div>
                        </div>
                        <div class="div31item">
                            <div class="div31itemcolor4">
                                <i class="fa fa-circle"></i>
                                <div></div>
                            </div>
                            <div>
                                <p>2 phút trước</p>
                                <p>Nhân viên kho <strong>Nguyễn Văn A</strong> vừa đóng gói đơn hàng
                                    <strong>DH0998</strong> và giao cho nhân viên giao hàng <strong>Nguyễn Trọng
                                        Cảnh</strong></p>
                            </div>
                        </div>
                        <div class="div31item">
                            <div class="div31itemcolor1">
                                <i class="fa fa-circle"></i>
                                <div></div>
                            </div>
                            <div>
                                <p>5 phút trước</p>
                                <p>Nhân viên kho <strong>Nguyễn Văn B</strong> vừa đóng gói đơn hàng
                                    <strong>DH0999</strong> và giao cho nhân viên giao hàng <strong>Nguyễn Lưu
                                        Ly</strong></p>
                            </div>
                        </div>
                        <div class="div31item">
                            <div class="div31itemcolor2">
                                <i class="fa fa-circle"></i>
                                <div></div>
                            </div>
                            <div>
                                <p>6 phút trước</p>
                                <p>Admin <strong>Nguyễn Thị Hoa Hồng</strong> vừa duyệt đơn hàng
                                    <strong>DH1001</strong> cho nhân viên kho <strong>Nguyễn Văn A</strong>
                                </p>
                            </div>
                        </div>
                        <div class="div31item">
                            <div class="div31itemcolor3">
                                <i class="fa fa-circle"></i>
                                <div></div>
                            </div>
                            <div>
                                <p>7 phút trước</p>
                                <p>Admin <strong>Nguyễn Thị Hoa Hồng</strong> vừa duyệt đơn hàng
                                    <strong>DH1000</strong> cho nhân viên kho <strong>Nguyễn Văn B</strong>
                                </p>
                            </div>
                        </div>
                        <div class="div31item">
                            <div class="div31itemcolor4">
                                <i class="fa fa-circle"></i>
                                <div></div>
                            </div>
                            <div>
                                <p>10 phút trước</p>
                                <p>Nhân viên giao hàng<strong> Nguyễn Văn Đại</strong> vừa xác nhận giao hàng thành
                                    công đơn hàng <strong>DH0992</strong></p>
                            </div>
                        </div>
                        <div class="div31item">
                            <div class="div31itemcolor1">
                                <i class="fa fa-circle"></i>
                                <div></div>
                            </div>
                            <div>
                                <p>15 phút trước</p>
                                <p>Nhân viên giao hàng<strong> Nguyễn Văn Đại</strong> vừa xác nhận giao hàng thành
                                    công đơn hàng <strong>DH0990</strong></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="div32">
                <h3>
                    <div class="iconheader"></div>
                    Những việc cần làm
                    <div class="lineh3header"></div>
                </h3>
                <div>
                    <div>
                        <ul id="vieccanlam">
                            <li>
                                <div class="div32item">
                                    <div>
                                        <p>Duyệt tất cả đơn hàng của tuần này nè :v</p>
                                        <i class="fa fa-close" onclick="removevieccanlam(this)"></i>
                                    </div>
                                    <div class="div32line"></div>
                                </div>
                            </li>
                            <li>
                                <div class="div32item">
                                    <div>
                                        <p>Quản lý một số bình luận bị báo cáo</p>
                                        <i class="fa fa-close" onclick="removevieccanlam(this)"></i>
                                    </div>
                                    <div class="div32line"></div>
                                </div>
                            </li>
                            <li>
                                <div class="div32item">
                                    <div>
                                        <p>Sửa lại mức lương cho nhân viên Nguyễn Văn A</p>
                                        <i class="fa fa-close" onclick="removevieccanlam(this)"></i>
                                    </div>
                                    <div class="div32line"></div>
                                </div>
                            </li>
                            <li>
                                <div class="div32item">
                                    <div>
                                        <p>Thêm nhân viên giao hàng mới Nguyễn Văn L</p>
                                        <i class="fa fa-close" onclick="removevieccanlam(this)"></i>
                                    </div>
                                    <div class="div32line"></div>
                                </div>
                            </li>
                            <li>
                                <div class="div32item">
                                    <div>
                                        <p>Kiểm tra đơn hàng DH1004</p>
                                        <i class="fa fa-close" onclick="removevieccanlam(this)"></i>
                                    </div>
                                    <div class="div32line"></div>
                                </div>
                            </li>
                            <li>
                                <div class="div32item">
                                    <div>
                                        <p>Nhập hàng: Áo thun + Quần Jean nữ</p>
                                        <i class="fa fa-close" onclick="removevieccanlam(this)"></i>
                                    </div>
                                    <div class="div32line"></div>
                                </div>
                            </li>
                            <li>
                                <div class="div32item">
                                    <div>
                                        <p>Nhập hàng xong nhớ luôn là gửi gmail thông báo cho tất cả khách hàng</p>
                                        <i class="fa fa-close" onclick="removevieccanlam(this)"></i>
                                    </div>
                                    <div class="div32line"></div>
                                </div>
                            </li>
                            <li>
                                <div class="div32item">
                                    <div>
                                        <p>Thay đổi hình đại diện</p>
                                        <i class="fa fa-close" onclick="removevieccanlam(this)"></i>
                                    </div>
                                    <div class="div32line"></div>
                                </div>
                            </li>
                            <li>
                                <div class="div32item">
                                    <div>
                                        <p>Thống kế doanh thu</p>
                                        <i class="fa fa-close" onclick="removevieccanlam(this)"></i>
                                    </div>
                                    <div class="div32line"></div>
                                </div>
                            </li>
                            <li>
                                <div class="div32item">
                                    <div>
                                        <p>Duyệt tất cả đơn hàng</p>
                                        <i class="fa fa-close" onclick="removevieccanlam(this)"></i>
                                    </div>
                                    <div class="div32line"></div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <div>
                    <input type="text" placeholder="Việc cần làm" id="inputvieccanlam">
                    <button onclick="addViecCanLam()">+</button>
                </div>
            </div>
        </div>

    </div>

    <!-- Quan tâm nhiêu đây thôi-->
</div>

</body>

</html>
<%}%>