<%@ page import="beans.loginAdmin.LoginAdminObject" %>
<%@ page import="beans.loginAdmin.RememberAccount" %>
<%@ page import="beans.loginAdmin.ForgotPasswordAdminObject" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 8:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%

    //  Nếu như đã đăng nhập rồi thì sẽ không thể tới trang này foward tới controller điều hướng index
    if (request.getSession().getAttribute("userAdmin") != null) {
        request.getRequestDispatcher("../../AdminIndexNavigation").forward(request, response);
    }


%>


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVT SHOP ADMIN | Đăng nhập</title>

    <link rel="stylesheet" href="../../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../css/loginvienAdmin.css">



</head>

<style>
    .boxdivpassword {
        margin-bottom: 70px;
        margin-top: 52px;
    }
</style>

<body>

<%
    //  Lấy loginAdminObject, nếu như có tồn tại thì lấy các thuộc tính cần thiết
    LoginAdminObject loginAdminObject = (LoginAdminObject) request.getSession().getAttribute("loginAdminObject");

    //  Lấy remember account, để làm những việc cần thiết
    RememberAccount rememberAccount = (RememberAccount) request.getSession().getAttribute("rememberAccount");

    //  Lấy forgotPasswordAdminObject để xử lý việc có hiện thông báo quên mật khẩu hay không
    ForgotPasswordAdminObject forgotPasswordAdminObject = (ForgotPasswordAdminObject) request.getSession().getAttribute("forgotPasswordAdminObject");


%>


<!-- main-->
<div class="mainlogin">
    <div class="login">

        <div class="left" id="left">

            <div class="contentleft loginpage" id="loginpage">
                <div class="headerleft">
                    <a><i class=" fa fa-modx"></i></a>
                    <a>
                        <p>TVT Shop Admin</p>
                    </a>
                </div>
                <p class="wellcome">Chào mừng bạn trở lại, vui lòng đăng nhập vào tài khoản của mình</p>

                <form class="form" method="post" action="../../LoginAdminController">
                    <div class="tk">
                        <p class="titletk">Tài khoản</p>
                        <input id="taikhoan" name="taikhoan" type="text"

                            <% if(loginAdminObject != null){%>
                               value="<%=loginAdminObject.getAccount()%>"
                            <%} else if(rememberAccount != null){%>
                               value="<%=rememberAccount.getAccount()%>"
                            <%}%>

                               placeholder="&#xf2bd;    Nhập tài khoản của bạn ở đây"
                               style="font-family:Arial, FontAwesome" required>
                        <div class="lineinput1"></div>
                    </div>

                    <%if (loginAdminObject != null && loginAdminObject.isNotifyAccount()) {%>
                    <p class="error"><%=loginAdminObject.getContent()%>
                    </p>
                    <%}%>

                    <div class="mk">
                        <p class="titletk">Mật khẩu</p>
                        <input id="matkhau" name="matkhau" type="password"

                            <% if(rememberAccount != null){%>
                               value="<%=rememberAccount.getPassword()%>"
                            <%}%>

                               placeholder="&#xf13e;     Nhập mật khẩu của bạn ở đây"
                               style="font-family:Arial, FontAwesome" required>
                        <span class="eye" onclick="showPassword()"><i class="fa fa-eye-slash" id="iconshowpassword"></i></span>
                        <div class="lineinput2"></div>
                    </div>

                    <%if (loginAdminObject != null && loginAdminObject.isNotifyPassword()) {%>
                    <p class="error"><%=loginAdminObject.getContent()%>
                    </p>
                    <%}%>

                    <div class="helpLogin">
                        <div>

                            <input type="checkbox" name="remember" id="remember"

                                <%if(loginAdminObject!= null && loginAdminObject.getRemember() != null && loginAdminObject.getRemember().equals("on")){%>
                                   checked
                                <%} else if(rememberAccount != null){%>
                                   checked
                                <%}%>
                            >

                            <label for="remember">Nhớ mật khẩu</label>
                        </div>

                        <span onclick="displaydivpassword()">Quên mật khẩu</span>
                    </div>

                    <div class="divsubmit">
                        <button>Đăng nhập</button>
                        <a onclick="toPublic()">Trở lại mua sắm</a>
                    </div>

                    <div class="dkcsbm">
                        <p>Bằng cách đăng nhập, bạn đồng ý với <a href="">các điều khoản và điều kiện</a> & <a
                                href="">chính sách bảo mật</a> của
                            chúng tôi</p>
                    </div>
                </form>
            </div>
        </div>

        <div class="right" id="right">
            <div class="hiddenright"></div>
        </div>

        <div class="contentright" id="contentright">
            <p>Chào mừng trở lại!</p>
            <p>Hãy duy trì kết nối với chúng tôi bằng cách đăng nhập tài khoản của bạn</p>
        </div>
    </div>
