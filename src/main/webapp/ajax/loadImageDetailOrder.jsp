<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.product.ProductImage" %>

<% ArrayList<ProductImage> list = (ArrayList<ProductImage>) request.getAttribute("listI"); %>


<% for ( ProductImage p : list) { %>


<div>
    <div>
        <img src="<%=p.getLink_hinh()%>" alt="">
    </div>
</div>

<%} %>