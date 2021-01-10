<%@ page import="beans.account.ErrorAddAccount" %>
<%@ page import="beans.account.AccountCustomer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 9:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVTSHOP ADMIN | Quản lý khách hàng</title>
    <script src="js/Truong/jquery/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="js/Truong/jquery/jquery-3.5.1.min.js">

    <link rel="stylesheet" href="css/indexAdmin.css">

    <link rel="stylesheet" href="css/quanLyKhachHangAdmin.css">


    <% ArrayList<AccountCustomer> list = (ArrayList<AccountCustomer>) request.getAttribute("listKH");%>


</head>

<body>

<%--<jsp:include page="../share/_LayoutLeft.jsp">--%>

<%--</jsp:include>--%>

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


                    <!--code------------------------------------------------------------------->


                        <div class="leftheader">
                            <select name="type" onchange="loadKH()" id="typeSelect" >
                                <option value="ngay_tao" selected>Ngày tạo</option>
                                <option value="ten_day_du">Họ và tên</option>
                                <option value="tai_khoan">Tài khoản</option>
                            </select>
                            <div>
                                <div class="leftheadersort" id="order" onclick="changesort2(this)">
                                    <i class=" fa fa-sort-amount-desc" onclick="setOrderBy()"></i>
                                    <i class=" fa fa-sort-amount-asc" onclick="setOrderBy()"></i>
                                    <input type="checkbox" style="display: none;">
                                    <input type="hidden" id="checkSort" name="orderBy" value="DESC">
                                </div>
                                <div class="leftheadersearch">
                                    <button type="submit" class="timkiem" disabled > <i class="fa fa-search" type="submit" ></i></button>
<%--                                    <input name="page" value="1" type="hidden">--%>
                                    <input type="text" id="resultSearch" name="search" class="search2" placeholder="Tìm kiếm" value="" oninput="loadKH()">

                                </div>
                            </div>
                        </div>





                    <button onclick="themkhachhang()" style="position: absolute;left: 350px;"><i class="fa fa-plus"></i>Thêm khách hàng mới</button>
                    <button id="btDelete" style="position: absolute;left: 535px; background-color: #80808061;"><i class="fa fa-trash-o"></i>Xóa các mục đã chọn</button>
                </div>
                <div class="maindiv2" id="maindiv2">



<%--                    <%--%>

<%--                        for ( AccountCustomer k : list  ) {--%>
<%--                    %>--%>

<%--                    --%>

<%--                    <%}%>--%>
                </div>
            </div>
        </div>

        <input type="hidden" name="" id="page" value="1">

        <form action="../../them-tai-khoan-khach-hang" method="post">
            <div id="div1">
                <div>
                    <div class="div11">
                        <h3>Hồ sơ của bạn</h3>
                        <input name="avatar" value="../../img/user.jpg" id="fileInput12" type="file" style="display:none;" onchange="loadIMG(event)"/>
                        <div class="div11daidien" onclick="document.getElementById('fileInput12').click()">
                            <div>
                                <img id="avatar" src="../../img/user.jpg" alt="">
                            </div>
                        </div>

                        <button type="button" onclick="document.getElementById('fileInput12').click()">Thay đổi ảnh đại diện
                            mới
                        </button>
                        <button type="button" onclick="removeImg()">Xóa ảnh đại diện</button>

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
                            <input name="dispaly-name" value="${param["display-name"]}" type="text" placeholder="Nhập tên hiển thị ở đây">
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
                                <label for="">Trạng thái kích hoạt</label>
                                <select name="ttkh" id="">
                                    <option value="1">Đã kích hoạt</option>
                                    <option value="0">Chưa kích hoạt</option>
                                </select>
                            </div>
                            <div class="div12inputlv2">
                                <label for="">Trạng thái đánh giá</label>
                                <select name="ttdg" id="">
                                    <option value="1">Cho phép đánh giá</option>
                                    <option value="0">Cấm đánh giá</option>
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
                        <button type="submit"><i class="fa fa-plus"></i>Thêm khách hàng</button>
                        <button type="button" onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</button>
                    </div>
                </div>
            </div>
        </form>



<!---------------------------------------check--------------------------->
        <%
        //lấy status ra
            if (request.getAttribute("status") != null) {

                String status = (String) request.getAttribute("status");

                //truyển status vào để sử lí
                ErrorAddAccount errorAccount = new ErrorAddAccount(status);

        %>
        <%request.setCharacterEncoding("utf-8");%>

        <!--lúc request lại thì về lại cái form-->
        <script>
            document.getElementById("div1").style.display = "flex";
        document.getElementById("div2").style.display = "none";
        document.getElementById("div3").style.display = "none";
        </script>


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
            const folder = "Avatar/" + nameData;
            const metadata = {contentType: file.type};
            let urlm;
            const task = ref.child(folder).put(file, metadata);
            task
                .then(snapshot => snapshot.ref.getDownloadURL())
                .then(url => {
                    alert("Thanh cong");
                    document.getElementById('avataredit').src = url;
                    document.getElementById("loadAvatar").value = url;
                    urlm = url;

                    link = url;
                    firebase.database().ref(folder).set({
                        Name: nameData,
                        Link: link
                    })
                });

// Lấy dữ liệu xuống như lấy thuộc tính từ đối tượng ra , chỉ cần truyền đúng link thì oke
//             firebase.database().ref().on('value', function (snapshot) {
//                 document.getElementById('avatar').src = snapshot.val().Link;
//                 document.getElementById('avatar2').src = snapshot.val().Link;
//                 document.getElementById("loadAvatar").value = snapshot.val().Link;
//             })
        }
    }

