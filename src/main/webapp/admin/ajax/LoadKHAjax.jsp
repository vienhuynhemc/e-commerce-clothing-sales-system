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


 <% int count = 0;
for ( AccountCustomer k : list  ) {
    count ++;
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



            <form action="EditAccountKHController" type="post">
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
                </div>
                <div class="div12">
                    <h3>Điền thông tin cá nhân</h3>
                    <div class="linediv12"></div>
                    <input type="hidden" name="userName" value="<%=k.getIdUser()%>">
                    <div class="div12input">
                        <label for="">* Họ và tên</label>
                        <input id="editfullname_<%=count%>" name="fullName" type="text" placeholder="Nhập họ và tên ở đây"
                               value="<%=k.getFullName()%>" >
                    </div>
                    <div class="div12input">
                        <label for="">Tên hiển thị</label>
                        <input id="editdisplayname_<%=count%>" name="displayName" type="text" placeholder="Nhập tên hiển thị ở đây"
                               value="<%=k.getDisplayName()%>">
                    </div>
                    <div class="div12input">
                        <label for="">* Email</label>
                        <input name="" type="text" placeholder="Nhập email ở đây"
                               value="<%=k.getEmail()%>" disabled>
                    </div>
                    <div class="div12input">
                        <label for="">* Số điện thoại</label>
                        <input name="phone2" type="text" placeholder="Nhập số điện thoại ở đây"
                               value="<%=k.getPhone()%>"
                               disabled>
                    </div>
                    <div class="linediv12"></div>
                    <div class="trangthai">
                        <div class="div12inputlv2">
                            <label for="">Trạng thái kích hoạt</label>
                            <select name="activeStatus" id="editttkh_<%=count%>">

                                <% if (k.getActiveStatus() == 1) {%>

                                <option value="1" selected>Đã kích hoạt</option>
                                <option value="0" >Chưa kích hoạt</option>
                                <%}else {%>
                                <option value="0" selected>Chưa kích hoạt</option>
                                <option value="1" >Đã kích hoạt</option>
                                <%}%>

                            </select>
                        </div>
                        <div class="div12inputlv2">
                            <label for="">Trạng thái đánh giá</label>
                            <select name="activeEvaluate" id="editttdg_<%=count%>">

                                <% if (k.getActiveEvaluate() == 1) {%>
                                <option value="1" selected>Cho phép đánh giá</option>
                                <option value="0">Cấm đánh giá</option>
                                <%}else {%>
                                <option value="0" selected>Cấm đánh giá</option>
                                <option value="1">Cho phép đánh giá</option>
                                <%}%>


                            </select>
                        </div>
                    </div>
                    <div class="linediv12"></div>
                    <div class="div12input">
                        <label for="">* Tài khoản</label>
                        <input name="tk2" type="text" placeholder="Nhập tên tài khoản ở đây"
                               value="<%=k.getUserName()%>"
                               disabled>
                    </div>
                    <div class="div12input">
                        <label for="">* Mật khẩu</label>
                        <input name="passWord" id="editpass_<%=count%>" type="password" placeholder="Nhập mật khẩu ở đây"
                        >
                    </div>
<%--                    <div class="div12input">--%>
<%--                        <label for="editrepass_<%=count%>">* Xác nhận</label>--%>
<%--                        <input name="editrepass_<%=count%>" id="editrepass_<%=count%>" type="password" placeholder="Xác nhận mật khẩu ở đây">--%>
<%--                    </div>--%>
                </div>
                <div class="div13">
                    <button type="submit"  ><i class="fa fa-save"></i>Lưu</button>
                    <button type="button" onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản
                        lý
                    </button>
                </div>
            </form>




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
