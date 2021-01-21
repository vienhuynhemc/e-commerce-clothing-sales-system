<%@ page import="beans.loginAdmin.UserAdmin" %>
<%@ page import="beans.loginAdmin.AccountStaffAdmin" %>
<%@ page import="beans.informationAccountNVGH.InformationAccountNVGHObject" %>
<%@ page import="model.phoneNumber.PhoneNumberModel" %>
<%@ page import="model.password.PasswordModel" %>
<%@ page import="model.salary.SalaryModel" %>
<%@ page import="beans.personalNotice.PersonalNotice" %>
<%@ page import="java.util.List" %>
<%@ page import="model.personalNotice.PersonalNoticeModel" %>
<%@ page import="beans.address.Provincial" %>
<%@ page import="beans.address.District" %>
<%@ page import="beans.address.Commune" %><%--
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
    <title>TVTSHOP ADMIN | Tài khoản nhân viên giao hàng</title>
    <link rel="stylesheet" href="../../fonts/font-awesome-4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="../../css/indexAdmin.css">
    <script src="../../js/Truong/jquery/jquery-3.5.1.min.js"></script>
    <script src="../../js/indexAdmin.js"></script>


    <link rel="stylesheet" href="../../css/thongTinTaiKhoanNVGHAdmin.css">

    <!-- CKEDitor -->
    <script src="../../ckeditor/ckeditor.js"></script>


</head>

<body>

