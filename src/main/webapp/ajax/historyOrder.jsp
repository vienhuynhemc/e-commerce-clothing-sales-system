<%@ page import="java.util.Map" %>
<%@ page import="model.language.ChangInfoCustomerLanguageModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.order.Order" %>
<%@ page import="beans.order.DetailOrder" %>
<%@ page import="beans.encode.ConvertPrice" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //  Chuyển về UTF-8
    request.setCharacterEncoding("UTF-8");

    //  Lấy list ngôn ngữ ra
    Map<String, String> lang = (Map<String, String>) session.getAttribute("langList");

    // Riêng khi test, khi mở server thì nó vô thẳng trang này nên là lấy thủ công ra 1 tí
    if (lang == null) {
        lang = ChangInfoCustomerLanguageModel.getInstance().getList("vietnamese");
    }

%>


    <% ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("listOrder");

    int nowPage = (int) request.getAttribute("page");
    int numPage = (int) request.getAttribute("numPage");

    %>




    <div class="historycontent">

        <div class="historyleft">
            <div class="contentheader">
                <p class="ma">Mã đơn hàng</p>
                <p class="soloai">Số loại</p>
                <p class="sosanpham">Số sản phẩm</p>
                <p class="gia">Tổng giá</p>
                <p class="trangthai">Trạng thái</p>
            </div>

            <div class="linehistory"></div>

            <div class="contenthistorymain">
<%--                <div class="historyitem activehistoryitem">--%>
<%--                    <p class="ma">DH402</p>--%>
<%--                    <p class="soloai">5</p>--%>
<%--                    <p class="sosanpham">14</p>--%>
<%--                    <p class="gia">4,359,00 VND</p>--%>
<%--                    <p class="trangthai xuly"><i class="fa fa-circle"></i>Đang xử lý: 3/5</p>--%>
<%--                </div>--%>

                <% for (Order o : list) {

               %>


                <div class="historyitem" id="<%=o.getMa_don_hang()%>" onclick="loaddetail(this)">
                    <input type="hidden" name="" value="<%=o.getTong_tien()%>">
                    <p class="ma"><%=o.getMa_don_hang()%></p>
                    <p class="soloai"><%=o.getListDetail().size()%></p>
                    <p class="sosanpham"><% int sum = 0;
                        for ( DetailOrder d : o.getListDetail()) {
                        sum += d.getSo_luong_san_pham();
                        } %>
                    <%=sum%>
                    </p>
                    <p class="gia"><%=ConvertPrice.convertPrice(o.getTong_tien())%> VND</p>
                    <p class="trangthai"><i class="fa fa-circle"></i>

                        <% if (o.getTrang_thai_van_chuyen() == 1){%>

                        Hoan thanh

                        <%}else{%>

                        Dang van chuyen

                        <%}%>
                    </p>
                </div>

                <%}%>
            </div>

            <div class="footerleft">
                <ul>


                    <%if(nowPage == 1){
                    %>
                    <li><i class="fa fa-angle-double-left"></i></li>
                    <%}else{%>
                    <li value="<%=nowPage-1%>" onclick="loadHistoryByPage(this)"><i class="fa fa-angle-double-left" ></i></li>
                    <%}%>


                    <% for (int i = 1; i <= numPage; i++) {

                        if (i == nowPage){
                    %>
                    <li class="activeli" value="<%=i%>" onclick="loadHistoryByPage(this)"><%=i%></li>
                    <%}else{%>

                    <li class="" value="<%=i%>" onclick="loadHistoryByPage(this)"><%=i%></li>

                   <% }
                    }%>

                    <%if(nowPage == numPage){
                    %>
                    <li><i class="fa fa-angle-double-right"></i></li>
                    <%}else{%>
                    <li value="<%=nowPage+1%>" onclick="loadHistoryByPage(this)"><i class="fa fa-angle-double-right"></i></li>
                    <%}%>

                </ul>
            </div>
        </div>

        <div class="linedoc"></div>

        <div class="historyright">
            <div class="historyrightheader">
                <p>Đơn hàng #DH402</p>
                <p><i class="fa fa-circle"></i>Đang xử lý 3/5</p>
            </div>
            <div class="divhinh">
                <div class="listhinh" id="listhinh">

                    <!--load hình--->


                    <!--load hình--->

                </div>
            </div>
            <span class="fa fa-chevron-left scrollleft" onclick="left()"></span>
            <span class="fa fa-chevron-right scrollright" onclick="right()"></span>

            <div class="tongketright">
<%--                <div>--%>
<%--                    <p>Tổng tiền sản phẩm:</p>--%>
<%--                    <p id="tongtien"></p>--%>
<%--                </div>--%>
<%--                <div>--%>
<%--                    <p>Phí vận chuyển:</p>--%>
<%--                    <p >70,000 VND</p>--%>
<%--                </div>--%>
                <div class="line"></div>
                <div>
                    <p>Tổng tiền:</p>
                    <p id="tongtienthanhtoan"></p>
                </div>
            </div>

            <button class="buttonxemchitiet" onclick="xemchitiet()">Xem chi tiết</button>
        </div>

    </div>

<script>

    function loaddetail(event){

        var ma_don_hang = $(event).attr("id");
        $("#laymadonhang").prop("value",ma_don_hang);

        $.ajax({
            url:'LoadProductImagePayController',
            dataType:'html',
            type:"get",
            data:{
                ma_dh:ma_don_hang
            },
            success:function (data) {
                $("#listhinh").html(data);

                var list = event.children;

                var tien = parseInt($(list[0]).val());

                var convert = tien.toLocaleString("vi-VN");

                $("#tongtienthanhtoan").text(convert + " VND");


            },
            error:function (){
                //alert("loi load lich su don hang");
            }

        });



    }

    function loadDetailByID(){
        var ma_don_hang = $("#laymadonhang").attr("value");

        $.ajax({
            url:'LoadDetailOrderController',
            dataType:'html',
            type:"get",
            data:{
                ma_dh:ma_don_hang
            },
            success:function (data) {
                $('#loadDetailOrder').html(data);
            },
            error:function (){
                //alert("loi load lich su don hang");
            }

        });


    }

</script>

