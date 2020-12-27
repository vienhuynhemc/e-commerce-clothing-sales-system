<%@ page import="beans.manufacturer.Manufacturer" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.nextPage.NextPageObject" %>
<%@ page import="beans.nextPage.NextPageConfiguration" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 26/12/2020
  Time: 1:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TVTSHOP ADMIN | Quản lý hãng sản xuất</title>
    <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="css/indexAdmin.css">
    <script src="js/indexAdmin.js"></script>

    <link rel="stylesheet" href="css/quanLyHangSanXuatAdmin.css">


</head>

<body>

<jsp:include page="../share/_LayoutLeft.jsp"/>

<div class="indexright">

    <jsp:include page="../share/_LayoutTop.jsp"/>

    <!-- Code trang ở đây-->

    <div class="indexmain">
        <div id="div2">
            <div>
                <form class="header" method="post" action="ManufacturerController" id="mainForm">
                    <div class="leftheader">
                        <select name="selectSearchAndSort" id="selectSearchAndSort" onchange="changeFilter()">
                            <option value="dateCreated" selected>Ngày tạo</option>
                            <option value="manufacturerName">Tên hãng</option>
                            <option value="manufacturerId">Mã hãng</option>
                            <option value="informationList">Số lượng thông tin</option>
                            <option value="numberOfProducts">Số lượng sản phẩm</option>
                        </select>
                        <div>

                            <% if(request.getAttribute("sort").equals("DESC")){%>
                            <div class="leftheadersort" id="leftheadersort" onclick="changesortasc()">
                                <i class=" fa fa-sort-amount-desc"></i>
                            </div>
                            <%}else{%>
                            <div class="leftheadersort" id="leftheadersort" onclick="changesortdesc()" style="margin-top:4px">
                                <i class=" fa fa-sort-amount-asc" style="margin-top: -10px"></i>
                            </div>
                            <%}%>

                            <div class="leftheadersearch">
                                <i class="fa fa-search" onclick="showsearch2(this)"></i>
                                <div>
                                    <i class="fa fa-search" onclick="hiddensearch2(this)"></i>
                                    <input type="text" placeholder="Tìm kiếm" name="search" onsubmit="return false" onkeydown="submitSerach(e)" >
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="leftnextpage">
                        <p>Hiển thị <strong><%= request.getAttribute("numberOfShow") %>
                        </strong> trên tổng <%=request.getAttribute("maximumManufacturer")%> hãng</p>
                        <span onclick="prePage(<%=request.getAttribute("nowPage")%>)"><i class="fa fa-caret-left"></i></span>
                        <ul>

                            <%
                                //  Lấy list next page đổ next page ra
                                List<NextPageObject> nextPages = (List<NextPageObject>) request.getAttribute("nextPages");
                                for(NextPageObject n : nextPages){
                            %>
                                <li
                                    <%  if(n.getType() == NextPageConfiguration.ACTIVE_LI){ %>
                                          class="activeli"
                                     <%} else if( n.getType() == NextPageConfiguration.NONE){%>
                                        class="none"
                                        <%}else{%>
                                  onclick="pageNavigation(<%=request.getAttribute("maximunPage")%>)"
                                <%}%>
                                ><%=n.getValue()%></li>
                            <%
                                //  Kết thúc đổ next page
                                }
                            %>
                        </ul>
                        <span onclick="nextPage(<%=request.getAttribute("nowPage")%>,<%=request.getAttribute("maximunPage")%>)"><i class="fa fa-caret-right"></i></span>
                        <input type="number" name="numberOfPage" id="numberOfPage" style="display: none" value="<%=request.getAttribute("nowPage")%>">
                        <input type="number" name="maximunNumberOfPage" style="display: none" value="<%=request.getAttribute("maximunPage")%>">
                    </div>
                    <button onclick="themdanhmuc()"><i class="fa fa-plus"></i>Thêm hãng mới</button>
                    <button onclick="xoacacmuadachon()"><i class="fa fa-trash-o"></i>Xóa các mục đã chọn</button>

                    <!-- action -->
                    <input type="text" name="action" style="display: none" id="action" value="">

                    <!-- sort -->
                    <input type="checkbox" style="display: none" name="sort" id="sort">
                </form>
                <div class="maindiv2" id="maindiv2">
                    <div class="maindiv2header">
                        <button onclick="allselect()">+</button>
                        <p>Mã hãng</p>
                        <p>Tên hãng</p>
                        <p>Thông tin</p>
                        <p>Sản phẩm</p>
                        <p>Ngày tạo</p>
                    </div>

                    <%

                        //  Đổ dữ liệu list sản hãng sản xuất
                        List<Manufacturer> manufacturers = (List<Manufacturer>) request.getAttribute("manufacturers");

                        for (Manufacturer m : manufacturers) {

                    %>
                    <div class="item">
                        <label for="c1">
                            <input type="checkbox" name="" id="c1">
                        </label>
                        <p>
                            #<%= m.getManufacturerId() %>
                        </p>
                        <p>
                            <%= m.getManufacturerName() %>
                        </p>

                        <p>
                            <%= m.getInformationList().size() %>
                        </p>

                        <p>
                            <%= m.getNumberOfProduct() %>
                        </p>

                        <p>
                            <%= m.getDateCreated().toStringDateTypeNumberStringNumber() %>
                        </p>

                        <div class="itemsubmit" onclick="showselect(this)">
                            <input type="text" style="display: none;">
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <i class="fa fa-circle"></i>
                            <div>
                                <button onclick="editdanhmuc(this)"><i class="fa fa-pencil"></i>Sửa</button>
                                <button onclick="removekhachhang(this)"><i class="fa fa-trash"></i>Xóa</button>
                            </div>
                        </div>
                        <div>
                            <div class="div11">
                            </div>

                            <div class="div12">
                                <h3>Điền thông tin hãng sản xuất </h3>
                                <div class="linediv12"></div>
                                <div class="div12input">
                                    <label>* Tên hãng</label>
                                    <input type="text" placeholder="Nhập tên hãng sản xuất ở đây" value="<%=m.getManufacturerName()%>">
                                </div>
                                <div class="linediv12"></div>
                                <button onclick="themitemchitiet(this)"><i class="fa fa-plus"></i> Thêm chi tiết mới
                                </button>
                                <div class="listItemChiTiet">

                                    <%
                                        // Đổ list thông tin của từng hãng
                                        List<String> informationList = m.getInformationList();

                                        for (String s : informationList) {

                                    %>
                                    <div class="itemchitiet">
                                        *<input type="text" required placeholder="Nhập chi tiết ở đây" value="<%=s%>">
                                        <i
                                                onclick="removeitemchitiet(this)" class="fa fa-close"></i>
                                    </div>

                                    <%
                                            //  Kết thúc đổ list thông tin của từng hãng
                                        }

                                    %>

                                </div>
                                <div class="linediv12"></div>
                                <button><i class="fa fa-save"></i>Lưu</button>
                                <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</button>
                            </div>
                            <div class="div13">
                            </div>
                        </div>
                    </div>
                    <%
                            // End đổ dữ liệu list hãng sản xuất
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
                    <h3>Điền thông tin hãng sản xuất </h3>
                    <div class="linediv12"></div>
                    <div class="div12input">
                        <label>* Tên hãng</label>
                        <input type="text" placeholder="Nhập tên hãng sản xuất ở đây">
                    </div>
                    <div class="linediv12"></div>
                    <button onclick="themitemchitiet2(this)"><i class="fa fa-plus"></i> Thêm chi tiết mới</button>
                    <div class="listItemChiTiet">
                    </div>
                    <div class="linediv12"></div>
                    <button><i class="fa fa-plus"></i>Thêm danh mục</button>
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

<script src="js/quanLyHangSanXuatAdmin.js"></script>