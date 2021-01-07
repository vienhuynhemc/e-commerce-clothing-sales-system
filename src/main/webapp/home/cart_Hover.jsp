<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.cart.Cart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% ArrayList<Cart> carts = (ArrayList<Cart>) request.getAttribute("listCart"); %>


<% for (Cart c: carts) {

%>

<li>
    <a class="aa-cartbox-img" href=""><img
            src="<%=c.getHinh_sp()%>" alt="img"></a>
    <div class="aa-cartbox-info">
        <h4><a href=""><%=c.getTen_sp()%></a></h4>
        <p><%=c.getSo_luong()%> x <%=c.getGia()%> VND</p>
    </div>
    <a class="aa-remove-product" href=""><span
            class="fa fa-times"></span></a>
</li>

<% } %>