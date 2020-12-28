<%@ page import="beans.account.ErrorLogin" %>
<%@ page import="beans.account.AccountCustomer" %>
<%@ page import="beans.account.ErrorSignUpAccount" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 6:53 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVT SHOP | Đăng nhập</title>

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
    <link rel="stylesheet" href="css/loginvien.css">

    <script src="js/dangnhap.js"></script>

</head>

<body>

<!-- wpf loader Two -->
<jsp:include page="../share/_LayoutLoadAndScroll.jsp"></jsp:include>

<jsp:include page="../share/_LayoutHeader.jsp"></jsp:include>

<%request.setCharacterEncoding("utf-8");%>
<jsp:include page="../share/_LayoutBanner.jsp">
    <jsp:param name="title" value="Đăng nhập"/>
</jsp:include>

<!-- / catg header banner section -->

<!-- main-->
<div class="mainlogin">
    <div class="login">

        <div class="left" id="left">
            <div class="contentleft loginpage" id="loginpage">
                <div class="headerleft">
                    <a href="../index.html"><i class=" fa fa-modx"></i></a>
                    <a href="../index.html">
                        <p>TVT Shop</p>
                    </a>
                </div>
                <p class="wellcome">Chào mừng bạn trở lại, vui lòng đăng nhập vào tài khoản của mình</p>
                <div class="loginwith">
                    <div class="loginwithitem"><i class="fa fa-facebook-f"></i>
                        <p onclick="toAccount()">Đăng nhập bằng facebook</p>
                    </div>
                    <div class="loginwithitem"><i class="fa fa-google"></i>
                        <p onclick="toAccount()">Đăng nhập bằng google</p>
                    </div>
                </div>
                <p class="or">- Hoặc -</p>


                <!--------------------- đăng nhập ở chỗ này ---------------------------->

                <form action="LoginUserCustomerController" method="post">
                    <div class="form">
                        <div class="tk">
                            <p class="titletk">Tài khoản</p>
                            <input name="userName" value="${param["userName"]}" type="text" placeholder="&#xf2bd;    Nhập tài khoản của bạn ở đây"
                                   style="font-family:Arial, FontAwesome">
                            <div class="lineinput1"></div>
                        </div>
                        <div class="mk">
                            <p class="titletk">Mật khẩu</p>
                            <input name="passWord" type="password" placeholder="&#xf13e;     Nhập mật khẩu của bạn ở đây"
                                   style="font-family:Arial, FontAwesome">
                            <button class="eye"><i class="fa fa-eye-slash"></i></button>
                            <div class="lineinput2"></div>
                        </div>

                        <div class="helpLogin">
                            <div>
                                <input type="checkbox" name="" id="remember">
                                <label for="remember">Nhớ mật khẩu</label>
                            </div>

                            <button onclick="displaydivpassword()">Quên mật khẩu</button>
                        </div>

                        <div class="divsubmit">
                            <button type="submit" onclick="toAccount()">Đăng nhập</button>
                            <button type="button" onclick="dangky()">Đăng ký</button>
                        </div>

                        <div class="dkcsbm">
                            <p>Bằng cách đăng ký, bạn đồng ý với <a href="">các điều khoản và điều kiện</a> & <a
                                    href="">chính sách bảo mật</a> của
                                chúng tôi</p>
                        </div>
                    </div>
                </form>


            <!-- sử lí hiện bảng thông báo ---->
                <%
                    //lấy request loginStatus != null thì đăng nhập thất bại

                    String status = (String) request.getAttribute("loginStatus");

                    if (status  != null) {

                        //truyển status vào để sử lí
                        ErrorLogin errorLogin = new ErrorLogin(status);

                %>

                <%request.setCharacterEncoding("utf-8");%>
                <jsp:include page="../notifyErrorLogin/AccountStatus.jsp">
                    <jsp:param name="title" value="<%=errorLogin.getTitle()%>"/>
                    <jsp:param name="content" value="<%=errorLogin.getContent()%>"/>
                </jsp:include>
                <%
                    }
                %>



            </div>
            <div class="contentleft signuppage" id="signuppage">
                <div class="headerleft">
                    <a href="../index.html"><i class=" fa fa-modx"></i></a>
                    <a href="../index.html">
                        <p>TVT Shop</p>
                    </a>
                </div>

                <p class="title">Đăng ký</p>
                <p class="info">Cung cấp cho chúng tôi một số thông tin của bạn để có quyền truy cập vào trang và
                    mua sắm</p>

                <form action="../SignUpController" method="post">
                    <div class="form">
                        <div class="tk">
                            <p class="titletk">Tài khoản</p>
                            <input type="text" name="username" placeholder="&#xf2bd; Nhập tài khoản của bạn ở đây"
                                   style="font-family:Arial, FontAwesome">
                            <div class="lineinput1"></div>
                        </div>
                        <div class="mk">
                            <p class="titletk">Mật khẩu</p>
                            <input type="password" name="pass" placeholder="&#xf13e;     Nhập mật khẩu của bạn ở đây"
                                   style="font-family:Arial, FontAwesome">
                            <button class="eye"><i class="fa fa-eye-slash"></i></button>
                            <div class="lineinput2"></div>
                        </div>
                        <div class="tk">
                            <p class="titletk">Họ và tên</p>
                            <input type="text" name="name" placeholder="&#xf2bc;    Nhập họ và tên của bạn ở đây"
                                   style="font-family:Arial, FontAwesome">
                            <div class="lineinput2"></div>
                        </div>
                        <div class="tk">
                            <p class="titletk">Số điện thoại</p>
                            <input type="text" name="phone"placeholder="&#xf10b;    Nhập số điện thoại của bạn ở đây"
                                   style="font-family:Arial, FontAwesome">
                            <div class="lineinput2"></div>
                        </div>
                        <div class="tk">
                            <p class="titletk">Email</p>
                            <input type="text" name="mail" placeholder="&#xf003;    Nhập email của bạn ở đây"
                                   style="font-family:Arial, FontAwesome">
                            <div class="lineinput1"></div>
                        </div>
                        <div class="dkcsbm agree">
                            <input type="checkbox" id="checkagree" name="check" value="check">
                            <label for="checkagree">
                                <p>Bằng cách tạo tài khoản, bạn đồng ý với <a href="">các điều khoản và điều kiện</a> &
                                    <a href="">chính sách bảo mật</a> của
                                    chúng tôi</p>
                            </label>
                        </div>
                        <div class="divsubmit">
                            <%--                          <button onclick="displayNoti()">Đăng ký</button>--%>
                            <button type="submit">Đăng ký</button>
                            <p>Bạn đã có tài khoản? <span onclick="dangnhap()">Đăng nhập</span></p>
                        </div>

                    </div>
                </form>


                <%
                    //lấy status ra

                    String statusSignUP = (String) request.getAttribute("status");

                    if (status != null) {
                        //truyển status vào để sử lí
                        ErrorSignUpAccount errorAccount = new ErrorSignUpAccount(statusSignUP);

                %>


                <!--lúc request lại thì về lại cái form-->
                <%request.setCharacterEncoding("utf-8");%>
                <jsp:include page="../notifyErrorAccount/AccountStatus.jsp">
                    <jsp:param name="title" value="<%=errorAccount.getTitle()%>"/>
                    <jsp:param name="content" value="<%=errorAccount.getContent()%>"/>
                </jsp:include>



                <%
                    }
                %>
            </div>
        </div>

        <div class="right" id="right">
            <div class="hiddenright"></div>
        </div>

        <div class="contentright" id="contentright">
            <p>Xin chào, bạn của tôi!</p>
            <p>Đăng ký tài khoản dành riêng cho bạn và bắt đầu hành trình mua sắm với chúng tôi</p>
            <button onclick="dangky()">ĐĂNG KÝ</button>
        </div>

        <div class="contentright ctl" id="ctl">
            <p>Chào mừng trở lại!</p>
            <p>Hãy duy trì kết nối với chúng tôi bằng cách đăng nhập tài khoản của bạn</p>
            <button onclick="dangnhap()">ĐĂNG NHẬP</button>
        </div>

    </div>
