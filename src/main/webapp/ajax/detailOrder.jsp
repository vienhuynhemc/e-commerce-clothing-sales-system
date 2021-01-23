<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.order.DetailOrder1" %>
<%@ page import="beans.encode.ConvertPrice" %>
<%
    ArrayList<DetailOrder1> list = (ArrayList<DetailOrder1>) request.getAttribute("listO");
    String madh = (String) request.getAttribute("donhang");
%>





<div class="cartleft">
    <div class="cartleftheader">
        <h3> T<span style="color:#ff7315">V</span>T</h3>
        <h5>|</h5>
        <p>Đơn hàng <%=madh%> </p>
    </div>
    <div class="scrollmain">
        <div class="cartleftmain">


            <%
                int soloai = 0;
                int soluong = 0;

                for ( DetailOrder1 order : list ) {

                    soloai ++;
                    soluong += order.getSo_luong_sp();


            %>

            <div class="cartleftmainitem">
                <div class="cartleftmainitemleft">
                    <a href="" class="cartleftmainimg"> <img src="../img/product/pro11.webp" alt=""></a>
                    <a href="">
                        <div class="cartleftmainiteminfor">
                            <p><%=order.getTen_sp()%></p>
                            <h6><%=order.getTen_dm()%> | Size : <%=order.getTen_size()%></h6>
                        </div>
                    </a>
                    <p class="cartleftmainitemcolor"><%=order.getTen_mau()%></p>
                    <div class="cartleftmainitemsl">
                        <p><%=order.getSo_luong_sp()%></p>
                    </div>
                    <p class="cartleftmainitemprice">

                        <% if(order.getGiakm() == 0){%>

                        <%=order.getGia()%>

                        <%}else{%>

                        <%=order.getGiakm()%>

                        <%}%>
                        VND</p>
                </div>
            </div>


            <%}%>



        </div>
    </div>

    <div class="cartleftfooter">
        <a onclick="trovetaikhoan()">
            <i class="fa fa-long-arrow-left"></i> Trở về tài khoản
        </a>
        <div class="footertongtien">
            <p>Tổng tiền sản phẩm:</p>
            <p><%=ConvertPrice.convertPrice(list.get(0).getTong_tien())%> VND</p>
        </div>

    </div>
</div>

<div class="cartright">
    <div class="closecartright" onclick="trovetaikhoan()"><i class="fa fa-power-off"></i></div>
    <h3>Thông tin đơn hàng</h3>
    <div class="pricecr">
        <div class="pricedivright">
            <p>Tổng tiền: </p>
            <p><%=ConvertPrice.convertPrice(list.get(0).getTong_tien())%> VND</p>
        </div>
    </div>
    <div class="linecr"></div>
    <div class="pricecr">
        <div class="pricedivright">
            <p>Số loại:</p>
            <p><%=soloai%></p>
        </div>
        <div class="pricedivright">
            <p>Số lượng</p>
            <p><%=soluong%></p>
        </div>
    </div>
    <div class="linecr"></div>
    <div class="pricecr">
        <div class="pricedivrightinfor">
            <div>
                <i class="fa fa-clock-o"></i>
                <p>Thời gian giao hàng từ 1-5 ngày tùy khu vực</p>
            </div>
            <div>
                <i class="fa fa-truck"></i>
                <p>Free ship cho đơn hàng từ 499k trở lên</p>
            </div>
        </div>
    </div>
    <div class="linecr"></div>
    <div class="note">
        <p>Ghi chú đơn hàng</p>
        <textarea cols="30"
                  rows="10"><%=list.get(0).getGhi_chu()%></textarea>
    </div>
    <a href="informationOrder.html" class="submit">
        Kiểm tra tiến trình giao hàng
    </a>

    <!-- Lam dep -->>
    <div class="box1">
    </div>
    <div class="box2">
        <div></div>
        <div style="background-color: #ff7315;"></div>
        <div></div>
    </div>
</div>