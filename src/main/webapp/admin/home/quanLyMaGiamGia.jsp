<%@ page import="beans.discountCode.DiscountCodeObject" %>
<%@ page import="beans.nextPage.NextPageObject" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.nextPage.NextPageConfiguration" %>
<%@ page import="beans.discountCode.DiscountCode" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 31/12/2020
  Time: 10:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVTSHOP ADMIN | Quản lý mã giảm giá</title>
    <link rel="stylesheet" href="../../fonts/font-awesome-4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="../../css/indexAdmin.css">
    <script src="../../js/indexAdmin.js"></script>

    <link rel="stylesheet" href="../../css/quanLyMaGiamGiaAdmin.css">


</head>

<body>

<%

    //  Lấy DiscountCode
    DiscountCodeObject discountCodeObject = (DiscountCodeObject) session.getAttribute("discountCodeObject");

%>

<jsp:include page="../share/_LayoutLeft.jsp"/>

<div class="indexright">

    <jsp:include page="../share/_LayoutTop.jsp"/>

    <!-- Code trang ở đây-->

    <div class="indexmain">
        <div id="div2">
            <div>
                <form class="header" method="post" action="../../DiscountCodeController" id="mainForm" onsubmit="return false">
                    <div class="leftheader">
                        <select name="selectSearchAndSort" id="selectSearchAndSort" onchange="changeFilter()">

                            <% String selectSearchAndSort = discountCodeObject.getSelectSearchAndSort(); %>

                            <option value="dateCreated" selected
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("dateCreated")) {%>
                                    selected
                                    <%}%>
                            >Ngày tạo</option>
                            <option value="id"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("id")) {%>
                                    selected
                                    <%}%>
                            >Mã giảm giá</option>
                            <option value="name"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("name")) {%>
                                    selected
                                    <%}%>
                            >Mã nhập</option>
                            <option value="status"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("status")) {%>
                                    selected
                                    <%}%>
                            >Trạng thái sử dụng</option>
                            <option value="numberOfUse"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("numberOfUse")) {%>
                                    selected
                                    <%}%>
                            >Số lần đã sử dụng</option>
                            <option value="maximunNumberOfUse"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("maximunNumberOfUse")) {%>
                                    selected
                                    <%}%>
                            >Số lần sử dụng tối đa</option>
                            <option value="remainNumberOfUse"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("remainNumberOfUse")) {%>
                                    selected
                                    <%}%>
                            >Số lần sử dụng còn lại</option>
                            <option value="deadline"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("deadline")) {%>
                                    selected
                                    <%}%>
                            >Ngày hết hạn</option>
                            <option value="%"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("%")) {%>
                                    selected
                                    <%}%>
                            >Giảm giá theo %</option>
                            <option value="VND"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("VND")) {%>
                                    selected
                                    <%}%>
                            >Giảm giá theo số tiền</option>
                            <option value="MPVC"
                                    <% if (selectSearchAndSort != null && selectSearchAndSort.equals("MPVC")) {%>
                                    selected
                                    <%}%>
                            >Miến phí vận chuyển</option>
                        </select>
                        <div>

                            <% String sort = discountCodeObject.getSort(); %>

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
                                    <i class="fa fa-search"></i>
                                    <input type="text" placeholder="Tìm kiếm" name="search" class="searchsubmit"
                                           value="<%=discountCodeObject.getSearch()%>">
                                    <i class="fa fa-refresh loadPage" onclick="loadPage()"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="leftnextpage" id="leftnextpage">
                        <p>Hiển thị <strong><%= discountCodeObject.getNumberOfShow() %>
                        </strong> trên tổng <%=discountCodeObject.getMaximumDiscountCode()%> mã giảm giá</p>
                        <span onclick="prePage(<%=discountCodeObject.getNowPage()%>)"><i
                                class="fa fa-caret-left"></i></span>
                        <ul>

                            <%
                                //  Lấy list next page đổ next page ra
                                List<NextPageObject> nextPages = discountCodeObject.getNextPages();
                                for (NextPageObject n : nextPages) {
                            %>
                            <li
                                    <% if (n.getType() == NextPageConfiguration.ACTIVE_LI) { %>
                                    class="activeli"
                                    <%} else if (n.getType() == NextPageConfiguration.NONE) {%>
                                    class="none" onclick="showselectgopage(this)"
                                    <%} else {%>
                                    onclick="pageNavigation(<%=n.getValue()%>)"
                                    <%}%>
                            ><%=n.getValue()%>

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
                        <span onclick="nextPage(<%=discountCodeObject.getNowPage()%>,<%=discountCodeObject.getMaximumPage()%>)"><i
                                class="fa fa-caret-right"></i></span>
                        <input type="number" name="numberOfPage" id="numberOfPage" style="display: none"
                               value="<%=discountCodeObject.getNowPage()%>">
                        <input type="number" name="maximunNumberOfPage" style="display: none" id="maximunNumberOfPage"
                               value="<%=discountCodeObject.getMaximumPage()%>">
                    </div>
                    <span onclick="themdanhmuc()"><i class="fa fa-plus"></i>Thêm mã giảm giá mới</span>
                    <span onclick="xoacacmuadachon()"><i class="fa fa-trash-o"></i>Xóa các mục đã chọn</span>

                    <!-- action -->
                    <input type="text" name="action" style="display: none" id="action" value="">

                    <!-- sort -->
                    <% if (sort.equals("DESC")) {%>
                    <input type="checkbox" style="display: none" name="sort" id="sort">
                    <% } else {%>
                    <input type="checkbox" style="display: none" name="sort" id="sort" checked>
                    <%}%>

                </form>
                <div class="maindiv2" id="maindiv2">
                    <div class="maindiv2header">
                        <button onclick="allselect()">+</button>
                        <p>Mã</p>
                        <p>Mã nhập</p>
                        <p>Kiểu</p>
                        <p>Giá trị</p>
                        <p>Sử dụng</p>
                        <p>Còn lại</p>
                        <p>Tối đa</p>
                        <p>Trạng thái</p>
                        <p>Ngày tạo</p>
                        <p>Hạn sử dụng</p>
                    </div>

                    <%

                        //  Đổ dữ liệu list mã giảm giá
                        List<DiscountCode> discountCodes = discountCodeObject.getDiscountCodes();

                        for (DiscountCode d : discountCodes) {

                    %>

                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                            <input type="text" style="display: none" value="<%=d.getId()%>">
                        </label>
                        <p>
                            #<%= d.getId()%>
                        </p>
                        <p>
                           <%=d.getName()%>
                        </p>

                        <p><%=d.getType()%></p>

                        <p>
                            <%=d.getStringValue()%>
                        </p>

                        <p>
                            <%=d.getNumberOfUse()%>
                        </p>
                        <p>
                            <%=d.getRemainNumberOfUse()%>
                        </p>
                        <p>
                            <%=d.getMaximunNumberOfUse()%>
                        </p>

                        <div class="tableitemicon

                        <% if(d.getStatus() == 0){%>
                        hoanthanh
                        <%}else{%>
                        khonghoanthanh
                        <%}%>

                        ">
                            <div>
                                <i class="fa fa-clock-o"></i>
                            </div>
                            <div>
                                <i class="fa fa-check-circle"></i>
                            </div>
                            <div>
                                <i class="fa fa-close"></i>
                            </div>
                        </div>

                        <p><%=d.getDateCreated().toString()%></p>

                        <p><%=d.getDeadline().toString()%></p>

                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editdanhmuc(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                                <input type="text" style="display: none" value="<%=d.getId()%>">
                            </div>
                        </div>
                        <div>
                            <div class="div11">
                            </div>

                            <div class="div12">
                                <h3>Điền thông tin mã giảm giá </h3>
                                <div class="linediv12"></div>
                                <div class="div12input">
                                    <label>* Loại mã giảm giá</label>
                                    <select name="" id="" onchange="changeSelect2(this)">
                                        <option value="mpvc"

                                                <% if (d.getType().equals("MPVC")) {%>
                                                selected
                                                <%}%>

                                        >Miễn phí vận chuyển</option>
                                        <option value="ggtpt"

                                                <% if (d.getType().equals("%")) {%>
                                                selected
                                                <%}%>

                                        >Giảm theo %</option>
                                        <option value="ggtstnt"

                                                <% if (d.getType().equals("VND")) {%>
                                                selected
                                                <%}%>

                                        >Giảm theo số tiền nhất định</option>
                                    </select>
                                </div>
                                <div class="div12input
                                     <%if(d.getType().equals("MPVC")){%>
                                        hidden
                                    <%}%>
                                    ">
                                    <label for="">* Giá trị</label>
                                    <input type="text" placeholder="Giá trị của mã giảm giá" value="<%=d.getValue()%>">
                                </div>
                                <div class="div12input">
                                    <label for="">* Mã nhập</label>
                                    <input type="text" placeholder="Mã để người dùng nhập" value="<%=d.getName()%>">
                                </div>
                                <div class="div12input">
                                    <label for="">* Số lần sử dụng</label>
                                    <input type="number" placeholder="Số làn sử dụng tối đa của mã" value="<%=d.getMaximunNumberOfUse()%>">
                                </div>
                                <div class="div12input">
                                    <label for="">* Hạn sử dụng</label>
                                    <input type="datetime-local" value="<%=d.getDeadline().toStringDateTimeLocal()%>">
                                </div>
                                <input type="text" style="display: none" value="<%=d.getId()%>">
                                <div class="linediv12"></div>
                                <button onclick="themmoi()"><i class="fa fa-save"></i>Lưu</button>
                                <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</button>
                            </div>
                            <div class="div13">
                            </div>
                        </div>
                    </div>

                        <%
                                // End đổ dữ liệu list mã giảm giá
                            }

                        %>




                </div>
            </div>
        </div>

        <div id="div1">
            <div>
                <div class="div11">
                </div>

                <div class="div12">
                    <h3>Điền thông tin mã giảm giá </h3>
                    <div class="linediv12"></div>
                    <div class="div12input">
                        <label>* Loại mã giảm giá</label>
                        <select name="" id="" onchange="changeSelect(this)">
                            <option value="mpvc" selected>Miễn phí vận chuyển</option>
                            <option value="ggtpt">Giảm theo %</option>
                            <option value="ggtstnt">Giảm theo số tiền nhất định</option>
                        </select>
                    </div>
                    <div class="div12input hidden">
                        <label for="">* Giá trị</label>
                        <input type="text" placeholder="Giá trị của mã giảm giá">
                    </div>
                    <div class="div12input">
                        <label for="">* Mã nhập</label>
                        <input type="text" placeholder="Mã để người dùng nhập">
                    </div>
                    <div class="div12input">
                        <label for="">* Số lần sử dụng</label>
                        <input type="number" placeholder="Số làn sử dụng tối đa của mã">
                    </div>
                    <div class="div12input">
                        <label for="">* Hạn sử dụng</label>
                        <input type="datetime-local">
                    </div>
                    <div class="linediv12"></div>
                    <button onclick="themmoi()"><i class="fa fa-plus"></i>Thêm mã giảm giá</button>
                    <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</button>
                </div>
                <div class="div13">
                </div>
            </div>
        </div>

        <div id="div3">
        </div>
    </div>

    <!-- Quan tâm nhiêu đây thôi-->
</div>

</body>

</html>

<script src="../../js/quanLyMaGiamGiaAdmin.js"></script>
