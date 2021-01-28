<%@ page import="beans.category.Category" %>
<%@ page import="worksWithDatabase.category.CategoryWorksWithDatabase" %><%--<%@ page import="beans.category.Category" %>--%>
<%--<%@ page import="worksWithDatabase.category.CategoryWorksWithDatabase" %>--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%-- Created by IntelliJ IDEA. User: Administrator Date: 22/12/2020 Time: 9:00 CH To change this template use File |
    Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <html>

        <head>

            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>TVTSHOP ADMIN | Quản lý danh mục</title>
            <link rel="stylesheet" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

            <link rel="stylesheet" href="css/indexAdmin.css">
            <script src="js/indexAdmin.js"></script>

            <link rel="stylesheet" href="css/quanLyDanhMucAdmin.css">

            <% ArrayList<Category> list = (ArrayList<Category>) request.getAttribute("listDM");%>

        </head>

        <body>


        <jsp:include page="../share/_LayoutLeft.jsp">
            <jsp:param name="activeSelect" value="quanLyDanhMuc"/>
        </jsp:include>

            <div class="indexright">
                <jsp:include page="../share/_LayoutTop.jsp">
                    <jsp:param name="level" value="Admin"/>
                </jsp:include>

                <!-- Code trang ở đây-->

                <div class="indexmain">
                    <div id="div2">
                        <div>
                            <div class="header">
<%--                            <form action="LoadCategoryController" method="get">--%>
                                <div class="leftheader">
                                    <select name="type" id="typeSelect" onchange="if (this.value) window.location.href=this.value">
                                        <option value="LoadCategoryController?page=<%= Integer.parseInt(request.getParameter("page"))%>&type=ngay_tao&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>"
                                        <% if(request.getParameter("type").equals("ngay_tao")){%>
                                         selected <%}%> >Ngày tạo</option>
                                        <option value="LoadCategoryController?page=<%= Integer.parseInt(request.getParameter("page"))%>&type=ten_dm&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>"
                                        <% if(request.getParameter("type").equals("ten_dm")){%>
                                        selected <%}%> >Tên danh mục</option>
                                        <option value="LoadCategoryController?page=<%= Integer.parseInt(request.getParameter("page"))%>&type=ma_dm&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>"
                                        <% if(request.getParameter("type").equals("ma_dm")){%>
                                        selected <%}%> > Mã danh mục</option>
                                    </select>
                                    <div>
                                        <div class="leftheadersort" onclick="changesort2(this)">
                                            <% if(request.getParameter("orderBy").equals("desc")){%>
                                            <a href="LoadCategoryController?page=<%= Integer.parseInt(request.getParameter("page"))%>&type=ma_dm&search=<%=request.getParameter("search")%>&orderBy=asc"> <i class=" fa fa-sort-amount-desc"></i></a>
                                            <%} else {%>
                                            <a href="LoadCategoryController?page=<%= Integer.parseInt(request.getParameter("page"))%>&type=ma_dm&search=<%=request.getParameter("search")%>&orderBy=desc"> <i class=" fa fa-sort-amount-asc"></i></a>
                                            <%}%>
<%--                                            <i class=" fa fa-sort-amount-desc" onclick="setOrderBy()"></i>--%>
<%--                                            <i class=" fa fa-sort-amount-asc" onclick="setOrderBy()"></i>--%>
<%--                                            <input type="checkbox" style="display: none;">--%>
<%--                                            <input type="hidden" id="checkSort" name="orderBy" value="${param.orderBy}">--%>
                                        </div>
                                        <form action="SearchCategoryController" method="get">
                                        <div class="leftheadersearch">
                                            <input name="page" value="<%=request.getParameter("page")%>" type="hidden" type="input">
                                            <input name="type" value="<%=request.getParameter("type")%>" type="hidden"type="input">

                                            <button type="submit" class="timkiem" > <i class="fa fa-search" ></i></button>
                                            <input type="text" name="search" class="search2" placeholder="Tìm kiếm" value="${param.search == null?"":param.search}">
                                            <input name="orderBy" value="<%=request.getParameter("orderBy")%>" type="hidden"type="input">
                                        </div>
                                        </form>
                                    </div>
                                </div>
<%--                            </form>--%>
                                <div class="leftnextpage">
                                    <p>Hiển thị <strong> <%= list.size() %> </strong> trên tổng <%= (int)request.getAttribute("sumCategory")%> danh mục</p>