</div>

<!--notification-->
<div class="success" id="success">
    <div class="helponclick" onclick="completesuccess()"></div>
    <div class="contentsuccess" id="notifi1" style="display: none">
        <h3>Đăng ký thành công!</h3>
        <p>Hệ thống đã gửi <span>liên kết kích hoạt tài khoản</span> đến <span>email</span> của bạn. Đề nghị bạn hãy
            kiểm tra <span>email</span> và <span>mở liên kết
                    kích hoạt tài khoản</span> để hoàn tất việc đăng ký.</p>
        <img src="../../img/Daco_287580.png" class="logosuccess" alt="">
        <button onclick="completesuccess()">Đăng nhập</button>
        <i class=" fa fa-times closesuccess" onclick="completesuccess()"> </i>
    </div>
    <div class="contentsuccess" id="notifi2" style="display: flex">
        <h3>Lấy lại mật khẩu thành công!</h3>
        <p>Chúc mừng bạn đã lấy lại mật khẩu thành công, bây giờ hãy đăng nhập với chung tôi nào</p>
        <img src="../../img/Daco_287580.png" class="logosuccess" alt="">
        <button onclick="completesuccess()">Đăng nhập</button>
        <i class=" fa fa-times closesuccess" onclick="completesuccess()"> </i>
    </div>
</div>

<!--forgotpassword-->
<div class="success
<%
    if(forgotPasswordAdminObject != null && (forgotPasswordAdminObject.isFillCode() || forgotPasswordAdminObject.isFillEmail()|| forgotPasswordAdminObject.isValidPassword())){
%>
     showdivsuccess
        <%}%>