</div>

<!--notification-->
<div class="success" id="success">
    <div class="helponclick" onclick="completesuccess()"></div>
    <div class="contentsuccess" id="notifi1">
        <h3>Đăng ký thành công!</h3>
        <p>Hệ thống đã gửi <span>liên kết kích hoạt tài khoản</span> đến <span>email</span> của bạn. Đề nghị bạn hãy
            kiểm tra <span>email</span> và <span>mở liên kết
                    kích hoạt tài khoản</span> để hoàn tất việc đăng ký.</p>
        <img src="../img/Daco_287580.png" class="logosuccess" alt="">
        <button onclick="completesuccess()">Đăng nhập</button>
        <i class=" fa fa-times closesuccess" onclick="completesuccess()"> </i>
    </div>
    <div class="contentsuccess" id="notifi2">
        <h3>Lấy lại mật khẩu thành công!</h3>
        <p>Chúc mừng bạn đã lấy lại mật khẩu thành công, bây giờ hãy đăng nhập và cùng mua sắm với chung tôi nào</p>
        <img src="../img/Daco_287580.png" class="logosuccess" alt="">
        <button onclick="completesuccess()">Đăng nhập</button>
        <i class=" fa fa-times closesuccess" onclick="completesuccess()"> </i>
    </div>
</div>

