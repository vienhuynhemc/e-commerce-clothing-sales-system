<%@ page import="beans.cart.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.encode.ConvertPrice" %>


<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    response.setCharacterEncoding("UTF-8");

    ArrayList<Cart> carts = (ArrayList<Cart>) request.getAttribute("listProduct");%>


        <div class="danhsachsanpham">

            <%
                int tong_gia = 0;
                for (Cart c: carts) {

                if(c.getGia_km() == 0){
                    tong_gia += (int)c.getGia();
                }else{
                    tong_gia += (int)c.getGia_km();
                }
            %>
             <div class="item">
        <div class="img">
            <img src="<%=c.getHinh_sp()%>" alt="">
        </div>
        <div class="sl">
            <p><%=c.getSo_luong()%></p>
        </div>
        <div class="infor">
            <p><%=c.getTen_sp()%></p>
            <p><%=c.getMau_sp()%> / <%= c.getSize()%></p>
        </div>
        <p class="price">

            <% if(c.getGia_km() != 0){ %>

            <%=ConvertPrice.convertPrice((int)c.getGia_km())%>

            <%}else {%>

            <%=ConvertPrice.convertPrice((int)c.getGia())%>

            <%}%>


            VND</p>
    </div>
            <% }%>
</div>







<div class="magiamgia">
    <div>
        <input type="text" id="ma_gg" placeholder="Mã giảm giá">
        <button type="button" onclick="promoPay()" >Sử dụng</button>
    </div>

    <p>Bạn có mã giảm giá? Vui lòng nhập tại đây</p>
</div>

<div class="tamtinh">
    <div>
        <p>Tạm tính</p>
        <p id="tamtinh"><%= ConvertPrice.convertPrice(tong_gia)%> VND</p>
    </div>
    <div>Phí vận chuyển
        <p>70.000</p>
        <p>VND</p>
    </div>
    <div class="linestatus"></div>
    <div>
        <p>Tổng cộng</p>
        <p id="tongcong"><%=ConvertPrice.convertPrice(tong_gia + 70000)%> VND</p>
    </div>
</div>

<div class="ghichu" id="ghichu_sp">
    <p>TVT Shop sẽ <span class="note">xác nhận</span> đơn hàng bằng <span class="note">email</span> hoặc
        <span class="note">gọi điện</span>. Bạn vui lòng <span class="note">kiểm tra email</span> hoặc
        <span class="note">nghe máy</span>
        sau khi <span class="note">đặt hàng thành công</span>.</p>
</div>

<input type="hidden" name="" id="tongtiensp" value="<%= tong_gia + 70000 %>">
<input type="hidden" name="" id="giohang" value="<%=carts%>">

<%  HttpSession session1 = request.getSession();
        session1.setAttribute("carts",carts);
%>