<%
    //----------------------Kiểm tra thử đăng nhập hay chưa và có vai trò ở trang này hay không------------------------------------//
    if(request.getSession().getAttribute("userAdmin") == null) {

        //  Lưu vô session biến trang chờ đợi là trang này để có gì đăng nhập thành công chuyển tới trang này
        request.getSession().setAttribute("trackPage","admin.thongTinTaiKhoanNVGH");

        //  Lưu trackpage xong thì sendredirect tới login
        response.sendRedirect("login.jsp");

    }else{

        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        AccountStaffAdmin accountStaffAdmin = userAdmin.getAccount();
        if(accountStaffAdmin.accept("admin.thongTinTaiKhoanNVGH")){

            InformationAccountNVGHObject informationAccountNVGHObject  = ( InformationAccountNVGHObject) userAdmin.getListOfFunction().get("informationAccountNVGHObject");
            if(informationAccountNVGHObject == null || !informationAccountNVGHObject.isReady()){
                response.sendRedirect("../../InformationAccountNVGHController");
            }else {
                request.setCharacterEncoding("UTF-8");
%>

<!-------------------------------------------------------------------------------------------------------------------------------->
<!----------------------------------------------------- Form yes no ------------------------------------------------->
<div id="formYesNo">
    <div class="formYesNoHidden" onclick="hiddenFormYesNo()"></div>
    <div>
        <p>
            <i class="fa fa-cogs"></i> TVT Shop
        </p>
        <div>
            <p id="formYesNoTitle"></p>
            <p id="formYesNoTitle2"></p>
            <div>
                <a id="formYesNoLink">Có, chắc chắn <i class="fa fa-check"></i> </a>
                <span onclick="hiddenFormYesNo()" id="buttonNoFormYesNo">Không, suy nghĩ thêm <i class="fa fa-close"></i></span>
            </div>
        </div>
    </div>
</div>

<%
    //  Nếu như có thông báo thì hiển thị
    if (informationAccountNVGHObject.isNotify()) {

        //  Thông báo xong thì để lại trạng thái ban đầu
        informationAccountNVGHObject.setNotify(false);

%>
<div id="notifiSuccess">
    <div class="notifiSuccessHidden" onclick="hiddenNotifiSuccess()"></div>
    <div>
        <p>
            <i class="fa fa-cogs"></i> TVT Shop
        </p>
        <div>
            <p><%=informationAccountNVGHObject.getTitle()%></p>
            <p><%=informationAccountNVGHObject.getContent()%> <i class="fa fa-hand-grab-o"></i></p>
            <div>
                <span onclick="hiddenNotifiSuccess()">Trở về<i class="fa fa-close"></i></span>
            </div>
        </div>
    </div>
</div>
<%}%>
<!------------------------------------------------------------------------------------------------------------------->



<jsp:include page="../share/_LayoutLeftNVGH.jsp">
    <jsp:param name="activeSelect" value="thongTinTaiKhoanNVGH"/>
</jsp:include>

<div class="indexright">

    <jsp:include page="../share/_LayoutTop.jsp">
        <jsp:param name="level" value="Nhân viên giao hàng"/>
    </jsp:include>

    <!-- Code trang ở đây-->

    <div class="indexmain">

        <div id="div2"
                <%if(informationAccountNVGHObject.isEdit()){%>
             class="hidden"
                <%}%>
        >
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
                        <span onclick="thayDoiThongTin()"><i class="fa fa-cog"></i>Thay đổi thông tin</span>
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
                        <div id="introductuser">
                            <%=informationAccountNVGHObject.getIntroduct()%>
                        </div>
                    </div>
                    <div>
                        <div>
                            <p><%=informationAccountNVGHObject.getOrderApproval()%></p>
                            <p>Thao tác đơn hàng</p>
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

        <form
                <%if(!informationAccountNVGHObject.isEdit()){%>
                class="hidden"
                <%}%> method="POST" action="../../InformationAccountNVGHController"
                id="div3">
            <div>
                <div class="div11">
                    <h3>Hồ sơ của bạn</h3>
                    <input id="fileInput1" type="file" style="display:none;" onchange="loadIMG2(event,this)"/>
                    <div class="div11daidien" onclick="document.getElementById('fileInput1').click()">
                        <div>
                            <img src="<%=userAdmin.getAccount().getAvatarLink()%>" alt="">
                        </div>
                    </div>

                    <span onclick="document.getElementById('fileInput1').click()">Thay đổi
                        ảnh đại diện
                        mới
                    </span>
                    <span onclick="removeIMG2()">Xóa ảnh đại diện</span>

                </div>

                <div class="div12">
                    <h3>Điền thông tin cá nhân</h3>
                    <div class="linediv12"></div>
                    <div class="div12input">
                        <label >* Họ và tên</label>
                        <input type="text" placeholder="Nhập họ và tên ở đây" name="fullName" id="fullName" value="<%=informationAccountNVGHObject.getFullName()%>" required>
                    </div>
                    <p class="notifyError hidden" id="error1">Tên không được bỏ trống</p>
                    <div class="div12input">
                        <label >Tên hiển thị</label>
                        <input type="text" placeholder="Nhập tên hiển thị ở đây" name="displayName" id="displayName" value="<%=informationAccountNVGHObject.getDisplayName()%>" required>
                    </div>
                    <p class="notifyError hidden" id="error2">Tên hiển thị không được bỏ trống</p>
                    <div class="div12input">
                        <label >* Email</label>
                        <input type="text" placeholder="Nhập email ở đây" value="<%=userAdmin.getAccount().getEmail()%>" required
                               disabled>
                    </div>
                    <div class="div12input">
                        <label >* Số điện thoại</label>
                        <input type="number" placeholder="Nhập số điện thoại ở đây" name="phoneNumber" id="phoneNumber" value="<%=informationAccountNVGHObject.getPhoneNumber()%>" required>
                    </div>
                    <p class="notifyError hidden" id="error3">Số điện thoại không được bỏ trống</p>
                    <div class="div12input">
                        <label >* Lương</label>
                        <input type="number" placeholder="Nhập lương ở đây" value="<%=userAdmin.getAccount().getSalary()%>" required disabled>
                    </div>
                    <div class="linediv12"></div>
                    <div class="trangthai">
                        <div class="div12inputlv2">
                            <label >Tỉnh / Thành</label>
                            <select name="provincial" id="provincial"  required onchange="loadTinh()">
                                <%
                                    if(informationAccountNVGHObject.getProvincial() == null){
                                %>
                                <option value="none" selected>Chọn tỉnh / thành</option>
                                <% } else { %>
                                <option value="<%=informationAccountNVGHObject.getProvincial().getProvincialId()%>" selected><%=informationAccountNVGHObject.getProvincial().getProvincialName()%></option>
                                <% }
                                    if(informationAccountNVGHObject.getProvincials() != null){
                                        for(Provincial provincial : informationAccountNVGHObject.getProvincials()){
                                %>
                                <option value="<%=provincial.getProvincialId()%>"><%=provincial.getProvincialName()%></option>
                                <% }} %>
                            </select>
                        </div>
                        <div class="div12inputlv2">
                            <label >Quận / huyện</label>
                            <select name="district" id="district" required onchange="loadHuyen()">
                                <%
                                    if(informationAccountNVGHObject.getDistrict() == null){
                                %>
                                <option value="none" selected>Chọn quận / huyện</option>
                                <% } else { %>
                                <option value="<%=informationAccountNVGHObject.getDistrict().getDistrictId()%>" selected><%=informationAccountNVGHObject.getDistrict().getDistrictName()%></option>
                                <% }
                                    if(informationAccountNVGHObject.getDistricts() != null){
                                        for(District district : informationAccountNVGHObject.getDistricts()){
                                %>
                                <option value="<%=district.getDistrictId()%>"><%=district.getDistrictName()%></option>
                                <% }} %>
                            </select>
                            <p class="notifyError2 hidden" id="error4">Chọn huyện đi nào</p>
                        </div>
                        <div class="div12inputlv2">
                            <label >Phường / xã</label>
                            <select name="commune" id="commune"  required >
                                <%
                                    if(informationAccountNVGHObject.getCommune() == null){
                                %>
                                <option value="none" selected>Chọn phường / xã</option>
                                <% } else { %>
                                <option value="<%=informationAccountNVGHObject.getCommune().getCommuneId()%>" selected><%=informationAccountNVGHObject.getCommune().getCommuneName()%></option>
                                <% }
                                    if(informationAccountNVGHObject.getCommunes() != null){
                                        for(Commune commune : informationAccountNVGHObject.getCommunes()){
                                %>
                                <option value="<%=commune.getCommuneId()%>"><%=commune.getCommuneName()%></option>
                                <% }} %>
                            </select>
                            <p class="notifyError2 hidden" id="error5">Chọn xã đi nào</p>
                        </div>
                    </div>
                    <div class="linediv12"></div>
                    <div class="div12input">
                        <label >* Tài khoản</label>
                        <input type="text" placeholder="Nhập tên tài khoản ở đây" value="<%=userAdmin.getAccount().getAccount()%>" disabled>
                    </div>
                    <div class="div12input">
                        <label >* Mật khẩu</label>
                        <input type="password" name="password" id="password" placeholder="Nhập mật khẩu ở đây" value="<%=informationAccountNVGHObject.getPassword()%>">
                    </div>
                    <p class="notifyError hidden" id="error6">Mật khẩu không được để trống</p>
                    <div class="div12input">
                        <label >* Xác nhận</label>
                        <input type="password" name="checkPassword" id="checkPassword"  placeholder="Xác nhận mật khẩu ở đây" value="<%=informationAccountNVGHObject.getCheckPassword()%>">
                    </div>
                    <p class="notifyError hidden" id="error7">Mật khẩu xác thực không trùng khớp</p>
                </div>

                <div class="div13">

                    <div class="div12input formckgioithieu">
                        <textarea name="gioiThieu" id="gioiThieu" placeholder="Nhập giới thiệu ở đây"></textarea>
                    </div>
                    <span onclick="getData()"><i class="fa fa-save"></i>Lưu</span>
                    <span onclick="troVeQuanLy()"><i class="fa fa-arrow-left"></i> Trở về quản
                        lý
                    </span>
                </div>
            </div>
            <input type="text" style="display: none" id="action" name="action">
            <input type="text" name="introduct" id="introduct" style="display: none">
            <input type="text"  style="display: none" name="hinh_anh_trong_firebase" value="<%=userAdmin.getAccount().getNubmerOfImgInFirebase()%>" id="hinh_anh_trong_firebase">
        </form>

        <input type="text" style="display: none" id="ma_nv" value="<%=userAdmin.getAccount().getId()%>">
        <form action="../../InformationAccountNVGHChangeAvatarController" style="display: none"  method="POST" id="changeAvatar">
            <input type="text" id="dataSend"  name="data" value="">
            <input type="text" name="fullName" id="fullName2">
            <input type="text" name="displayName" id="displayName2">
            <input type="text" name="phoneNumber" id="phoneNumber2">
            <input type="text" name="provincial" id="provincial2">
            <input type="text" name="district" id="district2">
            <input type="text" name="commune" id="commune2">
            <input type="text" name="password" id="password2">
            <input type="text" name="checkPassword" id="checkPassword2">
            <input type="text" name="introduct" id="introduct2">
            <input type="text" name="action" id="action2">
        </form>

    </div>

    <!-- Quan tâm nhiêu đây thôi-->
</div>

</body>

</html>
!-- The core Firebase JS SDK is always required and must be listed first -->
<script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-storage.js"></script>
<script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-database.js"></script>

<!-- TODO: Add SDKs for Firebase products that you want to use
https://firebase.google.com/docs/web/setup#available-libraries -->
<script src="https://www.gstatic.com/firebasejs/8.2.1/firebase-analytics.js"></script>
<script src="../../js/thongTinTaiKhoanNVGHAdmin.js"></script>
<%     }

}else{

    //  Tài khoản không có vai trò ở trang này thì ta tới controller điều hướng trang chủ để nó đến trang chủ tương ứng
    response.sendRedirect("../../AdminIndexNavigation");

}
}

    //------------------------------------------------------------------------------------------------------------------------------//

%>