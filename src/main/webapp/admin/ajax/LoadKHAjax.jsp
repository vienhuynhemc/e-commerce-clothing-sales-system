<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.account.AccountCustomer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% ArrayList<AccountCustomer> list = (ArrayList<AccountCustomer>) request.getAttribute("listKH");

    int sumAccount = (int) request.getAttribute("sumCustomer");

%>


<div class="maindiv2header">
    <button onclick="allselect()">+</button>
    <p>Họ và tên</p>
    <p>Email</p>
    <p>Số điện thoại</p>
    <p>Tài khoản</p>
    <p>Kích hoạt</p>
    <p>Đánh giá</p>
    <p>Ngày tạo</p>
</div>


 <%
for ( AccountCustomer k : list  ) {
 %>

<div class="item">
    <label for="">
        <input type="checkbox" name="checkRemove" id="checkRemove_<%=k.getIdUser()%>" value="<%=k.getIdUser()%>">
    </label>
    <div class="itemhdd">
        <img src="<%=k.getAvatar()%>" alt="">
    </div>
    <p class="itemname">
        <%=k.getFullName()%>
    </p>

    <p class="itememail">
        <%=k.getEmail()%>
    </p>

    <p class="itemphone">
        <%=k.getPhone()%>
    </p>

    <p class="itemtk">
        <%=k.getUserName()%>
    </p>

    <div class="tableitemicon hoanthanh">
        <div>
            <i class="fa fa-clock-o"></i>
        </div>
        <%
            if (k.getActiveStatus() ==1){

        %>
        <div>
            <i class="fa fa-check-circle"></i>
        </div>
        <%}else{%>
        <div>
            <i class="fa fa-times-circle"></i>
        </div>
        <%}%>

    </div>
    <div class="tableitemicon hoanthanh">
        <div>
            <i class="fa fa-clock-o"></i>
        </div>

        <%
            if (k.getActiveEvaluate() ==1){

        %>
        <div>
            <i class="fa fa-check-circle"></i>
        </div>
        <%}else{%>
        <div>
            <i class="fa fa-times-circle"></i>
        </div>
        <%}%>
    </div>

    <p class="itemdate">
        <%=k.getRegisDate().getDay()%> Tháng <%=k.getRegisDate().getMonth()%> <%=k.getRegisDate().getYear()%>
    </p>

    <div class="itemsubmit" onclick="showselect(this)">
        <input type="text" style="display: none;">
        <i class="fa fa-circle"></i>
        <i class="fa fa-circle"></i>
        <i class="fa fa-circle"></i>
        <div>
            <button type="button" onclick="editkhachhang(this)"><i class="fa fa-pencil"></i>Sửa</button>
            <button type="button" id="<%=k.getIdUser()%>"  onclick="deleteOne(this)" >
                <i class="fa fa-trash"></i>
                <input type="hidden" value="<%=k.getIdUser()%>">
                Xóa

            </button>
        </div>
    </div>


        <div class="div11">
            <h3>Hồ sơ của bạn</h3>
            <input id="fileInput1" type="file" style="display:none;"
                   onchange="loadIMG(event)"/>
            <div class="div11daidien" onclick="document.getElementById('fileInput1').click()">
                <div>
                    <img id="avataredit" src="<%=k.getAvatar()%>" alt="">
                    <input id="loadAvatar" type="hidden" name="avatar" value="<%=k.getAvatar()%>" >
                </div>
            </div>

            <button type="button" onclick="document.getElementById('fileInput1').click()">Thay đổi
                ảnh đại diện
                mới
            </button>
            <button type="button" onclick="removeIMG2()">Xóa ảnh đại diện</button>

        <div class="div12">
            <h3>Điền thông tin cá nhân</h3>
            <div class="linediv12"></div>
            <div class="div12input">
                <label for="">* Họ và tên</label>
                <input name="fullName" type="text" placeholder="Nhập họ và tên ở đây"
                       value="<%=k.getFullName()%>">
            </div>
            <div class="div12input">
                <label for="">Tên hiển thị</label>
                <input name="displayName" type="text" placeholder="Nhập tên hiển thị ở đây"
                       value="<%=k.getDisplayName()%>">
            </div>
            <div class="div12input">
                <label for="">* Email</label>
                <input name="email" type="text" placeholder="Nhập email ở đây"
                       value="<%=k.getEmail()%>" disabled>
            </div>
            <div class="div12input">
                <label for="">* Số điện thoại</label>
                <input name="phone" type="text" placeholder="Nhập số điện thoại ở đây"
                       value="<%=k.getPhone()%>"
                       disabled>
            </div>
            <div class="linediv12"></div>
            <div class="trangthai">
                <div class="div12inputlv2">
                    <label for="">Trạng thái kích hoạt</label>
                    <select name="activeStatus" id="">
                        <option value="1">Đã kích hoạt</option>
                        <option value="0">Chưa kích hoạt</option>
                    </select>
                </div>
                <div class="div12inputlv2">
                    <label for="">Trạng thái đánh giá</label>
                    <select name="activeEvaluate" id="">
                        <option value="1">Cho phép đánh giá</option>
                        <option value="0">Cấm đánh giá</option>
                    </select>
                </div>
            </div>
            <div class="linediv12"></div>
            <div class="div12input">
                <label for="">* Tài khoản</label>
                <input namei="userName" type="text" placeholder="Nhập tên tài khoản ở đây"
                       value="<%=k.getUserName()%>"
                       disabled>
            </div>
            <div class="div12input">
                <label for="">* Mật khẩu</label>
                <input name="passWord" type="password" placeholder="Nhập mật khẩu ở đây"
                       value="">
            </div>
            <div class="div12input">
                <label for="">* Xác nhận</label>
                <input name="rePassWord" type="password" placeholder="Xác nhận mật khẩu ở đây"
                       value="">
            </div>
        </div>


        <div class="div13">
            <button type="submit"><i class="fa fa-save"></i>Lưu</button>
            <button type="button" onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                lý
            </button>
        </div>
    </div>

</div>

<%}%>

<div class="leftnextpage">
    <p>Hiển thị <strong> <%=list.size()%> </strong> trên tổng


        <%= request.getAttribute("sumCustomer") %>

        khách hàng</p>

    <%int nowpage = Integer.parseInt(request.getParameter("page"));
        if(nowpage == 1){
    %>
    <button type="button"  ><i class="fa fa-caret-left"></i></button>
    <%}else{%>
    <button type="button" id="<%=nowpage-1%>" onclick="changePage(this)" ><i class="fa fa-caret-left"></i></button
    <%}%>
    <ul>

        <%
            int listpage = (int) request.getAttribute("numberPage");

            for (int i = 1;i <= listpage;i++){
                if(i == nowpage){
        %>
        <li style="background-color: #4162fb; box-shadow: 0 3px 5px #90a3ff;" ><button type="button" id="<%=i%>" onclick="changePage(this)"> <%=i%> </button></li>

        <%}else{%>
        <li ><button type="button" id="<%=i%>" onclick="changePage(this)"> <%=i%> </button></li>
        <%}
        }%>

    </ul>
    <%
        if(nowpage == listpage){
    %>
    <button type="button" id="" ><i class="fa fa-caret-right"></i></button>
    <%}else{%>
    <button type="button" id="<%=nowpage+1%>" onclick="changePage(this)" ><i class="fa fa-caret-right"></i></button>
        <%}%>
</div>
<script>

</script>