<%--    function removeAvatar() {--%>

<%--        document.getElementById('avatar').src = '../img/user.jpg';--%>
<%--        document.getElementById('avatar2').src = '../img/user.jpg';--%>
<%--// xoá thì truyền link vào--%>
<%--//database--%>
<%--        firebase.database().ref(<%=accountCustomer.getAvatar()%>).remove();--%>
<%--        // img--%>
<%--        firebase.storage().ref(<%=accountCustomer.getAvatar()%>).delete();--%>


<%--    }--%>

</script>

<script>
    function changesort2(item) {
        let list = item.children;
        if (list[2].checked == false) {
            list[2].checked = true;
            list[0].style.display = "none";
            list[1].style.display = "block";
            item.style.marginTop = "0px";
        } else {
            list[2].checked = false;
            list[1].style.display = "none";
            list[0].style.display = "block";
            item.style.marginTop = "-5px";
        }
    }
    <!--sử lí click vào cái sắp xếp nó set lại value -->
    function setOrderBy(){
        if(document.getElementById("checkSort").value == "ASC"){
            document.getElementById("checkSort").value = "DESC";
        }else{
            document.getElementById("checkSort").value = "ASC";
        }
    loadKH();
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
    <!-- sử lí cự kiện onlick button xóa 1 nhân viên cụ thể-->
    function deleteOne(event){
        var data = $(event).attr('id');
        deleteE(data);
    }

    function deleteE(data){
        console.log(data);
        $.ajax({
            url:'RemoveAccountHKController',
            contentType:'application/json',
            type:'get',
            data: {
                list: JSON.stringify(data)
            },
            success: function (result){
                alert("Xóa thành công");
                window.location.href = "LoadAccountKHController?page=<%=request.getParameter("page")%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>";
            },
            error: function (){
                alert("Xóa thất bại");
                window.location.href = "LoadAccountKHController?page=<%=request.getParameter("page")%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>";
            }
        });
    }

    <!--sử lí load lại thì có giá trị trước cho cho cái select -->
    // $(function (){
    //     var typename = $('#typeName').attr('value');
    //     let list =  document.getElementById("typeSelect").children;
    //
    //     if(typename == "RegisDate"){
    //         $('select#typeSelect option[value= "RegisDate" ]').prop('selected', true);
    //     }else if(typename == "FullName"){
    //         $('select#typeSelect option[value= "FullName" ]').prop('selected', true);
    //     }else if(typename == "UserName"){
    //         $('select#typeSelect option[value= "UserName" ]').prop('selected', true);
    //     }
    // });

    // $(function (){
    //     var order = $('#checkSort').attr('value') ;
    //     let list =  document.getElementById("order").children;
    //
    //     if(order == "DESC"){
    //
    //         if (list[2].checked == true) {
    //             list[2].checked = false;
    //             list[1].style.display = "none";
    //             list[0].style.display = "block";
    //             //list[0].style.marginTop = "0px";
    //         }
    //     }else{
    //         if (list[2].checked == false) {
    //             list[2].checked = true;
    //             list[0].style.display = "none";
    //             list[1].style.display = "block";
    //             //list[1].style.marginTop = "-9px";
    //         }
    //     }
    //
    // });

</script>


<script >

    function changePage(event){
        var page = $(event).attr("id");
        document.getElementById("page").value = page;
        loadKH();
    }
    function loadKH(){

        var page = $('#page').val();
        var type = $('#typeSelect').val();
        var search = $('#resultSearch').val();
        var orderBy = $('#checkSort').val();
        console.log(page);
        console.log(type);
        console.log(search);
        console.log(orderBy);

        $.ajax({
            url: 'LoadAccountKH_AjaxController',
            type: 'get',
            dataType:'html',
            data:{
                page:page,
                type:type,
                search:search,
                orderBy:orderBy
            },
            success:function (data){
                $('#maindiv2').html(data);
            },
            error:function (){
                alert("loi r");
            }
        })
    };



  $(document).ready(function (){

        $.ajax({
            url: 'LoadAccountKH_AjaxController',
            type: 'get',
            dataType:'html',
            data:{
                page:1,
                type:'ngay_tao',
                search:'',
                orderBy:'DESC'
            },
            success:function (data){
                $('#maindiv2').html(data);
            },
            error:function (){
                alert("loi r");
            }
        })
    });

</script>


<script src="js/quanLyKhachHangAdmin.js"></script>
<script src="js/Truong/jquery/jquery-3.5.1.min.js"></script>