" id="divpassword">
    <div class="helponclick" onclick="hiddendivpassword()"></div>
    <div class="contentsuccess">
        <div class="left1divpassword
            <%    if(forgotPasswordAdminObject != null && (forgotPasswordAdminObject.isFillCode() || forgotPasswordAdminObject.isFillEmail()|| forgotPasswordAdminObject.isValidPassword())){
                %>
                left1divpasswordhidden
                <%}%>
                " id="left1divpassword">
            <h3>Quên mật khẩu</h3>
            <p>Hãy chọn cách mà chúng tôi sẽ sử dụng để đặt lại mật khẩu của bạn:</p>

            <div class="boxdivpassword" onclick="email()">
                <i class="fa fa-envelope-o"></i>
                <p>Đặt lại mật khẩu bằng email</p>
            </div>
            <button onclick="hiddendivpassword()">Trở lại</button>
            <i class=" fa fa-times closesuccess" onclick="hiddendivpassword()"> </i>
        </div>
        <div class="left2divpassword1
        <%if(forgotPasswordAdminObject != null && forgotPasswordAdminObject.isFillEmail()){%>
        left2divpassword1show
        <%}%>
            " id="left2divpassword1">
            <form class="left2divpassword" id="left2divpassword11" method="post"
                  action="../../ForgotPasswordAdminController">
                <h3>Bằng email</h3>
                <p>Nhập email của bạn dưới đây để đặt lại mật khẩu</p>
                <div class="tk">
                    <input type="text" name="email" placeholder="&#xf003;    Nhập email của bạn ở đây" required
                           style="font-family:Arial, FontAwesome" value="<%if(forgotPasswordAdminObject!=null){%><%=forgotPasswordAdminObject.getEmail()%><%}%>">
                    <div class="lineinput1"></div>
                </div>
                <% if (forgotPasswordAdminObject != null) {%>
                <p class="error" style="color: #ec3650;margin-top: 20px"><%=forgotPasswordAdminObject.getContent()%></p>
                <%}%>
                <div class="divbutton">
                    <button>Đặt lại mật khẩu</button>
                    <span onclick="hiddendivpasswordBack1()">Trở lại</span>
                </div>
                <i class=" fa fa-times closesuccess" onclick="hiddendivpassword()"> </i>
                <input type="text" name="role" value="email" style="display: none">
            </form>
        </div>
        <div class="left2divpassword1
 <%if(forgotPasswordAdminObject != null && forgotPasswordAdminObject.isFillCode()){%>
        left2divpassword2show
        <%}%>
                " id="left2divpassword2">
            <div class="left2divpassword" id="left2divpassword21">
                <h3>Xác nhận email</h3>
                <p>Vui lòng nhập mã gồm 6 chữ số được gửi tới email của bạn</p>
                <div class="tk">
                    <input type="text" placeholder="&#xf13e;   Nhập mã 6 chữ số của bạn ở đây"
                           style="font-family:Arial, FontAwesome" maxlength="4">
                    <div class="lineinput1"></div>
                </div>
                <div class="divbutton">
                    <div class="divalink">
                        <button class="alink" onclick="guilaima()">Gởi lại mã ( <pre class="timeout" id="timeout"><%if(forgotPasswordAdminObject!= null && forgotPasswordAdminObject.getTimeExists() != null){%><%=forgotPasswordAdminObject.getTimeOut()%><%}%></pre> )</button>
                        <button class="alink" onclick="hiddendivpasswordBack2()">Thay đổi email</button>
                    </div>
                    <button onclick="gotochange()">Đặt lại mật khẩu</button>
                </div>
                <i class=" fa fa-times closesuccess" onclick="hiddendivpassword()"> </i>
            </div>
        </div>
        <div class="left2divpassword1" id="left3divpassword">
            <div class="left2divpassword" id="left2divpassword31">
                <h3>Mật khẩu mới</h3>
                <p>Chúc mừng bạn đã tới giai đoạn này, bây giờ hãy nhập mật khẩu mới và hoàn tất công việc lấy lại
                    mật khẩu</p>
                <div class="tk">
                    <input type="password" placeholder="&#xf13e;   Nhập mật khẩu mới bạn ở đây"
                           style="font-family:Arial, FontAwesome">
                    <button class="eye"><i class="fa fa-eye-slash"></i></button>
                    <div class="lineinput1"></div>
                </div>
                <div class="tk">
                    <input type="password" placeholder="&#xf13e;   Nhập lại mật khẩu"
                           style="font-family:Arial, FontAwesome">
                    <button class="eye"><i class="fa fa-eye-slash"></i></button>
                    <div class="lineinput1"></div>
                </div>
                <div class="divbutton">
                    <button onclick="gotocomplete()">Đặt lại mật khẩu</button>
                </div>
                <i class=" fa fa-times closesuccess" onclick="hiddendivpassword()"> </i>
            </div>
        </div>
    </div>
</div>
<!-- Form remove forgotpassword admin object-->
<form action="../../ForgotPasswordAdminRemoveAllController" id="formForgotPasswordAdminRemoveAllController"
      style="display: none">
</form>


<!--End main-->


</body>

</html>

<script src="../../js/dangnhapAdmin.js"></script>