<%@ page import="beans.account.ErrorAddAccount" %>
<%@ page import="beans.account.AccountEmployee" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 9:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVTSHOP ADMIN | Quản lý nhân viên giao hàng</title>
    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="css/indexAdmin.css">
    <script src="js/indexAdmin.js"></script>

    <link rel="stylesheet" href="css/quanLyNVGHAdmin.css">
    <script src="js/Truong/jquery/jquery-3.5.1.min.js" ></script>

    <% ArrayList<AccountEmployee> list = (ArrayList<AccountEmployee>) request.getAttribute("listNVVC");%>

</head>

<body>


<jsp:include page="../share/_LayoutLeft.jsp"/>

<div class="indexright">
    <div class="indextop">
        <h3>TVT<span style="color: #2a2935;">S</span>hop</h3>
        <div class="indextopright">
            <div class="indextopsearch">
                <i class="fa fa-search"></i>
                <input type="text" placeholder="Tìm kiếm">
            </div>
            <div class="indextopbell  dontindextopbellinfor" onclick="indextopbellinfor(this)">
                <i class="fa fa-bell-o"></i>
                <div>
                    <i class="fa fa-circle"></i>
                </div>
                <div class="indextopbellinfor">
                    <i class="fa fa-caret-up"></i>
                    <div>
                        <h3>Thông báo</h3>
                        <div class="indextopbellinforcontent">
                            <div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar1.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong> Diệu Đặng</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar2.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Hoàng Nguyễn</strong> đánh giá trên trang của bạn</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar3.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Sơn</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar4.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Xinh Gái</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar5.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Lê Nguyễn</strong> vừa đánh giá trên trang của bạn</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar6.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Hồng Nhan</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar1.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong> Diệu Đặng</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar2.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Hoàng Nguyễn</strong> đánh giá trên trang của bạn</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar3.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Sơn</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar4.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Xinh Gái</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar5.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Lê Nguyễn</strong> vừa đánh giá trên trang của bạn</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                                <a class="indextopbellinforcontentitem">
                                    <div>
                                        <img src="../../img/product/avatar6.jpg" alt="">
                                    </div>
                                    <div>
                                        <p><strong>Hồng Nhan</strong> vừa thanh toán một đơn hàng</p>
                                        <p>14:32 - 12/10/2020</p>
                                    </div>
                                </a>
                                <div class="lineindextopbellinforcontentitem"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <input type="checkbox" style="display: none;">
            </div>
            <a class="indextopaccount">
                <div>
                    <img src="../../img/product/avatar7.jpg" alt="">
                </div>
                <div>
                    <h3>Nguyễn Thị Hoa Hồng</h3>
                    <p>Admin</p>
                </div>
            </a>
        </div>
    </div>

    <div class="backgroundindexmain">
    </div>

    <!-- Code trang ở đây-->

    <div class="indexmain">
        <div id="div2">
            <div>
                <div class="header">


                    <!---code sử lí search ở đây----->

                    <form action="LoadAccountNVVCController" method="get">
                    <div class="leftheader">
                        <select name="type" id="typeSelect">
                            <option value="RegisDate" selected>Ngày tạo</option>
                            <option value="FullName">Họ và tên</option>
                            <option value="UserName">Tài khoản</option>
                            <option value="Salary">Lương</option>
                            <input type="hidden" name="" id="typeName" value="<%=request.getParameter("type")%>">
                        </select>
                        <div>
                            <div class="leftheadersort" id="order" onclick="changesort2(this)">
                                <i class=" fa fa-sort-amount-desc"  onclick="setOrderBy()"></i>
                                <i class=" fa fa-sort-amount-asc" onclick="setOrderBy()"></i>
                                <input type="checkbox" style="display: none;">
                                <input type="hidden" id="checkSort" name="orderBy" value="${param.orderBy}">
                            </div>
                            <div class="leftheadersearch">

                                <button type="submit" class="timkiem" > <i class="fa fa-search" type="submit" ></i></button>
                                <input name="page" value="1" type="hidden">
                                <input type="text" name="search" class="search2" placeholder="Tìm kiếm" value="${param.search}">

                            </div>
                        </div>
                    </div>

                    </form>

                    <!-- end code--->


                    <!-- xử lí phân trang ở đây-->
                    <div class="leftnextpage">
                        <p>Hiển thị <strong> <%=list.size()%> </strong> trên tổng


                            <%= request.getAttribute("sumEployee") %>

                            nhân viên</p>

                        <%int nowpage = Integer.parseInt(request.getParameter("page"));
                            if(nowpage == 1){
                        %>
                        <a href="LoadAccountNVVCController?page=<%=nowpage%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>" >
                                <%}else { %>
                            <a href="LoadAccountNVVCController?page=<%=nowpage-1%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>" >
                                <%}%>

                                <button><i class="fa fa-caret-left"></i>
                                </button>
                            </a>


                        <ul>

                            <%
                                int listpage = (int) request.getAttribute("numberPage");
                                for (int i = 1;i <= listpage;i++){
                                    if(i == nowpage){
                            %>
                            <li style="background-color: #4162fb; box-shadow: 0 3px 5px #90a3ff;" ><a href="LoadAccountNVVCController?page=<%=i%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>"> <%=i%> </a></li>

                            <%}else{%>
                            <li ><a href="LoadAccountNVVCController?page=<%=i%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>"> <%=i%> </a></li>
                            <%}}%>

                        </ul>

                                        <%
                        if(nowpage == listpage){
                        %>
                        <a href="LoadAccountNVVCController?page=<%=nowpage%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>" >
                        <%}else { %>
                        <a href="LoadAccountNVVCController?page=<%=nowpage+1%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>" >
                         <%}%>
                        <button><i class="fa fa-caret-right"></i></button>
                        </a>




                    </div>

                    <!-- end code--->



                    <!-- sử lí xóa nhiều mục đã chọn, script sử lỉ sự kiện onclick ở dưới cùng-->
                    <button onclick="themkhachhang()"><i class="fa fa-plus"></i>Thêm nhân viên mới</button>
                    <button type="button" id="btDelete"> <i class="fa fa-trash-o"></i>Xóa các mục đã chọn</button>



                </div>
                <div class="maindiv2" id="maindiv2">
                    <div class="maindiv2header">
                        <button onclick="allselect()">+</button>
                        <p>Họ và tên</p>
                        <p>Email</p>
                        <p>Số điện thoại</p>
                        <p>Tài khoản</p>
                        <p>Lương</p>
                        <p>Ngày tạo</p>
                    </div>


                    <!------------------------- Load danh sách nhân viên vận chuyển ở đây------------------>




                    <%

                        for ( AccountEmployee nvvc : list  ) {
                    %>

                    <div class="item">
                        <label for="<%=nvvc.getIdUser()%>">
                            <input type="checkbox" name="nguoi-dung" id="checkRemove_<%=nvvc.getIdUser()%>" value="<%=nvvc.getIdUser()%>">
                        </label>
                        <div class="itemhdd">
                            <img src="<%=nvvc.getAvatar()%>" alt="">
                        </div>
                        <p class="itemname">
                            <%=nvvc.getFullName()%>
                        </p>

                        <p class="itememail">
                            <%=nvvc.getEmail()%>
                        </p>

                        <p class="itemphone">
                            <%=nvvc.getPhone()%>
                        </p>

                        <p class="itemtk">
                            <%=nvvc.getUserName()%>
                        </p>

                        <div></div>
                        <p class="luong"> <%=nvvc.getSalary()%> VND</p>

                        <p class="itemdate">
                            <%=nvvc.getRegisDate().getDay()%> Tháng <%=nvvc.getRegisDate().getMonth()%> <%=nvvc.getRegisDate().getYear()%>
                        </p>

                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button id="sua" onclick="editkhachhang(this)"><i class="fa fa-pencil"></i>Sửa</button>

                                <button type="button" id="<%=nvvc.getIdUser()%>"  onclick="deleteOne(this)"><i class="fa fa-trash"></i>Xóa</button>
                            </div>
                        </div>


                        <div>
                            <div class="div11">
                                <h3>Hồ sơ của bạn</h3>
                                <input id="fileInput1" type="file" style="display:none;"
                                       onchange="loadIMG2(event,this)"/>
                                <div class="div11daidien" onclick="document.getElementById('fileInput1').click()">
                                    <div>
                                        <img src="../../img/user.jpg" alt="">
                                    </div>
                                </div>

                                <button onclick="document.getElementById('fileInput1').click()">Thay đổi
                                    ảnh đại diện
                                    mới
                                </button>
                                <button onclick="removeIMG2()">Xóa ảnh đại diện</button>

                            </div>

                            <form action="EditAccountNVKController?IDUser=<%=nvvc.getIdUser()%>" method="post">
                                <div class="div12">
                                    <h3>Điền thông tin cá nhân</h3>
                                    <div class="linediv12"></div>
                                    <div class="div12input">
                                        <label for="">* Họ và tên</label>
                                        <input type="text" name="fullName" placeholder="Nhập họ và tên ở đây"
                                               value="<%=nvvc.getFullName()%>">
                                    </div>
                                    <div class="div12input">
                                        <label for="">Tên hiển thị</label>
                                        <input type="text" name="displayName" placeholder="Nhập tên hiển thị ở đây"
                                               value="<%=nvvc.getDisplayName()%>">
                                    </div>
                                    <div class="div12input">
                                        <label for="">* Email</label>
                                        <input type="text" name="" placeholder="Nhập email ở đây"
                                               value="<%=nvvc.getEmail()%>" disabled>
                                    </div>
                                    <div class="div12input">
                                        <label for="">* Số điện thoại</label>
                                        <input type="text" name="" placeholder="Nhập số điện thoại ở đây" value="<%=nvvc.getPhone()%>"
                                               disabled>
                                    </div>
                                    <div class="linediv12"></div>
                                    <div class="trangthai">
                                        <div class="div12inputlv2">
                                            <label for="">Tỉnh / Thành</label>
                                            <select name="tinh" >
                                                <option value="">Chọn tỉnh / thành</option>
                                                <option value="" selected>Hưng Yên</option>
                                            </select>
                                        </div>
                                        <div class="div12inputlv2">
                                            <label for="">Quận / huyện</label>
                                            <select name="huyen" id="">
                                                <option value="">Chọn quận / huyện</option>
                                                <option value="" selected>Quận Đại Nam</option>
                                            </select>
                                        </div>
                                        <div class="div12inputlv2">
                                            <label for="">Phường / xã</label>
                                            <select name="xa" id="">
                                                <option value="">Chọn phường / xã</option>
                                                <option value="" selected>Xã Góm Đỏ</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="linediv12"></div>
                                    <div class="div12input">
                                        <label for="">* Tài khoản</label>
                                        <input type="text" placeholder="Nhập tên tài khoản ở đây" value="<%=nvvc.getUserName()%>"
                                               disabled>
                                    </div>
                                    <div class="div12input">
                                        <label for="">* Mật khẩu</label>
                                        <input name="passWord" type="password" placeholder="Nhập mật khẩu ở đây" value="">
                                    </div>
                                    <div class="div12input">
                                        <label for="">* Xác nhận</label>
                                        <input name="rePassWord" type="password" placeholder="Xác nhận mật khẩu ở đây" value="">
                                    </div>
                                </div>

                                <div class="div13">
                                    <div class="div12input">
                                        <label for="">* Lương</label>
                                        <input name="salary" type="text" placeholder="Nhập lương ở đây" value="<%=nvvc.getSalary()%>">
                                    </div>
                                    <div class="linediv12"></div>
                                    <div class="div12input">
                                        <label for="">Giới thiệu</label>
                                        <input name="info" type="text" placeholder="Nhập số giới thiệu ở đây"
                                               value="<%=nvvc.getInfo()%>">
                                    </div>
                                    <div class="linediv12"></div>
                                    <button  type="submit"><i class="fa fa-save"></i>Lưu</button>

                                    <button type="button" onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                                        lý
                                    </button>
                                </div>
                            </form>
                        </div>

                    </div>

                    <%}%>




                </div>
            </div>
        </div>


        <form action="them-tai-khoan-nhan-vien-van-chuyen" method="post">
            <div id="div1">
                <div>
                    <div class="div11">
                        <h3>Hồ sơ của bạn</h3>
                        <input id="fileInput12" type="file" style="display:none;" onchange="loadIMG(event,this)"/>
                        <div class="div11daidien" onclick="document.getElementById('fileInput12').click()">
                            <div>
                                <img src="../../img/user.jpg" alt="">
                            </div>
                        </div>

                        <button onclick="document.getElementById('fileInput12').click()">Thay đổi ảnh đại diện
                            mới
                        </button>
                        <button onclick="removeImg()">Xóa ảnh đại diện</button>

                    </div>

                    <div class="div12">
                        <h3>Điền thông tin cá nhân</h3>
                        <div class="linediv12"></div>
                        <div class="div12input">
                            <label for="">* Họ và tên</label>
                            <input name="full-name" value="${param["full-name"]}" type="text" placeholder="Nhập họ và tên ở đây">
                        </div>
                        <div class="div12input">
                            <label for="">Tên hiển thị</label>
                            <input name="display-name" value="${param["display-name"]}" type="text" placeholder="Nhập tên hiển thị ở đây">
                        </div>
                        <div class="div12input">
                            <label for="">* Email</label>
                            <input name="email" value="${param["email"]}" type="text" placeholder="Nhập email ở đây">
                        </div>
                        <div class="div12input">
                            <label for="">* Số điện thoại</label>
                            <input name="phone" value="${param["phone"]}" type="text" placeholder="Nhập số điện thoại ở đây">
                        </div>
                        <div class="linediv12"></div>
                        <div class="trangthai">
                            <div class="div12inputlv2">
                                <label for="">Tỉnh / Thành</label>
                                <select name="tinh" id="">
                                    <option value="">Chọn tỉnh / thành</option>
                                </select>
                            </div>
                            <div class="div12inputlv2">
                                <label for="">Quận / huyện</label>
                                <select name="huyen" id="">
                                    <option value="">Chọn quận / huyện</option>
                                </select>
                            </div>
                            <div class="div12inputlv2">
                                <label for="">Phường / xã</label>
                                <select name="xa" id="">
                                    <option value="">Chọn phường / xã</option>
                                </select>
                            </div>
                        </div>
                        <div class="linediv12"></div>
                        <div class="div12input">
                            <label for="">* Tài khoản</label>
                            <input name="userName" value="${param["userName"]}" type="text" placeholder="Nhập tên tài khoản ở đây">
                        </div>
                        <div class="div12input">
                            <label for="">* Mật khẩu</label>
                            <input name="passWord" type="password" placeholder="Nhập mật khẩu ở đây">
                        </div>
                        <div class="div12input">
                            <label for="">* Xác nhận</label>
                            <input name="rePassWord" type="text" placeholder="Xác nhận mật khẩu ở đây">
                        </div>
                    </div>

                    <div class="div13">
                        <div class="div12input">
                            <label for="">* Lương</label>
                            <input name="salary" value="${param["salary"]}" type="number" placeholder="Nhập lương ở đây">
                        </div>
                        <div class="linediv12"></div>
                        <div class="div12input">
                            <label for="">Giới thiệu</label>
                            <input name="gioi-thieu" type="number"  value="${param["gioi-thieu"]}" placeholder="Nhập số giới thiệu ở đây">
                        </div>
                        <div class="linediv12"></div>
                        <button type="submit"><i class="fa fa-plus"></i>Thêm nhân viên</button>
                        <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</button>
                    </div>
                </div>
            </div>
        </form>


        <!---------------------------------------check---------------------------!>
        <%
        //lấy status ra
            if (request.getAttribute("status") != null) {

                String status = (String) request.getAttribute("status");

                //truyển status vào để sử lí
                ErrorAddAccount errorAccount = new ErrorAddAccount(status);

        %>

        <!--lúc request lại thì về lại cái form-->
        <script>
            document.getElementById("div1").style.display = "flex";
            document.getElementById("div2").style.display = "none";
            document.getElementById("div3").style.display = "none";
        </script>

        <%request.setCharacterEncoding("utf-8");%>
        <jsp:include page="../NotifyErrorAccount/AccountStatus.jsp">
            <jsp:param name="title" value="<%=errorAccount.getTitle()%>"/>
            <jsp:param name="content" value="<%=errorAccount.getContent()%>"/>
        </jsp:include>

        <%
            }
        %>

        <div id="div3">
        </div>
    </div>

    <!-- Quan tâm nhiêu đây thôi-->
