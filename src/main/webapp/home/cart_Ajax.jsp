<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.cart.Cart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<% ArrayList<Cart> carts = (ArrayList<Cart>) request.getAttribute("listCart"); %>

<div class="cartleftheader">
    <h3> T<span style="color:#ff7315">V</span>T</h3>
    <h5>|</h5>
    <p>Giỏ hàng của bạn</p>
</div>

<div class="scrollmain">
    <div class="cartleftmain" id="">


        <!-- load danh sách cart vào chỗ này-->

        <% for (Cart c: carts) {

       %>
            <div class="cartleftmainitem">
                <div class="cartleftmainitemleft">
                    <a href="" class="cartleftmainimg"> <img src="<%=c.getHinh_sp()%>" alt=""></a>
                    <a href="">
                        <div class="cartleftmainiteminfor">
                            <p>${cart.ten_sp}</p>
                            <h6>Áo thun | Size : <%=c.getSize()%></h6>
                        </div>
                    </a>
                    <p class="cartleftmainitemcolor"><%=c.getMau_sp()%></p>
                    <div class="cartleftmainitemsl">
                        <p><%=c.getSo_luong()%></p>
                        <div>
                            <button>+</button>
                            <button>-</button>
                        </div>
                    </div>
                    <p class="cartleftmainitemprice"> <%= (int) c.getGia()%> VND</p>
                </div>
                <div class="cartleftmainitemright">
                    <div></div>
                    <div></div>
                </div>
            </div>
        <% } %>




    </div>
</div>

<div class="cartleftfooter">
    <a href="product.html" class="back">
        <i class="fa fa-long-arrow-left"></i> Tiếp tục mua sắm
    </a>
    <div class="footertongtien">
        <p>Tổng tiền sản phẩm:</p>


        <%
            int sum = 0;
            for (Cart c: carts) {
            sum += (int)c.getGia();
        }%>

        <p><%=sum%> VND</p>
    </div>

</div>