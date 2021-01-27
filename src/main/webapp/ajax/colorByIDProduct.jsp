
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.product.Size" %>
<%@ page import="beans.product.ProductColor" %>
<%@ page import="beans.product.Product" %>

<% ArrayList<ProductColor> list = (ArrayList<ProductColor>) request.getAttribute("listColor"); %>


<% int numa = 0;  %>




<% for (ProductColor c: list) {

%>
<%--<a href="#" style="border: none !important; opacity: 1"   onclick="addcolor(this)" >--%>
<%--    <input type="hidden" name="" value="<%=c.getMa_mau()%>">--%>
<%--    <img style="width: 20px;height: 20px;border-radius: 50%;"--%>
<%--    src="<%=c.getLink_hinh()%>" alt="">--%>
<%--</a>--%>
<%--onclick="document.getElementById('color2_<%=numa%>').click()"--%>


<label class="labelcolor" for="color_<%=numa%>" id="color2_<%=numa%>" onclick="addcolor(this)" >
    <input type="radio" name="color" class="inputcolor" id="color_<%=numa%>" value="<%=c.getMa_mau()%>">
    <img class="hinhmau"  src="<%=c.getLink_hinh()%>" alt="">
  </label>
<%numa ++;%>

<%}%>