</div>

</body>

</html>

<script>
    <!--sử lí click vào cái sắp xếp nó set lại value -->
    function setOrderBy(){
        if(document.getElementById("checkSort").value == "ASC"){
            document.getElementById("checkSort").value = "DESC";
        }else{
            document.getElementById("checkSort").value = "ASC";
        }
    }


    <!-- sử lí cự kiện onlick button xóa 1 nhân viên cụ thể-->
    function deleteOne(event){
        var data = $(event).attr('id');
        console.log(data);
        deleteE(data);
    }

    <!-- sử lí cự kiện onlick xóa nhiều mục-->
    $('#btDelete').click(function (){
        var data = {};
        var dis = $('#maindiv2 input[type = checkbox]:checked').map(function (){
            return $(this).val();

        }).get();

        data = dis;
        console.log(data);

        deleteE(data);
    });


    function deleteE(data){
        $.ajax({
            url:'RemoveAccountNVVCController',
            contentType:'application/json',
            type:'get',
            data: {
                list: JSON.stringify(data)
            },
            success: function (result){
                alert("Xóa thành công");
                window.location.href = "LoadAccountNVVCController?page=<%=request.getParameter("page")%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>";
            },
            error: function (){
                alert("Xóa thất bại");
                window.location.href = "LoadAccountNVVCController?page=<%=request.getParameter("page")%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>";
            }
        });
    }

    <!--sử lí load lại thì có giá trị trước cho cho cái select -->
    $(function (){
        var typename = $('#typeName').attr('value');
        let list =  document.getElementById("typeSelect").children;

        if(typename == "RegisDate"){
            $('select#typeSelect option[value= "RegisDate" ]').prop('selected', true);
        }else if(typename == "FullName"){
            $('select#typeSelect option[value= "FullName" ]').prop('selected', true);
        }else if(typename == "UserName"){
            $('select#typeSelect option[value= "UserName" ]').prop('selected', true);
        }else{
            $('select#typeSelect option[value= "Salary" ]').prop('selected', true);
        }
    });

    $(function (){
        var order = $('#checkSort').attr('value') ;
        let list =  document.getElementById("order").children;

        if(order == "DESC"){

            if (list[2].checked == true) {
                list[2].checked = false;
                list[1].style.display = "none";
                list[0].style.display = "block";
                //list[0].style.marginTop = "0px";
            }
        }else{
            if (list[2].checked == false) {
                list[2].checked = true;
                list[0].style.display = "none";
                list[1].style.display = "block";
                //list[1].style.marginTop = "-9px";
            }
        }

    });

</script>


<script src="js/quanLyNVGHAdmin.js"></script>
