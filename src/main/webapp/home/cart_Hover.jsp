<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.cart.Cart" %>
<%@ page import="beans.encode.ConvertPrice" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% ArrayList<Cart> carts = (ArrayList<Cart>) request.getAttribute("listCart"); %>




<%
    int sum = 0;
    for (Cart c: carts) {
    sum += c.getGia();
%>

<li>
    <a class="aa-cartbox-img" href=""><img
            src="<%=c.getHinh_sp()%>" alt="img"></a>
    <div class="aa-cartbox-info">
        <h4><a href=""><%=c.getTen_sp()%></a></h4>
        <p><%=c.getSo_luong()%> x <%=ConvertPrice.convertPrice(c.getGia())%> VND</p>
    </div>
    <a class="aa-remove-product" href=""><span
            class="fa fa-times"></span></a>
</li>

<% } %>
<li>
    <a class="aa-cartbox-img" href=""><img
            src="" alt="img"></a>
    <div class="aa-cartbox-info">
        <h4><a href=""></a></h4>
        <p> x  VND</p>
    </div>
    <a class="aa-remove-product" href=""><span
            class="fa fa-times"></span></a>
</li>
<li>
    <a class="aa-cartbox-img" href=""><img
            src="" alt="img"></a>
    <div class="aa-cartbox-info">
        <h4><a href=""></a></h4>
        <p> x  VND</p>
    </div>
    <a class="aa-remove-product" href=""><span
            class="fa fa-times"></span></a>
</li>
<li>
    <a class="aa-cartbox-img" href=""><img
            src="" alt="img"></a>
    <div class="aa-cartbox-info">
        <h4><a href=""></a></h4>
        <p> x  VND</p>
    </div>
    <a class="aa-remove-product" href=""><span
            class="fa fa-times"></span></a>
</li>

<span class="aa-cartbox-total-title">

    <%
    if(request.getSession().getAttribute("lang") != null && request.getSession().getAttribute("lang") == "english" ){
    %>

    Total price

<%}else{%>
     Tổng tiền

    <%}%>
</span>

<input type="hidden" name="" id="tongtien" value="<%=ConvertPrice.convertPrice(sum)%>">
<input type="hidden" name="" id="soluongsp" value="<%=carts.size()%>">