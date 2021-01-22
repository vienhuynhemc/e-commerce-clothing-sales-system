<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.cart.Cart" %>
<%@ page import="beans.encode.ConvertPrice" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% ArrayList<Cart> carts = (ArrayList<Cart>) request.getAttribute("listCart"); %>




<%
    int sum = 0;
    for (Cart c: carts) {

        if(c.getGia_km() > 0){
            sum += c.getGia_km();
        }else{
            sum += c.getGia();
        }

%>

<li>
    <a class="aa-cartbox-img" href=""><img
            src="<%=c.getHinh_sp()%>" alt="img"></a>
    <div class="aa-cartbox-info">
        <h4><a href=""><%=c.getTen_sp()%></a></h4>
        <p><%=c.getSo_luong()%> x

            <%if (c.getGia_km() > 0){%>

            <%=ConvertPrice.convertPrice(c.getGia_km())%>

            <%}else{%>

            <%=ConvertPrice.convertPrice(c.getGia())%>
            <%}%>


            VND</p>
    </div>
    <button class="aa-remove-product" onclick="removeCartHover(this)">
        <span class="fa fa-times"></span>
        <input type="hidden" value="<%=c.getMa_sp()%>" disabled>
        <input type="hidden" value="<%=c.getMa_mau()%>" disabled>
        <input type="hidden" value="<%=c.getMa_size()%>" disabled>
    </button>
</li>

<% } %>
<%--<span class="aa-cartbox-total-title">--%>

<%--    <%--%>
<%--    if(request.getSession().getAttribute("lang") != null && request.getSession().getAttribute("lang") == "english" ){--%>
<%--    %>--%>

<%--    Total price--%>

<%--<%}else{%>--%>
<%--     Tổng tiền--%>

<%--    <%}%>--%>
<%--</span>--%>

<input type="hidden" name="" id="tongtien" value="<%=ConvertPrice.convertPrice(sum)%>">
<input type="hidden" name="" id="soluongsp" value="<%=carts.size()%>">