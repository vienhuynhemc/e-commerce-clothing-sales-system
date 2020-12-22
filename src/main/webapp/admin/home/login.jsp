<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 8:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVT SHOP ADMIN | Đăng nhập</title>

    <link rel="stylesheet" href="../../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../css/loginvienAdmin.css">

    <script src="../../js/dangnhapAdmin.js"></script>

</head>

<body>


<!-- main-->
<div class="mainlogin">
    <div class="login">

        <div class="left" id="left">
            <div id="error">
                Bạn nhập sai tài khoản
            </div>
            <div class="contentleft loginpage" id="loginpage">
                <div class="headerleft">
                    <a><i class=" fa fa-modx"></i></a>
                    <a>
                        <p>TVT Shop Admin</p>
                    </a>
                </div>
                <p class="wellcome">Chào mừng bạn trở lại, vui lòng đăng nhập vào tài khoản của mình</p>

                <div class="form">
                    <div class="tk">
                        <p class="titletk">Tài khoản</p>
                        <input id="taikhoan" type="text" placeholder="&#xf2bd;    Nhập tài khoản của bạn ở đây"
                               style="font-family:Arial, FontAwesome">
                        <div class="lineinput1"></div>
                    </div>
                    <div class="mk">
                        <p class="titletk">Mật khẩu</p>
                        <input id="matkhau" type="password" placeholder="&#xf13e;     Nhập mật khẩu của bạn ở đây"
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
                        <button onclick="toAccount()">Đăng nhập</button>
                        <button onclick="toPublic()">Trở lại mua sắm</button>
                    </div>

                    <div class="dkcsbm">
                        <p>Bằng cách đăng nhập, bạn đồng ý với <a href="">các điều khoản và điều kiện</a> & <a
                                href="">chính sách bảo mật</a> của
                            chúng tôi</p>
                    </div>
                </div>
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
    <div class="contentsuccess" id="notifi1">
        <h3>Đăng ký thành công!</h3>
        <p>Hệ thống đã gửi <span>liên kết kích hoạt tài khoản</span> đến <span>email</span> của bạn. Đề nghị bạn hãy
            kiểm tra <span>email</span> và <span>mở liên kết
                    kích hoạt tài khoản</span> để hoàn tất việc đăng ký.</p>
        <img src="../../img/Daco_287580.png" class="logosuccess" alt="">
        <button onclick="completesuccess()">Đăng nhập</button>
        <i class=" fa fa-times closesuccess" onclick="completesuccess()"> </i>
    </div>
    <div class="contentsuccess" id="notifi2">
        <h3>Lấy lại mật khẩu thành công!</h3>
        <p>Chúc mừng bạn đã lấy lại mật khẩu thành công, bây giờ hãy đăng nhập và cùng mua sắm với chung tôi nào</p>
        <img src="../../img/Daco_287580.png" class="logosuccess" alt="">
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


</body>

</html>