<%--                                    <button><i class="fa fa-caret-left"></i></button>--%>
                                    <% // nut qua trai trang hien tai  <-- 2 %>
                                    <a href="LoadCategoryController?page=<%= Integer.parseInt(request.getParameter("page"))  - 1%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>" >
                                        <button><i class="fa fa-caret-left"></i>
                                        </button>
                                    </a>
                                    <ul>
<%--                                        <li>1</li>--%>
<%--                                        <li>2</li>--%>
<%--                                        <li>3</li>--%>
<%--                                        <li>4</li>--%>
<%--                                        <li>5</li>--%>
<%--                                        <li class="none">...</li>--%>
<%--                                        <li>9</li>--%>
<%--                                        <%--%>
<%--                                            int numberOfPage = (int)request.getAttribute("numberOfPage");--%>
<%--//                                            ArrayList<Category> list = (ArrayList<Category>) request.getAttribute("list");--%>
<%--                                        %>--%>

<%--                                        <%--%>

<%--                                            for(int i = 0; i< numberOfPage;i++){--%>
<%--                                        %>--%>

<%--                                        <a href="PageCategoryController?vi-tri=<%=(i+1)%>"><li><%= (i+1) %></li></a>--%>

<%--                                        <%}%>--%>

                                        <%
                                            // so trang hien thi 1 2 ... 4 5
                                            int listpage = (int) request.getAttribute("numberPage");

                                            // lay trang hien tai
                                            int nowpage = Integer.parseInt(request.getParameter("page"));

                                            for (int i = 1;i <= listpage;i++){
                                                if(i == nowpage){
                                        %>
                                        <li style="background-color: #4162ff; box-shadow: 0 3px 5px #90a3ff;" ><a href="LoadCategoryController?page=<%=i%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>"> <%=i%> </a></li>

                                        <%}else{%>
                                        <li ><a href="LoadCategoryController?page=<%=i%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>"> <%=i%> </a></li>
                                        <%}}%>

                                    </ul>
                                    <% // nut qua phai trang hien tai  2 -->%>
                                    <a href="LoadCategoryController?page=<%=Integer.parseInt(request.getParameter("page"))  + 1%>&type=<%=request.getParameter("type")%>&search=<%=request.getParameter("search")%>&orderBy=<%=request.getParameter("orderBy")%>">
                                        <button><i class="fa fa-caret-right"></i></button>
                                    </a>

                                </div>
                                <button onclick="themdanhmuc()"><i class="fa fa-plus"></i>Thêm danh mục mới</button>
                                <button onclick="xoacacmuadachon()"><i class="fa fa-trash-o"></i>Xóa các mục đã
                                    chọn</button>
                            </div>
                            <div class="maindiv2" id="maindiv2">
                                <div class="maindiv2header">
                                    <button onclick="allselect()">+</button>
                                    <p>Mã danh mục</p>
                                    <p>Tên danh mục</p>
                                    <p>Số sản phẩm</p>
                                    <p>Ngày tạo</p>
                                </div>