<!--forgotpassword-->
<div class="success" id="divpassword">
    <div class="helponclick" onclick="hiddendivpassword()"></div>
    <div class="contentsuccess">
        <div class="left1divpassword" id="left1divpassword">
            <h3>Quên mật khẩu</h3>
            <p>Hãy chọn cách mà chúng tôi sẽ sử dụng để đặt lại mật khẩu của bạn:</p>

            <div class="boxdivpassword" onclick="sdt()">
                <i class="fa fa-mobile"></i>
                <p>Đặt lại mật khẩu bằng số điện thoại</p>
            </div>
            <div class="boxdivpassword" onclick="email()">
                <i class="fa fa-envelope-o"></i>
                <p>Đặt lại mật khẩu bằng email</p>
            </div>
            <button onclick="hiddendivpassword()">Trở lại</button>
            <i class=" fa fa-times closesuccess" onclick="hiddendivpassword()"> </i>
        </div>
        <div class="left2divpassword1" id="left2divpassword1">
            <div class="left2divpassword" id="left2divpassword11">
                <h3>Bằng email</h3>
                <p>Nhập email của bạn dưới đây để đặt lại mật khẩu</p>
                <div class="tk">
                    <input type="text" placeholder="&#xf003;    Nhập email của bạn ở đây"
                           style="font-family:Arial, FontAwesome">
                    <div class="lineinput1"></div>
                </div>
                <div class="divbutton">
                    <button onclick="veryemail()">Đặt lại mật khẩu</button>
                    <button onclick="hiddendivpasswordBack1()">Trở lại</button>
                </div>
                <i class=" fa fa-times closesuccess" onclick="hiddendivpassword()"> </i>
            </div>
            <div class="left2divpassword" id="left2divpassword12">
                <h3>Bằng số điện thoại</h3>
                <p>Nhập số điện thoại của bạn dưới đây để đặt lại mật khẩu</p>
                <div class="tk">
                    <input type="text" placeholder="&#xf10b;    Nhập số điện thoại của bạn ở đây"
                           style="font-family:Arial, FontAwesome">
                    <div class="lineinput1"></div>
                </div>
                <div class="divbutton">
                    <button onclick="verysdt()">Đặt lại mật khẩu</button>
                    <button onclick="hiddendivpasswordBack1()">Trở lại</button>
                </div>
                <i class=" fa fa-times closesuccess" onclick="hiddendivpassword()"> </i>
            </div>
        </div>
        <div class="left2divpassword1" id="left2divpassword2">
            <div class="left2divpassword" id="left2divpassword21">
                <h3>Xác nhận email</h3>
                <p>Vui lòng nhập mã gồm 4 chữ số được gửi tới email của bạn</p>
                <div class="tk">
                    <input type="text" placeholder="&#xf13e;   Nhập mã 4 chữ số của bạn ở đây"
                           style="font-family:Arial, FontAwesome" maxlength="4">
                    <div class="lineinput1"></div>
                </div>
                <div class="divbutton">
                    <div class="divalink">
                        <button class="alink">Gởi lại mã</button>
                        <button class="alink" onclick="hiddendivpasswordBack2()">Thay đổi email</button>
                    </div>
                    <button onclick="gotochange()">Đặt lại mật khẩu</button>
                </div>
                <i class=" fa fa-times closesuccess" onclick="hiddendivpassword()"> </i>
            </div>
            <div class="left2divpassword" id="left2divpassword22">
                <h3>Xác nhận số điện thoại</h3>
                <p>Vui lòng nhập mã gồm 4 chữ số được gửi tới số điện thoại của bạn</p>
                <div class="tk">
                    <input type="text" placeholder="&#xf13e;   Nhập mã 4 chữ số của bạn ở đây"
                           style="font-family:Arial, FontAwesome" maxlength="4">
                    <div class="lineinput1"></div>
                </div>
                <div class="divbutton">
                    <div class="divalink">
                        <button class="alink">Gởi lại mã</button>
                        <button class="alink" onclick="hiddendivpasswordBack2()">Thay đổi số điện thoại</button>
                    </div>
                    <button onclick="gotochange()">Đặt lại mật khẩu</button>
                </div>
                <i class=" fa fa-times closesuccess" onclick="hiddendivpassword()"> </i>
            </div>
        </div>
        <div class="left2divpassword1" id="left3divpassword">
            <div class="left2divpassword" id="left2divpassword21">
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