<%@ page import="beans.loginAdmin.UserAdmin" %>
<%@ page import="beans.loginAdmin.AccountStaffAdmin" %>
<%@ page import="beans.informationAccountAdmin.InformationAccountAdminObject" %>
<%@ page import="model.phoneNumber.PhoneNumberModel" %>
<%@ page import="model.password.PasswordModel" %>
<%@ page import="model.salary.SalaryModel" %>
<%@ page import="model.personalNotice.PersonalNoticeModel" %>
<%@ page import="beans.personalNotice.PersonalNotice" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 9:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVTSHOP ADMIN | Tài khoản Admin</title>
    <link rel="stylesheet" href="../../fonts/font-awesome-4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="../../css/indexAdmin.css">
    <script src="../../js/Truong/jquery/jquery-3.5.1.min.js"></script>
    <script src="../../js/indexAdmin.js"></script>


    <link rel="stylesheet" href="../../css/thongTinTaiKhoanAdminAdmin.css">

    <!-- CKEDitor -->
    <script src="../../ckeditor/ckeditor.js"></script>


</head>

<body>

<%
    //----------------------Kiểm tra thử đăng nhập hay chưa và có vai trò ở trang này hay không------------------------------------//
    if(request.getSession().getAttribute("userAdmin") == null) {

        //  Lưu vô session biến trang chờ đợi là trang này để có gì đăng nhập thành công chuyển tới trang này
        request.getSession().setAttribute("trackPage","admin.thongTinTaiKhoanAdmin");

        //  Lưu trackpage xong thì sendredirect tới login
        response.sendRedirect("login.jsp");

    }else{

        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        AccountStaffAdmin accountStaffAdmin = userAdmin.getAccount();
        if(accountStaffAdmin.accept("admin.thongTinTaiKhoanAdmin")){

            InformationAccountAdminObject informationAccountAdminObject  = (InformationAccountAdminObject) userAdmin.getListOfFunction().get("informationAccountAdminObject");
            if(informationAccountAdminObject == null || !informationAccountAdminObject.isReady()){
                response.sendRedirect("../../InformationAccountAdminController");
            }else {
%>


<jsp:include page="../share/_LayoutLeft.jsp">
    <jsp:param name="activeSelect" value="thongTinTaiKhoanAdmin"/>
</jsp:include>

<div class="indexright">

    <jsp:include page="../share/_LayoutTop.jsp">
        <jsp:param name="level" value="Admin"/>
    </jsp:include>

    <!-- Code trang ở đây-->

    <div class="indexmain">

        <div id="div2">
            <div class="div1">
                <div>
                    <div>
                        <p><%=userAdmin.getAccount().getDisplayName()%></p>
                        <p>Admin</p>
                    </div>
                </div>

                <div class="headeright">
                    <div>
                        <button id="motchutvetoi" class="activebutton" onclick="motchutvetoi()">Một chút về
                            tôi
                        </button>
                        <button id="thongtinchitiet" onclick="thongtinchitiet()">Thông tin chi tiết</button>
                    </div>
                    <div>
                        <button onclick="thaydoithongtin()"><i class="fa fa-cog"></i>Thay đổi thông tin</button>
                    </div>
                </div>
                <div class="hinhdaidien">
                    <div>
                        <img src="<%=userAdmin.getAccount().getAvatarLink()%>" alt="">
                    </div>
                </div>
            </div>
            <div class="adiv12">
                <div class="div121" id="div121">
                    <div>
                        <h3>Giới thiệu: </h3>
                        <div>
                            <p><%=userAdmin.getAccount().getIntroduce()%></p>
                        </div>
                    </div>
                    <div>
                        <div>
                            <p><%=informationAccountAdminObject.getOrderApproval()%></p>
                            <p>Thao tác đơn hàng</p>
                        </div>
                        <div>
                            <p><%=informationAccountAdminObject.getNumberOfImportProduct()%></p>
                            <p>Số lần nhập hàng</p>
                        </div>
                        <div>
                            <p><%=informationAccountAdminObject.getSumImportProduct()%></p>
                            <p>Số sản phẩm nhập</p>
                        </div>
                    </div>
                </div>
                <div class="div122" id="div122">
                    <div class="div122item">
                        <p>Họ và tên: </p>
                        <p><%=userAdmin.getAccount().getFullName()%></p>
                    </div>
                    <div class="div122item">
                        <p>Email: </p>
                        <p><%=userAdmin.getAccount().getEmail()%></p>
                    </div>
                    <div class="div122item">
                        <p>Số điện thoại: </p>
                        <p><%=PhoneNumberModel.getInstance().numberToNumberAndDot(userAdmin.getAccount().getPhoneNumber())%></p>
                    </div>
                    <div class="div122item">
                        <p>Tên hiển thị: </p>
                        <p><%=userAdmin.getAccount().getDisplayName()%></p>
                    </div>
                    <div class="div122item">
                        <p>Tài khoản: </p>
                        <p><%=userAdmin.getAccount().getAccount()%></p>
                    </div>
                    <div class="div122item">
                        <p>Mật khẩu: </p>
                        <p><%=PasswordModel.getInstance().coverPasswordToStars(userAdmin.getAccount().getPassword())%></p>
                    </div>
                    <div class="div122item">
                        <p>Địa chỉ: </p>
                        <p><%=userAdmin.getAccount().getCommune().toString()%> - <%=userAdmin.getAccount().getDistrict().toString()%> - <%=userAdmin.getAccount().getProvincial().toString()%></p>
                    </div>
                    <div class="div122item">
                        <p>Lương: </p>
                        <p><%=SalaryModel.getInstance().coverSalaryToString(userAdmin.getAccount().getSalary())%></p>
                    </div>
                </div>
            </div>

            <div class="adiv13">
                <div class="div31">
                    <h3>
                        <div class="iconheader"></div>
                        Lịch sử hành động của bạn
                        <div class="lineh3header"></div>
                    </h3>
                    <div>
                        <div>

                            <%
                                //  Lấy list thông báo cá nhân của userNay xong đổ ra
                                List<PersonalNotice> personalNoticeList = PersonalNoticeModel.getInstance().getAllPersonalNoticeFromId(userAdmin.getAccount().getId());
                                for(int i =0; i < personalNoticeList.size();i++){
                            %>

                            <div class="div31item">
                                <div class="div31itemcolor<%=i%4+1%>">
                                    <i class="fa fa-circle"></i>
                                    <div></div>
                                </div>
                                <div>
                                    <p><%=personalNoticeList.get(i).getOverTime()%></p>
                                    <p><strong><%=personalNoticeList.get(i).getContent_1()%></strong> <%=personalNoticeList.get(i).getContent_2()%>
                                        <strong><%=personalNoticeList.get(i).getContent_3()%></strong> <%=personalNoticeList.get(i).getContent_4()%> <strong><%=personalNoticeList.get(i).getContent_5()%></strong>
                                    </p>
                                </div>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div  class="hidden" id="div3">
            <div>
                <div class="div11">
                    <h3>Hồ sơ của bạn</h3>
                    <input id="fileInput1" type="file" style="display:none;" onchange="loadIMG2(event,this)"/>
                    <div class="div11daidien" onclick="document.getElementById('fileInput1').click()">
                        <div>
                            <img src="../../img/product/avatar7.jpg" alt="">
                        </div>
                    </div>

                    <button onclick="document.getElementById('fileInput1').click()">Thay đổi
                        ảnh đại diện
                        mới
                    </button>
                    <button onclick="removeIMG2()">Xóa ảnh đại diện</button>

                </div>

                <div class="div12">
                    <h3>Điền thông tin cá nhân</h3>
                    <div class="linediv12"></div>
                    <div class="div12input">
                        <label for="">* Họ và tên</label>
                        <input type="text" placeholder="Nhập họ và tên ở đây" value="Nguyễn Thị Hoa Hồng">
                    </div>
                    <div class="div12input">
                        <label for="">Tên hiển thị</label>
                        <input type="text" placeholder="Nhập tên hiển thị ở đây" value="">
                    </div>
                    <div class="div12input">
                        <label for="">* Email</label>
                        <input type="text" placeholder="Nhập email ở đây" value="nguyenthihoahong@gmail.com"
                               disabled>
                    </div>
                    <div class="div12input">
                        <label for="">* Số điện thoại</label>
                        <input type="text" placeholder="Nhập số điện thoại ở đây" value="0971-122-209">
                    </div>
                    <div class="div12input">
                        <label for="">* Lương</label>
                        <input type="text" placeholder="Nhập lương ở đây" value="20,000,000">
                    </div>
                    <div class="linediv12"></div>
                    <div class="trangthai">
                        <div class="div12inputlv2">
                            <label for="">Tỉnh / Thành</label>
                            <select name="" id="">
                                <option value="">Chọn tỉnh / thành</option>
                                <option value="" selected>Phú Yên</option>
                            </select>
                        </div>
                        <div class="div12inputlv2">
                            <label for="">Quận / huyện</label>
                            <select name="" id="">
                                <option value="">Chọn quận / huyện</option>
                                <option value="" selected>Huyện Đồng Xuân</option>
                            </select>
                        </div>
                        <div class="div12inputlv2">
                            <label for="">Phường / xã</label>
                            <select name="" id="">
                                <option value="">Chọn phường / xã</option>
                                <option value="" selected>Xã Đa Lộc</option>
                            </select>
                        </div>
                    </div>
                    <div class="linediv12"></div>
                    <div class="div12input">
                        <label for="">* Tài khoản</label>
                        <input type="text" placeholder="Nhập tên tài khoản ở đây" value="adminhong" disabled>
                    </div>
                    <div class="div12input">
                        <label for="">* Mật khẩu</label>
                        <input type="password" placeholder="Nhập mật khẩu ở đây" value="mothaiba@@">
                    </div>
                    <div class="div12input">
                        <label for="">* Xác nhận</label>
                        <input type="password" placeholder="Xác nhận mật khẩu ở đây" value="mothaiba@@">
                    </div>
                </div>

                <div class="div13">

                    <div class="div12input formckgioithieu">
                        <textarea name="gioiThieu" id="gioiThieu" placeholder="Nhập giới thiệu ở đây"></textarea>
                    </div>
                    <button onclick="getData()"><i class="fa fa-save"></i>Lưu</button>
                    <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                        lý
                    </button>
                </div>
            </div>
        </div>
    </div>

    <!-- Quan tâm nhiêu đây thôi-->
</div>

</body>

</html>

<script src="../../js/thongTinTaiKhoanAdminAdmin.js"></script>
<%     }

}else{

    //  Tài khoản không có vai trò ở trang này thì ta tới controller điều hướng trang chủ để nó đến trang chủ tương ứng
    response.sendRedirect("../../AdminIndexNavigation");

}
}

    //------------------------------------------------------------------------------------------------------------------------------//

%>