<%--                                <%--%>
<%--                                    for(Category c : CategoryWorksWithDatabase.getCategoriesByIdASC()){%>--%>
<%--                              <  <c:forEach items="${listDM}" var="c">>--%>
                                <%
                                   ArrayList<Category> listDM =  (ArrayList<Category>)request.getAttribute("listDM");
                                %>
                                <% if(listDM.size() == 0){%>
                                <div><p style="    width: 29%;
                                text-align: center;
                                height: 25px;
                                margin: auto;
                                margin-top: 30px;
                                background-color: white;
                                line-height: 25px;
                                border-radius: 8px;
                                font-family: serif;"> Không tìm thấy danh mục sản phẩm!</p></div>
                                <%
                                }else{
                                        for(Category c : listDM){%>
                                <%System.out.println(list.size());%>
                                <div class="item">
                                    <label for="c1">
                                        <input type="checkbox" name="" id="c1">
                                    </label>
                                    <p>
                                        #<%= c.getId()%>
<%--                                        #${c.id}--%>
                                    </p>
                                    <p>
                                            <%= c.getName() %>
<%--                                        ${c.name}--%>
                                    </p>
                                    <p>
                                        <%=c.getNumberOfProduct()%>
                                    </p>
                                    <p>
<%--                                         ${c.dateCreated}--%>
                                        <%= c.getDateCreated() %>
                                    </p>

                                    <div class="itemsubmit" onclick="showselect(this)">
                                        <input type="text" style="display: none;">
                                        <i class="fa fa-circle"></i>
                                        <i class="fa fa-circle"></i>
                                        <i class="fa fa-circle"></i>
                                        <div>

                                           <button type="submit"><a href="admin/home/quanLyDanhMuc(Form_capnhat).jsp?id=${c.id}"> <i class="fa fa-pencil" style="margin-right: 10px"></i>Sửa</a> </button>

                                            <form action="RemoveCategoryController" method="post">

                                                <button type="submit" name="name_C" value="${c.id}"><i class="fa fa-trash"></i>Xóa</button>
                                            </form>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="div11"></div>

                                           <div class="div12">
                                               <h3>Điền thông tin danh mục</h3>
                                               <div class="linediv12"></div>
                                               <form action="" method="get">
                                               <div class="div12input">
                                                   <label >* Tên danh mục</label>
                                                   <input type="text" placeholder="Nhập tên danh mục ở đây" id="update"
                                                          value="">
                                               </div>
                                               <div class="linediv12"></div>
                                               <button type="submit"><i class="fa fa-save"></i>Lưu</button>
                                               <button onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</button>
                                               </form>
                                           </div>

                                        <div class="div13">
                                        </div>
                                    </div>
                                </div>

                                <% }}%>

                            </div>
                        </div>
                    </div>

                    <div id="div1">
                        <div>
                            <div class="div11">
                            </div>


                               <div class="div12">
                                   <h3>Điền thông tin danh mục</h3>
                                   <div class="linediv12"></div>
                                   <form action="AddCategoryController" method="post">
                                   <div class="div12input">
                                       <label >* Tên danh mục</label>
                                       <input type="text" placeholder="Nhập tên danh mục ở đây" name="name" value="">
                                   </div>
                                   <div class="linediv12"></div>
                                   <button type="submit"><i class="fa fa-plus"></i>Thêm danh mục</button>
                                   <button type="button" onclick="trove()"><i class="fa fa-arrow-left"></i> Trở về quản lý</button>
                                   </form>
                               </div>
                                <div class="pop-category">
                                    <div class="pop-header">
                                        <p>Quản lý danh mục</p>
                                    </div>
                                    <div class="pop-body">
                                        <div>Bạn có muốn thêm danh mục?</div>
                                        <div class="btn-ca">
                                            <button class="submit-ca">Thêm</button>
                                            <button class="close-ca">Trở về</button>
                                        </div>
                                    </div>

                                </div>
                                <div class ="overlay">

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
<script>
    function changesort2(item) {
        let list = item.children;
        if (list[2].checked == false) {
            list[2].checked = true;
            list[0].style.display = "none";
            list[1].style.display = "block";

            item.style.marginTop = "0px";
        } else {
            list[2].checked = false;
            list[1].style.display = "none";
            list[0].style.display = "block";
            item.style.marginTop = "-5px";

        }
    }
    function setOrderBy(){
        if(document.getElementById("checkSort").value == "ASC"){
            document.getElementById("checkSort").value = "DESC";
        }else{
            document.getElementById("checkSort").value = "ASC";
        }

    }

</script>

<script>
    function check(){

        document.getElementById("checkRemove").style.display = "block";

    }
</script>

<script>
    $(function (){
        let type = <%=request.getParameter("type")%>;
        let list =  document.getElementById("typeSelect").children;
        if(type.equals("RegisDate")){
            list[0].prop("selected",true);
        }else if(type.equals("FullName")){
            list[1].prop("selected",true);
        }else{
            list[2].prop("selected",true);
        }

        $('select#typeSelect option[value=<%=request.getParameter("type")%>]').prop('selected', true);
        $('select#typeSelect options[value=<%=request.getParameter("type")%>]).attr('selected',true);
        $('select#typeSelect option[value=<%=request.getParameter("type")%>]').prop('selected', 'selected').change();

        $(document).ready(function() {
            $("select#typeSelect option[value='<%=request.getParameter("type")%>']").prop('selected', true);
        });
    });
</script>

        <script src="js/quanLyDanhMucAdmin.js"></script>