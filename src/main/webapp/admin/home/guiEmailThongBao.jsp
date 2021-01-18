<%@ page import="beans.loginAdmin.UserAdmin" %>
<%@ page import="beans.loginAdmin.AccountStaffAdmin" %>
<%@ page import="beans.emailNotification.EmailNotificationObject" %>
<%@ page import="beans.nextPage.NextPageObject" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.nextPage.NextPageConfiguration" %>
<%@ page import="beans.emailNotification.EmailNotification" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 22/12/2020
  Time: 8:31 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVTSHOP ADMIN | Gửi email thông báo</title>
    <link rel="stylesheet" href="../../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="../../js/Truong/jquery/jquery-3.5.1.min.js"></script>

    <link rel="stylesheet" href="../../css/indexAdmin.css">
    <script src="../../js/indexAdmin.js"></script>

    <link rel="stylesheet" href="../../css/guiEmailThongBaoAdmin.css">

    <script src="../../ckeditor/ckeditor.js"></script>

</head>

<body>

<%
    //----------------------Kiểm tra thử đăng nhập hay chưa và có vai trò ở trang này hay không------------------------------------//
    if(request.getSession().getAttribute("userAdmin") == null) {

        //  Lưu vô session biến trang chờ đợi là trang này để có gì đăng nhập thành công chuyển tới trang này
        request.getSession().setAttribute("trackPage","admin.guiEmailThongBao");

        //  Lưu trackpage xong thì sendredirect tới login
        response.sendRedirect("login.jsp");

    }else{

        UserAdmin userAdmin = (UserAdmin) request.getSession().getAttribute("userAdmin");
        AccountStaffAdmin accountStaffAdmin = userAdmin.getAccount();
        if(accountStaffAdmin.accept("admin.guiEmailThongBao")){

            EmailNotificationObject emailNotificationObject  = (EmailNotificationObject) userAdmin.getListOfFunction().get("emailNotificationObject");
            if(emailNotificationObject == null || !emailNotificationObject.isReady()){
                response.sendRedirect("../../EmailNotificationController");
            }else {
%>

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
                <p onclick="submitAdd()" id="pFormYesNo">Có, chắc chắn <i class="fa fa-check"></i></p>
                <span onclick="hiddenFormYesNo()" id="buttonNoFormYesNo">Không, suy nghĩ thêm <i class="fa fa-close"></i></span>
            </div>
        </div>
    </div>
</div>

<form action="../../EmailNotificationAddController" method="post" style="display: none" id="fromSubmidAdd">
    <input type="text" name="titleSend" id="titleSend">
    <input type="text" name="dataSend" id="dataSend">
</form>

<%
    //  Nếu như có thông báo thì hiển thị
    if (emailNotificationObject.isNotify()) {

        //  Thông báo xong thì để lại trạng thái ban đầu
       emailNotificationObject.setNotify(false);

%>
<div id="notifiSuccess">
    <div class="notifiSuccessHidden" onclick="hiddenNotifiSuccess()"></div>
    <div>
        <p>
            <i class="fa fa-cogs"></i> TVT Shop
        </p>
        <div>
            <p><%=emailNotificationObject.getTitle()%></p>
            <p><%=emailNotificationObject.getConntent()%> <i class="fa fa-hand-grab-o"></i></p>
            <div>
                <span onclick="hiddenNotifiSuccess()">Trở về<i class="fa fa-close"></i></span>
            </div>
        </div>
    </div>
</div>
<%}%>
<!------------------------------------------------------------------------------------------------------------------->

<jsp:include page="../share/_LayoutLeft.jsp">
    <jsp:param name="activeSelect" value="guiEmailThongBao"/>
</jsp:include>
<div class="indexright">

    <jsp:include page="../share/_LayoutTop.jsp"/>

    <!-- Code trang ở đây-->

    <div class="indexmain">
        <div>
            <form class="left" method="post" action="../../EmailNotificationController" id="mainForm" onsubmit="return false">
                <div class="leftheader">
                    <select name="selectSearchAndSort" id="selectSearchAndSort" onchange="changeFilter()">

                        <% String selectSearchAndSort = emailNotificationObject.getSelectSearchAndSort(); %>

                        <option value="dateCreated"
                                <% if (selectSearchAndSort != null && selectSearchAndSort.equals("dateCreated")) {%>
                                selected
                                <%}%>
                        >Ngày gửi</option>
                        <option value="id"
                                <% if (selectSearchAndSort != null && selectSearchAndSort.equals("id")) {%>
                                selected
                                <%}%>
                        >Mã TB</option>
                        <option value="nameStaff"
                                <% if (selectSearchAndSort != null && selectSearchAndSort.equals("nameStaff")) {%>
                                selected
                                <%}%>
                        >Tên NV</option>
                    </select>
                    <div>

                        <% String sort = emailNotificationObject.getSort(); %>

                        <% if (sort.equals("DESC")) {%>
                        <div class="leftheadersort" id="leftheadersort" onclick="changesort()">
                            <i class=" fa fa-sort-amount-desc"></i>
                        </div>
                        <%} else {%>
                        <div class="leftheadersort" id="leftheadersort" onclick="changesort()"
                             style="margin-top:4px">
                            <i class=" fa fa-sort-amount-asc" style="margin-top: -10px"></i>
                        </div>
                        <%}%>

                        <div class="leftheadersearch">
                            <div>
                                <i class="fa fa-search" onclick="searchByClick()" ></i>
                                <input type="text" placeholder="Tìm kiếm" name="search" class="searchsubmit"
                                       value="<%=emailNotificationObject.getSearch()%>">
                                <i class="fa fa-refresh loadPage" onclick="loadPage()"></i>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="leftnextpage" id="leftnextpage">
                    <span onclick="prePage(<%=emailNotificationObject.getNowPage()%>)"><i
                            class="fa fa-caret-left"></i></span>
                    <ul>

                        <%
                            //  Lấy list next page đổ next page ra
                            List<NextPageObject> nextPages = emailNotificationObject.getNextPages();
                            for (NextPageObject n : nextPages) {
                        %>
                        <li
                                <% if (n.getType() == NextPageConfiguration.ACTIVE_LI) { %>
                                class="activeli"
                                <%} else if (n.getType() == NextPageConfiguration.NONE) {%>
                                class="none"
                                <%} else {%>
                                onclick="pageNavigation(<%=n.getValue()%>)"
                                <%}%>
                        >
                            <%if(n.getType() == NextPageConfiguration.NONE){%>
                            <p onclick="showselectgopage(this)"><%=n.getValue()%></p>
                            <%}else{%>
                            <%=n.getValue()%>
                            <%}%>
                            <div class="gopage">
                                <input type="checkbox" style="display: none;">
                                <input type="text">
                                <i class="fa fa-angle-right" onclick="gopagefast(this)"></i>
                            </div>

                        </li>
                        <%
                                //  Kết thúc đổ next page
                            }
                        %>
                    </ul>
                    <span onclick="nextPage(<%=emailNotificationObject.getNowPage()%>,<%=emailNotificationObject.getMaximumPage()%>)"><i
                            class="fa fa-caret-right"></i></span>
                    <input type="number" name="numberOfPage" id="numberOfPage" style="display: none"
                           value="<%=emailNotificationObject.getNowPage()%>">
                    <input type="number" name="maximunNumberOfPage" style="display: none" id="maximunNumberOfPage"
                           value="<%=emailNotificationObject.getMaximumPage()%>">
                </div>

                <div>
                    <div id="listleftitem">
                        <div class="leftitem" onclick="vietThongBaoMoi(this)" id="item0">

                            <div>
                                <img src="../img/icon-mail.png" alt="">
                            </div>

                            <div>
                                <p>Viết thông báo mới</p>
                                <div class="khonghoanthanh">
                                    <i class="fa fa-circle"></i>
                                    <p>#<%=emailNotificationObject.getNextId()%></p>
                                </div>
                            </div>

                            <div>
                            </div>
                            <div>
                            </div>
                        </div>

                        <%
                          List<EmailNotification> emailNotifications = emailNotificationObject.getEmailNotificationLists();
                          int count = 0;
                          for(EmailNotification emailNotification : emailNotifications){
                              count++;
                        %>
                        <div class="leftitem" onclick="changerightdonhang(this)" id="item<%=count%>">

                            <div>
                                <img src="<%=emailNotification.getLinkImgStaff()%>" alt="">
                            </div>

                            <div>
                                <p><%=emailNotification.getNameStaff()%></p>
                                <div class="hoanthanh">
                                    <i class="fa fa-circle"></i>
                                    <p>#<%=emailNotification.getEmailNotificationId()%></p>
                                </div>
                            </div>

                            <div style="display: none">
                                <input type="text" value="<%=emailNotification.getEmailNotificationId()%>">
                            </div>

                            <div>
                                <div class="rightheader">
                                    <div>
                                        <div>
                                            <img src="<%=emailNotification.getLinkImgStaff()%>" alt="">
                                        </div>
                                    </div>

                                    <div class="rightinfor">
                                        <p><%=emailNotification.getNameStaff()%></p>
                                        <p>Tới tất cả</p>
                                    </div>

                                    <div class="rightend">
                                        <p><%=emailNotification.getDateSend().toString()%></p>
                                        <i class="fa fa-trash"
                                           onclick="removeitem(document.getElementById('item<%=count%>'))"></i>
                                    </div>

                                </div>
                                <div class="rightcontent">
                                    <div>
                                        <p class="titleEmail">Tiêu đề: <%=emailNotification.getTitle()%></p>
                                        <%=emailNotification.getContent()%>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>

                <!-- action -->
                <input type="text" name="action" style="display: none" id="action" value="">

                <!-- sort -->
                <% if (sort.equals("DESC")) {%>
                <input type="checkbox" style="display: none" name="sort" id="sort">
                <% } else {%>
                <input type="checkbox" style="display: none" name="sort" id="sort" checked>
                <%}%>

            </form>

            <div class="right" id="right">
                <div id="vietThongBaoMoi">
                    <div class="rightheader">
                        <div>
                            <div>
                                <img src="<%=accountStaffAdmin.getAvatarLink()%>" alt="">
                            </div>
                        </div>

                        <div class="rightinfor">
                            <p><%=accountStaffAdmin.getDisplayName()%></p>
                            <p>Tới tất cả</p>
                        </div>

                        <div class="rightend">
                        </div>

                    </div>
                    <div class="rightcontentt">
                        <input type="text" placeholder="Tiêu đề email" id="titleEmail" required>
                        <textarea name="thongBaoMoi" id="thongBaoMoi" cols="30" rows="10"
                                                  placeholder="Nhập nội dung ở đây"></textarea>
                    </div>
                    <div class="rightsubmit">
                        <button onclick="guiEmail()">GỬI</button>
                        <input type="text" style="display: none" value="<%=emailNotificationObject.getNextId()%>" id="nextId">
                    </div>
                </div>
            </div>
        </div>
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

<script src="../../js/guiEmailThongBaoAdmin.js"></script>
<%     }

}else{

    //  Tài khoản không có vai trò ở trang này thì ta tới controller điều hướng trang chủ để nó đến trang chủ tương ứng
    response.sendRedirect("../../AdminIndexNavigation");

}
}

    //------------------------------------------------------------------------------------------------------------------------------//

%>

