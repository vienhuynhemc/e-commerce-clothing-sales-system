

<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.product.Size" %>
<%@ page import="beans.product.ProductColor" %>
<%@ page import="beans.product.Product" %>

<% ArrayList<ProductColor> list = (ArrayList<ProductColor>) request.getAttribute("listColor"); %>

<% for (ProductColor c: list) {

%>
<a href="#" style="border: none !important; opacity: 1" id="<%=c.getMa_mau()%>" >
    <img style="width: 20px;height: 20px;border-radius: 50%;"
    src="<%=c.getLink_hinh()%>" alt="">  </a>
<%}%>
