<%@ page import="beans.account.ErrorLogin" %>
<%@ page import="beans.account.AccountCustomer" %>
<%@ page import="beans.account.ErrorSignUpAccount" %>
<%@ page import="model.language.LoginLanguageModel" %>
<%@ page import="java.util.Map" %><%--
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
    <link href="css/sequence-theme.modern-slide-in.css" rel="stylesheet" media="all">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="css/trangChu.css">
    <script src="js"></script>
    <link rel="stylesheet" href="css/banner.css">
    <link rel="stylesheet" href="css/loginvien.css">

    <script src="js/dangnhap.js"></script>

</head>

<%
    //  Chuyển về UTF-8
    request.setCharacterEncoding("UTF-8");

    //  Lấy list ngôn ngữ ra
    Map<String, String> lang = (Map<String, String>) session.getAttribute("langList");

    // Riêng khi test, khi mở server thì nó vô thẳng trang này nên là lấy thủ công ra 1 tí
    if (lang == null) {
        lang = LoginLanguageModel.getInstance().getList("vietnamese");
    }

%>


<body>

<!-- wpf loader Two -->
<jsp:include page="../share/_LayoutLoadAndScroll.jsp"></jsp:include>

<jsp:include page="../share/_LayoutHeader.jsp">
    <jsp:param name="linkMainPage" value="LoginLanguageController"/>
    <jsp:param name="levelPage" value=""/>
</jsp:include>

<%request.setCharacterEncoding("utf-8");%>
<jsp:include page="../share/_LayoutBanner.jsp">
    <jsp:param name="titleVietnamese" value="Đăng Nhập & Đăng Ký"/>
    <jsp:param name="titleEnglish" value="Login & Register"/>
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
                <p class="wellcome"><%=lang.get("1")%></p>
                <div class="loginwith">
                    <div class="loginwithitem"><i class="fa fa-facebook-f"></i>
                        <p onclick="toAccount()"><%=lang.get("2")%></p>
                    </div>
                    <div class="loginwithitem"><i class="fa fa-google"></i>
                        <p onclick="toAccount()"><%=lang.get("25")%></p>
                    </div>
                </div>
                <p class="or">- <%=lang.get("3")%> -</p>


                <!--------------------- đăng nhập ở chỗ này ---------------------------->

                <form action="LoginUserCustomerController" method="post">
                    <div class="form">
                        <div class="tk">
                            <p class="titletk"><%=lang.get("4")%></p>
                            <input name="userName" id="nhaptk" title="Tài khoản không được bỏ trống"  value="${param["userName"]}" type="text" placeholder="&#xf2bd;    <%=lang.get("5")%>"
                                   style="font-family:Arial, FontAwesome" autofocus>
                            <div class="lineinput1"></div>
                        </div>
                        <div class="mk">
                            <p class="titletk"><%=lang.get("6")%></p>
                            <input name="passWord" id="nhappass" type="password"  title="Mật khẩu phải trên 6 kí tự" placeholder="&#xf13e;     <%=lang.get("7")%>"
                                   style="font-family:Arial, FontAwesome">
                            <button class="eye"><i class="fa fa-eye-slash"></i></button>
                            <div class="lineinput2"></div>
                        </div>

                        <div class="helpLogin">
                            <div>
                                <input type="checkbox" name="" id="remember">
                                <label for="remember"><%=lang.get("8")%></label>
                            </div>

                            <button onclick="displaydivpassword()"><%=lang.get("9")%></button>
                        </div>

                        <div class="divsubmit">
                            <button type="submit"><%=lang.get("10")%></button>
                            <button type="button" onclick="dangky()"><%=lang.get("11")%></button>
                        </div>

                        <div class="dkcsbm">
                            <p><%=lang.get("11")%> <a href=""><%=lang.get("26")%></a> <%=lang.get("27")%> <a
                                    href=""><%=lang.get("28")%></a> <%=lang.get("29")%></p>
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

                <p class="title"><%=lang.get("11")%></p>
                <p class="info"><%=lang.get("18")%></p>

                <form action="SignUpController" method="post">
                    <div class="form">
                        <div class="tk">
                            <p class="titletk"><%=lang.get("4")%></p>
                            <input type="text" name="username" placeholder="&#xf2bd; <%=lang.get("5")%>"
                                   style="font-family:Arial, FontAwesome">
                            <div class="lineinput1"></div>
                        </div>
                        <div class="mk">
                            <p class="titletk"><%=lang.get("6")%></p>
                            <input type="password" name="pass" placeholder="&#xf13e;     <%=lang.get("7")%>"
                                   style="font-family:Arial, FontAwesome">
                            <button class="eye"><i class="fa fa-eye-slash"></i></button>
                            <div class="lineinput2"></div>
                        </div>
                        <div class="tk">
                            <p class="titletk"><%=lang.get("19")%></p>
                            <input type="text" name="name" placeholder="&#xf2bc;    <%=lang.get("20")%>"
                                   style="font-family:Arial, FontAwesome">
                            <div class="lineinput2"></div>
                        </div>
                        <div class="tk">
                            <p class="titletk"><%=lang.get("21")%></p>
                            <input type="text" name="phone"placeholder="&#xf10b;    <%=lang.get("22")%>"
                                   style="font-family:Arial, FontAwesome">
                            <div class="lineinput2"></div>
                        </div>
                        <div class="tk">
                            <p class="titletk">Email</p>
                            <input type="text" name="mail" placeholder="&#xf003;    <%=lang.get("22")%>"
                                   style="font-family:Arial, FontAwesome">
                            <div class="lineinput1"></div>
                        </div>
                        <div class="dkcsbm agree">
                            <input type="checkbox" id="checkagree" name="check" value="check">
                            <label for="checkagree">
                                <p><%=lang.get("11")%> <a href=""><%=lang.get("26")%></a> <%=lang.get("27")%> <a
                                        href=""><%=lang.get("28")%></a> <%=lang.get("29")%></p>
                            </label>
                        </div>
                        <div class="divsubmit">
                            <%--                          <button onclick="displayNoti()">Đăng ký</button>--%>
                            <button type="submit"><%=lang.get("11")%></button>
                            <p><%=lang.get("24")%> <span onclick="dangnhap()"><%=lang.get("10")%></span></p>
                        </div>

                    </div>
                </form>





                <%
                    //lấy status ra

                    String statusSignUP = (String) request.getAttribute("statuss");

                    if (statusSignUP != null) {
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
            <p><%=lang.get("13")%></p>
            <p><%=lang.get("14")%></p>
            <button onclick="dangky()"><%=lang.get("15")%></button>
        </div>

        <div class="contentright ctl" id="ctl">
            <p><%=lang.get("16")%></p>
            <p><%=lang.get("17")%></p>
            <button onclick="dangnhap()"><%=lang.get("10")%></button>
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


<script>


    // var tentk = document.getElementById("nhaptk");
    // tentk.oninvalid = function(event) {
    //     event.target.setCustomValidity('Nhập tài khoản của bạn');
    // }
    //
    // var matkhau = document.getElementById("nhappass");
    // matkhau.oninvalid = function(event) {
    //     event.target.setCustomValidity('Nhập mật khẩu của bạn, mật khẩu phải trên 6 kí tự');
    // }

</script>